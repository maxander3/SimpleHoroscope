package droid.maxaria.maxander.domain.usecases

import droid.maxaria.maxander.domain.HoroscopeRepository
import droid.maxaria.maxander.domain.model.ForecastModel
import retrofit2.Response
import javax.inject.Inject

class GetPredictUseCase @Inject constructor(private val repository: HoroscopeRepository) {
    suspend fun getPredict(sign:String):Response<ForecastModel>{
        return repository.getPredict(sign)
    }
}