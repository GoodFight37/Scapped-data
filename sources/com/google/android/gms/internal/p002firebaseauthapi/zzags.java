package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.util.Strings;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public class zzags implements zzaea<zzags> {
    private static final String zza = "zzags";
    private String zzb;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaea
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzags zza(String str) throws zzabr {
        try {
            this.zzb = Strings.emptyToNull(new JSONObject(str).optString("producerProjectNumber"));
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzail.zza(e, zza, str);
        }
    }

    public final String zza() {
        return this.zzb;
    }

    public zzags() {
    }

    public zzags(String str) {
        this.zzb = str;
    }
}
