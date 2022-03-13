package com.example.omdbproject.util

import com.example.omdbproject.model.EpisodesDataModel
import com.example.omdbproject.model.SeriesModel
import io.reactivex.Single
import retrofit2.http.GET

interface APIInterface {

    @GET("?t=Game+Of+Thrones&apikey=809b203b&type=series")
    fun getSeries1Data(): Single<SeriesModel>

    @GET("?t=Friends&apikey=809b203b&type=series")
    fun getSeries2Data(): Single<SeriesModel>

    @GET("?t=Peaky+Blinders&apikey=809b203b&type=series")
    fun getSeries3Data(): Single<SeriesModel>

    @GET("?t=Game+Of+Thrones&season=1&apikey=809b203b&type=episodes")
    fun getGOTEpisodesList(): Single<EpisodesDataModel>

    @GET("?t=Friends&season=1&apikey=809b203b&type=episodes")
    fun getFriendsEpisodesList(): Single<EpisodesDataModel>

    @GET("?t=Peaky+Blinders&season=1&apikey=809b203b&type=episodes")
    fun getPeakyBlindersEpisodesList(): Single<EpisodesDataModel>

    @GET("?t=")
    fun getBlankEpisodesList(): Single<EpisodesDataModel>
}