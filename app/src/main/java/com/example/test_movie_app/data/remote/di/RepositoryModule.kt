package com.example.test_movie_app.data.remote.dto.di

import com.example.test_movie_app.data.remote.dto.ApiService
import com.example.test_movie_app.data.remote.dto.TvShowsRepositoryImpl
import com.example.test_movie_app.domain.domain.repository.TvShowsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideMoviesRepository(apiService: ApiService):TvShowsRepository= TvShowsRepositoryImpl(apiService)

}