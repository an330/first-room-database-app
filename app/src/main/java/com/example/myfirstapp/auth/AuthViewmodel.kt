package com.example.myfirstapp.auth

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Intent
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class AuthViewmodel():ViewModel() {

    val username = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val signUpResult = MutableLiveData<Boolean>()
    val reset=MutableLiveData<Boolean>()

    fun signUp() {
        val userName = username.value
        val passWord = password.value
        if (userName.isNullOrEmpty()||passWord.isNullOrEmpty()){
            signUpResult.postValue(false)
            return
        }
        println("username is $userName")
        signUpResult.postValue(true)

    }
    fun reset(){
        val username = username.postValue("")
        val password = password.postValue("")
        reset.postValue(true)
    }

}