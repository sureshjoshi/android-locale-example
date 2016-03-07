package com.sureshjoshi.android.localeexample.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;

public class LocaleUtils {

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({ENGLISH, FRENCH, SPANISH})
    public @interface LocaleDef {
        String[] SUPPORTED_LOCALES = {ENGLISH, FRENCH, SPANISH};
    }

    public static final String ENGLISH = "en";
    public static final String FRENCH = "fr";
    public static final String SPANISH = "es";

    public static void initialize(Context context) {
//        String lang = getPersistedData(context, Locale.getDefault().getLanguage());
        setLocale(context, ENGLISH);
    }

    public static void initialize(Context context, @LocaleDef String defaultLanguage) {
//        String lang = getPersistedData(context, defaultLanguage);
        setLocale(context, defaultLanguage);
    }

//    public static String getLanguage(Context context) {
//        return getPersistedData(context, Locale.getDefault().getLanguage());
//    }

    public static boolean setLocale(Context context, @LocaleDef String language) {
//        persist(context, language);
        return updateResources(context, language);
    }

    public static boolean setLocale(Context context, int languageIndex) {
//        persist(context, language);
        if (languageIndex >= LocaleDef.SUPPORTED_LOCALES.length) {
            return false;
        }

        return updateResources(context, LocaleDef.SUPPORTED_LOCALES[languageIndex]);
    }

//    private static String getPersistedData(Context context, String defaultLanguage) {
//        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
//        return preferences.getString(SELECTED_LANGUAGE, defaultLanguage);
//    }

//    private static void persist(Context context, String language) {
//        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
//        SharedPreferences.Editor editor = preferences.edit();
//
//        editor.putString(SELECTED_LANGUAGE, language);
//        editor.apply();
//    }

    private static boolean updateResources(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Resources resources = context.getResources();

        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;

        resources.updateConfiguration(configuration, resources.getDisplayMetrics());

        return true;
    }
}