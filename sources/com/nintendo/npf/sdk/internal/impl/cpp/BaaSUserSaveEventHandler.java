package com.nintendo.npf.sdk.internal.impl.cpp;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.core.x4;
import com.nintendo.npf.sdk.internal.impl.NativeBridgeUtil;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.user.Gender;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public class BaaSUserSaveEventHandler implements BaaSUser.SaveCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f845a;
    private long b;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final x4 f846a = x4.a.a();
    }

    public BaaSUserSaveEventHandler() {
        this.f845a = -1L;
        this.b = -1L;
    }

    private static native void onSaveCallback(long j, long j2, String str, String str2);

    public static void save(long j, long j2, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2, int i3) {
        BaaSUser baaSUserC = a.f846a.getNPFSDK().c();
        baaSUserC.setNickname(new String(bArr));
        baaSUserC.setCountry(new String(bArr2));
        Gender gender = Gender.UNKNOWN;
        if ("male".equals(new String(bArr3))) {
            gender = Gender.MALE;
        }
        if ("female".equals(new String(bArr3))) {
            gender = Gender.FEMALE;
        }
        baaSUserC.setGender(gender);
        baaSUserC.setBirthdayYear(i);
        baaSUserC.setBirthdayMonth(i2);
        baaSUserC.setBirthdayDay(i3);
        baaSUserC.save(new BaaSUserSaveEventHandler(j, j2));
    }

    @Override // com.nintendo.npf.sdk.user.BaaSUser.SaveCallback
    public void onComplete(NPFError nPFError) {
        String string;
        String string2 = null;
        try {
            string = NativeBridgeUtil.toJsonFromBaaSUser(a.f846a.getNPFSDK().c()).toString();
            if (nPFError != null) {
                try {
                    string2 = NativeBridgeUtil.toJsonFromNPFError(nPFError).toString();
                } catch (JSONException e) {
                    e = e;
                    e.printStackTrace();
                }
            }
        } catch (JSONException e2) {
            e = e2;
            string = null;
        }
        onSaveCallback(this.f845a, this.b, string, string2);
    }

    public BaaSUserSaveEventHandler(long j, long j2) {
        this.f845a = j;
        this.b = j2;
    }
}
