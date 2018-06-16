package com.prongbang.recyclerviewlayoutmanager.utils

import android.view.View

interface OnItemClickListener<T> {
    fun onClick(v: View, data: T)
}