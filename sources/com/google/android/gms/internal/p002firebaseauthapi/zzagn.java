package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.ActionCodeSettings;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzagn implements zzaeb {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private ActionCodeSettings zze;
    private String zzf;
    private String zzg;

    public final ActionCodeSettings zzb() {
        return this.zze;
    }

    public static zzagn zza(ActionCodeSettings actionCodeSettings, String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(actionCodeSettings);
        return new zzagn(7, actionCodeSettings, null, str2, str, null, null);
    }

    public final zzagn zza(ActionCodeSettings actionCodeSettings) {
        this.zze = (ActionCodeSettings) Preconditions.checkNotNull(actionCodeSettings);
        return this;
    }

    public final zzagn zza(String str) {
        this.zzg = str;
        return this;
    }

    public final zzagn zzb(String str) {
        this.zzb = Preconditions.checkNotEmpty(str);
        return this;
    }

    public final zzagn zzc(String str) {
        this.zzf = str;
        return this;
    }

    public final zzagn zzd(String str) {
        this.zzd = Preconditions.checkNotEmpty(str);
        return this;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zzd;
    }

    private static String zza(int i) {
        if (i == 1) {
            return "PASSWORD_RESET";
        }
        if (i == 4) {
            return "VERIFY_EMAIL";
        }
        if (i == 6) {
            return "EMAIL_SIGNIN";
        }
        if (i == 7) {
            return "VERIFY_AND_CHANGE_EMAIL";
        }
        return "REQUEST_TYPE_UNSET_ENUM_VALUE";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeb
    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String str = this.zza;
        str.hashCode();
        int i = 1;
        switch (str) {
            case "PASSWORD_RESET":
                break;
            case "VERIFY_EMAIL":
                i = 4;
                break;
            case "VERIFY_AND_CHANGE_EMAIL":
                i = 7;
                break;
            case "EMAIL_SIGNIN":
                i = 6;
                break;
            default:
                i = 0;
                break;
        }
        jSONObject.put("requestType", i);
        String str2 = this.zzb;
        if (str2 != null) {
            jSONObject.put("email", str2);
        }
        String str3 = this.zzc;
        if (str3 != null) {
            jSONObject.put("newEmail", str3);
        }
        String str4 = this.zzd;
        if (str4 != null) {
            jSONObject.put("idToken", str4);
        }
        ActionCodeSettings actionCodeSettings = this.zze;
        if (actionCodeSettings != null) {
            jSONObject.put("androidInstallApp", actionCodeSettings.getAndroidInstallApp());
            jSONObject.put("canHandleCodeInApp", this.zze.canHandleCodeInApp());
            if (this.zze.getUrl() != null) {
                jSONObject.put("continueUrl", this.zze.getUrl());
            }
            if (this.zze.getIOSBundle() != null) {
                jSONObject.put("iosBundleId", this.zze.getIOSBundle());
            }
            if (this.zze.zzd() != null) {
                jSONObject.put("iosAppStoreId", this.zze.zzd());
            }
            if (this.zze.getAndroidPackageName() != null) {
                jSONObject.put("androidPackageName", this.zze.getAndroidPackageName());
            }
            if (this.zze.getAndroidMinimumVersion() != null) {
                jSONObject.put("androidMinimumVersion", this.zze.getAndroidMinimumVersion());
            }
            if (this.zze.zzc() != null) {
                jSONObject.put("dynamicLinkDomain", this.zze.zzc());
            }
            if (this.zze.getLinkDomain() != null) {
                jSONObject.put("linkDomain", this.zze.getLinkDomain());
            }
        }
        String str5 = this.zzf;
        if (str5 != null) {
            jSONObject.put("tenantId", str5);
        }
        String str6 = this.zzg;
        if (str6 != null) {
            zzail.zza(jSONObject, "captchaResp", str6);
        } else {
            zzail.zza(jSONObject);
        }
        return jSONObject.toString();
    }

    public zzagn(int i) {
        this.zza = zza(i);
    }

    private zzagn(int i, ActionCodeSettings actionCodeSettings, String str, String str2, String str3, String str4, String str5) {
        this.zza = zza(7);
        this.zze = (ActionCodeSettings) Preconditions.checkNotNull(actionCodeSettings);
        this.zzb = null;
        this.zzc = str2;
        this.zzd = str3;
        this.zzf = null;
        this.zzg = null;
    }
}
