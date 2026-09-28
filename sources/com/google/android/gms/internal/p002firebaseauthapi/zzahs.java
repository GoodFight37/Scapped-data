package com.google.android.gms.internal.p002firebaseauthapi;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public class zzahs implements zzaea<zzahs> {
    private static final String zza = "zzahs";

    public String zza() {
        return null;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaea
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public zzahs zza(String str) throws zzabr {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optJSONObject("phoneSessionInfo") != null) {
                return (zzahw) ((zzahs) new zzahw().zza(str));
            }
            if (jSONObject.optJSONObject("totpSessionInfo") != null) {
                return (zzahy) ((zzahs) new zzahy().zza(str));
            }
            throw new IllegalArgumentException("Missing phoneSessionInfo or totpSessionInfo.");
        } catch (NullPointerException | JSONException e) {
            throw zzail.zza(e, zza, str);
        }
    }
}
