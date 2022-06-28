package droid.maxaria.maxander.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import droid.maxaria.maxander.domain.model.ForecastModel


@Dao
interface PredictDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(data: ForecastModel)
    @Query("SELECT * from predicts")
    fun getAll(): LiveData<List<ForecastModel>>
}