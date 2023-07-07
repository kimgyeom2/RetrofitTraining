package com.gy25m.retrofittraining

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.gy25m.retrofittraining.databinding.RecyclerItemBinding

class MyAdapter(var data:MutableList<Pr>,var context:Context) :Adapter<MyAdapter.VH>() {
    inner class VH(var binding:RecyclerItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=VH(
        DataBindingUtil.inflate(
            LayoutInflater.from(context),R.layout.recycler_item,parent,false))

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.binding.item=data[position]
    }
}