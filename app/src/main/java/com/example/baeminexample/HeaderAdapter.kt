package com.example.baeminexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.example.baeminexample.databinding.ItemHeaderBinding

/**
 * baemin example
 * Class: HeaderAdapter
 * Created by 82102 on 2021-12-21.
 *
 * Description:
 */
class HeaderAdapter(private var image: ArrayList<Int>) : RecyclerView.Adapter<HeaderAdapter.ViewHolder>() {


    class ViewHolder(private val binding: ItemHeaderBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(dataSet: List<Int>, position: Int) {

            binding.imageViewIdol.setImageResource( dataSet[position])
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHeaderBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
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