package droid.maxaria.maxander.simplehoroscope.fragments.predictfragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import droid.maxaria.maxander.domain.usecases.GetPredictUseCase

class PredictFragmentViewModelFactory(val getPredictUseCase: GetPredictUseCase): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PredictFragmentViewModel(getPredictUseCase) as T
    }
}