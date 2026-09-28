package com.google.android.gms.internal.nearby;

import java.io.IOException;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzta implements Appendable {
    final /* synthetic */ Appendable zzb;
    final /* synthetic */ String zzc = ":";
    int zza = 2;

    zzta(int i, Appendable appendable, String str) {
        this.zzb = appendable;
    }

    @Override // java.lang.Appendable
    public final Appendable append(char c) throws IOException {
        if (this.zza == 0) {
            this.zzb.append(this.zzc);
            this.zza = 2;
        }
        this.zzb.append(c);
        this.zza--;
        return this;
    }

    @Override // java.lang.Appendable
    public final Appendable append(@CheckForNull CharSequence charSequence) {
        throw new UnsupportedOperationException();
    }

    @Override // java.lang.Appendable
    public final Appendable append(@CheckForNull CharSequence charSequence, int i, int i2) {
        throw new UnsupportedOperationException();
    }
}
