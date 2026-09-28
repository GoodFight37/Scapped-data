package com.nintendo.npf.sdk.internal.impl.cpp;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.internal.impl.NativeBridgeUtil;
import com.nintendo.npf.sdk.mynintendo.MissionStatus;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public class MissionStatusEventHandler implements MissionStatus.ReceivingGiftsCallback, MissionStatus.RetrievingCallback {
    private static Map c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f852a;
    private long b;

    public MissionStatusEventHandler() {
        this.f852a = -1L;
        this.b = -1L;
    }

    public static void getAll(long j, long j2) {
        c.clear();
        MissionStatus.getAll(new MissionStatusEventHandler(j, j2));
    }

    private static native void onMissionStatusGetAllComplete(long j, long j2, String str, String str2);

    private static native void onMissionStatusReceiveAvailableGifts(long j, long j2, String str);

    public static void receiveAvailableGifts(long j, long j2, String str) {
        Map map = c;
        MissionStatus missionStatus = (map == null || str == null) ? null : (MissionStatus) map.get(str);
        if (missionStatus != null) {
            missionStatus.receiveAvailableGifts(new MissionStatusEventHandler(j, j2));
            return;
        }
        try {
            onMissionStatusReceiveAvailableGifts(j, j2, NativeBridgeUtil.toJsonFromNPFError(new NPFError(NPFError.ErrorType.NPF_ERROR, 500, "Can't find the MissionStatus! (missionId : " + str + ")")).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.nintendo.npf.sdk.mynintendo.MissionStatus.RetrievingCallback
    public void onComplete(List<MissionStatus> list, NPFError nPFError) {
        String str;
        String string;
        String str2;
        String string2 = null;
        if (list != null) {
            try {
                for (MissionStatus missionStatus : list) {
                    c.put(missionStatus.getMissionId(), missionStatus);
                }
                string = NativeBridgeUtil.toJsonFromMissionStatuses(list).toString();
            } catch (JSONException e) {
                e = e;
                str = null;
                e.printStackTrace();
                str2 = str;
                onMissionStatusGetAllComplete(this.f852a, this.b, str2, string2);
            }
        } else {
            string = null;
        }
        if (nPFError != null) {
            try {
                string2 = NativeBridgeUtil.toJsonFromNPFError(nPFError).toString();
            } catch (JSONException e2) {
                str = string;
                e = e2;
                e.printStackTrace();
                str2 = str;
            }
        }
        str2 = string;
        onMissionStatusGetAllComplete(this.f852a, this.b, str2, string2);
    }

    public MissionStatusEventHandler(long j, long j2) {
        this.f852a = j;
        this.b = j2;
    }

    @Override // com.nintendo.npf.sdk.mynintendo.MissionStatus.ReceivingGiftsCallback
    public void onComplete(NPFError nPFError) {
        if (nPFError != null) {
            try {
                onMissionStatusReceiveAvailableGifts(this.f852a, this.b, NativeBridgeUtil.toJsonFromNPFError(nPFError).toString());
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        onMissionStatusReceiveAvailableGifts(this.f852a, this.b, null);
    }
}
