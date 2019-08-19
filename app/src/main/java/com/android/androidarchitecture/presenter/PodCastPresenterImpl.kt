package com.android.androidarchitecture.presenter

import com.android.androidarchitecture.model.PodCastBody
import com.android.androidarchitecture.model.PodCastInteract
import com.android.androidarchitecture.model.PodCastInteractImpl
import com.android.androidarchitecture.view.PodCastView

class PodCastPresenterImpl(var podCastView: PodCastView) : PodCastPresenter {

    private var podCastInteract: PodCastInteract = PodCastInteractImpl(this)

    override fun getPodCasts() {
        podCastInteract.getPodCastsApi()
    }

    override fun showPodCasts(podCast: PodCastBody) {
        podCastView.showPodCasts(podCast)
    }

}