package com.example.test_movie_app

import com.example.test_movie_app.domain.domain.model.ShowItem
import com.example.test_movie_app.domain.domain.repository.TvShowsRepository
import com.example.test_movie_app.domain.domain.useCases.GetShowsUseCase
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class GetShowsUseCasseTest {
    private lateinit var repository: TvShowsRepository
    private lateinit var getMovieUseCase: GetShowsUseCase
    private val showsList = Mockito.mock<List<ShowItem>>()

    @Before
    fun setUp() {
        repository = Mockito.mock()
        getMovieUseCase = GetShowsUseCase(repository)
    }

    @Test
    fun validate_emit_shows_api_response_success() = runTest {
        Mockito.`when`(repository.getTvShows()).thenReturn(
            showsList
        )
        getMovieUseCase.invoke().onEach {
            Assert.assertEquals(showsList, it.data)
        }
    }

    @Test
    fun validate_emit_shows_api_response_failure() = runTest {
        Mockito.`when`(repository.getTvShows()).thenThrow(
            RuntimeException("something went wrong")
        )
        getMovieUseCase.invoke().onEach {
            Assert.assertEquals("something went wrong",it)
        }
    }
}
