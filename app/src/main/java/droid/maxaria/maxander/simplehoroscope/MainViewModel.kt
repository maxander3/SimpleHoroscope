package droid.maxaria.maxander.simplehoroscope

import android.util.Log
import androidx.lifecycle.ViewModel
import droid.maxaria.maxander.data.RepositoryImpl
import droid.maxaria.maxander.data.api.ApiProvider
import droid.maxaria.maxander.domain.Repository
import droid.maxaria.maxander.domain.usecases.GetPredictUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {

    private val api=ApiProvider()
    private val repository=RepositoryImpl(api)
    private val getPredictUseCase=GetPredictUseCase(repository)
    //TODO DI
    fun getPredict(sign:String){
        GlobalScope.launch(Dispatchers.IO) {
            val result=getPredictUseCase.getPredict(sign)
            Log.d("TAG",result.body().toString())
        }
    }

}