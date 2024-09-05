package com.prmto.kekodswitchapp.compose.switch_main.components

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prmto.kekodswitchapp.R
import com.prmto.kekodswitchapp.SwitchState
import com.prmto.kekodswitchapp.ui.switch_main.Emotion

@Composable
fun SwitchItem(
    modifier: Modifier = Modifier,
    switchStates: List<SwitchState>,
    emotion: Emotion,
    @StringRes switchTitleId: Int,
    onCheckedSwitch: (Emotion, Boolean) -> Unit
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(color = colorResource(id = R.color.gray))
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Switch(
            modifier = Modifier.testTag(emotion.name),
            checked = switchStates.find { it.emotion == emotion }?.isSwitchChecked ?: false,
            onCheckedChange = { onCheckedSwitch(emotion, it) },
            enabled = switchStates.find { it.emotion == emotion }?.isEnabled ?: false,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.Black,
                uncheckedThumbColor = Color.Black,
                checkedTrackColor = colorResource(id = R.color.green),
                uncheckedTrackColor = colorResource(id = R.color.red)
            )
        )

        Text(
            text = stringResource(id = switchTitleId),
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp)
        )
    }
}