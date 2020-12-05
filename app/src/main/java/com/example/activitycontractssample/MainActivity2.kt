package com.example.activitycontractssample

import android.R.attr
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.example.activitycontractssample.databinding.ActivityMain2Binding


class MainActivity2 : Activity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        binding.text.setOnClickListener {
            val intent = Intent().apply {
                putExtra("output_string", "value_here")
            }
            setResult(RESULT_OK, intent);
            finish()
        }
        setContentView(binding.root)
    }

}