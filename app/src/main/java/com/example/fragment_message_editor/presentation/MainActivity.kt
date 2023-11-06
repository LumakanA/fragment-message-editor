package com.example.fragment_message_editor.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.fragment_message_editor.R
import com.example.fragment_message_editor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                val mainFragment = MainFragment()
                setReorderingAllowed(true)
                add(R.id.fragmentContainerView, mainFragment)
            }
        }
    }
}