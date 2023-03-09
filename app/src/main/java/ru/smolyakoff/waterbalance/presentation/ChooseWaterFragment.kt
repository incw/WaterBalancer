package ru.smolyakoff.waterbalance.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.smolyakoff.waterbalance.databinding.FragmentChooseWaterBinding


class ChooseWaterFragment : Fragment() {


    private var _binding: FragmentChooseWaterBinding? = null
    private val binding: FragmentChooseWaterBinding
        get() = _binding ?: throw RuntimeException("FragmentChooseWaterBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseWaterBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}