package com.example.musicapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://deezerdevs-deezer.p.rapidapi.com/search?q=eminem/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIInterface::class.java)

        val retrofitData = retrofitBuilder.getData("eminem")

        retrofitData.enqueue(object : Callback<List<MusicData>?> {
            override fun onResponse(
                call: Call<List<MusicData>?>,
                response: Response<List<MusicData>?>
            ) {
                  //implement code that works on success of Api fetch

                val dataList = response.body()
                val textView = findViewById<TextView>(R.id.tv1)
                textView.text = dataList.toString()
                Log.d("Tag:OnResponse","onResponse:"+ response.body())
            }

            override fun onFailure(call: Call<List<MusicData>?>, t: Throwable) {

                //Implement code that is when no api connection is made
                Log.d("Tag:OnFailure","onFailure:"+ t.message )
            }
        })


    }
}