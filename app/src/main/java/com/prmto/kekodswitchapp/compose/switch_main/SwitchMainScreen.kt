package com.prmto.kekodswitchapp.compose.switch_main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
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
    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(R.raw.switch_anim)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    listOf(
                        Color(0xFF4CAF50),
                        Color(0xFF155282)
                    )
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        LottieAnimation(
            composition = composition,
            modifier = Modifier
                .padding(50.dp)
                .size(300.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(colorResource(id = R.color.blue)),
            reverseOnRepeat = true,
            iterations = LottieConstants.IterateForever
        )
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

}