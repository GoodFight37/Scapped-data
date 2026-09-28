package com.google.android.gms.internal.p002firebaseauthapi;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public class zzagb implements zzaea<zzagb> {
    private static final String zza = "zzagb";
    private String zzb;
    private String zzc;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaea
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzagb zza(String str) throws zzabr {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = jSONObject.optString("idToken", null);
            this.zzc = jSONObject.optString("refreshToken", null);
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzail.zza(e, zza, str);
        }
    }

    public final String zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zzc;
    }
}
