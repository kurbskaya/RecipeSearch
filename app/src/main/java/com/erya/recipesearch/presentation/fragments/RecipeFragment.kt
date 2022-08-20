package com.erya.recipesearch.presentation.fragments

import androidx.fragment.app.Fragment

class RecipeFragment : Fragment() {
//    private lateinit var viewModel: RecipeViewModel
//    private val binding get() = _binding!!
//    private var _binding: FragmentRecipeBinding? = null
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        _binding = FragmentRecipeBinding.inflate(inflater, container, false)
//        // TODO: Refactor later by DI
//        viewModel = ViewModelProvider(
//            requireActivity(),
//            ViewModelFactory(
//                RecipesRepositoryImpl(
//                    RecipeDataSource(
//                        RecipeApiImpl(
//                            RetrofitImpl(
//                                ConverterFactoryImpl(), OkHttpClientImpl(
//                                    InterceptorImpl(
//                                        HttpLoggingInterceptor.Level.BODY
//                                    )
//                                )
//                            )
//                        ).recipesService(),
//                        RecipesResponseMapper()
//                    )
//                ),
//                ProductRepositoryImpl(requireContext()),
//                PageRepositoryImpl()
//            )
//        ).get(RecipeViewModel::class.java)
//        viewModel.getRandomRecipe()
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        val args = arguments?.getStringArray("PRODUCT")
//        if (args != null) viewModel.getRecipeByIngredients(args)
//        viewModel.recipeLiveData.observe(viewLifecycleOwner) { recipe ->
//            binding.recipeTitle.text = recipe.title
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//                binding.recipeSummary.text =
//                    Html.fromHtml(recipe.summary, Html.FROM_HTML_MODE_COMPACT)
//            }
//            Glide.with(binding.recipeImage.context)
//                .load(recipe.image)
//                .placeholder(R.drawable.progress_animation)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(binding.recipeImage)
//            val steps = recipe.analyzedInstructions[0].steps.map { it.step }
//            binding.recipeSteps.text = steps.joinToString("\n")
//        }
//    }
//
//    override fun onDestroyView() {
//        _binding = null
//        super.onDestroyView()
//    }
}