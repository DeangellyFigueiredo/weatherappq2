package com.example.appq2.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.appq2.R
import com.example.appq2.data.Wheater
import java.text.SimpleDateFormat
import java.util.*

class ListAdapter : RecyclerView.Adapter<com.example.appq2.list.ListAdapter.MyViewHolder>() {


     private var weatherList = emptyList<Wheater>()
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_item,parent,false))
     }

     override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
         val currentItem = weatherList[position]
         holder.itemView.findViewById<TextView>(R.id.temperature_txt).text = currentItem.temp.toString()

         holder.itemView.findViewById<TextView>(R.id.temperature_txt).text = String.format("%.0f", currentItem.temp) +"°C"
         holder.itemView.findViewById<TextView>(R.id.location_txt).text = currentItem.local
         holder.itemView. findViewById<TextView>(R.id.sky_behaviour_txt).text = currentItem.sky
         val feelsLike : String = "Feels like: " + String.format("%.0f",currentItem.feels_like) +"°c"
         holder.itemView.findViewById<TextView>(R.id.sensation_txt).text = feelsLike
         val tempMaxMin : String = "Max. " + String.format("%.0f",currentItem.temp_max) + "°c Min. " +String.format("%.0f",currentItem.temp_min) +"°c"
         holder.itemView.findViewById<TextView>(R.id.temperature_max_mid_txt).text = tempMaxMin

         holder.itemView.findViewById<TextView>(R.id.date_text).text = currentItem.date
     }

    fun setData(wheater: List<Wheater>){
        this.weatherList = wheater
        notifyDataSetChanged()

    }
     override fun getItemCount(): Int {
        return  weatherList.size
     }

 }