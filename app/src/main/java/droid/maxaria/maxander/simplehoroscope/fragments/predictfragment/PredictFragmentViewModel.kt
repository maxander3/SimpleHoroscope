package droid.maxaria.maxander.simplehoroscope.fragments.predictfragment

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import droid.maxaria.maxander.data.RepositoryImpl
import droid.maxaria.maxander.data.api.ApiProvider
import droid.maxaria.maxander.domain.model.ForecastModel
import droid.maxaria.maxander.domain.usecases.GetPredictUseCase
import droid.maxaria.maxander.domain.usecases.SavePredictUseCase
import droid.maxaria.maxander.simplehoroscope.R
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
    private var _Error = MutableLiveData<String>()
    val error
        get() = _Error


    @OptIn(DelicateCoroutinesApi::class)
    fun getPredict(sign: String) {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val result = getPredictUseCase.getPredict(sign)
                predictLive.postValue(result.body())
            } catch (exception: Exception) {
                _Error.postValue(INTERNET_ERROR)
            }
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun savePredict(predict: ForecastModel?, success: () -> Unit) {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                if (predict != null) {
                    savePredictUseCase.savePredictUseCase(predict)
                    success()
                } else {
                    _Error.postValue(SAVE_Error)
                }
                Log.d("Tag", "succes")
            } catch (exception: Exception) {
                _Error.postValue(ROOM_ERROR)
                Log.d("Tag", "Error")
            }
        }

    }

    companion object {
        const val INTERNET_ERROR = "Internet error"
        const val SAVE_Error = "Save error"
        const val ROOM_ERROR = "Room error"
    }
}