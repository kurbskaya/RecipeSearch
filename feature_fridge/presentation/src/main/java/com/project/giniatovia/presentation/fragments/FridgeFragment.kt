package com.project.giniatovia.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.giniatovia.feature_fridge.presentation.R
import com.project.giniatovia.feature_fridge.presentation.databinding.FragmentFridgeBinding
import com.project.giniatovia.presentation.ProductAdapter

class FridgeFragment : Fragment() {

    private lateinit var productAdapter: ProductAdapter

    private var _binding: FragmentFridgeBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFridgeBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fab.setOnClickListener{
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SearchProductFragment())
                .addToBackStack(null)
                .commit()
        }

//        productAdapter = ProductAdapter(ProductClickListener { id ->
//            viewModel.deleteProduct(id)
//        })
//
//        binding.recyclerProduct.adapter = productAdapter
//        binding.recyclerProduct.layoutManager = LinearLayoutManager(requireContext())

        //observes
        //submitlist
    }

}