package droid.maxaria.maxander.simplehoroscope.fragments.listfragment

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import droid.maxaria.maxander.simplehoroscope.R
import droid.maxaria.maxander.simplehoroscope.databinding.FragmentListBinding
import droid.maxaria.maxander.simplehoroscope.fragments.listfragment.recycle.MainListAdapter
import droid.maxaria.maxander.simplehoroscope.fragments.predictfragment.PredictFragment
import javax.inject.Inject

@AndroidEntryPoint
class ListFragment : Fragment() {


    private val mViewModel: ListViewModel by viewModels()
    private var _binding:FragmentListBinding? = null
    private val mBinding:FragmentListBinding
        get() = _binding!!
    var landscapeMode = false
    @Inject
    lateinit var adapter: MainListAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding=FragmentListBinding.inflate(inflater,container,false)

        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init()
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDetach() {
        _binding = null
        super.onDetach()
    }
    private fun checkScreenMode():Boolean{
        return when (resources.configuration.orientation){
            Configuration.ORIENTATION_PORTRAIT-> false
            Configuration.ORIENTATION_LANDSCAPE-> true
            else->throw RuntimeException("Unknown screen mode")
        }
    }
    private fun init(){
        landscapeMode = checkScreenMode()
        adapter.onSignItemClickListener = {
            launchFragment(it)
        }
        recyclerView = mBinding.list
        recyclerView.adapter = adapter
        mViewModel.data.observe(viewLifecycleOwner){
            if (it.isNotEmpty()) {
                adapter.submitList(it)
            }
        }
        recyclerSwipe()
    }

    private fun recyclerSwipe() {
        val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder,
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                mViewModel.deletePredict(adapter.currentList[viewHolder.adapterPosition])
            }

        })
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }
    private fun launchFragment(bundle:Bundle){
        if (landscapeMode) {
            val fragment= PredictFragment().apply {
                arguments = bundle
            }

            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container2,fragment)
                .addToBackStack(null)
                .commit()
        } else {
            findNavController().navigate(R.id.action_listFragment_to_predictFragment,
                bundle)
        }
    }


}