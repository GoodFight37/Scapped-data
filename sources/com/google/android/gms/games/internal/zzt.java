package com.google.android.gms.games.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.games_v2.zzfn;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzt extends com.google.android.gms.internal.games_v2.zzab {
    final /* synthetic */ zzah zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzt(zzah zzahVar) {
        super(zzahVar.getContext().getMainLooper(), 1000);
        Objects.requireNonNull(zzahVar);
        this.zza = zzahVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.games_v2.zzab
    protected final void zza(String str, int i) {
        try {
            zzah zzahVar = this.zza;
            if (zzahVar.isConnected()) {
                ((zzam) zzahVar.getService()).zzJ(str, i);
                return;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 30 + String.valueOf(i).length() + 48);
            sb.append("Unable to increment event ");
            sb.append(str);
            sb.append(" by ");
            sb.append(i);
            sb.append(" because the games client is no longer connected");
            zzfn.zzg("GamesGmsClientImpl", sb.toString());
        } catch (RemoteException e) {
            zzah.zzV(e);
        } catch (SecurityException e2) {
            int i2 = zzah.zze;
            zzfn.zzh("GamesGmsClientImpl", "Is player signed out?", e2);
        }
    }
}
