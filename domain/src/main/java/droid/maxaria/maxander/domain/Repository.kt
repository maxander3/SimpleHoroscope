package droid.maxaria.maxander.domain

import androidx.lifecycle.LiveData
import droid.maxaria.maxander.domain.model.ForecastModel
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface Repository {
    suspend fun getPredict(sign:String): Response<ForecastModel>
    suspend fun savePredict(data:ForecastModel)
    val allData: LiveData<List<ForecastModel>>
}