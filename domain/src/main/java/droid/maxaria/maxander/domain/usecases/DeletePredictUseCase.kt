package droid.maxaria.maxander.domain.usecases

import droid.maxaria.maxander.domain.Repository
import droid.maxaria.maxander.domain.model.ForecastModel
import javax.inject.Inject

class DeletePredictUseCase @Inject constructor(private val repository: Repository) {
    suspend fun deletePredictUseCase(data:ForecastModel){
        repository.deletePredict(data)
    }
}