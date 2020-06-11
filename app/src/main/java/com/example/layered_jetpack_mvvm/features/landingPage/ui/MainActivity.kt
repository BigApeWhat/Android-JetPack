package com.example.layered_jetpack_mvvm.features.landingPage.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.layered_jetpack_mvvm.R
import com.example.layered_jetpack_mvvm.common._interface.RecyclerViewClickListener
import com.example.layered_jetpack_mvvm.common.activity.DaggerBaseActivity
import com.example.layered_jetpack_mvvm.features.databinding.ui.DataBindingActivity
import com.example.layered_jetpack_mvvm.features.landingPage.adapter.MainItemSelectionAdapter
import com.example.layered_jetpack_mvvm.features.paging.ui.PagingActivity
import com.example.layered_jetpack_mvvm.features.landingPage.viewmodel.MainActivityViewModel
import com.example.layered_jetpack_mvvm.features.lifecycle.ui.LifcycleAwareActivity
import com.example.layered_jetpack_mvvm.features.navigation.ui.NavigationActivity
import com.example.layered_jetpack_mvvm.features.room.ui.RoomActivity
import kotlinx.android.synthetic.main.activity_main.recycler_view
import javax.inject.Inject

class MainActivity : DaggerBaseActivity(), RecyclerViewClickListener {
    @Inject
    lateinit var mainActivityViewModel: MainActivityViewModel
    
    private lateinit var recyclerView: RecyclerView
    private lateinit var mAdapter: MainItemSelectionAdapter
    
    override fun getLayout(): Int = R.layout.activity_main
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prepareRecycler()
    }
    
    private fun prepareRecycler() {
        mAdapter = MainItemSelectionAdapter(this, mainActivityViewModel.getSelectionListData())
        recyclerView = recycler_view
        
        val itemDecorator = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        itemDecorator.setDrawable(getDrawable(R.drawable.decorator_vertical_divider)!!)
    
        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = mLayoutManager
        recyclerView.addItemDecoration(itemDecorator)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = mAdapter
    }
    
    override fun recyclerViewPositionClicked(view: View, position: Int) {
        val myIntent = when (position) {
            0 -> {
                Intent(this, NavigationActivity::class.java)
            }
            1 -> {
                Intent(this, RoomActivity::class.java)
            }
            2 -> {
                Intent(this, DataBindingActivity::class.java)
            }
            3 -> {
                Intent(this, LifcycleAwareActivity::class.java)
            }
            4 -> {
                Intent(this, PagingActivity::class.java)
            }
            else -> {
                Intent(this, NavigationActivity::class.java)
            }
        }
        startActivity(myIntent)
    }
    
}