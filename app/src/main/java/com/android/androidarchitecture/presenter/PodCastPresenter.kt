package com.android.androidarchitecture.presenter

import com.android.androidarchitecture.model.PodCast

interface PodCastPresenter {
    // View
    fun showPodCasts(podCast: List<PodCast>?)

    // Interact
    fun getPodCasts()
}