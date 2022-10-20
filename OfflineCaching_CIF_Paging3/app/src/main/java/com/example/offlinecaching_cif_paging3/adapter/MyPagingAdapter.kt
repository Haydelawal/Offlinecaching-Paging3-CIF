package com.example.offlinecaching_cif_paging3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bumptech.glide.Glide
import  com.example.offlinecaching_cif_paging3.adapter.MyPagingAdapter.MyViewHolder
import com.example.offlinecaching_cif_paging3.model.RestApiResponse
import com.example.offlinecaching_cif_paging3.databinding.CustomLayoutBinding

class MyPagingAdapter : PagingDataAdapter<RestApiResponse, MyViewHolder>(diffCallBack) {

    inner class MyViewHolder( val binding: CustomLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    companion object {
        val diffCallBack = object : DiffUtil.ItemCallback<RestApiResponse>() {
            override fun areItemsTheSame(oldItem: RestApiResponse, newItem: RestApiResponse): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: RestApiResponse, newItem: RestApiResponse): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = getItem(position)

        holder.binding.apply {
            textView.text = currentItem?.name

            Glide.with(holder.itemView)
                .load(currentItem?.logo)
                .into(imageView)

//            val imageLink = currentItem?.logo
//
//            imageView.load(imageLink){
//                crossfade(true)
//                crossfade(1000)
//
//            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            CustomLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}