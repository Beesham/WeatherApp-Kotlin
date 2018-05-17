package com.beesham.weatherapp.ui.activities

import android.support.v7.graphics.drawable.DrawerArrowDrawable
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import com.beesham.weatherapp.R
import com.beesham.weatherapp.extensions.ctx
import com.beesham.weatherapp.extensions.slideEnter
import com.beesham.weatherapp.extensions.slideExit
import com.beesham.weatherapp.ui.App
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

interface ToolbarManager {

    val toolBar: Toolbar

    var toolbarTitle: String
        get() = toolBar.title.toString()
        set(value) {
            toolBar.title = value
        }

    fun initToolbar() {
        toolBar.inflateMenu(R.menu.menu_main)
        toolBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_settings -> toolBar.ctx.startActivity<SettingActivity>()
                else -> App.instance.toast("Unknown option")
            }
            true
        }
    }

    fun enableHomeAsUp(up: () -> Unit) {
        toolBar.navigationIcon = createUpDrawable()
        toolBar.setNavigationOnClickListener { up() }
    }

    private fun createUpDrawable() = DrawerArrowDrawable(toolBar.ctx).apply { progress = 1f }

    fun attachToScroll(recyclerView: RecyclerView) {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                if(dy > 0) toolBar.slideExit() else toolBar.slideEnter()
            }
        })
    }
}