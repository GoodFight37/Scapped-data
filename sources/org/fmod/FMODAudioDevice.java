package org.fmod;

import android.media.AudioTrack;
import android.util.Log;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class FMODAudioDevice implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Thread f1131a = null;
    private volatile boolean b = false;
    private AudioTrack c = null;
    private boolean d = false;
    private ByteBuffer e = null;
    private byte[] f = null;
    private volatile a g;

    private native int fmodGetInfo(int i);

    private native int fmodProcess(ByteBuffer byteBuffer);

    native int fmodProcessMicData(ByteBuffer byteBuffer, int i);

    public synchronized void start() {
        if (this.f1131a != null) {
            stop();
        }
        this.f1131a = new Thread(this, "FMODAudioDevice");
        this.f1131a.setPriority(10);
        this.b = true;
        this.f1131a.start();
        if (this.g != null) {
            a aVar = this.g;
            if (aVar.e != null) {
                aVar.b();
            }
            aVar.f = true;
            aVar.e = new Thread(aVar);
            aVar.e.start();
        }
    }

    public synchronized void stop() {
        while (this.f1131a != null) {
            this.b = false;
            try {
                this.f1131a.join();
                this.f1131a = null;
            } catch (InterruptedException unused) {
            }
        }
        if (this.g != null) {
            this.g.b();
        }
    }

    public synchronized void close() {
        stop();
    }

    public boolean isRunning() {
        return this.f1131a != null && this.f1131a.isAlive();
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = 3;
        while (this.b) {
            if (!this.d && i > 0) {
                releaseAudioTrack();
                int iFmodGetInfo = fmodGetInfo(0);
                int i2 = fmodGetInfo(4) == 1 ? 4 : 12;
                int minBufferSize = AudioTrack.getMinBufferSize(iFmodGetInfo, i2, 2);
                int iFmodGetInfo2 = fmodGetInfo(4) * 2;
                int iRound = Math.round(minBufferSize * 1.1f) & (~(iFmodGetInfo2 - 1));
                int iFmodGetInfo3 = fmodGetInfo(1);
                int iFmodGetInfo4 = fmodGetInfo(2) * iFmodGetInfo3 * iFmodGetInfo2;
                AudioTrack audioTrack = new AudioTrack(3, iFmodGetInfo, i2, 2, iFmodGetInfo4 > iRound ? iFmodGetInfo4 : iRound, 1);
                this.c = audioTrack;
                boolean z = audioTrack.getState() == 1;
                this.d = z;
                if (z) {
                    ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(iFmodGetInfo3 * iFmodGetInfo2);
                    this.e = byteBufferAllocateDirect;
                    this.f = new byte[byteBufferAllocateDirect.capacity()];
                    this.c.play();
                    i = 3;
                } else {
                    Log.e("FMOD", "AudioTrack failed to initialize (status " + this.c.getState() + ")");
                    releaseAudioTrack();
                    i--;
                }
            }
            if (this.d) {
                if (fmodGetInfo(3) == 1) {
                    fmodProcess(this.e);
                    ByteBuffer byteBuffer = this.e;
                    byteBuffer.get(this.f, 0, byteBuffer.capacity());
                    this.c.write(this.f, 0, this.e.capacity());
                    this.e.position(0);
                } else {
                    releaseAudioTrack();
                }
            }
        }
        releaseAudioTrack();
    }

    private void releaseAudioTrack() {
        AudioTrack audioTrack = this.c;
        if (audioTrack != null) {
            if (audioTrack.getState() == 1) {
                this.c.stop();
            }
            this.c.release();
            this.c = null;
        }
        this.e = null;
        this.f = null;
        this.d = false;
    }

    public synchronized int startAudioRecord(int i, int i2, int i3) {
        if (this.g == null) {
            this.g = new a(this, i, i2);
            a aVar = this.g;
            if (aVar.e != null) {
                aVar.b();
            }
            aVar.f = true;
            aVar.e = new Thread(aVar);
            aVar.e.start();
        }
        return this.g.b.capacity();
    }

    public synchronized void stopAudioRecord() {
        if (this.g != null) {
            this.g.b();
            this.g = null;
        }
    }
}
