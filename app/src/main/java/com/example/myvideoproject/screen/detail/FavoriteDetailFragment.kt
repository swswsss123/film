package com.example.myvideoproject.screen.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.myvideoproject.BASE_IMG
import com.example.myvideoproject.MAIN
import com.example.myvideoproject.R
import com.example.myvideoproject.databinding.FragmentDetailBinding
import com.example.myvideoproject.databinding.FragmentFavoriteBinding
import com.example.myvideoproject.databinding.FragmentFavoriteDetailBinding
import com.example.myvideoproject.model.perfectFilmsModel.MovieResult
import com.example.myvideoproject.model.popularMovieModel.HitResult

class FavoriteDetailFragment : Fragment() {
    private var mBinding: FragmentFavoriteDetailBinding?= null
    private val binding get() = mBinding !!
    lateinit var currentMovie2 : HitResult

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentFavoriteDetailBinding.inflate(layoutInflater,container,false)
        currentMovie2 = arguments?.getSerializable("movieFavorite") as HitResult
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }
    fun init(){
        val viewModel = ViewModelProvider(this).get(DetailFragmentViewModel::class.java)
        Glide.with(MAIN)
            .load(BASE_IMG +currentMovie2.poster_path)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(binding.imgDetail1)
        binding.textDetailTitle1.text = currentMovie2.title
        binding.textDeteilData1.text = currentMovie2.release_date
        binding.textDetailDescription1.text = currentMovie2.overview
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }

}