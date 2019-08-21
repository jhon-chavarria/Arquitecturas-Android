package com.android.androidarchitecture.view.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.android.androidarchitecture.BR
import com.android.androidarchitecture.model.PodCast
import com.android.androidarchitecture.viewModel.PodCastViewModel

class PodCastAdapter(var podCastViewModel: PodCastViewModel, private var resource: Int) : RecyclerView.Adapter<PodCastAdapter.CardPodCastHolder>() {

    var podCastList: List<PodCast>? = null

    fun setPodCastsList(podCastList: List<PodCast>?) {
        this.podCastList= podCastList
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): CardPodCastHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(viewGroup.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(layoutInflater, position, viewGroup, false)
        return CardPodCastHolder(binding)
    }

    override fun getItemCount(): Int {
        return podCastList?.size ?: 0
    }

    override fun onBindViewHolder(holder: CardPodCastHolder, position: Int) {
        //val podCast = podCastList?.get(position)
        podCastList?.let {
            holder.bindView(podCastViewModel, position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition()
    }

    private fun getLayoutIdForPosition(): Int {
        return resource
    }


    class CardPodCastHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

        private var binding: ViewDataBinding? = null

        init {
            this.binding = binding
        }

        fun bindView(podCast: PodCast?){
            /*podCast?.let {
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

            }*/

        }

        fun bindView(podCastViewModel: PodCastViewModel, position: Int) {
            binding?.setVariable(BR.model, podCastViewModel)
            binding?.setVariable(BR.position, position)
            binding?.executePendingBindings()
        }
    }

}
