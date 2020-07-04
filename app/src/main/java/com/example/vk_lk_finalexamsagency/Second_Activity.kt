package com.example.vk_lk_finalexamsagency

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vk_lk_finalexamsagency.DataLoader.CustomCallback
import com.example.vk_lk_finalexamsagency.DataLoader.Dataloader
import com.example.vk_lk_finalexamsagency.DataLoader.Serializer
import com.example.vk_lk_finalexamsagency.ItemModel.ItemModel
import com.example.vk_lk_finalexamsagency.RecyclerView.RecyclerViewAdapter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_second_.*


class Second_Activity : AppCompatActivity() {
    val items = ArrayList<ItemModel>()

    lateinit var adapter: RecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_)
        val intent = intent
        Dataloader.getRequest(intent!!.extras!!.getString("CarNumber","UY064YU"), object : CustomCallback {
            override fun onSuccess(result: String){


                val Serialized = Gson().fromJson(
                    result,
                    Serializer::class.java
                )
                items.add(
                    ItemModel(
                        Serialized.protocolAuto,
                        Serialized.violationDate,
                        Serialized.lastDate,
                        Serialized.protocolPlace,
                        Serialized.protocolAmount,
                        Serialized.protocolNo
                    )
                )

            }
        })

        adapter.notifyDataSetChanged()
        init()
    }
    private fun init(){
        adapter.notifyDataSetChanged()
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RecyclerViewAdapter(items,this)
        recyclerView.adapter = RecyclerViewAdapter(items,this)


        SecondButton.setOnClickListener(){
            OpenMainActivaty()
        }

    }
    private fun OpenMainActivaty(){

        setResult(Activity.RESULT_OK,intent)

        finish()
    }
}