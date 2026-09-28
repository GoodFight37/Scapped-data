package com.google.android.gms.internal.p002firebaseauthapi;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.zzal;
import com.google.firebase.auth.zzc;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzagl {
    private String zza;
    private String zzb;
    private boolean zzc;
    private String zzd;
    private String zze;
    private zzahb zzf;
    private String zzg;
    private long zzh;
    private long zzi;
    private boolean zzj;
    private zzc zzk;
    private List<zzagz> zzl;
    private zzaj<zzal> zzm;

    public final long zza() {
        return this.zzh;
    }

    public final long zzb() {
        return this.zzi;
    }

    public final Uri zzc() {
        if (TextUtils.isEmpty(this.zze)) {
            return null;
        }
        return Uri.parse(this.zze);
    }

    public final zzaj<zzal> zzd() {
        return this.zzm;
    }

    public final zzc zze() {
        return this.zzk;
    }

    public final zzagl zza(zzc zzcVar) {
        this.zzk = zzcVar;
        return this;
    }

    public final zzagl zza(String str) {
        this.zzd = str;
        return this;
    }

    public final zzagl zzb(String str) {
        this.zzb = str;
        return this;
    }

    public final zzagl zza(boolean z) {
        this.zzj = z;
        return this;
    }

    public final zzagl zza(zzaj<zzal> zzajVar) {
        Preconditions.checkNotNull(zzajVar);
        this.zzm = zzajVar;
        return this;
    }

    public final zzagl zzc(String str) {
        this.zze = str;
        return this;
    }

    public final zzagl zza(List<zzahc> list) {
        Preconditions.checkNotNull(list);
        zzahb zzahbVar = new zzahb();
        this.zzf = zzahbVar;
        zzahbVar.zza().addAll(list);
        return this;
    }

    public final zzahb zzf() {
        return this.zzf;
    }

    public final String zzg() {
        return this.zzd;
    }

    public final String zzh() {
        return this.zzb;
    }

    public final String zzi() {
        return this.zza;
    }

    public final String zzj() {
        return this.zzg;
    }

    public final List<zzagz> zzk() {
        return this.zzl;
    }

    public final List<zzahc> zzl() {
        return this.zzf.zza();
    }

    public zzagl() {
        this.zzf = new zzahb();
        this.zzm = zzaj.zzh();
    }

    public zzagl(String str, String str2, boolean z, String str3, String str4, zzahb zzahbVar, String str5, String str6, long j, long j2, boolean z2, zzc zzcVar, List<zzagz> list, zzaj<zzal> zzajVar) {
        zzahb zzahbVar2;
        this.zza = str;
        this.zzb = str2;
        this.zzc = z;
        this.zzd = str3;
        this.zze = str4;
        if (zzahbVar == null) {
            zzahbVar2 = new zzahb();
        } else {
            List<zzahc> listZza = zzahbVar.zza();
            zzahb zzahbVar3 = new zzahb();
            if (listZza != null) {
                zzahbVar3.zza().addAll(listZza);
            }
            zzahbVar2 = zzahbVar3;
        }
        this.zzf = zzahbVar2;
        this.zzg = str6;
        this.zzh = j;
        this.zzi = j2;
        this.zzj = false;
        this.zzk = null;
        this.zzl = list == null ? new ArrayList<>() : list;
        this.zzm = zzajVar;
    }

    public final boolean zzm() {
        return this.zzc;
    }

    public final boolean zzn() {
        return this.zzj;
    }
}
