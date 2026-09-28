package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.util.Strings;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public class zzaii implements zzaea<zzaii> {
    private static final String zza = "zzaii";
    private String zzb;
    private String zzc;
    private long zzd;
    private List<zzagz> zze;
    private String zzf;

    public final long zza() {
        return this.zzd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaea
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzaii zza(String str) throws zzabr {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Strings.emptyToNull(jSONObject.optString("localId", null));
            Strings.emptyToNull(jSONObject.optString("email", null));
            Strings.emptyToNull(jSONObject.optString("displayName", null));
            this.zzb = Strings.emptyToNull(jSONObject.optString("idToken", null));
            Strings.emptyToNull(jSONObject.optString("photoUrl", null));
            this.zzc = Strings.emptyToNull(jSONObject.optString("refreshToken", null));
            this.zzd = jSONObject.optLong("expiresIn", 0L);
            this.zze = zzagz.zza(jSONObject.optJSONArray("mfaInfo"));
            this.zzf = jSONObject.optString("mfaPendingCredential", null);
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzail.zza(e, zza, str);
        }
    }

    public final String zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzf;
    }

    public final String zzd() {
        return this.zzc;
    }

    public final List<zzagz> zze() {
        return this.zze;
    }

    public final boolean zzf() {
        return !TextUtils.isEmpty(this.zzf);
    }
}
