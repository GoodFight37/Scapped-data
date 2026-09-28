package com.unity3d.player;

import android.content.Context;
import com.unity3d.player.a.AbstractC0082o;
import com.unity3d.player.a.AbstractC0086t;
import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes2.dex */
public final class J0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UnityPlayerForActivityOrService f1026a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ boolean g;
    public final /* synthetic */ String h;
    public final /* synthetic */ int i;
    public final /* synthetic */ boolean j;
    public final /* synthetic */ boolean k;
    public final /* synthetic */ Semaphore l;
    public final /* synthetic */ UnityPlayerForActivityOrService m;

    public J0(UnityPlayerForActivityOrService unityPlayerForActivityOrService, UnityPlayerForActivityOrService unityPlayerForActivityOrService2, String str, int i, boolean z, boolean z2, boolean z3, boolean z4, String str2, int i2, boolean z5, boolean z6, Semaphore semaphore) {
        this.m = unityPlayerForActivityOrService;
        this.f1026a = unityPlayerForActivityOrService2;
        this.b = str;
        this.c = i;
        this.d = z;
        this.e = z2;
        this.f = z3;
        this.g = z4;
        this.h = str2;
        this.i = i2;
        this.j = z5;
        this.k = z6;
        this.l = semaphore;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AbstractC0129t c0135y;
        try {
            try {
                UnityPlayerForActivityOrService unityPlayerForActivityOrService = this.m;
                if (unityPlayerForActivityOrService.mSoftInput != null) {
                    unityPlayerForActivityOrService.dismissSoftInput();
                }
                UnityPlayerForActivityOrService unityPlayerForActivityOrService2 = this.m;
                int iA = SoftInputProvider.a();
                Context context = this.m.mContext;
                UnityPlayerForActivityOrService unityPlayerForActivityOrService3 = this.f1026a;
                if (AbstractC0082o.a(iA) == 2) {
                    c0135y = new C0135y(context, unityPlayerForActivityOrService3);
                } else {
                    c0135y = new A(context, unityPlayerForActivityOrService3);
                }
                unityPlayerForActivityOrService2.mSoftInput = c0135y;
                this.m.mSoftInput.a(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k);
                AbstractC0129t abstractC0129t = this.m.mSoftInput;
                abstractC0129t.f = new I0(this);
                abstractC0129t.d();
                this.m.nativeReportKeyboardConfigChanged();
            } catch (Exception e) {
                AbstractC0086t.Log(6, "Exception when opening Softinput " + e);
            }
        } finally {
            this.l.release();
        }
    }
}
