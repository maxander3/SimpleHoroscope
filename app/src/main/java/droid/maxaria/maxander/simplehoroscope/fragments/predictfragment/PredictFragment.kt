package droid.maxaria.maxander.simplehoroscope.fragments.predictfragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import droid.maxaria.maxander.domain.model.ForecastModel
import droid.maxaria.maxander.simplehoroscope.R
import droid.maxaria.maxander.simplehoroscope.databinding.FragmentPredictBinding

class PredictFragment : Fragment() {


    private val mViewModel: PredictFragmentViewModel by viewModels<PredictFragmentViewModel>()
    private var _binding: FragmentPredictBinding? = null
    val mBinding: FragmentPredictBinding
        get() = _binding!!
    private lateinit var currentSign:String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentPredictBinding.inflate(layoutInflater,container,false)
        currentSign = arguments?.getString("zodiac_sign").toString()
        mViewModel.getPredict(currentSign)
        mViewModel.predictLive.observe(viewLifecycleOwner){
            mBinding.predictTxt.text = it.horoscope
        }
        return mBinding.root
    }

    override fun onDetach() {
        _binding = null
        mViewModel.predictLive.removeObservers(viewLifecycleOwner)
        super.onDetach()
    }


}