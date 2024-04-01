package com.example.test_movie_app.domain.domain.useCases

import com.example.test_movie_app.common.Resource
import com.example.test_movie_app.domain.domain.model.ShowItem
import com.example.test_movie_app.domain.domain.repository.TvShowsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetShowsUseCase @Inject constructor(val repository: TvShowsRepository) {
     operator fun invoke(): Flow<Resource<List<ShowItem>>> = flow {
          emit(Resource.Loading())
          try {
               emit(Resource.Success(data = repository.getTvShows()))
          } catch (e : Exception) {
               emit(Resource.Error(message = e.message.toString()))
          }
     }
}