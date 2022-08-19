package com.erya.recipesearch.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieDrawable
import com.erya.recipesearch.databinding.OnboardingItemBinding
import com.erya.recipesearch.models.Page

class OnboardingAdapter(private val pageList: ArrayList<Page>) : RecyclerView.Adapter<OnboardingAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        OnboardingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(pageList[position])
    }

    override fun getItemCount() = pageList.size

    override fun onViewDetachedFromWindow(holder: ViewHolder) {
        holder.binding.imgIntro.clearAnimation()
        super.onViewDetachedFromWindow(holder)

    }

    override fun onViewAttachedToWindow(holder: ViewHolder) {
        holder.binding.imgIntro.playAnimation()
        super.onViewDetachedFromWindow(holder)

    }

    class ViewHolder(val binding: OnboardingItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Page) {
            binding.tvIntroSubTitle.text = item.description
            binding.imgIntro.setAnimation(item.lottie)
            binding.imgIntro.repeatCount = LottieDrawable.INFINITE
            //binding.imgIntro.playAnimation()
        }

    }
}