package com.example.omdbproject.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.omdbproject.model.EpisodesDataModel
import com.example.omdbproject.util.APIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class EpisodesViewModel : ViewModel() {

    val episodesLiveData = MutableLiveData<EpisodesDataModel>()
    val episodesDisposable = CompositeDisposable()
    private val serviceInstance = APIService()

    fun getEpisodesData(episodesForSeries: String) {
        when (episodesForSeries) {
            "Game of Thrones" -> episodesDisposable.add(
                serviceInstance.getGOTEpisodesList().subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(object : DisposableSingleObserver<EpisodesDataModel>() {
                        override fun onSuccess(t: EpisodesDataModel) {
                            episodesLiveData.value = t
                        }

                        override fun onError(e: Throwable) {
                            Log.d("ERROR---------->", e.toString())
                        }
                    })
            )
            "Friends" -> episodesDisposable.add(
                serviceInstance.getFriendsEpisodesList().subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(object : DisposableSingleObserver<EpisodesDataModel>() {
                        override fun onSuccess(t: EpisodesDataModel) {
                            episodesLiveData.value = t
                        }

                        override fun onError(e: Throwable) {
                            Log.d("ERROR---------->", e.toString())
                        }
                    })
            )
            "Peaky Blinders" -> episodesDisposable.add(
                serviceInstance.getPeakyBlindersEpisodesList().subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(object : DisposableSingleObserver<EpisodesDataModel>() {
                        override fun onSuccess(t: EpisodesDataModel) {
                            episodesLiveData.value = t
                        }

                        override fun onError(e: Throwable) {
                            Log.d("ERROR---------->", e.toString())
                        }
                    })
            )
        }
    }
}