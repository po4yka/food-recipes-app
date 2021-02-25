package com.po4yka.foodrecipes.data

import com.po4yka.foodrecipes.data.network.FoodRecipesApi
import com.po4yka.foodrecipes.models.FoodRecipe
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val foodRecipesApi: FoodRecipesApi
) {

    suspend fun getRecipes(queries: Map<String, String>): Response<FoodRecipe> {
        return foodRecipesApi.getRecipes(queries)
    }

}