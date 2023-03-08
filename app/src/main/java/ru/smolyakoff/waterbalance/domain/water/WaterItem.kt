package ru.smolyakoff.waterbalance.domain.water

data class WaterItem(

    val id: Int = WATER_ID,
    val name: String,
    val count: Int
) {

    companion object {
        const val WATER_ID = 0
    }

}