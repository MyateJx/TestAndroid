package com.myatejx.ui_test;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bumptech.glide.Glide;
import com.myatejx.ui_test.databinding.ActivityOneBinding;
import com.myatejx.ui_test.databinding.ItemTestAnimtorBinding;

import java.util.ArrayList;

public class OneActivity extends AppCompatActivity {

    private ActivityOneBinding mBinding;
    private BaseBindingAdapter<String, ItemTestAnimtorBinding> mAdapter;
    private static final String PATH = "http://photo.l99.com/bigger/888/1525235746976_2cr48g.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_one);
        mAdapter = new BaseBindingAdapter<String, ItemTestAnimtorBinding>(getApplicationContext()) {
            @Override
            protected int getLayoutResId(int viewType) {
                return R.layout.item_test_animtor;
            }

            @Override
            protected void onBindItem(final ItemTestAnimtorBinding binding, String item, int position) {
                binding.iv.setTag(null);
                Glide.with(OneActivity.this).load(PATH).into(binding.iv);
                binding.iv.setTag("img");
                binding.tvTitle.setText(item);
                binding.getRoot().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        KShareViewActivityManager.getInstance(OneActivity.this)
                                .startActivity(OneActivity.this, TwoActivity.class,
                                        R.layout.item_test_animtor, R.layout.activity_two, binding.iv, binding.tvTitle);

                    }
                });
            }
        };
        mBinding.rv.setAdapter(mAdapter);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("fuckckfhsjdfgsjdgfsdfjsdgfsjdgfjdgdgdgdjfgsdf");
        }
        mAdapter.setList(list);
        mAdapter.notifyDataSetChanged();

    }

}
