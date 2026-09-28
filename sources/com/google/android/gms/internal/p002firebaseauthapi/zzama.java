package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzama implements zzall {
    private final zzaln zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzall
    public final zzaln zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzall
    public final zzalz zzb() {
        int i = this.zzd;
        if ((i & 1) != 0) {
            return zzalz.PROTO2;
        }
        return (i & 4) == 4 ? zzalz.EDITIONS : zzalz.PROTO3;
    }

    final String zzd() {
        return this.zzb;
    }

    zzama(zzaln zzalnVar, String str, Object[] objArr) {
        this.zza = zzalnVar;
        this.zzb = str;
        this.zzc = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.zzd = cCharAt;
            return;
        }
        int i = cCharAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char cCharAt2 = str.charAt(i3);
            if (cCharAt2 < 55296) {
                this.zzd = i | (cCharAt2 << i2);
                return;
            } else {
                i |= (cCharAt2 & 8191) << i2;
                i2 += 13;
                i3 = i4;
            }
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzall
    public final boolean zzc() {
        return (this.zzd & 2) == 2;
    }

    final Object[] zze() {
        return this.zzc;
    }
}
