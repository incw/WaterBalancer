package ru.smolyakoff.waterbalance.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import ru.smolyakoff.waterbalance.R
import ru.smolyakoff.waterbalance.databinding.ActivityWaterBinding

class WaterActivity : AppCompatActivity() {
    private lateinit var navController: NavController


    private var _binding: ActivityWaterBinding? = null
    private val binding: ActivityWaterBinding
        get() = _binding ?: throw RuntimeException("ActivityWaterBinding is null")

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        _binding = ActivityWaterBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        navController = navHostFragment.navController
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}