package com.example.layered_jetpack_mvvm.features.navigation.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.example.layered_jetpack_mvvm.R
import com.example.layered_jetpack_mvvm.common.fragment.BaseFragment
import com.example.layered_jetpack_mvvm.features.navigation.datamodel.FormEntryData
import kotlinx.android.synthetic.main.fragment_navigation_complete_error.*

class NavigationCompleteErrorFragment : BaseFragment(), View.OnClickListener {
    private lateinit var navController: NavController
    private lateinit var formEntry: FormEntryData
    
    override fun getLayout(): Int = R.layout.fragment_navigation_complete_error
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        formEntry = requireArguments().getParcelable("FormEntry")!!
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        displayErrorMessage()
        navController = Navigation.findNavController(view)
        complete_error.setOnClickListener(this)
    }
    
    override fun onClick(view: View) {
        when(view) {
            complete_error -> navController.popBackStack()
        }
    }

    private fun displayErrorMessage() {
        nav_err_display.text = formEntry.getErrorMessage()
    }
}
