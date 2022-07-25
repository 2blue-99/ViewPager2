package com.example.bedals_minjock

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bedals_minjock.databinding.MyitemBinding
import androidx.viewpager.widget.PagerAdapter

class ViewPageAdapter() : RecyclerView.Adapter<ViewPageAdapter.PagerViewHolder>() {

    var heyinList = mutableListOf<Data>()

    inner class PagerViewHolder(private val binding: MyitemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: Data){
            binding.myImageItem.setImageDrawable(data.myImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : PagerViewHolder{
        val binding = MyitemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return PagerViewHolder(binding)
    }


    override fun getItemCount(): Int = Int.MAX_VALUE

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.bind(heyinList[position%4])
    }





}