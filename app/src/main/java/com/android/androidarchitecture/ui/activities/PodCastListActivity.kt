package com.android.androidarchitecture.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import com.android.androidarchitecture.R
import com.android.androidarchitecture.adapters.PodCastAdapter
import com.android.androidarchitecture.api.ApiClient
import com.android.androidarchitecture.model.PodCast
import com.android.androidarchitecture.model.PodCastBody
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PodCastListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getPodCastList()
    }

    private fun getPodCastList() {
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
    }

    private fun fillAdapter(podCastList: List<PodCast>?) {
        with(rcViewPodCast) {
            layoutManager = GridLayoutManager(this@PodCastListActivity, 2)
            adapter = PodCastAdapter(podCastList, R.layout.item_podcast)
        }
    }

    /*private fun getDataFromLocal() {
        val jsonString =  readStream(resources.openRawResource(R.raw.data))
        val testModel = Gson().fromJson(jsonString, PodCastBody::class.java)
        fillAdapter(testModel.body)
    }


    private fun readStream(`is`: InputStream): String {
        val s = Scanner(`is`).useDelimiter("\\A")
        return if (s.hasNext()) s.next() else ""
    }*/
}
