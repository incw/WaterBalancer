package ru.smolyakoff.waterbalance.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import ru.smolyakoff.waterbalance.domain.other.WaterBalanceRepository
import ru.smolyakoff.waterbalance.domain.user.UserItem
import ru.smolyakoff.waterbalance.domain.water.WaterItem

class RepositoryImpl(
    application: Application
) : WaterBalanceRepository {


    private val waterBalanceDao = WBDataBase.getInstance(application).waterBalanceDao()

    private val mappers = WBMapper()

    // for user impl

    override suspend fun addUser(userItem: UserItem) {
        waterBalanceDao.addUser(mappers.mapUserToDbModel(userItem))
    }

    override suspend fun getUser(userItemId: Int): UserItem {
        val dbModel = waterBalanceDao.getUser(userItemId)
        return mappers.mapDbModelToUser(dbModel)
    }

    override suspend fun updateUserInfo(userItem: UserItem) {
        waterBalanceDao.addUser(mappers.mapUserToDbModel(userItem))
    }

    override fun getUserList(): LiveData<List<UserItem>> = Transformations.map(
        waterBalanceDao.getUserList()
    ){
        mappers.mapListDbModelToUserList(it)
    }

    // for water impl

    override suspend fun addWater(waterItem: WaterItem) {
        waterBalanceDao.addWater(mappers.mapWaterToDbModel(waterItem))
    }

    override suspend fun deleteWater(waterItem: WaterItem) {
        waterBalanceDao.deleteWater(waterItem.id)
    }

    override suspend fun getWater(waterItemId: Int): WaterItem {
        val dbModel = waterBalanceDao.getWater(waterItemId)
        return mappers.mapDbModelToWater(dbModel)
    }

    override fun getWaterList(): LiveData<List<WaterItem>> = Transformations.map(
        waterBalanceDao.getWaterList()
    ){
        mappers.mapListDbModelToListWater(it)
    }

}