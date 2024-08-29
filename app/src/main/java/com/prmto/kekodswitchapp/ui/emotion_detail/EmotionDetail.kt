package com.prmto.kekodswitchapp.ui.emotion_detail

import com.prmto.kekodswitchapp.ui.switch_main.Emotion
import java.util.UUID

data class EmotionDetail(
    val emotion: Emotion,
    val emotionDescription: String,
    val emotionImageUrl: String,
    val emotionQuote: List<EmotionQuote>,
    val emotionStaticsText: String
)

data class EmotionQuote(
    val id: String = UUID.randomUUID().toString(),
    val quote: String,
    val author: String,
)