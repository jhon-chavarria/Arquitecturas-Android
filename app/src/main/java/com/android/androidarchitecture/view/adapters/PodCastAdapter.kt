package com.android.androidarchitecture.view.adapters

import android.app.Activity
import android.content.Intent
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.support.v4.util.Pair
import com.android.androidarchitecture.model.PodCast
import com.android.androidarchitecture.view.activities.PodCastDetailActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_podcast.view.*

class PodCastAdapter(private var podCastList : List<PodCast>?, private var resource: Int) : RecyclerView.Adapter<PodCastAdapter.CardCouponHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): CardCouponHolder {
        return CardCouponHolder(LayoutInflater.from(viewGroup.context).inflate(resource, viewGroup, false))
    }

    override fun getItemCount(): Int {
        return podCastList?.size ?: 0
    }

    override fun onBindViewHolder(holder: CardCouponHolder, position: Int) {
        val podCast = podCastList?.get(position)
        podCastList?.let {
            holder.bindView(podCast)
        }
    }

    class CardCouponHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(podCast: PodCast?){
            podCast?.let {
                with(it){
                    itemView.txtTitleItem.text = title

                    Glide.with(itemView.context).load(urls?.banner_image?.original).into(itemView.imgItemHeader)

                    itemView.setOnClickListener {
                        val context = itemView.context
                        val intent = Intent(context, PodCastDetailActivity::class.java)
                        intent.putExtra("title", title)
                        intent.putExtra("description", formatted_description)
                        intent.putExtra("imageHeader", urls?.banner_image?.original)

                        val p1: Pair<View, String> = Pair.create(itemView.imgItemHeader, "transitionHeader")
                        val p2: Pair<View, String> = Pair.create(itemView.txtTitleItem, "transitionTitle")
                        val p3: Pair<View, String> = Pair.create(itemView.txtDescItem, "transitionDesc")
                        val p4: Pair<View, String> = Pair.create(itemView.txtPriceItem, "transitionPrice")
                        val options: ActivityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(itemView.context as Activity, p1, p2, p3, p4)
                        context.startActivity(intent, options.toBundle())
                    }
                }

            }
        }
    }

}
