package com.prmto.kekodswitchapp.giving

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.prmto.kekodswitchapp.R
import com.prmto.kekodswitchapp.databinding.FragmentGivingBinding

class GivingFragment : Fragment(R.layout.fragment_giving) {

    private var _binding: FragmentGivingBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentGivingBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}