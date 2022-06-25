package droid.maxaria.maxander.domain.usecases

import droid.maxaria.maxander.domain.Repository
import droid.maxaria.maxander.domain.model.ForecastModel
import javax.inject.Inject

class SavePredictUseCase @Inject constructor(private val repository: Repository) {
    fun savePredictUseCase(predict:ForecastModel){
        //TODO
    }
}