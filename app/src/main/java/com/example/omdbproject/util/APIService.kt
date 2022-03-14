package com.example.omdbproject.util

import com.example.omdbproject.model.EpisodesDataModel
import com.example.omdbproject.model.SeriesModel
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class APIService {

    companion object {
        private const val BASE_URL = "https://www.omdbapi.com/"
    }

    private val seriesAPICall =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(APIInterface::class.java)

    fun getSeries1(): Observable<SeriesModel> {
        return seriesAPICall.getSeries1Data()
    }

    fun getSeries2(): Observable<SeriesModel> {
        return seriesAPICall.getSeries2Data()
    }

    fun getSeries3(): Observable<SeriesModel> {
        return seriesAPICall.getSeries3Data()
    }

    fun getEpisodeList(episodeForSeries: String): Single<EpisodesDataModel> {
        when (episodeForSeries) {
            "Game of Thrones" -> return seriesAPICall.getGOTEpisodesList()
            "Friends" -> return seriesAPICall.getFriendsEpisodesList()
            "Peaky Blinders" -> return seriesAPICall.getPeakyBlindersEpisodesList()
        }
        return seriesAPICall.getBlankEpisodesList()
    }
}