package com.example.myvideoproject.screen.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myvideoproject.MAIN
import com.example.myvideoproject.R
import com.example.myvideoproject.databinding.FragmentMainBinding
import com.example.myvideoproject.databinding.FragmentStartBinding


class StartFragment : Fragment() {

    private var mBinding: FragmentStartBinding?= null
    private val binding get() = mBinding !!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentStartBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }
    fun init(){
            binding.imgPopular.setOnClickListener {
                MAIN.navController.navigate(R.id.action_startFragment_to_mainFragment)
            }
            binding.buttonFavorite.setOnClickListener {
                MAIN.navController.navigate(R.id.action_startFragment_to_favoriteFragment)
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }

}