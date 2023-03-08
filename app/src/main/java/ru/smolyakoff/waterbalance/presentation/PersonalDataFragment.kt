package ru.smolyakoff.waterbalance.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.smolyakoff.waterbalance.databinding.FragmentPersonalDataBinding


class PersonalDataFragment : Fragment() {


    private var _binding: FragmentPersonalDataBinding? = null
    private val binding: FragmentPersonalDataBinding
        get() = _binding ?: throw RuntimeException("FragmentPersonalDataBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentPersonalDataBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}