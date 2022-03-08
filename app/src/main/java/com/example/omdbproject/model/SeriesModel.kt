package com.example.omdbproject.model

import com.google.gson.annotations.SerializedName

data class SeriesModel(
    @SerializedName("Title")
    val title: String?,
    @SerializedName("Actors")
    val actors: String?,
    @SerializedName("imdbRating")
    val imdbRating: String?,
    @SerializedName("Poster")
    val posterURL: String?
)
