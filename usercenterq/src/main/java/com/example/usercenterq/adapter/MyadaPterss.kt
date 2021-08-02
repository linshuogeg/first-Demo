package com.example.usercenterq.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseViewHolder
import com.example.common.App.MyApplication
import com.example.usercenter.adapter.TypeAdapter
import com.example.usercenter.model.protocol.resp.RespTypeEntity
import com.example.usercenterq.R
import com.example.usercenterq.protocol.req.RespGoodEntity
 /*
 /商品信息的原生适配器
  */
class MyadaPterss(): RecyclerView.Adapter<TypeAdapter.ViewHolder>() {
    lateinit var data:List<RespGoodEntity.Data>
    constructor(list: List<RespGoodEntity.Data>) : this() {
        this.data = list
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypeAdapter.ViewHolder {
        var inflate = LayoutInflater.from(MyApplication.mContext).inflate(R.layout.itemzhu, parent, false)
        return TypeAdapter.ViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: TypeAdapter.ViewHolder, position: Int) {
        var imageView=holder.itemView.findViewById<ImageView>(R.id.img222)
        var textView=holder.itemView.findViewById<TextView>(R.id.titit)
        textView.setText(data[position].ShortTitle)
        //加载图片
        Glide.with(MyApplication.getAppContext()).load(data[position].PictUrl).into(imageView)
    }


    override fun getItemCount(): Int {
        return data.size
    }
    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        init {
            var textView = itemView.findViewById<TextView>(R.id.titit)
            var imageView = itemView.findViewById<ImageView>(R.id.img222)
        }
    }

}