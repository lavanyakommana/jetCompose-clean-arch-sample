package com.example.test_movie_app.data.remote.dto

import com.example.test_movie_app.data.remote.dto.mappers.toUIModel
import com.example.test_movie_app.domain.domain.model.ShowItem
import com.example.test_movie_app.domain.domain.repository.TvShowsRepository
import javax.inject.Inject

class TvShowsRepositoryImpl @Inject constructor(private val apiService: ApiService)
    :TvShowsRepository{
    override suspend fun getTvShows(): List<ShowItem> {
        return apiService.getTvShows().toUIModel()

    }
}

