package com.prmto.kekodswitchapp.ui.emotion_detail

import androidx.lifecycle.ViewModel
import com.prmto.kekodswitchapp.data.EmotionRepository
import com.prmto.kekodswitchapp.data.EmotionRepositoryImpl
import com.prmto.kekodswitchapp.ui.switch_main.Emotion
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class EmotionDetailViewModel : ViewModel() {

    private val emotionRepository: EmotionRepository = EmotionRepositoryImpl()

    private val _emotionDetail = MutableStateFlow<EmotionDetail?>(null)
    val emotionDetail: StateFlow<EmotionDetail?> = _emotionDetail.asStateFlow()

    fun getEmotionDetail(emotion: Emotion) {
        val emotionDetail = emotionRepository.getEmotionDetail(emotion)
        _emotionDetail.update { emotionDetail }
    }
}