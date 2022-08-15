package com.erya.recipesearch

import android.widget.ImageView
import com.makeramen.roundedimageview.RoundedTransformationBuilder
import com.squareup.picasso.Picasso


fun ImageView.showIcon(icon: String) {
    Picasso.with(context)
        .load(icon)
        .into(this)
}

fun ImageView.showIconRound(icon: String) {
    val transformation = RoundedTransformationBuilder()
        .cornerRadiusDp(30F)
        .oval(false)
        .build()

    Picasso.with(context)
        .load(icon)
        .fit()
        .transform(transformation)
        .into(this)
}


