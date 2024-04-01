package com.example.test_movie_app.domain.domain.repository

import com.example.test_movie_app.domain.domain.model.ShowItem

interface TvShowsRepository {
    suspend fun getTvShows(): List<ShowItem>
}
