package com.example.test_movie_app.Presentation.viewModels
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test_movie_app.Presentation.viewModels.stateHolders.ShowsState
import com.example.test_movie_app.common.Resource
import com.example.test_movie_app.domain.domain.useCases.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShowsViewModel @Inject constructor(val useCase: GetMoviesUseCase):ViewModel(){
    //private var _response= MutableLiveData<List<ShowsResponseItem>>()
    private var _response = mutableStateOf(ShowsState())
    val response:  State<ShowsState>
        get()= _response
    init {
        getAllTvShows()
    }
    private fun getAllTvShows(){
        viewModelScope.launch {
            useCase().collect {
                when (it) {
                    is Resource.Loading -> {
                        _response.value = ShowsState(isLoading = true)
                    }

                    is Resource.Success -> {
                        _response.value = ShowsState(data = it.data)
                    }

                    is Resource.Error -> {
                        _response.value =
                            ShowsState(error = it.message.toString())
                    }

                }
            }

        }
        }
    }