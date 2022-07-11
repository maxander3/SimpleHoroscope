package droid.maxaria.maxander.simplehoroscope

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isNotEmpty
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.NavController
import androidx.navigation.NavHost
import dagger.hilt.android.AndroidEntryPoint
import droid.maxaria.maxander.simplehoroscope.databinding.ActivityMainBinding
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    //______________________________________________________________________________________________
    private var _binding:ActivityMainBinding?=null
    val mBinding:ActivityMainBinding
        get() = _binding!!
    private var rightContainer:FragmentContainerView? = null
    //______________________________________________________________________________________________
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        rightContainer = mBinding.fragmentContainer2
    }

    //______________________________________________________________________________________________
    override fun onDestroy() {
        _binding=null
        super.onDestroy()
    }
    //______________________________________________________________________________________________
    override fun onBackPressed() {
        if (mBinding.fragmentContainer2?.isNotEmpty() == true){
            mBinding.fragmentContainer2?.removeAllViews()
        }else {
            super.onBackPressed()
        }
    }
}