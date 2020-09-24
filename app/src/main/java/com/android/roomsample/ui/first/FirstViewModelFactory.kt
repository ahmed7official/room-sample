package com.android.roomsample.ui.first

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.roomsample.data.local.AppDatabase
import com.android.roomsample.data.repository.UsersRepository

class FirstViewModelFactory(private val application: Application) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        val appDatabase = AppDatabase.getDatabase(application)
        val repository = UsersRepository(appDatabase.userDao())

        return FirstViewModel(repository) as T
    }

}