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

    private lateinit var entireEpisodePojo: EpisodesDataModel

    fun convertResponseForList(response: EpisodesDataModel) {
        val gson = Gson()
        val responseToJsonElement = gson.fromJson(gson.toJson(response), JsonElement::class.java)
        entireEpisodePojo = gson.fromJson(responseToJsonElement, EpisodesDataModel::class.java)
        updateEpisodeList(entireEpisodePojo)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateEpisodeList(entireEpisodePojo: EpisodesDataModel) {
        episodesList.clear()
        val newEpisodesList = entireEpisodePojo.episodes!!
        episodesList.addAll(newEpisodesList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodesDataViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_episodes, parent, false)
        return EpisodesDataViewHolder(view)
    }

    override fun onBindViewHolder(holder: EpisodesDataViewHolder, position: Int) {
        holder.view.seasonNo.text = "Season No: " + entireEpisodePojo.Season
        holder.view.episodeTitle.text = "Episode Title: " + episodesList[position].Title
        holder.view.episodeNo.text = "Episode No: " + episodesList[position].Episode
        holder.view.episodeIMDBRating.text = "IMDBRating: " + episodesList[position].imdbRating
    }

    override fun getItemCount() = episodesList.size

    class EpisodesDataViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    }
}