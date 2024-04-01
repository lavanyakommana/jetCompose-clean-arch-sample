package com.example.test_movie_app

import com.example.test_movie_app.data.remote.dto.ApiService
import com.example.test_movie_app.data.remote.dto.ShowsResponse
import com.example.test_movie_app.data.remote.dto.TvShowsRepositoryImpl
import com.example.test_movie_app.data.remote.dto.mappers.toUIModel
import com.example.test_movie_app.domain.domain.repository.TvShowsRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class RepositoryTest {
    @Mock
    private lateinit var apiService: ApiService

    private lateinit var repository: TvShowsRepository
    private lateinit var showsRepsonse:ShowsResponse
    @Before
    fun setUp(){
        MockitoAnnotations.openMocks(this)
        repository = TvShowsRepositoryImpl(apiService)
        getMockData()
    }
    @Test
    fun validate_success_from_api(): Unit = runBlocking{
        Mockito.`when`(apiService.getTvShows()).thenReturn(
            showsRepsonse
        )
        val result = repository.getTvShows()
        Assert.assertEquals(showsRepsonse.toUIModel(),result)
    }
    fun getMockData(){
        showsRepsonse = ShowsResponse()
        showsRepsonse.addAll(listOf())
    }
}