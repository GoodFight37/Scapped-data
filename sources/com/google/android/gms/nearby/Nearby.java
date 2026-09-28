package com.google.android.gms.nearby;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.nearby.zzax;
import com.google.android.gms.internal.nearby.zzi;
import com.google.android.gms.internal.nearby.zzih;
import com.google.android.gms.internal.nearby.zzji;
import com.google.android.gms.internal.nearby.zzl;
import com.google.android.gms.internal.nearby.zzrs;
import com.google.android.gms.internal.nearby.zzry;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.nearby.connection.ConnectionsClient;
import com.google.android.gms.nearby.connection.ConnectionsOptions;
import com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient;
import com.google.android.gms.nearby.messages.Messages;
import com.google.android.gms.nearby.messages.MessagesClient;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.internal.zzbh;
import com.google.android.gms.nearby.messages.internal.zzbx;
import com.google.android.gms.nearby.messages.internal.zzby;
import com.google.android.gms.nearby.messages.zzc;
import com.google.android.gms.nearby.uwb.UwbClient;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class Nearby {

    @Deprecated
    public static final Api<ConnectionsOptions> CONNECTIONS_API = new Api<>("Nearby.CONNECTIONS_API", zzji.zzb, zzji.zza);

    @Deprecated
    public static final Connections Connections = new zzji();

    @Deprecated
    public static final Api<MessagesOptions> MESSAGES_API = new Api<>("Nearby.MESSAGES_API", zzbx.zzc, zzbx.zzb);

    @Deprecated
    public static final Messages Messages = zzbx.zza;
    public static final zzc zza = new zzby();

    @Deprecated
    public static final Api zzb = new Api("Nearby.BOOTSTRAP_API", zzl.zzb, zzl.zza);

    @Deprecated
    public static final zzi zzc = new zzl();

    private Nearby() {
    }

    public static final ConnectionsClient getConnectionsClient(Activity activity) {
        Preconditions.checkNotNull(activity, "Activity must not be null");
        return zzih.zza(activity, null);
    }

    public static ExposureNotificationClient getExposureNotificationClient(Context context) {
        Preconditions.checkNotNull(context, "Context must not be null");
        return new zzax(context);
    }

    public static final MessagesClient getMessagesClient(Activity activity) {
        Preconditions.checkNotNull(activity, "Activity must not be null");
        return new zzbh(activity, (MessagesOptions) null);
    }

    public static UwbClient getUwbControleeClient(Context context) {
        Preconditions.checkNotNull(context, "Context must not be null");
        com.google.android.gms.nearby.uwb.zzc zzcVar = new com.google.android.gms.nearby.uwb.zzc();
        zzcVar.zza(2);
        return new zzrs(context, zzcVar.zzb());
    }

    public static UwbClient getUwbControllerClient(Context context) {
        Preconditions.checkNotNull(context, "Context must not be null");
        com.google.android.gms.nearby.uwb.zzc zzcVar = new com.google.android.gms.nearby.uwb.zzc();
        zzcVar.zza(1);
        return new zzrs(context, zzcVar.zzb());
    }

    public static boolean zza(Context context) {
        if (Wrappers.packageManager(context).checkCallingOrSelfPermission("com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
            return zzry.zzb(context.getContentResolver(), "gms:nearby:requires_gms_check", true);
        }
        return true;
    }

    public static final ConnectionsClient getConnectionsClient(Context context) {
        Preconditions.checkNotNull(context, "Context must not be null");
        return zzih.zzb(context, null);
    }

    public static final MessagesClient getMessagesClient(Activity activity, MessagesOptions messagesOptions) {
        Preconditions.checkNotNull(activity, "Activity must not be null");
        Preconditions.checkNotNull(messagesOptions, "Options must not be null");
        return new zzbh(activity, messagesOptions);
    }

    public static final MessagesClient getMessagesClient(Context context) {
        Preconditions.checkNotNull(context, "Context must not be null");
        return new zzbh(context, (MessagesOptions) null);
    }

    public static final MessagesClient getMessagesClient(Context context, MessagesOptions messagesOptions) {
        Preconditions.checkNotNull(context, "Context must not be null");
        Preconditions.checkNotNull(messagesOptions, "Options must not be null");
        return new zzbh(context, messagesOptions);
    }
}
