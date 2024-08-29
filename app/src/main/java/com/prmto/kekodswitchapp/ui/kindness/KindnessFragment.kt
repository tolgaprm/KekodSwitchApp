package com.prmto.kekodswitchapp.ui.kindness

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.prmto.kekodswitchapp.R
import com.prmto.kekodswitchapp.databinding.FragmentKindnessBinding
import com.prmto.kekodswitchapp.ui.emotion_detail.EmotionDetailBindingHelper
import com.prmto.kekodswitchapp.ui.emotion_detail.EmotionDetailViewModel
import com.prmto.kekodswitchapp.ui.switch_main.Emotion
import com.prmto.kekodswitchapp.util.collectFlow

class KindnessFragment : Fragment(R.layout.fragment_kindness) {

    private var _binding: FragmentKindnessBinding? = null
    val binding get() = _binding!!

    private val viewModel: EmotionDetailViewModel by viewModels()

    private val emotionDetailBindingHelper by lazy {
        EmotionDetailBindingHelper(binding.emotionDetail)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentKindnessBinding.bind(view)
        viewModel.getEmotionDetail(Emotion.KINDNESS)
        collectFlow(viewModel.emotionDetail) { emotionDetail ->
            emotionDetailBindingHelper.bindEmotionDetail(emotionDetail)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}