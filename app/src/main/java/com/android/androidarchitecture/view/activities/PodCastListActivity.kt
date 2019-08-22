package com.android.androidarchitecture.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.androidarchitecture.R
import com.android.androidarchitecture.databinding.ActivityMainBinding
import com.android.androidarchitecture.viewModel.PodCastViewModel

class PodCastListActivity : AppCompatActivity() {

    private var podCastViewModel: PodCastViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBindings()
    }

    private fun setupBindings() {
        val activityMainBinding: ActivityMainBinding
                = DataBindingUtil.setContentView(this, R.layout.activity_main)

        podCastViewModel = ViewModelProviders.of(this).get(PodCastViewModel::class.java)

        activityMainBinding.model = podCastViewModel

        podCastViewModel?.getPodCasts()?.observe(this, Observer {
            podCastViewModel?.setRecyclerPodCastsAdapter(it)
        })

        setupListClick()
    }

    private fun setupListClick() {
        podCastViewModel?.getPodCastSelected()?.observe(this,
            Observer {
                with(it) {
                    val intent = Intent(this@PodCastListActivity, PodCastDetailActivity::class.java)
                    intent.putExtra("title", title)
                    intent.putExtra("description", formatted_description)
                    intent.putExtra("imageHeader", urls?.banner_image?.original)
                    startActivity(intent)
                }
            })
    }

    fun updateMutableList() {
        podCastViewModel?.updateMutableList()

    }
}
