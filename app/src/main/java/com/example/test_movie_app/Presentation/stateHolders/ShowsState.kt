package com.example.test_movie_app.Presentation.viewModels.stateHolders

import com.example.test_movie_app.domain.domain.model.ShowItem

data class ShowsState(
    val isLoading:Boolean = false,
    val data : List<ShowItem>? = null,
    val error: String = ""
)