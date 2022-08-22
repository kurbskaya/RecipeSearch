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

@Database(entities = [ProductEntity::class], version = 1, exportSchema = false)
abstract class ProductsRoomDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao

    private class ProductsDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    val dao = database.productDao()
                    dao.deleteAllRecords()
                }
            }
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: ProductsRoomDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): ProductsRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProductsRoomDatabase::class.java,
                    "saved_products"
                )
                    .addCallback(ProductsDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}