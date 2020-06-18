package com.mycode.viewmodelfirst

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mycode.viewmodelfirst.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var viewModel: SecondActivityViewModel
    private lateinit var viewModelFactory: SecondActivityViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_second)

        viewModelFactory = SecondActivityViewModelFactory(100)

        viewModel =
            ViewModelProvider(this, viewModelFactory).get(SecondActivityViewModel::class.java)

        viewModel.totalData.observe(this, Observer {
            binding.textView.text = it.toString()
        })

        binding.btnAdd.setOnClickListener {
            viewModel.setValue(binding.edInputValue.text.toString().toInt())
        }
    }
}