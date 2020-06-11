package com.example.layered_jetpack_mvvm.features.landingPage.entity

import com.example.layered_jetpack_mvvm.R
import com.example.layered_jetpack_mvvm.features.landingPage.model.MainItemSelection

class SelectionList {
    private val selectionListInit: List<MainItemSelection> by lazy {
        generateSelectionList()
    }
    
    fun getSelectionList(): List<MainItemSelection> = selectionListInit
    
    private fun generateSelectionList(): List<MainItemSelection> {
        val selectionListCreator: MutableList<MainItemSelection> = mutableListOf()
        
        selectionListCreator.add(
            MainItemSelection(
                R.string.main_selection_nav_graph,
                R.color.orange_500,
                R.drawable.eyes_banner
            )
        )
        selectionListCreator.add(
            MainItemSelection(
                R.string.main_selection_room,
                R.color.yellow_300,
                R.drawable.sunset_banner
            )
        )
        selectionListCreator.add(
            MainItemSelection(
                R.string.main_selection_data_binding,
                R.color.green_500,
                R.drawable.stars_banner
            )
        )
        selectionListCreator.add(
            MainItemSelection(
                R.string.main_selection_live_data,
                R.color.pink_500,
                R.drawable.sunset_clouds_banner
            )
        )
        selectionListCreator.add(
            MainItemSelection(
                R.string.main_selection_paging,
                R.color.black,
                R.drawable.hot_air_balloon_banner
            )
        )
        
        return selectionListCreator
    }
    
}