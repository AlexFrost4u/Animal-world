package com.example.animalworld.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "animal_list_table")
data class Animal (
    @PrimaryKey(autoGenerate = true)
    var animalId:Long = 0L,

    @ColumnInfo(name = "animal_picture_path")
    var animalPicPath:String = "",

    @ColumnInfo(name = "animal_name")
    var animalName:String = "",

    @ColumnInfo(name = "animal_description")
    var animalDes:String = ""
)