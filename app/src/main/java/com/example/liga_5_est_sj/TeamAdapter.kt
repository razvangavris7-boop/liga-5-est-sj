package com.example.liga_5_est_sj

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class TeamAdapter(
    var context: Context,
    var teamList: List<Team>
) : RecyclerView.Adapter<TeamAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val logo: ImageView = itemView.findViewById(R.id.team_logo_id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.fragment_team_detalis, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.logo.setImageResource(teamList[position].teamLogo)
    }

    override fun getItemCount(): Int = teamList.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateTeamLogo(newList: List<Team>) {
        teamList = newList
        notifyDataSetChanged()
    }
}