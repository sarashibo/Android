package com.example.kancollemanager

import android.view.View
import android.view.animation.Animation
import android.view.animation.Transformation

class ResizeAnimation(view: View, addHeight: Int, startHeight: Int) : Animation() {
    val addHeight: Int
    var view: View
    var startHeight: Int
    override fun applyTransformation(
        interpolatedTime: Float,
        t: Transformation?
    ) {
        val newHeight = (startHeight + addHeight * interpolatedTime).toInt()
        view.getLayoutParams().height = newHeight
        view.requestLayout()
    }

    override fun initialize(
        width: Int,
        height: Int,
        parentWidth: Int,
        parentHeight: Int
    ) {
        super.initialize(width, height, parentWidth, parentHeight)
    }

    override fun willChangeBounds(): Boolean {
        return true
    }

    init {
        this.view = view
        this.addHeight = addHeight
        this.startHeight = startHeight
    }
}