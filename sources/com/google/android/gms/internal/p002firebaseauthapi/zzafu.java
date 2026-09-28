package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import android.util.Log;
import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public class zzafu implements zzaea<zzafu> {
    private static final String zza = "com.google.android.gms.internal.firebase-auth-api.zzafu";
    private String zzb;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaea
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzafu zza(String str) throws zzabr {
        try {
            JSONObject jSONObject = new JSONObject(new JSONObject(str).getString("error"));
            jSONObject.getInt("code");
            this.zzb = jSONObject.getString(MapperConstants.NPF_ERROR_FIELD_MESSAGE);
            return this;
        } catch (NullPointerException | JSONException e) {
            Log.e(zza, "Failed to parse error for string [" + str + "] with exception: " + e.getMessage());
            throw new zzabr("Failed to parse error for string [" + str + "]", e);
        }
    }

    public final String zza() {
        return this.zzb;
    }

    public final boolean zzb() {
        return !TextUtils.isEmpty(this.zzb);
    }
}
