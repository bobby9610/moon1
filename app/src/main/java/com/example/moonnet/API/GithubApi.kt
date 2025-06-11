package com.example.moonnet.API

import com.example.moonnet.models.Repo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {
    @GET("users/{user}/repos")
    fun getRepos(@Path("user") user: String): Call<List<Repo>>
}