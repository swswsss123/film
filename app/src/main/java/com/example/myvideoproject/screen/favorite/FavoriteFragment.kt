package com.example.myvideoproject.screen.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.example.myvideoproject.MAIN
import com.example.myvideoproject.R
import com.example.myvideoproject.databinding.FragmentFavoriteBinding
import com.example.myvideoproject.databinding.FragmentMainBinding
import com.example.myvideoproject.model.perfectFilmsModel.MovieResult
import com.example.myvideoproject.model.popularMovieModel.HitResult

class FavoriteFragment : Fragment() {

    private var mBinding:FragmentFavoriteBinding ?= null
    private val binding get() = mBinding !!
    lateinit var recyclerView: RecyclerView
    private val adapter by lazy { FavoriteAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentFavoriteBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }
    private fun init(){
        val viewModel = ViewModelProvider(this).get(FavoriteFragmentViewModel::class.java)
        recyclerView = binding.rcMainFavorite
        recyclerView.adapter = adapter
        viewModel.getFavoriteMovies()
        viewModel.myFavoriteList.observe(viewLifecycleOwner){
            adapter.setFavoriteList(it.body()!!.results)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
    companion object{
        // функция для передачи даных между экранами
        fun onClickViewFavorite(model: HitResult){
            val bundle = Bundle()
            bundle.putSerializable("movieFavorite",model)
            MAIN.navController.navigate(R.id.action_favoriteFragment_to_favoriteDetailFragment,bundle)

        }
    }


}
