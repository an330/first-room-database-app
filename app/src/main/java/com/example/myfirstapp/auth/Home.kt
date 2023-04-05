package com.example.myfirstapp.auth

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "data")
data class Home(
    @PrimaryKey(autoGenerate = true)val id:Long=0,

    val firstName:String,
    val lastName:String,
    val age:String,
    val radio:Int
)