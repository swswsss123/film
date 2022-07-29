package com.example.myvideoproject.dao.retrofit

import com.example.myvideoproject.model.perfectFilmsModel.Movie
import com.example.myvideoproject.model.popularMovieModel.PopularMovie
import retrofit2.Response

class RetrofitRealization {

    suspend fun getMovies():Response<Movie>{
        return RetrofitInstance.api.allMovies()
    }
    suspend fun getPopularMovies():Response<PopularMovie>{
        return RetrofitInstance.api.allPopularMovies()
    }
}