package com.example.layered_jetpack_mvvm.features.paging.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.layered_jetpack_mvvm.R
import com.example.layered_jetpack_mvvm.common._interface.ActivityViewModel
import com.example.layered_jetpack_mvvm.common.activity.DaggerBaseActivity
import com.example.layered_jetpack_mvvm.features.paging.adapter.PagingListAdapter
import com.example.layered_jetpack_mvvm.features.paging.datasource.RedditDataSource
import com.example.layered_jetpack_mvvm.network.reddit.model.RedditPost
import com.example.layered_jetpack_mvvm.features.paging.viewmodel.PagingViewModel
import kotlinx.android.synthetic.main.activity_paging.paging_recycler
import javax.inject.Inject

class PagingActivity : DaggerBaseActivity(), ActivityViewModel {
    @Inject
    lateinit var viewModel: PagingViewModel
    @Inject
    lateinit var redditDataSource: RedditDataSource
    
    private lateinit var recyclerView: RecyclerView
    private lateinit var mAdapter: PagingListAdapter
    
    override fun getLayout(): Int = R.layout.activity_paging
    override fun getViewModel(): ViewModel = viewModel
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prepareRecycler()
    }
    
    private fun prepareRecycler() {
        mAdapter = PagingListAdapter()
        recyclerView = paging_recycler
        
        val itemDecorator = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        itemDecorator.setDrawable(getDrawable(R.drawable.decorator_vertical_divider)!!)
        
        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = mLayoutManager
        recyclerView.addItemDecoration(itemDecorator)
        recyclerView.itemAnimator = DefaultItemAnimator()
        
        //TODO: show empty state, error state, working state
        initializeList()
        recyclerView.adapter = mAdapter
    }
    
    private fun initializeList() {
        val config = PagedList.Config.Builder()
            .setPageSize(30)
            .setEnablePlaceholders(false)
            .build()
    
        val liveData = initializedPagedListBuilder(config).build()
    
        liveData.observe(this, Observer(mAdapter::submitList))
    }
    
    private fun initializedPagedListBuilder(config: PagedList.Config): LivePagedListBuilder<String, RedditPost> {
            val dataSourceFactory = object : DataSource.Factory<String, RedditPost>() {
                override fun create(): DataSource<String, RedditPost> {
                    return redditDataSource
                }
            }
            return LivePagedListBuilder(dataSourceFactory, config)
    }
}
