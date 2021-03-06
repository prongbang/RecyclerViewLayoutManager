package com.prongbang.recyclerviewlayoutmanager.ui.staggered


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.prongbang.recyclerviewlayoutmanager.R
import com.prongbang.recyclerviewlayoutmanager.model.Item
import com.prongbang.recyclerviewlayoutmanager.utils.OnItemClickListener
import kotlinx.android.synthetic.main.fragment_staggered_grid_layout.view.*

class StaggeredGridLayoutFragment : Fragment() {

    companion object {
        fun newInstance(): Fragment {
            return StaggeredGridLayoutFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_staggered_grid_layout, container, false)

        val items = ArrayList<Item>().apply {
            add(Item(1, R.drawable.item_1, "Item 1"))
            add(Item(2, R.drawable.item_2, "Item 2"))
            add(Item(3, R.drawable.item_3, "Item 3"))
            add(Item(4, R.drawable.item_5, "Item 5"))
            add(Item(5, R.drawable.item_4, "Item 4"))
            add(Item(6, R.drawable.item_6, "Item 6"))
            add(Item(7, R.drawable.item_7, "Item 7"))
        }

        val adapter = StaggeredGridLayoutAdapter().apply {
            setOnItemClickListener(object : OnItemClickListener<Item>{
                override fun onClick(v: View, data: Item) {
                    Toast.makeText(context, data.message, Toast.LENGTH_SHORT).show()
                }
            })
            submitList(items)
        }

        view.rvStaggeredGrid.apply {
            setAdapter(adapter)
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            isNestedScrollingEnabled = false
        }

        return view
    }


}
