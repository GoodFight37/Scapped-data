package com.nintendo.npf.sdk.core;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import java.io.IOException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class t1 implements u1 {
    public static final a c = new a(null);
    private static final String d = "s1";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s1 f568a;
    private final DeviceDataFacade b;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f569a;
        /* synthetic */ Object b;
        int d;

        b(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return t1.this.a(this);
        }
    }

    public t1(s1 googleAdvertisingIdAPI, DeviceDataFacade deviceDataFacade) {
        Intrinsics.checkNotNullParameter(googleAdvertisingIdAPI, "googleAdvertisingIdAPI");
        Intrinsics.checkNotNullParameter(deviceDataFacade, "deviceDataFacade");
        this.f568a = googleAdvertisingIdAPI;
        this.b = deviceDataFacade;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17, types: [com.nintendo.npf.sdk.core.t1] */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.nintendo.npf.sdk.core.t1$b, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.nintendo.npf.sdk.core.t1] */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.nintendo.npf.sdk.core.u1
    public Object a(Continuation continuation) throws Throwable {
        t1 bVar;
        t1 t1Var;
        if (continuation instanceof b) {
            b bVar2 = (b) continuation;
            int i = bVar2.d;
            if ((i & Integer.MIN_VALUE) != 0) {
                bVar2.d = i - Integer.MIN_VALUE;
                bVar = bVar2;
            } else {
                bVar = new b(continuation);
            }
        } else {
            bVar = new b(continuation);
        }
        Object objA = bVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = bVar.d;
        String str = null;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objA);
                if (this.b.isDisabledUsingGoogleAdvertisingId()) {
                    return Unit.INSTANCE;
                }
                try {
                    s1 s1Var = this.f568a;
                    bVar.f569a = this;
                    bVar.d = 1;
                    objA = s1Var.a((Continuation) bVar);
                    if (objA == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    bVar = this;
                } catch (GooglePlayServicesNotAvailableException e) {
                    e = e;
                    bVar = this;
                    SDKLog.e(d, "Failed Google Play Service is not available ", e);
                    t1Var = bVar;
                    t1Var.b.setAdvertisingId(str);
                    return Unit.INSTANCE;
                } catch (GooglePlayServicesRepairableException e2) {
                    e = e2;
                    bVar = this;
                    SDKLog.e(d, "Failed Google Play Service library load ", e);
                    t1Var = bVar;
                    t1Var.b.setAdvertisingId(str);
                    return Unit.INSTANCE;
                } catch (IOException e3) {
                    e = e3;
                    bVar = this;
                    SDKLog.e(d, "Failed getting advertisingId", e);
                    t1Var = bVar;
                    t1Var.b.setAdvertisingId(str);
                    return Unit.INSTANCE;
                } catch (Throwable th) {
                    th = th;
                    bVar = this;
                    bVar.b.setAdvertisingId(str);
                    throw th;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                bVar = (t1) bVar.f569a;
                try {
                    ResultKt.throwOnFailure(objA);
                    bVar = bVar;
                } catch (GooglePlayServicesNotAvailableException e4) {
                    e = e4;
                    SDKLog.e(d, "Failed Google Play Service is not available ", e);
                    t1Var = bVar;
                    t1Var.b.setAdvertisingId(str);
                    return Unit.INSTANCE;
                } catch (GooglePlayServicesRepairableException e5) {
                    e = e5;
                    SDKLog.e(d, "Failed Google Play Service library load ", e);
                    t1Var = bVar;
                    t1Var.b.setAdvertisingId(str);
                    return Unit.INSTANCE;
                } catch (IOException e6) {
                    e = e6;
                    SDKLog.e(d, "Failed getting advertisingId", e);
                    t1Var = bVar;
                    t1Var.b.setAdvertisingId(str);
                    return Unit.INSTANCE;
                }
            }
            String str2 = (String) objA;
            if (str2 == null) {
                try {
                    SDKLog.e(d, "Failed getting advertisingId: probably, google play service disable.");
                } catch (GooglePlayServicesNotAvailableException e7) {
                    str = str2;
                    e = e7;
                    SDKLog.e(d, "Failed Google Play Service is not available ", e);
                    t1Var = bVar;
                    t1Var.b.setAdvertisingId(str);
                } catch (GooglePlayServicesRepairableException e8) {
                    str = str2;
                    e = e8;
                    SDKLog.e(d, "Failed Google Play Service library load ", e);
                    t1Var = bVar;
                    t1Var.b.setAdvertisingId(str);
                } catch (IOException e9) {
                    str = str2;
                    e = e9;
                    SDKLog.e(d, "Failed getting advertisingId", e);
                    t1Var = bVar;
                    t1Var.b.setAdvertisingId(str);
                } catch (Throwable th2) {
                    str = str2;
                    th = th2;
                    bVar.b.setAdvertisingId(str);
                    throw th;
                }
            }
            bVar.b.setAdvertisingId(str2);
            return Unit.INSTANCE;
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
