package com.android.roomsample.data.repository

import androidx.lifecycle.LiveData
import com.android.roomsample.data.local.User
import com.android.roomsample.data.local.UserDao

class UsersRepository(private val userDao: UserDao) {

    val allWords: LiveData<List<User>> = userDao.getAllUsers()

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    suspend fun insert(user: User) {
        userDao.insertUser(user)
    }


}