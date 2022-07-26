package droid.maxaria.maxander.simplehoroscope.fragments.predictfragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import droid.maxaria.maxander.domain.model.ForecastModel
import droid.maxaria.maxander.domain.usecases.GetPredictUseCase
import droid.maxaria.maxander.domain.usecases.SavePredictUseCase
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PredictFragmentViewModel @Inject constructor(
    private val getPredictUseCase: GetPredictUseCase,
    private val savePredictUseCase: SavePredictUseCase,
) : ViewModel() {
    var currentMode: String? = null
    var currentSign: String? = null
    var currentPredict: ForecastModel? = null
    private var _predictLive = MutableLiveData<ForecastModel>()
    val predictLive
        get() = _predictLive
    private var _error = MutableLiveData<String>()
    val error
        get() = _error
    private val _successSave = MutableLiveData<Unit>()
    val successSave:LiveData<Unit>
        get() = _successSave


    fun getPredict(sign: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = getPredictUseCase.getPredict(sign)
                predictLive.postValue(result.body())
            } catch (exception: Exception) {
                _error.postValue(INTERNET_ERROR)
            }
        }
    }

    fun savePredict(predict: ForecastModel?) {
        viewModelScope.launch(Dispatchers.IO) {
                try {
                    if (predict != null) {
                        savePredictUseCase.savePredictUseCase(predict)
                        _successSave.postValue(Unit)
                    } else {
                        _error.postValue(SAVE_Error)
                    }
                }catch (e:Exception) {
                    _error.postValue(ROOM_ERROR)
                }
        }

    }

    companion object {
        const val INTERNET_ERROR = "Internet error"
        const val SAVE_Error = "Save error"
        const val ROOM_ERROR = "Room error"
    }
}