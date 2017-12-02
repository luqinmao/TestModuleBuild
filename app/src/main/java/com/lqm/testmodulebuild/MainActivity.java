package com.lqm.testmodulebuild;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.lqm.baselibrary.AppConfig;
import com.lqm.baselibrary.BaseActivity;
import com.lqm.baselibrary.utils.ToastUtil;

public class MainActivity extends BaseActivity {

    private TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textView);

    }

    public void clickA(View view){
        launchActivity(AppConfig.AModuleActivity,"我是MainActivity 传递的数据");

    }


    public void clickB(View view){
        launchActivity(AppConfig.BModuleActivity,"");
    }


    public void clickC(View view){
        // 1. 应用内简单的跳转(通过URL跳转在'进阶用法'中)
//        ARouter.getInstance().build("/moduleC/CActivity").navigation();

        // 2. 跳转并携带参数
        ARouter.getInstance().build("/moduleC/CActivity")
                .withString("key", "我是通过arouter跳转传过来的数据")
                .navigation();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (data.hasExtra(AppConfig.INTENT_VALUE)) {
                mTextView.setText(data.getStringExtra(AppConfig.INTENT_VALUE));
            }
        }
    }


    private void launchActivity(String activityName,String value){
        Intent intent = getStartActivityIntent(activityName);
        if (!TextUtils.isEmpty(value))
                intent.putExtra("intentValue",value);
        try {
            startActivityForResult(intent, 1);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            ToastUtil.showToast(getApplicationContext(), "该功能尚未开放");
        }
    }


}
