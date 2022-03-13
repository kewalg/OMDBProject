package com.example.omdbproject.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.omdbproject.R
import com.example.omdbproject.util.EpisodesListAdapter
import com.example.omdbproject.viewmodel.EpisodesViewModel
import kotlinx.android.synthetic.main.fragment_episodes.*

class EpisodesFragment : Fragment() {

    private lateinit var episodesViewModel: EpisodesViewModel
    private var episodeAdapter = EpisodesListAdapter(arrayListOf())
    private var stringForSeriesName: String = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_episodes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        if (arguments != null) {
            arguments?.let {
                stringForSeriesName = EpisodesFragmentArgs.fromBundle(it).keyForSeriesName
            }
        }

        episodeRecyclerView.apply {
            adapter = episodeAdapter
            layoutManager = LinearLayoutManager(context)
        }

        episodesViewModel = ViewModelProvider(this).get(EpisodesViewModel::class.java)
        episodesViewModel.getEpisodesData(stringForSeriesName)

        observeEpisodeLiveData()
    }

    private fun observeEpisodeLiveData() {
        episodesViewModel.episodesLiveData.observe(this, Observer {
            episodeAdapter.convertResponseForList(it)
        })
    }
}