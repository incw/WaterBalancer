package ru.smolyakoff.waterbalance.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.smolyakoff.waterbalance.R
import ru.smolyakoff.waterbalance.databinding.FragmentContainerBinding


class ContainerFragment : Fragment() {

    private var _binding: FragmentContainerBinding? = null
    private val binding: FragmentContainerBinding
        get() = _binding ?: throw RuntimeException("FragmentContainerBinding == null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{

        _binding = FragmentContainerBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.bottom_bar)
        val navController = (childFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment )
            .navController
        NavigationUI.setupWithNavController(bottomNavigationView,navController)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}