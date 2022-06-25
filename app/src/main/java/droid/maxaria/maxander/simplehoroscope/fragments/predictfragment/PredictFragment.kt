package droid.maxaria.maxander.simplehoroscope.fragments.predictfragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import droid.maxaria.maxander.data.RepositoryImpl
import droid.maxaria.maxander.data.api.ApiProvider
import droid.maxaria.maxander.domain.usecases.GetPredictUseCase
import droid.maxaria.maxander.simplehoroscope.*
import droid.maxaria.maxander.simplehoroscope.databinding.FragmentPredictBinding
import javax.inject.Inject
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

        currentSign = arguments?.getString(bundleSharedName).toString()
        mBinding.signNameTxt.text = currentSign
        mBinding.predictTxt.setText(R.string.loading)
        mViewModel.getPredict(currentSign)
        mViewModel.predictLive.observe(viewLifecycleOwner){
            activity!!.getSharedPreferences("Sign", Context.MODE_PRIVATE)!!.edit().putString(
                sharedPredictName,it.horoscope).commit()

            mBinding.predictTxt.text = it.horoscope
        }
        mBinding.predictTxtBack.setOnClickListener{
            APP_ACTIVITY.navController.navigate(R.id.action_predictFragment_to_mainFragment)
        }
    }


}