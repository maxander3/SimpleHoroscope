package droid.maxaria.maxander.simplehoroscope.fragments.predictfragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import droid.maxaria.maxander.simplehoroscope.R

class PredictFragment : Fragment() {

    companion object {
        fun newInstance() = PredictFragment()
    }

    private lateinit var viewModel: PredictFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_predict, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PredictFragmentViewModel::class.java)
        // TODO: Use the ViewModel
    }

}