package com.erya.recipesearch.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.project.giniatovia.feature_recipe.R
import com.project.giniatovia.feature_recipe.databinding.RecipeBottomSheetBinding

class RecipeBottomSheetDialogFragment : BottomSheetDialogFragment() {

    lateinit var binding: RecipeBottomSheetBinding

    override fun getTheme() = R.style.AppBottomSheetDialogTheme1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = RecipeBottomSheetBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = arguments?.getString(RECIPE_INSTRUCTIONS)
        binding.recipeInstructionsTv.text = args
    }

    companion object {
        private const val RECIPE_INSTRUCTIONS = "recipe_instructions"

        fun newInstance(args: String) = RecipeBottomSheetDialogFragment().apply {
            arguments = Bundle().apply {
                putString(RECIPE_INSTRUCTIONS, args)
            }
        }
    }
}
