package com.maherbson.ui.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.maherbson.ui.R

fun ImageView.loadUrl(url: String) {
    Glide.with(this)
        .load(url)
        .centerCrop()
        .placeholder(R.drawable.ic_person)
        .error(R.drawable.ic_broken_image)
        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
        .into(this)
}
