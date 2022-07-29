package com.example.myvideoproject.screen.favorite

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myvideoproject.BASE_IMG
import com.example.myvideoproject.MAIN
import com.example.myvideoproject.R
import com.example.myvideoproject.model.popularMovieModel.HitResult
import kotlinx.android.synthetic.main.item_layout.view.*


class FavoriteAdapter:RecyclerView.Adapter<FavoriteAdapter.HolderFaforite>() {

    private var listFavorite = emptyList<HitResult>()
    class HolderFaforite(view:View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderFaforite {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return HolderFaforite(view)
    }

    override fun onBindViewHolder(holder: HolderFaforite, position: Int) {
        holder.itemView.textTitle.text = listFavorite[position].title
        holder.itemView.textData.text = listFavorite[position].release_date

        Glide.with(MAIN)
            .load(BASE_IMG+listFavorite[position].poster_path)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.itemView.item_img)
    }

    override fun getItemCount(): Int {
        return listFavorite.size
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setFavoriteList(list: List<HitResult>){
        listFavorite = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: HolderFaforite) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener{
            FavoriteFragment.onClickViewFavorite(listFavorite[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: HolderFaforite) {
        holder.itemView.setOnClickListener(null)
    }

}