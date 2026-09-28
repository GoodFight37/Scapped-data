package org.fmod;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;

/* JADX INFO: loaded from: classes2.dex */
public class FmodAndroidAudioManager {
    private static FmodAndroidAudioManager f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Activity f1132a = null;
    private volatile AudioManager b = null;
    private BroadcastReceiver c = null;
    private boolean d = false;
    private boolean e = false;

    private FmodAndroidAudioManager() {
    }

    public static FmodAndroidAudioManager getInstance() {
        if (f == null) {
            f = new FmodAndroidAudioManager();
        }
        return f;
    }

    public void setActivity(Activity activity) {
        if (this.f1132a != activity) {
            if (this.c != null) {
                this.f1132a.unregisterReceiver(this.c);
                this.c = null;
                this.e = false;
            }
            this.f1132a = activity;
            this.b = this.f1132a != null ? (AudioManager) this.f1132a.getSystemService("audio") : null;
        }
    }

    public void setUseBluetooth(boolean z) {
        this.d = z;
    }

    public void startBluetoothSco() {
        if (this.c == null) {
            this.c = new BroadcastReceiver() { // from class: org.fmod.FmodAndroidAudioManager.1
                @Override // android.content.BroadcastReceiver
                public final void onReceive(Context context, Intent intent) {
                    int intExtra = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
                    if (intExtra == 0) {
                        FmodAndroidAudioManager.this.e = false;
                    } else {
                        if (intExtra != 1) {
                            return;
                        }
                        FmodAndroidAudioManager.this.e = true;
                    }
                }
            };
            this.f1132a.registerReceiver(this.c, new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));
        }
        this.b.startBluetoothSco();
    }

    public void stopBluetoothSco() {
        this.b.stopBluetoothSco();
    }

    public boolean isBluetoothScoConnected() {
        return this.e;
    }

    public boolean isBuiltinInputDeviceAvailable() {
        for (AudioDeviceInfo audioDeviceInfo : this.b.getDevices(1)) {
            if (audioDeviceInfo.getType() == 15) {
                return true;
            }
        }
        return false;
    }

    public boolean isBluetoothInputDeviceAvailable() {
        for (AudioDeviceInfo audioDeviceInfo : this.b.getDevices(1)) {
            if (audioDeviceInfo.getType() == 7) {
                return true;
            }
        }
        return false;
    }

    public int getBluetoothInputDeviceId() {
        for (AudioDeviceInfo audioDeviceInfo : this.b.getDevices(1)) {
            if (audioDeviceInfo.getType() == 7) {
                return audioDeviceInfo.getId();
            }
        }
        return -1;
    }

    public boolean isInputSampleRateAvailable(int i) {
        for (AudioDeviceInfo audioDeviceInfo : this.b.getDevices(1)) {
            if ((this.d && audioDeviceInfo.getType() == 7) || (!this.d && audioDeviceInfo.getType() == 15)) {
                for (int i2 : audioDeviceInfo.getSampleRates()) {
                    if (i2 == i) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isBuiltinSpeakerDevice(int i) {
        for (AudioDeviceInfo audioDeviceInfo : this.b.getDevices(2)) {
            if (audioDeviceInfo.getId() == i && audioDeviceInfo.getType() == 2) {
                return true;
            }
        }
        return false;
    }
}
