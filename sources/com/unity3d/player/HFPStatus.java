package com.unity3d.player;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.unity3d.player.a.AbstractC0086t;

/* JADX INFO: loaded from: classes2.dex */
public class HFPStatus {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1022a;
    public final AudioManager d;
    public BroadcastReceiver b = null;
    public boolean c = false;
    public boolean e = false;
    public int f = 1;

    private final native void deinitHFPStatusJni();

    private final native void initHFPStatusJni();

    public HFPStatus(Context context) {
        this.d = null;
        this.f1022a = context;
        this.d = (AudioManager) context.getSystemService("audio");
        initHFPStatusJni();
    }

    public final void b() {
        clearHFPStat();
        deinitHFPStatusJni();
    }

    public void requestHFPStat() {
        clearHFPStat();
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.unity3d.player.HFPStatus.1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                if (intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1) != 1) {
                    return;
                }
                HFPStatus hFPStatus = HFPStatus.this;
                hFPStatus.f = 2;
                hFPStatus.a();
                HFPStatus hFPStatus2 = HFPStatus.this;
                if (hFPStatus2.c) {
                    hFPStatus2.d.setMode(3);
                }
            }
        };
        this.b = broadcastReceiver;
        this.f1022a.registerReceiver(broadcastReceiver, new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));
        try {
            this.e = true;
            this.d.startBluetoothSco();
        } catch (NullPointerException unused) {
            AbstractC0086t.Log(5, "startBluetoothSco() failed. no bluetooth device connected.");
        }
    }

    public boolean getHFPStat() {
        return this.f == 2;
    }

    public void setHFPRecordingStat(boolean z) {
        this.c = z;
        if (z) {
            return;
        }
        this.d.setMode(0);
    }

    public void clearHFPStat() {
        BroadcastReceiver broadcastReceiver = this.b;
        if (broadcastReceiver != null) {
            this.f1022a.unregisterReceiver(broadcastReceiver);
            this.b = null;
        }
        this.f = 1;
        a();
    }

    public final void a() {
        if (this.e) {
            this.e = false;
            this.d.stopBluetoothSco();
        }
    }
}
