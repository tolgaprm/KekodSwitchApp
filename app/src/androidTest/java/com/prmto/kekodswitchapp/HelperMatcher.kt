package com.prmto.kekodswitchapp

import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithTag
import com.prmto.kekodswitchapp.ui.switch_main.Emotion

fun ComposeTestRule.switchMatcher(emotion: Emotion): SemanticsNodeInteraction {
    return onNodeWithTag(emotion.name)
}

fun ComposeTestRule.switchMatcherIsEnabledAndChecked(emotion: Emotion): SemanticsNodeInteraction {
    return onNodeWithTag(emotion.name).assertIsEnabled().assertIsOn()
}

fun ComposeTestRule.switchMatcherIsEnabledAndUnChecked(emotion: Emotion): SemanticsNodeInteraction {
    return onNodeWithTag(emotion.name).assertIsEnabled().assertIsOff()
}

fun ComposeTestRule.switchMatcherIsDisabledAndUnChecked(emotion: Emotion): SemanticsNodeInteraction {
    return onNodeWithTag(emotion.name).assertIsNotEnabled().assertIsOff()
}