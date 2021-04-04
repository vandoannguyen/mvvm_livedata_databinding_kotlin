package com.example.dagger_kotlin_retrofit.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * DATA defined type of item data in ViewHolder
 * VH defined type of ViewHolder with data type is DATA
 */
abstract class BaseAdapter<DATA : Any, VH : BaseHolder<DATA>> :
    RecyclerView.Adapter<VH> {
    var listData: List<DATA> = ArrayList();

    constructor(listData: List<DATA>) : super() {
        this.listData = listData;
    }

    fun setList(listData: List<DATA>) {
        this.listData = listData
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        onBind(holder, listData.get(position))
        holder.itemView.setOnClickListener {
            onItemClick(listData.get(position));
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        var view: View =
            LayoutInflater.from(parent.context).inflate(getLayout(), parent, false)
        return getViewHolder(view);
    }

    abstract fun getViewHolder(view: View): VH;
    abstract fun getLayout(): Int;
    abstract fun onItemClick(data: DATA);
    abstract fun onBind(holder: BaseHolder<DATA>, data: DATA);
}