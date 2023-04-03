package ru.smolyakoff.waterbalance.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.smolyakoff.waterbalance.R
import ru.smolyakoff.waterbalance.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    private lateinit var viewModel: DataViewModel

    private var _binding: FragmentNotificationsBinding? = null
    private val binding: FragmentNotificationsBinding
        get() = _binding ?: throw RuntimeException("FragmentSettingsBinding")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this)[DataViewModel::class.java]

        super.onViewCreated(view, savedInstanceState)
        getUserInfo()
        calculateWater()
    }


    private fun getUserInfo() {

        viewModel.userList.observe(viewLifecycleOwner) {

            binding.tvNameUser.text = it[0]
                .name
                .capitalize()
                .trim()

            binding.tvHeightUser.text = context?.resources?.let { resources ->
                String.format(
                    resources.getString(R.string.your_height),
                    it[0].height.toString()
                )
            }


            binding.tvWeightUser.text = context?.resources?.let { resources ->
                String.format(
                    resources.getString(R.string.your_weight),
                    it[0].weight.toString()
                )
            }


        }

    }

    private fun calculateWater() {
        viewModel.userList.observe(viewLifecycleOwner) {

            binding.normalWaterOfWay.text = context?.resources?.let { waterMl ->
                String.format(
                    waterMl.getString(R.string.normal_water_of_day),
                    ((it[0].height - 100) * 35).toString()
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}