package com.erya.recipesearch.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.erya.recipesearch.R
import com.erya.recipesearch.databinding.OnboardingDialogBinding
import com.erya.recipesearch.models.OnboardingAdapter
import com.erya.recipesearch.models.Page
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.tabs.TabLayoutMediator

class OnboardingDialogFragment : BottomSheetDialogFragment() {

    private var _binding: OnboardingDialogBinding? = null
    private val binding get() = _binding!!

    override fun getTheme() = R.style.AppBottomSheetDialogThemeOnboarding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = OnboardingDialogBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    override fun onStart() {
        super.onStart()

        val pageList = arrayListOf(
            Page("description1", R.raw.first_page),
            Page("description2", R.raw.second_page),
            Page("description3", R.raw.third_page)
        )

        binding.apply {
            introViewPager.adapter = OnboardingAdapter(pageList)
            TabLayoutMediator(intoTabLayout, introViewPager) { _, _ -> }.attach()
            btn.setOnClickListener { dismiss() }
        }
    }
}