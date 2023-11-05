package com.example.fragment_message_editor.presentation

import androidx.lifecycle.ViewModel

class MessageViewModel : ViewModel() {
    private var message: String = ""
    var isMessageModified: Boolean = false

    fun setMessage(newMessage: String) {
        message = newMessage
        isMessageModified = true
    }

    fun saveChanges() {
        isMessageModified = false
    }
}
