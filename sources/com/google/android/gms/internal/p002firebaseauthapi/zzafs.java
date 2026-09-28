package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzafs extends zzahi {
    private String zza;
    private String zzb;
    private String zzc;
    private zzagh zzd;
    private String zze;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzahi
    public final zzahi zza(String str) {
        if (str == null) {
            throw new NullPointerException("Null idToken");
        }
        this.zze = str;
        return this;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzahi
    public final zzahi zzb(String str) {
        if (str == null) {
            throw new NullPointerException("Null providerId");
        }
        this.zza = str;
        return this;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzahi
    public final zzahi zzc(String str) {
        this.zzb = str;
        return this;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzahi
    public final zzahi zzd(String str) {
        if (str == null) {
            throw new NullPointerException("Null token");
        }
        this.zzc = str;
        return this;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzahi
    public final zzahi zza(zzagh zzaghVar) {
        if (zzaghVar == null) {
            throw new NullPointerException("Null tokenType");
        }
        this.zzd = zzaghVar;
        return this;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzahi
    public final zzahf zza() {
        if (this.zza == null || this.zzc == null || this.zzd == null || this.zze == null) {
            StringBuilder sb = new StringBuilder();
            if (this.zza == null) {
                sb.append(" providerId");
            }
            if (this.zzc == null) {
                sb.append(" token");
            }
            if (this.zzd == null) {
                sb.append(" tokenType");
            }
            if (this.zze == null) {
                sb.append(" idToken");
            }
            throw new IllegalStateException("Missing required properties:" + String.valueOf(sb));
        }
        return new zzafp(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
    }

    zzafs() {
    }
}
