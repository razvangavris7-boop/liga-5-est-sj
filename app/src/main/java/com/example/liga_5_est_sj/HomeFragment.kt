package com.example.liga_5_est_sj


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.recyclerview.widget.RecyclerView
import com.example.liga_5_est_sj.databinding.FragmentHomeBinding
import com.example.liga_5_est_sj.databinding.FragmentTeamDetalisBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var binding2: FragmentTeamDetalisBinding

    private lateinit var teamAdapter: TeamAdapter
    private lateinit var teamView: RecyclerView

    private var teamsList = emptyList<Team>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        binding2 = FragmentTeamDetalisBinding.inflate(layoutInflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//        val teamAdapter = TeamAdapter(requireContext(), teamsList)
//
//        val teamView = view.findViewById<ListView>(R.id.team_list_view)

        teamAdapter = TeamAdapter(requireContext(), teamsList)
        teamView = view.findViewById(R.id.team_list_view)

        teamView.adapter = teamAdapter
        teamAdapter.updateTeamLogo(
            listOf(
                TeamHelper.teamIleanda,
                TeamHelper.teamACSTihau,
                TeamHelper.teamAgronovaDragu,
                TeamHelper.teamUnireaCristolt
            )
        )
    }
}
