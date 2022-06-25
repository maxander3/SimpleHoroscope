package droid.maxaria.maxander.simplehoroscope.fragments.predictfragment

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import droid.maxaria.maxander.data.RepositoryImpl
import droid.maxaria.maxander.data.api.ApiProvider
import droid.maxaria.maxander.domain.model.ForecastModel
import droid.maxaria.maxander.domain.usecases.GetPredictUseCase
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PredictFragmentViewModel @Inject constructor (private val getPredictUseCase: GetPredictUseCase): ViewModel() {
    var predictLive = MutableLiveData<ForecastModel>()


    @OptIn(DelicateCoroutinesApi::class)
    fun getPredict(sign:String){
        GlobalScope.launch(Dispatchers.IO) {
            val result=getPredictUseCase.getPredict(sign)
            predictLive.postValue(result.body())
            Log.d("TAG",result.body().toString())
        }
    }
}