package com.example.liga_5_est_sj

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.liga_5_est_sj.databinding.FragmentHomeBinding
import com.example.liga_5_est_sj.databinding.FragmentTeamDetalisBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var binding2: FragmentTeamDetalisBinding

    private var teamsList = listOf<Team>()


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

        val player1Ileanda = Player(
            1,
            "Pocol Andrei",
            "185 cm, 22 ani...",
            7,
            "FC Benfyka Ileanda",
        )

        val teamIleanda = Team(
            1000,
            "FC Benfyka Ileanda",
            "localitatea Ileanda...",
            R.mipmap.logo_aplicatie,
            teamStadium = listOf(R.mipmap.logo_aplicatie),
            teamPlayers = listOf(player1Ileanda),
            teamMatches = listOf(1),
            teamPlace = 3,
        )


            TODO("CREEAZA LISTELE CU TOATE ECHIPELE SI JUCATORII")




        binding2.teamLogoId.setImageResource(teamIleanda.teamLogo)
    }
}
