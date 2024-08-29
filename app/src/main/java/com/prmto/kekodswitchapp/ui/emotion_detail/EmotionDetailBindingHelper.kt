package com.prmto.kekodswitchapp.ui.emotion_detail

import com.prmto.kekodswitchapp.databinding.FragmentEmotionDetailBinding
import com.prmto.kekodswitchapp.util.loadImage

class EmotionDetailBindingHelper(
    private val emotionDetailBinding: FragmentEmotionDetailBinding
) {
    private val emotionQuoteAdapter = QuoteAdapter()

    init {
        emotionDetailBinding.rwEmotionQuotes.adapter = emotionQuoteAdapter
    }

    fun bindEmotionDetail(emotionDetail: EmotionDetail?) {
        emotionDetail?.let {
            setEmotionTitle(
                emotionDetail.emotion.name.lowercase().replaceFirstChar { it.uppercase() })
            setEmotionDescription(emotionDetail.emotionDescription)
            setEmotionImage(emotionDetail.emotionImageUrl)
            setEmotionStaticsText(emotionDetail.emotionStaticsText)
            setEmotionQuotes(emotionDetail.emotionQuote)
        }
    }

    private fun setEmotionQuotes(emotionQuote: List<EmotionQuote>) {
        emotionQuoteAdapter.submitList(emotionQuote)
    }

    private fun setEmotionTitle(emotionTitle: String) {
        emotionDetailBinding.tvEmotionTitle.text = emotionTitle
    }

    private fun setEmotionDescription(emotionDescription: String) {
        emotionDetailBinding.tvEmotionDescription.text = emotionDescription
    }

    private fun setEmotionImage(emotionImageUrl: String) {
        emotionDetailBinding.ivEmotion.loadImage(emotionImageUrl)
    }

    private fun setEmotionStaticsText(emotionStaticsText: String) {
        emotionDetailBinding.tvEmotionStaticsText.text = emotionStaticsText
    }
}