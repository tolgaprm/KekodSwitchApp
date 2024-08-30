package com.prmto.kekodswitchapp.compose.emotion_detail.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun BodyText(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle = MaterialTheme.typography.bodyMedium.copy(fontSize = 18.sp),
    textAlign: TextAlign = TextAlign.Justify
) {
    Text(
        modifier = modifier,
        text = text,
        style = style,
        textAlign = textAlign
    )
}
