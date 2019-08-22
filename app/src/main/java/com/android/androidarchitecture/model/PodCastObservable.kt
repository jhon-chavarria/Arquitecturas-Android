package com.android.androidarchitecture.model

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData

class PodCastObservable : BaseObservable() {

    private var podCastRepository: PodCastRepository = PodCastRepositoryImpl()

    // Repository
    fun callPodCastApi() : MutableLiveData<List<PodCast>>  {
        return podCastRepository.callPodCastsApi()
    }

    fun callPodCastNewApiApi() : MutableLiveData<List<PodCast>>  {
        return podCastRepository.callPodCastsNewListApi()
    }


    //ViewModel
    fun getPodCasts() : MutableLiveData<List<PodCast>> {
        return podCastRepository.getPodCasts()
    }
}