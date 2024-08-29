package com.prmto.kekodswitchapp.optimism

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.prmto.kekodswitchapp.R
import com.prmto.kekodswitchapp.databinding.FragmentOptimismBinding

class OptimismFragment : Fragment(R.layout.fragment_optimism) {

    private var _binding: FragmentOptimismBinding? = null
    val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentOptimismBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}