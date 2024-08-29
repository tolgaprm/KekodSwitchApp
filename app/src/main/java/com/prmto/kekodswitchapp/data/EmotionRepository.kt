package com.prmto.kekodswitchapp.data

import com.prmto.kekodswitchapp.ui.emotion_detail.EmotionDetail
import com.prmto.kekodswitchapp.ui.switch_main.Emotion

interface EmotionRepository {

    fun getEmotionDetail(emotion: Emotion): EmotionDetail
}