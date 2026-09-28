package com.google.android.gms.games.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.FriendsResolutionRequiredException;
import com.google.android.gms.games.GamesClientStatusCodes;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.internal.games_v2.zzfn;
import com.google.android.gms.signin.internal.SignInClientImpl;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzah extends GmsClient {
    public static final /* synthetic */ int zze = 0;
    private final com.google.android.gms.internal.games_v2.zzac zzf;
    private final String zzg;
    private PlayerEntity zzh;
    private final zzan zzi;
    private boolean zzj;
    private final long zzk;
    private final zzao zzl;
    private final com.google.android.gms.games.zzi zzm;

    public zzah(Context context, Looper looper, ClientSettings clientSettings, com.google.android.gms.games.zzi zziVar, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zzao zzaoVar) {
        super(context, looper, 1, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zzf = new zzj(this);
        this.zzj = false;
        this.zzg = clientSettings.getRealClientPackageName();
        this.zzl = (zzao) Preconditions.checkNotNull(zzaoVar);
        zzan zzanVarZzb = zzan.zzb(this, clientSettings.getGravityForPopups());
        this.zzi = zzanVarZzb;
        this.zzk = hashCode();
        this.zzm = zziVar;
        if (clientSettings.getViewForPopups() != null || (context instanceof Activity)) {
            zzanVarZzb.zzf(clientSettings.getViewForPopups());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzV(RemoteException remoteException) {
        zzfn.zzf("GamesGmsClientImpl", "service died", remoteException);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final void connect(BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        this.zzh = null;
        super.connect(connectionProgressReportCallbacks);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesService");
        return iInterfaceQueryLocalInterface instanceof zzam ? (zzam) iInterfaceQueryLocalInterface : new zzam(iBinder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final void disconnect() {
        this.zzj = false;
        if (isConnected()) {
            try {
                this.zzf.zzb();
                ((zzam) getService()).zzd(this.zzk);
            } catch (RemoteException unused) {
                zzfn.zze("GamesGmsClientImpl", "Failed to notify client disconnect.");
            }
        }
        super.disconnect();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Feature[] getApiFeatures() {
        return com.google.android.gms.games.zzd.zzj;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Bundle getConnectionHint() {
        return null;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final Bundle getGetServiceRequestExtraArgs() {
        String string = getContext().getResources().getConfiguration().locale.toString();
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.games.key.isHeadless", false);
        com.google.android.gms.games.zzi zziVar = this.zzm;
        boolean z = zziVar.zzb;
        bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", true);
        int i = zziVar.zzc;
        bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", 17);
        bundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", false);
        bundle.putInt("com.google.android.gms.games.key.sdkVariant", zziVar.zze);
        bundle.putString("com.google.android.gms.games.key.forceResolveAccountKey", null);
        bundle.putStringArrayList("com.google.android.gms.games.key.proxyApis", zziVar.zzg);
        bundle.putBoolean("com.google.android.gms.games.key.unauthenticated", false);
        bundle.putBoolean("com.google.android.gms.games.key.skipPgaCheck", false);
        bundle.putBoolean("com.google.android.gms.games.key.skipWelcomePopup", false);
        bundle.putString("com.google.android.gms.games.key.realClientPackageName", null);
        int i2 = zziVar.zzl;
        bundle.putInt("com.google.android.gms.games.key.API_VERSION", 9);
        bundle.putString("com.google.android.gms.games.key.gameRunToken", zziVar.zzm);
        bundle.putBoolean("com.google.android.gms.games.key.isGmsCoreUiInitiatedRequest", false);
        bundle.putString(ServiceSpecificExtraArgs.GamesExtraArgs.GAME_PACKAGE_NAME, this.zzg);
        bundle.putString(ServiceSpecificExtraArgs.GamesExtraArgs.DESIRED_LOCALE, string);
        bundle.putParcelable(ServiceSpecificExtraArgs.GamesExtraArgs.WINDOW_TOKEN, new BinderWrapper(this.zzi.zzd()));
        if (!bundle.containsKey("com.google.android.gms.games.key.API_VERSION")) {
            bundle.putInt("com.google.android.gms.games.key.API_VERSION", 9);
        }
        bundle.putBundle(ServiceSpecificExtraArgs.GamesExtraArgs.SIGNIN_OPTIONS, SignInClientImpl.createBundleFromClientSettings(getClientSettings()));
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.GmsClient, com.google.android.gms.common.api.Api.Client
    public final Set getScopesForConnectionlessNonSignIn() {
        return getScopes();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getServiceDescriptor() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServiceAction() {
        return "com.google.android.gms.games.service.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final /* bridge */ /* synthetic */ void onConnectedLocked(IInterface iInterface) {
        zzam zzamVar = (zzam) iInterface;
        super.onConnectedLocked(zzamVar);
        if (this.zzj) {
            this.zzi.zzg();
            this.zzj = false;
        }
        try {
            zzamVar.zzM(new zzk(new com.google.android.gms.internal.games_v2.zzaf(this.zzi.zze())), this.zzk);
        } catch (RemoteException e) {
            zzV(e);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        super.onConnectionFailed(connectionResult);
        this.zzj = false;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final void onPostInitHandler(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (i == 0) {
            i = 0;
            if (bundle != null) {
                bundle.setClassLoader(zzah.class.getClassLoader());
                this.zzj = bundle.getBoolean("show_welcome_popup");
                this.zzh = (PlayerEntity) bundle.getParcelable("com.google.android.gms.games.current_player");
            }
        }
        super.onPostInitHandler(i, iBinder, bundle, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final void onUserSignOut(BaseGmsClient.SignOutCallbacks signOutCallbacks) {
        try {
            zzl zzlVar = new zzl(signOutCallbacks);
            this.zzf.zzb();
            try {
                ((zzam) getService()).zze(new zzm(zzlVar));
            } catch (SecurityException unused) {
                zzlVar.setFailedResult(GamesClientStatusCodes.zza(4));
            }
        } catch (RemoteException unused2) {
            signOutCallbacks.onSignOutComplete();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final boolean requiresAccount() {
        return true;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final boolean requiresSignIn() {
        return !this.zzm.zzn.zzc();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final boolean usesClientTelemetry() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzA(TaskCompletionSource taskCompletionSource, String str, long j, String str2) throws RemoteException {
        try {
            ((zzam) getService()).zzs(new zzaf(taskCompletionSource), str, j, str2);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzB(TaskCompletionSource taskCompletionSource, boolean z) throws RemoteException {
        try {
            ((zzam) getService()).zzp(new zzp(taskCompletionSource), z);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzG(TaskCompletionSource taskCompletionSource, boolean z) throws RemoteException {
        this.zzf.zzb();
        try {
            ((zzam) getService()).zzH(new zzs(taskCompletionSource), z);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzH(TaskCompletionSource taskCompletionSource, boolean z, String... strArr) throws RemoteException {
        this.zzf.zzb();
        try {
            ((zzam) getService()).zzI(new zzs(taskCompletionSource), z, strArr);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzI(String str, int i) {
        this.zzf.zzc(str, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzJ(TaskCompletionSource taskCompletionSource, boolean z) throws RemoteException {
        try {
            ((zzam) getService()).zzO(new zzab(taskCompletionSource), z);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzK(TaskCompletionSource taskCompletionSource, boolean z) throws RemoteException {
        try {
            ((zzam) getService()).zzA(new zzaa(taskCompletionSource), z);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzL(TaskCompletionSource taskCompletionSource, String str, boolean z, int i) throws RemoteException {
        try {
            ((zzam) getService()).zzL(new zzag(taskCompletionSource), str, z, i);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzM(TaskCompletionSource taskCompletionSource, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) throws RemoteException {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        Preconditions.checkState(!snapshotContents.isClosed(), "Snapshot already closed");
        BitmapTeleporter bitmapTeleporterZza = snapshotMetadataChange.zza();
        if (bitmapTeleporterZza != null) {
            bitmapTeleporterZza.setTempDir(getContext().getCacheDir());
        }
        Contents contentsZza = snapshotContents.zza();
        snapshotContents.zzb();
        try {
            ((zzam) getService()).zzB(new zzq(taskCompletionSource), snapshot.getMetadata().getSnapshotId(), (SnapshotMetadataChangeEntity) snapshotMetadataChange, contentsZza);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzN(TaskCompletionSource taskCompletionSource, String str) throws RemoteException {
        try {
            ((zzam) getService()).zzD(new zzr(taskCompletionSource), str);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzO(TaskCompletionSource taskCompletionSource, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) throws RemoteException {
        Preconditions.checkState(!snapshotContents.isClosed(), "SnapshotContents already closed");
        BitmapTeleporter bitmapTeleporterZza = snapshotMetadataChange.zza();
        if (bitmapTeleporterZza != null) {
            bitmapTeleporterZza.setTempDir(getContext().getCacheDir());
        }
        Contents contentsZza = snapshotContents.zza();
        snapshotContents.zzb();
        try {
            ((zzam) getService()).zzE(new zzag(taskCompletionSource), str, str2, (SnapshotMetadataChangeEntity) snapshotMetadataChange, contentsZza);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    final void zzP(IBinder iBinder, Bundle bundle) {
        if (isConnected()) {
            if (this.zzm.zzn.zzb() && this.zzl.zzb()) {
                return;
            }
            try {
                ((zzam) getService()).zzf(iBinder, bundle);
                this.zzl.zzc();
            } catch (RemoteException e) {
                zzV(e);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    final void zzQ() {
        if (isConnected()) {
            try {
                ((zzam) getService()).zzg();
            } catch (RemoteException e) {
                zzV(e);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzR(TaskCompletionSource taskCompletionSource, String str, boolean z) throws RemoteException {
        ((zzam) getService()).zzS(new zzu(taskCompletionSource), str, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzS(TaskCompletionSource taskCompletionSource, String str, boolean z, List list) throws RemoteException {
        ((zzam) getService()).zzT(new zzv(taskCompletionSource), str, z, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ void zzT(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setException(FriendsResolutionRequiredException.zza(GamesClientStatusCodes.zzb(GamesClientStatusCodes.CONSENT_REQUIRED, ((zzam) getService()).zzQ())));
        } catch (RemoteException e) {
            taskCompletionSource.setException(e);
        }
    }

    public final void zzp(zzf zzfVar) {
        zzfVar.zzc(this.zzi);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Player zzq() throws RemoteException {
        checkConnected();
        synchronized (this) {
            if (this.zzh == null) {
                PlayerBuffer playerBuffer = new PlayerBuffer(((zzam) getService()).zzi());
                try {
                    if (playerBuffer.getCount() > 0) {
                        PlayerEntity playerEntity = new PlayerEntity(playerBuffer.get(0));
                        this.zzh = playerEntity;
                    }
                    playerBuffer.release();
                } catch (Throwable th) {
                    playerBuffer.release();
                    throw th;
                }
            }
        }
        return this.zzh;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzr(TaskCompletionSource taskCompletionSource, boolean z) throws RemoteException {
        try {
            ((zzam) getService()).zzK(new zzad(taskCompletionSource), null, z);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzs(TaskCompletionSource taskCompletionSource, String str, boolean z) throws RemoteException {
        try {
            ((zzam) getService()).zzK(new zzad(taskCompletionSource), str, z);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzt(TaskCompletionSource taskCompletionSource, String str, int i, boolean z, boolean z2) throws RemoteException {
        if (!str.equals("played_with") && !str.equals("friends_all")) {
            throw new IllegalArgumentException("Invalid player collection: ".concat(str));
        }
        try {
            ((zzam) getService()).zzy(new zzac(this, taskCompletionSource), str, i, z, z2);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzu(TaskCompletionSource taskCompletionSource, boolean z) throws RemoteException {
        try {
            ((zzam) getService()).zzq(new zzz(taskCompletionSource), z);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzv(TaskCompletionSource taskCompletionSource, String str, boolean z) throws RemoteException {
        try {
            ((zzam) getService()).zzr(new zzw(taskCompletionSource), str, z);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzw(TaskCompletionSource taskCompletionSource, String str, int i, int i2) throws RemoteException {
        try {
            ((zzam) getService()).zzu(new zzx(this, taskCompletionSource), null, str, i, i2);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzx(TaskCompletionSource taskCompletionSource, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        try {
            ((zzam) getService()).zzj(new zzy(this, taskCompletionSource), str, i, i2, i3, z);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzy(TaskCompletionSource taskCompletionSource, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        try {
            ((zzam) getService()).zzk(new zzy(this, taskCompletionSource), str, i, i2, i3, z);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzz(TaskCompletionSource taskCompletionSource, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) throws RemoteException {
        try {
            ((zzam) getService()).zzl(new zzy(this, taskCompletionSource), leaderboardScoreBuffer.zza().zza(), i, i2);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzC(TaskCompletionSource taskCompletionSource, String str) throws RemoteException {
        zzo zzoVar = taskCompletionSource == null ? null : new zzo(taskCompletionSource);
        try {
            zzam zzamVar = (zzam) getService();
            zzan zzanVar = this.zzi;
            zzamVar.zzm(zzoVar, str, zzanVar.zzd(), zzanVar.zzc());
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzD(TaskCompletionSource taskCompletionSource, String str) throws RemoteException {
        zzo zzoVar = taskCompletionSource == null ? null : new zzo(taskCompletionSource);
        try {
            zzam zzamVar = (zzam) getService();
            zzan zzanVar = this.zzi;
            zzamVar.zzn(zzoVar, str, zzanVar.zzd(), zzanVar.zzc());
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzE(TaskCompletionSource taskCompletionSource, String str, int i) throws RemoteException {
        zzn zznVar = taskCompletionSource == null ? null : new zzn(taskCompletionSource);
        try {
            zzam zzamVar = (zzam) getService();
            zzan zzanVar = this.zzi;
            zzamVar.zzo(zznVar, str, i, zzanVar.zzd(), zzanVar.zzc());
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzF(TaskCompletionSource taskCompletionSource, String str, int i) throws RemoteException {
        zzn zznVar = taskCompletionSource == null ? null : new zzn(taskCompletionSource);
        try {
            zzam zzamVar = (zzam) getService();
            zzan zzanVar = this.zzi;
            zzamVar.zzt(zznVar, str, i, zzanVar.zzd(), zzanVar.zzc());
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }
}
