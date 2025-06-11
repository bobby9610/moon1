package com.example.moonnet.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitProvider {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.example.com/")  // ✅ Use the correct API base URL
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: ZenAPI = retrofit.create(ZenAPI::class.java)  // ✅ Ensure ZenAPI is correctly created
}
