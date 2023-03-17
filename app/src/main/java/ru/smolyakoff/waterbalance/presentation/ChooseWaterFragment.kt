package ru.smolyakoff.waterbalance.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.smolyakoff.waterbalance.databinding.FragmentChooseWaterBinding
import ru.smolyakoff.waterbalance.domain.user.UserItem


class ChooseWaterFragment : Fragment() {


    private lateinit var viewModel: DataViewModel

    private var userItemId = UserItem.USER_ID


    private var _binding: FragmentChooseWaterBinding? = null
    private val binding: FragmentChooseWaterBinding
        get() = _binding ?: throw RuntimeException("FragmentChooseWaterBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseWaterBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel = ViewModelProvider(this)[DataViewModel::class.java]
        super.onViewCreated(view, savedInstanceState)
        getUserInfo()

    }
    private fun getUserInfo(){
        viewModel.userList.observe(viewLifecycleOwner) {
            binding.tvNameUser.text = it[0].name
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}