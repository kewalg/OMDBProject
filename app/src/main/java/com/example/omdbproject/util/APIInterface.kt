package com.example.omdbproject.util

import com.example.omdbproject.model.SeriesModel
import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {

    @GET("?t=Game+Of+Thrones&apikey=809b203b&type=series")
    fun getSeries1Data(): Call<SeriesModel>

    @GET("?t=Friends&apikey=809b203b&type=series")
    fun getSeries2Data(): Call<SeriesModel>

    @GET("?t=True+Detective&apikey=809b203b&type=series")
    fun getSeries3Data(): Call<SeriesModel>
}