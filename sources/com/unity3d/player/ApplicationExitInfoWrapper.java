package com.unity3d.player;

import android.app.ApplicationExitInfo;
import com.unity3d.player.a.AbstractC0086t;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes2.dex */
class ApplicationExitInfoWrapper extends ApplicationExitInfoBase {
    private ApplicationExitInfo mApplicationExitInfo;

    protected static Object GetStaticFieldByReflection(Class cls, String str, Object obj, boolean z) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            if (z) {
                declaredField.setAccessible(true);
            }
            return declaredField.get(null);
        } catch (NoSuchFieldException e) {
            AbstractC0086t.Log(6, "ApplicationExitInfo: GetStaticFieldByReflection NoSuchFieldException " + e);
            return obj;
        } catch (Exception e2) {
            AbstractC0086t.Log(6, "ApplicationExitInfo: GetStaticFieldByReflection exception " + e2);
            return obj;
        }
    }

    private boolean checkSupport() {
        return this.mApplicationExitInfo != null && PlatformSupport.RED_VELVET_CAKE_SUPPORT;
    }

    public ApplicationExitInfoWrapper(ApplicationExitInfo applicationExitInfo) {
        this.mApplicationExitInfo = applicationExitInfo;
    }

    @Override // com.unity3d.player.ApplicationExitInfoBase
    public String getDescription() {
        if (checkSupport()) {
            return this.mApplicationExitInfo.getDescription();
        }
        return null;
    }

    @Override // com.unity3d.player.ApplicationExitInfoBase
    public int describeContents() {
        if (checkSupport()) {
            return this.mApplicationExitInfo.describeContents();
        }
        return 0;
    }

    @Override // com.unity3d.player.ApplicationExitInfoBase
    public int getDefiningUid() {
        if (checkSupport()) {
            return this.mApplicationExitInfo.getDefiningUid();
        }
        return 0;
    }

    @Override // com.unity3d.player.ApplicationExitInfoBase
    public int getImportance() {
        if (checkSupport()) {
            return this.mApplicationExitInfo.getImportance();
        }
        return 0;
    }

    @Override // com.unity3d.player.ApplicationExitInfoBase
    public int getPackageUid() {
        if (checkSupport()) {
            return this.mApplicationExitInfo.getPackageUid();
        }
        return 0;
    }

    @Override // com.unity3d.player.ApplicationExitInfoBase
    public int getPid() {
        if (checkSupport()) {
            return this.mApplicationExitInfo.getPid();
        }
        return 0;
    }

    @Override // com.unity3d.player.ApplicationExitInfoBase
    public String getProcessName() {
        if (checkSupport()) {
            return this.mApplicationExitInfo.getProcessName();
        }
        return null;
    }

    @Override // com.unity3d.player.ApplicationExitInfoBase
    public byte[] getProcessStateSummary() {
        if (checkSupport()) {
            return this.mApplicationExitInfo.getProcessStateSummary();
        }
        return new byte[0];
    }

    @Override // com.unity3d.player.ApplicationExitInfoBase
    public long getPss() {
        if (checkSupport()) {
            return this.mApplicationExitInfo.getPss();
        }
        return 0L;
    }

    @Override // com.unity3d.player.ApplicationExitInfoBase
    public int getRealUid() {
        if (checkSupport()) {
            return this.mApplicationExitInfo.getRealUid();
        }
        return 0;
    }

    @Override // com.unity3d.player.ApplicationExitInfoBase
    public int getReason() {
        if (checkSupport()) {
            return this.mApplicationExitInfo.getReason();
        }
        return 0;
    }

    @Override // com.unity3d.player.ApplicationExitInfoBase
    public long getRss() {
        if (checkSupport()) {
            return this.mApplicationExitInfo.getRss();
        }
        return 0L;
    }

    @Override // com.unity3d.player.ApplicationExitInfoBase
    public int getStatus() {
        if (checkSupport()) {
            return this.mApplicationExitInfo.getStatus();
        }
        return 0;
    }

    @Override // com.unity3d.player.ApplicationExitInfoBase
    public long getTimestamp() {
        if (checkSupport()) {
            return this.mApplicationExitInfo.getTimestamp();
        }
        return 0L;
    }

    @Override // com.unity3d.player.ApplicationExitInfoBase
    public byte[] getTrace() {
        if (!checkSupport()) {
            return null;
        }
        try {
            return readAllBytes(this.mApplicationExitInfo.getTraceInputStream());
        } catch (IOException e) {
            AbstractC0086t.Log(6, "ApplicationExitInfo: getTrace exception " + e);
            return null;
        }
    }

    @Override // com.unity3d.player.ApplicationExitInfoBase
    public String getTraceString() {
        byte[] trace = getTrace();
        if (trace == null || trace.length == 0) {
            return "";
        }
        return new String(trace, StandardCharsets.UTF_8);
    }

    private byte[] readAllBytes(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int i = inputStream.read(bArr, 0, 1024);
                if (i > 0) {
                    byteArrayOutputStream.write(bArr, 0, i);
                } else {
                    return byteArrayOutputStream.toByteArray();
                }
            } catch (IOException e) {
                AbstractC0086t.Log(6, "ApplicationExitInfo: readAllBytes exception " + e);
                throw e;
            }
        }
    }
}
