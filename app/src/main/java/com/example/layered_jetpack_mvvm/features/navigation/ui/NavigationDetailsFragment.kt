package com.example.layered_jetpack_mvvm.features.navigation.ui

import android.os.Bundle
import android.text.Editable
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.layered_jetpack_mvvm.R
import com.example.layered_jetpack_mvvm.common.fragment.BaseFragment
import com.example.layered_jetpack_mvvm.features.navigation.datamodel.FormEntryData
import kotlinx.android.synthetic.main.fragment_navigation_details.*

class NavigationDetailsFragment : BaseFragment(), View.OnClickListener {
    private lateinit var navController: NavController
    
    override fun getLayout(): Int = R.layout.fragment_navigation_details
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        nav_details_submit.setOnClickListener(this)
    }
    
    override fun onClick(view: View) {
        val formName = nav_form_name.text
        val formAddress = nav_form_address.text
        val formTelephoneNumber = nav_form_telephone.text
        val bundle = bundleOf("FormEntry" to FormEntryData(formName.toString(), formAddress.toString(), formTelephoneNumber.toString()))
        
        when(view) {
            nav_details_submit -> {
                if (checkBundleFields(formName, formAddress, formTelephoneNumber)) {
                    navController.navigate(R.id.action_navigationDetailsFragment_to_navigationCompleteFragment, bundle)
                } else {
                    navController.navigate(R.id.action_navigationDetailsFragment_to_navigationCompleteErrorFragment, bundle)
                }
            }
        }
    }
    
    private fun checkBundleFields(formName: Editable, formAddress: Editable, formTelephoneNumber: Editable): Boolean =
        !(formName.isBlank() || formAddress.isBlank() || formTelephoneNumber.isBlank())

}