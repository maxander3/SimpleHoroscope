package droid.maxaria.maxander.simplehoroscope.fragments.listfragment


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import droid.maxaria.maxander.domain.model.ForecastModel
import droid.maxaria.maxander.simplehoroscope.databinding.FragmentListBinding
import droid.maxaria.maxander.simplehoroscope.databinding.PredictCardBinding
import javax.inject.Inject

class ListAdapter @Inject constructor(): RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private var _data:List<ForecastModel> = emptyList()
    private val mData
        get() = _data

    inner class ListViewHolder(binding: PredictCardBinding):RecyclerView.ViewHolder(binding.root){
        val date = binding.cardDate
        val sign = binding.cardSign
        val txt = binding.cardTxt
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(PredictCardBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.apply {
            date.text = mData[position].date
            sign.text = mData[position].sign
            txt.text = mData[position].horoscope
        }
    }

    override fun getItemCount(): Int = mData.size

    fun update(data:List<ForecastModel>){
        _data=data
        notifyDataSetChanged()
    }
}