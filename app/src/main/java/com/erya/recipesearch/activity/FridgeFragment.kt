package com.erya.recipesearch.activity

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.project.giniatovia.core.network.implementation.*
import com.project.giniatovia.data.repository.RecipesRepositoryImpl
import com.project.giniatovia.feature_fridge.R
import com.project.giniatovia.feature_fridge.data.ProductRepositoryImpl
import com.project.giniatovia.feature_fridge.databinding.FragmentFridgeBinding
import com.project.giniatovia.feature_fridge.presentation.ProductAdapter
import com.project.giniatovia.feature_fridge.presentation.viewmodels.ProductViewModel
import com.project.giniatovia.feature_recipe.data.datasource.RecipeDataSource
import com.project.giniatovia.feature_recipe.data.mapper.RecipesResponseMapper
import okhttp3.logging.HttpLoggingInterceptor

class FridgeFragment : Fragment() {

    private lateinit var productAdapter: ProductAdapter

    private var _binding: FragmentFridgeBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFridgeBinding.inflate(inflater, container, false)
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
                ProductRepositoryImpl(requireContext())
            )
        ).get(ProductViewModel::class.java)
        viewModel.getAllProducts()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val productAdapter = ProductAdapter()
        binding.recyclerProduct.adapter = productAdapter

        viewModel.productLiveData.observe(viewLifecycleOwner) {
            Log.d("TAG", it.entries.take(10).toString())
        }

        binding.fab.setOnClickListener {
            val fragment = RecipeFragment.newInstance(arrayOf())
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}