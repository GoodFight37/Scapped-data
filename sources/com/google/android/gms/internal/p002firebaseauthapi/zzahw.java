package com.google.android.gms.internal.p002firebaseauthapi;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzahw extends zzahs {
    private static final String zza = "zzahw";
    private String zzb;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzahs, com.google.android.gms.internal.p002firebaseauthapi.zzaea
    public final /* synthetic */ zzaea zza(String str) throws zzabr {
        return (zzahw) zza(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzahs
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzahw zza(String str) throws zzabr {
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("phoneSessionInfo");
            if (jSONObjectOptJSONObject != null) {
                this.zzb = zzae.zza(jSONObjectOptJSONObject.optString("sessionInfo"));
            }
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzail.zza(e, zza, str);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzahs
    public final String zza() {
        return this.zzb;
    }
}
