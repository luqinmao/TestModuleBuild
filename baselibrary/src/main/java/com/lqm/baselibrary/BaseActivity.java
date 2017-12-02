package com.lqm.baselibrary;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;


public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public Resources getBaseResources(){
        return getResources();
    }


    public Intent getStartActivityIntent(String activityName) {
        Intent intent = new Intent();
        intent.setClassName(this, activityName);
        return intent;
    }
}
