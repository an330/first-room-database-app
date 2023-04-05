package com.example.myfirstapp.auth

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface HomeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(home: Home)

    @Query("SELECT * FROM data")
    fun getAll(): List<Home>
}