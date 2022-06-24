package droid.maxaria.maxander.data

import droid.maxaria.maxander.data.api.ApiProvider
import droid.maxaria.maxander.domain.Repository
import droid.maxaria.maxander.domain.model.ForecastModel
import retrofit2.Response

class RepositoryImpl (private val apiProvider: ApiProvider):Repository {
    override suspend fun getPredict(sign: String): Response<ForecastModel> {
        return apiProvider.getForecast().getForecast(sign)
    }
}