package com.example.musicapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface APIInterface {
    @Headers("X-RapidAPI-Key: 49b4460042msh448c60ba9217846p1075bdjsne0c158bdffd6",
    "X-RapidAPI-Host: deezerdevs-deezer.p.rapidapi.com")
    @GET("search")

    fun getData(@Query("q")query:String) : Call<List<MusicData>>
}