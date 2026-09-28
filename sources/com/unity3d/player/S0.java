package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import android.widget.MediaController;
import com.unity3d.player.a.C0090x;
import com.unity3d.player.a.C0091y;
import java.io.FileInputStream;
import java.io.IOException;
import kotlin.time.DurationKt;

/* JADX INFO: loaded from: classes2.dex */
public class S0 extends FrameLayout implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, SurfaceHolder.Callback, MediaController.MediaPlayerControl {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1040a;
    public final SurfaceView b;
    public final SurfaceHolder c;
    public final String d;
    public final int e;
    public final int f;
    public final boolean g;
    public final long h;
    public final long i;
    public final S0 j;
    public int k;
    public int l;
    public int m;
    public int n;
    public MediaPlayer o;
    public MediaController p;
    public boolean q;
    public boolean r;
    public int s;
    public boolean t;
    public int u;
    public boolean v;
    public C0091y w;
    public final Q0 x;
    public R0 y;
    public volatile int z;

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return true;
    }

    public S0(Context context, UnityPlayer unityPlayer, String str, int i, int i2, int i3, boolean z, long j, long j2, Q0 q0) {
        super(context);
        this.q = false;
        this.r = false;
        this.s = 0;
        this.t = false;
        this.u = 0;
        this.v = false;
        this.w = null;
        this.z = 0;
        this.x = q0;
        this.f1040a = context;
        this.j = this;
        SurfaceView surfaceView = new SurfaceView(context);
        this.b = surfaceView;
        SurfaceHolder holder = surfaceView.getHolder();
        this.c = holder;
        holder.addCallback(this);
        setBackgroundColor(i);
        addView(surfaceView);
        this.d = str;
        this.e = i2;
        this.f = i3;
        this.g = z;
        this.h = j;
        this.i = j2;
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.w = C0117n.a(unityPlayer.getActivity(), DurationKt.NANOS_IN_MILLIS, new P0(this));
    }

    public final void a(int i) {
        this.z = i;
        Q0 q0 = this.x;
        if (q0 != null) {
            int i2 = this.z;
            com.unity3d.player.a.T t = (com.unity3d.player.a.T) q0;
            t.f1067a.h.e.lock();
            com.unity3d.player.a.Y y = t.f1067a.h;
            y.g = i2;
            if (i2 == 3 && y.i) {
                y.runOnUiThread(new com.unity3d.player.a.S(t));
            }
            if (i2 != 0) {
                t.f1067a.h.d.release();
            }
            t.f1067a.h.e.unlock();
        }
    }

    public void destroyPlayer() {
        if (!this.t) {
            pause();
        }
        doCleanUp();
        C0091y c0091y = this.w;
        if (c0091y != null) {
            c0091y.unregisterOnBackPressedCallback();
            this.w = null;
        }
    }

    public void cancelOnPrepare() {
        a(2);
    }

    public boolean exitOnKeypress(int i, KeyEvent keyEvent) {
        Runnable runnable;
        if (i != 4 && (this.e != 2 || i == 0 || keyEvent.isSystem())) {
            return false;
        }
        C0090x c0090x = this.w.f1091a;
        if (c0090x == null || (runnable = c0090x.f1090a) == null) {
            return true;
        }
        runnable.run();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (exitOnKeypress(i, keyEvent)) {
            return true;
        }
        MediaController mediaController = this.p;
        if (mediaController != null) {
            return mediaController.onKeyUp(i, keyEvent);
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        MediaController mediaController = this.p;
        if (mediaController != null) {
            return mediaController.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (this.e == 2 && action == 0) {
            destroyPlayer();
            a(3);
            return true;
        }
        MediaController mediaController = this.p;
        if (mediaController != null) {
            return mediaController.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.s = i;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        destroyPlayer();
        a(3);
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        if (i == 0 || i2 == 0) {
            return;
        }
        this.q = true;
        this.m = i;
        this.n = i2;
        if (!this.r || isPlaying()) {
            return;
        }
        a(1);
        updateVideoLayout();
        if (this.t) {
            return;
        }
        start();
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        R0 r0 = this.y;
        if (r0 != null) {
            r0.b = true;
            this.y = null;
        }
        int i = this.e;
        if (i == 0 || i == 1) {
            MediaController mediaController = new MediaController(this.f1040a);
            this.p = mediaController;
            mediaController.setMediaPlayer(this);
            this.p.setAnchorView(this);
            this.p.setEnabled(true);
            Context context = this.f1040a;
            if (context instanceof Activity) {
                this.p.setSystemUiVisibility(((Activity) context).getWindow().getDecorView().getSystemUiVisibility());
            }
            this.p.show();
        }
        this.r = true;
        if (!this.q || isPlaying()) {
            return;
        }
        a(1);
        updateVideoLayout();
        if (this.t) {
            return;
        }
        start();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (this.k == i2 && this.l == i3) {
            return;
        }
        this.k = i2;
        this.l = i3;
        if (this.v) {
            updateVideoLayout();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.v = false;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.v = true;
        if (this.t) {
            MediaPlayer mediaPlayer = this.o;
            if (mediaPlayer == null || this.u <= 0) {
                return;
            }
            mediaPlayer.setDisplay(this.c);
            this.o.seekTo(this.u);
            return;
        }
        MediaPlayer mediaPlayer2 = this.o;
        if (mediaPlayer2 != null) {
            mediaPlayer2.setDisplay(this.c);
            if (this.t) {
                return;
            }
            int i = this.u;
            if (i > 0) {
                this.o.seekTo(i);
            }
            this.o.start();
            this.u = 0;
            return;
        }
        a(0);
        doCleanUp();
        try {
            MediaPlayer mediaPlayer3 = new MediaPlayer();
            this.o = mediaPlayer3;
            if (this.g) {
                mediaPlayer3.setDataSource(this.f1040a, Uri.parse(this.d));
            } else if (this.i != 0) {
                FileInputStream fileInputStream = new FileInputStream(this.d);
                this.o.setDataSource(fileInputStream.getFD(), this.h, this.i);
                fileInputStream.close();
            } else {
                try {
                    AssetFileDescriptor assetFileDescriptorOpenFd = getResources().getAssets().openFd(this.d);
                    this.o.setDataSource(assetFileDescriptorOpenFd.getFileDescriptor(), assetFileDescriptorOpenFd.getStartOffset(), assetFileDescriptorOpenFd.getLength());
                    assetFileDescriptorOpenFd.close();
                } catch (IOException unused) {
                    FileInputStream fileInputStream2 = new FileInputStream(this.d);
                    this.o.setDataSource(fileInputStream2.getFD());
                    fileInputStream2.close();
                }
            }
            this.o.setDisplay(this.c);
            this.o.setScreenOnWhilePlaying(true);
            this.o.setOnBufferingUpdateListener(this);
            this.o.setOnCompletionListener(this);
            this.o.setOnPreparedListener(this);
            this.o.setOnVideoSizeChangedListener(this);
            this.o.setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(3).build());
            this.o.prepareAsync();
            this.y = new R0(this);
            new Thread(this.y).start();
        } catch (Exception unused2) {
            a(2);
        }
    }

    public void doCleanUp() {
        R0 r0 = this.y;
        if (r0 != null) {
            r0.b = true;
            this.y = null;
        }
        MediaPlayer mediaPlayer = this.o;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.o.release();
            this.o = null;
        }
        this.m = 0;
        this.n = 0;
        this.r = false;
        this.q = false;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x003b  */
    /* JADX WARN: Code duplicated, block: B:22:0x003f  */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0042, code lost:
    
        if (r8 == 0) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void updateVideoLayout() {
        /*
            r10 = this;
            android.media.MediaPlayer r0 = r10.o
            if (r0 != 0) goto L5
            goto L4c
        L5:
            android.content.Context r0 = r10.f1040a
            android.graphics.Point r0 = com.unity3d.player.T0.a(r0)
            int r1 = r0.x
            if (r1 <= 0) goto L17
            int r0 = r0.y
            if (r0 <= 0) goto L17
            r10.k = r1
            r10.l = r0
        L17:
            int r0 = r10.k
            int r1 = r10.l
            boolean r2 = r10.q
            if (r2 == 0) goto L45
            int r2 = r10.m
            float r3 = (float) r2
            int r4 = r10.n
            float r5 = (float) r4
            float r3 = r3 / r5
            float r5 = (float) r0
            float r6 = (float) r1
            float r7 = r5 / r6
            int r8 = r10.f
            r9 = 1
            if (r8 != r9) goto L34
            int r2 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r2 > 0) goto L3f
            goto L3b
        L34:
            r9 = 2
            if (r8 != r9) goto L42
            int r2 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r2 < 0) goto L3f
        L3b:
            float r5 = r5 / r3
            int r4 = (int) r5
            r2 = r0
            goto L47
        L3f:
            float r6 = r6 * r3
            int r2 = (int) r6
            goto L46
        L42:
            if (r8 != 0) goto L45
            goto L47
        L45:
            r2 = r0
        L46:
            r4 = r1
        L47:
            if (r0 != r2) goto L4d
            if (r1 == r4) goto L4c
            goto L4d
        L4c:
            return
        L4d:
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams
            r1 = 17
            r0.<init>(r2, r4, r1)
            com.unity3d.player.S0 r1 = r10.j
            android.view.SurfaceView r2 = r10.b
            r1.updateViewLayout(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.player.S0.updateVideoLayout():void");
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        if (this.g) {
            return this.s;
        }
        return 100;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        MediaPlayer mediaPlayer = this.o;
        if (mediaPlayer == null) {
            return 0;
        }
        return mediaPlayer.getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        MediaPlayer mediaPlayer = this.o;
        if (mediaPlayer == null) {
            return 0;
        }
        return mediaPlayer.getDuration();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        boolean z = this.r && this.q;
        MediaPlayer mediaPlayer = this.o;
        if (mediaPlayer == null) {
            return !z;
        }
        return mediaPlayer.isPlaying() || !z;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        MediaPlayer mediaPlayer = this.o;
        if (mediaPlayer == null) {
            return;
        }
        if (this.v) {
            this.u = mediaPlayer.getCurrentPosition();
            this.o.pause();
        }
        this.t = true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        MediaPlayer mediaPlayer = this.o;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.seekTo(i);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        MediaPlayer mediaPlayer = this.o;
        if (mediaPlayer == null) {
            return;
        }
        if (this.v) {
            int i = this.u;
            if (i > 0) {
                mediaPlayer.seekTo(i);
            }
            this.o.start();
            this.u = 0;
        }
        this.t = false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        MediaPlayer mediaPlayer = this.o;
        if (mediaPlayer == null) {
            return 0;
        }
        return mediaPlayer.getAudioSessionId();
    }
}
