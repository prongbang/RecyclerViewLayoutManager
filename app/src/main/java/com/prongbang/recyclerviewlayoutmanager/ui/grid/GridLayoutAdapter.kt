package com.prongbang.recyclerviewlayoutmanager.ui.grid

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.view.ViewGroup
import com.prongbang.recyclerviewlayoutmanager.model.Item
import com.prongbang.recyclerviewlayoutmanager.utils.OnItemClickListener

class GridLayoutAdapter : ListAdapter<Item, GridLayoutViewHolder>(DIFF_COMPARATOR) {

    private var mOnItemClickListener: OnItemClickListener<Item>? = null

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): GridLayoutViewHolder {

        return GridLayoutViewHolder.create(p0, mOnItemClickListener)
    }

    override fun onBindViewHolder(p0: GridLayoutViewHolder, p1: Int) {
        p0.bind(getItem(p1))
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener<Item>) {
        this.mOnItemClickListener = onItemClickListener
    }

    companion object {

        private val DIFF_COMPARATOR = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(p0: Item, p1: Item): Boolean {
                return p0 == p1
            }

            override fun areContentsTheSame(p0: Item, p1: Item): Boolean {
                return p0.id == p1.id
            }

        }

    }

}