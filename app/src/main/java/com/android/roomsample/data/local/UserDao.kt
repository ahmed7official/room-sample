package com.android.roomsample.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Data Access Object for the users table.
 */
@Dao
interface UserDao {

    /**
     * Get a all user.
     * @return all users from the table.
     */
    @Query("SELECT * FROM Users")
    fun getAllUsers(): LiveData<List<User>>


    /**
     * Insert a user in the database. If the user already exists, replace it.
     * @param user the user to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)


    /**
     * Delete all users.
     */
    @Query("DELETE FROM Users")
    fun deleteAllUsers()
}