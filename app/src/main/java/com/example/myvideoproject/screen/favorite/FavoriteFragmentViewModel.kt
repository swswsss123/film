package com.example.myvideoproject.screen.favorite

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.myvideoproject.dao.retrofit.RetrofitRealization
import com.example.myvideoproject.model.popularMovieModel.PopularMovie
import kotlinx.coroutines.launch
import retrofit2.Response

class FavoriteFragmentViewModel(application: Application): AndroidViewModel(application){
    private val realizationFavorite = RetrofitRealization()
    val myFavoriteList:MutableLiveData<Response<PopularMovie>> = MutableLiveData()
    fun getFavoriteMovies(){
        viewModelScope.launch {
            myFavoriteList.value = realizationFavorite.getPopularMovies()
        }
    }
}