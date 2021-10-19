package com.anushka.viewmodeldemo2

import androidx.lifecycle.ViewModel

// making a ViewModel class, it inherent from the class ViewModel
// creating a class with a constructor startingTotal of type Int
class MainActivityModel(startingTotal: Int) : ViewModel(){

    private var total = 0

    // init block will run when a object is created with the value passed via the constructor (startingTotal)
    init {
        total = startingTotal
    }

    fun getTotal(): Int{
        return total
    }

    fun setTotal(input: Int){
        total +=input
    }
}