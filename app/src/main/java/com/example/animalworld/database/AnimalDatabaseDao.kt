package com.example.animalworld.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AnimalDatabaseDao {

    // Add new instance to table
    @Insert
    suspend fun insert(animal: Animal)

    // Deletes instance
    @Delete
    fun deleteAnimal(animal: Animal)

    // Replace old value with new one in rows
    @Update
    suspend fun update(animal:Animal)

    // Returns all rows in table
    @Query("SELECT * FROM animal_list_table ORDER BY animalId DESC")
    fun getAllAnimals():LiveData<List<Animal>>

    // Returns particular row according to the key
    @Query("SELECT * from animal_list_table WHERE animalId = :key")
    fun getNightWithId(key: Long): LiveData<Animal>
}

