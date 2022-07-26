package droid.maxaria.maxander.data

import androidx.lifecycle.LiveData
import droid.maxaria.maxander.data.api.ApiProvider
import droid.maxaria.maxander.data.database.PredictDao
import droid.maxaria.maxander.domain.HoroscopeRepository
import droid.maxaria.maxander.domain.model.ForecastModel
import retrofit2.Response

class HoroscopeRepositoryImpl (private val apiProvider: ApiProvider, private val predictDao: PredictDao):HoroscopeRepository {
    override suspend fun getPredict(sign: String): Response<ForecastModel> {
        return apiProvider.getForecast().getForecast(sign)
    }


    override suspend fun savePredict(data: ForecastModel) {
        predictDao.insertPredict(data)
    }

    override suspend fun deletePredict(data: ForecastModel) {
        predictDao.deletePredict(data)
    }

    override val allData: LiveData<List<ForecastModel>>
        get() = predictDao.getAll()


}