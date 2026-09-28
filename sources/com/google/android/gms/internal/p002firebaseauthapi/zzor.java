package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzor {
    public static final zzzn zza = zzzn.zza(new byte[0]);

    public static final zzzn zza(int i) {
        return zzzn.zza(ByteBuffer.allocate(5).put((byte) 0).putInt(i).array());
    }

    public static final zzzn zzb(int i) {
        return zzzn.zza(ByteBuffer.allocate(5).put((byte) 1).putInt(i).array());
    }
}
