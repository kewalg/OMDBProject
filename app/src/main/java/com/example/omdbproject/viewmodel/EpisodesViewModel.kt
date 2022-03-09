package com.example.omdbproject.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.omdbproject.model.EpisodesDataModel
import com.example.omdbproject.util.APIService
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EpisodesViewModel : ViewModel() {

    val episodesLiveData = MutableLiveData<EpisodesDataModel>()
    private val serviceInstance = APIService()

    fun getEpisodeData() {
        serviceInstance.getEpisodesList().enqueue(object : Callback<EpisodesDataModel> {
            override fun onResponse(
                call: Call<EpisodesDataModel>,
                response: Response<EpisodesDataModel>
            ) {
                episodesLiveData.value = response.body()
            }

            override fun onFailure(call: Call<EpisodesDataModel>, t: Throwable) {
                Log.d("Error-------)", t.toString())
            }
        })
    }
}