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

    private var podCastList: List<PodCast>? = null

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

        fun bindView(podCastViewModel: PodCastViewModel, position: Int) {
            binding?.setVariable(BR.model, podCastViewModel)
            binding?.setVariable(BR.position, position)
            binding?.executePendingBindings()
        }
    }

}
