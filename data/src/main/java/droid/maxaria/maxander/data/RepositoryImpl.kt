package droid.maxaria.maxander.data

import androidx.lifecycle.LiveData
import droid.maxaria.maxander.data.api.ApiProvider
import droid.maxaria.maxander.data.database.PredictDao
import droid.maxaria.maxander.domain.Repository
import droid.maxaria.maxander.domain.model.ForecastModel
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class RepositoryImpl (private val apiProvider: ApiProvider, private val predictDao: PredictDao):Repository {
    override suspend fun getPredict(sign: String): Response<ForecastModel> {
        return apiProvider.getForecast().getForecast(sign)
    }

    override suspend fun savePredict(data: ForecastModel) {
        predictDao.insert(data)
    }

    override val allData: LiveData<List<ForecastModel>>
        get() = predictDao.getAll()


}