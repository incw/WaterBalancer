package ru.smolyakoff.waterbalance.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.smolyakoff.waterbalance.R
import ru.smolyakoff.waterbalance.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private var _binding: FragmentWelcomeBinding? = null
    private val binding: FragmentWelcomeBinding
        get() = _binding ?: throw RuntimeException("FragmentWelcome is null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentWelcomeBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonStart.setOnClickListener {
            launchPersonalDataFragment()
        }
    }

    private fun launchPersonalDataFragment() {
        findNavController().navigate(R.id.action_welcomeFragment_to_personalDataFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}