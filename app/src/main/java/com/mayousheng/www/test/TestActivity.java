package com.mayousheng.www.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by marking on 2017/5/2.
 */

public class TestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("-----1", "TestActivity onCreate");
        finish();
    }
}
