package com.example.baeminexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.example.baeminexample.databinding.ItemHeaderBinding
import com.example.baeminexample.databinding.ItemScrollCenterBinding
import com.example.baeminexample.databinding.ItemScrollHeaderBinding
import com.example.baeminexample.databinding.ItemScrollPresentBinding

/**
 * baemin example
 * Class: HeaderAdapter
 * Created by 82102 on 2021-12-21.
 *
 * Description:
 */
class ScrollPresentAdapter(private var image: ArrayList<Int>) : RecyclerView.Adapter<ScrollPresentAdapter.ViewHolder>() {


    class ViewHolder(private val binding: ItemScrollPresentBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(dataSet: List<Int>, position: Int) {

            binding.imageViewIdol.setBackgroundResource( dataSet[position])
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemScrollPresentBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(image, position)
    }

    override fun getItemCount() = image.size

    fun setData(newDataSet: ArrayList<Int>) {
        image = newDataSet
        notifyDataSetChanged()
    }
}