package ru.smolyakoff.waterbalance.domain.water

import androidx.lifecycle.LiveData
import ru.smolyakoff.waterbalance.domain.other.WaterBalanceRepository

class GetWaterListUseCase(private val waterBalanceRepository: WaterBalanceRepository){

    fun getWaterList():LiveData<List<WaterItem>>{
        return waterBalanceRepository.getWaterList()
    }

}