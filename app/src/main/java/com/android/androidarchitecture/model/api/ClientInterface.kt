package com.android.androidarchitecture.model.api

import com.android.androidarchitecture.model.PodCastBody
import retrofit2.http.GET
import retrofit2.Call


interface ClientInterface {
    @GET("channels/recommended")
    fun getPodCasts(): Call<PodCastBody>

    @GET("channels/recommended?category_ids[]=205")
    fun getPodCastsNewList(): Call<PodCastBody>

}
