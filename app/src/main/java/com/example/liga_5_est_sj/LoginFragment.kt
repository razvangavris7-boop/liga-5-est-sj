package com.example.liga_5_est_sj

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import com.example.liga_5_est_sj.AccountHelper.validatePass

import com.example.liga_5_est_sj.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var firebaseService: FirebaseService

    private  lateinit var firebaseAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        firebaseAuth = FirebaseAuth.getInstance()

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firebaseService = FirebaseService(requireContext())

        binding.textviewRegister.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        
        binding.buttonSignInGoogle.setOnClickListener {
            startSignIn()
        }
        
        binding.buttonLogin.setOnClickListener {
            if (!loginHandler(binding.editTextEmail.text.toString(), binding.editTextPassword.text.toString())) {
                Toast.makeText(context, "All fields are required!", Toast.LENGTH_SHORT).show()
            }
            if (validatePass(context, binding.editTextPassword.text.toString())) {

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    
    private fun loginHandler(email: String, password: String) : Boolean {
        return !(email.isEmpty() || password.isEmpty())
    }

    private fun startSignIn() {
        val signInIntent = firebaseService.getGoogleSignInClient().signInIntent
        signInLauncher.launch(signInIntent)
    }

    private val signInLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            firebaseService.handleGoogleSignInResult(result.data,
                onSuccess = { user ->
                    Log.d("SignIn", "User: ${user.email}")
                    FirebaseFirestore.getInstance().collection("users")
                        .document(user.uid)
                        .get()
                        .addOnSuccessListener { document ->
                            if (document.exists()) {
                                startActivity(Intent(requireContext(), MainActivity::class.java))
                                requireActivity().finish()
                            } else {
                                firebaseService.showUsernameDialog(requireContext()) { username ->
                                    val currentUser = FirebaseAuth.getInstance().currentUser
                                    if (currentUser != null) {
                                        firebaseService.createOrUpdateUserInFirestore(
                                            currentUser,
                                            username,
                                            onSuccess = {
                                                startActivity(
                                                    Intent(
                                                        requireContext(),
                                                        MainActivity::class.java
                                                    )
                                                )
                                                requireActivity().finish()
                                            },
                                            onFailure = { error ->
                                                Toast.makeText(
                                                    requireContext(),
                                                    error,
                                                    Toast.LENGTH_LONG
                                                ).show()
                                            }
                                        )
                                    }
                                }
                            }
                        }

                    firebaseService.generateSessionToken()
                },
                onError = { error ->
                    Log.e("SignIn", "Error: ${error.message}")
                }
            )
        }
}