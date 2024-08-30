package com.prmto.kekodswitchapp

import android.content.Context
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.core.app.ApplicationProvider
import com.prmto.kekodswitchapp.compose.switch_main.SwitchMainScreen
import com.prmto.kekodswitchapp.ui.switch_main.Emotion
import org.junit.Rule
import org.junit.Test

class SwitchMainScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val context: Context = ApplicationProvider.getApplicationContext()

    @Test
    fun whenEgoSwitchChecked_OtherSwitchUnCheckedAndDisabled() {
        composeTestRule.setContent {
            SwitchMainScreen(
                switchStates = listOf(
                    SwitchState(
                        Emotion.EGO,
                        isSwitchChecked = true,
                        isEnabled = true
                    ),
                    SwitchState(
                        Emotion.HAPPINESS,
                        isSwitchChecked = false,
                        isEnabled = false
                    ),
                    SwitchState(
                        Emotion.OPTIMISTIC,
                        isSwitchChecked = false,
                        isEnabled = false
                    ),
                    SwitchState(
                        Emotion.KINDNESS,
                        isSwitchChecked = false,
                        isEnabled = false
                    ),
                    SwitchState(
                        Emotion.RESPECT,
                        isSwitchChecked = false,
                        isEnabled = false
                    ),
                    SwitchState(
                        Emotion.GIVING,
                        isSwitchChecked = false,
                        isEnabled = false
                    )
                ),
                onCheckedSwitch = { _, _ -> }
            )
        }
        composeTestRule.apply {
            switchMatcherIsEnabledAndChecked(Emotion.EGO)
            switchMatcherIsDisabledAndUnChecked(Emotion.HAPPINESS)
            switchMatcherIsDisabledAndUnChecked(Emotion.OPTIMISTIC)
            switchMatcherIsDisabledAndUnChecked(Emotion.KINDNESS)
            switchMatcherIsDisabledAndUnChecked(Emotion.GIVING)
            switchMatcherIsDisabledAndUnChecked(Emotion.RESPECT)
        }
    }

    @Test
    fun whenEgoSwitchFalse_OtherSwitchesEnabled() {
        composeTestRule.setContent {
            SwitchMainScreen(
                switchStates = listOf(
                    SwitchState(
                        Emotion.EGO,
                        isSwitchChecked = false,
                        isEnabled = true
                    ),
                    SwitchState(
                        Emotion.HAPPINESS,
                        isSwitchChecked = false,
                        isEnabled = true
                    ),
                    SwitchState(
                        Emotion.OPTIMISTIC,
                        isSwitchChecked = true,
                        isEnabled = true
                    ),
                    SwitchState(
                        Emotion.KINDNESS,
                        isSwitchChecked = false,
                        isEnabled = true
                    ),
                    SwitchState(
                        Emotion.RESPECT,
                        isSwitchChecked = false,
                        isEnabled = true
                    ),
                    SwitchState(
                        Emotion.GIVING,
                        isSwitchChecked = false,
                        isEnabled = true
                    )
                ),
                onCheckedSwitch = { _, _ -> }
            )
        }

        composeTestRule.apply {
            switchMatcherIsEnabledAndUnChecked(Emotion.EGO)
            switchMatcherIsEnabledAndUnChecked(Emotion.HAPPINESS)
            switchMatcherIsEnabledAndChecked(Emotion.OPTIMISTIC)
            switchMatcherIsEnabledAndUnChecked(Emotion.KINDNESS)
            switchMatcherIsEnabledAndUnChecked(Emotion.GIVING)
            switchMatcherIsEnabledAndUnChecked(Emotion.RESPECT)
        }
    }
}
