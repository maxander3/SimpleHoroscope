package droid.maxaria.maxander.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import droid.maxaria.maxander.domain.model.ForecastModel


@Dao
interface PredictDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPredict(data: ForecastModel)
    @Query("SELECT * from predicts")
    fun getAll(): LiveData<List<ForecastModel>>
    @Delete
    suspend fun deletePredict(data: ForecastModel)
}