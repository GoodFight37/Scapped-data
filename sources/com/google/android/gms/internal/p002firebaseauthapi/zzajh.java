package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
class zzajh extends zzaje {
    protected final byte[] zzb;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaiw
    public byte zza(int i) {
        return this.zzb[i];
    }

    protected int zze() {
        return 0;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaiw
    byte zzb(int i) {
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaiw
    protected final int zzb(int i, int i2, int i3) {
        return zzaki.zza(i, this.zzb, zze(), i3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaiw
    public int zzb() {
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaiw
    public final zzaiw zza(int i, int i2) {
        int iZza = zza(0, i2, zzb());
        if (iZza == 0) {
            return zzaiw.zza;
        }
        return new zzaja(this.zzb, zze(), iZza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaiw
    public final zzaji zzc() {
        return zzaji.zza(this.zzb, zze(), zzb(), true);
    }

    zzajh(byte[] bArr) {
        super();
        bArr.getClass();
        this.zzb = bArr;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaiw
    protected void zza(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzb, 0, bArr, 0, i3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaiw
    final void zza(zzaix zzaixVar) throws IOException {
        zzaixVar.zza(this.zzb, zze(), zzb());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaiw
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzaiw) || zzb() != ((zzaiw) obj).zzb()) {
            return false;
        }
        if (zzb() == 0) {
            return true;
        }
        if (obj instanceof zzajh) {
            zzajh zzajhVar = (zzajh) obj;
            int iZza = zza();
            int iZza2 = zzajhVar.zza();
            if (iZza == 0 || iZza2 == 0 || iZza == iZza2) {
                return zza(zzajhVar, 0, zzb());
            }
            return false;
        }
        return obj.equals(this);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaje
    final boolean zza(zzaiw zzaiwVar, int i, int i2) {
        if (i2 > zzaiwVar.zzb()) {
            throw new IllegalArgumentException("Length too large: " + i2 + zzb());
        }
        if (i2 > zzaiwVar.zzb()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + i2 + ", " + zzaiwVar.zzb());
        }
        if (zzaiwVar instanceof zzajh) {
            zzajh zzajhVar = (zzajh) zzaiwVar;
            byte[] bArr = this.zzb;
            byte[] bArr2 = zzajhVar.zzb;
            int iZze = zze() + i2;
            int iZze2 = zze();
            int iZze3 = zzajhVar.zze();
            while (iZze2 < iZze) {
                if (bArr[iZze2] != bArr2[iZze3]) {
                    return false;
                }
                iZze2++;
                iZze3++;
            }
            return true;
        }
        return zzaiwVar.zza(0, i2).equals(zza(0, i2));
    }
}
