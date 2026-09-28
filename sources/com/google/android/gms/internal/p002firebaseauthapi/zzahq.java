package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.util.Strings;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public class zzahq implements zzaea<zzahq> {
    private static final String zza = "zzahq";
    private String zzb;
    private String zzc;
    private long zzd;

    public final long zza() {
        return this.zzd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaea
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzahq zza(String str) throws zzabr {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = Strings.emptyToNull(jSONObject.optString("idToken", null));
            Strings.emptyToNull(jSONObject.optString("displayName", null));
            Strings.emptyToNull(jSONObject.optString("email", null));
            this.zzc = Strings.emptyToNull(jSONObject.optString("refreshToken", null));
            this.zzd = jSONObject.optLong("expiresIn", 0L);
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzail.zza(e, zza, str);
        }
    }

    public final String zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzc;
    }
}
