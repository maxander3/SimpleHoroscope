package droid.maxaria.maxander.data.api

import droid.maxaria.maxander.domain.model.ForecastModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface HoroscopeApi {
    @GET("{zodiacSign}")
    suspend fun getForecast(
        @Path("zodiacSign") sign:String
    ):Response<ForecastModel>
}