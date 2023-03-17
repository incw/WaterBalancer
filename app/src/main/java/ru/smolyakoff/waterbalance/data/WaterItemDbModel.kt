package ru.smolyakoff.waterbalance.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "water_table")
data class WaterItemDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val name: String,
    val count: Int

) {

}
