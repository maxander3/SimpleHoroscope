package droid.maxaria.maxander.domain.usecases

import droid.maxaria.maxander.domain.Repository
import droid.maxaria.maxander.domain.model.ForecastModel
import retrofit2.Response

class GetPredictUseCase(private val repository: Repository) {
    suspend fun getPredict(sign:String):Response<ForecastModel>{
        return repository.getPredict(sign)
    }
}