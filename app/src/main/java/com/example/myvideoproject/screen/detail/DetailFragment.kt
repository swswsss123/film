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
import com.example.myvideoproject.model.perfectFilmsModel.MovieResult


class DetailFragment : Fragment() {
    private var mBinding: FragmentDetailBinding?= null
    private val binding get() = mBinding !!
    lateinit var currentMovie : MovieResult

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentDetailBinding.inflate(layoutInflater,container,false)
        currentMovie = arguments?.getSerializable("movie") as MovieResult
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }
    fun init(){
        val viewModel = ViewModelProvider(this).get(DetailFragmentViewModel::class.java)
        Glide.with(MAIN)
            .load(BASE_IMG+currentMovie.poster_path)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(binding.imgDetail)
        binding.textDetailTitle.text = currentMovie.title
        binding.textDeteilData.text = currentMovie.release_date
        binding.textDetailDescription.text = currentMovie.overview
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }

}