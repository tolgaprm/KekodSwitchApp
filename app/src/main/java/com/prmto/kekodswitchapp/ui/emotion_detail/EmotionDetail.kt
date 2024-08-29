package com.prmto.kekodswitchapp.ui.emotion_detail

import com.prmto.kekodswitchapp.ui.switch_main.Emotion

data class EmotionDetail(
    val emotion: Emotion,
    val emotionDescription: String,
    val emotionImageUrl: String,
    val emotionQuote: List<EmotionQuote>,
    val emotionStaticsText: String
)

data class EmotionQuote(
    val id: Int,
    val quote: String,
    val author: String,
)