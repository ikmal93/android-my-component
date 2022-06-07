package com.ikmal93.androidmycomponent.component.banner

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ikmal93.androidmycomponent.databinding.BannerImageSliderItemBinding

class BannerSliderAdapter(
    private val bannerListItem: MutableList<BannerModel>,
    private val onItemClick: (BannerModel) -> Unit
) : RecyclerView.Adapter<BannerSliderAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = BannerImageSliderItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(bannerListItem[position])
    }

    override fun getItemCount(): Int {
        return bannerListItem.size
    }

    class ViewHolder(
        private val binding: BannerImageSliderItemBinding,
        private val onItemClick: (BannerModel) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(bannerModel: BannerModel) {
            binding.apply {
                Glide.with(root.context)
                    .load(bannerModel.bannerImageUrl)
                    .into(ivImage)
                tvTitle.text = bannerModel.bannerTitle
                root.setOnClickListener {
                    onItemClick(bannerModel)
                }
            }
        }
    }
}