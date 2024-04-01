package com.example.test_movie_app.data.remote.dto.mappers

import com.example.test_movie_app.domain.domain.model.ShowItem
import com.example.test_movie_app.domain.domain.model.ShowsResponseItem

fun List<ShowsResponseItem>.toUIModel() : List<ShowItem>{
    return map{
        ShowItem(
            imagePath = it.image.original,
            title = it.name
        )
    }
}