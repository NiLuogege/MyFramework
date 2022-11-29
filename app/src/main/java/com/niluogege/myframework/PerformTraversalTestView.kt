package com.niluogege.myframework

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.niluogege.myframework.utils.LogUtils

class PerformTraversalTestView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        //这里可以打印出调用栈
//        LogUtils.log("onMeasure-->${Log.getStackTraceString(Throwable())}");
        LogUtils.log("onMeasure");


    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        LogUtils.log("onLayout");
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        LogUtils.log("onDraw");
    }

}