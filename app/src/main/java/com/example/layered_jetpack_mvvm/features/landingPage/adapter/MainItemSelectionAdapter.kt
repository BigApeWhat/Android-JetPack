package com.example.layered_jetpack_mvvm.features.landingPage.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.layered_jetpack_mvvm.R
import com.example.layered_jetpack_mvvm.common._interface.RecyclerViewClickListener
import com.example.layered_jetpack_mvvm.features.landingPage.model.MainItemSelection
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.main_item_selection.view.image_selection
import kotlinx.android.synthetic.main.main_item_selection.view.title_selection
import java.util.concurrent.TimeUnit

class MainItemSelectionAdapter(private val listener: RecyclerViewClickListener, private val items: List<MainItemSelection>) : RecyclerView.Adapter<MainItemSelectionAdapter.ViewHolder>() {
    
    class ViewHolder(private val listener: RecyclerViewClickListener, itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: MainItemSelection): Disposable = with(itemView) {
            title_selection.text = resources.getString(item.title)
            title_selection.setTextColor(ContextCompat.getColor(this.context, item.fontColor))
            image_selection.setImageResource(item.image)
            RxView.clicks(this)
                .throttleFirst(300, TimeUnit.MILLISECONDS)
                .subscribe { listener.recyclerViewPositionClicked(this, layoutPosition) }
        }
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.main_item_selection, parent, false)
        return ViewHolder(listener, itemView)
    }
    
    override fun getItemCount(): Int = items.size
    
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }
}