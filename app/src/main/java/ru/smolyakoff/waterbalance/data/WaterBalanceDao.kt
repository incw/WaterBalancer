package ru.smolyakoff.waterbalance.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WaterBalanceDao {


    // interface for water
    @Query("SELECT * FROM water_table")
    fun getWaterList(): LiveData<List<WaterItemDbModel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addWater(waterItemDbModel: WaterItemDbModel)

    @Query("DELETE FROM water_table WHERE id=:waterItemId")
    suspend fun deleteWater(waterItemId: Int)

    @Query("SELECT * FROM water_table WHERE id=:waterItemId LIMIT 1")
    suspend fun getWater(waterItemId: Int):WaterItemDbModel

    // interface for user

    @Query("SELECT * FROM user_table")
    fun getUserList(): LiveData<List<UserItemDbModel>>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun addUser(userItemDbModel: UserItemDbModel)

    @Query("DELETE FROM user_table WHERE id=:userItemId")
    suspend fun deleteUser(userItemId:Int)

    @Query("SELECT * FROM user_table WHERE id=:userItemId LIMIT 1")
    suspend fun getUser(userItemId: Int):UserItemDbModel

}