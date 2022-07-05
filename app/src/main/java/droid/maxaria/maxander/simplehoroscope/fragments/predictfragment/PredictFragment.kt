package droid.maxaria.maxander.simplehoroscope.fragments.predictfragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import droid.maxaria.maxander.data.RepositoryImpl
import droid.maxaria.maxander.data.api.ApiProvider
import droid.maxaria.maxander.domain.model.ForecastModel
import droid.maxaria.maxander.domain.usecases.GetPredictUseCase
import droid.maxaria.maxander.simplehoroscope.*
import droid.maxaria.maxander.simplehoroscope.databinding.FragmentPredictBinding
@AndroidEntryPoint
class PredictFragment : Fragment() {

    private val mViewModel:PredictFragmentViewModel by viewModels()
    private var _binding: FragmentPredictBinding? = null
    private val mBinding: FragmentPredictBinding
        get() = _binding!!
    private var currentSign:String? = null
    private var currentPredict:ForecastModel? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentPredictBinding.inflate(layoutInflater,container,false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun init(){

        currentSign = arguments?.getString(ZODIAC)
        currentPredict = arguments?.getSerializable(PREDICT) as ForecastModel?
        Log.d("taf", currentSign.toString())
        if (currentSign != null) {
            mBinding.predictTxt.setText(R.string.loading)
            mViewModel.getPredict(currentSign!!)
            mBinding.btnSave.visibility = View.VISIBLE
        }else{
           if (currentPredict != null) {
               mViewModel.predictLive.value = currentPredict
               mBinding.btnSave.visibility = View.INVISIBLE
           }
        }
        mViewModel.predictLive.observe(viewLifecycleOwner){
            mBinding.signNameTxt.text = it.sign
            mBinding.predictTxt.text = it.horoscope
        }
        mBinding.btnSave.setOnClickListener{
            mViewModel.savePredict(mViewModel.predictLive.value?.copy() ?: return@setOnClickListener){
                Toast.makeText(activity,R.string.success,Toast.LENGTH_SHORT).show()
            }
        }
        mBinding.predictTxtBack.setOnClickListener{
            activity?.onBackPressed()
        }
    }


}