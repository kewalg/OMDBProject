package com.example.omdbproject.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.omdbproject.model.SeriesModel
import com.example.omdbproject.util.APIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class SeriesViewModel : ViewModel() {

    private val seriesAPIInstance = APIService()
    val series1LiveData = MutableLiveData<SeriesModel>()
    val series2LiveData = MutableLiveData<SeriesModel>()
    val series3LiveData = MutableLiveData<SeriesModel>()

    private val series1Disposable = CompositeDisposable()
    private val series2Disposable = CompositeDisposable()
    private val series3Disposable = CompositeDisposable()

    fun getDataForViewModelByRxJava() {
        series1Disposable.add(
            seriesAPIInstance.getSeries1().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<SeriesModel>() {
                    override fun onSuccess(response: SeriesModel) {
                        series1LiveData.value = response
                    }

                    override fun onError(e: Throwable) {
                        Log.d("Error ------>", e.toString())
                    }
                })
        )

        series2Disposable.add(
            seriesAPIInstance.getSeries2().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<SeriesModel>() {
                    override fun onSuccess(response: SeriesModel) {
                        series2LiveData.value = response
                    }

                    override fun onError(e: Throwable) {
                        Log.d("Error ------>", e.toString())
                    }
                })
        )

        series3Disposable.add(
            seriesAPIInstance.getSeries3().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<SeriesModel>() {
                    override fun onSuccess(response: SeriesModel) {
                        series3LiveData.value = response
                    }

                    override fun onError(e: Throwable) {
                        Log.d("Error ------>", e.toString())
                    }
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        series1Disposable.clear()
        series2Disposable.clear()
        series3Disposable.clear()
    }
}