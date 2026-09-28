package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.util.Strings;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public class zzahg implements zzaea<zzahg> {
    private static final String zza = "zzahg";
    private String zzb;
    private String zzc;
    private String zzd;
    private zzagz zze;

    public final zzagz zza() {
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:37:0x0091  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaea
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzahg zza(String str) throws zzabr {
        String str2;
        byte b;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = Strings.emptyToNull(jSONObject.optString("email"));
            this.zzc = Strings.emptyToNull(jSONObject.optString("newEmail"));
            int iOptInt = jSONObject.optInt("reqType");
            if (iOptInt != 1) {
                switch (iOptInt) {
                    case 4:
                        str2 = "VERIFY_EMAIL";
                        break;
                    case 5:
                        str2 = "RECOVER_EMAIL";
                        break;
                    case 6:
                        str2 = "EMAIL_SIGNIN";
                        break;
                    case 7:
                        str2 = "VERIFY_AND_CHANGE_EMAIL";
                        break;
                    case 8:
                        str2 = "REVERT_SECOND_FACTOR_ADDITION";
                        break;
                    default:
                        str2 = null;
                        break;
                }
            } else {
                str2 = "PASSWORD_RESET";
            }
            this.zzd = str2;
            if (TextUtils.isEmpty(str2)) {
                String strOptString = jSONObject.optString("requestType");
                switch (strOptString.hashCode()) {
                    case -1874510116:
                        if (!strOptString.equals("REVERT_SECOND_FACTOR_ADDITION")) {
                            b = -1;
                        } else {
                            b = 5;
                        }
                        break;
                    case -1452371317:
                        if (!strOptString.equals("PASSWORD_RESET")) {
                            b = -1;
                        } else {
                            b = 1;
                        }
                        break;
                    case -1341836234:
                        if (!strOptString.equals("VERIFY_EMAIL")) {
                            b = -1;
                        } else {
                            b = 0;
                        }
                        break;
                    case -1099157829:
                        if (!strOptString.equals("VERIFY_AND_CHANGE_EMAIL")) {
                            b = -1;
                        } else {
                            b = 3;
                        }
                        break;
                    case 870738373:
                        if (!strOptString.equals("EMAIL_SIGNIN")) {
                            b = -1;
                        } else {
                            b = 2;
                        }
                        break;
                    case 970484929:
                        if (!strOptString.equals("RECOVER_EMAIL")) {
                            b = -1;
                        } else {
                            b = 4;
                        }
                        break;
                    default:
                        b = -1;
                        break;
                }
                this.zzd = (b == 0 || b == 1 || b == 2 || b == 3 || b == 4 || b == 5) ? strOptString : null;
            }
            if (jSONObject.has("mfaInfo")) {
                this.zze = zzagz.zza(jSONObject.optJSONObject("mfaInfo"));
            }
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

    public final String zzd() {
        return this.zzd;
    }

    public final boolean zze() {
        return this.zzb != null;
    }

    public final boolean zzf() {
        return this.zze != null;
    }

    public final boolean zzg() {
        return this.zzc != null;
    }

    public final boolean zzh() {
        return this.zzd != null;
    }
}
