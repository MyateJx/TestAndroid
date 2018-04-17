package com.myatejx.ui_test;

import android.animation.ObjectAnimator;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.myatejx.ui_test.databinding.ActivityViewTestBinding;
import com.myatejx.ui_test.databinding.AdapterColorLinearBinding;


/**
 * Created by admin on 2018/3/5.
 */

public class ViewTestActivity extends AppCompatActivity {

    private ActivityViewTestBinding mBinding;
    private int mLastLeft;
    private int mLastRight;
    private ExpandView mExpandView;
    private int mScreenWidth;
    private int mScreenHeight;
    private BaseBindingAdapter mLinearAdapter;
    private TestDataSource mTestDataSource;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_view_test);
        mTestDataSource = new TestDataSource();
        initView();
        WindowManager wm1 = this.getWindowManager();
        mScreenWidth = wm1.getDefaultDisplay().getWidth();
        mScreenHeight = wm1.getDefaultDisplay().getHeight();
    }

    private void initView() {
        mExpandView = new ExpandView(mBinding.viewTest, mBinding.lv);
        if (mExpandView.getActivity() == null) {
            mExpandView.setActivity(this);
        }

        if (mLinearAdapter == null) {
            mLinearAdapter = new BaseBindingAdapter<ColorEntity, AdapterColorLinearBinding>(getApplicationContext()) {
                @Override
                protected int getLayoutResId(int viewType) {
                    return R.layout.adapter_color_linear;
                }

                @Override
                protected void onBindItem(AdapterColorLinearBinding binding, ColorEntity item, int position) {
                    binding.tvTitle.setText(item.getTitle());
                    binding.tvTitle.setTextColor(Color.parseColor(item.getTextColorHex()));
                    binding.ivBg.setBackgroundColor(Color.parseColor(item.getBgColorHex()));
                }
            };
        }
        mBinding.lv.addItemDecoration(new SpaceItemDecoration(20));
        mBinding.lv.setAdapter(mLinearAdapter);
        mLinearAdapter.setList(mTestDataSource.getColorEntities());
        mLinearAdapter.notifyDataSetChanged();

    }

    public class ClickProxy {

        public void fitWidth() {
            mLastLeft = mBinding.viewTest.getLeft();
            mLastRight = mBinding.viewTest.getRight();
            mBinding.viewTest.layout(0, mBinding.viewTest.getTop(), mScreenWidth, mBinding.viewTest.getBottom());
        }

        public void redoWidth() {
            mBinding.viewTest.layout(mLastLeft, mBinding.viewTest.getTop(), mLastRight, mBinding.viewTest.getBottom());

        }

        public void moveByAnim() {
            ObjectAnimator.ofFloat(mBinding.viewTest, "translationX", 0, 400).setDuration(1000).start();
//                ObjectAnimator.ofFloat(mBinding.viewTest, "translationY", 0, 200).setDuration(1000).start();
        }

        public void moveByScroller() {
            mBinding.viewTest.smoothScrollTo(-400, 0);

        }

        public void expand() {
            mBinding.lv.layout(0, 800, mScreenWidth, mScreenHeight);
            ObjectAnimator.ofInt(mExpandView, "expand", 0, 800).setDuration(350).start();
        }

        public void contract() {
            mBinding.lv.layout(0, 0, mScreenWidth, mScreenHeight);
            ObjectAnimator.ofInt(mExpandView, "expand", 800, 0).setDuration(350).start();
        }
    }

}
