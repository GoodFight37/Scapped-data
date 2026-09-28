package com.nintendo.npf.sdk.core;

/* JADX INFO: loaded from: classes2.dex */
public abstract class r3 {

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final x4 f555a = x4.a.a();
    }

    public static com.nintendo.npf.sdk.core.a a() {
        x4 x4Var = a.f555a;
        y1 hostInformationDataFacade = x4Var.getHostInformationDataFacade();
        return new b(x4Var.getAccountApiClient(), hostInformationDataFacade.g(), hostInformationDataFacade.h());
    }

    public static c b() {
        x4 x4Var = a.f555a;
        return new d(x4Var.getAccountClient(), x4Var.getHostInformationDataFacade().g());
    }
}
