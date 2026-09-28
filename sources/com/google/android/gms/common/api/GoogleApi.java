package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.core.content.ContextCompat;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.NonGmsServiceBrokerClient;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.common.api.internal.zaad;
import com.google.android.gms.common.api.internal.zabo;
import com.google.android.gms.common.api.internal.zabt;
import com.google.android.gms.common.api.internal.zacq;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.AttributionSourceWrapper;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class GoogleApi<O extends Api.ApiOptions> implements HasApiKey<O> {
    protected final GoogleApiManager zaa;
    private final Context zab;
    private final String zac;
    private final AttributionSourceWrapper zad;
    private final Api zae;
    private final Api.ApiOptions zaf;
    private final ApiKey zag;
    private final Looper zah;
    private final int zai;
    private final GoogleApiClient zaj;
    private final StatusExceptionMapper zak;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.6.0 */
    public static class Settings {
        public static final Settings DEFAULT_SETTINGS = new Builder().build();
        public final StatusExceptionMapper zaa;
        public final Looper zab;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.6.0 */
        public static class Builder {
            private StatusExceptionMapper zaa;
            private Looper zab;

            public Settings build() {
                if (this.zaa == null) {
                    this.zaa = new ApiExceptionMapper();
                }
                if (this.zab == null) {
                    this.zab = Looper.getMainLooper();
                }
                return new Settings(this.zaa, this.zab);
            }

            public Builder setLooper(Looper looper) {
                Preconditions.checkNotNull(looper, "Looper must not be null.");
                this.zab = looper;
                return this;
            }

            public Builder setMapper(StatusExceptionMapper statusExceptionMapper) {
                Preconditions.checkNotNull(statusExceptionMapper, "StatusExceptionMapper must not be null.");
                this.zaa = statusExceptionMapper;
                return this;
            }
        }

        private Settings(StatusExceptionMapper statusExceptionMapper, Account account, Looper looper) {
            this.zaa = statusExceptionMapper;
            this.zab = looper;
        }
    }

    public GoogleApi(Activity activity, Api<O> api, O o, Settings settings) {
        this(activity, activity, api, o, settings);
    }

    private final BaseImplementation.ApiMethodImpl zad(int i, BaseImplementation.ApiMethodImpl apiMethodImpl) {
        apiMethodImpl.zak();
        this.zaa.zau(this, i, apiMethodImpl);
        return apiMethodImpl;
    }

    private final Task zae(int i, TaskApiCall taskApiCall) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zaa.zav(this, i, taskApiCall, taskCompletionSource, this.zak);
        return taskCompletionSource.getTask();
    }

    public GoogleApiClient asGoogleApiClient() {
        return this.zaj;
    }

    protected ClientSettings.Builder createClientSettingsBuilder() {
        Account account;
        GoogleSignInAccount googleSignInAccount;
        GoogleSignInAccount googleSignInAccount2;
        ClientSettings.Builder builder = new ClientSettings.Builder();
        Api.ApiOptions apiOptions = this.zaf;
        if (!(apiOptions instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) || (googleSignInAccount2 = ((Api.ApiOptions.HasGoogleSignInAccountOptions) apiOptions).getGoogleSignInAccount()) == null) {
            Api.ApiOptions apiOptions2 = this.zaf;
            account = apiOptions2 instanceof Api.ApiOptions.HasAccountOptions ? ((Api.ApiOptions.HasAccountOptions) apiOptions2).getAccount() : null;
        } else {
            account = googleSignInAccount2.getAccount();
        }
        builder.zab(account);
        Api.ApiOptions apiOptions3 = this.zaf;
        Set<Scope> setEmptySet = (!(apiOptions3 instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) || (googleSignInAccount = ((Api.ApiOptions.HasGoogleSignInAccountOptions) apiOptions3).getGoogleSignInAccount()) == null) ? Collections.emptySet() : googleSignInAccount.getRequestedScopes();
        builder.zaa(setEmptySet);
        builder.zac(this.zab.getClass().getName());
        builder.setRealClientPackageName(this.zab.getPackageName());
        return builder;
    }

    protected Task<Boolean> disconnectService() {
        return this.zaa.zan(this);
    }

    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doBestEffortWrite(T t) {
        zad(2, t);
        return t;
    }

    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doRead(T t) {
        zad(0, t);
        return t;
    }

    @Deprecated
    public <A extends Api.AnyClient, T extends RegisterListenerMethod<A, ?>, U extends UnregisterListenerMethod<A, ?>> Task<Void> doRegisterEventListener(T t, U u) {
        Preconditions.checkNotNull(t);
        Preconditions.checkNotNull(u);
        Preconditions.checkNotNull(t.getListenerKey(), "Listener has already been released.");
        Preconditions.checkNotNull(u.getListenerKey(), "Listener has already been released.");
        Preconditions.checkArgument(Objects.equal(t.getListenerKey(), u.getListenerKey()), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
        return this.zaa.zao(this, t, u, new Runnable() { // from class: com.google.android.gms.common.api.zad
            @Override // java.lang.Runnable
            public final void run() {
            }
        });
    }

    public Task<Boolean> doUnregisterEventListener(ListenerHolder.ListenerKey<?> listenerKey) {
        return doUnregisterEventListener(listenerKey, 0);
    }

    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doWrite(T t) {
        zad(1, t);
        return t;
    }

    protected String getApiFallbackAttributionTag(Context context) {
        return null;
    }

    @Override // com.google.android.gms.common.api.HasApiKey
    public final ApiKey<O> getApiKey() {
        return this.zag;
    }

    public O getApiOptions() {
        return (O) this.zaf;
    }

    public Context getApplicationContext() {
        return this.zab;
    }

    protected String getContextAttributionTag() {
        return this.zac;
    }

    @Deprecated
    protected String getContextFeatureId() {
        return this.zac;
    }

    public Looper getLooper() {
        return this.zah;
    }

    public <L> ListenerHolder<L> registerListener(L l, String str) {
        return ListenerHolders.createListenerHolder(l, this.zah, str);
    }

    public final int zaa() {
        return this.zai;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Api.Client zab(Looper looper, zabo zaboVar) {
        ClientSettings clientSettingsBuild = createClientSettingsBuilder().build();
        Api.Client clientBuildClient = ((Api.AbstractClientBuilder) Preconditions.checkNotNull(this.zae.zaa())).buildClient(this.zab, looper, clientSettingsBuild, this.zaf, (GoogleApiClient.ConnectionCallbacks) zaboVar, (GoogleApiClient.OnConnectionFailedListener) zaboVar);
        AttributionSourceWrapper attributionSourceWrapper = this.zad;
        if (attributionSourceWrapper != null && (clientBuildClient instanceof BaseGmsClient)) {
            ((BaseGmsClient) clientBuildClient).setAttributionSourceWrapper(attributionSourceWrapper);
            return clientBuildClient;
        }
        if (attributionSourceWrapper != null && (clientBuildClient instanceof NonGmsServiceBrokerClient)) {
            ((NonGmsServiceBrokerClient) clientBuildClient).zac(attributionSourceWrapper);
            return clientBuildClient;
        }
        String contextAttributionTag = getContextAttributionTag();
        if (contextAttributionTag != null && (clientBuildClient instanceof BaseGmsClient)) {
            ((BaseGmsClient) clientBuildClient).setAttributionTag(contextAttributionTag);
        }
        if (contextAttributionTag != null && (clientBuildClient instanceof NonGmsServiceBrokerClient)) {
            ((NonGmsServiceBrokerClient) clientBuildClient).zad(contextAttributionTag);
        }
        return clientBuildClient;
    }

    public final zacq zac(Context context, Handler handler) {
        return new zacq(context, handler, createClientSettingsBuilder().build());
    }

    @Deprecated
    public GoogleApi(Activity activity, Api<O> api, O o, StatusExceptionMapper statusExceptionMapper) {
        Settings.Builder builder = new Settings.Builder();
        builder.setMapper(statusExceptionMapper);
        builder.setLooper(activity.getMainLooper());
        this(activity, (Api) api, (Api.ApiOptions) o, builder.build());
    }

    public <TResult, A extends Api.AnyClient> Task<TResult> doBestEffortWrite(TaskApiCall<A, TResult> taskApiCall) {
        return zae(2, taskApiCall);
    }

    public <TResult, A extends Api.AnyClient> Task<TResult> doRead(TaskApiCall<A, TResult> taskApiCall) {
        return zae(0, taskApiCall);
    }

    public Task<Boolean> doUnregisterEventListener(ListenerHolder.ListenerKey<?> listenerKey, int i) {
        Preconditions.checkNotNull(listenerKey, "Listener key cannot be null.");
        return this.zaa.zap(this, listenerKey, i);
    }

    public <TResult, A extends Api.AnyClient> Task<TResult> doWrite(TaskApiCall<A, TResult> taskApiCall) {
        return zae(1, taskApiCall);
    }

    private GoogleApi(Context context, Activity activity, Api api, Api.ApiOptions apiOptions, Settings settings) {
        Context context2;
        String apiFallbackAttributionTag;
        ApiKey sharedApiKey;
        GoogleApiManager googleApiManagerZak;
        Preconditions.checkNotNull(context, "Null context is not permitted.");
        Preconditions.checkNotNull(api, "Api must not be null.");
        Preconditions.checkNotNull(settings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context context3 = (Context) Preconditions.checkNotNull(context.getApplicationContext(), "The provided context did not have an application context.");
        this.zab = context3;
        AttributionSourceWrapper attributionSourceWrapper = null;
        if (Build.VERSION.SDK_INT >= 30) {
            if (context != null) {
                apiFallbackAttributionTag = ContextCompat.getAttributionTag(context);
            } else {
                context2 = null;
            }
            this.zac = apiFallbackAttributionTag;
            if (Build.VERSION.SDK_INT >= 31 && context != null) {
                attributionSourceWrapper = new AttributionSourceWrapper(context.getAttributionSource());
            }
            this.zad = attributionSourceWrapper;
            this.zae = api;
            this.zaf = apiOptions;
            this.zah = settings.zab;
            sharedApiKey = ApiKey.getSharedApiKey(api, apiOptions, apiFallbackAttributionTag);
            this.zag = sharedApiKey;
            this.zaj = new zabt(this);
            googleApiManagerZak = GoogleApiManager.zak(context3);
            this.zaa = googleApiManagerZak;
            this.zai = googleApiManagerZak.zaa();
            this.zak = settings.zaa;
            if (activity != null && !(activity instanceof GoogleApiActivity) && Looper.myLooper() == Looper.getMainLooper()) {
                zaad.zad(activity, googleApiManagerZak, sharedApiKey);
            }
            googleApiManagerZak.zaz(this);
        }
        context2 = context;
        apiFallbackAttributionTag = context2 != null ? getApiFallbackAttributionTag(context2) : null;
        this.zac = apiFallbackAttributionTag;
        if (Build.VERSION.SDK_INT >= 31) {
            attributionSourceWrapper = new AttributionSourceWrapper(context.getAttributionSource());
        }
        this.zad = attributionSourceWrapper;
        this.zae = api;
        this.zaf = apiOptions;
        this.zah = settings.zab;
        sharedApiKey = ApiKey.getSharedApiKey(api, apiOptions, apiFallbackAttributionTag);
        this.zag = sharedApiKey;
        this.zaj = new zabt(this);
        googleApiManagerZak = GoogleApiManager.zak(context3);
        this.zaa = googleApiManagerZak;
        this.zai = googleApiManagerZak.zaa();
        this.zak = settings.zaa;
        if (activity != null) {
            zaad.zad(activity, googleApiManagerZak, sharedApiKey);
        }
        googleApiManagerZak.zaz(this);
    }

    public <A extends Api.AnyClient> Task<Void> doRegisterEventListener(RegistrationMethods<A, ?> registrationMethods) {
        Preconditions.checkNotNull(registrationMethods);
        Preconditions.checkNotNull(registrationMethods.register.getListenerKey(), "Listener has already been released.");
        Preconditions.checkNotNull(registrationMethods.zaa.getListenerKey(), "Listener has already been released.");
        return this.zaa.zao(this, registrationMethods.register, registrationMethods.zaa, registrationMethods.zab);
    }

    public GoogleApi(Context context, Api<O> api, O o, Settings settings) {
        this(context, null, api, o, settings);
    }

    @Deprecated
    public GoogleApi(Context context, Api<O> api, O o, StatusExceptionMapper statusExceptionMapper) {
        Settings.Builder builder = new Settings.Builder();
        builder.setMapper(statusExceptionMapper);
        this(context, api, o, builder.build());
    }
}
