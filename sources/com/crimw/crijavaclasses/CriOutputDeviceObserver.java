package com.crimw.crijavaclasses;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.unity3d.player.UnityPlayer;

/* JADX INFO: loaded from: classes.dex */
public class CriOutputDeviceObserver {
    private static OutputDeviceStateReceiver receiver;

    private enum OutputDeviceType {
        BuiltinSpeaker(0),
        WiredDevice(1),
        WirelessDevice(2);

        private final int id;

        OutputDeviceType(int i) {
            this.id = i;
        }

        public int getInt() {
            return this.id;
        }
    }

    private class OutputDeviceStateReceiver extends BroadcastReceiver {
        private String gameObjectName;
        private String methodName;
        private boolean is_connected = false;
        private OutputDeviceType device_type = OutputDeviceType.BuiltinSpeaker;

        public OutputDeviceStateReceiver(Activity activity, String str, String str2) {
            this.gameObjectName = str;
            this.methodName = str2;
            checkOutputDeviceType(activity);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction()) || "android.intent.action.HEADSET_PLUG".equals(intent.getAction()) || "android.media.ACTION_SCO_AUDIO_STATE_UPDATED".equals(intent.getAction())) {
                UnityPlayer.UnitySendMessage(this.gameObjectName, this.methodName, "a");
            } else if ("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED".equals(intent.getAction()) || "android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(intent.getAction()) || "android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction())) {
                UnityPlayer.UnitySendMessage(this.gameObjectName, this.methodName, "b");
            }
        }

        public void setConnectedState(boolean z) {
            this.is_connected = z;
        }

        public boolean isConnected() {
            return this.is_connected;
        }

        public int getOutputDeviceType(Activity activity) {
            checkOutputDeviceType(activity);
            return this.device_type.getInt();
        }

        private void checkOutputDeviceType(Activity activity) {
            AudioManager audioManager = (AudioManager) activity.getSystemService("audio");
            if (audioManager.isWiredHeadsetOn()) {
                this.is_connected = true;
                this.device_type = OutputDeviceType.WiredDevice;
            } else if (audioManager.isBluetoothA2dpOn() || audioManager.isBluetoothScoOn()) {
                this.is_connected = true;
                this.device_type = OutputDeviceType.WirelessDevice;
            } else {
                this.is_connected = false;
                this.device_type = OutputDeviceType.BuiltinSpeaker;
            }
        }
    }

    public CriOutputDeviceObserver(Activity activity, String str, String str2) {
        receiver = new OutputDeviceStateReceiver(activity, str, str2);
    }

    public void Start(Activity activity) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        intentFilter.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
        intentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        activity.registerReceiver(receiver, intentFilter);
    }

    public void Stop(Activity activity) {
        activity.unregisterReceiver(receiver);
    }

    public boolean IsDeviceConnected() {
        return receiver.isConnected();
    }

    public int CheckOutputDeviceType(Activity activity) {
        return receiver.getOutputDeviceType(activity);
    }
}
