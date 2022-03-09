package com.example.omdbproject.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.omdbproject.model.SeriesModel
import com.example.omdbproject.util.APIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SeriesViewModel : ViewModel() {

    private val seriesAPIInstance = APIService()
    val series1LiveData = MutableLiveData<SeriesModel>()
    val series2LiveData = MutableLiveData<SeriesModel>()
    val series3LiveData = MutableLiveData<SeriesModel>()


    fun getDataForViewModel() {
        val getSeries1Data = seriesAPIInstance.getSeries1()
        val getSeries2Data = seriesAPIInstance.getSeries2()
        val getSeries3Data = seriesAPIInstance.getSeries3()
        getSeries1Data.enqueue(object : Callback<SeriesModel> {
            override fun onResponse(call: Call<SeriesModel>, response: Response<SeriesModel>) {
                series1LiveData.value = response.body()
            }

            override fun onFailure(call: Call<SeriesModel>, t: Throwable) {
                Log.d("Error--->", t.toString())
            }
        })

        getSeries2Data.enqueue(object : Callback<SeriesModel> {
            override fun onResponse(
                call: Call<SeriesModel>,
                response: Response<SeriesModel>
            ) {
                series2LiveData.value = response.body()
            }

            override fun onFailure(call: Call<SeriesModel>, t: Throwable) {
                Log.d("Error--->", t.toString())
            }
        })

        getSeries3Data.enqueue(object : Callback<SeriesModel> {
            override fun onResponse(
                call: Call<SeriesModel>,
                response: Response<SeriesModel>
            ) {
                series3LiveData.value = response.body()
            }

            override fun onFailure(call: Call<SeriesModel>, t: Throwable) {
                Log.d("Error--->", t.toString())
            }
        })
    }
}