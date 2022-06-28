package droid.maxaria.maxander.simplehoroscope.fragments.listfragment


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import droid.maxaria.maxander.domain.model.ForecastModel
import droid.maxaria.maxander.simplehoroscope.APP_ACTIVITY
import droid.maxaria.maxander.simplehoroscope.PREDICT
import droid.maxaria.maxander.simplehoroscope.R
import droid.maxaria.maxander.simplehoroscope.databinding.PredictCardBinding
import javax.inject.Inject

class ListAdapter @Inject constructor(): RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private var _data:List<ForecastModel> = emptyList()
    private val mData
        get() = _data

    inner class ListViewHolder(binding: PredictCardBinding):RecyclerView.ViewHolder(binding.root){
        val date = binding.cardDate
        val sign = binding.cardSign
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(PredictCardBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.itemView.setOnClickListener{
            val bundle = Bundle()
            bundle.putSerializable(PREDICT,mData[position])
            Log.d("TAG",mData[position].toString())
            APP_ACTIVITY.navController.navigate(R.id.action_listFragment_to_predictFragment,bundle)
        }
        holder.apply {
            date.text = mData[position].date
            sign.text = mData[position].sign
        }
    }
    override fun getItemCount(): Int = mData.size

    fun update(data:List<ForecastModel>){
        _data=data.reversed()
        notifyDataSetChanged()
    }
}