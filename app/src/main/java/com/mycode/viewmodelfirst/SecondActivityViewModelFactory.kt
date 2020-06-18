package com.mycode.viewmodelfirst

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class SecondActivityViewModelFactory(private val startingValue: Int): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SecondActivityViewModel::class.java)){
           return SecondActivityViewModel(startingValue) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }
}