package droid.maxaria.maxander.domain.usecases

import androidx.lifecycle.LiveData
import droid.maxaria.maxander.domain.Repository
import droid.maxaria.maxander.domain.model.ForecastModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSavedPredictsUseCase @Inject constructor(private val repository: Repository) {
    fun getSavedPredicts(): LiveData<List<ForecastModel>> {
        return repository.allData
    }
}