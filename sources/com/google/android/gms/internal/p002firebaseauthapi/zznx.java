package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zznx {

    @Nullable
    private ArrayList<zznw> zza = new ArrayList<>();
    private zznr zzb = zznr.zza;

    @Nullable
    private Integer zzc = null;

    public final zznx zza(zzbq zzbqVar, int i, String str, String str2) {
        ArrayList<zznw> arrayList = this.zza;
        if (arrayList == null) {
            throw new IllegalStateException("addEntry cannot be called after build()");
        }
        arrayList.add(new zznw(zzbqVar, i, str, str2));
        return this;
    }

    public final zznx zza(zznr zznrVar) {
        if (this.zza == null) {
            throw new IllegalStateException("setAnnotations cannot be called after build()");
        }
        this.zzb = zznrVar;
        return this;
    }

    public final zznx zza(int i) {
        if (this.zza == null) {
            throw new IllegalStateException("setPrimaryKeyId cannot be called after build()");
        }
        this.zzc = Integer.valueOf(i);
        return this;
    }

    public final zznu zza() throws GeneralSecurityException {
        if (this.zza == null) {
            throw new IllegalStateException("cannot call build() twice");
        }
        Integer num = this.zzc;
        if (num != null) {
            int iIntValue = num.intValue();
            ArrayList<zznw> arrayList = this.zza;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                zznw zznwVar = arrayList.get(i);
                i++;
                if (zznwVar.zza() == iIntValue) {
                }
            }
            throw new GeneralSecurityException("primary key ID is not present in entries");
        }
        zznu zznuVar = new zznu(this.zzb, Collections.unmodifiableList(this.zza), this.zzc);
        this.zza = null;
        return zznuVar;
    }
}
