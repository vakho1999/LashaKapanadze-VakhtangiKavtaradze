package com.example.vk_lk_finalexamsagency

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }


    private fun init() {

        search.setOnClickListener() {
            OpenSecondActivity()


        }
    }
    private fun OpenSecondActivity(){
        val intent = Intent(this,Second_Activity::class.java)
        intent.putExtra("CarNumber",carN_2.text.toString())
        startActivityForResult(intent,1)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }
}