package com.android.androidarchitecture.view

import com.android.androidarchitecture.model.PodCast

interface PodCastView {
    // View
    fun showPodCasts(podCast: List<PodCast>?)

    //Presenter
    fun getPodCasts()
}