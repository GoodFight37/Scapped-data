package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzmp implements zzbz {
    private final SharedPreferences.Editor zza;
    private final String zzb;

    public zzmp(Context context, String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("keysetName cannot be null");
        }
        this.zzb = str;
        Context applicationContext = context.getApplicationContext();
        if (str2 == null) {
            this.zza = PreferenceManager.getDefaultSharedPreferences(applicationContext).edit();
        } else {
            this.zza = applicationContext.getSharedPreferences(str2, 0).edit();
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbz
    public final void zza(zzuz zzuzVar) throws IOException {
        if (!this.zza.putString(this.zzb, zzza.zza(zzuzVar.zzk())).commit()) {
            throw new IOException("Failed to write to SharedPreferences");
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbz
    public final void zza(zzwl zzwlVar) throws IOException {
        if (!this.zza.putString(this.zzb, zzza.zza(zzwlVar.zzk())).commit()) {
            throw new IOException("Failed to write to SharedPreferences");
        }
    }
}
