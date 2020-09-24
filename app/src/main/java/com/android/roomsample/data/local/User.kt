package com.android.roomsample.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "users")
data class User(


    @PrimaryKey
    @ColumnInfo(name = "user_id")
    val id: String = UUID.randomUUID().toString(),

    @ColumnInfo(name = "name")
    val name: String,


    @ColumnInfo(name = "age")
    val age: String,


    @ColumnInfo(name = "job")
    val job: String,


    @ColumnInfo(name = "gender")
    val gender: String


)