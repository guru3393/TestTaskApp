package com.yuyakaido.android.cardstackview.sample

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.guru.testtaskapp.DetailsActivity
import com.guru.testtaskapp.R

class HomeVODAdapter(private var vodArrayList :  List<Spot> = emptyList()): RecyclerView.Adapter<HomeVODAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_view_layout, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return vodArrayList.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //holder.setIsRecyclable(false)
        holder.bindItems(vodArrayList[position])
    }

    class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)
    {

        @SuppressLint("SetTextI18n")
        fun bindItems(data: Spot) {
            val imageView: ImageView = itemView.findViewById(R.id.imageView)
            val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
            val tvDate: TextView = itemView.findViewById(R.id.tvDate)
            tvTitle.text = data.name
            tvTitle.isSelected = true
            //tvTitle.startScroll()
            tvDate.text = data.city

            Glide.with(itemView.context).load(data.url).into(imageView)
            itemView.setOnClickListener {
                val intent= Intent(itemView.context, DetailsActivity::class.java)
                intent.putExtra("VOD_TITLE",data.name)
                intent.putExtra("VOD_URL_LINK",data.url)
                itemView.context.startActivity(intent)
            }
        }

    }

}