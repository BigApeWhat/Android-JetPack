package com.example.layered_jetpack_mvvm.features.paging.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.layered_jetpack_mvvm.R
import com.example.layered_jetpack_mvvm.network.reddit.model.RedditPost
import kotlinx.android.synthetic.main.main_item_selection.view.title_selection

class PagingListAdapter : PagedListAdapter<RedditPost, PagingListAdapter.ViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object :
            DiffUtil.ItemCallback<RedditPost>() {
            override fun areItemsTheSame(oldConcert: RedditPost,
                newConcert: RedditPost) = oldConcert.hashCode() == newConcert.hashCode()
            
            override fun areContentsTheSame(oldConcert: RedditPost,
                newConcert: RedditPost) = oldConcert == newConcert
        }
    }
    
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: RedditPost?) = with(itemView) {
            title_selection.text = item?.title
        }
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.main_item_selection, parent, false)
        return ViewHolder(itemView)
    }
    
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}