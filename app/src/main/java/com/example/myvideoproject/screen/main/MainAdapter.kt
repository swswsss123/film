package com.example.myvideoproject.screen.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myvideoproject.BASE_IMG
import com.example.myvideoproject.MAIN
import com.example.myvideoproject.R
import com.example.myvideoproject.model.perfectFilmsModel.MovieResult
import kotlinx.android.synthetic.main.item_layout.view.*

class MainAdapter:RecyclerView.Adapter<MainAdapter.MainHolder>() {

    private var listMovies = emptyList<MovieResult>()
    class MainHolder(view:View):RecyclerView.ViewHolder(view)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MainHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return MainHolder(view)
    }

    override fun onBindViewHolder(holder: MainAdapter.MainHolder, position: Int) {
        holder.itemView.textTitle.text = listMovies[position].title
        holder.itemView.textData.text = listMovies[position].release_date

        Glide.with(MAIN)
            .load(BASE_IMG + listMovies[position].poster_path)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.itemView.item_img)
    }

    override fun getItemCount(): Int {
        return listMovies.size
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setList(list:List<MovieResult>){
        listMovies = list
        notifyDataSetChanged()
    }
    // работа с адаптером,функция отрабатывает нажатие на картинку ,и днлает перехот на DetailFragment
    override fun onViewAttachedToWindow(holder: MainHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener{
            MainFragment.onClickView(listMovies[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: MainHolder) {
        holder.itemView.setOnClickListener(null)

    }
}