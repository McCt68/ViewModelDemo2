package com.anushka.viewmodeldemo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.anushka.viewmodeldemo2.databinding.ActivityMainBinding

// Continued from VIewModelDemo 2
// ADD implementation of LiveData
// I can use this design to make my trykberegner app work with viewModels, so it dont destroy
// when i switch to landscape mode

class MainActivity : AppCompatActivity() {

    // can delete just for test git branches
    val testLiveDta = "Test"

    //
    private lateinit var binding: ActivityMainBinding

    // Reference variable for view model object
    private lateinit var viewModel: MainActivityModel

    private lateinit var viewModelFactory: MainActivityViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModelFactory = MainActivityViewModelFactory(125)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainActivityModel::class.java)

        // I think I need this to not destroy when i turn phone
        // test it more, and try to understand why ??
        binding.tvResult.text = viewModel.getTotal().toString()

        binding.btnAdd.setOnClickListener {
            viewModel.setTotal(binding.etNumber.text.toString().toInt()) // input parameter
            binding.tvResult.text = viewModel.getTotal().toString()
        }


    }
}