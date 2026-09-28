package com.adjust.sdk.sig;

import android.content.Context;
import android.os.BatteryManager;

/* JADX INFO: compiled from: r8-map-id-50f36c2f6dbb1f1f4069f6584f1798fc01925cf859372d68181d0fca7f3fe715 */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f133a;

    public h(Context context) {
        this.f133a = context;
    }

    public final void a(b0 b0Var) {
        b0Var.f116a = Integer.valueOf(((BatteryManager) this.f133a.getSystemService("batterymanager")).getIntProperty(4));
    }
}
