package com.project.giniatovia.core.db.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.project.giniatovia.core.db.models.ProductEntity
import com.project.giniatovia.core.db.models.RecipeEntity

@Database(entities = [RecipeEntity::class, ProductEntity::class], version = 3, exportSchema = false)
abstract class RecipeRoomDatabase : RoomDatabase() {

    abstract fun recipeDao(): RecipeDao

    companion object {
        @Volatile
        private var INSTANCE: RecipeRoomDatabase? = null

        fun getDatabase(
            context: Context
        ): RecipeRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RecipeRoomDatabase::class.java,
                    "saved_recipes"
                )
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}
