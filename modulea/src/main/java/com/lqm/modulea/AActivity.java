package com.lqm.modulea;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.lqm.baselibrary.AppConfig;
import com.lqm.baselibrary.BaseActivity;

/**
 * user：lqm
 * desc：
 */

public class AActivity extends BaseActivity{

    private TextView mTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

         mTextView = findViewById(R.id.textview2);
         String intentValue = getIntent().getStringExtra("intentValue");
        mTextView.setText(intentValue);

    }

    @Override
    public void onBackPressed() {
        getIntent().putExtra(AppConfig.INTENT_VALUE, "返回数据：123456");
        setResult(Activity.RESULT_OK,getIntent());
        super.onBackPressed();

    }
}
