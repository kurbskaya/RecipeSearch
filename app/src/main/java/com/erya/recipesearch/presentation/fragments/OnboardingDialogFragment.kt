package com.erya.recipesearch.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.erya.recipesearch.R
import com.erya.recipesearch.data.repository.PageRepositoryImpl
import com.erya.recipesearch.databinding.OnboardingDialogBinding
import com.erya.recipesearch.presentation.adapters.OnboardingAdapter
import com.erya.recipesearch.models.Page
import com.erya.recipesearch.presentation.viewmodels.OnboardingViewModel
import com.erya.recipesearch.presentation.viewmodels.ViewModelFactory
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.tabs.TabLayoutMediator
import com.erya.recipesearch.RecipesApplication
import com.project.giniatovia.core.network.implementation.*
import com.project.giniatovia.feature_recipe.data.repository.RecipesRepositoryImpl
import com.project.giniatovia.feature_fridge.data.ProductRepositoryImpl
import com.project.giniatovia.feature_recipe.data.datasource.RecipeDataSource
import okhttp3.logging.HttpLoggingInterceptor

class OnboardingDialogFragment : BottomSheetDialogFragment() {

    private var _binding: OnboardingDialogBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel : OnboardingViewModel

    override fun getTheme() = R.style.AppBottomSheetDialogThemeOnboarding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = OnboardingDialogBinding.inflate(inflater, container,false)
        val recipeDataSource = RecipeDataSource(
            RecipeApiImpl(
                RetrofitImpl(
                    ConverterFactoryImpl(), OkHttpClientImpl(
                        InterceptorImpl(
                            HttpLoggingInterceptor.Level.BODY
                        )
                    )
                )
            ).recipesService(),
        )
        viewModel = ViewModelProvider(
            requireActivity(),
            ViewModelFactory(
                RecipesRepositoryImpl(
                    recipeDataSource,
                    (requireActivity().application as RecipesApplication).databaseRecipe.recipeDao()
                ),
                ProductRepositoryImpl(
                    requireContext(),
                    (requireActivity().application as RecipesApplication).databaseProducts.productDao(),
                    recipeDataSource
                ),
                PageRepositoryImpl()
            )
        ).get(OnboardingViewModel::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lifecycleOwner = viewLifecycleOwner

        viewModel.init()

        viewModel.pageLiveData.observe(lifecycleOwner) { pageList: ArrayList<Page> ->

            binding.apply {
                introViewPager.adapter = OnboardingAdapter(pageList)
                TabLayoutMediator(intoTabLayout, introViewPager) { _, _ -> }.attach()
                btn.setOnClickListener { dismiss() }
            }
        }
    }
}
