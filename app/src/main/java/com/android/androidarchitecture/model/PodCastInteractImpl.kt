package com.android.androidarchitecture.model


import com.android.androidarchitecture.presenter.PodCastPresenter

/**
 * Jonathan Chavarria
 */
class PodCastInteractImpl(podCastPresenter: PodCastPresenter) : PodCastInteract {

    private val podCastRepository: PodCastRepository = PodCastRepositoryImpl(podCastPresenter)

    override fun getPodCastsApi() {
        podCastRepository.getPodCastsApi()
    }

    override fun getPodCastsNewList() {
        podCastRepository.getPodCastsNewList()
    }

}