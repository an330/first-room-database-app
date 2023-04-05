package com.example.myfirstapp.auth


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil

import androidx.lifecycle.ViewModelProviders
import com.example.myfirstapp.R
import com.example.myfirstapp.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_home.*

private lateinit var viewModel: AuthViewmodel

class Login : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding:ActivityLoginBinding=DataBindingUtil.setContentView(this,R.layout.activity_login)
        viewModel=ViewModelProviders.of(this).get(AuthViewmodel::class.java)
        binding.setLifecycleOwner(this)
        binding.viewmodel=viewModel

        viewModel.signUpResult.observe(this) { result ->
            if (result) {
                // Start new activity

                val intent = Intent(this, DetailActivity::class.java)

                startActivity(intent)
            }
            else{
                Toast.makeText(this,"Invalid username or password",Toast.LENGTH_SHORT).show()
            }
        }


    }




}