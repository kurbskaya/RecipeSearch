package com.erya.recipesearch.presentation.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.erya.recipesearch.R
import com.erya.recipesearch.data.database.*
import com.erya.recipesearch.databinding.FavRecipesFragmentBinding
import com.erya.recipesearch.presentation.activity.NewRecipeActivity
import com.erya.recipesearch.presentation.adapters.RecipeListAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.random.Random

class FavRecipesFragment: Fragment() {
    private var _binding: FavRecipesFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FavRecipesFragmentBinding.inflate(inflater, container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.i("MYTAG", "FavRecipesFragment created")

        val recipeViewModel: RecipeViewModel by requireActivity().viewModels {
            RecipeViewModelFactory((requireActivity().application as RecipesApplication).repository)
        }

        val recyclerView = requireActivity().findViewById<RecyclerView>(R.id.saved_recipes_list)
        val adapter = RecipeListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())

        recipeViewModel.savedRecipes.observe(requireActivity()) { recipes ->
            recipes.let { adapter.submitList(it) }
        }

        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                data?.getStringExtra(NewRecipeActivity.EXTRA_REPLY)?.let { reply ->
                    val randint = Random.nextInt(10, 100)
                    val recipe = RecipeEntity(randint, reply)
                    Log.i("SOME_TAG", "$reply $randint")
                    recipeViewModel.insert(recipe)
                }
            } else {
                Toast.makeText(
                    requireActivity().applicationContext,
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        val fab = requireActivity().findViewById<FloatingActionButton>(R.id.add_recipe_button)
        fab.setOnClickListener {
            val intent = Intent(requireActivity(), NewRecipeActivity::class.java)
            resultLauncher.launch(intent)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}