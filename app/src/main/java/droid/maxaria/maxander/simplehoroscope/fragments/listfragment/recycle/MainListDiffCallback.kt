package droid.maxaria.maxander.simplehoroscope.fragments.listfragment.recycle

import androidx.recyclerview.widget.DiffUtil
import droid.maxaria.maxander.domain.model.ForecastModel

class MainListDiffCallback: DiffUtil.ItemCallback<ForecastModel>() {
    override fun areItemsTheSame(oldItem: ForecastModel, newItem: ForecastModel): Boolean {
        return ((oldItem.date ==newItem.date) && (oldItem.sign == newItem.sign))
    }

    override fun areContentsTheSame(oldItem: ForecastModel, newItem: ForecastModel): Boolean {
        return (oldItem == newItem)
    }
}