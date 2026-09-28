package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaft implements zzaeb {
    private String zza;
    private String zzb = "http://localhost";
    private final String zzc;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeb
    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("identifier", this.zza);
        jSONObject.put("continueUri", this.zzb);
        String str = this.zzc;
        if (str != null) {
            jSONObject.put("tenantId", str);
        }
        return jSONObject.toString();
    }

    public zzaft(String str, String str2) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzc = str2;
    }
}
