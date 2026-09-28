package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.p002firebaseauthapi.zzagw;
import com.google.android.gms.internal.p002firebaseauthapi.zzzp;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorGenerator;
import com.google.firebase.auth.TotpMultiFactorInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzby {
    private Context zza;
    private String zzb;
    private SharedPreferences zzc;
    private Logger zzd;

    public final FirebaseUser zza() {
        String string = this.zzc.getString("com.google.firebase.auth.FIREBASE_USER", null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            if (jSONObject.has("type") && "com.google.firebase.auth.internal.DefaultFirebaseUser".equalsIgnoreCase(jSONObject.optString("type"))) {
                return zza(jSONObject);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public final zzagw zza(FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(firebaseUser);
        String string = this.zzc.getString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", firebaseUser.getUid()), null);
        if (string != null) {
            return zzagw.zzb(string);
        }
        return null;
    }

    private final zzaf zza(JSONObject jSONObject) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        MultiFactorInfo multiFactorInfoZza;
        zzah zzahVarZza;
        try {
            String string = jSONObject.getString("cachedTokenState");
            String string2 = jSONObject.getString("applicationName");
            boolean z = jSONObject.getBoolean("anonymous");
            String string3 = jSONObject.getString("version");
            String str = string3 != null ? string3 : "2";
            JSONArray jSONArray3 = jSONObject.getJSONArray("userInfos");
            int length = jSONArray3.length();
            if (length == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(zzab.zza(jSONArray3.getString(i)));
            }
            zzaf zzafVar = new zzaf(FirebaseApp.getInstance(string2), arrayList);
            if (!TextUtils.isEmpty(string)) {
                zzafVar.zza(zzagw.zzb(string));
            }
            if (!z) {
                zzafVar.zzb();
            }
            zzafVar.zza(str);
            if (jSONObject.has("userMetadata") && (zzahVarZza = zzah.zza(jSONObject.getJSONObject("userMetadata"))) != null) {
                zzafVar.zza(zzahVarZza);
            }
            if (jSONObject.has("userMultiFactorInfo") && (jSONArray2 = jSONObject.getJSONArray("userMultiFactorInfo")) != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    JSONObject jSONObject2 = new JSONObject(jSONArray2.getString(i2));
                    String strOptString = jSONObject2.optString(MultiFactorInfo.FACTOR_ID_KEY);
                    if ("phone".equals(strOptString)) {
                        multiFactorInfoZza = PhoneMultiFactorInfo.zza(jSONObject2);
                    } else {
                        multiFactorInfoZza = Objects.equals(strOptString, TotpMultiFactorGenerator.FACTOR_ID) ? TotpMultiFactorInfo.zza(jSONObject2) : null;
                    }
                    arrayList2.add(multiFactorInfoZza);
                }
                zzafVar.zzc(arrayList2);
            }
            if (jSONObject.has("passkeyInfo") && (jSONArray = jSONObject.getJSONArray("passkeyInfo")) != null) {
                ArrayList arrayList3 = new ArrayList();
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    arrayList3.add(com.google.firebase.auth.zzal.zza(new JSONObject(jSONArray.getString(i3))));
                }
                zzafVar.zzb(arrayList3);
            }
            return zzafVar;
        } catch (zzzp | ArrayIndexOutOfBoundsException | IllegalArgumentException | JSONException e) {
            this.zzd.wtf(e);
            return null;
        }
    }

    private final String zzc(FirebaseUser firebaseUser) {
        JSONObject jSONObject = new JSONObject();
        if (!zzaf.class.isAssignableFrom(firebaseUser.getClass())) {
            return null;
        }
        zzaf zzafVar = (zzaf) firebaseUser;
        try {
            jSONObject.put("cachedTokenState", zzafVar.zze());
            jSONObject.put("applicationName", zzafVar.zza().getName());
            jSONObject.put("type", "com.google.firebase.auth.internal.DefaultFirebaseUser");
            if (zzafVar.zzj() != null) {
                JSONArray jSONArray = new JSONArray();
                List<zzab> listZzj = zzafVar.zzj();
                int size = listZzj.size();
                if (listZzj.size() > 30) {
                    this.zzd.w("Provider user info list size larger than max size, truncating list to %d. Actual list size: %d", 30, Integer.valueOf(listZzj.size()));
                    size = 30;
                }
                boolean z = false;
                for (int i = 0; i < size; i++) {
                    zzab zzabVar = listZzj.get(i);
                    if (zzabVar.getProviderId().equals(FirebaseAuthProvider.PROVIDER_ID)) {
                        z = true;
                    }
                    if (i == size - 1 && !z) {
                        break;
                    }
                    jSONArray.put(zzabVar.zzb());
                }
                if (!z) {
                    int i2 = size - 1;
                    while (true) {
                        if (i2 >= listZzj.size() || i2 < 0) {
                            if (!z) {
                                this.zzd.w("Malformed user object! No Firebase Auth provider id found. Provider user info list size: %d, trimmed size: %d", Integer.valueOf(listZzj.size()), Integer.valueOf(size));
                                if (listZzj.size() >= 5) {
                                    break;
                                }
                                StringBuilder sb = new StringBuilder("Provider user info list:\n");
                                Iterator<zzab> it = listZzj.iterator();
                                while (it.hasNext()) {
                                    sb.append(String.format("Provider - %s\n", it.next().getProviderId()));
                                }
                                this.zzd.w(sb.toString(), new Object[0]);
                                break;
                            }
                            break;
                        }
                        zzab zzabVar2 = listZzj.get(i2);
                        if (zzabVar2.getProviderId().equals(FirebaseAuthProvider.PROVIDER_ID)) {
                            jSONArray.put(zzabVar2.zzb());
                            break;
                        }
                        if (i2 == listZzj.size() - 1) {
                            jSONArray.put(zzabVar2.zzb());
                        }
                        i2++;
                    }
                }
                jSONObject.put("userInfos", jSONArray);
            }
            jSONObject.put("anonymous", zzafVar.isAnonymous());
            jSONObject.put("version", "2");
            if (zzafVar.getMetadata() != null) {
                jSONObject.put("userMetadata", ((zzah) zzafVar.getMetadata()).zza());
            }
            List<MultiFactorInfo> enrolledFactors = ((zzaj) zzafVar.getMultiFactor()).getEnrolledFactors();
            if (enrolledFactors != null && !enrolledFactors.isEmpty()) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i3 = 0; i3 < enrolledFactors.size(); i3++) {
                    jSONArray2.put(enrolledFactors.get(i3).toJson());
                }
                jSONObject.put("userMultiFactorInfo", jSONArray2);
            }
            List<com.google.firebase.auth.zzal> listZzf = zzafVar.zzf();
            if (listZzf != null && !listZzf.isEmpty()) {
                JSONArray jSONArray3 = new JSONArray();
                for (int i4 = 0; i4 < listZzf.size(); i4++) {
                    jSONArray3.put(com.google.firebase.auth.zzal.zza(listZzf.get(i4)));
                }
                jSONObject.put("passkeyInfo", jSONArray3);
            }
            return jSONObject.toString();
        } catch (Exception e) {
            this.zzd.wtf("Failed to turn object into JSON", e, new Object[0]);
            throw new zzzp(e);
        }
    }

    public zzby(Context context, String str) {
        Preconditions.checkNotNull(context);
        this.zzb = Preconditions.checkNotEmpty(str);
        this.zza = context.getApplicationContext();
        this.zzc = this.zza.getSharedPreferences(String.format("com.google.firebase.auth.api.Store.%s", this.zzb), 0);
        this.zzd = new Logger("StorageHelpers", new String[0]);
    }

    public final void zza(String str) {
        this.zzc.edit().remove(str).apply();
    }

    public final void zzb(FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(firebaseUser);
        String strZzc = zzc(firebaseUser);
        if (TextUtils.isEmpty(strZzc)) {
            return;
        }
        this.zzc.edit().putString("com.google.firebase.auth.FIREBASE_USER", strZzc).apply();
    }

    public final void zza(FirebaseUser firebaseUser, zzagw zzagwVar) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzagwVar);
        this.zzc.edit().putString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", firebaseUser.getUid()), zzagwVar.zzf()).apply();
    }
}
