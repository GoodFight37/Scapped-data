package com.unity3d.player;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.InputEvent;
import android.view.OrientationEventListener;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import android.widget.FrameLayout;
import com.adjust.sdk.Constants;
import com.unity3d.player.a.AbstractC0082o;
import com.unity3d.player.a.AbstractC0086t;
import com.unity3d.player.a.C0076i;
import com.unity3d.player.a.C0087u;
import com.unity3d.player.a.C0089w;
import com.unity3d.player.a.C0091y;
import com.unity3d.player.a.EnumC0084q;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.fmod.FmodAndroidAudioManager;

/* JADX INFO: loaded from: classes2.dex */
public abstract class UnityPlayer implements IUnityPlayerLifecycleEvents {
    private static final String ARCORE_ENABLE_METADATA_NAME = "unity.arcore-enable";
    private static final String AUTO_REPORT_FULLY_DRAWN_ENABLE_METADATA_NAME = "unity.auto-report-fully-drawn";
    private static final String AUTO_SET_GAME_STATE_ENABLE_METADATA_NAME = "unity.auto-set-game-state";
    private static final String LAUNCH_FULLSCREEN = "unity.launch-fullscreen";
    private static final String RUN_WITHOUT_FOCUS = "unity.run-without-focus";
    private static final String SPLASH_ENABLE_METADATA_NAME = "unity.splash-enable";
    private static final String SPLASH_MODE_METADATA_NAME = "unity.splash-mode";
    public static Activity currentActivity;
    public static Context currentContext;
    Activity mActivity;
    Context mContext;
    private EnumC0084q mContextType;
    private int mInitialScreenOrientation;
    int mNaturalOrientation;
    boolean mQuitting;
    private com.unity3d.player.a.Y mVideoPlayerProxy;
    private ClipboardManager m_ClipboardManager;
    private FrameLayout m_FrameLayout;
    private HashMap m_PermissionRequests;
    private com.unity3d.player.a.J m_SplashScreen;
    TelephonyManager m_TelephonyManager;
    protected IUnityPlayerLifecycleEvents m_UnityPlayerLifecycleEvents;
    Window m_Window;
    private Configuration prevConfig;
    Handler mHandler = new Handler();
    private boolean mIsFullscreen = true;
    com.unity3d.player.a.Q mState = new com.unity3d.player.a.Q();
    private OrientationEventListener mOrientationListener = null;
    boolean m_AddPhoneCallListener = false;
    C0112k0 m_PhoneCallListener = new C0112k0(this);
    private GoogleARCoreApi m_ARCoreApi = null;
    private C0106h0 m_FakeListener = new C0106h0();
    private Camera2Wrapper m_Camera2Wrapper = null;
    private HFPStatus m_HFPStatus = null;
    private AudioVolumeHandler m_AudioVolumeHandler = null;
    private OrientationLockListener m_OrientationLockListener = null;
    private FmodAndroidAudioManager m_FmodAndroidAudioManager = null;
    private C0087u m_NetworkConnectivity = null;
    private C0091y m_OnBackPressedDispatcher = null;
    private com.unity3d.player.a.O m_Cursor = null;
    private UnityAccessibilityDelegate m_AccessibilityDelegate = null;
    private boolean m_DeferredPauseForRunWithoutFocus = false;
    private final ConcurrentLinkedQueue m_MainThreadJobs = new ConcurrentLinkedQueue();
    private Thread m_UIThread = Thread.currentThread();
    volatile boolean m_RunWithoutFocus = getMetaDataValue(RUN_WITHOUT_FOCUS);

    private void developmentPlayerInitialize() {
    }

    private final native void initJni(Context context, int i);

    private final native void nativeApplicationUnload();

    private final native void nativeHidePreservedContent();

    private final native boolean nativeInjectEvent(InputEvent inputEvent);

    /* JADX INFO: Access modifiers changed from: private */
    public final native boolean nativeIsAutorotationOn();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeMuteMasterAudio(boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetLaunchURL(String str);

    private static native void nativeUnitySendMessage(String str, String str2, byte[] bArr);

    static native void permissionResponseToNative(long j, boolean z);

    abstract void cleanupResourcesForDestroy();

    public abstract SurfaceView getSurfaceView();

    public abstract View getView();

    abstract boolean handleFocus(boolean z);

    abstract void hidePreservedContent();

    abstract void onOrientationChanged(int i, int i2);

    @Override // com.unity3d.player.IUnityPlayerLifecycleEvents
    public void onUnityPlayerQuitted() {
    }

    @Override // com.unity3d.player.IUnityPlayerLifecycleEvents
    public void onUnityPlayerUnloaded() {
    }

    public abstract boolean runningOnMainThread();

    public abstract void setMainSurfaceViewAspectRatio(float f);

    public static void UnitySendMessage(String str, String str2, String str3) {
        byte[] bytes;
        if (!com.unity3d.player.a.Q.e) {
            AbstractC0086t.Log(5, "Native libraries not loaded - dropping message for " + str + "." + str2);
            return;
        }
        if (str3 == null) {
            bytes = null;
        } else {
            try {
                bytes = str3.getBytes(Constants.ENCODING);
            } catch (UnsupportedEncodingException unused) {
                return;
            }
        }
        nativeUnitySendMessage(str, str2, bytes);
    }

    private static void unloadNative() {
        if (com.unity3d.player.a.Q.e) {
            if (NativeLoader.unload()) {
                com.unity3d.player.a.Q.e = false;
                return;
            }
            throw new UnsatisfiedLinkError("Unable to unload libraries from libmain.so");
        }
    }

    public boolean injectEvent(InputEvent inputEvent) {
        if (com.unity3d.player.a.Q.e) {
            return nativeInjectEvent(inputEvent);
        }
        return false;
    }

    public void invokeOnMainThread(Runnable runnable) {
        if (com.unity3d.player.a.Q.e) {
            if (runningOnUIThread() || !runningOnMainThread()) {
                this.m_MainThreadJobs.add(runnable);
            } else {
                runnable.run();
            }
        }
    }

    boolean isNativeInitialized() {
        return com.unity3d.player.a.Q.e && this.mState.d;
    }

    public abstract class a implements Runnable {
        public abstract void a();

        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (UnityPlayer.this.isFinishing()) {
                return;
            }
            a();
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    Activity getActivity() {
        return this.mActivity;
    }

    EnumC0084q getContextType() {
        return this.mContextType;
    }

    protected UnityPlayer(Context context, EnumC0084q enumC0084q, IUnityPlayerLifecycleEvents iUnityPlayerLifecycleEvents) {
        String strSubstring;
        this.mInitialScreenOrientation = -1;
        this.m_UnityPlayerLifecycleEvents = null;
        this.mContext = context;
        this.mContextType = enumC0084q;
        this.m_UnityPlayerLifecycleEvents = iUnityPlayerLifecycleEvents == null ? this : iUnityPlayerLifecycleEvents;
        String unityNativeLibraryPath = getUnityNativeLibraryPath(context);
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler instanceof com.unity3d.player.a.P) {
            com.unity3d.player.a.P p = (com.unity3d.player.a.P) defaultUncaughtExceptionHandler;
            int i = -1;
            int i2 = -1;
            while (true) {
                int iIndexOf = unityNativeLibraryPath.indexOf(47, i + 1);
                if (iIndexOf == -1) {
                    break;
                }
                i2 = i;
                i = iIndexOf;
            }
            if (i2 < 0) {
                strSubstring = "Unknown";
            } else {
                strSubstring = unityNativeLibraryPath.substring(i2 + 1);
            }
            p.b = strSubstring;
        }
        currentContext = context;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            this.mActivity = activity;
            currentActivity = activity;
            this.mInitialScreenOrientation = activity.getRequestedOrientation();
        }
    }

    protected void initialize(FrameLayout frameLayout) {
        this.m_FrameLayout = frameLayout;
        EarlyEnableFullScreenIfEnabled();
        Configuration configuration = getFrameLayout().getResources().getConfiguration();
        this.prevConfig = configuration;
        this.mNaturalOrientation = getNaturalOrientation(configuration.orientation);
        if (this.mActivity != null && getSplashEnabled()) {
            com.unity3d.player.a.J j = new com.unity3d.player.a.J(this.mContext, AbstractC0082o.b(3)[getSplashMode()]);
            this.m_SplashScreen = j;
            this.m_FrameLayout.addView(j);
            this.m_FrameLayout.bringChildToFront(this.m_SplashScreen);
        }
        preloadJavaPlugins();
        String strLoadNative = loadNative(getUnityNativeLibraryPath(this.mContext));
        if (!com.unity3d.player.a.Q.e) {
            AbstractC0086t.Log(6, "Your hardware does not support this application.");
            AlertDialog alertDialogCreate = new AlertDialog.Builder(this.mContext).setTitle("Failure to initialize!").setPositiveButton("OK", new Y(this)).setMessage("Your hardware does not support this application.\n\n" + strLoadNative + "\n\n Press OK to quit.").create();
            alertDialogCreate.setCancelable(false);
            alertDialogCreate.show();
            return;
        }
        initJni(this.mContext, this.mContextType.f1085a);
        this.mState.d = true;
        this.mQuitting = false;
        developmentPlayerInitialize();
        hideStatusBar();
        this.m_TelephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
        this.m_ClipboardManager = (ClipboardManager) this.mContext.getSystemService("clipboard");
        this.m_Camera2Wrapper = new Camera2Wrapper(this.mContext);
        this.m_HFPStatus = new HFPStatus(this.mContext);
        this.m_Cursor = new com.unity3d.player.a.O(this);
        FmodAndroidAudioManager fmodAndroidAudioManager = FmodAndroidAudioManager.getInstance();
        this.m_FmodAndroidAudioManager = fmodAndroidAudioManager;
        fmodAndroidAudioManager.setActivity(this.mActivity);
        this.m_OnBackPressedDispatcher = C0117n.a(getContext(), 1, new Z(this));
        Activity activity = this.mActivity;
        if (activity != null) {
            this.m_Window = activity.getWindow();
        }
    }

    private int getNaturalOrientation(int i) {
        int rotation = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getRotation();
        if ((rotation == 0 || rotation == 2) && i == 2) {
            return 0;
        }
        return ((rotation == 1 || rotation == 3) && i == 1) ? 0 : 1;
    }

    protected void toggleGyroscopeSensor(boolean z) {
        SensorManager sensorManager = (SensorManager) this.mContext.getSystemService("sensor");
        Sensor defaultSensor = sensorManager.getDefaultSensor(11);
        if (z) {
            sensorManager.registerListener(this.m_FakeListener, defaultSensor, 1);
        } else {
            sensorManager.unregisterListener(this.m_FakeListener);
        }
    }

    private String GetGlViewContentDescription(Context context) {
        return context.getResources().getString(context.getResources().getIdentifier("game_view_content_description", "string", context.getPackageName()));
    }

    void disableStaticSplashScreen() {
        runOnUiThread(new RunnableC0092a0(this));
    }

    private void EarlyEnableFullScreenIfEnabled() {
        View decorView;
        Activity activity = this.mActivity;
        if (activity != null && activity.getWindow() != null && ((getLaunchFullscreen() || this.mActivity.getIntent().getBooleanExtra("android.intent.extra.VR_LAUNCH", false)) && (decorView = this.mActivity.getWindow().getDecorView()) != null)) {
            decorView.setSystemUiVisibility(7);
        }
        AbstractC0111k.b(this.mActivity);
    }

    private boolean isWindowTranslucent() {
        Activity activity = this.mActivity;
        if (activity == null) {
            return false;
        }
        TypedArray typedArrayObtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{android.R.attr.windowIsTranslucent});
        boolean z = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z;
    }

    protected void applySurfaceViewSettings(SurfaceView surfaceView) {
        if (isWindowTranslucent()) {
            surfaceView.getHolder().setFormat(-3);
            surfaceView.setZOrderOnTop(true);
        } else {
            surfaceView.getHolder().setFormat(-1);
        }
    }

    void finish() {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        this.mActivity.finish();
    }

    void runOnAnonymousThread(Runnable runnable) {
        new Thread(runnable).start();
    }

    void runOnUiThread(Runnable runnable) {
        Activity activity = this.mActivity;
        if (activity != null) {
            activity.runOnUiThread(runnable);
        } else if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.mHandler.post(runnable);
        } else {
            runnable.run();
        }
    }

    void postOnUiThread(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    public void newIntent(Intent intent) {
        setLaunchURL(intent.getData());
    }

    public void destroy() {
        Camera2Wrapper camera2Wrapper = this.m_Camera2Wrapper;
        if (camera2Wrapper != null) {
            camera2Wrapper.closeCamera2();
            this.m_Camera2Wrapper = null;
        }
        HFPStatus hFPStatus = this.m_HFPStatus;
        if (hFPStatus != null) {
            hFPStatus.b();
            this.m_HFPStatus = null;
        }
        FmodAndroidAudioManager fmodAndroidAudioManager = this.m_FmodAndroidAudioManager;
        if (fmodAndroidAudioManager != null) {
            fmodAndroidAudioManager.setActivity(null);
        }
        C0087u c0087u = this.m_NetworkConnectivity;
        if (c0087u != null) {
            c0087u.a();
            this.m_NetworkConnectivity = null;
        }
        C0091y c0091y = this.m_OnBackPressedDispatcher;
        if (c0091y != null) {
            c0091y.unregisterOnBackPressedCallback();
            this.m_OnBackPressedDispatcher = null;
        }
        this.mQuitting = true;
        if (!this.mState.c) {
            setupUnityToBePaused();
        }
        cleanupResourcesForDestroy();
        unloadNative();
    }

    protected void kill() {
        AbstractC0086t.Log(4, "Quitting process");
        Process.killProcess(Process.myPid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldRunWithoutFocus() {
        return MultiWindowSupport.isInMultiWindowMode(this.mActivity) || this.m_RunWithoutFocus;
    }

    public void onStop() {
        if (shouldRunWithoutFocus()) {
            setupUnityToBePaused();
        }
    }

    public void onStart() {
        if (shouldRunWithoutFocus()) {
            setupUnityToBeResumed();
        }
    }

    public void onPause() {
        MultiWindowSupport.saveMultiWindowMode(this.mActivity);
        if (shouldRunWithoutFocus()) {
            this.m_DeferredPauseForRunWithoutFocus = true;
        } else {
            setupUnityToBePaused();
        }
    }

    public void onResume() {
        this.m_DeferredPauseForRunWithoutFocus = false;
        com.unity3d.player.a.Q q = this.mState;
        if (!q.b || q.c) {
            setupUnityToBeResumed();
        }
    }

    void handleDeferredPauseOnSurfaceDestroyed() {
        if (this.m_DeferredPauseForRunWithoutFocus) {
            setupUnityToBePaused();
        }
    }

    public void pause() {
        setupUnityToBePaused();
    }

    protected void setupUnityToBePaused() {
        this.m_DeferredPauseForRunWithoutFocus = false;
        GoogleARCoreApi googleARCoreApi = this.m_ARCoreApi;
        if (googleARCoreApi != null) {
            googleARCoreApi.pauseARCore();
        }
        com.unity3d.player.a.Y y = this.mVideoPlayerProxy;
        if (y != null) {
            y.e.lock();
            S0 s0 = y.f;
            if (s0 != null) {
                if (y.g == 0) {
                    s0.cancelOnPrepare();
                } else if (y.i) {
                    boolean z = s0.t;
                    y.h = z;
                    if (!z) {
                        s0.pause();
                    }
                }
            }
            y.e.unlock();
        }
        AudioVolumeHandler audioVolumeHandler = this.m_AudioVolumeHandler;
        if (audioVolumeHandler != null) {
            C0076i c0076i = audioVolumeHandler.f1011a;
            if (c0076i.c != null) {
                c0076i.f1077a.getContentResolver().unregisterContentObserver(c0076i.c);
                c0076i.c = null;
            }
            audioVolumeHandler.f1011a = null;
            this.m_AudioVolumeHandler = null;
        }
        OrientationLockListener orientationLockListener = this.m_OrientationLockListener;
        if (orientationLockListener != null) {
            com.unity3d.player.a.L l = orientationLockListener.f1032a;
            if (l.b != null) {
                l.f1060a.getContentResolver().unregisterContentObserver(l.b);
                l.b = null;
            }
            orientationLockListener.f1032a = null;
            this.m_OrientationLockListener = null;
        }
        C0091y c0091y = this.m_OnBackPressedDispatcher;
        if (c0091y != null) {
            c0091y.c = c0091y.f1091a != null;
            c0091y.unregisterOnBackPressedCallback();
        }
        if (canPauseUnity()) {
            pauseUnity();
        }
    }

    protected boolean canPauseUnity() {
        com.unity3d.player.a.Q q = this.mState;
        return q.b || !q.c;
    }

    void pauseUnity() {
        com.unity3d.player.a.Q q = this.mState;
        q.b = false;
        q.c = true;
    }

    protected boolean canResumeUnity() {
        boolean zShouldRunWithoutFocus = this.mActivity != null ? shouldRunWithoutFocus() : false;
        com.unity3d.player.a.Q q = this.mState;
        if (!com.unity3d.player.a.Q.e) {
            q.getClass();
        } else if ((zShouldRunWithoutFocus || q.f1065a) && !q.c && !q.b) {
            return true;
        }
        return false;
    }

    void resumeUnity() {
        this.mState.b = true;
    }

    public void resume() {
        setupUnityToBeResumed();
    }

    protected void setupUnityToBeResumed() {
        GoogleARCoreApi googleARCoreApi = this.m_ARCoreApi;
        if (googleARCoreApi != null) {
            googleARCoreApi.resumeARCore();
        }
        this.mState.c = false;
        com.unity3d.player.a.Y y = this.mVideoPlayerProxy;
        if (y != null) {
            y.e.lock();
            S0 s0 = y.f;
            if (s0 != null && y.i && !y.h) {
                s0.start();
            }
            y.e.unlock();
        }
        if (canResumeUnity()) {
            resumeUnity();
        }
        if (this.m_AudioVolumeHandler == null) {
            this.m_AudioVolumeHandler = new AudioVolumeHandler(this.mContext);
        }
        if (this.m_OrientationLockListener == null && com.unity3d.player.a.Q.e) {
            this.m_OrientationLockListener = new OrientationLockListener(this.mContext);
        }
        C0091y c0091y = this.m_OnBackPressedDispatcher;
        if (c0091y == null || !c0091y.c) {
            return;
        }
        c0091y.registerOnBackPressedCallback();
    }

    void shutdown() {
        this.mState.d = false;
    }

    public void unload() {
        nativeApplicationUnload();
    }

    protected boolean skipPermissionsDialog() {
        Activity activity = this.mActivity;
        if (activity != null) {
            return UnityPermissions.skipPermissionsDialog(activity);
        }
        return false;
    }

    private void requestUserAuthorization(String str, long j) {
        Activity activity;
        if (str == null || str.isEmpty() || (activity = this.mActivity) == null) {
            return;
        }
        UnityPermissions.requestUserPermissions(activity, new String[]{str}, j != 0 ? new C0110j0(j, this) : null);
    }

    public synchronized void addPermissionRequest(PermissionRequest permissionRequest) {
        Integer numValueOf;
        if (this.m_PermissionRequests == null) {
            this.m_PermissionRequests = new HashMap();
        }
        int i = 1;
        while (true) {
            numValueOf = Integer.valueOf(i);
            if (!this.m_PermissionRequests.containsKey(numValueOf)) {
                break;
            } else {
                i++;
            }
        }
        this.m_PermissionRequests.put(numValueOf, permissionRequest);
        if (this.m_PermissionRequests.size() == 1) {
            requestPermissionsFromActivity(permissionRequest.getPermissionNames(), i);
        }
    }

    public void requestPermissionsFromActivity(String[] strArr, int i) {
        this.mActivity.requestPermissions(strArr, i);
    }

    public synchronized void triggerNextPermissionRequest() {
        Iterator it;
        HashMap map = this.m_PermissionRequests;
        if (map == null || (it = map.entrySet().iterator()) == null || !it.hasNext()) {
            return;
        }
        Map.Entry entry = (Map.Entry) it.next();
        requestPermissionsFromActivity(((PermissionRequest) entry.getValue()).getPermissionNames(), ((Integer) entry.getKey()).intValue());
    }

    public synchronized void permissionResponse(Activity activity, int i, String[] strArr, int[] iArr) {
        int i2;
        if (this.m_PermissionRequests != null) {
            Integer numValueOf = Integer.valueOf(i);
            PermissionRequest permissionRequest = (PermissionRequest) this.m_PermissionRequests.get(numValueOf);
            if (permissionRequest != null) {
                this.m_PermissionRequests.remove(numValueOf);
                String[] permissionNames = permissionRequest.getPermissionNames();
                int[] iArr2 = new int[permissionNames.length];
                for (int i3 = 0; i3 < strArr.length; i3++) {
                    String str = strArr[i3];
                    int i4 = 0;
                    while (true) {
                        if (i4 >= permissionNames.length) {
                            i4 = -1;
                            break;
                        } else if (str.equals(permissionNames[i4])) {
                            break;
                        } else {
                            i4++;
                        }
                    }
                    if (i4 < 0) {
                        AbstractC0086t.Log(6, "Permission not found in request: " + str);
                    } else {
                        if (iArr[i3] == 0) {
                            i2 = 1;
                        } else {
                            i2 = (Build.VERSION.SDK_INT < 30 && !UnityPermissions.shouldShowRequestPermissionRationale(activity, str)) ? 3 : 2;
                        }
                        iArr2[i4] = i2;
                    }
                }
                invokeOnMainThread(new RunnableC0094b0(permissionRequest, permissionNames, iArr2));
                triggerNextPermissionRequest();
            }
        }
    }

    protected int getNetworkConnectivity() {
        C0087u c0087u = this.m_NetworkConnectivity;
        if (c0087u != null) {
            return c0087u.b();
        }
        if (PlatformSupport.NOUGAT_SUPPORT) {
            this.m_NetworkConnectivity = new C0089w(this.mContext);
        } else {
            this.m_NetworkConnectivity = new C0087u(this.mContext);
        }
        return this.m_NetworkConnectivity.b();
    }

    protected void setAccessibilityDelegate(UnityAccessibilityDelegate unityAccessibilityDelegate) {
        this.m_AccessibilityDelegate = unityAccessibilityDelegate;
    }

    public void configurationChanged(Configuration configuration) {
        int iDiff = this.prevConfig.diff(configuration);
        if ((iDiff & 256) != 0 || (iDiff & 1024) != 0 || (iDiff & 2048) != 0 || (iDiff & 128) != 0) {
            nativeHidePreservedContent();
        }
        this.prevConfig = new Configuration(configuration);
        com.unity3d.player.a.Y y = this.mVideoPlayerProxy;
        if (y != null) {
            y.e.lock();
            S0 s0 = y.f;
            if (s0 != null) {
                s0.updateVideoLayout();
            }
            y.e.unlock();
        }
        UnityAccessibilityDelegate unityAccessibilityDelegate = this.m_AccessibilityDelegate;
        if (unityAccessibilityDelegate != null) {
            unityAccessibilityDelegate.a(configuration);
        }
    }

    public void windowFocusChanged(boolean z) {
        saveFocusState(z);
        if (handleFocus(z) && canResumeUnity()) {
            resumeUnity();
        }
    }

    protected void saveFocusState(boolean z) {
        this.mState.f1065a = z;
    }

    public void setRunWithoutFocus(boolean z) {
        runOnUiThread(new RunnableC0096c0(this, z));
    }

    protected boolean loadLibrary(String str) {
        try {
            System.loadLibrary(str);
            return true;
        } catch (Exception | UnsatisfiedLinkError unused) {
            return false;
        }
    }

    protected void addPhoneCallListener() {
        this.m_AddPhoneCallListener = true;
        this.m_TelephonyManager.listen(this.m_PhoneCallListener, 32);
    }

    static {
        com.unity3d.player.a.P p = new com.unity3d.player.a.P();
        synchronized (p) {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (defaultUncaughtExceptionHandler == p) {
                return;
            }
            p.f1064a = defaultUncaughtExceptionHandler;
            p.b = "Unknown";
            Thread.setDefaultUncaughtExceptionHandler(p);
        }
    }

    private static String logLoadLibMainError(String str, String str2) {
        String str3 = "Failed to load 'libmain.so'\n\n" + str2;
        AbstractC0086t.Log(6, str3);
        return str3;
    }

    private static void preloadJavaPlugins() {
        try {
            Class.forName("com.unity3d.JavaPluginPreloader");
        } catch (ClassNotFoundException unused) {
        } catch (LinkageError e) {
            AbstractC0086t.Log(6, "Java class preloading failed: " + e.getMessage());
        }
    }

    private static String loadNative(String str) {
        String str2 = str + "/libmain.so";
        try {
            try {
                try {
                    System.load(str2);
                } catch (UnsatisfiedLinkError unused) {
                    System.loadLibrary("main");
                }
                if (NativeLoader.load(str)) {
                    com.unity3d.player.a.Q.e = true;
                    return "";
                }
                AbstractC0086t.Log(6, "NativeLoader.load failure, Unity libraries were not loaded.");
                return "NativeLoader.load failure, Unity libraries were not loaded.";
            } catch (UnsatisfiedLinkError e) {
                return logLoadLibMainError(str2, e.toString());
            }
        } catch (SecurityException e2) {
            return logLoadLibMainError(str2, e2.toString());
        }
    }

    private static String getUnityNativeLibraryPath(Context context) {
        return context.getApplicationInfo().nativeLibraryDir;
    }

    protected void setClipboardText(String str) {
        this.m_ClipboardManager.setPrimaryClip(ClipData.newPlainText("Text", str));
    }

    protected String getClipboardText() {
        ClipData primaryClip = this.m_ClipboardManager.getPrimaryClip();
        return primaryClip != null ? primaryClip.getItemAt(0).coerceToText(this.mContext).toString() : "";
    }

    protected String getLaunchURL() {
        Uri data;
        Activity activity = this.mActivity;
        if (activity == null || (data = activity.getIntent().getData()) == null) {
            return null;
        }
        return data.toString();
    }

    void setLaunchURL(Uri uri) {
        invokeOnMainThread(new RunnableC0098d0(uri != null ? uri.toString() : null));
    }

    protected boolean initializeGoogleAr() {
        if (this.m_ARCoreApi != null || this.mActivity == null || !getARCoreEnabled()) {
            return false;
        }
        GoogleARCoreApi googleARCoreApi = new GoogleARCoreApi();
        this.m_ARCoreApi = googleARCoreApi;
        googleARCoreApi.initializeARCore(this.mActivity);
        if (this.mState.c) {
            return false;
        }
        this.m_ARCoreApi.resumeARCore();
        return false;
    }

    protected boolean showVideoPlayer(String str, int i, int i2, int i3, boolean z, int i4, int i5) {
        if (this.mVideoPlayerProxy == null) {
            this.mVideoPlayerProxy = new com.unity3d.player.a.Y(this);
        }
        com.unity3d.player.a.Y y = this.mVideoPlayerProxy;
        Context context = this.mContext;
        C0100e0 c0100e0 = new C0100e0(this);
        y.e.lock();
        y.c = c0100e0;
        y.b = context;
        y.d.drainPermits();
        y.g = 2;
        y.runOnUiThread(new com.unity3d.player.a.U(y, str, i, i2, i3, z, i4, i5));
        boolean z2 = false;
        try {
            y.e.unlock();
            y.d.acquire();
            y.e.lock();
            if (y.g != 2) {
                z2 = true;
            }
        } catch (InterruptedException unused) {
        }
        y.runOnUiThread(new com.unity3d.player.a.V(y));
        if (z2 && y.g != 3) {
            y.runOnUiThread(new com.unity3d.player.a.W(y));
        } else {
            y.runOnUiThread(new com.unity3d.player.a.X(y));
        }
        y.e.unlock();
        if (z2) {
            runOnUiThread(new RunnableC0102f0(this));
        }
        return z2;
    }

    protected boolean isUaaLUseCase() {
        String callingPackage;
        Activity activity = this.mActivity;
        return (activity == null || (callingPackage = activity.getCallingPackage()) == null || !callingPackage.equals(this.mContext.getPackageName())) ? false : true;
    }

    protected int getUaaLLaunchProcessType() {
        String processName = getProcessName();
        return (processName == null || processName.equals(this.mContext.getPackageName())) ? 0 : 1;
    }

    private String getProcessName() {
        int iMyPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.mContext.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == iMyPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    ApplicationInfo getApplicationInfo() {
        return this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 128);
    }

    private ActivityInfo getActivityInfo() {
        return this.mActivity.getPackageManager().getActivityInfo(this.mActivity.getComponentName(), 128);
    }

    boolean getMetaDataValue(String str) {
        try {
            return getApplicationInfo().metaData.getBoolean(str);
        } catch (Exception unused) {
            return false;
        }
    }

    boolean getSplashEnabled() {
        try {
            return getApplicationInfo().metaData.getBoolean(SPLASH_ENABLE_METADATA_NAME);
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean getARCoreEnabled() {
        try {
            return getApplicationInfo().metaData.getBoolean(ARCORE_ENABLE_METADATA_NAME);
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean getLaunchFullscreen() {
        try {
            return getApplicationInfo().metaData.getBoolean(LAUNCH_FULLSCREEN);
        } catch (Exception unused) {
            return false;
        }
    }

    protected int getSplashMode() {
        try {
            return getApplicationInfo().metaData.getInt(SPLASH_MODE_METADATA_NAME);
        } catch (Exception unused) {
            return 0;
        }
    }

    boolean getAutoSetGameStateEnabled() {
        try {
            return getApplicationInfo().metaData.getBoolean(AUTO_SET_GAME_STATE_ENABLE_METADATA_NAME);
        } catch (Exception unused) {
            return false;
        }
    }

    boolean shouldSetGameState() {
        return (!PlatformSupport.TIRAMISU_SUPPORT || this.mActivity == null || isUaaLUseCase() || !getAutoSetGameStateEnabled() || UnityGameManager.getGameManager(currentContext) == null) ? false : true;
    }

    boolean getAutoReportFullyDrawnEnabled() {
        try {
            return getApplicationInfo().metaData.getBoolean(AUTO_REPORT_FULLY_DRAWN_ENABLE_METADATA_NAME);
        } catch (Exception unused) {
            return false;
        }
    }

    boolean shouldReportFullyDrawn() {
        if (this.mActivity == null) {
            return false;
        }
        return getAutoReportFullyDrawnEnabled();
    }

    void reportFullyDrawn() {
        this.mActivity.reportFullyDrawn();
    }

    protected void disableLogger() {
        AbstractC0086t.f1087a = true;
    }

    protected boolean isFinishing() {
        if (this.mQuitting) {
            return true;
        }
        Activity activity = this.mActivity;
        if (activity != null) {
            this.mQuitting = activity.isFinishing();
        }
        return this.mQuitting;
    }

    private void hideStatusBar() {
        Activity activity = this.mActivity;
        if (activity != null) {
            activity.getWindow().setFlags(1024, 1024);
        }
    }

    private void swapViews(View view, View view2) {
        boolean z;
        ViewParent parent;
        if (this.mState.c) {
            z = false;
        } else {
            setupUnityToBePaused();
            z = true;
        }
        FrameLayout frameLayout = getFrameLayout();
        if (view != null && (parent = view.getParent()) != frameLayout) {
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
            frameLayout.addView(view);
            frameLayout.bringChildToFront(view);
            view.setVisibility(0);
        }
        if (view2 != null && view2.getParent() == frameLayout) {
            view2.setVisibility(8);
            frameLayout.removeView(view2);
        }
        if (z) {
            setupUnityToBeResumed();
        }
    }

    public boolean addViewToPlayer(View view, boolean z) {
        View view2 = getView();
        swapViews(view, z ? view2 : null);
        FrameLayout frameLayout = getFrameLayout();
        boolean z2 = true;
        boolean z3 = view.getParent() == frameLayout;
        boolean z4 = z && view2.getParent() == null;
        boolean z5 = view2.getParent() == frameLayout;
        if (!z3 || (!z4 && !z5)) {
            z2 = false;
        }
        if (!z2) {
            if (!z3) {
                AbstractC0086t.Log(6, "addViewToPlayer: Failure adding view to hierarchy");
            }
            if (!z4 && !z5) {
                AbstractC0086t.Log(6, "addViewToPlayer: Failure removing old view from hierarchy");
            }
        }
        return z2;
    }

    public void removeViewFromPlayer(View view) {
        View view2 = getView();
        swapViews(view2, view);
        boolean z = view.getParent() == null;
        boolean z2 = view2.getParent() == getFrameLayout();
        if (z && z2) {
            return;
        }
        if (!z) {
            AbstractC0086t.Log(6, "removeViewFromPlayer: Failure removing view from hierarchy");
        }
        if (z2) {
            return;
        }
        AbstractC0086t.Log(6, "removeViewFromPlayer: Failure adding old view to hierarchy");
    }

    public void reportError(String str, String str2) {
        AbstractC0086t.Log(6, str + ": " + str2);
    }

    public String getNetworkProxySettings(String str) {
        String str2;
        String str3;
        if (str.startsWith("http:")) {
            str2 = "http.proxyHost";
            str3 = "http.proxyPort";
        } else {
            if (str.startsWith("https:")) {
                str2 = "https.proxyHost";
                str3 = "https.proxyPort";
            }
            return null;
        }
        String property = System.getProperties().getProperty(str2);
        if (property != null && !"".equals(property)) {
            StringBuilder sb = new StringBuilder(property);
            String property2 = System.getProperties().getProperty(str3);
            if (property2 != null && !"".equals(property2)) {
                sb.append(":").append(property2);
            }
            String property3 = System.getProperties().getProperty("http.nonProxyHosts");
            if (property3 != null && !"".equals(property3)) {
                sb.append('\n').append(property3);
            }
            return sb.toString();
        }
        return null;
    }

    public boolean startOrientationListener(int i) {
        if (this.mOrientationListener != null) {
            AbstractC0086t.Log(5, "Orientation Listener already started.");
            return false;
        }
        C0104g0 c0104g0 = new C0104g0(this, this.mContext, i);
        this.mOrientationListener = c0104g0;
        if (c0104g0.canDetectOrientation()) {
            this.mOrientationListener.enable();
            return true;
        }
        AbstractC0086t.Log(5, "Orientation Listener cannot detect orientation.");
        return false;
    }

    public boolean stopOrientationListener() {
        OrientationEventListener orientationEventListener = this.mOrientationListener;
        if (orientationEventListener == null) {
            AbstractC0086t.Log(5, "Orientation Listener was not started.");
            return false;
        }
        orientationEventListener.disable();
        this.mOrientationListener = null;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeOnMainThread(a aVar) {
        if (isFinishing()) {
            return;
        }
        invokeOnMainThread((Runnable) aVar);
    }

    protected void executeMainThreadJobs() {
        while (true) {
            Runnable runnable = (Runnable) this.m_MainThreadJobs.poll();
            if (runnable == null) {
                return;
            } else {
                runnable.run();
            }
        }
    }

    protected String getKeyboardLayout() {
        InputMethodSubtype currentInputMethodSubtype = ((InputMethodManager) this.mContext.getSystemService("input_method")).getCurrentInputMethodSubtype();
        if (currentInputMethodSubtype == null) {
            return null;
        }
        String strA = AbstractC0115m.a(currentInputMethodSubtype);
        if (strA != null && !strA.equals("")) {
            return strA;
        }
        return currentInputMethodSubtype.getMode() + " " + currentInputMethodSubtype.getExtraValue();
    }

    private boolean runningOnUIThread() {
        return Thread.currentThread() == this.m_UIThread;
    }

    public FrameLayout getFrameLayout() {
        return this.m_FrameLayout;
    }

    String getState() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.mState.toString() + "\n");
        sb.append(String.format("m_AudioVolumeHandler = %b", this.m_AudioVolumeHandler).concat("\n"));
        sb.append(String.format("m_OrientationLockListener = %b", this.m_OrientationLockListener).concat("\n"));
        return sb.toString();
    }

    private void requestPointerCapture() {
        com.unity3d.player.a.O o = this.m_Cursor;
        o.getClass();
        if (PlatformSupport.OREO_SUPPORT) {
            o.f1063a.runOnUiThread(new com.unity3d.player.a.M(o));
        }
    }

    private void releasePointerCapture() {
        com.unity3d.player.a.O o = this.m_Cursor;
        o.getClass();
        if (PlatformSupport.OREO_SUPPORT) {
            o.f1063a.runOnUiThread(new com.unity3d.player.a.N(o));
        }
    }

    private void setBackButtonLeavesApp(boolean z) {
        C0091y c0091y = this.m_OnBackPressedDispatcher;
        if (c0091y != null) {
            if (!z) {
                c0091y.registerOnBackPressedCallback();
            } else {
                c0091y.unregisterOnBackPressedCallback();
            }
        }
    }

    private void setScreenBrightness(float f) {
        float fMax = Math.max(0.04f, f);
        if (this.m_Window == null || getScreenBrightness() == fMax) {
            return;
        }
        runOnUiThread(new U(this, fMax));
    }

    private float getScreenBrightness() {
        Window window = this.m_Window;
        if (window == null) {
            return 1.0f;
        }
        float f = window.getAttributes().screenBrightness;
        if (f >= 0.0f) {
            return f;
        }
        int i = Settings.System.getInt(getContext().getContentResolver(), "screen_brightness", 255);
        return PlatformSupport.PIE_SUPPORT ? (float) Math.max(0.0d, Math.min(1.0d, ((Math.log(i) * 19.811d) - 9.411d) / 100.0d)) : i / 255.0f;
    }

    private void pauseJavaAndCallUnloadCallback() {
        runOnUiThread(new V(this));
    }

    private void startActivityIndicator(int i) {
        postOnUiThread(new W(this, i));
    }

    private void stopActivityIndicator() {
        postOnUiThread(new X());
    }
}
