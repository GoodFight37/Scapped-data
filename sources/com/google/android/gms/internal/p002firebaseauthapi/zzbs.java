package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbs {
    private final zzwl zza;
    private final List<zzbv> zzb;
    private final zznr zzc;

    private static zzbo zza(zzwl.zza zzaVar) throws GeneralSecurityException {
        zzpn zzpnVarZza = zzpn.zza(zzaVar.zzb().zzf(), zzaVar.zzb().zze(), zzaVar.zzb().zzb(), zzaVar.zzf(), zzaVar.zzf() == zzxd.RAW ? null : Integer.valueOf(zzaVar.zza()));
        zzom zzomVarZza = zzom.zza();
        zzcm zzcmVarZza = zzcm.zza();
        return !zzomVarZza.zzb(zzpnVarZza) ? new zznn(zzpnVarZza, zzcmVarZza) : zzomVarZza.zza(zzpnVarZza, zzcmVarZza);
    }

    private static zzbq zza(zzwc zzwcVar) throws GeneralSecurityException {
        int i = zzbr.zza[zzwcVar.ordinal()];
        if (i == 1) {
            return zzbq.zza;
        }
        if (i == 2) {
            return zzbq.zzb;
        }
        if (i == 3) {
            return zzbq.zzc;
        }
        throw new GeneralSecurityException("Unknown key status");
    }

    static final zzbs zza(zzwl zzwlVar) throws GeneralSecurityException {
        zzd(zzwlVar);
        return new zzbs(zzwlVar, zzc(zzwlVar));
    }

    public static final zzbs zza(zzbp zzbpVar) throws GeneralSecurityException {
        return new zzbu().zza(new zzbt(zzbpVar.zza()).zzb().zza()).zza();
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
            Method dump skipped, instruction units count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzbs.zza():com.google.android.gms.internal.firebase-auth-api.zzbs");
    }

    @Deprecated
    public static final zzbs zza(zzca zzcaVar, zzbe zzbeVar, byte[] bArr) throws GeneralSecurityException, IOException {
        zzuz zzuzVarZza = zzcaVar.zza();
        if (zzuzVarZza == null || zzuzVarZza.zzc().zzb() == 0) {
            throw new GeneralSecurityException("empty keyset");
        }
        return zza(zza(zzuzVarZza, zzbeVar, bArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzwl.zza zzb(zzbo zzboVar, zzbq zzbqVar, int i) throws GeneralSecurityException {
        zzwc zzwcVar;
        zzpn zzpnVar = (zzpn) zzom.zza().zza(zzboVar, zzpn.class, zzcm.zza());
        Integer numZze = zzpnVar.zze();
        if (numZze != null && numZze.intValue() != i) {
            throw new GeneralSecurityException("Wrong ID set for key with ID requirement");
        }
        if (zzbq.zza.equals(zzbqVar)) {
            zzwcVar = zzwc.ENABLED;
        } else if (zzbq.zzb.equals(zzbqVar)) {
            zzwcVar = zzwc.DISABLED;
        } else if (zzbq.zzc.equals(zzbqVar)) {
            zzwcVar = zzwc.DESTROYED;
        } else {
            throw new IllegalStateException("Unknown key status");
        }
        return (zzwl.zza) ((zzakg) zzwl.zza.zzd().zza(zzwb.zza().zza(zzpnVar.zzf()).zza(zzpnVar.zzd()).zza(zzpnVar.zza())).zza(zzwcVar).zza(i).zza(zzpnVar.zzc()).zze());
    }

    private static zzwl zza(zzuz zzuzVar, zzbe zzbeVar, byte[] bArr) throws GeneralSecurityException {
        try {
            zzwl zzwlVarZza = zzwl.zza(zzbeVar.zza(zzuzVar.zzc().zzd(), bArr), zzajv.zza());
            zzd(zzwlVarZza);
            return zzwlVarZza;
        } catch (zzakm unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    final zzwl zzb() {
        return this.zza;
    }

    public final <P> P zza(zzbf zzbfVar, Class<P> cls) throws GeneralSecurityException {
        if (!(zzbfVar instanceof zzmz)) {
            throw new GeneralSecurityException("Currently only subclasses of InternalConfiguration are accepted");
        }
        zzmz zzmzVar = (zzmz) zzbfVar;
        Class<?> clsZza = zzmzVar.zza((Class<?>) cls);
        if (clsZza == null) {
            throw new GeneralSecurityException("No wrapper found for " + cls.getName());
        }
        return (P) zza(zzmzVar, cls, clsZza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <B, P> P zza(zzmz zzmzVar, Class<P> cls, Class<B> cls2) throws GeneralSecurityException {
        zzcn.zzb(this.zza);
        zzpj zzpjVarZza = zzpg.zza(cls2);
        zzpjVarZza.zza(this.zzc);
        for (int i = 0; i < this.zzb.size(); i++) {
            zzwl.zza zzaVarZza = this.zza.zza(i);
            if (zzaVarZza.zzc().equals(zzwc.ENABLED)) {
                zzbv zzbvVar = this.zzb.get(i);
                if (zzbvVar == null) {
                    throw new GeneralSecurityException("Key parsing of key with index " + i + " and type_url " + zzaVarZza.zzb().zzf() + " failed, unable to get primitive");
                }
                zzbo zzboVarZzb = zzbvVar.zzb();
                try {
                    Object objZza = zzmzVar.zza(zzboVarZzb, cls2);
                    if (zzaVarZza.zza() == this.zza.zzb()) {
                        zzpjVarZza.zzb(objZza, zzboVarZzb, zzaVarZza);
                    } else {
                        zzpjVarZza.zza(objZza, zzboVarZzb, zzaVarZza);
                    }
                } catch (GeneralSecurityException e) {
                    throw new GeneralSecurityException("Unable to get primitive " + String.valueOf(cls2) + " for key of type " + zzaVarZza.zzb().zzf() + ", see https://developers.google.com/tink/faq/registration_errors", e);
                }
            }
        }
        return (P) zzmzVar.zza(zzpjVarZza.zza(), cls);
    }

    public final String toString() {
        return zzcn.zza(this.zza).toString();
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
    private static java.util.List<com.google.android.gms.internal.p002firebaseauthapi.zzbv> zzc(com.google.android.gms.internal.p002firebaseauthapi.zzwl r10) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r10.zza()
            r0.<init>(r1)
            java.util.List r1 = r10.zze()
            java.util.Iterator r1 = r1.iterator()
        L11:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L47
            java.lang.Object r2 = r1.next()
            com.google.android.gms.internal.firebase-auth-api.zzwl$zza r2 = (com.google.android.gms.internal.firebase-auth-api.zzwl.zza) r2
            int r6 = r2.zza()
            com.google.android.gms.internal.firebase-auth-api.zzbo r4 = zza(r2)     // Catch: java.security.GeneralSecurityException -> L42
            com.google.android.gms.internal.firebase-auth-api.zzbv r9 = new com.google.android.gms.internal.firebase-auth-api.zzbv     // Catch: java.security.GeneralSecurityException -> L42
            com.google.android.gms.internal.firebase-auth-api.zzwc r2 = r2.zzc()     // Catch: java.security.GeneralSecurityException -> L42
            com.google.android.gms.internal.firebase-auth-api.zzbq r5 = zza(r2)     // Catch: java.security.GeneralSecurityException -> L42
            int r2 = r10.zzb()     // Catch: java.security.GeneralSecurityException -> L42
            if (r6 != r2) goto L37
            r2 = 1
            goto L38
        L37:
            r2 = 0
        L38:
            r7 = r2
            r8 = 0
            r3 = r9
            r3.<init>(r4, r5, r6, r7)     // Catch: java.security.GeneralSecurityException -> L42
            r0.add(r9)     // Catch: java.security.GeneralSecurityException -> L42
            goto L11
        L42:
            r2 = 0
            r0.add(r2)
            goto L11
        L47:
            java.util.List r10 = java.util.Collections.unmodifiableList(r0)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzbs.zzc(com.google.android.gms.internal.firebase-auth-api.zzwl):java.util.List");
    }

    private zzbs(zzwl zzwlVar, List<zzbv> list) {
        this.zza = zzwlVar;
        this.zzb = list;
        this.zzc = zznr.zza;
    }

    private zzbs(zzwl zzwlVar, List<zzbv> list, zznr zznrVar) {
        this.zza = zzwlVar;
        this.zzb = list;
        this.zzc = zznrVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzd(zzwl zzwlVar) throws GeneralSecurityException {
        if (zzwlVar == null || zzwlVar.zza() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    @Deprecated
    public final void zza(zzbz zzbzVar) throws GeneralSecurityException, IOException {
        for (zzwl.zza zzaVar : this.zza.zze()) {
            if (zzaVar.zzb().zzb() == zzwb.zza.UNKNOWN_KEYMATERIAL || zzaVar.zzb().zzb() == zzwb.zza.SYMMETRIC || zzaVar.zzb().zzb() == zzwb.zza.ASYMMETRIC_PRIVATE) {
                throw new GeneralSecurityException(String.format("keyset contains key material of type %s for type url %s", zzaVar.zzb().zzb().name(), zzaVar.zzb().zzf()));
            }
        }
        zzbzVar.zza(this.zza);
    }

    @Deprecated
    public final void zza(zzbz zzbzVar, zzbe zzbeVar, byte[] bArr) throws GeneralSecurityException, IOException {
        zzwl zzwlVar = this.zza;
        zzbzVar.zza((zzuz) ((zzakg) zzuz.zza().zza(zzaiw.zza(zzbeVar.zzb(zzwlVar.zzk(), bArr))).zza(zzcn.zza(zzwlVar)).zze()));
    }
}
