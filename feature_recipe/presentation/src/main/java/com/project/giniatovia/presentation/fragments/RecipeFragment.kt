package com.project.giniatovia.presentation.fragments

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.project.giniatovia.core_network_impl.NetworkModule
import com.project.giniatovia.data.datasource.RecipeDataSource
import com.project.giniatovia.data.mapper.RecipesResponseMapper
import com.project.giniatovia.data.repository.RecipesRepositoryImpl
import com.project.giniatovia.feature_recipe.presentation.R
import com.project.giniatovia.feature_recipe.presentation.databinding.FragmentRecipeBinding
import com.project.giniatovia.presentation.viewmodels.RecipeViewModel
import com.project.giniatovia.presentation.viewmodels.ViewModelFactory

class RecipeFragment : Fragment() {
    private lateinit var viewModel: RecipeViewModel
    lateinit var binding: FragmentRecipeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecipeBinding.inflate(inflater, container,false)
        viewModel = ViewModelProvider(requireActivity(), ViewModelFactory(RecipesRepositoryImpl(
            RecipeDataSource(NetworkModule().provideRecipesApi(), RecipesResponseMapper())
        ))).get(RecipeViewModel::class.java)
        viewModel.getRandomRecipe()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.recipeLiveData.observe(viewLifecycleOwner) { recipe ->
            binding.recipeTitle.text = recipe.title
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                binding.recipeSummary.text = Html.fromHtml(recipe.summary, Html.FROM_HTML_MODE_COMPACT)
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
}