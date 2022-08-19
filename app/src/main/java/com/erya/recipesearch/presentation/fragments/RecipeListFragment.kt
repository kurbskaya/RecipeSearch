package com.erya.recipesearch.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.erya.recipesearch.R
import com.erya.recipesearch.data.repository.PageRepositoryImpl
import com.erya.recipesearch.presentation.viewmodels.ViewModelFactory
import com.project.giniatovia.core.network.implementation.*
import com.project.giniatovia.data.repository.RecipesRepositoryImpl
import com.project.giniatovia.feature_fridge.data.ProductRepositoryImpl
import com.project.giniatovia.feature_recipe.data.datasource.RecipeDataSource
import com.project.giniatovia.feature_recipe.data.mapper.RecipesResponseMapper
import com.project.giniatovia.feature_recipe.databinding.FragmentListRecipeBinding
import com.project.giniatovia.feature_recipe.presentation.adapters.RecipeClickListener
import com.project.giniatovia.feature_recipe.presentation.adapters.RecipesAdapter
import com.project.giniatovia.feature_recipe.presentation.fragments.RecipeDialogFragment
import com.project.giniatovia.feature_recipe.presentation.viewmodels.RecipeViewModel
import okhttp3.logging.HttpLoggingInterceptor

class RecipeListFragment : Fragment() {

    private var _binding: FragmentListRecipeBinding? = null
    private val binding get() = _binding!!

    lateinit var viewModel : RecipeViewModel

    // TODO: убрать 
    val ingridients = arrayOf("potato")


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListRecipeBinding.inflate(inflater, container,false)
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
        // TODO: прокинуть ингридиенты
        viewModel.create()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lifecycleOwner = viewLifecycleOwner
        
        viewModel.recipeLiveData.observe(lifecycleOwner) { recipeList: List<String> ->
            val productAdapter = binding.rvRecipe.adapter
            if (productAdapter == null) {
                val myAdapter = RecipesAdapter(RecipeClickListener { item ->
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, RecipeDialogFragment())
                        .addToBackStack(null)
                        .commit()
                })
                binding.rvRecipe.adapter = myAdapter
                binding.rvRecipe.layoutManager = GridLayoutManager(requireContext(),2)
                myAdapter.submitList(recipeList)

            } else {
                val myAdapter = productAdapter as RecipesAdapter
                myAdapter.submitList(recipeList)
            }

        }
    }
}