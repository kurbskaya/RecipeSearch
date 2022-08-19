package com.erya.recipesearch.presentation.fragments

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.erya.recipesearch.data.repository.PageRepositoryImpl
import com.erya.recipesearch.presentation.viewmodels.ViewModelFactory
import com.project.giniatovia.core.network.implementation.*
import com.project.giniatovia.data.repository.RecipesRepositoryImpl
import com.project.giniatovia.feature_fridge.R
import com.project.giniatovia.feature_fridge.data.ProductRepositoryImpl
import com.project.giniatovia.feature_fridge.databinding.FragmentFridgeBinding
import com.project.giniatovia.feature_fridge.presentation.ProductAdapter
import com.project.giniatovia.core.network.models.Product
import com.project.giniatovia.feature_fridge.presentation.viewmodels.ProductViewModel
import com.project.giniatovia.feature_recipe.data.datasource.RecipeDataSource
import com.project.giniatovia.feature_recipe.data.mapper.RecipesResponseMapper
import okhttp3.logging.HttpLoggingInterceptor

class FridgeFragment : Fragment() {

    private var _binding: FragmentFridgeBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ProductViewModel

    val prl = listOf( "Апельсин", "Ананас","Абрикос")

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
                ProductRepositoryImpl(requireContext()),
                PageRepositoryImpl()
            )
        ).get(ProductViewModel::class.java)
        viewModel.getAllProducts()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val autoCompleteAdapter = ArrayAdapter(
            requireContext(),
            R.layout.item_search_product,
            R.id.nameProduct,
            prl
        )
        val autoCompleteWidget = binding.autoCompleteTextView
        autoCompleteWidget.threshold = 1
        autoCompleteWidget.setAdapter(autoCompleteAdapter)
        autoCompleteWidget.setTextColor(Color.BLACK)
        autoCompleteWidget.setOnItemClickListener{ _, _, _, _ ->
            viewModel.add(
                // TODO:  во вью модели сформировать продукт с картинкой!!!
                Product(
                    "123",
                    autoCompleteWidget.editableText.toString(),
                    "141kkal"
                )
            )
            autoCompleteWidget.setText(R.string.empty)

            val context = context
            val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.hideSoftInputFromWindow(autoCompleteWidget.windowToken, 0)
        }

        val lifecycleOwner = viewLifecycleOwner
        viewModel.productLiveData.observe(lifecycleOwner) { productList: List<Product> ->
            val productAdapter = binding.rv.adapter
            if (productAdapter == null) {
                val myAdapter = ProductAdapter()
                binding.rv.adapter = myAdapter
                binding.rv.layoutManager = LinearLayoutManager(requireContext())
                myAdapter.submitList(productList)
            } else {
                val myAdapter = productAdapter as ProductAdapter
                myAdapter.submitList(productList)
            }

        }
        binding.mainBtn.setOnClickListener{
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, RecipeListFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}