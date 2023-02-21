package com.akatsuki.jazireketab.ui.fragments.home.adapters

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.Coil
import coil.load
import com.akatsuki.jazireketab.databinding.ItemPoserCenterBinding
import com.akatsuki.jazireketab.databinding.ItemTopListsBlackBinding

import com.akatsuki.jazireketab.models.posterCenterModel.ItemPosterCenterModel
import com.akatsuki.jazireketab.models.test.DataX


class Audio_Adapter : RecyclerView.Adapter<Audio_Adapter.MyViewHolder>(){
    private lateinit var onItemCLick: OnItemCLick

    inner class MyViewHolder(val binding: ItemPoserCenterBinding):
            RecyclerView.ViewHolder(binding.root)


    private val diffCallback = object : DiffUtil.ItemCallback<DataX>() {
        override fun areItemsTheSame(oldItem: DataX, newItem: DataX): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: DataX, newItem: DataX): Boolean {
            return newItem == oldItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)


    var items: List<DataX>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemPoserCenterBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = items[position]
        holder.binding.caption.text = item.caption
        holder.binding.bookCover.load(item.cover)
        holder.binding.rootView.setCardBackgroundColor(Color.parseColor("#${item.background}"))
        holder.binding.rootView.setOnClickListener{
            onItemCLick.onClick(items[position])
        }
    }

    override fun getItemCount(): Int {
       return items.size
    }



    fun setOnItemClickListener(onNotificationById: OnItemCLick){
        this.onItemCLick = onNotificationById
    }

    interface OnItemCLick{
        fun onClick(item: DataX)
    }


}