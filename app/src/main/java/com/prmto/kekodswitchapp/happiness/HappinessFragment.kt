package com.prmto.kekodswitchapp.happiness

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.prmto.kekodswitchapp.R
import com.prmto.kekodswitchapp.databinding.FragmentHappinessBinding

class HappinessFragment : Fragment(R.layout.fragment_happiness) {

    private var _binding: FragmentHappinessBinding? = null
    val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}