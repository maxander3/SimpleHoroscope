package droid.maxaria.maxander.domain

import droid.maxaria.maxander.domain.model.ForecastModel
import retrofit2.Response

interface Repository {
    suspend fun getPredict(sign:String): Response<ForecastModel>
}