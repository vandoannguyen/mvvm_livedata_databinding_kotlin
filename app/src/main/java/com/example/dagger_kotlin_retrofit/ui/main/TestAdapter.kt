package com.example.dagger_kotlin_retrofit.ui.main

import android.util.Log
import android.view.View
import com.example.dagger_kotlin_retrofit.R
import com.example.dagger_kotlin_retrofit.base.BaseAdapter
import com.example.dagger_kotlin_retrofit.base.BaseHolder
import kotlinx.android.synthetic.main.itemtest.view.*

class TestAdapter(listData: List<String>) : BaseAdapter<String, TestAdapter.ViewHolder>(listData) {
    class ViewHolder(itemView: View) : BaseHolder<String>(itemView) {
    }


    override fun getLayout(): Int {
        return R.layout.itemtest;
    }

    override fun onItemClick(data: String) {
        Log.e("TAG1111", "onItemClick:")
    }

    override fun getViewHolder(view: View): ViewHolder {
        return ViewHolder(view);
    }

    override fun onBind(holder: BaseHolder<String>, data: String) {
        holder.itemView.item_txt_test.text = data;
    }

}