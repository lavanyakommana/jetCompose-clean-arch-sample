package com.example.test_movie_app.data.remote.dto

import retrofit2.http.GET

interface ApiService {
    @GET(Constants.END_POINT)
    suspend fun getTvShows():ShowsResponse
}