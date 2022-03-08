package com.example.omdbproject.util

import com.example.omdbproject.model.SeriesModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIService {

    companion object {
        private const val BASE_URL = "https://www.omdbapi.com/"
    }

    private val seriesAPICall =
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIInterface::class.java)

    fun getSeries1(): Call<SeriesModel> {
        return seriesAPICall.getSeries1Data()
    }

    fun getSeries2(): Call<SeriesModel> {
        return seriesAPICall.getSeries2Data()
    }

    fun getSeries3(): Call<SeriesModel> {
        return seriesAPICall.getSeries3Data()
    }
}