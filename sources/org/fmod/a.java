package org.fmod;

import android.media.AudioRecord;
import android.util.Log;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FMODAudioDevice f1134a;
    public final ByteBuffer b;
    public final int c;
    public final int d;
    public volatile Thread e;
    public volatile boolean f;
    public AudioRecord g;
    public boolean h;

    public a(FMODAudioDevice fMODAudioDevice, int i, int i2) {
        this.f1134a = fMODAudioDevice;
        this.c = i;
        this.d = i2;
        this.b = ByteBuffer.allocateDirect(AudioRecord.getMinBufferSize(i, i2, 2));
    }

    public final void b() {
        while (this.e != null) {
            this.f = false;
            try {
                this.e.join();
                this.e = null;
            } catch (InterruptedException unused) {
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = 3;
        while (this.f) {
            if (!this.h && i > 0) {
                a();
                AudioRecord audioRecord = new AudioRecord(1, this.c, this.d, 2, this.b.capacity());
                this.g = audioRecord;
                boolean z = audioRecord.getState() == 1;
                this.h = z;
                if (z) {
                    this.b.position(0);
                    this.g.startRecording();
                    i = 3;
                } else {
                    Log.e("FMOD", "AudioRecord failed to initialize (status " + this.g.getState() + ")");
                    i--;
                    a();
                }
            }
            if (this.h && this.g.getRecordingState() == 3) {
                AudioRecord audioRecord2 = this.g;
                ByteBuffer byteBuffer = this.b;
                this.f1134a.fmodProcessMicData(this.b, audioRecord2.read(byteBuffer, byteBuffer.capacity()));
                this.b.position(0);
            }
        }
        a();
    }

    public final void a() {
        AudioRecord audioRecord = this.g;
        if (audioRecord != null) {
            if (audioRecord.getState() == 1) {
                this.g.stop();
            }
            this.g.release();
            this.g = null;
        }
        this.b.position(0);
        this.h = false;
    }
}
