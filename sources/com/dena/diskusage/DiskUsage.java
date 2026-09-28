package com.dena.diskusage;

import android.os.StatFs;
import android.util.Log;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class DiskUsage {
    private static final String TAG = "DiskUsage";
    private static final int invalid = -1;

    public static long getFreeDiskSize(String str) {
        File file = new File(str);
        if (!file.exists()) {
            Log.e(TAG, "path " + str + " was not found");
            return -1L;
        }
        return getFreeDiskSizeForStat(new StatFs(file.getPath()));
    }

    public static long getBlockSize(String str) {
        File file = new File(str);
        if (!file.exists()) {
            Log.e(TAG, "path " + str + " was not found");
            return -1L;
        }
        return new StatFs(file.getPath()).getBlockSizeLong();
    }

    private static long getFreeDiskSizeForStatDeprecated(StatFs statFs) {
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    private static long getFreeDiskSizeForStat(StatFs statFs) {
        return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
    }
}
