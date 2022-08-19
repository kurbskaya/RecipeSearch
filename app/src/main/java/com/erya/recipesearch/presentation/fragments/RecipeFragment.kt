package com.erya.recipesearch.presentation.fragments

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.erya.recipesearch.data.repository.PageRepositoryImpl
import com.erya.recipesearch.presentation.viewmodels.ViewModelFactory
import com.project.giniatovia.core.network.implementation.*
import com.project.giniatovia.data.repository.RecipesRepositoryImpl
import com.project.giniatovia.feature_fridge.data.ProductRepositoryImpl
import com.project.giniatovia.feature_recipe.R
import com.project.giniatovia.feature_recipe.data.datasource.RecipeDataSource
import com.project.giniatovia.feature_recipe.data.mapper.RecipesResponseMapper
import com.project.giniatovia.feature_recipe.databinding.FragmentRecipeBinding
import com.project.giniatovia.feature_recipe.presentation.viewmodels.RecipeViewModel
import okhttp3.logging.HttpLoggingInterceptor

class RecipeFragment : Fragment() {
    private lateinit var viewModel: RecipeViewModel
    private val binding get() = _binding!!
    private var _binding: FragmentRecipeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecipeBinding.inflate(inflater, container, false)
        // TODO: Refactor later by DI
        viewModel = ViewModelProvider(
            requireActivity(),
            ViewModelFactory(
                RecipesRepositoryImpl(
                    RecipeDataSource(
                        RecipeApiImpl(
                            RetrofitImpl(
                                ConverterFactoryImpl(), OkHttpClientImpl(
                                    InterceptorImpl(
                                        HttpLoggingInterceptor.Level.BODY
                                    )
                                )
                            )
                        ).recipesService(),
                        RecipesResponseMapper()
                    )
                ),
                ProductRepositoryImpl(requireContext()),
                PageRepositoryImpl()
            )
        ).get(RecipeViewModel::class.java)
        viewModel.getRandomRecipe()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = arguments?.getStringArray("PRODUCT")
        if (args != null) viewModel.getRecipeByIngredients(args)
        viewModel.recipeLiveData.observe(viewLifecycleOwner) { recipe ->
            binding.recipeTitle.text = recipe.title
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                binding.recipeSummary.text =
                    Html.fromHtml(recipe.summary, Html.FROM_HTML_MODE_COMPACT)
            }
            Glide.with(binding.recipeImage.context)
                .load(recipe.image)
                .placeholder(R.drawable.progress_animation)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.recipeImage)
            val steps = recipe.analyzedInstructions[0].steps.map { it.step }
            binding.recipeSteps.text = steps.joinToString("\n")
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}