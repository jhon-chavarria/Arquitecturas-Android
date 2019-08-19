package com.android.androidarchitecture.model.api


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val API_CLIENT = "http://api.audioboom.com/"

    fun getPodCastInterface(): ClientInterface {
        val retrofit = Retrofit.Builder()
            .baseUrl(API_CLIENT)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(ClientInterface::class.java)
    }
}