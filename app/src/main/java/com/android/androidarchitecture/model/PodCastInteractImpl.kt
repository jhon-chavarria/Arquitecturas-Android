package com.android.androidarchitecture.model

import com.android.androidarchitecture.presenter.PodCastPresenter

class PodCastInteractImpl(podCastPresenter: PodCastPresenter) : PodCastInteract {

    private val podCastRepository: PodCastRepository = PodCastRepositoryImpl(podCastPresenter)

    override fun getPodCastsApi() {
        podCastRepository.getPodCastsApi()
    }

}