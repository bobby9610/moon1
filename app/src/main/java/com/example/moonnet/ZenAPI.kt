package com.example.moonnet.API

import retrofit2.Call
import retrofit2.http.GET

interface ZenAPI {
    @GET("zen")
    fun getZenQuote(): Call<String>
}
