package com.nintendo.npf.sdk.internal.impl;

import android.app.Activity;
import android.app.Application;
import android.os.Looper;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.domain.application.SubscriptionDefaultController;
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
import com.nintendo.npf.sdk.domain.service.PromoCodeDefaultService;
import com.nintendo.npf.sdk.domain.service.SubscriptionDefaultService;
import com.nintendo.npf.sdk.domain.service.VirtualCurrencyDefaultService;
import com.nintendo.npf.sdk.infrastructure.api.PromoCodeApi;
import com.nintendo.npf.sdk.infrastructure.api.SubscriptionApi;
import com.nintendo.npf.sdk.infrastructure.api.VirtualCurrencyApi;
import com.nintendo.npf.sdk.infrastructure.helper.PromoCodeHelper;
import com.nintendo.npf.sdk.infrastructure.helper.SubscriptionHelper;
import com.nintendo.npf.sdk.infrastructure.helper.VirtualCurrencyHelper;
import com.nintendo.npf.sdk.infrastructure.mapper.PromoCodeBundleMapper;
import com.nintendo.npf.sdk.infrastructure.mapper.PromoCodePurchasesMapper;
import com.nintendo.npf.sdk.infrastructure.mapper.SubscriptionOwnershipMapper;
import com.nintendo.npf.sdk.infrastructure.mapper.SubscriptionProductMapper;
import com.nintendo.npf.sdk.infrastructure.mapper.SubscriptionPurchaseMapper;
import com.nintendo.npf.sdk.infrastructure.mapper.SubscriptionReplacementMapper;
import com.nintendo.npf.sdk.infrastructure.mapper.VirtualCurrencyBundleMapper;
import com.nintendo.npf.sdk.infrastructure.mapper.VirtualCurrencyPurchaseAbilityMapper;
import com.nintendo.npf.sdk.infrastructure.mapper.VirtualCurrencyPurchasedSummaryMapper;
import com.nintendo.npf.sdk.infrastructure.mapper.VirtualCurrencyPurchasesMapper;
import com.nintendo.npf.sdk.infrastructure.mapper.VirtualCurrencyWalletMapper;
import com.nintendo.npf.sdk.infrastructure.repository.OrderCacheDefaultRepository;
import com.nintendo.npf.sdk.infrastructure.repository.PromoCodeBundleGoogleRepository;
import com.nintendo.npf.sdk.infrastructure.repository.PromoCodeBundleMockRepository;
import com.nintendo.npf.sdk.infrastructure.repository.SubscriptionOwnershipGoogleRepository;
import com.nintendo.npf.sdk.infrastructure.repository.SubscriptionOwnershipMockRepository;
import com.nintendo.npf.sdk.infrastructure.repository.SubscriptionProductGoogleRepository;
import com.nintendo.npf.sdk.infrastructure.repository.SubscriptionProductMockRepository;
import com.nintendo.npf.sdk.infrastructure.repository.SubscriptionPurchaseGoogleRepository;
import com.nintendo.npf.sdk.infrastructure.repository.SubscriptionPurchaseMockRepository;
import com.nintendo.npf.sdk.infrastructure.repository.SubscriptionReplacementGoogleRepository;
import com.nintendo.npf.sdk.infrastructure.repository.SubscriptionReplacementMockRepository;
import com.nintendo.npf.sdk.infrastructure.repository.SubscriptionTransactionGoogleRepository;
import com.nintendo.npf.sdk.infrastructure.repository.SubscriptionTransactionMockRepository;
import com.nintendo.npf.sdk.infrastructure.repository.VirtualCurrencyBundleGoogleRepository;
import com.nintendo.npf.sdk.infrastructure.repository.VirtualCurrencyBundleMockRepository;
import com.nintendo.npf.sdk.infrastructure.repository.VirtualCurrencyPurchaseAbilityDefaultRepository;
import com.nintendo.npf.sdk.infrastructure.repository.VirtualCurrencyPurchaseGoogleRepository;
import com.nintendo.npf.sdk.infrastructure.repository.VirtualCurrencyPurchaseMockRepository;
import com.nintendo.npf.sdk.infrastructure.repository.VirtualCurrencyPurchaseSummaryDefaultRepository;
import com.nintendo.npf.sdk.infrastructure.repository.VirtualCurrencyTransactionGoogleRepository;
import com.nintendo.npf.sdk.infrastructure.repository.VirtualCurrencyTransactionMockRepository;
import com.nintendo.npf.sdk.infrastructure.repository.VirtualCurrencyWalletDefaultRepository;
import com.nintendo.npf.sdk.internal.billing.NPFBillingClient;
import com.nintendo.npf.sdk.internal.billing.PromoCodeLifecycleObserver;
import com.nintendo.npf.sdk.internal.billing.SubscriptionErrorFactory;
import com.nintendo.npf.sdk.internal.util.Lazy;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import com.nintendo.npf.sdk.promo.PromoCodeService;
import com.nintendo.npf.sdk.subscription.SubscriptionController;
import com.nintendo.npf.sdk.subscription.SubscriptionService;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyService;
import com.nintendo.npf.sdkbilling.d;
import com.nintendo.npf.sdkbilling.e1;
import com.nintendo.npf.sdkbilling.u;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes2.dex */
public class ServiceLocatorBilling extends ServiceLocatorNoBilling {
    public static final /* synthetic */ int Z = 0;
    public final Lazy N;
    public final Lazy O;
    public final Lazy P;
    public final Lazy Q;
    public final Lazy R;
    public final Lazy S;
    public final Lazy T;
    public final Lazy U;
    public final Lazy V;
    public final Lazy W;
    public final Lazy X;
    public final Lazy Y;

    /* JADX INFO: renamed from: com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling$1, reason: invalid class name */
    public class AnonymousClass1 extends Lazy<VirtualCurrencyBundleRepository> {
        public AnonymousClass1() {
        }

        public final /* synthetic */ VirtualCurrencyApi a() {
            return ServiceLocatorBilling.a(ServiceLocatorBilling.this);
        }

        public final /* synthetic */ VirtualCurrencyApi b() {
            return ServiceLocatorBilling.a(ServiceLocatorBilling.this);
        }

        public final NPFBillingClient c() {
            ServiceLocatorBilling serviceLocatorBilling = ServiceLocatorBilling.this;
            int i = ServiceLocatorBilling.Z;
            return new NPFBillingClient(serviceLocatorBilling.getApplication().getApplicationContext(), "inapp", new e1());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public final VirtualCurrencyBundleRepository initializeField2() {
            if (ServiceLocatorBilling.this.getCapabilities().isPurchaseMock()) {
                return new VirtualCurrencyBundleMockRepository(new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.a();
                    }
                });
            }
            ServiceLocatorBilling serviceLocatorBilling = ServiceLocatorBilling.this;
            int i = ServiceLocatorBilling.Z;
            return new VirtualCurrencyBundleGoogleRepository(serviceLocatorBilling.v(), new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.b();
                }
            }, new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling$1$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.c();
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling$10, reason: invalid class name */
    public class AnonymousClass10 extends Lazy<SubscriptionReplacementRepository> {
        public AnonymousClass10() {
        }

        public final /* synthetic */ SubscriptionApi a() {
            return ServiceLocatorBilling.b(ServiceLocatorBilling.this);
        }

        public final /* synthetic */ SubscriptionApi b() {
            return ServiceLocatorBilling.b(ServiceLocatorBilling.this);
        }

        public final NPFBillingClient c() {
            ServiceLocatorBilling serviceLocatorBilling = ServiceLocatorBilling.this;
            int i = ServiceLocatorBilling.Z;
            return new NPFBillingClient(serviceLocatorBilling.getApplication().getApplicationContext(), "subs", new SubscriptionErrorFactory());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public final SubscriptionReplacementRepository initializeField2() {
            if (ServiceLocatorBilling.this.getCapabilities().isPurchaseMock()) {
                return new SubscriptionReplacementMockRepository(new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling$10$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.a();
                    }
                }, new ErrorFactory());
            }
            ServiceLocatorBilling serviceLocatorBilling = ServiceLocatorBilling.this;
            int i = ServiceLocatorBilling.Z;
            return new SubscriptionReplacementGoogleRepository(serviceLocatorBilling.u(), new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling$10$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.b();
                }
            }, new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling$10$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.c();
                }
            }, new ErrorFactory());
        }
    }

    /* JADX INFO: renamed from: com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling$11, reason: invalid class name */
    public class AnonymousClass11 extends Lazy<SubscriptionTransactionRepository> {
        public AnonymousClass11() {
        }

        public final NPFBillingClient a() {
            ServiceLocatorBilling serviceLocatorBilling = ServiceLocatorBilling.this;
            int i = ServiceLocatorBilling.Z;
            return new NPFBillingClient(serviceLocatorBilling.getApplication().getApplicationContext(), "subs", new SubscriptionErrorFactory());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public final SubscriptionTransactionRepository initializeField2() {
            if (ServiceLocatorBilling.this.getCapabilities().isPurchaseMock()) {
                return new SubscriptionTransactionMockRepository();
            }
            ServiceLocatorBilling serviceLocatorBilling = ServiceLocatorBilling.this;
            int i = ServiceLocatorBilling.Z;
            return new SubscriptionTransactionGoogleRepository(serviceLocatorBilling.u(), new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling$11$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.a();
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling$12, reason: invalid class name */
    public class AnonymousClass12 extends Lazy<PromoCodeBundleRepository> {
        public AnonymousClass12() {
        }

        public final PromoCodeApi a() {
            ServiceLocatorBilling serviceLocatorBilling = ServiceLocatorBilling.this;
            int i = ServiceLocatorBilling.Z;
            serviceLocatorBilling.getClass();
            return new PromoCodeApi(serviceLocatorBilling.getBaasHttpClient(), new PromoCodeBundleMapper(), new PromoCodePurchasesMapper(), new ErrorFactory());
        }

        public final NPFBillingClient b() {
            ServiceLocatorBilling serviceLocatorBilling = ServiceLocatorBilling.this;
            int i = ServiceLocatorBilling.Z;
            return new NPFBillingClient(serviceLocatorBilling.getApplication().getApplicationContext(), "inapp", new u());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public final PromoCodeBundleRepository initializeField2() {
            if (ServiceLocatorBilling.this.getCapabilities().isPurchaseMock()) {
                return new PromoCodeBundleMockRepository();
            }
            ServiceLocatorBilling serviceLocatorBilling = ServiceLocatorBilling.this;
            int i = ServiceLocatorBilling.Z;
            return new PromoCodeBundleGoogleRepository(serviceLocatorBilling.t(), ServiceLocatorBilling.this.getCapabilities(), new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling$12$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.a();
                }
            }, new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling$12$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.b();
                }
            }, new OrderCacheDefaultRepository(ServiceLocatorBilling.this.getApplication()), new ErrorFactory());
        }
    }

    /* JADX INFO: renamed from: com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling$2, reason: invalid class name */
    public class AnonymousClass2 extends Lazy<VirtualCurrencyPurchaseAbilityRepository> {
        public AnonymousClass2() {
        }

        public final /* synthetic */ VirtualCurrencyApi a() {
            return ServiceLocatorBilling.a(ServiceLocatorBilling.this);
        }

        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField, reason: merged with bridge method [inline-methods] */
        public final VirtualCurrencyPurchaseAbilityRepository initializeField2() {
            return new VirtualCurrencyPurchaseAbilityDefaultRepository(new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling$2$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.a();
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling$3, reason: invalid class name */
    public class AnonymousClass3 extends Lazy<VirtualCurrencyPurchaseRepository> {
        public AnonymousClass3() {
        }

        public final /* synthetic */ VirtualCurrencyApi a() {
            return ServiceLocatorBilling.a(ServiceLocatorBilling.this);
        }

        public final /* synthetic */ Activity b() {
            return ServiceLocatorBilling.this.getActivity();
        }

        public final /* synthetic */ VirtualCurrencyApi c() {
            return ServiceLocatorBilling.a(ServiceLocatorBilling.this);
        }

        public final NPFBillingClient d() {
            ServiceLocatorBilling serviceLocatorBilling = ServiceLocatorBilling.this;
            int i = ServiceLocatorBilling.Z;
            return new NPFBillingClient(serviceLocatorBilling.getApplication().getApplicationContext(), "inapp", new e1());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public final VirtualCurrencyPurchaseRepository initializeField2() {
            if (ServiceLocatorBilling.this.getCapabilities().isPurchaseMock()) {
                ServiceLocatorBilling serviceLocatorBilling = ServiceLocatorBilling.this;
                int i = ServiceLocatorBilling.Z;
                return new VirtualCurrencyPurchaseMockRepository(serviceLocatorBilling.v(), ServiceLocatorBilling.this.getCapabilities(), new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling$3$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.a();
                    }
                }, new OrderCacheDefaultRepository(ServiceLocatorBilling.this.getApplication()), new ErrorFactory());
            }
            ServiceLocatorBilling serviceLocatorBilling2 = ServiceLocatorBilling.this;
            int i2 = ServiceLocatorBilling.Z;
            return new VirtualCurrencyPurchaseGoogleRepository(serviceLocatorBilling2.v(), new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling$3$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.b();
                }
            }, ServiceLocatorBilling.this.getCapabilities(), new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling$3$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.c();
                }
            }, new OrderCacheDefaultRepository(ServiceLocatorBilling.this.getApplication()), new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling$3$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.d();
                }
            }, new ErrorFactory());
        }
    }

    /* JADX INFO: renamed from: com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling$4, reason: invalid class name */
    public class AnonymousClass4 extends Lazy<VirtualCurrencyTransactionRepository> {
        public AnonymousClass4() {
        }

        public final /* synthetic */ VirtualCurrencyApi a() {
            return ServiceLocatorBilling.a(ServiceLocatorBilling.this);
        }

        public final NPFBillingClient b() {
            ServiceLocatorBilling serviceLocatorBilling = ServiceLocatorBilling.this;
            int i = ServiceLocatorBilling.Z;
            return new NPFBillingClient(serviceLocatorBilling.getApplication().getApplicationContext(), "inapp", new e1());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public final VirtualCurrencyTransactionRepository initializeField2() {
            if (ServiceLocatorBilling.this.getCapabilities().isPurchaseMock()) {
                return new VirtualCurrencyTransactionMockRepository();
            }
            ServiceLocatorBilling serviceLocatorBilling = ServiceLocatorBilling.this;
            int i = ServiceLocatorBilling.Z;
            return new VirtualCurrencyTransactionGoogleRepository(serviceLocatorBilling.v(), ServiceLocatorBilling.this.getCapabilities(), new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling$4$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.a();
                }
            }, new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling$4$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.b();
                }
            }, new ErrorFactory());
        }
    }

    /* JADX INFO: renamed from: com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling$5, reason: invalid class name */
    public class AnonymousClass5 extends Lazy<VirtualCurrencyWalletRepository> {
        public AnonymousClass5() {
        }

        public final /* synthetic */ VirtualCurrencyApi a() {
            return ServiceLocatorBilling.a(ServiceLocatorBilling.this);
        }

        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public final VirtualCurrencyWalletRepository initializeField2() {
            return new VirtualCurrencyWalletDefaultRepository(new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling$5$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.a();
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling$6, reason: invalid class name */
    public class AnonymousClass6 extends Lazy<VirtualCurrencyPurchaseSummaryRepository> {
        public AnonymousClass6() {
        }

        public final /* synthetic */ VirtualCurrencyApi a() {
            return ServiceLocatorBilling.a(ServiceLocatorBilling.this);
        }

        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public final VirtualCurrencyPurchaseSummaryRepository initializeField2() {
            return new VirtualCurrencyPurchaseSummaryDefaultRepository(new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling$6$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.a();
                }
            }, new ErrorFactory());
        }
    }

    /* JADX INFO: renamed from: com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling$7, reason: invalid class name */
    public class AnonymousClass7 extends Lazy<SubscriptionOwnershipRepository> {
        public AnonymousClass7() {
        }

        public final /* synthetic */ SubscriptionApi a() {
            return ServiceLocatorBilling.b(ServiceLocatorBilling.this);
        }

        public final /* synthetic */ SubscriptionApi b() {
            return ServiceLocatorBilling.b(ServiceLocatorBilling.this);
        }

        public final NPFBillingClient c() {
            ServiceLocatorBilling serviceLocatorBilling = ServiceLocatorBilling.this;
            int i = ServiceLocatorBilling.Z;
            return new NPFBillingClient(serviceLocatorBilling.getApplication().getApplicationContext(), "subs", new SubscriptionErrorFactory());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public final SubscriptionOwnershipRepository initializeField2() {
            if (ServiceLocatorBilling.this.getCapabilities().isPurchaseMock()) {
                return new SubscriptionOwnershipMockRepository(new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling$7$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.a();
                    }
                });
            }
            ServiceLocatorBilling serviceLocatorBilling = ServiceLocatorBilling.this;
            int i = ServiceLocatorBilling.Z;
            return new SubscriptionOwnershipGoogleRepository(serviceLocatorBilling.u(), new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling$7$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.b();
                }
            }, new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling$7$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.c();
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling$8, reason: invalid class name */
    public class AnonymousClass8 extends Lazy<SubscriptionProductRepository> {
        public AnonymousClass8() {
        }

        public final /* synthetic */ SubscriptionApi a() {
            return ServiceLocatorBilling.b(ServiceLocatorBilling.this);
        }

        public final /* synthetic */ SubscriptionApi b() {
            return ServiceLocatorBilling.b(ServiceLocatorBilling.this);
        }

        public final NPFBillingClient c() {
            ServiceLocatorBilling serviceLocatorBilling = ServiceLocatorBilling.this;
            int i = ServiceLocatorBilling.Z;
            return new NPFBillingClient(serviceLocatorBilling.getApplication().getApplicationContext(), "subs", new SubscriptionErrorFactory());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public final SubscriptionProductRepository initializeField2() {
            if (ServiceLocatorBilling.this.getCapabilities().isPurchaseMock()) {
                return new SubscriptionProductMockRepository(new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling$8$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.a();
                    }
                });
            }
            ServiceLocatorBilling serviceLocatorBilling = ServiceLocatorBilling.this;
            int i = ServiceLocatorBilling.Z;
            return new SubscriptionProductGoogleRepository(serviceLocatorBilling.u(), new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling$8$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.b();
                }
            }, new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling$8$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.c();
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling$9, reason: invalid class name */
    public class AnonymousClass9 extends Lazy<SubscriptionPurchaseRepository> {
        public AnonymousClass9() {
        }

        public final /* synthetic */ SubscriptionApi a() {
            return ServiceLocatorBilling.b(ServiceLocatorBilling.this);
        }

        public final /* synthetic */ Activity b() {
            return ServiceLocatorBilling.this.getActivity();
        }

        public final /* synthetic */ SubscriptionApi c() {
            return ServiceLocatorBilling.b(ServiceLocatorBilling.this);
        }

        public final NPFBillingClient d() {
            ServiceLocatorBilling serviceLocatorBilling = ServiceLocatorBilling.this;
            int i = ServiceLocatorBilling.Z;
            return new NPFBillingClient(serviceLocatorBilling.getApplication().getApplicationContext(), "subs", new SubscriptionErrorFactory());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public final SubscriptionPurchaseRepository initializeField2() {
            if (ServiceLocatorBilling.this.getCapabilities().isPurchaseMock()) {
                return new SubscriptionPurchaseMockRepository(new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling$9$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.a();
                    }
                });
            }
            ServiceLocatorBilling serviceLocatorBilling = ServiceLocatorBilling.this;
            int i = ServiceLocatorBilling.Z;
            return new SubscriptionPurchaseGoogleRepository(serviceLocatorBilling.u(), new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling$9$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.b();
                }
            }, new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling$9$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.c();
                }
            }, new Function0() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling$9$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.d();
                }
            }, new ErrorFactory());
        }
    }

    public ServiceLocatorBilling(Application application) {
        super(application);
        this.N = new AnonymousClass1();
        this.O = new AnonymousClass2();
        this.P = new AnonymousClass3();
        this.Q = new AnonymousClass4();
        this.R = new AnonymousClass5();
        this.S = new AnonymousClass6();
        this.T = new AnonymousClass7();
        this.U = new AnonymousClass8();
        this.V = new AnonymousClass9();
        this.W = new AnonymousClass10();
        this.X = new AnonymousClass11();
        this.Y = new AnonymousClass12();
        final PromoCodeLifecycleObserver promoCodeLifecycleObserver = new PromoCodeLifecycleObserver(application, new ServiceLocatorBilling$$ExternalSyntheticLambda0(this));
        Runnable runnable = new Runnable() { // from class: com.nintendo.npf.sdk.internal.impl.ServiceLocatorBilling$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ProcessLifecycleOwner.get().getLifecycle().addObserver(promoCodeLifecycleObserver);
            }
        };
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            runnable.run();
        } else {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new d(runnable, null), 3, null);
        }
        SDKLog.setup(getCapabilities().isPrintLog().booleanValue(), getCapabilities().isDebugLog());
    }

    public static SubscriptionApi b(ServiceLocatorBilling serviceLocatorBilling) {
        return new SubscriptionApi(serviceLocatorBilling.getBaasHttpClient(), new SubscriptionProductMapper(serviceLocatorBilling.getCapabilities().isPurchaseMock()), new SubscriptionPurchaseMapper(), new SubscriptionOwnershipMapper(), new SubscriptionReplacementMapper(), new ErrorFactory());
    }

    @Override // com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling
    public PromoCodeBundleRepository getPromoCodeBundleRepository() {
        return (PromoCodeBundleRepository) this.Y.get();
    }

    @Override // com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling, com.nintendo.npf.sdk.core.x4
    public PromoCodeService getPromoCodeService() {
        return new PromoCodeDefaultService(getBaasAccountRepository(), getPromoCodeBundleRepository());
    }

    @Override // com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling, com.nintendo.npf.sdk.core.x4
    public SubscriptionController getSubscriptionController() {
        return new SubscriptionDefaultController(getActivityProvider(), getCapabilities());
    }

    @Override // com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling
    public SubscriptionOwnershipRepository getSubscriptionOwnershipRepository() {
        return (SubscriptionOwnershipRepository) this.T.get();
    }

    @Override // com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling
    public SubscriptionProductRepository getSubscriptionProductRepository() {
        return (SubscriptionProductRepository) this.U.get();
    }

    @Override // com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling
    public SubscriptionPurchaseRepository getSubscriptionPurchaseRepository() {
        return (SubscriptionPurchaseRepository) this.V.get();
    }

    @Override // com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling
    public SubscriptionReplacementRepository getSubscriptionReplacementRepository() {
        return (SubscriptionReplacementRepository) this.W.get();
    }

    @Override // com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling, com.nintendo.npf.sdk.core.x4
    public SubscriptionService getSubscriptionService() {
        return new SubscriptionDefaultService(getBaasAccountRepository(), getSubscriptionProductRepository(), getSubscriptionPurchaseRepository(), getSubscriptionOwnershipRepository(), getSubscriptionReplacementRepository(), getSubscriptionTransactionRepository());
    }

    @Override // com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling
    public SubscriptionTransactionRepository getSubscriptionTransactionRepository() {
        return (SubscriptionTransactionRepository) this.X.get();
    }

    @Override // com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling
    public VirtualCurrencyBundleRepository getVirtualCurrencyBundleRepository() {
        return (VirtualCurrencyBundleRepository) this.N.get();
    }

    @Override // com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling
    public VirtualCurrencyPurchaseAbilityRepository getVirtualCurrencyPurchaseAbilityRepository() {
        return (VirtualCurrencyPurchaseAbilityRepository) this.O.get();
    }

    @Override // com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling
    public VirtualCurrencyPurchaseRepository getVirtualCurrencyPurchaseRepository() {
        return (VirtualCurrencyPurchaseRepository) this.P.get();
    }

    @Override // com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling
    public VirtualCurrencyPurchaseSummaryRepository getVirtualCurrencyPurchaseSummaryRepository() {
        return (VirtualCurrencyPurchaseSummaryRepository) this.S.get();
    }

    @Override // com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling, com.nintendo.npf.sdk.core.x4
    public VirtualCurrencyService getVirtualCurrencyService() {
        return new VirtualCurrencyDefaultService(getNintendoAccountRepository(), getDeviceDataFacade(), getBaasAccountRepository(), getVirtualCurrencyBundleRepository(), getVirtualCurrencyPurchaseAbilityRepository(), getVirtualCurrencyPurchaseRepository(), getVirtualCurrencyTransactionRepository(), getVirtualCurrencyWalletRepository(), getVirtualCurrencyPurchaseSummaryRepository(), new ServiceLocatorBilling$$ExternalSyntheticLambda0(this), new ErrorFactory());
    }

    @Override // com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling
    public VirtualCurrencyTransactionRepository getVirtualCurrencyTransactionRepository() {
        return (VirtualCurrencyTransactionRepository) this.Q.get();
    }

    @Override // com.nintendo.npf.sdk.internal.impl.ServiceLocatorNoBilling
    public VirtualCurrencyWalletRepository getVirtualCurrencyWalletRepository() {
        return (VirtualCurrencyWalletRepository) this.R.get();
    }

    public final PromoCodeHelper t() {
        return new PromoCodeHelper(new ServiceLocatorBilling$$ExternalSyntheticLambda2(this));
    }

    public final SubscriptionHelper u() {
        return new SubscriptionHelper(new ServiceLocatorBilling$$ExternalSyntheticLambda2(this));
    }

    public final VirtualCurrencyHelper v() {
        return new VirtualCurrencyHelper(new ServiceLocatorBilling$$ExternalSyntheticLambda2(this));
    }

    public static VirtualCurrencyApi a(ServiceLocatorBilling serviceLocatorBilling) {
        return new VirtualCurrencyApi(serviceLocatorBilling.getBaasHttpClient(), new VirtualCurrencyBundleMapper(), new VirtualCurrencyPurchaseAbilityMapper(), new VirtualCurrencyPurchasesMapper(), new VirtualCurrencyWalletMapper(), new VirtualCurrencyPurchasedSummaryMapper(), new ErrorFactory());
    }
}
