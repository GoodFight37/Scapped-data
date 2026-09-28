package com.nintendo.npf.sdk.internal.impl;

import android.app.Activity;
import android.app.Application;
import com.nintendo.npf.sdk.NPFSDK;
import com.nintendo.npf.sdk.analytics.AnalyticsService;
import com.nintendo.npf.sdk.audit.AuditService;
import com.nintendo.npf.sdk.core.a1;
import com.nintendo.npf.sdk.core.a2;
import com.nintendo.npf.sdk.core.a4;
import com.nintendo.npf.sdk.core.b1;
import com.nintendo.npf.sdk.core.b4;
import com.nintendo.npf.sdk.core.b5;
import com.nintendo.npf.sdk.core.c3;
import com.nintendo.npf.sdk.core.d1;
import com.nintendo.npf.sdk.core.d3;
import com.nintendo.npf.sdk.core.e1;
import com.nintendo.npf.sdk.core.e4;
import com.nintendo.npf.sdk.core.e5;
import com.nintendo.npf.sdk.core.f5;
import com.nintendo.npf.sdk.core.g0;
import com.nintendo.npf.sdk.core.g5;
import com.nintendo.npf.sdk.core.h1;
import com.nintendo.npf.sdk.core.h4;
import com.nintendo.npf.sdk.core.h5;
import com.nintendo.npf.sdk.core.i3;
import com.nintendo.npf.sdk.core.i4;
import com.nintendo.npf.sdk.core.j0;
import com.nintendo.npf.sdk.core.j2;
import com.nintendo.npf.sdk.core.k0;
import com.nintendo.npf.sdk.core.k1;
import com.nintendo.npf.sdk.core.l1;
import com.nintendo.npf.sdk.core.l2;
import com.nintendo.npf.sdk.core.l4;
import com.nintendo.npf.sdk.core.m0;
import com.nintendo.npf.sdk.core.m2;
import com.nintendo.npf.sdk.core.m4;
import com.nintendo.npf.sdk.core.n1;
import com.nintendo.npf.sdk.core.n3;
import com.nintendo.npf.sdk.core.o2;
import com.nintendo.npf.sdk.core.o3;
import com.nintendo.npf.sdk.core.o4;
import com.nintendo.npf.sdk.core.p2;
import com.nintendo.npf.sdk.core.p3;
import com.nintendo.npf.sdk.core.p4;
import com.nintendo.npf.sdk.core.q0;
import com.nintendo.npf.sdk.core.r3;
import com.nintendo.npf.sdk.core.s0;
import com.nintendo.npf.sdk.core.s1;
import com.nintendo.npf.sdk.core.s3;
import com.nintendo.npf.sdk.core.t1;
import com.nintendo.npf.sdk.core.t3;
import com.nintendo.npf.sdk.core.u0;
import com.nintendo.npf.sdk.core.u1;
import com.nintendo.npf.sdk.core.u3;
import com.nintendo.npf.sdk.core.v0;
import com.nintendo.npf.sdk.core.v4;
import com.nintendo.npf.sdk.core.w2;
import com.nintendo.npf.sdk.core.w3;
import com.nintendo.npf.sdk.core.x1;
import com.nintendo.npf.sdk.core.x2;
import com.nintendo.npf.sdk.core.x3;
import com.nintendo.npf.sdk.core.x4;
import com.nintendo.npf.sdk.core.y1;
import com.nintendo.npf.sdk.core.y2;
import com.nintendo.npf.sdk.core.y4;
import com.nintendo.npf.sdk.core.z1;
import com.nintendo.npf.sdk.core.z2;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade;
import com.nintendo.npf.sdk.domain.repository.BaasAccountRepository;
import com.nintendo.npf.sdk.domain.repository.NintendoAccountRepository;
import com.nintendo.npf.sdk.domain.repository.PromoCodeBundleRepository;
import com.nintendo.npf.sdk.domain.repository.SubscriptionOwnershipRepository;
import com.nintendo.npf.sdk.domain.repository.SubscriptionProductRepository;
import com.nintendo.npf.sdk.domain.repository.SubscriptionPurchaseRepository;
import com.nintendo.npf.sdk.domain.repository.SubscriptionReplacementRepository;
import com.nintendo.npf.sdk.domain.repository.SubscriptionTransactionRepository;
import com.nintendo.npf.sdk.domain.repository.VirtualCurrencyBundleRepository;
import com.nintendo.npf.sdk.domain.repository.VirtualCurrencyPurchaseAbilityRepository;
import com.nintendo.npf.sdk.domain.repository.VirtualCurrencyPurchaseRepository;
import com.nintendo.npf.sdk.domain.repository.VirtualCurrencyPurchaseSummaryRepository;
import com.nintendo.npf.sdk.domain.repository.VirtualCurrencyTransactionRepository;
import com.nintendo.npf.sdk.domain.repository.VirtualCurrencyWalletRepository;
import com.nintendo.npf.sdk.domain.service.AnalyticsDefaultService;
import com.nintendo.npf.sdk.infrastructure.helper.ReportHelper;
import com.nintendo.npf.sdk.inquiry.InquiryService;
import com.nintendo.npf.sdk.internal.client.core.HttpClient;
import com.nintendo.npf.sdk.internal.model.Capabilities;
import com.nintendo.npf.sdk.internal.util.Lazy;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import com.nintendo.npf.sdk.notification.PushNotificationChannelService;
import com.nintendo.npf.sdk.promo.PromoCodeService;
import com.nintendo.npf.sdk.subscription.SubscriptionController;
import com.nintendo.npf.sdk.subscription.SubscriptionService;
import com.nintendo.npf.sdk.user.BaasAccountService;
import com.nintendo.npf.sdk.user.LinkedAccountService;
import com.nintendo.npf.sdk.user.NintendoAccountService;
import com.nintendo.npf.sdk.user.OtherUserService;
import com.nintendo.npf.sdk.user.TransferAccountService;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyService;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public class ServiceLocatorNoBilling implements x4 {
    private final Lazy A;
    private final Lazy B;
    private final Lazy C;
    private final Lazy D;
    private final Lazy E;
    private final Lazy F;
    private final Lazy G;
    private final Lazy H;
    private final Lazy I;
    private final Lazy J;
    private final Lazy K;
    private Activity L;
    private final e4 M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Application f779a;
    private final Function0 b;
    private final Lazy c;
    private final Lazy d;
    private final Lazy e;
    private final Lazy f;
    private final Lazy g;
    private final Lazy h;
    private final Lazy i;
    private final Lazy j;
    private final Lazy k;
    private final Lazy l;
    private final Lazy m;
    private final Lazy n;
    private final Lazy o;
    private final Lazy p;
    private final com.nintendo.npf.sdk.core.n q;
    private final Lazy r;
    private final Lazy s;
    private final Lazy t;
    private final Lazy u;
    private final Lazy v;
    private final Lazy w;
    private final Lazy x;
    private final n1 y;
    private final l1 z;

    class a extends Lazy {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public y2 initializeField2() {
            return new w2(ServiceLocatorNoBilling.this.c(), ServiceLocatorNoBilling.this.g());
        }
    }

    class a0 extends Lazy {
        a0() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public a1 initializeField2() {
            return new b1(ServiceLocatorNoBilling.this.q());
        }
    }

    class b extends Lazy {
        final /* synthetic */ com.nintendo.npf.sdk.internal.impl.a c;
        final /* synthetic */ p4 d;

        b(com.nintendo.npf.sdk.internal.impl.a aVar, p4 p4Var) {
            this.c = aVar;
            this.d = p4Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Capabilities a() {
            return ServiceLocatorNoBilling.this.getCapabilities();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public com.nintendo.npf.sdk.core.w initializeField2() {
            return new com.nintendo.npf.sdk.core.o(new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling$b$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.a();
                }
            }, this.c, ServiceLocatorNoBilling.this.o(), this.d, ServiceLocatorNoBilling.this.g());
        }
    }

    class b0 extends Lazy {
        b0() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public d1 initializeField2() {
            return new e1(ServiceLocatorNoBilling.this.h());
        }
    }

    class c extends Lazy {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ NintendoAccountService a() {
            return ServiceLocatorNoBilling.this.getNintendoAccountService();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ BaasAccountService b() {
            return ServiceLocatorNoBilling.this.getBaasAccountService();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public i3 initializeField2() {
            return new i3(ServiceLocatorNoBilling.this.getNintendoAccountRepository(), (u1) ServiceLocatorNoBilling.this.l.get(), new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling$c$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.a();
                }
            }, new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling$c$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.b();
                }
            }, ServiceLocatorNoBilling.this.getProcessLifecycleObserver(), ServiceLocatorNoBilling.this.getLoginHandler());
        }
    }

    class c0 extends Lazy {
        c0() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public DeviceDataFacade initializeField2() {
            return new k1(ServiceLocatorNoBilling.this.h(), ServiceLocatorNoBilling.this.q(), ServiceLocatorNoBilling.this.f(), new h1(Locale.getDefault()), ServiceLocatorNoBilling.this.getCredentialsDataFacade());
        }
    }

    class d extends Lazy {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ NintendoAccountService a() {
            return ServiceLocatorNoBilling.this.getNintendoAccountService();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ BaasAccountService b() {
            return ServiceLocatorNoBilling.this.getBaasAccountService();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public j0 initializeField2() {
            return new j0(ServiceLocatorNoBilling.this.g(), new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling$d$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.a();
                }
            }, new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling$d$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.b();
                }
            });
        }
    }

    class d0 extends Lazy {
        d0() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public y1 initializeField2() {
            return new z1(ServiceLocatorNoBilling.this.h());
        }
    }

    class e extends Lazy {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ NintendoAccountRepository a() {
            return ServiceLocatorNoBilling.this.getNintendoAccountRepository();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public c3 initializeField2() {
            return new c3(new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling$e$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.a();
                }
            }, ServiceLocatorNoBilling.this.a(), ServiceLocatorNoBilling.this.g());
        }
    }

    class e0 extends Lazy {
        e0() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ s3 a() {
            return ServiceLocatorNoBilling.this.m();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public NintendoAccountRepository initializeField2() {
            return new t3(new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling$e0$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.a();
                }
            }, ServiceLocatorNoBilling.this.a(), ServiceLocatorNoBilling.this.getCredentialsDataFacade(), ServiceLocatorNoBilling.this.g());
        }
    }

    class f extends Lazy {
        f() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public Capabilities initializeField2() {
            return new Capabilities(ServiceLocatorNoBilling.this.getConfigurationDataFacade(), ServiceLocatorNoBilling.this.e(), ServiceLocatorNoBilling.this.getDeviceDataFacade(), ServiceLocatorNoBilling.this.getHostInformationDataFacade(), new s0(ServiceLocatorNoBilling.this.f779a));
        }
    }

    class f0 extends Lazy {
        f0() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public com.nintendo.npf.sdk.core.e0 initializeField2() {
            return new com.nintendo.npf.sdk.core.e0(ServiceLocatorNoBilling.this.getCredentialsDataFacade(), ServiceLocatorNoBilling.this.c(), ServiceLocatorNoBilling.this.g());
        }
    }

    class g extends Lazy {
        g() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public d3 initializeField2() {
            return new d3(ServiceLocatorNoBilling.this.g());
        }
    }

    class h extends Lazy {
        h() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public m4 initializeField2() {
            return new m4(ServiceLocatorNoBilling.this.g(), ServiceLocatorNoBilling.this.getDeviceDataFacade());
        }
    }

    class i extends Lazy {
        i() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public v4 initializeField2() {
            return new v4();
        }
    }

    class j extends Lazy {
        j() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public com.nintendo.npf.sdk.core.c0 initializeField2() {
            Capabilities capabilities = ServiceLocatorNoBilling.this.getCapabilities();
            final ServiceLocatorNoBilling serviceLocatorNoBilling = ServiceLocatorNoBilling.this;
            return new com.nintendo.npf.sdk.core.c0(capabilities, new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling$j$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return serviceLocatorNoBilling.getEventHandler();
                }
            }, ServiceLocatorNoBilling.this.getBaasAccountRepository(), ServiceLocatorNoBilling.this.getNintendoAccountRepository(), ServiceLocatorNoBilling.this.getDeviceDataFacade(), ServiceLocatorNoBilling.this.getCredentialsDataFacade());
        }
    }

    class k extends Lazy {
        final /* synthetic */ com.nintendo.npf.sdk.internal.impl.a c;
        final /* synthetic */ p4 d;

        k(com.nintendo.npf.sdk.internal.impl.a aVar, p4 p4Var) {
            this.c = aVar;
            this.d = p4Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ o4 a() {
            return ServiceLocatorNoBilling.this.o();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ ReportHelper b() {
            return ServiceLocatorNoBilling.this.getReportHelper();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ o4 c() {
            return ServiceLocatorNoBilling.this.o();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public o4 initializeField2() {
            o4 o4Var = new o4(ServiceLocatorNoBilling.this.getBaasAccountRepository(), ServiceLocatorNoBilling.this.q, this.c, this.d, new com.nintendo.npf.sdk.core.h(ServiceLocatorNoBilling.this.d(), new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling$k$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.a();
                }
            }).b(), new com.nintendo.npf.sdk.core.v(ServiceLocatorNoBilling.this.q, new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling$k$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.b();
                }
            }, new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling$k$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.c();
                }
            }, ServiceLocatorNoBilling.this.n()).b());
            this.d.c(new com.nintendo.npf.sdk.core.i());
            return o4Var;
        }
    }

    class l extends Lazy {
        l() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Application a() {
            return ServiceLocatorNoBilling.this.f779a;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public u1 initializeField2() {
            return new t1(new s1(new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling$l$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.a();
                }
            }), ServiceLocatorNoBilling.this.getDeviceDataFacade());
        }
    }

    class m extends Lazy {
        m() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public o2 initializeField2() {
            return new l2(ServiceLocatorNoBilling.this.i());
        }
    }

    class n extends Lazy {
        n() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public h4 initializeField2() {
            return i4.a(ServiceLocatorNoBilling.this.getDeviceDataFacade().getSdkVersion());
        }
    }

    class o extends Lazy {
        o() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ String a() {
            return ServiceLocatorNoBilling.this.getHostInformationDataFacade().f();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public HttpClient initializeField2() {
            return a2.a(new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling$o$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.a();
                }
            }, ServiceLocatorNoBilling.this.p(), ServiceLocatorNoBilling.this);
        }
    }

    class p extends Lazy {
        p() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ String a() {
            return ServiceLocatorNoBilling.this.getHostInformationDataFacade().e();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public HttpClient initializeField2() {
            return a2.a(new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling$p$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.a();
                }
            }, ServiceLocatorNoBilling.this.p(), ServiceLocatorNoBilling.this);
        }
    }

    class q extends Lazy {
        q() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ String a() {
            return ServiceLocatorNoBilling.this.getHostInformationDataFacade().d();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public HttpClient initializeField2() {
            return a2.a(new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling$q$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.a();
                }
            }, ServiceLocatorNoBilling.this.p(), ServiceLocatorNoBilling.this);
        }
    }

    class r extends Lazy {
        r() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public com.nintendo.npf.sdk.internal.client.core.f initializeField2() {
            return new com.nintendo.npf.sdk.internal.client.core.a(ServiceLocatorNoBilling.this.getBaasAccountRepository(), ServiceLocatorNoBilling.this.getNintendoAccountRepository(), ServiceLocatorNoBilling.this.getHostInformationDataFacade(), ServiceLocatorNoBilling.this.getBaasAuth());
        }
    }

    class s extends Lazy {
        s() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public y4 initializeField2() {
            return new y4(ServiceLocatorNoBilling.this.getDeviceDataFacade(), ServiceLocatorNoBilling.this.getHostInformationDataFacade(), ServiceLocatorNoBilling.this.getReportHelper(), ServiceLocatorNoBilling.this.getLoginHandler());
        }
    }

    class t extends Lazy {
        t() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public z2 initializeField2() {
            return new z2(ServiceLocatorNoBilling.this.getBaasAuth(), ServiceLocatorNoBilling.this.getDeviceDataFacade(), ServiceLocatorNoBilling.this.getBaasAccountRepository(), ServiceLocatorNoBilling.this.g());
        }
    }

    class u extends Lazy {
        u() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public ProcessLifecycleObserver initializeField2() {
            return new ProcessLifecycleObserver(ServiceLocatorNoBilling.this.getLoginHandler(), ServiceLocatorNoBilling.this.getSessionEventManager(), (u1) ServiceLocatorNoBilling.this.l.get());
        }
    }

    class v extends Lazy {
        v() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public b5 initializeField2() {
            return new b5(ServiceLocatorNoBilling.this.f779a);
        }
    }

    class w extends Lazy {
        w() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public p3 initializeField2() {
            return new n3(ServiceLocatorNoBilling.this.getNintendoAccountRepository(), ServiceLocatorNoBilling.this.getHostInformationDataFacade(), ServiceLocatorNoBilling.this.getDeviceDataFacade(), ServiceLocatorNoBilling.this.a());
        }
    }

    class x extends Lazy {
        x() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public o3 initializeField2() {
            return new o3(ServiceLocatorNoBilling.this.l(), ServiceLocatorNoBilling.this.M, ServiceLocatorNoBilling.this.g());
        }
    }

    class y extends Lazy {
        y() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public g5 initializeField2() {
            return new e5(ServiceLocatorNoBilling.this.c());
        }
    }

    class z extends Lazy {
        z() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public u0 initializeField2() {
            return new v0(ServiceLocatorNoBilling.this.h());
        }
    }

    public ServiceLocatorNoBilling(Application application) {
        if (application == null) {
            throw new IllegalArgumentException();
        }
        this.f779a = application;
        this.b = new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.getActivity();
            }
        };
        com.nintendo.npf.sdk.internal.impl.a aVar = new com.nintendo.npf.sdk.internal.impl.a(application);
        p4 p4Var = new p4(new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.s();
            }
        });
        this.M = new e4();
        this.r = new k(aVar, p4Var);
        this.s = new v();
        this.t = new z();
        this.u = new a0();
        this.v = new b0();
        this.w = new c0();
        this.x = new d0();
        this.m = new e0();
        this.k = new f0();
        this.n = new a();
        this.p = new b(aVar, p4Var);
        this.q = new com.nintendo.npf.sdk.core.j(d(), p4Var, g());
        this.c = new c();
        this.d = new d();
        this.e = new e();
        f fVar = new f();
        this.f = fVar;
        this.g = new g();
        this.h = new h();
        this.i = new i();
        this.j = new j();
        this.l = new l();
        this.o = new m();
        this.A = new n();
        this.B = new o();
        this.C = new p();
        this.D = new q();
        this.E = new r();
        this.F = new s();
        this.G = new t();
        this.H = new u();
        this.J = new w();
        this.I = new x();
        this.K = new y();
        this.y = new n1(application, new q0());
        this.z = new l1(application);
        SDKLog.setup(((Capabilities) fVar.get()).isPrintLog().booleanValue(), ((Capabilities) fVar.get()).isDebugLog());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit s() {
        o().a();
        return Unit.INSTANCE;
    }

    @Override // com.nintendo.npf.sdk.core.x4
    public HttpClient getAccountApiClient() {
        return (HttpClient) this.D.get();
    }

    @Override // com.nintendo.npf.sdk.core.x4
    public HttpClient getAccountClient() {
        return (HttpClient) this.C.get();
    }

    protected Activity getActivity() {
        return this.L;
    }

    public Function0<Activity> getActivityProvider() {
        return this.b;
    }

    @Override // com.nintendo.npf.sdk.core.x4
    public AnalyticsService getAnalyticsService() {
        return new AnalyticsDefaultService(getBaasAccountRepository(), getDeviceDataFacade(), new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.b();
            }
        }, this.q, g());
    }

    public Application getApplication() {
        return this.f779a;
    }

    @Override // com.nintendo.npf.sdk.core.x4
    public AuditService getAuditService() {
        return new com.nintendo.npf.sdk.core.z(getBaasAccountRepository(), g());
    }

    public BaasAccountRepository getBaasAccountRepository() {
        return (BaasAccountRepository) this.k.get();
    }

    @Override // com.nintendo.npf.sdk.core.x4
    public BaasAccountService getBaasAccountService() {
        return new com.nintendo.npf.sdk.core.f0(new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.getCapabilities();
            }
        }, new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.getBaasAuth();
            }
        }, new ServiceLocatorNoBilling$$ExternalSyntheticLambda4(this), getBaasAccountRepository(), getLoginHandler(), getSessionEventManager(), getNintendoAccountRepository(), getDeviceDataFacade(), getCredentialsDataFacade(), g());
    }

    public com.nintendo.npf.sdk.core.c0 getBaasAuth() {
        return (com.nintendo.npf.sdk.core.c0) this.j.get();
    }

    @Override // com.nintendo.npf.sdk.core.x4
    public HttpClient getBaasHttpClient() {
        return (HttpClient) this.B.get();
    }

    @Override // com.nintendo.npf.sdk.core.x4
    public j0 getBaasUser() {
        return (j0) this.d.get();
    }

    @Override // com.nintendo.npf.sdk.core.x4
    public Capabilities getCapabilities() {
        return (Capabilities) this.f.get();
    }

    @Override // com.nintendo.npf.sdk.core.x4
    public u0 getConfigurationDataFacade() {
        return (u0) this.t.get();
    }

    @Override // com.nintendo.npf.sdk.core.x4
    public a1 getCredentialsDataFacade() {
        return (a1) this.u.get();
    }

    @Override // com.nintendo.npf.sdk.core.x4
    public DeviceDataFacade getDeviceDataFacade() {
        return (DeviceDataFacade) this.w.get();
    }

    @Override // com.nintendo.npf.sdk.core.x4
    public e4 getEventDispatcher() {
        return this.M;
    }

    public NPFSDK.EventHandler getEventHandler() {
        return this.M.a();
    }

    @Override // com.nintendo.npf.sdk.core.x4
    public y1 getHostInformationDataFacade() {
        return (y1) this.x.get();
    }

    @Override // com.nintendo.npf.sdk.core.x4
    public InquiryService getInquiryService() {
        return new m2(getBaasAccountRepository(), j(), new ErrorFactory());
    }

    @Override // com.nintendo.npf.sdk.core.x4
    public LinkedAccountService getLinkedAppleAccountService() {
        return new x2("appleAccount", getPushNotificationChannel(), getCapabilities(), getBaasAccountRepository(), getNintendoAccountRepository(), k(), getDeviceDataFacade(), getCredentialsDataFacade(), g());
    }

    @Override // com.nintendo.npf.sdk.core.x4
    public LinkedAccountService getLinkedFacebookAccountService() {
        return new x2("facebookAccount", getPushNotificationChannel(), getCapabilities(), getBaasAccountRepository(), getNintendoAccountRepository(), k(), getDeviceDataFacade(), getCredentialsDataFacade(), g());
    }

    @Override // com.nintendo.npf.sdk.core.x4
    public LinkedAccountService getLinkedGoogleAccountService() {
        return new x2("googleAccount", getPushNotificationChannel(), getCapabilities(), getBaasAccountRepository(), getNintendoAccountRepository(), k(), getDeviceDataFacade(), getCredentialsDataFacade(), g());
    }

    @Override // com.nintendo.npf.sdk.core.x4
    public z2 getLoginHandler() {
        return (z2) this.G.get();
    }

    @Override // com.nintendo.npf.sdk.core.x4
    public c3 getMiiStudioService() {
        return (c3) this.e.get();
    }

    @Override // com.nintendo.npf.sdk.core.x4
    public d3 getMissionStatus() {
        return (d3) this.g.get();
    }

    @Override // com.nintendo.npf.sdk.core.x4
    public i3 getNPFSDK() {
        return (i3) this.c.get();
    }

    @Override // com.nintendo.npf.sdk.core.x4
    public o3 getNaAuthorizationHandler() {
        return (o3) this.I.get();
    }

    public NintendoAccountRepository getNintendoAccountRepository() {
        return (NintendoAccountRepository) this.m.get();
    }

    @Override // com.nintendo.npf.sdk.core.x4
    public NintendoAccountService getNintendoAccountService() {
        return new u3(getCredentialsDataFacade(), getBaasAccountRepository(), g(), getNaAuthorizationHandler());
    }

    @Override // com.nintendo.npf.sdk.core.x4
    public OtherUserService getOtherUserService() {
        return new a4(getBaasAccountRepository(), g());
    }

    public ProcessLifecycleObserver getProcessLifecycleObserver() {
        return (ProcessLifecycleObserver) this.H.get();
    }

    public PromoCodeBundleRepository getPromoCodeBundleRepository() {
        throw new UnsupportedOperationException();
    }

    @Override // com.nintendo.npf.sdk.core.x4
    public PromoCodeService getPromoCodeService() {
        throw new UnsupportedOperationException();
    }

    public m4 getPushNotificationChannel() {
        return (m4) this.h.get();
    }

    @Override // com.nintendo.npf.sdk.core.x4
    public PushNotificationChannelService getPushNotificationChannelService() {
        return new l4(new ServiceLocatorNoBilling$$ExternalSyntheticLambda4(this));
    }

    public ReportHelper getReportHelper() {
        return new ReportHelper(getBaasAccountRepository(), b(), this.q, g());
    }

    @Override // com.nintendo.npf.sdk.core.x4
    public v4 getSdkWebViewManager() {
        return (v4) this.i.get();
    }

    public y4 getSessionEventManager() {
        return (y4) this.F.get();
    }

    @Override // com.nintendo.npf.sdk.core.x4
    public SubscriptionController getSubscriptionController() {
        throw new UnsupportedOperationException();
    }

    public SubscriptionOwnershipRepository getSubscriptionOwnershipRepository() {
        throw new UnsupportedOperationException();
    }

    public SubscriptionProductRepository getSubscriptionProductRepository() {
        throw new UnsupportedOperationException();
    }

    public SubscriptionPurchaseRepository getSubscriptionPurchaseRepository() {
        throw new UnsupportedOperationException();
    }

    public SubscriptionReplacementRepository getSubscriptionReplacementRepository() {
        throw new UnsupportedOperationException();
    }

    @Override // com.nintendo.npf.sdk.core.x4
    public SubscriptionService getSubscriptionService() {
        throw new UnsupportedOperationException();
    }

    public SubscriptionTransactionRepository getSubscriptionTransactionRepository() {
        throw new UnsupportedOperationException();
    }

    @Override // com.nintendo.npf.sdk.core.x4
    public TransferAccountService getTransferAccountService() {
        return new f5((g5) this.K.get(), getBaasAccountRepository(), getPushNotificationChannel(), getCapabilities(), getNintendoAccountRepository(), getDeviceDataFacade(), getCredentialsDataFacade(), g());
    }

    public VirtualCurrencyBundleRepository getVirtualCurrencyBundleRepository() {
        throw new UnsupportedOperationException();
    }

    public VirtualCurrencyPurchaseAbilityRepository getVirtualCurrencyPurchaseAbilityRepository() {
        throw new UnsupportedOperationException();
    }

    public VirtualCurrencyPurchaseRepository getVirtualCurrencyPurchaseRepository() {
        throw new UnsupportedOperationException();
    }

    public VirtualCurrencyPurchaseSummaryRepository getVirtualCurrencyPurchaseSummaryRepository() {
        throw new UnsupportedOperationException();
    }

    @Override // com.nintendo.npf.sdk.core.x4
    public VirtualCurrencyService getVirtualCurrencyService() {
        throw new UnsupportedOperationException();
    }

    public VirtualCurrencyTransactionRepository getVirtualCurrencyTransactionRepository() {
        throw new UnsupportedOperationException();
    }

    public VirtualCurrencyWalletRepository getVirtualCurrencyWalletRepository() {
        throw new UnsupportedOperationException();
    }

    @Override // com.nintendo.npf.sdk.core.x4
    public void setActivity(Activity activity) {
        this.L = activity;
    }

    @Override // com.nintendo.npf.sdk.core.x4
    public void setEventHandler(NPFSDK.EventHandler eventHandler) {
        this.M.a(eventHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.nintendo.npf.sdk.core.q a() {
        return new com.nintendo.npf.sdk.core.q(new ServiceLocatorNoBilling$$ExternalSyntheticLambda1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.nintendo.npf.sdk.core.w b() {
        return (com.nintendo.npf.sdk.core.w) this.p.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.nintendo.npf.sdk.core.d0 c() {
        return new com.nintendo.npf.sdk.core.d0(getDeviceDataFacade(), new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return g0.c();
            }
        }, g(), getCredentialsDataFacade(), new k0(), new b4(), new x1(), new h5(), getHostInformationDataFacade());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public m0 d() {
        return new m0(new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return g0.b();
            }
        }, new com.nintendo.npf.sdk.core.l(), g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d1 e() {
        return (d1) this.v.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l1 f() {
        return this.z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ErrorFactory g() {
        return new ErrorFactory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public n1 h() {
        return this.y;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public j2 i() {
        return new j2(new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return g0.d();
            }
        }, new p2(), new ErrorFactory());
    }

    private o2 j() {
        return (o2) this.o.get();
    }

    private y2 k() {
        return (y2) this.n.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public p3 l() {
        return (p3) this.J.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public s3 m() {
        return new s3(new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return r3.a();
            }
        }, new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return r3.b();
            }
        }, new x3(), new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.r();
            }
        }, g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h4 n() {
        return (h4) this.A.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public o4 o() {
        return (o4) this.r.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.nintendo.npf.sdk.internal.client.core.f p() {
        return (com.nintendo.npf.sdk.internal.client.core.f) this.E.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b5 q() {
        return (b5) this.s.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ w3 r() {
        return new w3(new ServiceLocatorNoBilling$$ExternalSyntheticLambda1(this));
    }
}
