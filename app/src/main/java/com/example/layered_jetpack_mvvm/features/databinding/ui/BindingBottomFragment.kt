package com.example.layered_jetpack_mvvm.features.databinding.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.layered_jetpack_mvvm.R
import com.example.layered_jetpack_mvvm.common._interface.ActivityViewModel
import com.example.layered_jetpack_mvvm.common.fragment.BaseFragment
import com.example.layered_jetpack_mvvm.common.helper.RandomStringGenerator.Companion.randomString
import com.example.layered_jetpack_mvvm.databinding.FragmentBindingBottomBinding
import com.example.layered_jetpack_mvvm.features.databinding.viewmodel.DataBindingViewModel
import kotlinx.android.synthetic.main.fragment_binding_bottom.*

class BindingBottomFragment : BaseFragment() {
    private lateinit var viewModel: DataBindingViewModel
    override fun getLayout(): Int = R.layout.fragment_binding_bottom
    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentBindingBottomBinding = DataBindingUtil.inflate(inflater, getLayout(), container, false)
        binding.bindingModel = viewModel.getBindings()
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        data_binding_bottom_text.addTextChangedListener(viewModel.getTextChangeListener())
        random_word_btn.setOnClickListener {
            viewModel.updateVarPass(randomString())
        }
    }
    
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ActivityViewModel) {
            viewModel = (context as ActivityViewModel).getViewModel() as DataBindingViewModel
        } else {
            throw RuntimeException("Context does not support the Fragment, implement ActivityViewModel")
        }
    }
}
