package com.example.fragment_message_editor.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragment_message_editor.databinding.FragmentEditBinding


class EditFragment : Fragment() {
    private lateinit var binding: FragmentEditBinding
    private var buttonClicked = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val message = arguments?.getString("message") ?: "Сообщение"
        binding.editTextMessage.setText(message)

        binding.buttonChange.setOnClickListener {
            buttonClicked = true
            val updatedMessage = binding.editTextMessage.text.toString()

            val mainFragment =
                parentFragmentManager.fragments.firstOrNull { it is MainFragment } as? MainFragment
            mainFragment?.updateMessage(updatedMessage)

            parentFragmentManager.popBackStack()
        }
    }

    override fun onPause() {
        super.onPause()
        if (buttonClicked) {
            val updatedMessage = binding.editTextMessage.text.toString()
            val mainFragment =
                parentFragmentManager.fragments.firstOrNull { it is MainFragment } as? MainFragment
            mainFragment?.updateMessage(updatedMessage)
        }
    }
}