package com.prongbang.recyclerviewlayoutmanager.ui.staggered

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.view.ViewGroup
import com.prongbang.recyclerviewlayoutmanager.model.Item
import com.prongbang.recyclerviewlayoutmanager.utils.OnItemClickListener

class StaggeredGridLayoutAdapter: ListAdapter<Item, StaggeredGridLayoutViewHolder>(DIFF_COMPARATOR) {

    private var onItemClickListener: OnItemClickListener<Item>? = null

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): StaggeredGridLayoutViewHolder {
        return StaggeredGridLayoutViewHolder.create(p0, onItemClickListener)
    }

    override fun onBindViewHolder(p0: StaggeredGridLayoutViewHolder, p1: Int) {
        p0.bind(getItem(p1))
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener<Item>) {
        this.onItemClickListener = onItemClickListener
    }

    companion object {
        private val DIFF_COMPARATOR = object : DiffUtil.ItemCallback<Item>(){
            override fun areItemsTheSame(p0: Item, p1: Item): Boolean {
                return p0 == p1
            }

            override fun areContentsTheSame(p0: Item, p1: Item): Boolean {
                return p0.id == p1.id
            }

        }
    }
}