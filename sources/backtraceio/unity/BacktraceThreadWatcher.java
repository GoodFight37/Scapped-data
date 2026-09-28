package backtraceio.unity;

/* JADX INFO: loaded from: classes.dex */
public class BacktraceThreadWatcher {
    private boolean active;
    private int counter;
    private int delay;
    private long lastTimestamp;
    private int privateCounter;
    private int timeout;

    BacktraceThreadWatcher(int i, int i2) {
        this.timeout = i;
        this.delay = i2;
        setActive(true);
    }

    int getTimeout() {
        return this.timeout;
    }

    int getDelay() {
        return this.delay;
    }

    long getLastTimestamp() {
        return this.lastTimestamp;
    }

    void setLastTimestamp(long j) {
        this.lastTimestamp = j;
    }

    synchronized boolean isActive() {
        return this.active;
    }

    synchronized void setActive(boolean z) {
        this.active = z;
    }

    void tickPrivateCounter() {
        this.privateCounter++;
    }

    int getPrivateCounter() {
        return this.privateCounter;
    }

    void setPrivateCounter(int i) {
        this.privateCounter = i;
    }

    synchronized int getCounter() {
        return this.counter;
    }

    public synchronized void tickCounter() {
        this.counter++;
    }
}
