package droid.maxaria.maxander.domain.usecases

import androidx.lifecycle.LiveData
import droid.maxaria.maxander.domain.HoroscopeRepository
import droid.maxaria.maxander.domain.model.ForecastModel
import javax.inject.Inject

class GetSavedPredictsUseCase @Inject constructor(private val repository: HoroscopeRepository) {
    fun getSavedPredicts(): LiveData<List<ForecastModel>> {
        return repository.allData
    }
}