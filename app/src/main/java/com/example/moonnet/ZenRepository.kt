package com.example.moonnet.data

import com.example.moonnet.api.RetrofitProvider

class ZenRepository {
    private val api = RetrofitProvider.api

    suspend fun fetchZen(): Result<String> = try {
        Result.success(api.getZen())
    } catch (e: Exception) {
        Result.failure(e)
    }
}
