package com.prmto.kekodswitchapp.respect

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.prmto.kekodswitchapp.R
import com.prmto.kekodswitchapp.databinding.FragmentRespectBinding

class RespectFragment : Fragment(R.layout.fragment_respect) {

    private var _binding: FragmentRespectBinding? = null
    val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentRespectBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}