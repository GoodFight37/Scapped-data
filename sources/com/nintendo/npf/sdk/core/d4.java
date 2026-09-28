package com.nintendo.npf.sdk.core;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d4 {
    public static final Object a(Bundle bundle, String key, Class clazz) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return Build.VERSION.SDK_INT >= 33 ? bundle.getParcelable(key, clazz) : bundle.getParcelable(key);
    }

    public static final Object a(Parcel parcel, ClassLoader classLoader, Class clazz) {
        Intrinsics.checkNotNullParameter(parcel, "<this>");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (Build.VERSION.SDK_INT >= 33) {
            return parcel.readParcelable(classLoader, clazz);
        }
        return parcel.readParcelable(classLoader);
    }
}
