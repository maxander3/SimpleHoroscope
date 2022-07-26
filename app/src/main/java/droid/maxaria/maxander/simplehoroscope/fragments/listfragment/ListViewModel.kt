package droid.maxaria.maxander.simplehoroscope.fragments.listfragment

import android.util.Log
import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import droid.maxaria.maxander.domain.model.ForecastModel
import droid.maxaria.maxander.domain.usecases.DeletePredictUseCase
import droid.maxaria.maxander.domain.usecases.GetSavedPredictsUseCase
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.switchMap
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(val getSavedPredictsCase: GetSavedPredictsUseCase,val deletePredictUseCase: DeletePredictUseCase): ViewModel() {
    var data:LiveData<List<ForecastModel>> = getSavedPredictsCase.getSavedPredicts()

    fun deletePredict(data: ForecastModel){
        viewModelScope.launch(Dispatchers.IO) {
            deletePredictUseCase.deletePredictUseCase(data)
        }
    }


}