package com.myatejx.ui_test;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

/**
 * Created by admin on 2018/3/5.
 */

public class TestView extends ViewGroup {

    private int mLastX;
    private int mLastY;
    private Scroller mScroller;


    public TestView(Context context) {
        super(context);
    }

    public TestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mScroller = new Scroller(context);
    }

    public TestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - mLastX;
                int offsetY = y - mLastY;
//                layout(getLeft() + offsetX, getTop() + offsetY, getRight() + offsetX, getBottom() + offsetY);
//                offsetLeftAndRight(offsetX);
//                offsetTopAndBottom(offsetY);
//                moveByMargin(offsetX, offsetY);
                ((View) getParent()).scrollBy(-offsetX, -offsetY);
                break;
            case MotionEvent.ACTION_DOWN:
                mLastX = x;
                mLastY = y;
                break;
            case MotionEvent.ACTION_UP:

                break;
            default:
        }

        //不return true等于不消费，不消费等于前面的这些都不执行？
        return true;
    }

    private void moveByMargin(int offsetX, int offsetY) {
        MarginLayoutParams layoutParams = (MarginLayoutParams) getLayoutParams();
        layoutParams.leftMargin = getLeft() + offsetX;
        layoutParams.topMargin = getTop() + offsetY;
        setLayoutParams(layoutParams);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        //如果还存在偏移，就继续重绘，否则停止
        if (mScroller.computeScrollOffset()) {
            ((View) getParent()).scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            invalidate();
        }
    }

    public void smoothScrollTo(int destX, int destY) {
        int scrollX = getScrollX();
        int delta = destX - scrollX;
        //1000秒内滑向destX
        mScroller.startScroll(scrollX, 0, delta, 0, 1000);
        invalidate();
    }

    public void stretchByMargin(int height) {
        MarginLayoutParams layoutParams = (MarginLayoutParams) getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = height;
        setLayoutParams(layoutParams);
    }


}
