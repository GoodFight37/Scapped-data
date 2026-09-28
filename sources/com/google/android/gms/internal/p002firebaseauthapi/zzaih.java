package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaih implements zzaeb {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private boolean zzf;

    public static zzaih zza(String str, String str2, boolean z) {
        zzaih zzaihVar = new zzaih();
        zzaihVar.zzb = Preconditions.checkNotEmpty(str);
        zzaihVar.zzc = Preconditions.checkNotEmpty(str2);
        zzaihVar.zzf = z;
        return zzaihVar;
    }

    public static zzaih zzb(String str, String str2, boolean z) {
        zzaih zzaihVar = new zzaih();
        zzaihVar.zza = Preconditions.checkNotEmpty(str);
        zzaihVar.zzd = Preconditions.checkNotEmpty(str2);
        zzaihVar.zzf = z;
        return zzaihVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeb
    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.zzd)) {
            jSONObject.put("phoneNumber", this.zza);
            jSONObject.put("temporaryProof", this.zzd);
        } else {
            jSONObject.put("sessionInfo", this.zzb);
            jSONObject.put("code", this.zzc);
        }
        String str = this.zze;
        if (str != null) {
            jSONObject.put("idToken", str);
        }
        if (!this.zzf) {
            jSONObject.put("operation", 2);
        }
        return jSONObject.toString();
    }

    private zzaih() {
    }

    public final void zza(String str) {
        this.zze = str;
    }
}
