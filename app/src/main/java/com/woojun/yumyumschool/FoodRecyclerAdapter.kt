package com.woojun.yumyumschool

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.woojun.yumyumschool.databinding.LunchItemBinding
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class FoodRecyclerAdapter(private val foodInfoList: List<FoodInfo>): RecyclerView.Adapter<FoodRecyclerAdapter.FoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val binding = LunchItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(binding).also { handler ->

        }
    }

    override fun getItemCount(): Int {
        return foodInfoList.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(foodInfoList[position])
    }

    class FoodViewHolder(private val binding: LunchItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(foodInfo: FoodInfo) {
            binding.apply {
                val foodName = foodInfo.DDISH_NM[position]
                if (position == 0) {
                    val inputFormatter = DateTimeFormatter.ofPattern("yyyyMMdd")
                    val outputFormatter = DateTimeFormatter.ofPattern("MM월 dd일")
                    val date = LocalDate.parse(foodInfo.MLSV_YMD, inputFormatter)
                    val formattedDate = date.format(outputFormatter)

                    imageView.setImageResource(R.drawable.food)
                    titleText.text = "$formattedDate 중식"
                    contentText.text = foodName.replace("<br/>", "\n")
                } else {
                    if (foodName.contains("밥")) {
                        imageView.setImageResource(R.drawable.rice)
                    } else if (foodName.contains("국")) {
                        imageView.setImageResource(R.drawable.soup)
                    } else {
                        imageView.setImageResource(R.drawable.side_dish)
                    }
                    titleText.text = foodName
                    contentText.text = "${foodName}에 대해 더 알아보고 싶으시면 클릭해주세요"
                }

            }
        }
    }

}