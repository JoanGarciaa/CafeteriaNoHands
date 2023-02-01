package com.example.cafeteria_nohands.src.database


import android.content.Context
import androidx.room.*
import com.example.cafeteria_nohands.src.model.Plato
import com.example.cafeteria_nohands.src.model.Usuari

@Database(
    entities = [Plato::class, Usuari::class],
    version = 1,
    exportSchema = true
)

abstract class PlatoDatabase : RoomDatabase() {

    abstract fun platoDao(): PlatoDao
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: PlatoDatabase? = null

        fun getDatabase(context: Context): PlatoDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = buildDatabase(context)
                }
            }
            // Return database.
            return INSTANCE!!
        }

        private fun buildDatabase(context: Context): PlatoDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                PlatoDatabase::class.java,
                "platos_database"
            ).createFromAsset("databases/platos.db").build()
        }
    }
}