package com.example.rickymortydapr.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

public interface RetroService {

    @GET("resource/f9bf-2cp4.json")
     fun getDataFromNYCAPI(): Call<List<StudentData>>

     @GET("resource/f9bf-2cp4.json")
     suspend fun getDataFromAPI():List<StudentData>
}