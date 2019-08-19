package com.android.androidarchitecture.presenter

import com.android.androidarchitecture.model.PodCastBody

interface PodCastPresenter {
    // View
    fun showPodCasts(podCast: PodCastBody)

    // Interact
    fun getPodCasts()
}