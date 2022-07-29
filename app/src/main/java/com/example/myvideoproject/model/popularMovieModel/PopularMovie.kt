package com.example.myvideoproject.model.popularMovieModel

data class PopularMovie(
    val page: Int,
    val results: List<HitResult>,
    val total_pages: Int,
    val total_results: Int
)