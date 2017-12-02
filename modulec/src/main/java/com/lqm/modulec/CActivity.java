package com.lqm.modulec;

import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lqm.baselibrary.BaseActivity;

/**
 * user：lqm
 * desc：使用Aroute打开CActivity
 */

// 在支持路由的页面上添加注解(必选)
// 这里的路径需要注意的是至少需要有两级，/xx/xx
@Route(path = "/moduleC/CActivity")
public class CActivity extends BaseActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

        mTextView = findViewById(R.id.textview2);


        mTextView.setText(getIntent().getStringExtra("key"));
    }
}
