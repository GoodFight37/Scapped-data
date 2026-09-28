package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public class zzafw implements zzaea<zzafw> {
    private static final String zza = "zzafw";
    private List<String> zzb;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaea
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzafw zza(String str) throws zzabr {
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.optString("authUri", null);
            jSONObject.optBoolean("registered", false);
            jSONObject.optString("providerId", null);
            jSONObject.optBoolean("forExistingProvider", false);
            if (jSONObject.has("allProviders")) {
                new zzahx(1, zzail.zza(jSONObject.optJSONArray("allProviders")));
            } else {
                zzahx.zza();
            }
            this.zzb = zzail.zza(jSONObject.optJSONArray("signinMethods"));
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzail.zza(e, zza, str);
        }
    }

    public final List<String> zza() {
        return this.zzb;
    }

    public zzafw() {
        zzahx.zza();
    }
}
