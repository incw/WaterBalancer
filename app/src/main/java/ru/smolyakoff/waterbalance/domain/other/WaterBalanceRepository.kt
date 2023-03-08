package ru.smolyakoff.waterbalance.domain.other

import androidx.lifecycle.LiveData
import ru.smolyakoff.waterbalance.domain.user.UserItem
import ru.smolyakoff.waterbalance.domain.water.WaterItem

interface WaterBalanceRepository {

    suspend fun addUser(userItem: UserItem)

    suspend fun getUser(userItemId: Int): UserItem

    suspend fun updateUserInfo(userItem: UserItem)

    fun getUserList(): LiveData<List<UserItem>>

    suspend fun addWater(waterItem: WaterItem)

    suspend fun deleteWater(waterItem: WaterItem)

    suspend fun getWater(waterItemId: Int): WaterItem

    fun getWaterList(): LiveData<List<WaterItem>>

}