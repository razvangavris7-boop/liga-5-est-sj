package com.example.liga_5_est_sj


object TeamHelper {

    val teamIleanda = Team(
        1000,
        "FC Benfyka Ileanda",
        "localitatea Ileanda...",
        R.drawable.benfyka,
        teamStadium = listOf(),
        teamPlayers = listOf(
            PlayerHelper.player1Ileanda,
            PlayerHelper.player2Ileanda,
            PlayerHelper.player3Ileanda
        ),
        teamMatches = listOf(1),
        teamPlace = 3,
    )

    val teamACSTihau = Team(
        1001,
        "ACS Tihau",
        "localitatea Ileanda...",
        R.drawable.acs_tihau,
        teamStadium = listOf(),
        teamPlayers = listOf(PlayerHelper.player1Ileanda),
        teamMatches = listOf(1),
        teamPlace = 3,
    )

    val teamAgronovaDragu = Team(
        1002,
        "Agronova Dragu",
        "localitatea Ileanda...",
        R.drawable.agronova_dragu,
        teamStadium = listOf(),
        teamPlayers = listOf(PlayerHelper.player1Ileanda),
        teamMatches = listOf(1),
        teamPlace = 3,
    )

    val teamUnireaCristolt = Team(
        1003,
        "Agronova Dragu",
        "localitatea Ileanda...",
        R.drawable.as_unirea_cristolt,
        teamStadium = listOf(),
        teamPlayers = listOf(PlayerHelper.player1Ileanda),
        teamMatches = listOf(1),
        teamPlace = 3,
    )
}