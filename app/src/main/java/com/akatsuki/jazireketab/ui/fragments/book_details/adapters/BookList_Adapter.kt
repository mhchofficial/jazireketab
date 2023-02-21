package com.akatsuki.jazireketab.ui.fragments.book_details.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.akatsuki.jazireketab.databinding.ItemListsDaynightBinding
import com.akatsuki.jazireketab.models.test.book_details.Books
import com.akatsuki.jazireketab.ui.fragments.audio_details.adapters.BookListAudio_Adapter


class BookList_Adapter : RecyclerView.Adapter<BookList_Adapter.MyViewHolder>(){
    private lateinit var onItemCLick: OnItemCLick

    inner class MyViewHolder(val binding: ItemListsDaynightBinding):
            RecyclerView.ViewHolder(binding.root)


    private val diffCallback = object : DiffUtil.ItemCallback<Books>() {
        override fun areItemsTheSame(oldItem: Books, newItem: Books): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Books, newItem: Books): Boolean {
            return newItem == oldItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)


    var items: List<Books>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemListsDaynightBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = items[position]

        holder.binding.subject.text = item.name
        holder.binding.price.text = item.price.toString()
        holder.binding.ratting.text = item.rating.toString()
        holder.binding.imageMybooks.load(item.cover)
        if (item.isAudio){
            holder.binding.isAudioView.visibility = View.VISIBLE
        }else{
            holder.binding.isAudioView.visibility = View.GONE
        }
        holder.binding.rootView.setOnClickListener{
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
        fun onClick(item: Books)
    }



}