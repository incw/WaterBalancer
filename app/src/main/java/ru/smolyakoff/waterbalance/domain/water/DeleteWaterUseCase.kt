package ru.smolyakoff.waterbalance.domain.water

import ru.smolyakoff.waterbalance.domain.other.WaterBalanceRepository

class DeleteWaterUseCase(private val waterBalanceRepository: WaterBalanceRepository) {

    suspend fun deleteWater(waterItem: WaterItem){
        waterBalanceRepository.deleteWater(waterItem)
    }
}