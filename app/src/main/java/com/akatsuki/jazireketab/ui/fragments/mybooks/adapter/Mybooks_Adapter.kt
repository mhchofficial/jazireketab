package com.akatsuki.jazireketab.ui.fragments.mybooks.adapter

import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.akatsuki.jazireketab.databinding.ItemMyBookBinding
import com.akatsuki.jazireketab.models.test.mybooks.Data
import com.akatsuki.jazireketab.utils.GetPath
import java.io.File


class Mybooks_Adapter : RecyclerView.Adapter<Mybooks_Adapter.MyViewHolder>(){
    private lateinit var onItemCLick: OnItemCLick

    inner class MyViewHolder(val binding: ItemMyBookBinding):
            RecyclerView.ViewHolder(binding.root)


    private val diffCallback = object : DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return newItem == oldItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)


    var items: List<Data>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemMyBookBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        )
    }

    @RequiresApi(Build.VERSION_CODES.R)
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = items[position]
        holder.binding.imageMybooks.load(item.cover)

        val path = (GetPath().toString() + item.fileName.toString())
        val search = File(path)
        Log.e("mybook adapter", path.toString())


        if (search.exists()){
            holder.binding.isDownloaded.visibility = View.GONE
        }
        else{
            holder.binding.isDownloaded.visibility = View.VISIBLE

        }



        holder.binding.mybookRoot.setOnClickListener{
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
        fun onClick(item: Data)
    }


}