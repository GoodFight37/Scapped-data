package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
abstract class zzac extends zzd<String> {
    final CharSequence zza;
    private final zzf zzb;
    private int zze;
    private int zzd = 0;
    private final boolean zzc = false;

    abstract int zza(int i);

    abstract int zzb(int i);

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzd
    protected final /* synthetic */ String zza() {
        int i = this.zzd;
        while (true) {
            int i2 = this.zzd;
            if (i2 == -1) {
                zzb();
                return null;
            }
            int iZzb = zzb(i2);
            if (iZzb == -1) {
                iZzb = this.zza.length();
                this.zzd = -1;
            } else {
                this.zzd = zza(iZzb);
            }
            int i3 = this.zzd;
            if (i3 != i) {
                while (i < iZzb && this.zzb.zza(this.zza.charAt(i))) {
                    i++;
                }
                while (iZzb > i && this.zzb.zza(this.zza.charAt(iZzb - 1))) {
                    iZzb--;
                }
                int i4 = this.zze;
                if (i4 == 1) {
                    iZzb = this.zza.length();
                    this.zzd = -1;
                    while (iZzb > i && this.zzb.zza(this.zza.charAt(iZzb - 1))) {
                        iZzb--;
                    }
                } else {
                    this.zze = i4 - 1;
                }
                return this.zza.subSequence(i, iZzb).toString();
            }
            int i5 = i3 + 1;
            this.zzd = i5;
            if (i5 > this.zza.length()) {
                this.zzd = -1;
            }
        }
    }

    protected zzac(zzv zzvVar, CharSequence charSequence) {
        this.zzb = zzvVar.zza;
        this.zze = zzvVar.zzc;
        this.zza = charSequence;
    }
}
