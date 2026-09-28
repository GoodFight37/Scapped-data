package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Status;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzafi extends zzadp {
    private final String zza;
    private final /* synthetic */ zzafd zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzafi(zzafd zzafdVar, zzadp zzadpVar, String str) {
        super(zzadpVar);
        this.zzb = zzafdVar;
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadp
    public final void zzb(String str) {
        zzafd.zza.d("onCodeSent", new Object[0]);
        zzafk zzafkVar = (zzafk) this.zzb.zzd.get(this.zza);
        if (zzafkVar == null) {
            return;
        }
        Iterator<zzadp> it = zzafkVar.zzb.iterator();
        while (it.hasNext()) {
            it.next().zzb(str);
        }
        zzafkVar.zzg = true;
        zzafkVar.zzd = str;
        if (zzafkVar.zza <= 0) {
            this.zzb.zze(this.zza);
        } else if (!zzafkVar.zzc) {
            this.zzb.zzd(this.zza);
        } else {
            if (zzae.zzc(zzafkVar.zze)) {
                return;
            }
            zzafd.zzb(this.zzb, this.zza);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadp
    public final void zza(Status status) {
        zzafd.zza.e("SMS verification code request failed: " + CommonStatusCodes.getStatusCodeString(status.getStatusCode()) + " " + status.getStatusMessage(), new Object[0]);
        zzafk zzafkVar = (zzafk) this.zzb.zzd.get(this.zza);
        if (zzafkVar == null) {
            return;
        }
        Iterator<zzadp> it = zzafkVar.zzb.iterator();
        while (it.hasNext()) {
            it.next().zza(status);
        }
        this.zzb.zzb(this.zza);
    }
}
