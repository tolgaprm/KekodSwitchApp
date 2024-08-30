package com.prmto.kekodswitchapp.compose.switch_main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.prmto.kekodswitchapp.R
import com.prmto.kekodswitchapp.SwitchState
import com.prmto.kekodswitchapp.compose.switch_main.components.SwitchItem
import com.prmto.kekodswitchapp.compose.switch_main.components.SwitchSection
import com.prmto.kekodswitchapp.ui.switch_main.Emotion

@Composable
fun SwitchMainScreen(
    modifier: Modifier = Modifier,
    switchStates: List<SwitchState>,
    onCheckedSwitch: (Emotion, Boolean) -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SwitchSection {
            SwitchItem(
                switchStates = switchStates,
                emotion = Emotion.HAPPINESS,
                switchTitleId = R.string.happinness,
                onCheckedSwitch = onCheckedSwitch
            )

            SwitchItem(
                switchStates = switchStates,
                emotion = Emotion.OPTIMISTIC,
                switchTitleId = R.string.optimism,
                onCheckedSwitch = onCheckedSwitch
            )


            SwitchItem(
                switchStates = switchStates,
                emotion = Emotion.KINDNESS,
                switchTitleId = R.string.kidness,
                onCheckedSwitch = onCheckedSwitch
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        SwitchSection {
            SwitchItem(
                switchStates = switchStates,
                emotion = Emotion.GIVING,
                switchTitleId = R.string.giving,
                onCheckedSwitch = onCheckedSwitch
            )

            SwitchItem(
                switchStates = switchStates,
                emotion = Emotion.RESPECT,
                switchTitleId = R.string.Respect,
                onCheckedSwitch = onCheckedSwitch
            )


            SwitchItem(
                switchStates = switchStates,
                emotion = Emotion.EGO,
                switchTitleId = R.string.ego,
                onCheckedSwitch = onCheckedSwitch
            )
        }
    }
}