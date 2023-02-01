package com.example.cafeteria_nohands.src.model


import android.content.Context
import androidx.room.*
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(
    entities = [Plato::class],
    version = 1,
    exportSchema = true
)

abstract class PlatoDatabase : RoomDatabase() {

    abstract fun platoDao(): PlatoDao

    companion object {
        @Volatile
        private var INSTANCE: PlatoDatabase? = null

        fun getDatabase(context: Context): PlatoDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            if (INSTANCE == null) {
                synchronized(this) {
                    // Pass the database to the INSTANCE
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