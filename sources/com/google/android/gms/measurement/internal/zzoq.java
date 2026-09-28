package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzoq {
    private final Map zza;

    zzoq(Map map) {
        HashMap map2 = new HashMap();
        this.zza = map2;
        map2.putAll(map);
    }

    private final int zzf() {
        try {
            String str = (String) this.zza.get("PolicyVersion");
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private final Bundle zzg() {
        int iZzf;
        Map map = this.zza;
        if ("1".equals(map.get("GoogleConsent")) && (iZzf = zzf()) >= 0) {
            String str = (String) map.get("PurposeConsents");
            if (!TextUtils.isEmpty(str)) {
                Bundle bundle = new Bundle();
                if (str.length() > 0) {
                    bundle.putString(zzjw.AD_STORAGE.zze, str.charAt(0) == '1' ? "granted" : "denied");
                }
                if (str.length() > 3) {
                    bundle.putString(zzjw.AD_PERSONALIZATION.zze, (str.charAt(2) == '1' && str.charAt(3) == '1') ? "granted" : "denied");
                }
                if (str.length() > 6 && iZzf >= 4) {
                    bundle.putString(zzjw.AD_USER_DATA.zze, (str.charAt(0) == '1' && str.charAt(6) == '1') ? "granted" : "denied");
                }
                return bundle;
            }
        }
        return Bundle.EMPTY;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzoq) {
            return zze().equalsIgnoreCase(((zzoq) obj).zze());
        }
        return false;
    }

    public final int hashCode() {
        return zze().hashCode();
    }

    public final String toString() {
        return zze();
    }

    /* JADX WARN: Code duplicated, block: B:15:0x004e  */
    /* JADX WARN: Code duplicated, block: B:17:0x005a  */
    /* JADX WARN: Code duplicated, block: B:19:0x0064  */
    /* JADX WARN: Code duplicated, block: B:21:0x0069  */
    /* JADX WARN: Code duplicated, block: B:24:0x0071  */
    /* JADX WARN: Code duplicated, block: B:26:0x008b  */
    /* JADX WARN: Code duplicated, block: B:27:0x008d  */
    /* JADX WARN: Code duplicated, block: B:33:0x00af  */
    /* JADX WARN: Code duplicated, block: B:36:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:43:0x00d9  */
    public final Bundle zza() {
        Map map;
        Bundle bundle;
        String str;
        String str2;
        String str3;
        zzgg zzggVar = zzgi.zzbj;
        if (((Boolean) zzggVar.zza(null)).booleanValue()) {
            Map map2 = this.zza;
            if ("1".equals(map2.get("gdprApplies")) && "1".equals(map2.get("EnableAdvertiserConsentMode"))) {
                if (((Boolean) zzggVar.zza(null)).booleanValue()) {
                    return zzg();
                }
                map = this.zza;
                if (map.get("Version") == null) {
                    return zzg();
                }
                if (zzf() >= 0) {
                    bundle = new Bundle();
                    String str4 = zzjw.AD_STORAGE.zze;
                    str = "denied";
                    if (true != Objects.equals(map.get("AuthorizePurpose1"), "1")) {
                        str2 = "denied";
                    } else {
                        str2 = "granted";
                    }
                    bundle.putString(str4, str2);
                    String str5 = zzjw.AD_PERSONALIZATION.zze;
                    if (Objects.equals(map.get("AuthorizePurpose3"), "1") || !Objects.equals(map.get("AuthorizePurpose4"), "1")) {
                        str3 = "denied";
                    } else {
                        str3 = "granted";
                    }
                    bundle.putString(str5, str3);
                    if (zzf() >= 4) {
                        String str6 = zzjw.AD_USER_DATA.zze;
                        if (Objects.equals(map.get("AuthorizePurpose1"), "1") && Objects.equals(map.get("AuthorizePurpose7"), "1")) {
                            str = "granted";
                        }
                        bundle.putString(str6, str);
                    }
                    return bundle;
                }
            }
        } else {
            Map map3 = this.zza;
            if ("1".equals(map3.get("GoogleConsent")) && "1".equals(map3.get("gdprApplies")) && "1".equals(map3.get("EnableAdvertiserConsentMode"))) {
                if (((Boolean) zzggVar.zza(null)).booleanValue()) {
                    return zzg();
                }
                map = this.zza;
                if (map.get("Version") == null) {
                    return zzg();
                }
                if (zzf() >= 0) {
                    bundle = new Bundle();
                    String str7 = zzjw.AD_STORAGE.zze;
                    str = "denied";
                    if (true != Objects.equals(map.get("AuthorizePurpose1"), "1")) {
                        str2 = "denied";
                    } else {
                        str2 = "granted";
                    }
                    bundle.putString(str7, str2);
                    String str8 = zzjw.AD_PERSONALIZATION.zze;
                    if (Objects.equals(map.get("AuthorizePurpose3"), "1")) {
                        str3 = "denied";
                    } else {
                        str3 = "denied";
                    }
                    bundle.putString(str8, str3);
                    if (zzf() >= 4) {
                        String str9 = zzjw.AD_USER_DATA.zze;
                        if (Objects.equals(map.get("AuthorizePurpose1"), "1")) {
                            str = "granted";
                        }
                        bundle.putString(str9, str);
                    }
                    return bundle;
                }
            }
        }
        return Bundle.EMPTY;
    }

    public final String zzb() {
        String str = (String) this.zza.get("PurposeDiagnostics");
        return TextUtils.isEmpty(str) ? "200000" : str;
    }

    public final String zzc(zzoq zzoqVar) {
        Map map = zzoqVar.zza;
        String str = "1";
        String str2 = (map.isEmpty() || ((String) map.get("Version")) != null) ? "0" : "1";
        Bundle bundleZza = zza();
        Bundle bundleZza2 = zzoqVar.zza();
        if (bundleZza.size() == bundleZza2.size() && Objects.equals(bundleZza.getString("ad_storage"), bundleZza2.getString("ad_storage")) && Objects.equals(bundleZza.getString("ad_personalization"), bundleZza2.getString("ad_personalization")) && Objects.equals(bundleZza.getString("ad_user_data"), bundleZza2.getString("ad_user_data"))) {
            str = "0";
        }
        return str2.concat(str);
    }

    public final String zzd() {
        StringBuilder sb = new StringBuilder("1");
        int i = -1;
        try {
            String str = (String) this.zza.get("CmpSdkID");
            if (!TextUtils.isEmpty(str)) {
                i = Integer.parseInt(str);
            }
        } catch (NumberFormatException unused) {
        }
        if (i < 0 || i > 4095) {
            sb.append("00");
        } else {
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i >> 6));
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i & 63));
        }
        int iZzf = zzf();
        if (iZzf < 0 || iZzf > 63) {
            sb.append("0");
        } else {
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(iZzf));
        }
        Preconditions.checkArgument(true);
        Map map = this.zza;
        int i2 = true != "1".equals(map.get("gdprApplies")) ? 0 : 2;
        boolean zEquals = "1".equals(map.get("EnableAdvertiserConsentMode"));
        int i3 = i2 | 4;
        if (zEquals) {
            i3 = i2 | 12;
        }
        sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i3));
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    final String zze() {
        StringBuilder sb = new StringBuilder();
        ImmutableList immutableList = zzot.zza;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            String str = (String) immutableList.get(i);
            Map map = this.zza;
            if (map.containsKey(str)) {
                if (sb.length() > 0) {
                    sb.append(";");
                }
                sb.append(str);
                sb.append("=");
                sb.append((String) map.get(str));
            }
        }
        return sb.toString();
    }
}
