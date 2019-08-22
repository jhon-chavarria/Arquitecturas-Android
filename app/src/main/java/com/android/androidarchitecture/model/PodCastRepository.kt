package com.android.androidarchitecture.model

import androidx.lifecycle.MutableLiveData

interface PodCastRepository {
    fun getPodCasts(): MutableLiveData<List<PodCast>>
    fun callPodCastsApi(): MutableLiveData<List<PodCast>>
    fun callPodCastsNewListApi(): MutableLiveData<List<PodCast>>

}