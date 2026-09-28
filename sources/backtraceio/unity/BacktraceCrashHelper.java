package backtraceio.unity;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class BacktraceCrashHelper {
    public void throwRuntimeException() {
        Log.d("BacktraceCrashHelper", "Throwing runtime exception");
        throw new RuntimeException("Unity-test: Uncaught JVM exception");
    }

    public void throwBackgroundJavaException() {
        Log.d("BacktraceCrashHelper", "throwing an unhandled background java exception");
        new Thread(new Runnable() { // from class: backtraceio.unity.BacktraceCrashHelper.1
            @Override // java.lang.Runnable
            public void run() {
                Log.d("BacktraceCrashHelper", String.valueOf(new int[]{10, 20, 30, 40}[5]));
            }
        }).start();
    }

    public static void StartAnr() {
        Log.d("BacktraceCrashHelper", "Starting ANR");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: backtraceio.unity.BacktraceCrashHelper.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Thread.sleep(10000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void ThrowNativeException() {
        Log.d("BacktraceCrashHelper", "Trying to throw native exception");
        InternalCall();
    }

    private static void InternalCall() {
        Log.d("BacktraceCrashHelper", String.valueOf(new int[]{10, 20, 30, 40}[5]));
    }
}
