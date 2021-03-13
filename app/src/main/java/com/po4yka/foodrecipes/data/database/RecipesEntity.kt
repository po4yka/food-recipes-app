package com.po4yka.foodrecipes.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.po4yka.foodrecipes.models.FoodRecipe
import com.po4yka.foodrecipes.util.Constants.Companion.RECIPES_TABLE

@Entity(tableName = RECIPES_TABLE)
class RecipesEntity(
    var foodRecipe: FoodRecipe
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}