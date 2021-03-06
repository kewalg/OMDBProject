package com.example.omdbproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.omdbproject.R
import com.example.omdbproject.viewmodel.SeriesViewModel
import kotlinx.android.synthetic.main.fragment_series.*

class SeriesFragment : Fragment() {
    private lateinit var seriesViewModel: SeriesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_series, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        seriesViewModel = ViewModelProvider(this).get(SeriesViewModel::class.java)
        seriesViewModel.getSeriesData()

        navigateToEpisodesList()
        observeLiveData()
    }

    private fun loadImage(url: String?, imageView: ImageView) {
        Glide.with(this).load(url).into(imageView)
    }

    private fun navigateToEpisodesList() {
        val action = SeriesFragmentDirections.actionSeriesFragmentToEpisodesFragment()
        ll1.setOnClickListener {
            action.keyForSeriesName = series1Name.text.toString()
            Navigation.findNavController(it)
                .navigate(action)
        }

        ll2.setOnClickListener {
            action.keyForSeriesName = series2Name.text.toString()
            Navigation.findNavController(it)
                .navigate(action)
        }

        ll3.setOnClickListener {
            action.keyForSeriesName = series3Name.text.toString()
            Navigation.findNavController(it)
                .navigate(action)
        }
    }

    private fun observeLiveData() {
        seriesViewModel.series1LiveData.observe(this, Observer {
            series1Name.text = it.title
            series1Actors.text = it.actors
            series1IMDBRating.text = it.imdbRating
            loadImage(it.posterURL, series1Poster)
        })

        seriesViewModel.series2LiveData.observe(this, Observer {
            series2Name.text = it.title
            series2Actors.text = it.actors
            series2IMDBRating.text = it.imdbRating
            loadImage(it.posterURL, series2Poster)
        })

        seriesViewModel.series3LiveData.observe(this, Observer {
            series3Name.text = it.title
            series3Actors.text = it.actors
            series3IMDBRating.text = it.imdbRating
            loadImage(it.posterURL, series3Poster)
        })
    }
}