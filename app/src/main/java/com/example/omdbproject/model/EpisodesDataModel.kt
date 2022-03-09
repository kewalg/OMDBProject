package com.example.omdbproject.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EpisodesDataModel(
    val Response: String,
    val Season: String,
    val Title: String,
    val totalSeasons: String,
    @SerializedName("Episodes")
    var episodes: List<EpisodesList>? = null
) : Parcelable {
    @Parcelize
    data class EpisodesList(
        val Episode: String,
        val Released: String,
        val Title: String,
        val imdbID: String,
        val imdbRating: String
    ) : Parcelable
}