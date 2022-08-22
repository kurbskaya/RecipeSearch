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
import com.erya.recipesearch.RecipesApplication
import com.project.giniatovia.core.network.implementation.*
import com.project.giniatovia.feature_recipe.data.repository.RecipesRepositoryImpl
import com.project.giniatovia.feature_fridge.data.ProductRepositoryImpl
import com.project.giniatovia.feature_recipe.data.datasource.RecipeDataSource
import com.project.giniatovia.feature_recipe.databinding.FragmentListRecipeBinding
import com.project.giniatovia.feature_recipe.presentation.adapters.RecipeClickListener
import com.project.giniatovia.feature_recipe.presentation.adapters.RecipesAdapter
import com.project.giniatovia.feature_recipe.presentation.models.RecipeViewData
import com.project.giniatovia.feature_recipe.presentation.viewmodels.RecipeViewModel
import okhttp3.logging.HttpLoggingInterceptor

class RecipeListFragment : Fragment() {

    private var _binding: FragmentListRecipeBinding? = null
    private val binding get() = _binding!!

    lateinit var viewModel: RecipeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListRecipeBinding.inflate(inflater, container, false)
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
                    ),
                    (requireActivity().application as RecipesApplication).databaseRecipe.recipeDao()
                ),
                ProductRepositoryImpl(
                    requireContext(),
                    (requireActivity().application as RecipesApplication).databaseProducts.productDao()
                ),
                PageRepositoryImpl()
            )
        ).get(RecipeViewModel::class.java)

        val args = arguments?.getStringArrayList(SELECTED_PRODUCTS)
        viewModel.clearLiveData()
        if (args != null) {
            viewModel.getRecipeByIngredients(args)
        } else {
            viewModel.getSavedRecipes()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lifecycleOwner = viewLifecycleOwner

        viewModel.recipeLiveData.observe(lifecycleOwner) { recipeList: List<RecipeViewData> ->
            val productAdapter = binding.rvRecipe.adapter
            if (productAdapter == null) {
                val myAdapter = RecipesAdapter(RecipeClickListener { item ->
                    val fragment = RecipeDialogFragment.newInstance(item.id!!)
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, fragment)
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

    companion object {
        private const val SELECTED_PRODUCTS = "selected_products"

        fun newInstance(args: ArrayList<String>) = RecipeListFragment().apply {
            arguments = Bundle().apply {
                putStringArrayList(SELECTED_PRODUCTS, args)
            }
        }
    }
}