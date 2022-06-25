package droid.maxaria.maxander.simplehoroscope.fragments.mainfragment

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import droid.maxaria.maxander.simplehoroscope.*
import droid.maxaria.maxander.simplehoroscope.databinding.FragmentMainBinding

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
        Log.d("TAG", "2click")
        val bundle = Bundle()
        val editor = activity!!.getSharedPreferences("Sign",
            Context.MODE_PRIVATE)!!.edit()
        when (p0) {
            mBinding.aquariusImg -> {
                bundle.putString(bundleSharedName, AQUARIUS_ID)
                editor.putString(bundleSharedName, AQUARIUS_ID)
            }
            mBinding.ariesImg -> {
                bundle.putString(bundleSharedName, ARIES_ID)
                editor.putString(bundleSharedName, ARIES_ID)
            }
            mBinding.cancerImg -> {
                bundle.putString(bundleSharedName, CANCER_ID)
                editor.putString(bundleSharedName, CANCER_ID)
            }
            mBinding.leoImg -> {
                bundle.putString(bundleSharedName, LEO_ID)
                editor.putString(bundleSharedName, LEO_ID)
            }
            mBinding.capricornusImg -> {
                bundle.putString(bundleSharedName, CAPRICORNUS_ID)
                editor.putString(bundleSharedName, CAPRICORNUS_ID)
            }
            mBinding.geminiImg -> {
                bundle.putString(bundleSharedName, GEMINI_ID)
                editor.putString(bundleSharedName, GEMINI_ID)
            }
            mBinding.libraImg -> {
                bundle.putString(bundleSharedName, LIBRA_ID)
                editor.putString(bundleSharedName, LIBRA_ID)
            }
            mBinding.piscesImg -> {
                bundle.putString(bundleSharedName, PISCES_ID)
                editor.putString(bundleSharedName, PISCES_ID)
            }
            mBinding.sagittariusImg -> {
                bundle.putString(bundleSharedName, SAGITTARIUS_ID)
                editor.putString(bundleSharedName, SAGITTARIUS_ID)
            }
            mBinding.scorpioImg -> {
                bundle.putString(bundleSharedName, SCORPIO_ID)
                editor.putString(bundleSharedName, SCORPIO_ID)
            }
            mBinding.taurusImg -> {
                bundle.putString(bundleSharedName, TAURUS_ID)
                editor.putString(bundleSharedName, TAURUS_ID)
            }
            mBinding.virgioImg -> {
                bundle.putString(bundleSharedName, VIRGO_ID)
                editor.putString(bundleSharedName, VIRGO_ID)
            }
            else -> bundle.putString(bundleSharedName, ERROR_String)
        }
        editor.commit()
        APP_ACTIVITY.navController.navigate(R.id.action_mainFragment_to_predictFragment, bundle)
    }


}