package droid.maxaria.maxander.simplehoroscope.fragments.predictfragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import droid.maxaria.maxander.data.RepositoryImpl
import droid.maxaria.maxander.data.api.ApiProvider
import droid.maxaria.maxander.domain.model.ForecastModel
import droid.maxaria.maxander.domain.usecases.GetPredictUseCase
import droid.maxaria.maxander.simplehoroscope.*
import droid.maxaria.maxander.simplehoroscope.databinding.FragmentPredictBinding
import java.lang.RuntimeException

@AndroidEntryPoint
class PredictFragment : Fragment() {

    private val mViewModel: PredictFragmentViewModel by viewModels()
    private var _binding: FragmentPredictBinding? = null
    private val mBinding: FragmentPredictBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentPredictBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun init() {
        parseParams()

        mBinding.btnSave.setOnClickListener {
            mViewModel.savePredict(mViewModel.predictLive.value?.copy()
                ?: return@setOnClickListener) {
                Toast.makeText(activity, R.string.success, Toast.LENGTH_SHORT).show()
            }
        }
        observeViewModel()
        mBinding.predictTxtBack.setOnClickListener {
            activity?.onBackPressed()
        }
    }

    private fun observeViewModel() {
        mViewModel.predictLive.observe(viewLifecycleOwner) {
            mBinding.signNameTxt.text = it.sign
            mBinding.predictTxt.text = it.horoscope
        }
    }

    private fun parseParams() {
        mViewModel.currentMode = arguments?.getString(FRAGMENT_MODE)
            ?: throw RuntimeException("Unknown Mode")
        when (mViewModel.currentMode) {
            API_MODE -> {
                mViewModel.currentSign = arguments?.getString(ZODIAC)
                    ?: throw RuntimeException("Unknown sign")
                launchApiMode()
            }
            ROOM_MODE -> {
                mViewModel.currentPredict = (arguments?.getSerializable(MODEL) as ForecastModel?
                    ?: throw RuntimeException("UnknownPredict"))
                launchRoomMode()
            }
            else -> throw RuntimeException("Unknown Mode")
        }
    }

    private fun launchApiMode() {
        mBinding.predictTxt.setText(R.string.loading)
        mViewModel.getPredict(mViewModel.currentSign!!)
        mBinding.btnSave.visibility = View.VISIBLE
    }

    private fun launchRoomMode() {
        mViewModel.predictLive.value = mViewModel.currentPredict
        mBinding.btnSave.visibility = View.INVISIBLE
    }

    companion object {
        private const val FRAGMENT_MODE = "fragment mode"
        private const val API_MODE = "api mode"
        private const val ROOM_MODE = "room mode"
        private const val MODEL = "model"
        private const val ZODIAC = "zodiac"
        fun newBundleApi(sign: String): Bundle {
            return Bundle().apply {
                putString(FRAGMENT_MODE, API_MODE)
                putString(ZODIAC, sign)
            }
        }

        fun newBundleRoom(model: ForecastModel): Bundle {
            return Bundle().apply {
                putString(FRAGMENT_MODE, ROOM_MODE)
                putSerializable(MODEL, model)
            }
        }
    }
}