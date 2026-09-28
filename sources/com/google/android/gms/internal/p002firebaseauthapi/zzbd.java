package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbd implements zzca {
    private final InputStream zza;

    public static zzca zza(byte[] bArr) {
        return new zzbd(new ByteArrayInputStream(bArr));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzca
    public final zzuz zza() throws IOException {
        try {
            return zzuz.zza(this.zza, zzajv.zza());
        } finally {
            this.zza.close();
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzca
    public final zzwl zzb() throws IOException {
        try {
            return zzwl.zza(this.zza, zzajv.zza());
        } finally {
            this.zza.close();
        }
    }

    private zzbd(InputStream inputStream) {
        this.zza = inputStream;
    }
}
