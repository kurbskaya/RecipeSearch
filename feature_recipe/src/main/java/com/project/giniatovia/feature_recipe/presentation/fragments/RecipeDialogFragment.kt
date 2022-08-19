package com.project.giniatovia.feature_recipe.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.project.giniatovia.feature_recipe.databinding.RecipeDialogBinding

class RecipeDialogFragment : Fragment() {

    private var _binding: RecipeDialogBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = RecipeDialogBinding.inflate(inflater, container, false)
        val bottomSheetDialogFragment = RecipeBottomSheetDialogFragment()
        bottomSheetDialogFragment.setCancelable(false)
        bottomSheetDialogFragment.show(requireActivity().supportFragmentManager, "tag1")


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}