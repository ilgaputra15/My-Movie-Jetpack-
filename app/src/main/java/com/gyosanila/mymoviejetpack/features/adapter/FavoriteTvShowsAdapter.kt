package com.gyosanila.mymoviejetpack.features.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gyosanila.mymoviejetpack.R
import com.gyosanila.mymoviejetpack.core.common.Constant
import com.gyosanila.mymoviejetpack.data.model.TvShowItem
import kotlinx.android.synthetic.main.item_tv_show.view.*

/**
 * Created by ilgaputra15
 * on Thursday, 09/11/2019 16:54
 * Division Mobile - PT.Homecareindo Global Medika
 **/
class FavoriteTvShowsAdapter(private val clickListener: (TvShowItem) -> Unit) :
    PagedListAdapter<TvShowItem, FavoriteTvShowsAdapter.TvShowHolder>(DIFF_CALLBACK)  {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowItem>() {
            override fun areItemsTheSame(oldConcert: TvShowItem, newConcert: TvShowItem) = oldConcert.id == newConcert.id
            override fun areContentsTheSame(oldConcert: TvShowItem, newConcert: TvShowItem) = oldConcert == newConcert
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tv_show, parent, false)
        val viewHolder = TvShowHolder(view)
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            getItem(position)?.let { clickListener(it) }
        }
        return viewHolder
    }


    override fun onBindViewHolder(holder: TvShowHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }


    class TvShowHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(part: TvShowItem) {
            Glide.with(itemView).load(Constant.ImageUrl+part.poster_path).into(itemView.imageTvShow)
        }
    }
}