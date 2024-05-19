package com.example.Lab9

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase

@Database(entities = [DailyPlan::class], version = 1)
abstract class DailyPlanDB: RoomDatabase() {
    abstract fun planDao(): DailyPlanDao
}

@Entity(tableName = "plans")
data class DailyPlan(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "deadline") val deadline: String?
)

@Dao
interface DailyPlanDao {
    @Query("SELECT * FROM plans")
    fun getAll(): List<DailyPlan>

    @Insert
    fun insertAll(vararg dailyPlans: DailyPlan)

    @Delete
    fun delete (dailyPlan: DailyPlan)

    @Query("DELETE FROM plans WHERE id = :planId")
    fun deleteById(planId: Int)
}
