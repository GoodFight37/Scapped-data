package com.google.android.gms.internal.p002firebaseauthapi;

import com.adjust.sdk.Constants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import java.io.UnsupportedEncodingException;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzagy {
    public static long zza(String str) {
        zzagx zzagxVarZzb = zzb(str);
        return zzagxVarZzb.zza().longValue() - zzagxVarZzb.zzb().longValue();
    }

    private static zzagx zzb(String str) {
        Preconditions.checkNotEmpty(str);
        List<String> listZza = zzv.zza('.').zza((CharSequence) str);
        if (listZza.size() < 2) {
            throw new RuntimeException("Invalid idToken " + str);
        }
        try {
            return zzagx.zza(new String(Base64Utils.decodeUrlSafeNoPadding(listZza.get(1)), Constants.ENCODING));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Unable to decode token", e);
        }
    }
}
