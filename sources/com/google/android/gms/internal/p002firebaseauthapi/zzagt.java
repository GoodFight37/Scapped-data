package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Strings;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public class zzagt implements zzaea<zzagt> {
    private static final String zza = "zzagt";
    private String zzb;
    private zzaj<zzahe> zzc;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaea
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final zzagt zza(String str) throws zzabr {
        zzaj<zzahe> zzajVarZza;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = Strings.emptyToNull(jSONObject.optString("recaptchaKey"));
            if (jSONObject.has("recaptchaEnforcementState")) {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("recaptchaEnforcementState");
                if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
                    zzajVarZza = zzaj.zza(new ArrayList());
                } else {
                    zzam zzamVarZzg = zzaj.zzg();
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                        zzamVarZzg.zza(jSONObject2 == null ? zzahe.zza(null, null) : zzahe.zza(Strings.emptyToNull(jSONObject2.optString("provider")), Strings.emptyToNull(jSONObject2.optString("enforcementState"))));
                    }
                    zzajVarZza = zzamVarZzg.zza();
                }
                this.zzc = zzajVarZza;
            }
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzail.zza(e, zza, str);
        }
    }

    public final String zzb(String str) {
        Preconditions.checkNotEmpty(str);
        zzaj<zzahe> zzajVar = this.zzc;
        if (zzajVar != null && !zzajVar.isEmpty()) {
            zzaj<zzahe> zzajVar2 = this.zzc;
            int size = zzajVar2.size();
            int i = 0;
            while (i < size) {
                zzahe zzaheVar = zzajVar2.get(i);
                i++;
                zzahe zzaheVar2 = zzaheVar;
                String strZza = zzaheVar2.zza();
                String strZzb = zzaheVar2.zzb();
                if (strZza != null && strZzb != null && strZzb.equals(str)) {
                    return zzaheVar2.zza();
                }
            }
        }
        return null;
    }

    public final String zza() {
        return this.zzb;
    }

    public final boolean zzc(String str) {
        String strZzb = zzb(str);
        if (strZzb == null) {
            return false;
        }
        return strZzb.equals("ENFORCE") || strZzb.equals("AUDIT");
    }
}
