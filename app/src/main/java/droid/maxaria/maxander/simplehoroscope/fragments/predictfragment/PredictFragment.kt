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
import droid.maxaria.maxander.domain.usecases.GetPredictUseCase
import droid.maxaria.maxander.simplehoroscope.APP_ACTIVITY
import droid.maxaria.maxander.simplehoroscope.App
import droid.maxaria.maxander.simplehoroscope.R
import droid.maxaria.maxander.simplehoroscope.databinding.FragmentPredictBinding
@AndroidEntryPoint
class PredictFragment : Fragment() {

    private val mViewModel:PredictFragmentViewModel by viewModels()
    private var _binding: FragmentPredictBinding? = null
    private val mBinding: FragmentPredictBinding
        get() = _binding!!
    private lateinit var currentSign:String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentPredictBinding.inflate(layoutInflater,container,false)
        init()
        return mBinding.root
    }


    override fun onDestroyView() {
        _binding = null
        mViewModel.predictLive.removeObservers(viewLifecycleOwner)
        super.onDestroyView()
    }

    private fun init(){

        currentSign = arguments?.getString("zodiac_sign").toString()
        mBinding.signNameTxt.text = currentSign
        mBinding.predictTxt.setText(R.string.loading)
        mViewModel.getPredict(currentSign)
        mViewModel.predictLive.observe(viewLifecycleOwner){
            mBinding.predictTxt.text = it.horoscope
        }
        mBinding.btnSave.setOnClickListener{
            mViewModel.savePredict(mViewModel.predictLive.value?.copy() ?: return@setOnClickListener){
                Toast.makeText(APP_ACTIVITY,R.string.success,Toast.LENGTH_SHORT).show()
            }
        }
        mBinding.predictTxtBack.setOnClickListener{
            APP_ACTIVITY.navController.navigate(R.id.action_predictFragment_to_mainFragment)
        }
    }


}