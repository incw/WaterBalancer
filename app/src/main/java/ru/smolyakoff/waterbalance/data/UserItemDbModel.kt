package ru.smolyakoff.waterbalance.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserItemDbModel(

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val name: String,
    val height: Int,
    val weight: Int

)