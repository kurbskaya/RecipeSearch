package com.erya.recipesearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.erya.recipesearch.databinding.FragmentFridgeBinding

class FridgeFragment : Fragment() {

    private lateinit var productAdapter: ProductAdapter

    private var _binding: FragmentFridgeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FridgeViewModel = FridgeViewModel()

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

        productAdapter = ProductAdapter(ProductClickListener { id ->
            viewModel.deleteProduct(id)
        })

        binding.recyclerProduct.adapter = productAdapter
        binding.recyclerProduct.layoutManager = LinearLayoutManager(requireContext())

        //observes
        //submitlist
    }
}