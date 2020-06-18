package com.mycode.viewmodelfirst

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mycode.viewmodelfirst.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var count = 0
    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        /* binding.countText.text = viewModel.getCurrentCount().toString()
         binding.button.setOnClickListener {
             binding.countText.text = viewModel.getUpdatedCount().toString()
         }*/
        viewModel.count.observe(this, Observer {
            binding.countText.text = it.toString()
        })

        binding.button.setOnClickListener {
           viewModel.setUpdatedCount()
        }
    }
}
