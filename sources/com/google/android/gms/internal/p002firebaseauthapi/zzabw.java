package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.auth.internal.zzar;
import com.google.firebase.auth.internal.zzl;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzabw extends zzaeg<SignInMethodQueryResult, zzl> {
    private final String zzu;
    private final String zzv;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final String zza() {
        return "fetchSignInMethodsForEmail";
    }

    public zzabw(String str, String str2) {
        super(3);
        Preconditions.checkNotEmpty(str, "email cannot be null or empty");
        this.zzu = str;
        this.zzv = str2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeg
    public final void zzb() {
        List listZzh;
        if (this.zzl.zza() == null) {
            listZzh = zzaj.zzh();
        } else {
            listZzh = (List) Preconditions.checkNotNull(this.zzl.zza());
        }
        zzb(new zzar(listZzh));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final void zza(TaskCompletionSource taskCompletionSource, zzado zzadoVar) {
        this.zzg = new zzaeq(this, taskCompletionSource);
        zzadoVar.zze(this.zzu, this.zzv, this.zzb);
    }
}
