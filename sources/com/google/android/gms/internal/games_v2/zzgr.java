package com.google.android.gms.internal.games_v2;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzgr extends zzgu {
    private static final zzgr zzb = new zzgr();

    private zzgr() {
        super("");
    }

    @Override // com.google.android.gms.internal.games_v2.zzgu, java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return zzc((zzgu) obj);
    }

    @Override // com.google.android.gms.internal.games_v2.zzgu
    public final int hashCode() {
        return System.identityHashCode(this);
    }

    public final String toString() {
        return "+∞";
    }

    @Override // com.google.android.gms.internal.games_v2.zzgu
    final void zza(StringBuilder sb) {
        throw new AssertionError();
    }

    @Override // com.google.android.gms.internal.games_v2.zzgu
    final void zzb(StringBuilder sb) {
        sb.append("+∞)");
    }

    @Override // com.google.android.gms.internal.games_v2.zzgu
    public final int zzc(zzgu zzguVar) {
        return zzguVar == this ? 0 : 1;
    }
}
