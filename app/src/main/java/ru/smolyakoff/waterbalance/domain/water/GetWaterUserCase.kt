package ru.smolyakoff.waterbalance.domain.water

import ru.smolyakoff.waterbalance.domain.other.WaterBalanceRepository

class GetWaterUserCase(private val waterBalanceRepository: WaterBalanceRepository) {

    suspend fun getWater(waterItemId: Int):WaterItem{
        return waterBalanceRepository.getWater(waterItemId)
    }

}