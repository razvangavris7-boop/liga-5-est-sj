package com.example.liga_5_est_sj


data class Team(
    val teamId: Int,
    val teamName: String,
    val teamDescription: String,
    val teamLogo: Int,
    val teamStadium: List<Int>,
    val teamPlayers: List<Player>,
    val teamMatches: List<Int>,
    val teamPlace: Int,
)
