package com.example.layered_jetpack_mvvm.features.lifecycle.ui

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleRegistry
import com.example.layered_jetpack_mvvm.R
import com.example.layered_jetpack_mvvm.common.activity.BaseActivity
import com.example.layered_jetpack_mvvm.features.lifecycle.component.AwareComponent
import com.example.layered_jetpack_mvvm.features.lifecycle.component.UnawareComponent
import kotlinx.android.synthetic.main.activity_lifcycle_aware.*

class LifcycleAwareActivity : BaseActivity() {
    override fun getLayout(): Int = R.layout.activity_lifcycle_aware
    private val lifecycleRegistry: LifecycleRegistry = LifecycleRegistry(this)
    
    private val MAX_TOAST_SHOW: Int = 5
    private val MAX_DELAY_MS: Long = 3000
    
    private val unawareComponent: UnawareComponent = UnawareComponent() { showToast("Active Activity") }
    private val awareComponent: AwareComponent = AwareComponent(lifecycleRegistry) { showToast(it) }
    
    private val handler: Handler = Handler()
    private var counter = MAX_TOAST_SHOW
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleRegistry.currentState = Lifecycle.State.CREATED
        lifecycle_unaware_close_update.setOnClickListener(unawareListener)
        lifecycle_aware_close_update.setOnClickListener(awareListener)
    }
    
    private val awareListener = View.OnClickListener {
        if (counter-- != 0) {
            handler.postDelayed(Runnable {
                lifecycle_aware_close_update.callOnClick()
                awareComponent.something()
            }, MAX_DELAY_MS)
        } else {
            counter = MAX_TOAST_SHOW
        }
    }
    
    private val unawareListener = View.OnClickListener {
        if (counter-- != 0) {
            handler.postDelayed(Runnable {
                lifecycle_unaware_close_update.callOnClick()
                unawareComponent.something()
            }, MAX_DELAY_MS)
        } else {
            counter = MAX_TOAST_SHOW
        }
    }
    
    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
    
    override fun onDestroy() {
        super.onDestroy()
        lifecycleRegistry.currentState = Lifecycle.State.DESTROYED
    }
}
