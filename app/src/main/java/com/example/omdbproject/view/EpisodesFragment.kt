package com.example.omdbproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_episodes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        episodeRecyclerView.apply {
            adapter = episodeAdapter
            layoutManager = LinearLayoutManager(context)
        }

        episodesViewModel = ViewModelProvider(this).get(EpisodesViewModel::class.java)
        episodesViewModel.getEpisodeData()

        observeEpisodeLiveData()
    }

    fun observeEpisodeLiveData() {
        episodesViewModel.episodesLiveData.observe(this, Observer {
            episodeAdapter.convertResponseForList(it)
        })
    }
}