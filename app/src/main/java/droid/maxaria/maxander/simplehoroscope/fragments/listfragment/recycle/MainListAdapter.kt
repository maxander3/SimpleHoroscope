package droid.maxaria.maxander.simplehoroscope.fragments.listfragment.recycle


import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import droid.maxaria.maxander.domain.model.ForecastModel
import droid.maxaria.maxander.simplehoroscope.databinding.PredictCardBinding
import droid.maxaria.maxander.simplehoroscope.fragments.predictfragment.PredictFragment
import javax.inject.Inject

class MainListAdapter @Inject constructor(): ListAdapter<ForecastModel,MainListViewHolder>(MainListDiffCallback()) {

    var onSignItemClickListener:((bundle:Bundle)->Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListViewHolder {
        return MainListViewHolder(PredictCardBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }


    override fun onBindViewHolder(holder: MainListViewHolder, position: Int) {
        holder.itemView.setOnClickListener{
            val bundle = PredictFragment.newBundleRoom(getItem(position))
            onSignItemClickListener?.invoke(bundle)
        }
        holder.apply {
            date.text = getItem(position).date
            sign.text = getItem(position).sign
        }
    }


}