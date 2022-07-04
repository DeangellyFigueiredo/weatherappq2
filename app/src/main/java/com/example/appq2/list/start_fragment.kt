package com.example.appq2.list

import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.appq2.NetworkUtils
import com.example.appq2.R
import com.example.appq2.WheaterViewModel
import com.example.appq2.api.Endpoint
import com.example.appq2.data.Wheater
import com.example.appq2.models.ResponseWheater
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*


class start_fragment : Fragment() {

    private lateinit var mWheaterViewModel : WheaterViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_start_fragment, container, false)


        view.findViewById<FloatingActionButton>(R.id.floatingActionButton).setOnClickListener{
            findNavController().navigate(R.id.list_fragment)
        }


        mWheaterViewModel = ViewModelProvider(this)[WheaterViewModel::class.java]


        val editText : EditText = view.findViewById(R.id.search_option)
        editText.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {

                getCurrencieslocal(editText.text.toString(),view)
                editText.setText("")
                editText.hint = "   Search your City"
                return@OnKeyListener true
            }
            false
        })
        return view


    }


    fun getCurrencieslocal( local : String, view : View){
        val retrofitClient = NetworkUtils.getRetrofitInstance("https://api.openweathermap.org")
        val endpoint = retrofitClient.create(Endpoint::class.java)


        endpoint.getCurrencieslocal(local).enqueue(object : Callback<ResponseWheater> {
            override fun onResponse(
                call: Call<ResponseWheater>,
                response: Response<ResponseWheater>
            ) {

                if(response.body() != null){
                var wheaterData : ResponseWheater = response.body() as ResponseWheater


                    view.findViewById<TextView>(R.id.temperature_txt).text =
                        String.format("%.0f", wheaterData.main.temp) + "°C"
                    view.findViewById<TextView>(R.id.location_txt).text = wheaterData.name
                    view.findViewById<TextView>(R.id.sky_behaviour_txt).text =
                        wheaterData.weather[0].main
                    val feelsLike: String =
                        "Feels like: " + String.format("%.0f", wheaterData.main.feels_like) + "°c"
                    view.findViewById<TextView>(R.id.sensation_txt).text = feelsLike
                    val tempMaxMin: String = "Max. " + String.format(
                        "%.0f",
                        wheaterData.main.temp_max
                    ) + "°c Min. " + String.format("%.0f", wheaterData.main.temp_min) + "°c"
                    view.findViewById<TextView>(R.id.temperature_max_mid_txt).text = tempMaxMin
                    val sdf = SimpleDateFormat("EEE, d MMM yyyy HH:mm")
                    val currentDate = sdf.format(Date())
                    view.findViewById<TextView>(R.id.date_text).text = currentDate

                    insertDataToDataBase(
                        wheaterData.main.temp,
                        wheaterData.name,
                        wheaterData.weather[0].main,
                        wheaterData.main.temp_max,
                        wheaterData.main.temp_min,
                        wheaterData.main.feels_like,
                        currentDate
                    )
                }else{

                    Toast.makeText(context,"Cidade não encontrada",Toast.LENGTH_SHORT).show()
                }

            }

            override fun onFailure(call: Call<ResponseWheater>, t: Throwable) {
                Toast.makeText(context,"Por favor, tente novamente",Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun insertDataToDataBase(temp : Double,local: String,sky : String, temp_max: Double, temp_min : Double,feels_like:Double, date:String){
        val wheater = Wheater(0,temp,local,sky,temp_max, temp_min, feels_like, date)

        mWheaterViewModel.addWheater(wheater)

    }

}