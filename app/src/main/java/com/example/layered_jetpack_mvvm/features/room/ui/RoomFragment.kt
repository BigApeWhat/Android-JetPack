package com.example.layered_jetpack_mvvm.features.room.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.layered_jetpack_mvvm.R
import com.example.layered_jetpack_mvvm.common._interface.ActivityViewModel
import com.example.layered_jetpack_mvvm.common.fragment.BaseFragment
import com.example.layered_jetpack_mvvm.database.entity.RoomLiveData
import com.example.layered_jetpack_mvvm.features.room.viewmodel.RoomViewModel
import kotlinx.android.synthetic.main.fragment_room.*

class RoomFragment : BaseFragment() {
    private lateinit var viewModel: RoomViewModel
    override fun getLayout(): Int = R.layout.fragment_room
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.liveData.observe(viewLifecycleOwner, Observer { loadDataIntoView(it) })
    
        viewModel.reloadData()
        add_entry.setOnClickListener(addListener)
        delete_entry.setOnClickListener(deleteListener)
    }
    
    private fun loadDataIntoView(dataList: List<RoomLiveData>) {
        var dataString = ""
        
        dataList.forEach {
           dataString += "${it.id} -> ${it.name} -> ${it.description}\n"
        }
    
        data_text.text = dataString
    }
    
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ActivityViewModel) {
            viewModel = (context as ActivityViewModel).getViewModel() as RoomViewModel
        } else {
            throw RuntimeException("Context does not support the Fragment, implement ActivityViewModel")
        }
    }
    
    private fun showEmptyFieldToast() {
        Toast.makeText(context, getString(R.string.room_data_toast_empty), Toast.LENGTH_SHORT).show()
    }
    
    private val addListener = View.OnClickListener {
        val id = room_data_input_id.text.toString()
        val name = room_data_input_name.text.toString()
        val desc = room_data_input_description.text.toString()
        
        if (viewModel.checkAddFields(id, name, desc)) {
            showEmptyFieldToast()
        } else {
            viewModel.saveDataEntry(RoomLiveData(id, name, desc))
        }
    }
    
    private val deleteListener = View.OnClickListener {
        val deleteId = room_data_delete_id.text.toString()
    
        if (viewModel.checkAddFields(deleteId)) {
            showEmptyFieldToast()
        } else {
            viewModel.deleteById(deleteId)
        }
    }
}
