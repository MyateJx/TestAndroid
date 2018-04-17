package com.myatejx.ui_test;

import android.app.Activity;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by admin on 2018/3/5.
 */

public class ExpandView {
    private View mTargetTop;
    private View mTargetBottom;

    private Activity mActivity;

    public Activity getActivity() {
        return mActivity;
    }

    public void setActivity(Activity activity) {
        mActivity = activity;
    }

    public ExpandView(View targetTop, View targetBottom) {
        mTargetTop = targetTop;
        mTargetBottom = targetBottom;
    }

    public void setExpand(int height) {
        int screenWidth = 0;
        int screenHeight = 0;
        if (mActivity != null) {
            WindowManager wm1 = mActivity.getWindowManager();
            screenWidth = wm1.getDefaultDisplay().getWidth();
            screenHeight = wm1.getDefaultDisplay().getHeight();
        }
        mTargetTop.layout(0, 0, screenWidth, height);
//        mTargetBottom.layout(0, mTargetTop.getHeight(), screenWidth, screenHeight);
    }

    public int getExpand() {
        return mTargetTop.getHeight();
    }

}
