package com.google.android.gms.games.internal.v2.appshortcuts;

import android.content.Context;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.internal.games_v2.zzfq;
import com.google.android.gms.internal.games_v2.zzgz;
import com.google.android.gms.internal.games_v2.zzhd;
import com.google.android.gms.internal.games_v2.zzio;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
final class zze extends zzf {
    private final Context zza;

    public zze(Context context) {
        super(null);
        this.zza = context.getApplicationContext();
    }

    static /* synthetic */ zzg zzc(zzhd zzhdVar, zzhd zzhdVar2, Task task) {
        return task.isSuccessful() ? (zzg) task.getResult() : zze(zzhdVar, zzhdVar2);
    }

    private static zzg zze(zzhd zzhdVar, zzhd zzhdVar2) {
        return new zzg(zzf(zzhdVar), zzhd.zzi(), zzf(zzhdVar2), zzhd.zzi());
    }

    private static zzhd zzf(zzhd zzhdVar) {
        int i = zzhd.zzd;
        zzgz zzgzVar = new zzgz();
        int size = zzhdVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            String strZza = ((zzi) zzhdVar.get(i2)).zza();
            if (strZza != null) {
                zzgzVar.zzd(strZza);
            }
        }
        return zzgzVar.zze();
    }

    private static zzhd zzg(List list) {
        int i = zzhd.zzd;
        zzgz zzgzVar = new zzgz();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ShortcutInfo shortcutInfo = (ShortcutInfo) it.next();
            if (!shortcutInfo.isImmutable() && shortcutInfo.getId().startsWith("PLAY_GAMES_SERVICES_")) {
                zzgzVar.zzd(new zzi(shortcutInfo.getId(), shortcutInfo.getExtras(), Boolean.valueOf(shortcutInfo.isPinned()), Boolean.valueOf(shortcutInfo.isEnabled())));
            }
        }
        return zzgzVar.zze();
    }

    @Override // com.google.android.gms.games.internal.v2.appshortcuts.zzf
    public final void zza() {
        zzfq.zza();
        new Thread(new Runnable() { // from class: com.google.android.gms.games.internal.v2.appshortcuts.zzd
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzb();
            }
        }, "initialize-shortcuts").start();
    }

    final /* synthetic */ void zzb() {
        Task taskForResult;
        Context context = this.zza;
        final ShortcutManager shortcutManager = (ShortcutManager) context.getSystemService(ShortcutManager.class);
        if (shortcutManager == null) {
            return;
        }
        final zzr zzrVarZza = zzt.zza(context, PlayGamesAppShortcutsActivity.class);
        final zzhd zzhdVarZzg = zzg(shortcutManager.getDynamicShortcuts());
        final zzhd zzhdVarZzg2 = zzg(shortcutManager.getPinnedShortcuts());
        if (zzrVarZza == null || zzrVarZza.zza() <= 0) {
            taskForResult = Tasks.forResult(zze(zzhdVarZzg, zzhdVarZzg2));
        } else {
            final zzq zzqVar = new zzq(context);
            taskForResult = zzqVar.doRead(TaskApiCall.builder().setMethodKey(6744).setFeatures(com.google.android.gms.games.zzd.zzg).setAutoResolveMissingFeatures(false).run(new RemoteCall() { // from class: com.google.android.gms.games.internal.v2.appshortcuts.zzp
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.android.gms.common.api.internal.RemoteCall
                public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                    ((zzv) ((zzu) obj).getService()).zzd(new zzl(zzqVar, (TaskCompletionSource) obj2), zzrVarZza, zzhdVarZzg, zzhdVarZzg2);
                }
            }).build()).continueWith(zzio.zza(), new Continuation() { // from class: com.google.android.gms.games.internal.v2.appshortcuts.zzc
                @Override // com.google.android.gms.tasks.Continuation
                public final /* synthetic */ Object then(Task task) {
                    return zze.zzc(zzhdVarZzg, zzhdVarZzg2, task);
                }
            });
        }
        taskForResult.addOnSuccessListener(zzio.zza(), new OnSuccessListener() { // from class: com.google.android.gms.games.internal.v2.appshortcuts.zzb
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final /* synthetic */ void onSuccess(Object obj) {
                zzg zzgVar = (zzg) obj;
                List<String> listZza = zzgVar.zza();
                ShortcutManager shortcutManager2 = shortcutManager;
                if (listZza != null && !listZza.isEmpty()) {
                    shortcutManager2.removeDynamicShortcuts(listZza);
                }
                List<ShortcutInfo> listZzb = zzgVar.zzb();
                if (listZzb != null && !listZzb.isEmpty()) {
                    shortcutManager2.addDynamicShortcuts(listZzb);
                }
                List<String> listZzc = zzgVar.zzc();
                if (listZzc != null && !listZzc.isEmpty()) {
                    shortcutManager2.disableShortcuts(listZzc);
                }
                List<String> listZzd = zzgVar.zzd();
                if (listZzd == null || listZzd.isEmpty()) {
                    return;
                }
                shortcutManager2.enableShortcuts(listZzd);
            }
        });
    }
}
