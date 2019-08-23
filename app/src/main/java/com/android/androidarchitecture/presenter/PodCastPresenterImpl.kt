package com.android.androidarchitecture.presenter


import com.android.androidarchitecture.model.PodCast
import com.android.androidarchitecture.model.PodCastInteract
import com.android.androidarchitecture.model.PodCastInteractImpl
import com.android.androidarchitecture.view.PodCastView

/**
 * Jonathan Chavarria
 */
class PodCastPresenterImpl(var podCastView: PodCastView) : PodCastPresenter {

    private var podCastInteract: PodCastInteract = PodCastInteractImpl(this)

    override fun getPodCasts() {
        podCastInteract.getPodCastsApi()
    }

    override fun getPodCastsNewList() {
        podCastInteract.getPodCastsNewList()
    }


    override fun showPodCasts(podCast: List<PodCast>?) {
        podCastView.showPodCasts(podCast)
    }

}