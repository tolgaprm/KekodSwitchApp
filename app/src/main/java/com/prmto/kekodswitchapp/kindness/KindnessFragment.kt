package com.prmto.kekodswitchapp.kindness

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.prmto.kekodswitchapp.R
import com.prmto.kekodswitchapp.databinding.FragmentKindnessBinding

class KindnessFragment : Fragment(R.layout.fragment_kindness) {

    private var _binding: FragmentKindnessBinding? = null
    val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentKindnessBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}