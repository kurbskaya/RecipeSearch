package com.erya.recipesearch

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.erya.recipesearch.databinding.FragmentFridgeBinding
import com.erya.recipesearch.databinding.FragmentSearchBinding

class SearchProductFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    val countries = listOf<String>( "Помидор", "Картоха", "Апельсинка", "Пэрсик")


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ArrayAdapter(
            requireContext(),
            R.layout.item_serach_product,
            R.id.nameProduct,
            countries)
        val autoCompleteWidget = binding.autoCompleteTextView
        autoCompleteWidget.threshold = 1
        autoCompleteWidget.setAdapter(adapter)
        autoCompleteWidget.setTextColor(Color.BLACK)
    }

}
