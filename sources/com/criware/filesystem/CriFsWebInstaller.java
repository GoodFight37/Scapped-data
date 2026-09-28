package com.criware.filesystem;

import android.os.AsyncTask;
import com.google.common.net.HttpHeaders;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Locale;
import java.util.zip.CRC32;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;

/* JADX INFO: loaded from: classes.dex */
public class CriFsWebInstaller {
    private static final boolean ENABLE_DEBUG_PRINT = false;
    private static CriFsWebInstallerManager manager;
    private boolean can_access_asynctask;
    private CRC32 crc_num;
    private boolean is_timeouted;
    private boolean is_waiting_to_start;
    private long start_time;
    private WebInstallerTask task;
    private AsyncTaskParam task_params;
    private long timeout_start_time;
    private StatusInfo synced_statusinfo = new StatusInfo();
    public boolean is_stop_required = false;

    public static class Config {
        boolean allow_insecure_ssl;
        boolean crc_enabled;
        int inactive_timeout_sec;
        int max_request_fields;
        int num_installers;
        String proxy_host;
        short proxy_port;
        String user_agent;
    }

    public enum TaskStatus {
        BUSY,
        STOP,
        STOPPING
    }

    private static native boolean ErrorCallback(int i);

    public enum Status {
        CRIFSWEBINSTALLER_STATUS_STOP(0),
        CRIFSWEBINSTALLER_STATUS_BUSY(1),
        CRIFSWEBINSTALLER_STATUS_COMPLETE(2),
        CRIFSWEBINSTALLER_STATUS_ERROR(3);

        private int value;

        Status(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum Error {
        CRIFSWEBINSTALLER_ERROR_NONE(0),
        CRIFSWEBINSTALLER_ERROR_TIMEOUT(1),
        CRIFSWEBINSTALLER_ERROR_MEMORY(2),
        CRIFSWEBINSTALLER_ERROR_LOCALFS(3),
        CRIFSWEBINSTALLER_ERROR_DNS(4),
        CRIFSWEBINSTALLER_ERROR_CONNECTION(5),
        CRIFSWEBINSTALLER_ERROR_SSL(6),
        CRIFSWEBINSTALLER_ERROR_HTTP(7),
        CRIFSWEBINSTALLER_ERROR_INTERNAL(8);

        private int value;

        Error(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public class StatusInfo {
        long contents_size;
        Error error;
        int http_status_code;
        long received_size;
        Status status;

        public StatusInfo() {
        }
    }

    public class AsyncTaskParam {
        long param_contents_size;
        String param_dst_path;
        long param_received_size;
        String param_src_path;

        AsyncTaskParam(String str, String str2, long j, long j2) {
            this.param_src_path = str;
            this.param_dst_path = str2;
            this.param_contents_size = j;
            this.param_received_size = j2;
        }
    }

    CriFsWebInstaller() {
        if (manager.crc_enabled) {
            this.crc_num = new CRC32();
        }
        ClearMember();
    }

    public class TaskStatusInfo {
        TaskStatus status = TaskStatus.BUSY;
        Error error = Error.CRIFSWEBINSTALLER_ERROR_NONE;
        int http_status_code = -1;
        long contents_size = -1;
        long received_size = 0;

        TaskStatusInfo() {
        }
    }

    private class WebInstallerTask extends AsyncTask<AsyncTaskParam, Void, Boolean> {
        private static final int CONNECT_FAILURE = 1;
        private static final int CONNECT_SUCCESS = 0;
        private static final int MAX_REDIRECT_COUNT = 10;
        private static final int NEEDS_REDIRECT = 2;
        private HttpURLConnection http_connection = null;
        private String task_dst_path;
        private TaskStatusInfo task_internal_info;
        private String task_src_path;
        private File tmp_file;

        WebInstallerTask() {
            this.task_internal_info = CriFsWebInstaller.this.new TaskStatusInfo();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Boolean doInBackground(AsyncTaskParam... asyncTaskParamArr) {
            int i = 0;
            this.task_src_path = asyncTaskParamArr[0].param_src_path;
            this.task_dst_path = asyncTaskParamArr[0].param_dst_path;
            synchronized (this) {
                this.task_internal_info.contents_size = asyncTaskParamArr[0].param_contents_size;
                this.task_internal_info.received_size = asyncTaskParamArr[0].param_received_size;
            }
            while (task_setup()) {
                if (isCancelled()) {
                    this.tmp_file.delete();
                    this.http_connection.disconnect();
                    return false;
                }
                int iTask_connect = task_connect();
                if (iTask_connect == 2) {
                    this.http_connection.disconnect();
                    i++;
                }
                if (i > 10) {
                    SetError(Error.CRIFSWEBINSTALLER_ERROR_INTERNAL, this.task_internal_info.http_status_code);
                    CriFsWebInstaller.ErrorEntry(16);
                    return false;
                }
                if (iTask_connect != 2) {
                    if (iTask_connect == 1) {
                        this.http_connection.disconnect();
                        return false;
                    }
                    if (!task_copyfile()) {
                        return false;
                    }
                    synchronized (this) {
                        this.task_internal_info.status = TaskStatus.STOP;
                    }
                    return true;
                }
            }
            HttpURLConnection httpURLConnection = this.http_connection;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean bool) {
            synchronized (this) {
                this.task_internal_info.status = TaskStatus.STOP;
            }
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            synchronized (this) {
                this.task_internal_info.status = TaskStatus.STOP;
            }
        }

        public void Cancel() {
            cancel(true);
            synchronized (this) {
                this.task_internal_info.status = TaskStatus.STOPPING;
            }
        }

        public synchronized TaskStatusInfo GetTaskStatusInfo() {
            return this.task_internal_info;
        }

        private synchronized void SetError(Error error, int i) {
            if (error != Error.CRIFSWEBINSTALLER_ERROR_CONNECTION && error != Error.CRIFSWEBINSTALLER_ERROR_DNS && this.tmp_file.exists()) {
                this.tmp_file.delete();
            }
            this.task_internal_info.status = TaskStatus.STOP;
            this.task_internal_info.error = error;
            this.task_internal_info.http_status_code = i;
        }

        private boolean task_setup() {
            try {
                if (!this.task_src_path.toLowerCase(Locale.ENGLISH).startsWith("https://") && !this.task_src_path.toLowerCase(Locale.ENGLISH).startsWith("http://")) {
                    SetError(Error.CRIFSWEBINSTALLER_ERROR_INTERNAL, this.task_internal_info.http_status_code);
                    CriFsWebInstaller.ErrorEntry(7);
                    return false;
                }
                URL url = new URL(this.task_src_path);
                this.tmp_file = new File(this.task_dst_path + ".tmp");
                try {
                    if (CriFsWebInstaller.manager.proxy_host == null || CriFsWebInstaller.manager.proxy_port == 0) {
                        CriFsWebInstallerManager criFsWebInstallerManager = CriFsWebInstaller.manager;
                        String property = System.getProperty("http.proxyHost");
                        criFsWebInstallerManager.proxy_host = property;
                        if (property != null) {
                            String property2 = System.getProperty("http.proxyPort");
                            CriFsWebInstallerManager criFsWebInstallerManager2 = CriFsWebInstaller.manager;
                            if (property2 == null) {
                                property2 = "-1";
                            }
                            criFsWebInstallerManager2.proxy_port = Short.parseShort(property2);
                            this.http_connection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(CriFsWebInstaller.manager.proxy_host, CriFsWebInstaller.manager.proxy_port)));
                        } else {
                            this.http_connection = (HttpURLConnection) url.openConnection();
                        }
                    } else {
                        this.http_connection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(CriFsWebInstaller.manager.proxy_host, CriFsWebInstaller.manager.proxy_port)));
                    }
                    this.http_connection.setRequestMethod("GET");
                    this.http_connection.setInstanceFollowRedirects(false);
                    this.http_connection.setDoInput(true);
                    this.http_connection.setConnectTimeout(5000);
                    this.http_connection.setReadTimeout(5000);
                    this.http_connection.setRequestProperty(HttpHeaders.USER_AGENT, CriFsWebInstaller.manager.user_agent);
                    this.http_connection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, "identity");
                    for (int i = 0; i < CriFsWebInstaller.manager.request_headers.length(); i++) {
                        try {
                            this.http_connection.setRequestProperty(CriFsWebInstaller.manager.request_headers.getFieldName(i), CriFsWebInstaller.manager.request_headers.getValue(i));
                        } catch (IllegalArgumentException unused) {
                            SetError(Error.CRIFSWEBINSTALLER_ERROR_INTERNAL, this.task_internal_info.http_status_code);
                            CriFsWebInstaller.ErrorEntry(12);
                            return false;
                        }
                    }
                    if (this.task_internal_info.contents_size != -1) {
                        if (!this.tmp_file.exists()) {
                            CriFsWebInstaller.ErrorEntry(8);
                            SetError(Error.CRIFSWEBINSTALLER_ERROR_LOCALFS, this.task_internal_info.http_status_code);
                            return false;
                        }
                        if (this.tmp_file.length() != this.task_internal_info.received_size) {
                            CriFsWebInstaller.ErrorEntry(9);
                            SetError(Error.CRIFSWEBINSTALLER_ERROR_INTERNAL, this.task_internal_info.http_status_code);
                            return false;
                        }
                        this.http_connection.setRequestProperty(HttpHeaders.RANGE, "bytes=" + this.tmp_file.length() + "-");
                    } else if (this.tmp_file.exists()) {
                        this.tmp_file.delete();
                    }
                    return true;
                } catch (IllegalArgumentException unused2) {
                    SetError(Error.CRIFSWEBINSTALLER_ERROR_INTERNAL, this.task_internal_info.http_status_code);
                    CriFsWebInstaller.ErrorEntry(11);
                    return false;
                }
            } catch (IOException e) {
                SetError(Error.CRIFSWEBINSTALLER_ERROR_INTERNAL, this.task_internal_info.http_status_code);
                CriFsWebInstaller.ErrorEntry(4);
                e.printStackTrace();
                return false;
            } catch (NullPointerException e2) {
                SetError(Error.CRIFSWEBINSTALLER_ERROR_MEMORY, this.task_internal_info.http_status_code);
                e2.printStackTrace();
                return false;
            } catch (MalformedURLException e3) {
                SetError(Error.CRIFSWEBINSTALLER_ERROR_DNS, this.task_internal_info.http_status_code);
                e3.printStackTrace();
                return false;
            } catch (ProtocolException e4) {
                SetError(Error.CRIFSWEBINSTALLER_ERROR_CONNECTION, this.task_internal_info.http_status_code);
                e4.printStackTrace();
                return false;
            }
        }

        private int task_connect() {
            long contentLength;
            try {
                this.http_connection.connect();
                int responseCode = this.http_connection.getResponseCode();
                if (this.task_internal_info.received_size > 0 && responseCode == 200) {
                    SetError(Error.CRIFSWEBINSTALLER_ERROR_HTTP, -1);
                    CriFsWebInstaller.ErrorEntry(15);
                    return 1;
                }
                if (responseCode == 200) {
                    contentLength = this.http_connection.getContentLength();
                } else {
                    if (responseCode != 206) {
                        if (responseCode >= 300 && responseCode <= 307 && responseCode != 306 && responseCode != 304) {
                            this.task_src_path = this.http_connection.getHeaderField(HttpHeaders.LOCATION);
                            return 2;
                        }
                        if (responseCode >= 0) {
                            SetError(Error.CRIFSWEBINSTALLER_ERROR_HTTP, responseCode);
                            return 1;
                        }
                        SetError(Error.CRIFSWEBINSTALLER_ERROR_CONNECTION, -1);
                        return 1;
                    }
                    contentLength = ((long) this.http_connection.getContentLength()) + this.task_internal_info.received_size;
                }
                synchronized (this) {
                    this.task_internal_info.http_status_code = responseCode;
                    this.task_internal_info.contents_size = contentLength;
                }
                return 0;
            } catch (FileNotFoundException unused) {
                SetError(Error.CRIFSWEBINSTALLER_ERROR_HTTP, -1);
                return 1;
            } catch (SocketException unused2) {
                SetError(Error.CRIFSWEBINSTALLER_ERROR_CONNECTION, -1);
                return 1;
            } catch (SocketTimeoutException unused3) {
                SetError(Error.CRIFSWEBINSTALLER_ERROR_CONNECTION, -1);
                return 1;
            } catch (UnknownHostException unused4) {
                SetError(Error.CRIFSWEBINSTALLER_ERROR_CONNECTION, -1);
                return 1;
            } catch (SSLHandshakeException unused5) {
                SetError(Error.CRIFSWEBINSTALLER_ERROR_SSL, -1);
                return 1;
            } catch (SSLException unused6) {
                SetError(Error.CRIFSWEBINSTALLER_ERROR_SSL, -1);
                return 1;
            } catch (IOException e) {
                SetError(Error.CRIFSWEBINSTALLER_ERROR_CONNECTION, -1);
                CriFsWebInstaller.ErrorEntry(5);
                e.printStackTrace();
                return 1;
            }
        }

        private boolean task_copyfile() {
            try {
                try {
                    try {
                        try {
                            try {
                                InputStream inputStream = this.http_connection.getInputStream();
                                FileOutputStream fileOutputStream = new FileOutputStream(this.tmp_file, true);
                                byte[] bArr = new byte[65536];
                                while (!isCancelled()) {
                                    try {
                                        int i = inputStream.read(bArr);
                                        if (i == -1) {
                                            break;
                                        }
                                        if (i != 0) {
                                            if (CriFsWebInstaller.manager.crc_enabled) {
                                                try {
                                                    CriFsWebInstaller.this.crc_num.update(bArr, 0, i);
                                                } catch (ArrayIndexOutOfBoundsException unused) {
                                                    SetError(Error.CRIFSWEBINSTALLER_ERROR_INTERNAL, -1);
                                                    CriFsWebInstaller.ErrorEntry(13);
                                                    break;
                                                }
                                            }
                                            try {
                                                fileOutputStream.write(bArr, 0, i);
                                                synchronized (this) {
                                                    this.task_internal_info.received_size += (long) i;
                                                }
                                            } catch (IOException unused2) {
                                                SetError(Error.CRIFSWEBINSTALLER_ERROR_LOCALFS, -1);
                                                break;
                                            }
                                        } else {
                                            try {
                                                Thread.sleep(10L);
                                            } catch (InterruptedException unused3) {
                                            }
                                        }
                                    } catch (IOException unused4) {
                                        SetError(Error.CRIFSWEBINSTALLER_ERROR_CONNECTION, -1);
                                        break;
                                    }
                                }
                                try {
                                    inputStream.close();
                                } catch (IOException unused5) {
                                }
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused6) {
                                }
                                this.http_connection.disconnect();
                                if (this.task_internal_info.error != Error.CRIFSWEBINSTALLER_ERROR_NONE) {
                                    if (this.task_internal_info.error == Error.CRIFSWEBINSTALLER_ERROR_LOCALFS) {
                                        this.tmp_file.delete();
                                    }
                                } else if (isCancelled()) {
                                    this.tmp_file.delete();
                                } else if (this.task_internal_info.received_size != this.task_internal_info.contents_size) {
                                    this.tmp_file.delete();
                                    SetError(Error.CRIFSWEBINSTALLER_ERROR_INTERNAL, -1);
                                    CriFsWebInstaller.ErrorEntry(14);
                                } else {
                                    File file = new File(this.task_dst_path);
                                    if (file.exists()) {
                                        this.tmp_file.delete();
                                        SetError(Error.CRIFSWEBINSTALLER_ERROR_LOCALFS, -1);
                                    } else {
                                        this.tmp_file.renameTo(file);
                                        this.http_connection.disconnect();
                                        return true;
                                    }
                                }
                            } catch (SocketTimeoutException unused7) {
                                SetError(Error.CRIFSWEBINSTALLER_ERROR_CONNECTION, -1);
                            }
                        } catch (FileNotFoundException unused8) {
                            SetError(Error.CRIFSWEBINSTALLER_ERROR_LOCALFS, -1);
                        }
                    } catch (NullPointerException unused9) {
                        SetError(Error.CRIFSWEBINSTALLER_ERROR_MEMORY, -1);
                    }
                } catch (IOException e) {
                    SetError(Error.CRIFSWEBINSTALLER_ERROR_INTERNAL, -1);
                    CriFsWebInstaller.ErrorEntry(6);
                    e.printStackTrace();
                }
                this.http_connection.disconnect();
                return false;
            } catch (Throwable th) {
                this.http_connection.disconnect();
                throw th;
            }
        }
    }

    public void Update() {
        TaskStatusInfo taskStatusInfoGetTaskStatusInfo;
        if (this.synced_statusinfo.status == Status.CRIFSWEBINSTALLER_STATUS_BUSY && this.can_access_asynctask && (taskStatusInfoGetTaskStatusInfo = this.task.GetTaskStatusInfo()) != null) {
            int i = AnonymousClass3.$SwitchMap$com$criware$filesystem$CriFsWebInstaller$TaskStatus[taskStatusInfoGetTaskStatusInfo.status.ordinal()];
            if (i == 1) {
                if (this.is_stop_required) {
                    this.task.Cancel();
                    return;
                }
                this.synced_statusinfo.contents_size = taskStatusInfoGetTaskStatusInfo.contents_size;
                if (taskStatusInfoGetTaskStatusInfo.received_size > this.synced_statusinfo.received_size) {
                    this.synced_statusinfo.received_size = taskStatusInfoGetTaskStatusInfo.received_size;
                    this.timeout_start_time = GetNow() / 1000;
                    return;
                } else {
                    if (this.timeout_start_time + ((long) manager.inactive_timeout_sec) < GetNow() / 1000) {
                        this.is_timeouted = true;
                        this.task.cancel(true);
                        return;
                    }
                    return;
                }
            }
            if (i != 2) {
                if (i != 3) {
                    return;
                }
                this.synced_statusinfo.contents_size = taskStatusInfoGetTaskStatusInfo.contents_size;
                this.synced_statusinfo.received_size = taskStatusInfoGetTaskStatusInfo.received_size;
                return;
            }
            if (this.is_stop_required) {
                new File(this.task_params.param_dst_path + ".tmp").delete();
                ClearMember();
                return;
            }
            if (this.is_timeouted) {
                this.synced_statusinfo.contents_size = taskStatusInfoGetTaskStatusInfo.contents_size;
                this.synced_statusinfo.received_size = taskStatusInfoGetTaskStatusInfo.received_size;
                this.synced_statusinfo.status = Status.CRIFSWEBINSTALLER_STATUS_ERROR;
                this.synced_statusinfo.error = Error.CRIFSWEBINSTALLER_ERROR_TIMEOUT;
                return;
            }
            this.synced_statusinfo.contents_size = taskStatusInfoGetTaskStatusInfo.contents_size;
            this.synced_statusinfo.received_size = taskStatusInfoGetTaskStatusInfo.received_size;
            if (this.timeout_start_time + ((long) manager.inactive_timeout_sec) < GetNow() / 1000) {
                this.is_timeouted = true;
            }
            if (taskStatusInfoGetTaskStatusInfo.error == Error.CRIFSWEBINSTALLER_ERROR_NONE) {
                this.synced_statusinfo.status = Status.CRIFSWEBINSTALLER_STATUS_COMPLETE;
                this.synced_statusinfo.http_status_code = taskStatusInfoGetTaskStatusInfo.http_status_code;
                return;
            }
            if (IsRetryable(taskStatusInfoGetTaskStatusInfo.error, this.synced_statusinfo.contents_size)) {
                if (!this.is_waiting_to_start) {
                    this.is_waiting_to_start = true;
                    this.start_time = GetNow();
                    return;
                } else {
                    if (GetNow() - this.start_time >= 5000) {
                        this.is_waiting_to_start = false;
                        this.task_params.param_contents_size = this.synced_statusinfo.contents_size;
                        this.task_params.param_received_size = this.synced_statusinfo.received_size;
                        this.can_access_asynctask = false;
                        StartTask(this.task_params);
                        return;
                    }
                    return;
                }
            }
            this.synced_statusinfo.status = Status.CRIFSWEBINSTALLER_STATUS_ERROR;
            this.synced_statusinfo.error = taskStatusInfoGetTaskStatusInfo.error;
            this.synced_statusinfo.http_status_code = taskStatusInfoGetTaskStatusInfo.http_status_code;
        }
    }

    private long GetNow() {
        return new Date().getTime();
    }

    private static boolean IsRetryable(Error error, long j) {
        return (error == Error.CRIFSWEBINSTALLER_ERROR_CONNECTION || error == Error.CRIFSWEBINSTALLER_ERROR_DNS) && ((j > (-1L) ? 1 : (j == (-1L) ? 0 : -1)) != 0);
    }

    private void ClearMember() {
        CRC32 crc32;
        this.synced_statusinfo.status = Status.CRIFSWEBINSTALLER_STATUS_STOP;
        this.synced_statusinfo.error = Error.CRIFSWEBINSTALLER_ERROR_NONE;
        this.synced_statusinfo.http_status_code = -1;
        this.synced_statusinfo.contents_size = -1L;
        this.synced_statusinfo.received_size = 0L;
        this.start_time = 0L;
        this.timeout_start_time = 0L;
        this.is_waiting_to_start = false;
        this.is_timeouted = false;
        this.can_access_asynctask = false;
        if (!manager.crc_enabled || (crc32 = this.crc_num) == null) {
            return;
        }
        crc32.reset();
    }

    /* JADX INFO: renamed from: com.criware.filesystem.CriFsWebInstaller$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ AsyncTaskParam val$params;

        AnonymousClass1(AsyncTaskParam asyncTaskParam) {
            this.val$params = asyncTaskParam;
        }

        @Override // java.lang.Runnable
        public void run() {
            CriFsWebInstaller.this.task = CriFsWebInstaller.this.new WebInstallerTask();
            CriFsWebInstaller.this.task.execute(this.val$params);
            CriFsWebInstaller.this.can_access_asynctask = true;
        }
    }

    /* JADX INFO: renamed from: com.criware.filesystem.CriFsWebInstaller$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ AsyncTaskParam val$params;

        AnonymousClass2(AsyncTaskParam asyncTaskParam) {
            this.val$params = asyncTaskParam;
        }

        @Override // java.lang.Runnable
        public void run() {
            CriFsWebInstaller.this.task = CriFsWebInstaller.this.new WebInstallerTask();
            CriFsWebInstaller.this.task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.val$params);
            CriFsWebInstaller.this.can_access_asynctask = true;
        }
    }

    private void StartTask(AsyncTaskParam asyncTaskParam) {
        try {
            WebInstallerTask webInstallerTask = new WebInstallerTask();
            this.task = webInstallerTask;
            webInstallerTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, asyncTaskParam);
            this.can_access_asynctask = true;
        } catch (NullPointerException unused) {
            ErrorEntry(10);
            this.synced_statusinfo.status = Status.CRIFSWEBINSTALLER_STATUS_ERROR;
            this.synced_statusinfo.error = Error.CRIFSWEBINSTALLER_ERROR_MEMORY;
        }
    }

    public static void Initialize(Config config) {
        if (manager == null) {
            CriFsWebInstallerManager criFsWebInstallerManager = new CriFsWebInstallerManager();
            manager = criFsWebInstallerManager;
            criFsWebInstallerManager.Manager_Initialize(config);
            return;
        }
        ErrorEntry(1);
    }

    public static void Finalize() {
        CriFsWebInstallerManager criFsWebInstallerManager = manager;
        if (criFsWebInstallerManager != null) {
            criFsWebInstallerManager.Manager_Finalize();
            manager = null;
        } else {
            ErrorEntry(1);
        }
    }

    public static void SetRequestHeader(String str, String str2) {
        CriFsWebInstallerManager criFsWebInstallerManager = manager;
        if (criFsWebInstallerManager != null) {
            criFsWebInstallerManager.request_headers.set(str, str2);
        }
    }

    public static void ExecuteMain() {
        CriFsWebInstallerManager criFsWebInstallerManager = manager;
        if (criFsWebInstallerManager != null) {
            criFsWebInstallerManager.ExecuteMain();
        }
    }

    public static CriFsWebInstaller Create() {
        CriFsWebInstallerManager criFsWebInstallerManager = manager;
        if (criFsWebInstallerManager != null) {
            return criFsWebInstallerManager.CreateInstaller();
        }
        ErrorEntry(1);
        return null;
    }

    public void Destroy() {
        if (this.synced_statusinfo.status != Status.CRIFSWEBINSTALLER_STATUS_STOP) {
            ErrorEntry(2);
        } else if (manager.installer_list.remove(this)) {
            manager.num_installers--;
        }
    }

    public void Copy(String str, String str2) {
        if (this.synced_statusinfo.status != Status.CRIFSWEBINSTALLER_STATUS_STOP) {
            ErrorEntry(2);
            return;
        }
        ClearMember();
        this.is_stop_required = false;
        this.synced_statusinfo.status = Status.CRIFSWEBINSTALLER_STATUS_BUSY;
        this.task_params = new AsyncTaskParam(str, str2, this.synced_statusinfo.contents_size, this.synced_statusinfo.received_size);
        this.timeout_start_time = GetNow() / 1000;
        StartTask(this.task_params);
    }

    /* JADX INFO: renamed from: com.criware.filesystem.CriFsWebInstaller$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$criware$filesystem$CriFsWebInstaller$Status;
        static final /* synthetic */ int[] $SwitchMap$com$criware$filesystem$CriFsWebInstaller$TaskStatus;

        static {
            int[] iArr = new int[Status.values().length];
            $SwitchMap$com$criware$filesystem$CriFsWebInstaller$Status = iArr;
            try {
                iArr[Status.CRIFSWEBINSTALLER_STATUS_STOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$criware$filesystem$CriFsWebInstaller$Status[Status.CRIFSWEBINSTALLER_STATUS_BUSY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$criware$filesystem$CriFsWebInstaller$Status[Status.CRIFSWEBINSTALLER_STATUS_COMPLETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$criware$filesystem$CriFsWebInstaller$Status[Status.CRIFSWEBINSTALLER_STATUS_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[TaskStatus.values().length];
            $SwitchMap$com$criware$filesystem$CriFsWebInstaller$TaskStatus = iArr2;
            try {
                iArr2[TaskStatus.BUSY.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$criware$filesystem$CriFsWebInstaller$TaskStatus[TaskStatus.STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$criware$filesystem$CriFsWebInstaller$TaskStatus[TaskStatus.STOPPING.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public void Stop() {
        int i = AnonymousClass3.$SwitchMap$com$criware$filesystem$CriFsWebInstaller$Status[this.synced_statusinfo.status.ordinal()];
        if (i == 2) {
            this.is_stop_required = true;
        } else if (i == 3 || i == 4) {
            ClearMember();
        }
    }

    public int GetStatusInfo_status() {
        return this.synced_statusinfo.status.getValue();
    }

    public int GetStatusInfo_error() {
        return this.synced_statusinfo.error.getValue();
    }

    public int GetStatusInfo_http_status_code() {
        return this.synced_statusinfo.http_status_code;
    }

    public long GetStatusInfo_contents_size() {
        return this.synced_statusinfo.contents_size;
    }

    public long GetStatusInfo_received_size() {
        return this.synced_statusinfo.received_size;
    }

    public int IsCRCEnabled() {
        return manager.crc_enabled ? 1 : 0;
    }

    public long GetCRC32() {
        return this.crc_num.getValue();
    }

    public static boolean ErrorEntry(int i) {
        return ErrorCallback(i);
    }
}
