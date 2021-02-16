package com.po4yka.foodrecipes.models


import com.google.gson.annotations.SerializedName

data class FoodRecipe(
        @SerializedName("results")
        val results: List<Result>
)