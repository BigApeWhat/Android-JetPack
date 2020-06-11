package com.example.layered_jetpack_mvvm.features.navigation.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.example.layered_jetpack_mvvm.R
import com.example.layered_jetpack_mvvm.common.fragment.BaseFragment
import com.example.layered_jetpack_mvvm.features.navigation.datamodel.FormEntryData
import kotlinx.android.synthetic.main.fragment_navigation_complete.*

class NavigationCompleteFragment : BaseFragment(), View.OnClickListener {
    private lateinit var navController: NavController
    private lateinit var formEntry: FormEntryData
    
    override fun getLayout(): Int = R.layout.fragment_navigation_complete
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        formEntry = requireArguments().getParcelable("FormEntry")!!
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        displayMessage()
        navController = Navigation.findNavController(view)
        nav_form_complete.setOnClickListener(this)
    }
    
    override fun onClick(view: View) {
        when(view) {
            nav_form_complete -> navController.navigate(R.id.action_navigationCompleteFragment_to_navigationStartFragment)
        }
    }
    
    private fun displayMessage() {
        nav_form_message.text = formEntry.toString()
    }
}
