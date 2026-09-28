package com.nintendo.npf.sdk.mynintendo;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.core.x4;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;

/* JADX INFO: loaded from: classes2.dex */
public class MissionStatus {
    private Map<String, Long> availableGifts;
    private boolean completed;
    private Integer currentSteps;
    private String detail;
    private Long limitEndsAt;
    private boolean limited;
    private String missionId;
    private String missionKey;
    private int pointAmount;
    private Integer timesCompleted;
    private String title;
    private int totalSteps;

    @Deprecated(message = "Deprecated since 3.3")
    public interface ReceivingGiftsCallback {
        void onComplete(NPFError nPFError);
    }

    public interface RetrievingCallback {
        void onComplete(List<MissionStatus> list, NPFError nPFError);
    }

    class a implements RetrievingCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RetrievingCallback f886a;

        a(RetrievingCallback retrievingCallback) {
            this.f886a = retrievingCallback;
        }

        @Override // com.nintendo.npf.sdk.mynintendo.MissionStatus.RetrievingCallback
        public void onComplete(List list, NPFError nPFError) {
            RetrievingCallback retrievingCallback = this.f886a;
            if (retrievingCallback != null) {
                retrievingCallback.onComplete(list, nPFError);
            }
        }
    }

    class b implements ReceivingGiftsCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ReceivingGiftsCallback f887a;

        b(ReceivingGiftsCallback receivingGiftsCallback) {
            this.f887a = receivingGiftsCallback;
        }

        @Override // com.nintendo.npf.sdk.mynintendo.MissionStatus.ReceivingGiftsCallback
        public void onComplete(NPFError nPFError) {
            ReceivingGiftsCallback receivingGiftsCallback = this.f887a;
            if (receivingGiftsCallback != null) {
                receivingGiftsCallback.onComplete(nPFError);
            }
        }
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final x4 f888a = x4.a.a();
    }

    protected MissionStatus(String str, String str2, String str3, String str4, int i, boolean z, Integer num, int i2, Integer num2, boolean z2, Long l, Map map) {
        this.missionId = str;
        this.missionKey = str2;
        this.title = str3;
        this.detail = str4;
        this.pointAmount = i;
        this.completed = z;
        this.timesCompleted = num;
        this.totalSteps = i2;
        this.currentSteps = num2;
        this.limited = z2;
        this.limitEndsAt = l;
        this.availableGifts = map;
    }

    public static void getAll(RetrievingCallback retrievingCallback) {
        c.f888a.getMissionStatus().a(new a(retrievingCallback));
    }

    public Map<String, Long> getAvailableGifts() {
        return this.availableGifts;
    }

    public Integer getCurrentSteps() {
        return this.currentSteps;
    }

    public String getDetail() {
        return this.detail;
    }

    public Long getLimitEndsAt() {
        return this.limitEndsAt;
    }

    public boolean getLimited() {
        return this.limited;
    }

    public String getMissionId() {
        return this.missionId;
    }

    public String getMissionKey() {
        return this.missionKey;
    }

    public int getPointAmount() {
        return this.pointAmount;
    }

    public Integer getTimesCompleted() {
        return this.timesCompleted;
    }

    public String getTitle() {
        return this.title;
    }

    public int getTotalSteps() {
        return this.totalSteps;
    }

    public boolean isCompleted() {
        return this.completed;
    }

    @Deprecated(message = "Deprecated since 3.3")
    public void receiveAvailableGifts(ReceivingGiftsCallback receivingGiftsCallback) {
        c.f888a.getMissionStatus().a(this.availableGifts, new b(receivingGiftsCallback));
    }
}
