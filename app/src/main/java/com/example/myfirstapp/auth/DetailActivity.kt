package com.example.myfirstapp.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.NumberPicker
import android.widget.TextView
import androidx.core.view.isInvisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.myfirstapp.R
import com.example.myfirstapp.databinding.ActivityDetailBinding
import com.example.myfirstapp.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_detail.view.*
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_home.view.*

lateinit var Age:String
class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityDetailBinding = DataBindingUtil.setContentView(this,R.layout.activity_detail)
        val viewModel= ViewModelProviders.of(this).get(DetailViewmodel::class.java)
        binding.setLifecycleOwner(this)
        binding.detailviewmodel=viewModel

        viewModel.numberResult.observe(this) { result ->
            if (result) {

                    numberpicker.minValue=1
                    numberpicker.maxValue=60

                println("${numberpicker.value}")
                 Age=numberpicker.value.toString()

            }
            else{
                return@observe
            }
        }
        viewModel.radioResult.observe(this){result->
            if(result){
                if (radioM.isEnabled){
                    radioF.setEnabled(false)
                }

                //radioF.isEnabled
                //radioM.isEnabled
                println("${radioM.text}")
                println("${radioF.text}")
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("age",Age)
                intent.putExtra("Firstname",et_firstname.text.toString())
                intent.putExtra("Lastname",et_lastname.text.toString())
                intent.putExtra("gender",radioM.text)
                startActivity(intent)
            }
        }

    }
}