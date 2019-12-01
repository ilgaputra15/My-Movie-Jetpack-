package com.gyosanila.mymoviejetpack.features.adapter

import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gyosanila.mymoviejetpack.R
import com.gyosanila.mymoviejetpack.core.common.Constant
import com.gyosanila.mymoviejetpack.data.model.MovieItem
import kotlinx.android.synthetic.main.item_movie.view.*

/**
 * Created by ilgaputra15
 * on Sunday, 23/06/2019 23:12
 * Division Mobile - PT.Homecareindo Global Medika
 **/
class FavoriteMoviesAdapter(private val clickListener: (MovieItem) -> Unit)
    : PagedListAdapter<MovieItem, FavoriteMoviesAdapter.MovieHolder>(DIFF_CALLBACK)  {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieItem>() {
            override fun areItemsTheSame(oldConcert: MovieItem, newConcert: MovieItem) = oldConcert.id == newConcert.id
            override fun areContentsTheSame(oldConcert: MovieItem, newConcert: MovieItem) = oldConcert == newConcert
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        val viewHolder = MovieHolder(view)
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            getItem(position)?.let { clickListener(it) }

        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }

    }

    class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(part: MovieItem) {
            itemView.textTitle.text = part.title
            itemView.textDescription.text = part.overview
            Glide.with(itemView).load(Constant.ImageUrl+part.poster_path).into(itemView.imageMovie)
        }
    }
}