package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbu {
    private final List<zzbt> zza = new ArrayList();
    private zznr zzb = zznr.zza;
    private boolean zzc = false;

    public final zzbu zza(zzbt zzbtVar) {
        if (zzbtVar.zze != null) {
            throw new IllegalStateException("Entry has already been added to a KeysetHandle.Builder");
        }
        if (zzbtVar.zza) {
            zzb();
        }
        zzbtVar.zze = this;
        this.zza.add(zzbtVar);
        return this;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.android.gms.internal.firebase-auth-api.zzbv.<init>(com.google.android.gms.internal.firebase-auth-api.zzbo, com.google.android.gms.internal.firebase-auth-api.zzbq, int, boolean, com.google.android.gms.internal.firebase-auth-api.zzby):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:224)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:93)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    public final com.google.android.gms.internal.p002firebaseauthapi.zzbs zza() throws java.security.GeneralSecurityException {
        /*
            Method dump skipped, instruction units count: 362
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzbu.zza():com.google.android.gms.internal.firebase-auth-api.zzbs");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb() {
        Iterator<zzbt> it = this.zza.iterator();
        while (it.hasNext()) {
            it.next().zza = false;
        }
    }
}
