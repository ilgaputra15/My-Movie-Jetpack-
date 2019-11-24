package com.gyosanila.mymoviejetpack.features.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
class TvShowAdapter(private val clickListener: (TvShowItem) -> Unit) :
    RecyclerView.Adapter<TvShowAdapter.TvShowHolder>() {

    private var listTvShow: List<TvShowItem> = ArrayList()

    fun setListTvShow(arrayList: List<TvShowItem>) {
        listTvShow = arrayList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tv_show, parent, false)
        val viewHolder = TvShowHolder(view)
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            clickListener(listTvShow[position])
        }
        return viewHolder
    }

    override fun getItemCount() = listTvShow.size

    override fun onBindViewHolder(holder: TvShowHolder, position: Int) {
        holder.bind(listTvShow[position])
    }


    class TvShowHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(part: TvShowItem) {
            Glide.with(itemView).load(Constant.ImageUrl+part.poster_path).into(itemView.imageTvShow)
        }
    }
}