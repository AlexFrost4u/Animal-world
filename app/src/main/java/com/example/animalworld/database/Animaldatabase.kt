package com.example.animalworld.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Animal::class],version = 1,exportSchema = false)
abstract class AnimalDatabase : RoomDatabase() {

    // Connect database to dao
    abstract val animalDatabaseDao :AnimalDatabaseDao

    companion object{
        @Volatile
        private var INSTANCE: AnimalDatabase? = null

        fun getInstance(context: Context):AnimalDatabase{
            synchronized(this){
                var instance = INSTANCE

                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AnimalDatabase::class.java,
                        "animal_list_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}