package com.prongbang.recyclerviewlayoutmanager.ui.linear

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.prongbang.recyclerviewlayoutmanager.R
import com.prongbang.recyclerviewlayoutmanager.model.Item
import com.prongbang.recyclerviewlayoutmanager.utils.OnItemClickListener
import kotlinx.android.synthetic.main.item_linear_layout.view.*

class LinearLayoutViewHolder(private val context: Context,
                             private val view: View,
                             private val  onItemClickListener: OnItemClickListener<Item>?): RecyclerView.ViewHolder(view) {

    fun bind(item: Item) {

        view.ivImage.setImageDrawable(ContextCompat.getDrawable(context, item.image))

        view.setOnClickListener {
            onItemClickListener?.onClick(it, item)
        }

    }

    companion object {

        fun create(parent: ViewGroup, onItemClickListener: OnItemClickListener<Item>?): LinearLayoutViewHolder {

            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_linear_layout, parent, false)

            return LinearLayoutViewHolder(parent.context, view, onItemClickListener)
        }

    }
}
