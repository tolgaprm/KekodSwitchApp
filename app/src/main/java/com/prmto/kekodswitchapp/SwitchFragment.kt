package com.prmto.kekodswitchapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.prmto.kekodswitchapp.databinding.FragmentSwitchBinding

class SwitchFragment : Fragment(R.layout.fragment_switch) {

    private var _binding: FragmentSwitchBinding? = null
    val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSwitchBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}