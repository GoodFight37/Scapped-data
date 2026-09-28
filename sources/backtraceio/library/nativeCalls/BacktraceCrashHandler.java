package backtraceio.library.nativeCalls;

import android.util.Log;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class BacktraceCrashHandler {
    public static final String BACKTRACE_CRASH_HANDLER = "BACKTRACE_UNITY_CRASH_HANDLER";
    private static final String LOG_TAG = "BacktraceCrashHandler";

    private static native boolean handleCrash(String[] strArr);

    public static void main(String[] strArr) {
        run(strArr, System.getenv());
    }

    public static boolean run(String[] strArr, Map<String, String> map) {
        if (map == null) {
            Log.e(LOG_TAG, "Cannot capture crash dump. Environment variables are undefined");
            return false;
        }
        String str = map.get(BACKTRACE_CRASH_HANDLER);
        if (str == null) {
            Log.e(LOG_TAG, String.format("Cannot capture crash dump. Cannot find %s environment variable", BACKTRACE_CRASH_HANDLER));
            return false;
        }
        System.load(str);
        if (!handleCrash(strArr)) {
            Log.e(LOG_TAG, String.format("Cannot capture crash dump. Invocation parameters: %s", BacktraceCrashHandler$$ExternalSyntheticBackport0.m(" ", strArr)));
            return false;
        }
        Log.i(LOG_TAG, "Successfully ran crash handler code.");
        return true;
    }
}
