package com.android.androidarchitecture.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.text.HtmlCompat
import com.android.androidarchitecture.R
import kotlinx.android.synthetic.main.view_detail.*

class PodCastDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pod_cast_detail)

        intent.extras?.let {
            val title = it.getString("title")
            val imageHeader = it.getString("imageHeader") ?: ""
            val description = it.getString("description") ?: ""

            //Glide.with(this).load(imageHeader).into(imgHeaderDetail)

            txtTitleDetail.text = title
            txtDetailLongDesc.text = HtmlCompat.fromHtml(description, HtmlCompat.FROM_HTML_MODE_LEGACY)
        }
    }
}
