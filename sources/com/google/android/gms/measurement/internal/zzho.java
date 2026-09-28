package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzqr;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzho {
    final /* synthetic */ zzht zza;
    private final String zzb;
    private final Bundle zzc;
    private Bundle zzd;

    public zzho(zzht zzhtVar, String str, Bundle bundle) {
        this.zza = zzhtVar;
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
        this.zzc = new Bundle();
    }

    public final void zzb(Bundle bundle) {
        zzht zzhtVar;
        Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        zzht zzhtVar2 = this.zza;
        SharedPreferences.Editor editorEdit = zzhtVar2.zzb().edit();
        if (bundle2.size() == 0) {
            editorEdit.remove(this.zzb);
        } else {
            String str = this.zzb;
            JSONArray jSONArray = new JSONArray();
            for (String str2 : bundle2.keySet()) {
                Object obj = bundle2.get(str2);
                if (obj != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("n", str2);
                        zzqr.zzb();
                        zzio zzioVar = zzhtVar2.zzu;
                        zzhtVar = zzhtVar2;
                        if (zzioVar.zzf().zzx(null, zzgi.zzaW)) {
                            try {
                                if (obj instanceof String) {
                                    jSONObject.put("v", obj.toString());
                                    jSONObject.put("t", "s");
                                } else if (obj instanceof Long) {
                                    jSONObject.put("v", obj.toString());
                                    jSONObject.put("t", "l");
                                } else if (obj instanceof int[]) {
                                    jSONObject.put("v", Arrays.toString((int[]) obj));
                                    jSONObject.put("t", "ia");
                                } else if (obj instanceof long[]) {
                                    jSONObject.put("v", Arrays.toString((long[]) obj));
                                    jSONObject.put("t", "la");
                                } else if (obj instanceof Double) {
                                    jSONObject.put("v", obj.toString());
                                    jSONObject.put("t", "d");
                                } else {
                                    zzioVar.zzaW().zze().zzb("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                                }
                                jSONArray.put(jSONObject);
                            } catch (JSONException e) {
                                e = e;
                                this.zza.zzu.zzaW().zze().zzb("Cannot serialize bundle value to SharedPreferences", e);
                            }
                        } else {
                            jSONObject.put("v", obj.toString());
                            if (obj instanceof String) {
                                jSONObject.put("t", "s");
                            } else if (obj instanceof Long) {
                                jSONObject.put("t", "l");
                            } else if (obj instanceof Double) {
                                jSONObject.put("t", "d");
                            } else {
                                zzioVar.zzaW().zze().zzb("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                            }
                            jSONArray.put(jSONObject);
                        }
                    } catch (JSONException e2) {
                        e = e2;
                        zzhtVar = zzhtVar2;
                    }
                    zzhtVar2 = zzhtVar;
                }
            }
            editorEdit.putString(str, jSONArray.toString());
        }
        editorEdit.apply();
        this.zzd = bundle2;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0086  */
    public final Bundle zza() {
        byte b;
        if (this.zzd == null) {
            zzht zzhtVar = this.zza;
            String string = zzhtVar.zzb().getString(this.zzb, null);
            if (string != null) {
                try {
                    Bundle bundle = new Bundle();
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            String string2 = jSONObject.getString("n");
                            String string3 = jSONObject.getString("t");
                            int iHashCode = string3.hashCode();
                            if (iHashCode != 100) {
                                if (iHashCode != 108) {
                                    if (iHashCode != 115) {
                                        if (iHashCode != 3352) {
                                            if (iHashCode == 3445 && string3.equals("la")) {
                                                b = 4;
                                            } else {
                                                b = -1;
                                            }
                                        } else if (string3.equals("ia")) {
                                            b = 3;
                                        } else {
                                            b = -1;
                                        }
                                    } else if (string3.equals("s")) {
                                        b = 0;
                                    } else {
                                        b = -1;
                                    }
                                } else if (string3.equals("l")) {
                                    b = 2;
                                } else {
                                    b = -1;
                                }
                            } else if (string3.equals("d")) {
                                b = 1;
                            } else {
                                b = -1;
                            }
                            if (b == 0) {
                                bundle.putString(string2, jSONObject.getString("v"));
                            } else if (b == 1) {
                                bundle.putDouble(string2, Double.parseDouble(jSONObject.getString("v")));
                            } else if (b == 2) {
                                bundle.putLong(string2, Long.parseLong(jSONObject.getString("v")));
                            } else if (b == 3) {
                                zzqr.zzb();
                                if (zzhtVar.zzu.zzf().zzx(null, zzgi.zzaW)) {
                                    JSONArray jSONArray2 = new JSONArray(jSONObject.getString("v"));
                                    int length = jSONArray2.length();
                                    int[] iArr = new int[length];
                                    for (int i2 = 0; i2 < length; i2++) {
                                        iArr[i2] = jSONArray2.optInt(i2);
                                    }
                                    bundle.putIntArray(string2, iArr);
                                }
                            } else if (b != 4) {
                                zzhtVar.zzu.zzaW().zze().zzb("Unrecognized persisted bundle type. Type", string3);
                            } else {
                                zzqr.zzb();
                                if (zzhtVar.zzu.zzf().zzx(null, zzgi.zzaW)) {
                                    JSONArray jSONArray3 = new JSONArray(jSONObject.getString("v"));
                                    int length2 = jSONArray3.length();
                                    long[] jArr = new long[length2];
                                    for (int i3 = 0; i3 < length2; i3++) {
                                        jArr[i3] = jSONArray3.optLong(i3);
                                    }
                                    bundle.putLongArray(string2, jArr);
                                }
                            }
                        } catch (NumberFormatException | JSONException unused) {
                            this.zza.zzu.zzaW().zze().zza("Error reading value from SharedPreferences. Value dropped");
                        }
                    }
                    this.zzd = bundle;
                } catch (JSONException unused2) {
                    this.zza.zzu.zzaW().zze().zza("Error loading bundle from SharedPreferences. Values will be lost");
                }
            }
            if (this.zzd == null) {
                this.zzd = this.zzc;
            }
        }
        return new Bundle((Bundle) Preconditions.checkNotNull(this.zzd));
    }
}
