package com.example.omdbproject.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.omdbproject.model.SeriesModel
import com.example.omdbproject.util.APIService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*

class SeriesViewModel : ViewModel() {

    private val seriesAPIInstance = APIService()
    val series1LiveData = MutableLiveData<SeriesModel>()
    val series2LiveData = MutableLiveData<SeriesModel>()
    val series3LiveData = MutableLiveData<SeriesModel>()

    @SuppressLint("CheckResult")
    fun getSeriesData() {
        val requests = ArrayList<Observable<SeriesModel>>()
        requests.add(seriesAPIInstance.getSeries1())
        requests.add(seriesAPIInstance.getSeries2())
        requests.add(seriesAPIInstance.getSeries3())

        Observable.zip(requests) { objects ->
            val responses = ArrayList<SeriesModel>()
            for (o in objects) {
                responses.add(o as SeriesModel)
            }
            responses
        }.subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({ dataResponses ->
                for (i in dataResponses) {
                    when (i.title) {
                        "Game of Thrones" -> series1LiveData.value = dataResponses[0]
                        "Friends" -> series2LiveData.value = dataResponses[1]
                        "Peaky Blinders" -> series3LiveData.value = dataResponses[2]
                    }
                }
            }
            ) { e -> Log.e("onSubscribe", "Throwable: $e") }
    }
}