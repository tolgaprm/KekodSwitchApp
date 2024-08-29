package com.prmto.kekodswitchapp.ui.optimism

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.prmto.kekodswitchapp.R
import com.prmto.kekodswitchapp.databinding.FragmentOptimismBinding
import com.prmto.kekodswitchapp.ui.emotion_detail.EmotionDetailBindingHelper
import com.prmto.kekodswitchapp.ui.emotion_detail.EmotionDetailViewModel
import com.prmto.kekodswitchapp.ui.switch_main.Emotion
import com.prmto.kekodswitchapp.util.collectFlow

class OptimismFragment : Fragment(R.layout.fragment_optimism) {

    private var _binding: FragmentOptimismBinding? = null
    val binding get() = _binding!!

    private val viewModel: EmotionDetailViewModel by viewModels()

    private val emotionDetailBindingHelper by lazy {
        EmotionDetailBindingHelper(binding.emotionDetail)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentOptimismBinding.bind(view)
        viewModel.getEmotionDetail(Emotion.OPTIMISTIC)
        collectFlow(viewModel.emotionDetail) { emotionDetail ->
            emotionDetailBindingHelper.bindEmotionDetail(emotionDetail)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}