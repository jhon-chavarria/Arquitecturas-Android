package com.android.androidarchitecture.view.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.android.androidarchitecture.R
import com.android.androidarchitecture.view.adapters.PodCastAdapter
import com.android.androidarchitecture.model.PodCast
import com.android.androidarchitecture.presenter.PodCastPresenter
import com.android.androidarchitecture.presenter.PodCastPresenterImpl
import com.android.androidarchitecture.view.PodCastView
import kotlinx.android.synthetic.main.activity_main.*



class PodCastListActivity : AppCompatActivity(), PodCastView {

    private lateinit var podCastPresenter: PodCastPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        podCastPresenter = PodCastPresenterImpl(this)

        getPodCasts()


        /*Handler().postDelayed( {
            podCastPresenter.getPodCastsNewList()
        }, 5000)*/
    }

    private fun fillAdapter(podCastList: List<PodCast>?) {
        with(rcViewPodCast) {
            layoutManager = GridLayoutManager(this@PodCastListActivity, 2)
            adapter = PodCastAdapter(podCastList, R.layout.item_podcast)
        }
    }

    override fun getPodCasts() {
        podCastPresenter.getPodCasts()
    }

    override fun showPodCasts(podCast: List<PodCast>?) {
        podCast?.let {
            fillAdapter(podCast)
        }
    }

}
