package com.android.androidarchitecture.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.androidarchitecture.R
import com.android.androidarchitecture.databinding.ActivityMainBinding
import com.android.androidarchitecture.view.adapters.PodCastAdapter
import com.android.androidarchitecture.model.PodCast
import com.android.androidarchitecture.viewModel.PodCastViewModel
import kotlinx.android.synthetic.main.activity_main.*

class PodCastListActivity : AppCompatActivity() {

    private lateinit var podCastViewModel: PodCastViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBindings(savedInstanceState)

    }

    private fun setupBindings(savedInstanceState: Bundle?){
        val activityMainBinding: ActivityMainBinding
                = DataBindingUtil.setContentView(this, R.layout.activity_main)

        podCastViewModel = ViewModelProviders.of(this).get(PodCastViewModel::class.java)

        activityMainBinding.model = podCastViewModel
        //setupListUpdate()

        //CallCoupons
        podCastViewModel.callPodCastApi()

        podCastViewModel.getPodCasts().observe(this, Observer {
            println("Entro ${it[0].title}")
            //Log.w("COUPON", coupons.get(0).title)
            //couponViewModel?.setCouponsInRecyclerAdapter(coupons)
            podCastViewModel.setRecyclerPodCastsAdapter(it)
        })


    }

    private fun fillAdapter(podCastList: List<PodCast>?) {
        with(rcViewPodCast) {
            //layoutManager = androidx.recyclerview.widget.GridLayoutManager(this@PodCastListActivity, 2)
            //adapter = PodCastAdapter(podCastList, R.layout.item_podcast)
        }
    }


}
