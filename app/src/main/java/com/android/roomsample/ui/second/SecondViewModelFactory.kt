package com.android.roomsample.ui.second

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.roomsample.data.local.AppDatabase
import com.android.roomsample.data.repository.UsersRepository

class SecondViewModelFactory(private val application: Application) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        val appDatabase = AppDatabase.getDatabase(application)
        val repository = UsersRepository(appDatabase.userDao())

        return SecondViewModel(repository) as T
    }

}