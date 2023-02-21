package com.akatsuki.jazireketab.ui.fragments.book_details.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.akatsuki.jazireketab.databinding.ItemMyCommentBinding
import com.akatsuki.jazireketab.models.test.book_details.Comments
import com.akatsuki.jazireketab.ui.fragments.audio_details.adapters.CoomentListAudio_Adapter


class CoomentList_Adapter : RecyclerView.Adapter<CoomentList_Adapter.MyViewHolder>(){
    private lateinit var onItemCLick: OnItemCLick

    inner class MyViewHolder(val binding: ItemMyCommentBinding):
            RecyclerView.ViewHolder(binding.root)


    private val diffCallback = object : DiffUtil.ItemCallback<Comments>() {
        override fun areItemsTheSame(oldItem: Comments, newItem: Comments): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Comments, newItem: Comments): Boolean {
            return newItem == oldItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)


    var items: List<Comments>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemMyCommentBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = items[position]
        var like =  item.like
        var dislike =item.dislike

        holder.binding.nameComment.text = item.name
        holder.binding.timeComment.text = item.timeCreated.toString()
        holder.binding.ratting.rating = item.rate.toFloat()

        holder.binding.likeComment.text = item.like.toString()
        holder.binding.dislikeComment.text = item.dislike.toString()
        holder.binding.textComment.text = item.commentText.toString()

        holder.binding.likeBtn.setOnClickListener {
            like += 1

        }

        holder.binding.unlikeBtn.setOnClickListener {
            dislike += 1

        }
        /*holder.binding.rootView.setOnClickListener{
            onItemCLick.onClick(items[position])
        }*/
    }

    override fun getItemCount(): Int {
       return items.size
    }



    fun setOnItemClickListener(onDeleteNotificationById: OnItemCLick){
        this.onItemCLick = onDeleteNotificationById
    }

    interface OnItemCLick{
        fun onClick(item: Comments)
    }


}