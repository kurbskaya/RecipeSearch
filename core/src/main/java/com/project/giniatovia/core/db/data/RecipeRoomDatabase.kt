package com.project.giniatovia.core.db.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.project.giniatovia.core.db.models.ProductEntity
import com.project.giniatovia.core.db.models.RecipeEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [RecipeEntity::class, ProductEntity::class], version = 1, exportSchema = false)
abstract class RecipeRoomDatabase : RoomDatabase() {

    abstract fun recipeDao(): RecipeDao

    private class RecipeDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    // Filling new database
                    val dao = database.recipeDao()
                    dao.deleteAll()
                }
            }
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: RecipeRoomDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): RecipeRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RecipeRoomDatabase::class.java,
                    "saved_recipes"
                )
                    .addCallback(RecipeDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}
