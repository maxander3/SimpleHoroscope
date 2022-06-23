package droid.maxaria.maxander.simplehoroscope

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.NavHost
import droid.maxaria.maxander.simplehoroscope.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //______________________________________________________________________________________________
    val mViewModel:MainViewModel by viewModels<MainViewModel>()
    private var _binding:ActivityMainBinding?=null
    lateinit var navController: NavController
    val mBinding:ActivityMainBinding
        get() = _binding!!
    //______________________________________________________________________________________________
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        APP_ACTIVITY=this
        navController=(supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHost).navController
            // mViewModel.getPredict("aquarius")
    }
    //______________________________________________________________________________________________
    override fun onDestroy() {
        _binding=null
        super.onDestroy()
    }
    //______________________________________________________________________________________________
}