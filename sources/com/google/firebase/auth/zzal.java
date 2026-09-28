package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzal> CREATOR = new zzan();
    private final String zza;
    private final String zzb;
    private final String zzc;

    public static com.google.android.gms.internal.p002firebaseauthapi.zzaj<zzal> zza(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return com.google.android.gms.internal.p002firebaseauthapi.zzaj.zza(new ArrayList());
        }
        com.google.android.gms.internal.p002firebaseauthapi.zzam zzamVarZzg = com.google.android.gms.internal.p002firebaseauthapi.zzaj.zzg();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            zzamVarZzg.zza(new zzal(jSONObject.getString("credentialId"), jSONObject.getString(AppMeasurementSdk.ConditionalUserProperty.NAME), jSONObject.getString("displayName")));
        }
        return zzamVarZzg.zza();
    }

    public static final zzal zza(JSONObject jSONObject) throws JSONException {
        return new zzal(jSONObject.getString("credentialId"), jSONObject.getString(AppMeasurementSdk.ConditionalUserProperty.NAME), jSONObject.getString("displayName"));
    }

    public static final JSONObject zza(zzal zzalVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("credentialId", zzalVar.zza);
        jSONObject.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzalVar.zzb);
        jSONObject.put("displayName", zzalVar.zzc);
        return jSONObject;
    }

    zzal(String str, String str2, String str3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
