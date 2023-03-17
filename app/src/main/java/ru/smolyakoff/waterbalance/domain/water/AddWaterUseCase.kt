package ru.smolyakoff.waterbalance.domain.water

import ru.smolyakoff.waterbalance.domain.other.WaterBalanceRepository

class AddWaterUseCase(private val waterBalanceRepository: WaterBalanceRepository) {

    suspend fun addWater(waterItem: WaterItem) {
        waterBalanceRepository.addWater(waterItem)
    }

}