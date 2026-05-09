package com.example.liga_5_est_sj

import android.annotation.SuppressLint
import android.content.Context
import android.database.DataSetObserver
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Adapter
import android.widget.ListAdapter

class PlayerAdapter (
    var context: Context,
    var teamList: List<Player>
    ) : Adapter, ListAdapter {

        @SuppressLint("ViewHolder", "MissingInflatedId")
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val inflater: LayoutInflater = LayoutInflater.from(context)
            val view: View = inflater.inflate(R.layout.player_item_list, null)
            val logo: TextView = view.findViewById(R.id.player_name_id)

            logo.text = teamList[position].playerName

            return view
        }

        override fun areAllItemsEnabled(): Boolean {
            TODO("Not yet implemented")
        }

        override fun isEnabled(p0: Int): Boolean {
            TODO("Not yet implemented")
        }

        override fun getCount(): Int = teamList.size

        override fun getItem(position: Int): Any {
            return position
        }

        override fun getItemId(p0: Int): Long {
            TODO("Not yet implemented")
        }

        override fun getItemViewType(p0: Int): Int {
            TODO("Not yet implemented")
        }

        override fun getView(
            p0: Int,
            p1: View?,
            p2: ViewGroup?
        ): View? {
            TODO("Not yet implemented")
        }

        override fun getViewTypeCount(): Int {
            TODO("Not yet implemented")
        }

        override fun hasStableIds(): Boolean {
            TODO("Not yet implemented")
        }

        override fun isEmpty(): Boolean {
            TODO("Not yet implemented")
        }

        override fun registerDataSetObserver(p0: DataSetObserver?) {
            TODO("Not yet implemented")
        }

        override fun unregisterDataSetObserver(p0: DataSetObserver?) {
            TODO("Not yet implemented")
        }


    }