package com.example.myfirstapp.auth

import android.widget.NumberPicker
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.android.synthetic.main.activity_detail.*
import java.time.temporal.ValueRange
import java.util.function.BooleanSupplier


class DetailViewmodel: ViewModel() {
    val firstname= MutableLiveData<String>()
    val lastname= MutableLiveData<String>()
    var numberPicker=MutableLiveData<Int>()
    var radio=MutableLiveData<Boolean>()
    val numberResult=MutableLiveData<Boolean>()
    val radioResult=MutableLiveData<Boolean>()


    fun setNumber(){

        numberResult.postValue(true)
    }
    fun setButton(){
        val first=firstname.value
        val last=lastname.value
        if (first.isNullOrEmpty()||last.isNullOrEmpty()){
            return
        }
        radioResult.postValue(true)
    }
}