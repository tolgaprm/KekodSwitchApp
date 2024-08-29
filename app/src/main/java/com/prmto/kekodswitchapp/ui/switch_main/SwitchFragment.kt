package com.prmto.kekodswitchapp.ui.switch_main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.prmto.kekodswitchapp.R
import com.prmto.kekodswitchapp.SwitchState
import com.prmto.kekodswitchapp.databinding.FragmentSwitchBinding
import com.prmto.kekodswitchapp.ui.SharedViewModel
import com.prmto.kekodswitchapp.ui.switch_main.Emotion.EGO
import com.prmto.kekodswitchapp.ui.switch_main.Emotion.GIVING
import com.prmto.kekodswitchapp.ui.switch_main.Emotion.HAPPINESS
import com.prmto.kekodswitchapp.ui.switch_main.Emotion.KINDNESS
import com.prmto.kekodswitchapp.ui.switch_main.Emotion.OPTIMISTIC
import com.prmto.kekodswitchapp.ui.switch_main.Emotion.RESPECT
import com.prmto.kekodswitchapp.util.collectFlow
import com.prmto.kekodswitchapp.util.setEnableAndUncheck

class SwitchFragment : Fragment(R.layout.fragment_switch) {

    private var _binding: FragmentSwitchBinding? = null
    val binding get() = _binding!!

    private lateinit var viewModel: SharedViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSwitchBinding.bind(view)
        viewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
        setSwitchCheckedChangeListeners()
        collectFlow(viewModel.switchState, action = ::changedSwitchState)
    }

    private fun changedSwitchState(items: List<SwitchState>) {
        items.forEach { item ->
            when (item.emotion) {
                HAPPINESS -> binding.swHappinness.isChecked = item.isSwitchChecked
                OPTIMISTIC -> binding.swOptimism.isChecked = item.isSwitchChecked
                KINDNESS -> binding.swKindness.isChecked = item.isSwitchChecked
                GIVING -> binding.swGiving.isChecked = item.isSwitchChecked
                RESPECT -> binding.swRespect.isChecked = item.isSwitchChecked
                EGO -> {
                    binding.swEgo.isChecked = item.isSwitchChecked
                    binding.apply {
                        swHappinness.setEnableAndUncheck(isEnable = !item.isSwitchChecked)
                        swOptimism.setEnableAndUncheck(isEnable = !item.isSwitchChecked)
                        swKindness.setEnableAndUncheck(isEnable = !item.isSwitchChecked)
                        swGiving.setEnableAndUncheck(isEnable = !item.isSwitchChecked)
                        swRespect.setEnableAndUncheck(isEnable = !item.isSwitchChecked)
                    }
                }
            }
        }
    }

    private fun setSwitchCheckedChangeListeners() {
        val switches = mapOf(
            EGO to binding.swEgo,
            HAPPINESS to binding.swHappinness,
            OPTIMISTIC to binding.swOptimism,
            KINDNESS to binding.swKindness,
            GIVING to binding.swGiving,
            RESPECT to binding.swRespect
        )

        switches.forEach { (emotion, switch) ->
            switch.setOnCheckedChangeListener { _, isChecked ->
                viewModel.setSwitchState(emotion, isChecked)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}