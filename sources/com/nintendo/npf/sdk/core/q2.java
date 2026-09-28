package com.nintendo.npf.sdk.core;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class q2 implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Activity f547a;

    public q2(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f547a = activity;
    }

    @Override // com.nintendo.npf.sdk.core.e
    public void a() {
    }

    @Override // com.nintendo.npf.sdk.core.e
    public void a(int i, int i2, Intent intent) {
    }

    @Override // com.nintendo.npf.sdk.core.e
    public void a(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
    }

    @Override // com.nintendo.npf.sdk.core.e
    public void b(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    @Override // com.nintendo.npf.sdk.core.e
    public void onResume() {
    }

    @Override // com.nintendo.npf.sdk.core.e
    public void a(Bundle bundle) {
        this.f547a.startActivity(this.f547a.getPackageManager().getLaunchIntentForPackage(this.f547a.getPackageName()));
        this.f547a.finish();
    }
}
