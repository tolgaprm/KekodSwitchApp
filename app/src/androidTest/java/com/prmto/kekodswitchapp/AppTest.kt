package com.prmto.kekodswitchapp

import androidx.activity.compose.setContent
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.prmto.kekodswitchapp.compose.SwitchApp
import com.prmto.kekodswitchapp.compose.components.BOTTOM_BAR_TEST_TAG
import com.prmto.kekodswitchapp.ui.MainActivity
import com.prmto.kekodswitchapp.ui.switch_main.Emotion
import org.junit.Rule
import org.junit.Test


class AppTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun whenAppLaunch_EgoSwitchCheckedAndEnabled_OtherSwitchesUncheckedAndDisabled() {
        composeTestRule.activity.setContent {
            SwitchApp()
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
    fun whenEgoSwitchChecked_bottomNavHidden() {
        composeTestRule.activity.setContent {
            SwitchApp()
        }

        composeTestRule.onNodeWithTag(BOTTOM_BAR_TEST_TAG).assertIsNotDisplayed()
    }

    @Test
    fun whenEgoSwitchUnChecked_bottomNavHidden() {
        composeTestRule.activity.setContent {
            SwitchApp()
        }

        composeTestRule.switchMatcher(Emotion.EGO).performClick()
        composeTestRule.switchMatcherIsEnabledAndUnChecked(Emotion.EGO)
        composeTestRule.onNodeWithTag(BOTTOM_BAR_TEST_TAG).assertIsDisplayed()
    }

    @Test
    fun whenEgoSwitchUnChecked_someSwitchChecked_assertIsCheckedAndEnabled() {
        composeTestRule.activity.setContent {
            SwitchApp()
        }

        composeTestRule.apply {
            switchMatcher(Emotion.EGO).performClick()
            switchMatcher(Emotion.KINDNESS).performClick()
            switchMatcher(Emotion.OPTIMISTIC).performClick()

            switchMatcherIsEnabledAndUnChecked(Emotion.EGO)
            switchMatcherIsEnabledAndChecked(Emotion.KINDNESS)
            switchMatcherIsEnabledAndChecked(Emotion.OPTIMISTIC)
        }
    }

    @Test
    fun whenEgoSwitchUnChecked_someSwitchChecked_thenEgoSwitchChecked_assertOtherSwitchDisabledAndUnchecked() {
        composeTestRule.activity.setContent {
            SwitchApp()
        }

        composeTestRule.apply {
            switchMatcher(Emotion.EGO).performClick()
            switchMatcher(Emotion.KINDNESS).performClick()
            switchMatcher(Emotion.OPTIMISTIC).performClick()
            switchMatcher(Emotion.EGO).performClick()
            // En son da Ego switch tekrar bastığımız için checked durumuna geçti, burada
            // diğer switch durumlarının da unchecked ve disabled durumuna geçme case'ini kontrol ediyoruz.

            switchMatcherIsEnabledAndChecked(Emotion.EGO)
            switchMatcherIsDisabledAndUnChecked(Emotion.HAPPINESS)
            switchMatcherIsDisabledAndUnChecked(Emotion.OPTIMISTIC)
            switchMatcherIsDisabledAndUnChecked(Emotion.KINDNESS)
            switchMatcherIsDisabledAndUnChecked(Emotion.GIVING)
            switchMatcherIsDisabledAndUnChecked(Emotion.RESPECT)
        }
    }
}