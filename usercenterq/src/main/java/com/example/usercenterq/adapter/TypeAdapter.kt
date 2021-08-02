package com.example.usercenter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.common.App.MyApplication

import com.example.usercenter.model.protocol.resp.RespTypeEntity
import com.example.usercenterq.R
/*
/商品分类的原生适配器
 */
class TypeAdapter() :RecyclerView.Adapter<TypeAdapter.ViewHolder>(){
    lateinit var data:List<RespTypeEntity>
    constructor(list: List<RespTypeEntity>) : this(){
        this.data=list
    }
   //获取布局
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var inflate = LayoutInflater.from(MyApplication.mContext).inflate(R.layout.item_type, parent, false)
        return ViewHolder(inflate)
    }

    override fun getItemCount(): Int {
        return data.size
    }
    //获取相应的数据
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var imageView = holder.itemView.findViewById<ImageView>(R.id.img2)
        var textView = holder.itemView.findViewById<TextView>(R.id.ttt)
        //显示获取的数据
        textView.setText(data[position].category_name)
    }

    //获取布局里的ID
    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        init {
            var textView = itemView.findViewById<TextView>(R.id.ttt)
            var imageView = itemView.findViewById<ImageView>(R.id.img2)
        }
    }



}