package droid.maxaria.maxander.simplehoroscope.fragments.listfragment.recycle

import androidx.recyclerview.widget.RecyclerView
import droid.maxaria.maxander.simplehoroscope.databinding.PredictCardBinding

class MainListViewHolder(binding: PredictCardBinding): RecyclerView.ViewHolder(binding.root){
    val date = binding.cardDate
    val sign = binding.cardSign
}