package com.example.myvideoproject.model.perfectFilmsModel

data class Movie(
    val page: Int,
    val results: List<MovieResult>,
    val total_pages: Int,
    val total_results: Int
)