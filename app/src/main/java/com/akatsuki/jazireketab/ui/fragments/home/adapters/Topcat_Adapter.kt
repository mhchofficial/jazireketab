package com.akatsuki.jazireketab.ui.fragments.home.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.akatsuki.jazireketab.databinding.ItemTopCatsBinding
import com.akatsuki.jazireketab.models.test.TopCategory


class Topcat_Adapter : RecyclerView.Adapter<Topcat_Adapter.MyViewHolder>(){
    private lateinit var onItemCLick: OnItemCLick

    inner class MyViewHolder(val binding: ItemTopCatsBinding):
            RecyclerView.ViewHolder(binding.root)


    private val diffCallback = object : DiffUtil.ItemCallback<TopCategory>() {
        override fun areItemsTheSame(oldItem: TopCategory, newItem: TopCategory): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TopCategory, newItem: TopCategory): Boolean {
            return newItem == oldItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)


    var items: List<TopCategory>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemTopCatsBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = items[position]
        holder.binding.topcatSubject.text = item.subject
        Log.e("topcat", item.subject.toString())

        holder.binding.rootTopcat.setOnClickListener{
            onItemCLick.onClick(items[position])
        }
    }

    override fun getItemCount(): Int {
       return items.size
    }



    fun setOnItemClickListener(onDeleteNotificationById: OnItemCLick){
        this.onItemCLick = onDeleteNotificationById
    }

    interface OnItemCLick{
        fun onClick(item: TopCategory)
    }


}