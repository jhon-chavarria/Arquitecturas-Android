package com.android.androidarchitecture.viewModel

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.androidarchitecture.R
import com.android.androidarchitecture.model.PodCast
import com.android.androidarchitecture.model.PodCastObservable
import com.android.androidarchitecture.view.adapters.PodCastAdapter
import com.squareup.picasso.Picasso

class PodCastViewModel : ViewModel() {
    private var podCastObservable: PodCastObservable = PodCastObservable()
    private var podCastAdapter: PodCastAdapter? = null

    // Repository
    fun callPodCastApi() {
        podCastObservable.callPodCastApi()
    }

    fun getPodCasts(): MutableLiveData<List<PodCast>> {
        return podCastObservable.getPodCasts()
    }


    fun getPodCastHeaderImage(position: Int): String {
        val podCastList: List<PodCast>? = podCastObservable.getPodCasts().value
        return podCastList?.get(position)?.urls?.banner_image?.original ?: ""
    }


    fun setRecyclerPodCastsAdapter(podCasList: List<PodCast>) {
        podCastAdapter?.setPodCastsList(podCasList)
        podCastAdapter?.notifyDataSetChanged()
    }

    fun getRecyclerPodCastsAdapter(): PodCastAdapter? {
        podCastAdapter = PodCastAdapter(this, R.layout.item_podcast)
        return podCastAdapter
    }

    fun getPodCastAt(position: Int): PodCast? {
        val podCastList: List<PodCast>? = podCastObservable.getPodCasts().value
        return podCastList?.get(position)
    }

}

@BindingAdapter("imageUrl")
fun getImagePodCastAt(imageHeader: ImageView, imageUrl: String) {
    if (imageUrl.isNotEmpty()) {
        Picasso.get()
            .load(imageUrl)
            .into(imageHeader)
    }
}