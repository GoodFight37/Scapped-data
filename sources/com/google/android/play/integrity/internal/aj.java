package com.google.android.play.integrity.internal;

/* JADX INFO: compiled from: com.google.android.play:integrity@@1.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class aj implements an {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f376a = new Object();
    private volatile an b;
    private volatile Object c = f376a;

    private aj(an anVar) {
        this.b = anVar;
    }

    public static an b(an anVar) {
        return anVar instanceof aj ? anVar : new aj(anVar);
    }

    @Override // com.google.android.play.integrity.internal.an
    public final Object a() {
        Object objA = this.c;
        Object obj = f376a;
        if (objA == obj) {
            synchronized (this) {
                objA = this.c;
                if (objA == obj) {
                    objA = this.b.a();
                    Object obj2 = this.c;
                    if (obj2 != obj && obj2 != objA) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj2 + " & " + objA + ". This is likely due to a circular dependency.");
                    }
                    this.c = objA;
                    this.b = null;
                }
            }
        }
        return objA;
    }
}
