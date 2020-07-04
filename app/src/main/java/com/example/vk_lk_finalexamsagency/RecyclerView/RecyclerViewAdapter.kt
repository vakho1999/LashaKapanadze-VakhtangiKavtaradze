package com.example.vk_lk_finalexamsagency.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vk_lk_finalexamsagency.ItemModel.ItemModel
import com.example.vk_lk_finalexamsagency.R
import com.example.vk_lk_finalexamsagency.Second_Activity
import kotlinx.android.synthetic.main.recyclerview_layout.view.*

class RecyclerViewAdapter(private val items:ArrayList<ItemModel>, private val activity: Second_Activity):
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(
                parent.context).inflate(
                R.layout.recyclerview_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return items.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind()
    }
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        lateinit var model: ItemModel
        fun onBind(){
            model = items[adapterPosition]
            itemView.image.setImageResource(R.mipmap.fine)
            itemView.text1.text = model.protocolAuto
            itemView.text2.text = model.violationDate
            itemView.text3.text = model.lastDate
            itemView.text4.text = model.protocolPlace
            itemView.text5.text = model.protocolAmount
            itemView.text6.text = model.protocolNo
        }
    }
}