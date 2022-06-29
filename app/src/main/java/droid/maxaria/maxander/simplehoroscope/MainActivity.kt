package droid.maxaria.maxander.simplehoroscope

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.NavHost
import dagger.hilt.android.AndroidEntryPoint
import droid.maxaria.maxander.simplehoroscope.databinding.ActivityMainBinding
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    //______________________________________________________________________________________________
    private var _binding:ActivityMainBinding?=null
    lateinit var navController: NavController
    val mBinding:ActivityMainBinding
        get() = _binding!!
    //______________________________________________________________________________________________
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

    }
    //______________________________________________________________________________________________
    override fun onDestroy() {
        _binding=null
        super.onDestroy()
    }
    //______________________________________________________________________________________________
}