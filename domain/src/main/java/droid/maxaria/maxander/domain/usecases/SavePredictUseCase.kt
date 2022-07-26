package droid.maxaria.maxander.domain.usecases

import droid.maxaria.maxander.domain.HoroscopeRepository
import droid.maxaria.maxander.domain.model.ForecastModel
import javax.inject.Inject

class SavePredictUseCase @Inject constructor(private val repository: HoroscopeRepository) {
    suspend fun savePredictUseCase(predict:ForecastModel){
        repository.savePredict(predict)
    }
}