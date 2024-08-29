package com.prmto.kekodswitchapp.ui

import androidx.lifecycle.ViewModel
import com.prmto.kekodswitchapp.SwitchState
import com.prmto.kekodswitchapp.ui.switch_main.BottomNavItem
import com.prmto.kekodswitchapp.ui.switch_main.Emotion
import com.prmto.kekodswitchapp.ui.switch_main.toBottomNavItem
import com.prmto.kekodswitchapp.ui.switch_main.toEmotion
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SharedViewModel : ViewModel() {
    private val _bottomNavMenuItems: MutableStateFlow<List<BottomNavItem>> =
        MutableStateFlow(listOf(BottomNavItem.Ego))
    val bottomNavItems: StateFlow<List<BottomNavItem>> = _bottomNavMenuItems.asStateFlow()

    private val _switchState: MutableStateFlow<List<SwitchState>> = MutableStateFlow(
        listOf(
            SwitchState(Emotion.EGO, true)
        )
    )
    val switchState: StateFlow<List<SwitchState>> = _switchState.asStateFlow()

    private val _showBottomBar: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val showBottomBar: StateFlow<Boolean> = _showBottomBar.asStateFlow()

    private fun setBottomNavMenuItem(item: BottomNavItem) {
        _bottomNavMenuItems.value = bottomNavItems.value + item
    }

    private fun removeBottomNavMenuItem(item: BottomNavItem) {
        _bottomNavMenuItems.value = bottomNavItems.value - item
    }

    fun setSwitchState(emotion: Emotion, isSwitchChecked: Boolean) {
        _switchState.update {
            it.map {
                if (it.emotion == emotion) {
                    it.copy(isSwitchChecked = isSwitchChecked)
                } else {
                    it
                }
            }
        }

        if (emotion == Emotion.EGO) {
            _showBottomBar.value = !isSwitchChecked
            return
        }

        if (isSwitchChecked && emotion in bottomNavItems.value.map { it.toEmotion() }) {
            return
        }

        if (isSwitchChecked) {
            setBottomNavMenuItem(emotion.toBottomNavItem())
        } else {
            removeBottomNavMenuItem(emotion.toBottomNavItem())
        }
    }
}