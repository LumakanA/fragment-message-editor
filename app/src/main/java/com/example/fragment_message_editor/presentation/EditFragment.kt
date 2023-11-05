package com.example.fragment_message_editor.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.fragment_message_editor.databinding.FragmentEditBinding

class EditFragment : Fragment() {
    private lateinit var binding: FragmentEditBinding
    private val messageViewModel: MessageViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditBinding.inflate(inflater, container, false)
            binding.buttonChange.setOnClickListener {
                val newMessage = binding.editTextMessage.text.toString()
                messageViewModel.setMessage(newMessage)
                parentFragmentManager.popBackStack()
            }
        return binding.root
    }
}