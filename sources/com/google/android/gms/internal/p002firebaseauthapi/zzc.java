package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzc extends zza {
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zza
    public final URLConnection zza(URL url, String str) throws IOException {
        return url.openConnection();
    }

    private zzc() {
    }
}
