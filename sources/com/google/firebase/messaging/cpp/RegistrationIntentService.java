package com.google.firebase.messaging.cpp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.core.app.JobIntentService;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.flatbuffers.FlatBufferBuilder;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: classes2.dex */
public class RegistrationIntentService extends JobIntentService {
    private static final String TAG = "FirebaseRegService";

    @Override // androidx.core.app.JobIntentService
    protected void onHandleWork(Intent intent) {
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() { // from class: com.google.firebase.messaging.cpp.RegistrationIntentService.1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public void onComplete(Task<String> task) {
                if (!task.isSuccessful()) {
                    Log.w(RegistrationIntentService.TAG, "Fetching FCM registration token failed", task.getException());
                    return;
                }
                String result = task.getResult();
                DebugLogging.log(RegistrationIntentService.TAG, String.format("onHandleWork token=%s", result));
                if (result != null) {
                    RegistrationIntentService.writeTokenToInternalStorage(this, result);
                }
            }
        });
    }

    public static void writeTokenToInternalStorage(Context context, String str) {
        byte[] bArrGenerateTokenByteBuffer = generateTokenByteBuffer(str);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferAllocate.putInt(bArrGenerateTokenByteBuffer.length);
        try {
            FileOutputStream fileOutputStreamOpenFileOutput = context.openFileOutput("FIREBASE_CLOUD_MESSAGING_LOCKFILE", 0);
            try {
                FileLock fileLockLock = fileOutputStreamOpenFileOutput.getChannel().lock();
                try {
                    FileOutputStream fileOutputStreamOpenFileOutput2 = context.openFileOutput("FIREBASE_CLOUD_MESSAGING_LOCAL_STORAGE", 32768);
                    try {
                        fileOutputStreamOpenFileOutput2.write(byteBufferAllocate.array());
                        fileOutputStreamOpenFileOutput2.write(bArrGenerateTokenByteBuffer);
                        if (fileOutputStreamOpenFileOutput2 != null) {
                            fileOutputStreamOpenFileOutput2.close();
                        }
                        if (fileLockLock != null) {
                            fileLockLock.close();
                        }
                        if (fileOutputStreamOpenFileOutput != null) {
                            fileOutputStreamOpenFileOutput.close();
                        }
                    } catch (Throwable th) {
                        if (fileOutputStreamOpenFileOutput2 != null) {
                            try {
                                fileOutputStreamOpenFileOutput2.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    if (fileLockLock != null) {
                        try {
                            fileLockLock.close();
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                        }
                    }
                    throw th3;
                }
            } catch (Throwable th5) {
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (Throwable th6) {
                        th5.addSuppressed(th6);
                    }
                }
                throw th5;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static byte[] generateTokenByteBuffer(String str) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(0);
        if (str == null) {
            str = "";
        }
        int iCreateString = flatBufferBuilder.createString(str);
        SerializedTokenReceived.startSerializedTokenReceived(flatBufferBuilder);
        SerializedTokenReceived.addToken(flatBufferBuilder, iCreateString);
        int iEndSerializedTokenReceived = SerializedTokenReceived.endSerializedTokenReceived(flatBufferBuilder);
        SerializedEvent.startSerializedEvent(flatBufferBuilder);
        SerializedEvent.addEventType(flatBufferBuilder, (byte) 2);
        SerializedEvent.addEvent(flatBufferBuilder, iEndSerializedTokenReceived);
        flatBufferBuilder.finish(SerializedEvent.endSerializedEvent(flatBufferBuilder));
        return flatBufferBuilder.sizedByteArray();
    }
}
