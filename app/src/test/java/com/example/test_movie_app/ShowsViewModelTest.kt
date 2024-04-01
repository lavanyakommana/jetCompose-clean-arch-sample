package com.example.test_movie_app

import com.example.test_movie_app.Presentation.viewModels.ShowsViewModel
import com.example.test_movie_app.common.Resource
import com.example.test_movie_app.domain.domain.model.ShowItem
import com.example.test_movie_app.domain.domain.useCases.GetShowsUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito


@OptIn(ExperimentalCoroutinesApi::class)
class ShowsViewModelTest {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()
    private lateinit var showsViewModel: ShowsViewModel
    private val showsUseCase: GetShowsUseCase = Mockito.mock()
    private val showsList: List<ShowItem>? = Mockito.mock()

    @Before
    fun setUp() {
        showsViewModel = ShowsViewModel(showsUseCase)
    }

    @Test
    fun validate_collecting_response_data() {
        mainCoroutineRule.runCatching {
            Mockito.`when`(showsUseCase.invoke())
                .thenReturn(flow { emit(Resource.Success(showsList)) })
            Assert.assertEquals(showsList,
                showsViewModel.response.value.data)
        }
    }

    @Test
    fun validate_collecting_api_error() {
        mainCoroutineRule.runCatching {
            Mockito.`when`(showsUseCase.invoke())
                .thenReturn(flow { emit(Resource.Error("not able to process request")) })
            Assert.assertEquals("not able to process request",
                showsViewModel.response.value.error)
        }
    }

    @Test
    fun validate_progressBar_visibility() {
        mainCoroutineRule.runCatching {
            Mockito.`when`(showsUseCase.invoke())
                .thenReturn(flow { emit(Resource.Loading()) })
            Assert.assertEquals(true, showsViewModel.response.value.isLoading)
        }
    }
}