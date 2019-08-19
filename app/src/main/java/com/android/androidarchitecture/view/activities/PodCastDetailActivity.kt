package com.android.androidarchitecture.view.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.text.HtmlCompat
import com.android.androidarchitecture.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_pod_cast_detail.*
import kotlinx.android.synthetic.main.view_detail.*

class PodCastDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pod_cast_detail)

        intent.extras?.let {
            val title = it.getString("title")
            val imageHeader = it.getString("imageHeader") ?: ""
            val description = it.getString("description") ?: ""

            Glide.with(this).load(imageHeader).into(imgHeaderDetail)

            txtTitleDetail.text = title
            txtDetailLongDesc.text = HtmlCompat.fromHtml(description, HtmlCompat.FROM_HTML_MODE_LEGACY)
        }
    }
}
