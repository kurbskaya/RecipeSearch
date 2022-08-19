package com.erya.recipesearch.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.erya.recipesearch.R
import com.erya.recipesearch.databinding.ButtonFragmentBinding

class ButtonFragment : Fragment() {

    private var _binding: ButtonFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ButtonFragmentBinding.inflate(inflater, container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mainBtn.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FridgeFragment(), FridgeFragment::class.java.simpleName)
                .addToBackStack(null)
                .commit()
        }


        binding.secondaryBtn.setOnClickListener{
//            requireActivity().supportFragmentManager.beginTransaction()
//                .replace(R.id.fragment_container, FavRecipesFragment())
//                .addToBackStack(null)
//                .commit()
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}