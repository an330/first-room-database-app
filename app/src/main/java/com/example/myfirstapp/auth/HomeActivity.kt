package com.example.myfirstapp.auth


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.room.Room
import com.example.myfirstapp.R

class HomeActivity : AppCompatActivity() {
    @SuppressLint("Range", "MissingInflatedId")
    //lateinit var database: MydbHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val Agee=intent.getStringExtra("age")
        val Lastname=intent.getStringExtra("Lastname")
        var Firstname=intent.getStringExtra("Firstname")
        var printName=findViewById<Button>(R.id.printName)
        var fname=findViewById<TextView>(R.id.Name)
        //var lname=findViewById<TextView>(R.id.lastname1)
        //var delete=findViewById<Button>(R.id.delete)
        //var Age=findViewById<TextView>(R.id.age1)

        //val tv_firstname=findViewById<TextView>(R.id.firstname)
        //val tv_age=findViewById<TextView>(R.id.age)
        //val tv_lastname=findViewById<TextView>(R.id.lastname)
        //tv_lastname.setText(lastname)
        //tv_firstname.setText(firstname)
        //tv_age.setText(age)
        /*val dbhelper:MydbHelper= MydbHelper(this, null)
        if (firstname != null) {
            if (lastname != null) {
                if (age != null) {
                    dbhelper.addData(firstname, lastname,age)
                }
            }
        }
        delete.setOnClickListener{
            val db=dbhelper.writableDatabase
            db.execSQL("DELETE FROM data")
        }
        printName.setOnClickListener{

            // creating a DBHelper class
            // and passing context to it
            val db = MydbHelper(this, null)

            // below is the variable for cursor
            // we have called method to get
            // all names from our database
            // and add to name text view
            val cursor = db.getName()

            // moving the cursor to first position and
            // appending value in the text view
            if (cursor != null && cursor.getCount() != 0) {
                cursor!!.moveToFirst()
                fname.append(cursor.getString(cursor.getColumnIndex(MydbHelper.KEY_NAME)) + "\n")
                lname.append(cursor.getString(cursor.getColumnIndex(MydbHelper.KEY_LASTNAME)) + "\n")
                Age.append(cursor.getString(cursor.getColumnIndex(MydbHelper.KEY_AGE)) + "\n")
            }

            // moving our cursor to next
            // position and appending values
            while(cursor!!.moveToNext()){
                fname.append(cursor.getString(cursor.getColumnIndex(MydbHelper.KEY_NAME)) + "\n")
                lname.append(cursor.getString(cursor.getColumnIndex(MydbHelper.KEY_LASTNAME)) + "\n")
                Age.append(cursor.getString(cursor.getColumnIndex(MydbHelper.KEY_AGE)) + "\n")
            }

            // at last we close our cursor
            cursor?.close()
        }*/

        val database=MydbHelper.getDatabase(this)
        val user = Home(firstName = "$Firstname", lastName = "$Lastname", age = "$Agee", radio = 1)
        database.homeDao().insert(user)


        //val users = database.homeDao().getAll()
        fun printTable() {
            val dao = database.homeDao()
            val entities = dao.getAll()
            val stringBuilder = StringBuilder()
            for(entity in entities) {
                stringBuilder.append(entity.id).append(entity.firstName).append(entity.lastName).append("  ").append(entity.age).append("  ").append(entity.radio).append("\n")
            }
            fname.text=stringBuilder.toString()
            /*lname.text=stringBuilder.toString()
            Age.text=stringBuilder.toString()*/

        }

// Step 6: Bind the function to the click event of a button

        printName.setOnClickListener {
            printTable()
        }









    }
}

