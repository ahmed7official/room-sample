package com.android.roomsample.ui.first

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.roomsample.data.local.User
import com.android.roomsample.data.repository.UsersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FirstViewModel(private val repository: UsersRepository) : ViewModel() {

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(user: User) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(user)
    }


}