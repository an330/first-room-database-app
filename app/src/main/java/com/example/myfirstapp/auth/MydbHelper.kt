package com.example.myfirstapp.auth

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

/*
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.security.spec.PSSParameterSpec.DEFAULT

class MydbHelper(context: Context, nothing: Nothing?): SQLiteOpenHelper(context,"FORMA",null,23) {
    companion object{
        const val KEY_ID="id"
        const val KEY_NAME="firstname"
        const val KEY_LASTNAME="lastname"
        const val TABLE_NAME="dataa"
        const val KEY_AGE="age"
    }
    override fun onCreate(db: SQLiteDatabase?) {
        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + KEY_ID + " INTEGER PRIMARY KEY, " +
                KEY_NAME + " TEXT," +
                KEY_LASTNAME + " TEXT ," +
                 KEY_AGE + " TEXT, " + ")")
         db?.execSQL(query)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        */
/*if(newVersion>oldVersion) {
            db?.execSQL("ALTER TABLE TABLE_NAME ADD COLUMN KEY_AGE TEXT")
        }*//*

        db?.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME )
        //onCreate(db)
        */
/*if(newVersion>oldVersion) {
            val sql = "ALTER TABLE data ADD COLUMN KEY_AGg INTEGER DEFAULT 1"
            db?.execSQL(sql)
        }*//*

        onCreate(db)

    }
    fun addData(firstname:String,lastname:String,age:String){
        var db:SQLiteDatabase=this.writableDatabase
        var values:ContentValues= ContentValues()
        values.put(KEY_NAME,firstname)
        values.put(KEY_LASTNAME,lastname)
        values.put(KEY_AGE,age)
        db.insert(TABLE_NAME,null,values)
        db.close()
    }
    fun getName(): Cursor? {

        // here we are creating a readable
        // variable of our database
        // as we want to read value from it
        val db = this.readableDatabase

        // below code returns a cursor to
        // read data from the database
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null)

    }
}*/
@Database(entities = [Home::class], version = 45)
abstract class MydbHelper : RoomDatabase(){
    abstract fun homeDao():HomeDao
    companion object{
        val migration_44_45=object :Migration(44,45){
            override fun migrate(database: SupportSQLiteDatabase) {
               database.execSQL("ALTER TABLE data ADD COLUMN radio INTEGER NOT NULL DEFAULT(1)")
            }

        }
        @Volatile
        private var instance:MydbHelper?=null
        fun getDatabase(context: Context):MydbHelper{
            if (instance==null){
                synchronized(this){
                    instance=Room.databaseBuilder(context.applicationContext,
                        MydbHelper::class.java,
                        "DATTA").allowMainThreadQueries().addMigrations(migration_44_45).build()
                }

            }
            return instance!!
        }
    }
}