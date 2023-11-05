package com.example.fragment_message_editor.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModel
import com.example.fragment_message_editor.R
import com.example.fragment_message_editor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val messageViewModel: MessageViewModel by viewModels()
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

        supportFragmentManager.addOnBackStackChangedListener {
            if (supportFragmentManager.backStackEntryCount == 0) {
                if (messageViewModel.isMessageModified)
                    messageViewModel.saveChanges()
            }
        }
    }
}