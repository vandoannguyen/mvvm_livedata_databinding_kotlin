package com.example.dagger_kotlin_retrofit.ui.main

import android.util.Log
import android.view.View
import com.example.dagger_kotlin_retrofit.R
import com.example.dagger_kotlin_retrofit.base.BaseAdapter
import com.example.dagger_kotlin_retrofit.base.BaseHolder
import com.example.dagger_kotlin_retrofit.data.mode.local.UserLocal
import com.example.dagger_kotlin_retrofit.data.mode.network.User
import kotlinx.android.synthetic.main.itemtest.view.*

class TestAdapter(listData: List<User>) : BaseAdapter<User, TestAdapter.ViewHolder>(listData) {
    class ViewHolder(itemView: View) : BaseHolder<User>(itemView)
    override fun getLayout(): Int {
        return R.layout.itemtest;
    }

    override fun onItemClick(data: User) {
        Log.e("TAG1111", "onItemClick:")
    }

    override fun getViewHolder(view: View): ViewHolder {
        return ViewHolder(view);
    }

    override fun onBind(holder: BaseHolder<User>, data: User) {
        holder.itemView.item_txt_test.text = data.login;
        holder.itemView.item_txt_test_name.text = data.name ?: "loading...";
    }

}