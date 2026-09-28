package net.gree.unitywebview;

import android.app.Activity;
import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.CookieManager;
import android.webkit.GeolocationPermissions;
import android.webkit.HttpAuthHandler;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.core.content.FileProvider;
import androidx.core.view.ViewCompat;
import com.google.common.net.HttpHeaders;
import com.unity3d.player.UnityPlayer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class CWebViewPlugin extends Fragment {
    private static final int INPUT_FILE_REQUEST_CODE = 1;
    private static boolean forceBringToFront;
    private static long instanceCount;
    private static FrameLayout layout;
    private boolean canGoBack;
    private boolean canGoForward;
    private boolean mAlertDialogEnabled;
    private boolean mAllowAudioCapture;
    private Pattern mAllowRegex;
    private boolean mAllowVideoCapture;
    private String mBasicAuthPassword;
    private String mBasicAuthUserName;
    private Uri mCameraPhotoUri;
    private Hashtable<String, String> mCustomHeaders;
    private Pattern mDenyRegex;
    private ValueCallback<Uri[]> mFilePathCallback;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener;
    private Pattern mHookRegex;
    private long mInstanceId;
    private boolean mPaused;
    private List<Pair<String, CWebViewPlugin>> mTransactions;
    private ValueCallback<Uri> mUploadMessage;
    private View mVideoView;
    private WebView mWebView;
    private CWebViewPluginInterface mWebViewPlugin;
    private String mWebViewUA;
    private int progress;
    private Queue<String> mMessages = new ArrayDeque();
    private boolean mInteractionEnabled = true;

    public void SaveDataURL(final String str, String str2) {
        String strSubstring;
        int iIndexOf;
        if (str2.startsWith("data:") && (iIndexOf = (strSubstring = str2.substring(5)).indexOf(";")) >= 0) {
            final String strSubstring2 = strSubstring.substring(iIndexOf + 8);
            final String strSubstring3 = strSubstring.substring(0, iIndexOf);
            final Activity activity = UnityPlayer.currentActivity;
            activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.1
                @Override // java.lang.Runnable
                public void run() {
                    String strSubstring4;
                    if (Build.VERSION.SDK_INT >= 29) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("_display_name", str);
                        contentValues.put("mime_type", strSubstring3);
                        contentValues.put("relative_path", Environment.DIRECTORY_DOWNLOADS);
                        contentValues.put("is_pending", (Integer) 1);
                        ContentResolver contentResolver = activity.getContentResolver();
                        Uri uriInsert = contentResolver.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, contentValues);
                        if (uriInsert != null) {
                            byte[] bArrDecode = Base64.decode(strSubstring2, 0);
                            try {
                                OutputStream outputStreamOpenOutputStream = contentResolver.openOutputStream(uriInsert);
                                if (outputStreamOpenOutputStream != null) {
                                    try {
                                        outputStreamOpenOutputStream.write(bArrDecode);
                                    } catch (Throwable th) {
                                        try {
                                            throw th;
                                        } catch (Throwable th2) {
                                            if (outputStreamOpenOutputStream != null) {
                                                try {
                                                    outputStreamOpenOutputStream.close();
                                                } catch (Throwable th3) {
                                                    th.addSuppressed(th3);
                                                }
                                            }
                                            throw th2;
                                        }
                                    }
                                }
                                if (outputStreamOpenOutputStream != null) {
                                    outputStreamOpenOutputStream.close();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        contentValues.clear();
                        contentValues.put("is_pending", (Integer) 0);
                        contentResolver.update(uriInsert, contentValues, null, null);
                        return;
                    }
                    File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), str);
                    file.getParent();
                    String name = file.getName();
                    int iLastIndexOf = name.lastIndexOf(".");
                    if (iLastIndexOf < 0) {
                        strSubstring4 = "";
                    } else {
                        strSubstring4 = name.substring(iLastIndexOf);
                        name = name.substring(0, iLastIndexOf);
                    }
                    int i = 1;
                    while (file.exists()) {
                        File file2 = new File(file.getParent(), name + " (" + i + ")" + strSubstring4);
                        i++;
                        file = file2;
                    }
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        try {
                            fileOutputStream.write(Base64.decode(strSubstring2, 0));
                            fileOutputStream.close();
                        } catch (Throwable th4) {
                            try {
                                throw th4;
                            } catch (Throwable th5) {
                                try {
                                    fileOutputStream.close();
                                } catch (Throwable th6) {
                                    th4.addSuppressed(th6);
                                }
                                throw th5;
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        }
    }

    public static boolean isDestroyed(Activity activity) {
        if (activity == null) {
            return true;
        }
        return activity.isDestroyed();
    }

    public void OnRequestFileChooserPermissionsResult(final boolean z) {
        UnityPlayer.currentActivity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.2
            @Override // java.lang.Runnable
            public void run() {
                if (CWebViewPlugin.this.mWebView == null) {
                    return;
                }
                if (z) {
                    CWebViewPlugin.this.ProcessChooser();
                } else {
                    CWebViewPlugin.this.mFilePathCallback.onReceiveValue(null);
                    CWebViewPlugin.this.mFilePathCallback = null;
                }
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0037  */
    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        Uri[] uriArr;
        if (i != 1) {
            super.onActivityResult(i, i2, intent);
            return;
        }
        if (this.mFilePathCallback == null) {
            super.onActivityResult(i, i2, intent);
            return;
        }
        if (i2 != -1) {
            uriArr = null;
        } else if (intent == null) {
            Uri uri = this.mCameraPhotoUri;
            if (uri != null) {
                uriArr = new Uri[]{uri};
            } else {
                uriArr = null;
            }
        } else {
            String dataString = intent.getDataString();
            if (dataString == null) {
                Uri uri2 = this.mCameraPhotoUri;
                if (uri2 != null) {
                    uriArr = new Uri[]{uri2};
                } else {
                    uriArr = null;
                }
            } else {
                uriArr = new Uri[]{Uri.parse(dataString)};
            }
        }
        this.mFilePathCallback.onReceiveValue(uriArr);
        this.mFilePathCallback = null;
    }

    public static boolean IsWebViewAvailable() {
        final Activity activity = UnityPlayer.currentActivity;
        FutureTask futureTask = new FutureTask(new Callable<Boolean>() { // from class: net.gree.unitywebview.CWebViewPlugin.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Boolean call() throws Exception {
                boolean z;
                try {
                    new WebView(activity);
                    z = true;
                } catch (Exception unused) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        });
        if (isDestroyed(activity)) {
            return false;
        }
        activity.runOnUiThread(futureTask);
        try {
            return ((Boolean) futureTask.get()).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public String GetMessage() {
        String strPoll;
        synchronized (this.mMessages) {
            strPoll = this.mMessages.size() > 0 ? this.mMessages.poll() : null;
        }
        return strPoll;
    }

    public void MyUnitySendMessage(String str, String str2, String str3) {
        synchronized (this.mMessages) {
            this.mMessages.add(str2 + ":" + str3);
        }
    }

    public boolean IsInitialized() {
        return this.mWebView != null;
    }

    public void Init(final String str, boolean z, boolean z2, int i, String str2, int i2) {
        final Activity activity = UnityPlayer.currentActivity;
        long j = instanceCount + 1;
        instanceCount = j;
        this.mInstanceId = j;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new AnonymousClass4(this, activity, i2, str, str2, z2, i, z));
        final View rootView = activity.getWindow().getDecorView().getRootView();
        this.mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: net.gree.unitywebview.CWebViewPlugin.5
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                rootView.getWindowVisibleDisplayFrame(rect);
                Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
                try {
                    Point point = new Point();
                    defaultDisplay.getSize(point);
                    int i3 = point.y;
                } catch (NoSuchMethodError unused) {
                    defaultDisplay.getHeight();
                }
                int height = rootView.getRootView().getHeight() - (rect.bottom - rect.top);
                if (CWebViewPlugin.this.IsInitialized()) {
                    CWebViewPlugin.this.MyUnitySendMessage(str, "SetKeyboardVisible", Integer.toString(height));
                }
            }
        };
        rootView.getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
    }

    /* JADX INFO: renamed from: net.gree.unitywebview.CWebViewPlugin$4, reason: invalid class name */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ Activity val$a;
        final /* synthetic */ int val$androidForceDarkMode;
        final /* synthetic */ String val$gameObject;
        final /* synthetic */ int val$radius;
        final /* synthetic */ CWebViewPlugin val$self;
        final /* synthetic */ boolean val$transparent;
        final /* synthetic */ String val$ua;
        final /* synthetic */ boolean val$zoom;

        AnonymousClass4(CWebViewPlugin cWebViewPlugin, Activity activity, int i, String str, String str2, boolean z, int i2, boolean z2) {
            this.val$self = cWebViewPlugin;
            this.val$a = activity;
            this.val$radius = i;
            this.val$gameObject = str;
            this.val$ua = str2;
            this.val$zoom = z;
            this.val$androidForceDarkMode = i2;
            this.val$transparent = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CWebViewPlugin.this.mWebView != null) {
                return;
            }
            CWebViewPlugin.this.setRetainInstance(true);
            if (CWebViewPlugin.this.mPaused) {
                if (CWebViewPlugin.this.mTransactions == null) {
                    CWebViewPlugin.this.mTransactions = new ArrayList();
                }
                CWebViewPlugin.this.mTransactions.add(Pair.create("add", this.val$self));
            } else {
                this.val$a.getFragmentManager().beginTransaction().add(0, this.val$self, "CWebViewPlugin" + CWebViewPlugin.this.mInstanceId).commitAllowingStateLoss();
            }
            CWebViewPlugin.this.mAlertDialogEnabled = true;
            CWebViewPlugin.this.mAllowVideoCapture = false;
            CWebViewPlugin.this.mAllowAudioCapture = false;
            CWebViewPlugin.this.mCustomHeaders = new Hashtable();
            final WebView roundedWebView = this.val$radius > 0 ? new RoundedWebView(this.val$a, this.val$radius) : new WebView(this.val$a);
            try {
                if ((this.val$a.getPackageManager().getApplicationInfo(this.val$a.getPackageName(), 0).flags & 2) != 0) {
                    WebView.setWebContentsDebuggingEnabled(true);
                }
            } catch (Exception unused) {
            }
            roundedWebView.setVisibility(8);
            roundedWebView.setFocusable(true);
            roundedWebView.setFocusableInTouchMode(true);
            roundedWebView.setWebChromeClient(new WebChromeClient() { // from class: net.gree.unitywebview.CWebViewPlugin.4.1
                @Override // android.webkit.WebChromeClient
                public void onPermissionRequest(PermissionRequest permissionRequest) {
                    String[] resources = permissionRequest.getResources();
                    for (String str : resources) {
                        if ((str.equals("android.webkit.resource.VIDEO_CAPTURE") && CWebViewPlugin.this.mAllowVideoCapture) || ((str.equals("android.webkit.resource.AUDIO_CAPTURE") && CWebViewPlugin.this.mAllowAudioCapture) || str.equals("android.webkit.resource.PROTECTED_MEDIA_ID"))) {
                            permissionRequest.grant(resources);
                            return;
                        }
                    }
                }

                @Override // android.webkit.WebChromeClient
                public void onProgressChanged(WebView webView, int i) {
                    CWebViewPlugin.this.progress = i;
                }

                @Override // android.webkit.WebChromeClient
                public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                    super.onShowCustomView(view, customViewCallback);
                    if (CWebViewPlugin.layout != null) {
                        CWebViewPlugin.this.mVideoView = view;
                        CWebViewPlugin.layout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                        CWebViewPlugin.layout.addView(CWebViewPlugin.this.mVideoView);
                    }
                }

                @Override // android.webkit.WebChromeClient
                public void onHideCustomView() {
                    super.onHideCustomView();
                    if (CWebViewPlugin.layout != null) {
                        CWebViewPlugin.layout.removeView(CWebViewPlugin.this.mVideoView);
                        CWebViewPlugin.layout.setBackgroundColor(0);
                        CWebViewPlugin.this.mVideoView = null;
                    }
                }

                @Override // android.webkit.WebChromeClient
                public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                    if (!CWebViewPlugin.this.mAlertDialogEnabled) {
                        jsResult.cancel();
                        return true;
                    }
                    return super.onJsAlert(webView, str, str2, jsResult);
                }

                @Override // android.webkit.WebChromeClient
                public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
                    if (!CWebViewPlugin.this.mAlertDialogEnabled) {
                        jsResult.cancel();
                        return true;
                    }
                    return super.onJsConfirm(webView, str, str2, jsResult);
                }

                @Override // android.webkit.WebChromeClient
                public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                    if (!CWebViewPlugin.this.mAlertDialogEnabled) {
                        jsPromptResult.cancel();
                        return true;
                    }
                    return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
                }

                @Override // android.webkit.WebChromeClient
                public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
                    callback.invoke(str, true, false);
                }

                public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
                    openFileChooser(valueCallback, str, "");
                }

                public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
                    if (CWebViewPlugin.this.mUploadMessage != null) {
                        CWebViewPlugin.this.mUploadMessage.onReceiveValue(null);
                    }
                    CWebViewPlugin.this.mUploadMessage = valueCallback;
                    Intent intent = new Intent("android.intent.action.GET_CONTENT");
                    intent.addCategory("android.intent.category.OPENABLE");
                    intent.setType("*/*");
                    CWebViewPlugin.this.startActivityForResult(intent, 1);
                }

                @Override // android.webkit.WebChromeClient
                public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                    CWebViewPlugin.this.mFilePathCallback = valueCallback;
                    CWebViewPlugin.this.MyUnitySendMessage(AnonymousClass4.this.val$gameObject, "RequestFileChooserPermissions", "");
                    return true;
                }
            });
            CWebViewPlugin.this.mWebViewPlugin = new CWebViewPluginInterface(this.val$self, this.val$gameObject);
            roundedWebView.setWebViewClient(new WebViewClient() { // from class: net.gree.unitywebview.CWebViewPlugin.4.2
                @Override // android.webkit.WebViewClient
                public void onReceivedError(WebView webView, int i, String str, String str2) {
                    roundedWebView.loadUrl("about:blank");
                    CWebViewPlugin.this.canGoBack = roundedWebView.canGoBack();
                    CWebViewPlugin.this.canGoForward = roundedWebView.canGoForward();
                    CWebViewPlugin.this.mWebViewPlugin.call("CallOnError", i + "\t" + str + "\t" + str2);
                }

                @Override // android.webkit.WebViewClient
                public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                    CWebViewPlugin.this.canGoBack = roundedWebView.canGoBack();
                    CWebViewPlugin.this.canGoForward = roundedWebView.canGoForward();
                    CWebViewPlugin.this.mWebViewPlugin.call("CallOnHttpError", Integer.toString(webResourceResponse.getStatusCode()));
                }

                @Override // android.webkit.WebViewClient
                public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                    CWebViewPlugin.this.canGoBack = roundedWebView.canGoBack();
                    CWebViewPlugin.this.canGoForward = roundedWebView.canGoForward();
                    CWebViewPlugin.this.mWebViewPlugin.call("CallOnStarted", str);
                }

                @Override // android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str) {
                    CWebViewPlugin.this.canGoBack = roundedWebView.canGoBack();
                    CWebViewPlugin.this.canGoForward = roundedWebView.canGoForward();
                    CWebViewPlugin.this.mWebViewPlugin.call("CallOnLoaded", str);
                }

                @Override // android.webkit.WebViewClient
                public void onLoadResource(WebView webView, String str) {
                    CWebViewPlugin.this.canGoBack = roundedWebView.canGoBack();
                    CWebViewPlugin.this.canGoForward = roundedWebView.canGoForward();
                }

                @Override // android.webkit.WebViewClient
                public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
                    if (CWebViewPlugin.this.mBasicAuthUserName != null && CWebViewPlugin.this.mBasicAuthPassword != null) {
                        httpAuthHandler.proceed(CWebViewPlugin.this.mBasicAuthUserName, CWebViewPlugin.this.mBasicAuthPassword);
                    } else {
                        httpAuthHandler.cancel();
                    }
                }

                @Override // android.webkit.WebViewClient
                public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                    if (CWebViewPlugin.this.mCustomHeaders == null || CWebViewPlugin.this.mCustomHeaders.isEmpty()) {
                        return super.shouldInterceptRequest(webView, str);
                    }
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                        httpURLConnection.setInstanceFollowRedirects(false);
                        httpURLConnection.setRequestProperty(HttpHeaders.USER_AGENT, CWebViewPlugin.this.mWebViewUA);
                        if (CWebViewPlugin.this.mBasicAuthUserName != null && CWebViewPlugin.this.mBasicAuthPassword != null) {
                            httpURLConnection.setRequestProperty(HttpHeaders.AUTHORIZATION, "Basic " + Base64.encodeToString((CWebViewPlugin.this.mBasicAuthUserName + ":" + CWebViewPlugin.this.mBasicAuthPassword).getBytes(), 2));
                        }
                        String cookie = CookieManager.getInstance().getCookie(str);
                        if (cookie != null && !cookie.isEmpty()) {
                            httpURLConnection.addRequestProperty(HttpHeaders.COOKIE, cookie);
                        }
                        for (Map.Entry entry : CWebViewPlugin.this.mCustomHeaders.entrySet()) {
                            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                        }
                        httpURLConnection.connect();
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode >= 300 && responseCode < 400) {
                            return null;
                        }
                        List<String> list = httpURLConnection.getHeaderFields().get(HttpHeaders.SET_COOKIE);
                        if (list != null) {
                            CWebViewPlugin.this.SetCookies(str, list);
                        }
                        return new WebResourceResponse(httpURLConnection.getContentType().split(";", 2)[0], httpURLConnection.getContentEncoding(), httpURLConnection.getInputStream());
                    } catch (Exception unused2) {
                        return super.shouldInterceptRequest(webView, str);
                    }
                }

                /* JADX INFO: renamed from: net.gree.unitywebview.CWebViewPlugin$4$2$1, reason: invalid class name */
                class AnonymousClass1 implements Runnable {
                    final /* synthetic */ List val$setCookieHeaders;
                    final /* synthetic */ String val$url;

                    AnonymousClass1(String str, List list) {
                        this.val$url = str;
                        this.val$setCookieHeaders = list;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        CWebViewPlugin.this.SetCookies(this.val$url, this.val$setCookieHeaders);
                    }
                }

                @Override // android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    CWebViewPlugin.this.canGoBack = roundedWebView.canGoBack();
                    CWebViewPlugin.this.canGoForward = roundedWebView.canGoForward();
                    if ((CWebViewPlugin.this.mAllowRegex == null || !CWebViewPlugin.this.mAllowRegex.matcher(str).find()) && CWebViewPlugin.this.mDenyRegex != null && CWebViewPlugin.this.mDenyRegex.matcher(str).find()) {
                        return true;
                    }
                    if (!str.startsWith("unity:")) {
                        if (CWebViewPlugin.this.mHookRegex != null && CWebViewPlugin.this.mHookRegex.matcher(str).find()) {
                            CWebViewPlugin.this.mWebViewPlugin.call("CallOnHooked", str);
                            return true;
                        }
                        if (!str.toLowerCase().endsWith(".pdf") && !str.startsWith("https://maps.app.goo.gl") && (str.startsWith("http://") || str.startsWith("https://") || str.startsWith("file://") || str.startsWith("javascript:"))) {
                            CWebViewPlugin.this.mWebViewPlugin.call("CallOnStarted", str);
                            return false;
                        }
                        try {
                            webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        } catch (ActivityNotFoundException unused2) {
                        }
                        return true;
                    }
                    CWebViewPlugin.this.mWebViewPlugin.call("CallFromJS", str.substring(6));
                    return true;
                }
            });
            roundedWebView.addJavascriptInterface(CWebViewPlugin.this.mWebViewPlugin, "Unity");
            WebSettings settings = roundedWebView.getSettings();
            String str = this.val$ua;
            if (str != null && str.length() > 0) {
                settings.setUserAgentString(this.val$ua);
            }
            CWebViewPlugin.this.mWebViewUA = settings.getUserAgentString();
            if (this.val$zoom) {
                settings.setSupportZoom(true);
                settings.setBuiltInZoomControls(true);
            } else {
                settings.setSupportZoom(false);
                settings.setBuiltInZoomControls(false);
            }
            settings.setDisplayZoomControls(false);
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
            settings.setJavaScriptEnabled(true);
            settings.setGeolocationEnabled(true);
            settings.setAllowUniversalAccessFromFileURLs(true);
            settings.setMediaPlaybackRequiresUserGesture(false);
            settings.setDatabaseEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setDatabasePath(roundedWebView.getContext().getDir("databases", 0).getPath());
            settings.setAllowFileAccess(true);
            if (Build.VERSION.SDK_INT >= 29) {
                int i = this.val$androidForceDarkMode;
                if (i == 0) {
                    int i2 = UnityPlayer.currentActivity.getResources().getConfiguration().uiMode & 48;
                    if (i2 == 16) {
                        settings.setForceDark(0);
                    } else if (i2 == 32) {
                        settings.setForceDark(2);
                    }
                } else if (i == 1) {
                    settings.setForceDark(0);
                } else if (i == 2) {
                    settings.setForceDark(2);
                }
            }
            if (this.val$transparent) {
                roundedWebView.setBackgroundColor(0);
            }
            roundedWebView.setOnTouchListener(new View.OnTouchListener() { // from class: net.gree.unitywebview.CWebViewPlugin.4.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return !CWebViewPlugin.this.mInteractionEnabled;
                }
            });
            if (CWebViewPlugin.layout == null || CWebViewPlugin.layout.getParent() != this.val$a.findViewById(android.R.id.content)) {
                FrameLayout unused2 = CWebViewPlugin.layout = new FrameLayout(this.val$a);
                this.val$a.addContentView(CWebViewPlugin.layout, new ViewGroup.LayoutParams(-1, -1));
                CWebViewPlugin.layout.setFocusable(true);
                CWebViewPlugin.layout.setFocusableInTouchMode(true);
            }
            CWebViewPlugin.layout.addView(roundedWebView, new FrameLayout.LayoutParams(-1, -1, 0));
            CWebViewPlugin.this.mWebView = roundedWebView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ProcessChooser() {
        File fileCreateImageFile;
        Intent[] intentArr;
        Intent intent = null;
        this.mCameraPhotoUri = null;
        Intent intent2 = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent2.resolveActivity(getActivity().getPackageManager()) != null) {
            try {
                fileCreateImageFile = createImageFile();
            } catch (IOException e) {
                Log.e("CWebViewPlugin", "Unable to create Image File", e);
                fileCreateImageFile = null;
            }
            if (fileCreateImageFile != null) {
                intent2.putExtra("PhotoPath", fileCreateImageFile);
                Uri uriForFile = FileProvider.getUriForFile(getActivity(), getActivity().getPackageName() + ".unitywebview.fileprovider", fileCreateImageFile);
                this.mCameraPhotoUri = uriForFile;
                intent2.putExtra("output", uriForFile);
                intent = intent2;
            }
        } else {
            intent = intent2;
        }
        Intent intent3 = new Intent("android.intent.action.GET_CONTENT");
        intent3.addCategory("android.intent.category.OPENABLE");
        intent3.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        intent3.setType("*/*");
        if (intent != null) {
            intentArr = new Intent[]{intent};
        } else {
            intentArr = new Intent[0];
        }
        Intent intent4 = new Intent("android.intent.action.CHOOSER");
        intent4.putExtra("android.intent.extra.INTENT", intent3);
        intent4.putExtra("android.intent.extra.INITIAL_INTENTS", intentArr);
        startActivityForResult(Intent.createChooser(intent4, "Select images"), 1);
    }

    private File createImageFile() throws IOException {
        String str = "JPEG_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + "_";
        File externalFilesDir = getActivity().getExternalFilesDir(Environment.DIRECTORY_DCIM);
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        return File.createTempFile(str, ".jpg", externalFilesDir);
    }

    public void Destroy() {
        final Activity activity = UnityPlayer.currentActivity;
        this.mMessages.clear();
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.6
            @Override // java.lang.Runnable
            public void run() {
                WebView webView = CWebViewPlugin.this.mWebView;
                CWebViewPlugin.this.mWebView = null;
                if (webView == null) {
                    return;
                }
                if (CWebViewPlugin.this.mGlobalLayoutListener != null) {
                    activity.getWindow().getDecorView().getRootView().getViewTreeObserver().removeOnGlobalLayoutListener(CWebViewPlugin.this.mGlobalLayoutListener);
                    CWebViewPlugin.this.mGlobalLayoutListener = null;
                }
                webView.stopLoading();
                if (CWebViewPlugin.this.mVideoView != null) {
                    CWebViewPlugin.layout.removeView(CWebViewPlugin.this.mVideoView);
                    CWebViewPlugin.layout.setBackgroundColor(0);
                    CWebViewPlugin.this.mVideoView = null;
                }
                CWebViewPlugin.layout.removeView(webView);
                webView.destroy();
                if (CWebViewPlugin.this.mPaused) {
                    if (CWebViewPlugin.this.mTransactions == null) {
                        CWebViewPlugin.this.mTransactions = new ArrayList();
                    }
                    CWebViewPlugin.this.mTransactions.add(Pair.create("remove", this));
                    return;
                }
                activity.getFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
            }
        });
    }

    public boolean SetURLPattern(String str, String str2, String str3) {
        final Pattern patternCompile;
        final Pattern patternCompile2 = null;
        if (str != null) {
            try {
                patternCompile = str.length() == 0 ? null : Pattern.compile(str);
            } catch (Exception unused) {
                return false;
            }
        }
        final Pattern patternCompile3 = (str2 == null || str2.length() == 0) ? null : Pattern.compile(str2);
        if (str3 != null && str3.length() != 0) {
            patternCompile2 = Pattern.compile(str3);
        }
        Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return false;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.7
            @Override // java.lang.Runnable
            public void run() {
                CWebViewPlugin.this.mAllowRegex = patternCompile;
                CWebViewPlugin.this.mDenyRegex = patternCompile3;
                CWebViewPlugin.this.mHookRegex = patternCompile2;
            }
        });
        return true;
    }

    public void LoadURL(final String str) {
        Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.8
            @Override // java.lang.Runnable
            public void run() {
                if (CWebViewPlugin.this.mWebView == null) {
                    return;
                }
                if (CWebViewPlugin.this.mCustomHeaders == null || CWebViewPlugin.this.mCustomHeaders.isEmpty()) {
                    CWebViewPlugin.this.mWebView.loadUrl(str);
                } else {
                    CWebViewPlugin.this.mWebView.loadUrl(str, CWebViewPlugin.this.mCustomHeaders);
                }
            }
        });
    }

    public void LoadHTML(final String str, final String str2) {
        Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.9
            @Override // java.lang.Runnable
            public void run() {
                if (CWebViewPlugin.this.mWebView == null) {
                    return;
                }
                CWebViewPlugin.this.mWebView.loadDataWithBaseURL(str2, str, "text/html", "UTF8", null);
            }
        });
    }

    public void EvaluateJS(final String str) {
        Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.10
            @Override // java.lang.Runnable
            public void run() {
                if (CWebViewPlugin.this.mWebView == null) {
                    return;
                }
                CWebViewPlugin.this.mWebView.evaluateJavascript(str, null);
            }
        });
    }

    public void GoBack() {
        Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.11
            @Override // java.lang.Runnable
            public void run() {
                if (CWebViewPlugin.this.mWebView == null) {
                    return;
                }
                CWebViewPlugin.this.mWebView.goBack();
            }
        });
    }

    public void GoForward() {
        Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.12
            @Override // java.lang.Runnable
            public void run() {
                if (CWebViewPlugin.this.mWebView == null) {
                    return;
                }
                CWebViewPlugin.this.mWebView.goForward();
            }
        });
    }

    public void Reload() {
        Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.13
            @Override // java.lang.Runnable
            public void run() {
                if (CWebViewPlugin.this.mWebView == null) {
                    return;
                }
                CWebViewPlugin.this.mWebView.reload();
            }
        });
    }

    public void SetMargins(int i, int i2, int i3, int i4) {
        final FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1, 0);
        layoutParams.setMargins(i, i2, i3, i4);
        Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.14
            @Override // java.lang.Runnable
            public void run() {
                if (CWebViewPlugin.this.mWebView == null) {
                    return;
                }
                CWebViewPlugin.this.mWebView.setLayoutParams(layoutParams);
            }
        });
    }

    public void SetVisibility(final boolean z) {
        Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.15
            @Override // java.lang.Runnable
            public void run() {
                if (CWebViewPlugin.this.mWebView == null) {
                    return;
                }
                if (z) {
                    CWebViewPlugin.this.mWebView.setVisibility(0);
                    CWebViewPlugin.layout.requestFocus();
                    CWebViewPlugin.this.mWebView.requestFocus();
                    if (CWebViewPlugin.layout != null && CWebViewPlugin.layout.getParent() != null && CWebViewPlugin.layout.getParent().getParent() != null) {
                        ((ViewGroup) CWebViewPlugin.layout.getParent().getParent()).requestLayout();
                    }
                    if (!CWebViewPlugin.forceBringToFront || CWebViewPlugin.layout == null) {
                        return;
                    }
                    CWebViewPlugin.layout.bringToFront();
                    return;
                }
                CWebViewPlugin.this.mWebView.setVisibility(8);
            }
        });
    }

    public void SetInteractionEnabled(final boolean z) {
        Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.16
            @Override // java.lang.Runnable
            public void run() {
                CWebViewPlugin.this.mInteractionEnabled = z;
            }
        });
    }

    public void SetScrollbarsVisibility(final boolean z) {
        Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.17
            @Override // java.lang.Runnable
            public void run() {
                if (CWebViewPlugin.this.mWebView == null) {
                    return;
                }
                CWebViewPlugin.this.mWebView.setHorizontalScrollBarEnabled(z);
                CWebViewPlugin.this.mWebView.setVerticalScrollBarEnabled(z);
            }
        });
    }

    public void SetAlertDialogEnabled(final boolean z) {
        Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.18
            @Override // java.lang.Runnable
            public void run() {
                CWebViewPlugin.this.mAlertDialogEnabled = z;
            }
        });
    }

    public void SetCameraAccess(final boolean z) {
        Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.19
            @Override // java.lang.Runnable
            public void run() {
                CWebViewPlugin.this.mAllowVideoCapture = z;
            }
        });
    }

    public void SetMicrophoneAccess(final boolean z) {
        Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.20
            @Override // java.lang.Runnable
            public void run() {
                CWebViewPlugin.this.mAllowAudioCapture = z;
            }
        });
    }

    public void SetNetworkAvailable(final boolean z) {
        Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.21
            @Override // java.lang.Runnable
            public void run() {
                if (CWebViewPlugin.this.mWebView == null) {
                    return;
                }
                CWebViewPlugin.this.mWebView.setNetworkAvailable(z);
            }
        });
    }

    public void Pause() {
        Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.22
            @Override // java.lang.Runnable
            public void run() {
                if (CWebViewPlugin.this.mWebView == null) {
                    return;
                }
                CWebViewPlugin.this.mWebView.onPause();
                CWebViewPlugin.this.mWebView.pauseTimers();
            }
        });
    }

    public void Resume() {
        Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.23
            @Override // java.lang.Runnable
            public void run() {
                if (CWebViewPlugin.this.mWebView == null) {
                    return;
                }
                CWebViewPlugin.this.mWebView.onResume();
                CWebViewPlugin.this.mWebView.resumeTimers();
            }
        });
    }

    public void OnApplicationPause(boolean z) {
        this.mPaused = z;
        final Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.24
            @Override // java.lang.Runnable
            public void run() {
                if (!CWebViewPlugin.this.mPaused && CWebViewPlugin.this.mTransactions != null) {
                    for (Pair pair : CWebViewPlugin.this.mTransactions) {
                        CWebViewPlugin cWebViewPlugin = (CWebViewPlugin) pair.second;
                        String str = (String) pair.first;
                        str.hashCode();
                        if (str.equals("remove")) {
                            activity.getFragmentManager().beginTransaction().remove(cWebViewPlugin).commitAllowingStateLoss();
                        } else if (str.equals("add")) {
                            activity.getFragmentManager().beginTransaction().add(0, cWebViewPlugin, "CWebViewPlugin" + CWebViewPlugin.this.mInstanceId).commitAllowingStateLoss();
                        }
                    }
                    CWebViewPlugin.this.mTransactions.clear();
                }
                if (CWebViewPlugin.this.mWebView == null) {
                    return;
                }
                if (CWebViewPlugin.this.mPaused) {
                    CWebViewPlugin.this.mWebView.onPause();
                    if (CWebViewPlugin.this.mWebView.getVisibility() == 0) {
                        CWebViewPlugin.this.mWebView.pauseTimers();
                        return;
                    }
                    return;
                }
                CWebViewPlugin.this.mWebView.onResume();
                CWebViewPlugin.this.mWebView.resumeTimers();
                if (!CWebViewPlugin.forceBringToFront || CWebViewPlugin.layout == null) {
                    return;
                }
                CWebViewPlugin.layout.bringToFront();
            }
        });
    }

    public void AddCustomHeader(final String str, final String str2) {
        Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.25
            @Override // java.lang.Runnable
            public void run() {
                if (CWebViewPlugin.this.mCustomHeaders == null) {
                    return;
                }
                CWebViewPlugin.this.mCustomHeaders.put(str, str2);
            }
        });
    }

    public String GetCustomHeaderValue(String str) {
        Hashtable<String, String> hashtable = this.mCustomHeaders;
        if (hashtable != null && hashtable.containsKey(str)) {
            return this.mCustomHeaders.get(str);
        }
        return null;
    }

    public void RemoveCustomHeader(final String str) {
        Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.26
            @Override // java.lang.Runnable
            public void run() {
                if (CWebViewPlugin.this.mCustomHeaders != null && CWebViewPlugin.this.mCustomHeaders.containsKey(str)) {
                    CWebViewPlugin.this.mCustomHeaders.remove(str);
                }
            }
        });
    }

    public void ClearCustomHeader() {
        Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.27
            @Override // java.lang.Runnable
            public void run() {
                if (CWebViewPlugin.this.mCustomHeaders == null) {
                    return;
                }
                CWebViewPlugin.this.mCustomHeaders.clear();
            }
        });
    }

    public void ClearCookies() {
        CookieManager.getInstance().removeAllCookies(null);
        CookieManager.getInstance().flush();
    }

    public void SaveCookies() {
        CookieManager.getInstance().flush();
    }

    public void GetCookies(String str) {
        this.mWebViewPlugin.call("CallOnCookies", CookieManager.getInstance().getCookie(str));
    }

    public void SetCookies(String str, List<String> list) {
        CookieManager cookieManager = CookieManager.getInstance();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            cookieManager.setCookie(str, it.next());
        }
        cookieManager.flush();
    }

    public void SetBasicAuthInfo(String str, String str2) {
        this.mBasicAuthUserName = str;
        this.mBasicAuthPassword = str2;
    }

    public void ClearCache(final boolean z) {
        Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.28
            @Override // java.lang.Runnable
            public void run() {
                if (CWebViewPlugin.this.mWebView == null) {
                    return;
                }
                CWebViewPlugin.this.mWebView.clearCache(z);
            }
        });
    }

    public void SetTextZoom(final int i) {
        Activity activity = UnityPlayer.currentActivity;
        if (isDestroyed(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: net.gree.unitywebview.CWebViewPlugin.29
            @Override // java.lang.Runnable
            public void run() {
                if (CWebViewPlugin.this.mWebView == null) {
                    return;
                }
                CWebViewPlugin.this.mWebView.getSettings().setTextZoom(i);
            }
        });
    }
}
