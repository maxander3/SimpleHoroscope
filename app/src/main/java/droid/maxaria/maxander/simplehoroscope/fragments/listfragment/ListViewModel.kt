package droid.maxaria.maxander.simplehoroscope.fragments.listfragment

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import droid.maxaria.maxander.domain.model.ForecastModel
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
class ListViewModel @Inject constructor(val getSavedPredictsCase: GetSavedPredictsUseCase): ViewModel() {
    var data = getSavedPredictsCase.getSavedPredicts()


}