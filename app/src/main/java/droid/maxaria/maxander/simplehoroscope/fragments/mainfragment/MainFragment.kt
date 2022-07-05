package droid.maxaria.maxander.simplehoroscope.fragments.mainfragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import droid.maxaria.maxander.simplehoroscope.*
import droid.maxaria.maxander.simplehoroscope.databinding.FragmentMainBinding
import droid.maxaria.maxander.simplehoroscope.fragments.predictfragment.PredictFragment

class MainFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentMainBinding? = null
    val mBinding: FragmentMainBinding
        get() = _binding!!

    //______________________________________________________________________________________________
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initClick()
        super.onViewCreated(view, savedInstanceState)
    }

    //______________________________________________________________________________________________
    override fun onDetach() {
        _binding = null
        super.onDetach()
    }
    private fun initClick(){
        mBinding.aquariusImg.setOnClickListener(this)
        mBinding.ariesImg.setOnClickListener(this)
        mBinding.cancerImg.setOnClickListener(this)
        mBinding.leoImg.setOnClickListener(this)
        mBinding.capricornusImg.setOnClickListener(this)
        mBinding.geminiImg.setOnClickListener(this)
        mBinding.libraImg.setOnClickListener(this)
        mBinding.piscesImg.setOnClickListener(this)
        mBinding.sagittariusImg.setOnClickListener(this)
        mBinding.scorpioImg.setOnClickListener(this)
        mBinding.taurusImg.setOnClickListener(this)
        mBinding.virgioImg.setOnClickListener(this)
        mBinding.mainToSavedBtn.setOnClickListener{
            findNavController().navigate(R.id.action_mainFragment_to_listFragment)
        }
    }

    override fun onClick(view: View?) {
        Log.d("TAG", "2click")
        val fragment = when (view) {
            mBinding.aquariusImg -> PredictFragment.newBundleApi(AQUARIUS_ID)
            mBinding.ariesImg -> PredictFragment.newBundleApi(ARIES_ID)
            mBinding.cancerImg -> PredictFragment.newBundleApi(AQUARIUS_ID)
            mBinding.leoImg -> PredictFragment.newBundleApi(LEO_ID)
            mBinding.capricornusImg -> PredictFragment.newBundleApi(CAPRICORNUS_ID)
            mBinding.geminiImg -> PredictFragment.newBundleApi(GEMINI_ID)
            mBinding.libraImg -> PredictFragment.newBundleApi(LIBRA_ID)
            mBinding.piscesImg -> PredictFragment.newBundleApi(PISCES_ID)
            mBinding.sagittariusImg -> PredictFragment.newBundleApi(SAGITTARIUS_ID)
            mBinding.scorpioImg -> PredictFragment.newBundleApi(SCORPIO_ID)
            mBinding.taurusImg -> PredictFragment.newBundleApi(TAURUS_ID)
            mBinding.virgioImg -> PredictFragment.newBundleApi(VIRGIO_ID)
            else -> null
        }
        if (fragment != null)
        findNavController().navigate(R.id.action_mainFragment_to_predictFragment,fragment)
    }
}

