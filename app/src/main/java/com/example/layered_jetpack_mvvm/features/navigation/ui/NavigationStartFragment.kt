package com.example.layered_jetpack_mvvm.features.navigation.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.layered_jetpack_mvvm.R
import com.example.layered_jetpack_mvvm.common.fragment.BaseFragment
import kotlinx.android.synthetic.main.fragment_navigation_start.nav_start_intro_btn

class NavigationStartFragment : BaseFragment(), View.OnClickListener {
    private lateinit var navController: NavController
    
    override fun getLayout(): Int = R.layout.fragment_navigation_start
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        nav_start_intro_btn.setOnClickListener(this)
    }
    
    override fun onClick(view: View) {
        when(view) {
            nav_start_intro_btn -> navController.navigate(R.id.action_navigationStartFragment_to_navigationDetailsFragment)
        }
    }
    
}
