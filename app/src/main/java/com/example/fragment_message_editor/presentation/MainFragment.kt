package com.example.fragment_message_editor.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.fragment_message_editor.R
import com.example.fragment_message_editor.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.buttonNext.setOnClickListener {
            parentFragmentManager.commit {
                val editFragment = EditFragment()
                replace(R.id.fragmentContainerView, editFragment)
                addToBackStack(null)
            }
        }
        return binding.root
    }
}