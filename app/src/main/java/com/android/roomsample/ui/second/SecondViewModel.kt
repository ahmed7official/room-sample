package com.android.roomsample.ui.second

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.android.roomsample.data.local.User
import com.android.roomsample.data.repository.UsersRepository

class SecondViewModel(repository: UsersRepository) : ViewModel() {

    val allUsers: LiveData<List<User>> = repository.allWords

}