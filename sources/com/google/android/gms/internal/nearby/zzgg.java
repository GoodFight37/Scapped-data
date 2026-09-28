package com.google.android.gms.internal.nearby;

import androidx.collection.ArraySet;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzgg extends zzkb {
    private final ListenerHolder zza;
    private final Set zzb = new ArraySet();

    zzgg(ListenerHolder listenerHolder) {
        this.zza = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzg(zzle zzleVar) {
        if (zzleVar.zza() != null) {
            return zzleVar.zzb() == null || "__UNRECOGNIZED_BLUETOOTH_DEVICE__".equals(zzleVar.zzb());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.nearby.zzkc
    public final synchronized void zzb(zzlc zzlcVar) {
        this.zza.notifyListener(new zzgc(this, zzlcVar));
    }

    @Override // com.google.android.gms.internal.nearby.zzkc
    public final synchronized void zzc(zzle zzleVar) {
        if (!zzg(zzleVar)) {
            this.zzb.add(zzleVar.zzb());
        }
        this.zza.notifyListener(new zzgd(this, zzleVar));
    }

    @Override // com.google.android.gms.internal.nearby.zzkc
    public final synchronized void zzd(zzlg zzlgVar) {
        this.zzb.remove(zzlgVar.zza());
        this.zza.notifyListener(new zzge(this, zzlgVar));
    }

    final synchronized void zze() {
        Iterator it = this.zzb.iterator();
        while (it.hasNext()) {
            this.zza.notifyListener(new zzgf(this, (String) it.next()));
        }
        this.zzb.clear();
    }
}
