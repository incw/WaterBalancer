package ru.smolyakoff.waterbalance.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ru.smolyakoff.waterbalance.R
import ru.smolyakoff.waterbalance.databinding.FragmentDataBinding
import ru.smolyakoff.waterbalance.domain.user.UserItem

class DataFragment : Fragment() {

    private lateinit var viewModel: DataViewModel

    private var _binding: FragmentDataBinding? = null
    private val binding: FragmentDataBinding
        get() = _binding ?: throw RuntimeException("FragmentDataBinding is null")

    private var userItemId: Int = UserItem.USER_ID

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDataBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[DataViewModel::class.java]

        binding.buttonSavePersonData.setOnClickListener {
            addUser()
            launchMainFragment()
        }
    }

    private fun addUser() {

        val name = binding.etName.text.toString()
        val height = binding.etHeight.text.toString().toInt()
        val weight = binding.etWeight.text.toString().toInt()

        viewModel.addUser(name, height, weight)

    }


    private fun launchMainFragment() {
        findNavController().navigate(
            R.id.action_dataFragment2_to_mainFragment
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}