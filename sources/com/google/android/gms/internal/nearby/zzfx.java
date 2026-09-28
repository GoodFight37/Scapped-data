package com.google.android.gms.internal.nearby;

import androidx.collection.ArraySet;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzfx extends zzju implements zzgk {
    private final ListenerHolder zza;
    private final Set zzb = new ArraySet();
    private final Set zzc = new ArraySet();

    zzfx(ListenerHolder listenerHolder) {
        this.zza = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    @Override // com.google.android.gms.internal.nearby.zzjv
    public final void zzb(zzkq zzkqVar) {
        this.zza.notifyListener(new zzfu(this, zzkqVar));
    }

    @Override // com.google.android.gms.internal.nearby.zzjv
    public final synchronized void zzc(zzks zzksVar) {
        this.zzb.add(zzksVar.zzb());
        this.zza.notifyListener(new zzfr(this, zzksVar));
    }

    @Override // com.google.android.gms.internal.nearby.zzjv
    public final synchronized void zzd(zzky zzkyVar) {
        this.zzb.remove(zzkyVar.zzb());
        Status statusZzG = zzgy.zzG(zzkyVar.zza());
        if (statusZzG.isSuccess()) {
            this.zzc.add(zzkyVar.zzb());
        }
        this.zza.notifyListener(new zzfs(this, zzkyVar, statusZzG));
    }

    @Override // com.google.android.gms.internal.nearby.zzjv
    public final synchronized void zze(zzla zzlaVar) {
        this.zzc.remove(zzlaVar.zza());
        this.zza.notifyListener(new zzft(this, zzlaVar));
    }

    @Override // com.google.android.gms.internal.nearby.zzgk
    public final synchronized void zzf() {
        Iterator it = this.zzb.iterator();
        while (it.hasNext()) {
            this.zza.notifyListener(new zzfv(this, (String) it.next()));
        }
        this.zzb.clear();
        Iterator it2 = this.zzc.iterator();
        while (it2.hasNext()) {
            this.zza.notifyListener(new zzfw(this, (String) it2.next()));
        }
        this.zzc.clear();
    }
}
