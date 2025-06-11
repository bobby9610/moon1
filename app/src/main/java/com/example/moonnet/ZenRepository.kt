package com.example.moonnet.data

import android.util.Log
import com.example.moonnet.API.RetrofitProvider
import java.io.IOException

class ZenRepository {
    private val api = RetrofitProvider.api  // ✅ Ensure API instance exists

    fun fetchZenQuote(): Result<String> {
        return try {
            val response = api.getZenQuote().execute()  // ✅ Correct API call

            if (!response.isSuccessful) {
                Log.e("ZenRepository", "API error: ${response.code()}")
                return Result.failure(Exception("Error: ${response.code()}"))
            }

            response.body()?.let {
                Result.success(it)
            } ?: Result.failure(Exception("Empty response from server"))

        } catch (e: IOException) {
            Log.e("ZenRepository", "Network error", e)
            Result.failure(e)
        }  // ✅ The catch block should **end** here

    }

    fun fetchZen(): Result<String> {
        return fetchZenQuote()  // ✅ Correct placement, outside of `catch`
    }
}
