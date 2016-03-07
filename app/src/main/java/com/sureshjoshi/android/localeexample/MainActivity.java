package com.sureshjoshi.android.localeexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.sureshjoshi.android.localeexample.utils.LocaleUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @Bind(R.id.button_change_locale)
    Button mChangeLocaleButton;
    private int mLanguageIndex = 0;

    @OnClick(R.id.button_change_locale)
    void changeLocale() {
        if (++mLanguageIndex >= LocaleUtils.LocaleDef.SUPPORTED_LOCALES.length) {
            mLanguageIndex = 0;
        }

        LocaleUtils.setLocale(this, mLanguageIndex);
        setupUi();
    }

    @Bind(R.id.button_load_activity)
    Button mLoadActivityButton;

    @OnClick(R.id.button_load_activity)
    void loadActivity() {
        startActivity(new Intent(this, AnotherActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        LocaleUtils.initialize(this, LocaleUtils.ENGLISH);

        setupUi();
    }

    private void setupUi() {
        mChangeLocaleButton.setText(R.string.current_language);
        mLoadActivityButton.setText(R.string.open);
    }
}
