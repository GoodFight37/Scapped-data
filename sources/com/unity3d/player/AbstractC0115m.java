package com.unity3d.player;

import android.view.inputmethod.InputMethodSubtype;

/* JADX INFO: renamed from: com.unity3d.player.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0115m {
    public static String a(InputMethodSubtype inputMethodSubtype) {
        if (PlatformSupport.NOUGAT_SUPPORT) {
            return inputMethodSubtype.getLanguageTag();
        }
        return inputMethodSubtype.getLocale();
    }
}
