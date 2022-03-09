package com.example.omdbproject.util

import com.example.omdbproject.model.SeriesModel
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {

    @GET("?t=Game+Of+Thrones&apikey=809b203b&type=series")
    fun getSeries1Data(): Call<SeriesModel>

    @GET("?t=Friends&apikey=809b203b&type=series")
    fun getSeries2Data(): Call<SeriesModel>

    @GET("?t=Peaky+Blinders&apikey=809b203b&type=series")
    fun getSeries3Data(): Call<SeriesModel>

    @GET("?t=Game+Of+Thrones&season=1&apikey=809b203b&type=episodes")
    fun getEpisodesList(): Call<JsonObject>
}