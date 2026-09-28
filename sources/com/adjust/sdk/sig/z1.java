package com.adjust.sdk.sig;

import android.util.Log;
import com.adjust.sdk.AdjustConfig;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-50f36c2f6dbb1f1f4069f6584f1798fc01925cf859372d68181d0fca7f3fe715 */
/* JADX INFO: loaded from: classes.dex */
public final class z1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleDateFormat f166a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);
    public final boolean b;

    public z1(Map map) {
        this.b = AdjustConfig.ENVIRONMENT_SANDBOX.equals(map.get("environment"));
    }

    public final void a(String str) {
        if (this.b) {
            Log.v("SignerInstance", str + this.f166a.format(new Date(System.currentTimeMillis())));
        }
    }
}
