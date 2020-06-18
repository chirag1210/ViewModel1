package com.mycode.viewmodelfirst

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondActivityViewModel(startingTotal: Int) : ViewModel() {

    private var count = MutableLiveData<Int>()
    val totalData: MutableLiveData<Int>
        get() = count

    init {
        count.value = startingTotal
    }

    fun setValue(enteredValue: Int) {
        // count +=enteredValue
        count.value = count.value?.plus(enteredValue)
    }
}