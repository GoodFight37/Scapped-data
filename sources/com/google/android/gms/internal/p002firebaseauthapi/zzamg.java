package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [FieldDescriptorT] */
/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzamg<FieldDescriptorT> extends zzamh<FieldDescriptorT, Object> {
    zzamg() {
        super();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamh
    public final void zza() {
        if (!zze()) {
            for (int i = 0; i < zzb(); i++) {
                Map.Entry<FieldDescriptorT, Object> entryZza = zza(i);
                if (((zzaka) entryZza.getKey()).zze()) {
                    entryZza.setValue(Collections.unmodifiableList((List) entryZza.getValue()));
                }
            }
            for (Map.Entry<FieldDescriptorT, Object> entry : zzc()) {
                if (((zzaka) entry.getKey()).zze()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zza();
    }
}
