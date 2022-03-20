package com.example.omdbproject.util

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.omdbproject.R
import com.example.omdbproject.model.EpisodesDataModel
import com.google.gson.Gson
import com.google.gson.JsonElement
import kotlinx.android.synthetic.main.item_episodes.view.*

class EpisodesListAdapter(val episodesList: ArrayList<EpisodesDataModel.EpisodesList>) :
    RecyclerView.Adapter<EpisodesListAdapter.EpisodesDataViewHolder>() {

    private lateinit var response: EpisodesDataModel

    @SuppressLint("NotifyDataSetChanged")
    fun updateEpisodeList(responseObject: EpisodesDataModel) {
        response = responseObject
        val responseList = response.episodes
        episodesList.clear()
        episodesList.addAll(responseList!!)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodesDataViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_episodes, parent, false)
        return EpisodesDataViewHolder(view)
    }

    override fun onBindViewHolder(holder: EpisodesDataViewHolder, position: Int) {
        holder.view.seasonNo.text = "Season No: " + response.Season
        holder.view.episodeTitle.text = "Episode Title: " + episodesList[position].Title
        holder.view.episodeNo.text = "Episode No: " + episodesList[position].Episode
        holder.view.episodeIMDBRating.text = "IMDBRating: " + episodesList[position].imdbRating
    }

    override fun getItemCount() = episodesList.size

    class EpisodesDataViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}