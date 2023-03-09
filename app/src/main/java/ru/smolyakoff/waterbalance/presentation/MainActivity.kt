package ru.smolyakoff.waterbalance.presentation


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import ru.smolyakoff.waterbalance.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding ?: throw RuntimeException("ActivityMainBinding is null")

    override fun onCreate(savedInstanceState: Bundle?) {

        _binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.buttonSavePersonData.setOnClickListener {
            addUser()
            startWaterActivity()
        }

    }

    private fun addUser() {

        val name = binding.etName.text.toString()
        val height = binding.etHeight.text.toString().toInt()
        val weight = binding.etWeight.text.toString().toInt()

        viewModel.addUser(name, height, weight)

    }


    private fun startWaterActivity(){
        val intent = Intent(Intent(this,WaterActivity::class.java))
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}