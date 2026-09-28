package com.nintendo.npf.sdk.core;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k {
    public static final i a(i iVar, i.b mode) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(mode, "mode");
        return iVar.a((2045 & 1) != 0 ? iVar.f475a : mode, (2045 & 2) != 0 ? iVar.b : 0L, (2045 & 4) != 0 ? iVar.c : null, (2045 & 8) != 0 ? iVar.d : false, (2045 & 16) != 0 ? iVar.e : 0, (2045 & 32) != 0 ? iVar.f : null, (2045 & 64) != 0 ? iVar.g : null, (2045 & 128) != 0 ? iVar.h : null, (2045 & 256) != 0 ? iVar.i : null, (2045 & 512) != 0 ? iVar.j : null, (2045 & 1024) != 0 ? iVar.k : null);
    }

    public static final i a(i iVar, long j) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        return iVar.a((2045 & 1) != 0 ? iVar.f475a : null, (2045 & 2) != 0 ? iVar.b : j, (2045 & 4) != 0 ? iVar.c : null, (2045 & 8) != 0 ? iVar.d : false, (2045 & 16) != 0 ? iVar.e : 0, (2045 & 32) != 0 ? iVar.f : null, (2045 & 64) != 0 ? iVar.g : null, (2045 & 128) != 0 ? iVar.h : null, (2045 & 256) != 0 ? iVar.i : null, (2045 & 512) != 0 ? iVar.j : null, (2045 & 1024) != 0 ? iVar.k : null);
    }

    public static final boolean a(i iVar) {
        String strJ;
        String strC;
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        if (iVar.g() == i.b.NONE || iVar.f() < System.currentTimeMillis()) {
            return false;
        }
        if (iVar.g() != i.b.V2) {
            return true;
        }
        String strA = iVar.a();
        return (strA == null || strA.length() == 0 || (strJ = iVar.j()) == null || strJ.length() == 0 || (strC = iVar.c()) == null || strC.length() == 0) ? false : true;
    }
}
