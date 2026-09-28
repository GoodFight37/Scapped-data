package com.google.android.gms.internal.games_v2;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzhn implements zzhu {
    private final Iterator zza;
    private boolean zzb;
    private Object zzc;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb || this.zza.hasNext();
    }

    @Override // com.google.android.gms.internal.games_v2.zzhu, java.util.Iterator
    public final Object next() {
        if (!this.zzb) {
            return this.zza.next();
        }
        Object obj = this.zzc;
        this.zzb = false;
        this.zzc = null;
        return obj;
    }

    @Override // com.google.android.gms.internal.games_v2.zzhu
    public final Object zza() {
        if (!this.zzb) {
            this.zzc = this.zza.next();
            this.zzb = true;
        }
        return this.zzc;
    }

    public zzhn(Iterator it) {
        it.getClass();
        this.zza = it;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!(!this.zzb)) {
            throw new IllegalStateException("Can't remove after you've peeked at next");
        }
        this.zza.remove();
    }
}
