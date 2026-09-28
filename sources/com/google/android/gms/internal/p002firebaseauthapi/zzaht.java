package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaht implements zzahp {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private zzafn zzg;
    private final String zzh;

    public static zzaht zza(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Preconditions.checkNotEmpty(str2);
        return new zzaht(str, "phone", str2, str3, str4, str5, str6, null);
    }

    public final String zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeb
    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("idToken", this.zza);
        jSONObject.put("mfaProvider", 1);
        if (this.zzb != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("phoneNumber", this.zzb);
            if (!TextUtils.isEmpty(this.zzd)) {
                jSONObject2.put("recaptchaToken", this.zzd);
            }
            if (!TextUtils.isEmpty(this.zze)) {
                jSONObject2.put("playIntegrityToken", this.zze);
            }
            zzafn zzafnVar = this.zzg;
            if (zzafnVar != null) {
                jSONObject2.put("autoRetrievalInfo", zzafnVar.zza());
            }
            String str = this.zzf;
            if (str != null) {
                zzail.zza(jSONObject2, "captchaResponse", str);
            } else {
                zzail.zza(jSONObject2);
            }
            jSONObject.put("phoneEnrollmentInfo", jSONObject2);
        }
        if (!TextUtils.isEmpty(null)) {
            jSONObject.put("tenantId", (Object) null);
        }
        return jSONObject.toString();
    }

    private zzaht(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.zza = Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        this.zzb = str3;
        this.zzc = str4;
        this.zzd = str5;
        this.zze = str6;
        this.zzf = str7;
        this.zzh = null;
    }

    public final void zza(zzafn zzafnVar) {
        this.zzg = zzafnVar;
    }
}
