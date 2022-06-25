package droid.maxaria.maxander.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class ApiProvider @Inject constructor() {
    val forecast: Retrofit by lazy { initForecast() }
    private fun initForecast() = Retrofit.Builder()
        .baseUrl("https://ohmanda.com/api/horoscope/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
   suspend fun getForecast(): HoroscopeApi =forecast.create(HoroscopeApi::class.java)
}