package ru.smolyakoff.waterbalance.presentation


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.smolyakoff.waterbalance.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding ?: throw RuntimeException("ActivityMainBinding == null")

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

    }
}