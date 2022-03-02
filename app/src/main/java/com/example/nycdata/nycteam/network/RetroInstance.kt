package com.example.rickymortydapr.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

public class RetroInstance {
    companion object {
        val baseURL = "https://data.cityofnewyork.us/"
        fun getRetroInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}