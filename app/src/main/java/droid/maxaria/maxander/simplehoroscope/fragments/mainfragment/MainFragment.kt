package droid.maxaria.maxander.simplehoroscope.fragments.mainfragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        mBinding.mainToSavedBtn.setOnClickListener{
            APP_ACTIVITY.navController.navigate(R.id.action_mainFragment_to_listFragment)
        }
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
                bundle.putString(ZODIAC, AQUARIUS_ID)
                editor.putString(ZODIAC, AQUARIUS_ID)
            }
            mBinding.ariesImg -> {
                bundle.putString(ZODIAC, ARIES_ID)
                editor.putString(ZODIAC, ARIES_ID)
            }
            mBinding.cancerImg -> {
                bundle.putString(ZODIAC, CANCER_ID)
                editor.putString(ZODIAC, CANCER_ID)
            }
            mBinding.leoImg -> {
                bundle.putString(ZODIAC, LEO_ID)
                editor.putString(ZODIAC, LEO_ID)
            }
            mBinding.capricornusImg -> {
                bundle.putString(ZODIAC, CAPRICORNUS_ID)
                editor.putString(ZODIAC, CAPRICORNUS_ID)
            }
            mBinding.geminiImg -> {
                bundle.putString(ZODIAC, GEMINI_ID)
                editor.putString(ZODIAC, GEMINI_ID)
            }
            mBinding.libraImg -> {
                bundle.putString(ZODIAC, LIBRA_ID)
                editor.putString(ZODIAC, LIBRA_ID)
            }
            mBinding.piscesImg -> {
                bundle.putString(ZODIAC, PISCES_ID)
                editor.putString(ZODIAC, PISCES_ID)
            }
            mBinding.sagittariusImg -> {
                bundle.putString(ZODIAC, SAGITTARIUS_ID)
                editor.putString(ZODIAC, SAGITTARIUS_ID)
            }
            mBinding.scorpioImg -> {
                bundle.putString(ZODIAC, SCORPIO_ID)
                editor.putString(ZODIAC, SCORPIO_ID)
            }
            mBinding.taurusImg -> {
                bundle.putString(ZODIAC, TAURUS_ID)
                editor.putString(ZODIAC, TAURUS_ID)
            }
            mBinding.virgioImg -> {
                bundle.putString(ZODIAC, VIRGO_ID)
                editor.putString(ZODIAC, VIRGO_ID)
            }
            else -> bundle.putString(ZODIAC, ERROR_String)
        }
        editor.commit()
        APP_ACTIVITY.navController.navigate(R.id.action_mainFragment_to_predictFragment,bundle)
    }
}

