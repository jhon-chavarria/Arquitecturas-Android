package com.android.androidarchitecture.model


import android.util.Log
import com.android.androidarchitecture.model.api.ApiClient
import com.android.androidarchitecture.presenter.PodCastPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Jonathan Chavarria
 */
class PodCastRepositoryImpl(val podCastPresenter: PodCastPresenter): PodCastRepository {

    override fun getPodCastsApi() {
        val call = ApiClient.getPodCastInterface().getPodCasts()
        call.enqueue(object : Callback<PodCastBody> {
            override fun onResponse(call: Call<PodCastBody>, response: Response<PodCastBody>) {
                response.body()?.let {
                    podCastPresenter.showPodCasts(it.body)
                }
            }

            override fun onFailure(call: Call<PodCastBody>, t: Throwable) {
                Log.e("ERROR: ", t.message)
            }
        })
    }

    override fun getPodCastsNewList() {
        val call = ApiClient.getPodCastInterface().getPodCastsNewList()
        call.enqueue(object : Callback<PodCastBody> {
            override fun onResponse(call: Call<PodCastBody>, response: Response<PodCastBody>) {
                response.body()?.let {
                    podCastPresenter.showPodCasts(it.body)
                }
            }

            override fun onFailure(call: Call<PodCastBody>, t: Throwable) {
                Log.e("ERROR: ", t.message)
            }
        })
    }

}