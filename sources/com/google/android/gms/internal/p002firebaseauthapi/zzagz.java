package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzagz {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final long zzd;
    private final zzaia zze;

    private static long zza(String str) {
        try {
            return zzanp.zza(zzanp.zza(str));
        } catch (ParseException e) {
            Log.w("MfaInfo", "Could not parse timestamp as ISOString. Invalid ISOString \"" + str + "\"", e);
            return 0L;
        }
    }

    public final long zza() {
        return this.zzd;
    }

    public static zzagz zza(JSONObject jSONObject) {
        zzagz zzagzVar = new zzagz(jSONObject.optString("phoneInfo", null), jSONObject.optString("mfaEnrollmentId", null), jSONObject.optString("displayName", null), zza(jSONObject.optString("enrolledAt", "")), jSONObject.opt("totpInfo") != null ? new zzaia() : null);
        jSONObject.optString("unobfuscatedPhoneInfo");
        return zzagzVar;
    }

    public final zzaia zzb() {
        return this.zze;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final String zze() {
        return this.zza;
    }

    public static List<zzagz> zza(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(zza(jSONArray.getJSONObject(i)));
        }
        return arrayList;
    }

    private zzagz(String str, String str2, String str3, long j, zzaia zzaiaVar) {
        if (!TextUtils.isEmpty(str) && zzaiaVar != null) {
            Log.e("MfaInfo", "Cannot have both MFA phone_info and totp_info");
            throw new IllegalArgumentException("Cannot have both MFA phone_info and totp_info");
        }
        this.zza = str;
        this.zzb = Preconditions.checkNotEmpty(str2);
        this.zzc = str3;
        this.zzd = j;
        this.zze = zzaiaVar;
    }
}
