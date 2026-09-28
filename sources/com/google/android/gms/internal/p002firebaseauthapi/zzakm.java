package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public class zzakm extends IOException {
    private boolean zza;

    static zzakp zza() {
        return new zzakp("Protocol message tag had invalid wire type.");
    }

    static zzakm zzb() {
        return new zzakm("Protocol message end-group tag did not match expected tag.");
    }

    static zzakm zzc() {
        return new zzakm("Protocol message contained an invalid tag (zero).");
    }

    static zzakm zzd() {
        return new zzakm("Protocol message had invalid UTF-8.");
    }

    static zzakm zze() {
        return new zzakm("CodedInputStream encountered a malformed varint.");
    }

    static zzakm zzf() {
        return new zzakm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzakm zzg() {
        return new zzakm("Failed to parse the message.");
    }

    static zzakm zzh() {
        return new zzakm("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
    }

    static zzakm zzi() {
        return new zzakm("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    static zzakm zzj() {
        return new zzakm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public zzakm(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    public zzakm(String str) {
        super(str);
    }

    final void zzk() {
        this.zza = true;
    }

    final boolean zzl() {
        return this.zza;
    }
}
