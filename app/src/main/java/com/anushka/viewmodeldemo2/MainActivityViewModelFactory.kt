package com.anushka.viewmodeldemo2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivityViewModelFactory(private val startingTotal: Int) : ViewModelProvider.Factory{

    // Used to construct custom ViewModels
    // Override method from ViewModel
    // Press ALT + Insert
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityModel::class.java)){
            return MainActivityModel(startingTotal) as T
        }
        throw IllegalArgumentException("Unknown View Model Class") // maybe wrong ??

    }
}