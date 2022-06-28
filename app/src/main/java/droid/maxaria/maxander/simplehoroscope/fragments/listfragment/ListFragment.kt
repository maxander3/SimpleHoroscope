package droid.maxaria.maxander.simplehoroscope.fragments.listfragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import droid.maxaria.maxander.simplehoroscope.databinding.FragmentListBinding
import javax.inject.Inject
@AndroidEntryPoint
class ListFragment : Fragment() {


    private val mViewModel: ListViewModel by viewModels()
    private var _binding:FragmentListBinding? = null
    private val mBinding:FragmentListBinding
        get() = _binding!!
    private lateinit var adapter:ListAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding=FragmentListBinding.inflate(inflater,container,false)
        init()
        return mBinding.root
    }
    private fun init(){
        adapter = ListAdapter()
        recyclerView = mBinding.list
        recyclerView.adapter = adapter
        mViewModel.data.observe(viewLifecycleOwner){
            Log.d("TAG",it.toString())
            if (it.isNotEmpty()) {
                adapter.update(it)
            }
        }
    }


}