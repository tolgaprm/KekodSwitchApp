package com.prmto.kekodswitchapp.ui

import app.cash.turbine.test
import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isFalse
import assertk.assertions.isTrue
import com.prmto.kekodswitchapp.SwitchState
import com.prmto.kekodswitchapp.ui.switch_main.BottomNavItem
import com.prmto.kekodswitchapp.ui.switch_main.Emotion
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
class SharedViewModelTest {

    private val viewModel = SharedViewModel()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `setSwitchState when ego switch checked, should update switchState`() = runTest {
        viewModel.setSwitchState(Emotion.EGO, true)
        viewModel.switchState.test {
            assertThat(awaitItem()).isEqualTo(
                listOf(
                    SwitchState(
                        emotion = Emotion.EGO,
                        isSwitchChecked = true,
                        isEnabled = true
                    ),
                    SwitchState(
                        emotion = Emotion.HAPPINESS,
                        isSwitchChecked = false,
                        isEnabled = false
                    ),
                    SwitchState(
                        emotion = Emotion.OPTIMISTIC,
                        isSwitchChecked = false,
                        isEnabled = false
                    ),
                    SwitchState(
                        emotion = Emotion.KINDNESS,
                        isSwitchChecked = false,
                        isEnabled = false
                    ),
                    SwitchState(
                        emotion = Emotion.GIVING,
                        isSwitchChecked = false,
                        isEnabled = false
                    ),
                    SwitchState(
                        emotion = Emotion.RESPECT,
                        isSwitchChecked = false,
                        isEnabled = false
                    )
                )
            )
        }
    }

    @Test
    fun `setSwitchState when ego switch unchecked, should update switchState`() = runTest {
        viewModel.setSwitchState(Emotion.EGO, false)
        viewModel.switchState.test {
            assertThat(awaitItem()).isEqualTo(
                listOf(
                    SwitchState(
                        emotion = Emotion.EGO,
                        isSwitchChecked = false,
                        isEnabled = true
                    ),
                    SwitchState(
                        emotion = Emotion.HAPPINESS,
                        isSwitchChecked = false,
                        isEnabled = true
                    ),
                    SwitchState(
                        emotion = Emotion.OPTIMISTIC,
                        isSwitchChecked = false,
                        isEnabled = true
                    ),
                    SwitchState(
                        emotion = Emotion.KINDNESS,
                        isSwitchChecked = false,
                        isEnabled = true
                    ),
                    SwitchState(
                        emotion = Emotion.GIVING,
                        isSwitchChecked = false,
                        isEnabled = true
                    ),
                    SwitchState(
                        emotion = Emotion.RESPECT,
                        isSwitchChecked = false,
                        isEnabled = true
                    )
                )
            )
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `setSwitchState should update showBottomBar to true`() = runTest {
        viewModel.setSwitchState(Emotion.EGO, isSwitchChecked = false)
        viewModel.setSwitchState(Emotion.RESPECT, isSwitchChecked = true)
        viewModel.showBottomBar.test {
            assertThat(awaitItem()).isTrue()
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `setSwitchState with EGO should hide bottomBar`() = runTest {
        viewModel.setSwitchState(Emotion.EGO, true)
        viewModel.showBottomBar.test {
            assertThat(awaitItem()).isFalse()
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `setSwitchState should update bottomNavItems`() = runTest {
        viewModel.setSwitchState(emotion = Emotion.EGO, isSwitchChecked = true)
        viewModel.setSwitchState(Emotion.GIVING, isSwitchChecked = true)
        viewModel.setSwitchState(Emotion.RESPECT, isSwitchChecked = true)
        viewModel.setSwitchState(Emotion.GIVING, isSwitchChecked = false)

        viewModel.bottomNavItems.test {
            assertThat(awaitItem()).isEqualTo(
                listOf(
                    BottomNavItem.Ego,
                    BottomNavItem.Respect
                )
            )
        }
    }
}