package com.example.myvideoproject.screen.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.myvideoproject.MAIN
import com.example.myvideoproject.R
import com.example.myvideoproject.databinding.FragmentMainBinding
import com.example.myvideoproject.model.perfectFilmsModel.MovieResult

class MainFragment : Fragment() {
    private var mBinding:FragmentMainBinding ?= null
    private val binding get() = mBinding !!
    lateinit var recyclerView: RecyclerView
    private val adapter by lazy { MainAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding =FragmentMainBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }
    private fun init(){
        val viewModel = ViewModelProvider(this).get(MainFragmentViewModel::class.java)
        recyclerView = binding.rcMain
        recyclerView.adapter = adapter

        viewModel.getMoviesRetrofit()
        viewModel.myMovieList.observe(viewLifecycleOwner){
            adapter.setList(it.body()!!.results)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
    companion object{
        // функция для передачи даных между экранами
        fun onClickView(model: MovieResult){
            val bundle = Bundle()
            bundle.putSerializable("movie",model)
            MAIN.navController.navigate(R.id.action_mainFragment_to_detailFragment,bundle)

        }
    }

}