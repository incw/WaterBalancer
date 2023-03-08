package ru.smolyakoff.waterbalance.domain.user

import ru.smolyakoff.waterbalance.domain.other.WaterBalanceRepository

class GetUserUseCase(private val waterBalanceRepository: WaterBalanceRepository) {


    suspend fun getUser(userItemId: Int) {
        waterBalanceRepository.getUser(userItemId)
    }

}