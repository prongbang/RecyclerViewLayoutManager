package com.prongbang.recyclerviewlayoutmanager.model

import android.support.annotation.DrawableRes

data class Item(
        var id: Int,
        @DrawableRes
        var image: Int,
        var message: String
)