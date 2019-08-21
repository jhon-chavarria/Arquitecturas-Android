package com.android.androidarchitecture.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.android.androidarchitecture.model.api.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PodCastRepositoryImpl: PodCastRepository {

    private var podCasts = MutableLiveData<List<PodCast>>()

    override fun getPodCasts() : MutableLiveData<List<PodCast>> {
        return podCasts
    }

    override fun callPodCastsApi() {
        val call = ApiClient.getPodCastInterface().getPodCasts()
        call.enqueue(object : Callback<PodCastBody> {
            override fun onResponse(call: Call<PodCastBody>, response: Response<PodCastBody>) {
                response.body()?.let {
                    podCasts.value = it.body
                }
            }

            override fun onFailure(call: Call<PodCastBody>, t: Throwable) {
                Log.e("ERROR: ", t.message)
            }
        })
    }

}