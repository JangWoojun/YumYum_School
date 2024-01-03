package com.woojun.yumyumschool

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.woojun.yumyumschool.databinding.LunchItemBinding

class FoodRecyclerAdapter(private val foodList: List<FoodInfo>): RecyclerView.Adapter<FoodRecyclerAdapter.FoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val binding = LunchItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(binding).also { handler ->

        }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(foodList[position])
    }

    class FoodViewHolder(private val binding: LunchItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(foodInfo: FoodInfo) {
            binding.apply {

            }
        }
    }

}