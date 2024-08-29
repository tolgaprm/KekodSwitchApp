package com.prmto.kekodswitchapp.ui.happiness

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.prmto.kekodswitchapp.R
import com.prmto.kekodswitchapp.databinding.FragmentHappinessBinding
import com.prmto.kekodswitchapp.ui.emotion_detail.EmotionDetailBindingHelper
import com.prmto.kekodswitchapp.ui.emotion_detail.EmotionDetailViewModel
import com.prmto.kekodswitchapp.ui.switch_main.Emotion
import com.prmto.kekodswitchapp.util.collectFlow

class HappinessFragment : Fragment(R.layout.fragment_happiness) {

    private var _binding: FragmentHappinessBinding? = null
    val binding get() = _binding!!

    private val viewModel: EmotionDetailViewModel by viewModels()

    private val emotionDetailBindingHelper by lazy {
        EmotionDetailBindingHelper(binding.emotionDetail)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHappinessBinding.bind(view)
        viewModel.getEmotionDetail(Emotion.HAPPINESS)
        collectFlow(viewModel.emotionDetail) { emotionDetail ->
            emotionDetailBindingHelper.bindEmotionDetail(emotionDetail)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}