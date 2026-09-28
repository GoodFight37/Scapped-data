package com.unity3d.player;

import android.content.Context;
import android.os.Build;
import android.os.LocaleList;
import android.os.SystemClock;
import java.io.File;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
class DeviceInfo {
    DeviceInfo() {
    }

    public static String getSystemLanguage() {
        return getCleanLocale(Locale.getDefault());
    }

    public static String getLocaleList(Context context) {
        int i = 0;
        if (PlatformSupport.NOUGAT_SUPPORT) {
            LocaleList locales = context.getResources().getConfiguration().getLocales();
            StringBuilder sb = new StringBuilder();
            while (i < locales.size()) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(getCleanLocale(locales.get(i)));
                i++;
            }
            return sb.toString();
        }
        Locale[] availableLocales = Locale.getAvailableLocales();
        StringBuilder sb2 = new StringBuilder();
        while (i < availableLocales.length) {
            if (i > 0) {
                sb2.append(",");
            }
            sb2.append(getCleanLocale(availableLocales[i]));
            i++;
        }
        return sb2.toString();
    }

    private static String getCleanLocale(Locale locale) {
        String string = locale.toString();
        int iIndexOf = string.indexOf("#");
        if (iIndexOf <= 0) {
            return string;
        }
        int i = iIndexOf - 1;
        if (string.charAt(i) == '_') {
            return string.substring(0, i);
        }
        return string.substring(0, iIndexOf);
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public static long getTotalSpace(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null || !cacheDir.exists()) {
            return -1L;
        }
        return Math.round(cacheDir.getTotalSpace() / 1024);
    }

    public static long getSystemBootTime() {
        return (System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000;
    }
}
