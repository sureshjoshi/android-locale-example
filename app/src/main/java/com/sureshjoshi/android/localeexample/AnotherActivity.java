package com.sureshjoshi.android.localeexample;

import android.app.Activity;
import android.os.Bundle;

import com.sureshjoshi.android.localeexample.utils.LocaleUtils;

import butterknife.ButterKnife;

public class AnotherActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        ButterKnife.bind(this);
    }
}
