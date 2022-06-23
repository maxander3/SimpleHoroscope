package droid.maxaria.maxander.simplehoroscope.fragments.mainfragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.viewModels
import droid.maxaria.maxander.simplehoroscope.*
import droid.maxaria.maxander.simplehoroscope.databinding.FragmentMainBinding

class MainFragment : Fragment(),View.OnClickListener {

    private var _binding:FragmentMainBinding? = null
    val mBinding:FragmentMainBinding
    get() = _binding!!
    val mViewModel:MainFragmentViewModel by viewModels<MainFragmentViewModel>()

    //______________________________________________________________________________________________
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding=FragmentMainBinding.inflate(layoutInflater,container,false)
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
        return mBinding.root
    }

    //______________________________________________________________________________________________
    override fun onDetach() {
        _binding = null
        super.onDetach()
    }

    override fun onClick(p0: View?) {
            Log.d("TAG","2click")
            val bundle=Bundle()
            when (p0) {
                mBinding.aquariusImg->bundle.putString("zodiac_sign", AQUARIUS_ID)
                mBinding.ariesImg->bundle.putString("zodiac_sign", ARIES_ID)
                mBinding.cancerImg->bundle.putString("zodiac_sign", CANCER_ID)
                mBinding.leoImg->bundle.putString("zodiac_sign", LEO_ID)
                mBinding.capricornusImg->bundle.putString("zodiac_sign", CAPRICORNUS_ID)
                mBinding.geminiImg->bundle.putString("zodiac_sign", GEMINI_ID)
                mBinding.libraImg->bundle.putString("zodiac_sign", LIBRA_ID)
                mBinding.piscesImg->bundle.putString("zodiac_sign", PISCES_ID)
                mBinding.sagittariusImg->bundle.putString("zodiac_sign", SAGITTARIUS_ID)
                mBinding.scorpioImg->bundle.putString("zodiac_sign", SCORPIO_ID)
                mBinding.taurusImg->bundle.putString("zodiac_sign", TAURUS_ID)
                mBinding.virgioImg->bundle.putString("zodiac_sign", VIRGO_ID)
                else->bundle.putString("zodiac_sign", ERROR_String)
            }
            if (bundle!=null)
                APP_ACTIVITY.navController.navigate(R.id.action_mainFragment_to_predictFragment,bundle)
    }


}