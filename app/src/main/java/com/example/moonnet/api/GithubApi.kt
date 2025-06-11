package com.example.moonnet.api

import retrofit2.Call
import retrofit2.http.GET

interface GithubApi {
    @GET("zen")
    fun getZen(): Call<String>
}

package com.example.moonnet.api

import retrofit2.http.GET

interface GithubApi {
    @GET("zen")
    suspend fun getZen(): String
}

