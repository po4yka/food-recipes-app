package com.po4yka.foodrecipes.di

import android.content.Context
import androidx.room.Room
import com.po4yka.foodrecipes.data.database.RecipesDatabase
import com.po4yka.foodrecipes.util.Constants.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        RecipesDatabase::class.java,
        DATABASE_NAME
    ).build()

    @Provides
    fun provideDao(database: RecipesDatabase) = database.recipesDao()

}