package com.prmto.kekodswitchapp.util

import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bumptech.glide.Glide
import com.google.android.material.switchmaterial.SwitchMaterial
import com.prmto.kekodswitchapp.SwitchState
import com.prmto.kekodswitchapp.ui.switch_main.BottomNavItem
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

fun SwitchMaterial.setCheckedAndEnabled(switchState: SwitchState) {
    this.isChecked = switchState.isSwitchChecked
    this.isEnabled = switchState.isEnabled
}

fun ImageView.loadImage(url: String) {
    Glide.with(this)
        .load(url)
        .into(this)
}

fun Menu.addItem(
    bottomNavItem: BottomNavItem,
): MenuItem {
    return add(
        1,
        bottomNavItem.itemId,
        0,
        bottomNavItem.textId
    ).apply {
        setIcon(bottomNavItem.icon)
    }
}

fun <T> Fragment.collectFlow(
    flow: Flow<T>,
    action: suspend (T) -> Unit
): Job {
    return viewLifecycleOwner.lifecycleScope.launch {
        flow.collect {
            action(it)
        }
    }
}

fun <T> AppCompatActivity.collectFlow(
    flow: Flow<T>,
    state: Lifecycle.State = Lifecycle.State.STARTED,
    action: suspend (T) -> Unit
): Job {
    return lifecycleScope.launch {
        repeatOnLifecycle(state) {
            flow.collect {
                action(it)
            }
        }
    }
}