package com.android.androidarchitecture.view.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import com.android.androidarchitecture.R
import com.android.androidarchitecture.view.adapters.PodCastAdapter
import com.android.androidarchitecture.model.PodCast
import com.android.androidarchitecture.model.PodCastBody
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
    }

    /*private fun getPodCastList() {
        val call = ApiClient.getPodCastInterface().getPodCasts()
        call.enqueue(object : Callback<PodCastBody> {
            override fun onResponse(call: Call<PodCastBody>, response: Response<PodCastBody>) {
                response.body()?.let {
                    fillAdapter(it.body)
                }
            }

            override fun onFailure(call: Call<PodCastBody>, t: Throwable) {
                Log.e("ERROR: ", t.message)
            }
        })
    }*/

    private fun fillAdapter(podCastList: List<PodCast>?) {
        //with(rcViewPodCast) {
          //  layoutManager = GridLayoutManager(this@PodCastListActivity, 2)
            //PodCastAdapter(podCastList, R.layout.item_podcast)
        //}
        rcViewPodCast.layoutManager = GridLayoutManager(this, 2)
        rcViewPodCast.adapter = PodCastAdapter(podCastList, R.layout.item_podcast)
    }

    override fun getPodCasts() {
        podCastPresenter.getPodCasts()
    }

    override fun showPodCasts(podCast: PodCastBody) {
        podCast.body?.let {
            fillAdapter(podCast.body)
        }
    }

}
