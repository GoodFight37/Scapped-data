package com.google.android.gms.internal.p002firebaseauthapi;

import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzahc {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private String zzg;

    public final Uri zza() {
        if (TextUtils.isEmpty(this.zzc)) {
            return null;
        }
        return Uri.parse(this.zzc);
    }

    public final String zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzg;
    }

    public final String zzd() {
        return this.zza;
    }

    public final String zze() {
        return this.zzf;
    }

    public final String zzf() {
        return this.zzd;
    }

    public final String zzg() {
        return this.zze;
    }

    public zzahc() {
    }

    public zzahc(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = null;
        this.zzf = str6;
        this.zzg = str7;
    }

    public final void zza(String str) {
        this.zze = str;
    }
}
