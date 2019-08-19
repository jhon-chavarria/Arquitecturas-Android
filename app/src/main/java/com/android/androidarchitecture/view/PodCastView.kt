package com.android.androidarchitecture.view

import com.android.androidarchitecture.model.PodCastBody

interface PodCastView {
    // View
    fun showPodCasts(podCast: PodCastBody)

    //Presenter
    fun getPodCasts()
}