package com.yasirkula.unity;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class NativeGalleryMediaPickerResultOperation {
    private boolean cancelled;
    private final Context context;
    private final Intent data;
    public boolean finished;
    private final NativeGalleryMediaReceiver mediaReceiver;
    public int progress;
    private final String savePathDirectory;
    private final String savePathFilename;
    private ArrayList<String> savedFiles;
    private final boolean selectMultiple;
    public boolean sentResult;
    private String unityResult;

    public NativeGalleryMediaPickerResultOperation(final Context context, final NativeGalleryMediaReceiver mediaReceiver, final Intent data, final boolean selectMultiple, final String savePathDirectory, final String savePathFilename) {
        this.context = context;
        this.mediaReceiver = mediaReceiver;
        this.data = data;
        this.selectMultiple = selectMultiple;
        this.savePathDirectory = savePathDirectory;
        this.savePathFilename = savePathFilename;
    }

    public void execute() {
        this.unityResult = "";
        this.progress = -1;
        try {
            try {
                if (!this.selectMultiple || this.data.getClipData() == null) {
                    String pathFromURI = getPathFromURI(this.data.getData());
                    if (pathFromURI != null && pathFromURI.length() > 0 && new File(pathFromURI).exists()) {
                        this.unityResult = pathFromURI;
                    }
                    Log.d("Unity", "NativeGalleryMediaPickerResultOperation: " + pathFromURI);
                } else {
                    int itemCount = this.data.getClipData().getItemCount();
                    boolean z = true;
                    for (int i = 0; i < itemCount; i++) {
                        if (this.cancelled) {
                            return;
                        }
                        String pathFromURI2 = getPathFromURI(this.data.getClipData().getItemAt(i).getUri());
                        if (pathFromURI2 != null && pathFromURI2.length() > 0 && new File(pathFromURI2).exists()) {
                            if (z) {
                                this.unityResult += pathFromURI2;
                                z = false;
                            } else {
                                this.unityResult += ">" + pathFromURI2;
                            }
                        }
                        Log.d("Unity", "NativeGalleryMediaPickerResultOperation: " + pathFromURI2);
                    }
                }
            } catch (Exception e) {
                Log.e("Unity", "Exception:", e);
            }
        } finally {
            this.progress = 100;
            this.finished = true;
        }
    }

    public void cancel() {
        if (this.cancelled || this.finished) {
            return;
        }
        Log.d("Unity", "Cancelled NativeGalleryMediaPickerResultOperation!");
        this.cancelled = true;
        this.unityResult = "";
    }

    public void sendResultToUnity() {
        if (this.sentResult) {
            return;
        }
        this.sentResult = true;
        NativeGalleryMediaReceiver nativeGalleryMediaReceiver = this.mediaReceiver;
        if (nativeGalleryMediaReceiver == null) {
            Log.d("Unity", "NativeGalleryMediaPickerResultOperation.mediaReceiver became null in sendResultToUnity!");
        } else if (this.selectMultiple) {
            nativeGalleryMediaReceiver.OnMultipleMediaReceived(this.unityResult);
        } else {
            nativeGalleryMediaReceiver.OnMediaReceived(this.unityResult);
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private String getPathFromURI(Uri uri) throws Throwable {
        FileInputStream fileInputStream;
        Exception e;
        FileInputStream fileInputStream2 = null;
        if (uri == null) {
            return null;
        }
        Log.d("Unity", "Selected media uri: " + uri.toString());
        String strGetPathFromURI = NativeGalleryUtils.GetPathFromURI(this.context, uri);
        if (strGetPathFromURI != null && strGetPathFromURI.length() > 0) {
            try {
                fileInputStream = new FileInputStream(new File(strGetPathFromURI));
                try {
                    try {
                        fileInputStream.read();
                        if (NativeGalleryMediaPickerFragment.ShouldGrantPersistableUriPermission(this.context)) {
                            this.context.getContentResolver().takePersistableUriPermission(uri, 1);
                        }
                        try {
                            fileInputStream.close();
                        } catch (Exception unused) {
                        }
                        return strGetPathFromURI;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (Exception unused2) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    Log.e("Unity", "Media uri isn't accessible via File API: " + uri, e);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    return copyToTempFile(uri);
                }
            } catch (Exception e3) {
                fileInputStream = null;
                e = e3;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                throw th;
            }
        }
        return copyToTempFile(uri);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0192 A[Catch: all -> 0x01cf, TryCatch #7 {all -> 0x01cf, blocks: (B:77:0x0146, B:78:0x014c, B:80:0x0152, B:83:0x0157, B:85:0x015d, B:87:0x0170, B:89:0x0178, B:91:0x017c, B:97:0x018a, B:99:0x018e, B:101:0x0192, B:102:0x0199, B:103:0x019e, B:96:0x0188), top: B:132:0x0146 }] */
    /* JADX WARN: Code duplicated, block: B:105:0x01c8 A[Catch: Exception -> 0x01dc, TRY_ENTER, TryCatch #3 {Exception -> 0x01dc, blocks: (B:51:0x00bd, B:53:0x00c3, B:62:0x00e4, B:65:0x00fe, B:67:0x0106, B:69:0x0114, B:70:0x0130, B:71:0x0132, B:105:0x01c8, B:106:0x01cb, B:113:0x01d5, B:114:0x01d8, B:115:0x01db), top: B:127:0x00bd }] */
    /* JADX WARN: Code duplicated, block: B:120:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:125:0x00da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:139:0x0130 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:141:0x015d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:144:0x014c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:16:0x0044  */
    /* JADX WARN: Code duplicated, block: B:29:0x0060  */
    /* JADX WARN: Code duplicated, block: B:35:0x0077  */
    /* JADX WARN: Code duplicated, block: B:37:0x007d  */
    /* JADX WARN: Code duplicated, block: B:42:0x009d  */
    /* JADX WARN: Code duplicated, block: B:44:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:48:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:50:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:53:0x00c3 A[Catch: Exception -> 0x01dc, TRY_LEAVE, TryCatch #3 {Exception -> 0x01dc, blocks: (B:51:0x00bd, B:53:0x00c3, B:62:0x00e4, B:65:0x00fe, B:67:0x0106, B:69:0x0114, B:70:0x0130, B:71:0x0132, B:105:0x01c8, B:106:0x01cb, B:113:0x01d5, B:114:0x01d8, B:115:0x01db), top: B:127:0x00bd }] */
    /* JADX WARN: Code duplicated, block: B:55:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:61:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:64:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:67:0x0106 A[Catch: Exception -> 0x01dc, TryCatch #3 {Exception -> 0x01dc, blocks: (B:51:0x00bd, B:53:0x00c3, B:62:0x00e4, B:65:0x00fe, B:67:0x0106, B:69:0x0114, B:70:0x0130, B:71:0x0132, B:105:0x01c8, B:106:0x01cb, B:113:0x01d5, B:114:0x01d8, B:115:0x01db), top: B:127:0x00bd }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0114 A[Catch: Exception -> 0x01dc, TryCatch #3 {Exception -> 0x01dc, blocks: (B:51:0x00bd, B:53:0x00c3, B:62:0x00e4, B:65:0x00fe, B:67:0x0106, B:69:0x0114, B:70:0x0130, B:71:0x0132, B:105:0x01c8, B:106:0x01cb, B:113:0x01d5, B:114:0x01d8, B:115:0x01db), top: B:127:0x00bd }] */
    /* JADX WARN: Code duplicated, block: B:75:0x0142  */
    /* JADX WARN: Code duplicated, block: B:76:0x0144  */
    /* JADX WARN: Code duplicated, block: B:87:0x0170 A[Catch: all -> 0x01cf, TryCatch #7 {all -> 0x01cf, blocks: (B:77:0x0146, B:78:0x014c, B:80:0x0152, B:83:0x0157, B:85:0x015d, B:87:0x0170, B:89:0x0178, B:91:0x017c, B:97:0x018a, B:99:0x018e, B:101:0x0192, B:102:0x0199, B:103:0x019e, B:96:0x0188), top: B:132:0x0146 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x017c A[Catch: all -> 0x01cf, TRY_LEAVE, TryCatch #7 {all -> 0x01cf, blocks: (B:77:0x0146, B:78:0x014c, B:80:0x0152, B:83:0x0157, B:85:0x015d, B:87:0x0170, B:89:0x0178, B:91:0x017c, B:97:0x018a, B:99:0x018e, B:101:0x0192, B:102:0x0199, B:103:0x019e, B:96:0x0188), top: B:132:0x0146 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0184 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:95:0x0186  */
    /* JADX WARN: Code duplicated, block: B:99:0x018e A[Catch: all -> 0x01cf, TryCatch #7 {all -> 0x01cf, blocks: (B:77:0x0146, B:78:0x014c, B:80:0x0152, B:83:0x0157, B:85:0x015d, B:87:0x0170, B:89:0x0178, B:91:0x017c, B:97:0x018a, B:99:0x018e, B:101:0x0192, B:102:0x0199, B:103:0x019e, B:96:0x0188), top: B:132:0x0146 }] */
    private String copyToTempFile(Uri uri) throws Throwable {
        Cursor cursorQuery;
        String strSubstring;
        int iLastIndexOf;
        String type;
        String strSubstring2;
        String extensionFromMimeType;
        InputStream inputStreamOpenInputStream;
        long j;
        String str;
        File file;
        FileOutputStream fileOutputStream;
        int i;
        byte[] bArr;
        int i2;
        int i3;
        int i4;
        int i5;
        ContentResolver contentResolver = this.context.getContentResolver();
        Cursor cursor = null;
        long jAvailable = -1;
        try {
            cursorQuery = contentResolver.query(uri, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            strSubstring = cursorQuery.getString(cursorQuery.getColumnIndex("_display_name"));
                            try {
                                jAvailable = cursorQuery.getLong(cursorQuery.getColumnIndex("_size"));
                            } catch (Exception e) {
                                e = e;
                                Log.e("Unity", "Exception:", e);
                                if (cursorQuery != null) {
                                }
                                if (strSubstring != null) {
                                    strSubstring = "temp";
                                } else {
                                    strSubstring = "temp";
                                }
                                iLastIndexOf = strSubstring.lastIndexOf(46);
                                if (iLastIndexOf > 0) {
                                    type = contentResolver.getType(uri);
                                    if (type != null) {
                                        strSubstring2 = null;
                                    } else {
                                        strSubstring2 = null;
                                    }
                                } else {
                                    type = contentResolver.getType(uri);
                                    if (type != null) {
                                        strSubstring2 = null;
                                    } else {
                                        strSubstring2 = null;
                                    }
                                }
                                if (strSubstring2 == null) {
                                    strSubstring2 = ".tmp";
                                }
                                if (!NativeGalleryMediaPickerFragment.tryPreserveFilenames) {
                                    strSubstring = this.savePathFilename;
                                } else if (strSubstring.endsWith(strSubstring2)) {
                                    strSubstring = strSubstring.substring(0, strSubstring.length() - strSubstring2.length());
                                }
                                inputStreamOpenInputStream = contentResolver.openInputStream(uri);
                                if (inputStreamOpenInputStream == null) {
                                    Log.w("Unity", "Couldn't open input stream: " + uri);
                                    return null;
                                }
                                j = 0;
                                if (jAvailable < 0) {
                                    try {
                                        jAvailable = inputStreamOpenInputStream.available();
                                    } catch (Exception unused) {
                                    }
                                    if (jAvailable < 0) {
                                        jAvailable = 0;
                                    }
                                }
                                str = strSubstring + strSubstring2;
                                if (this.savedFiles != null) {
                                    i4 = 1;
                                    i5 = 0;
                                    while (i5 < this.savedFiles.size()) {
                                        if (this.savedFiles.get(i5).equals(str)) {
                                            int i6 = i4 + 1;
                                            i4 = i6;
                                            str = strSubstring + i6 + strSubstring2;
                                            i5 = -1;
                                        }
                                        i5++;
                                    }
                                }
                                file = new File(this.savePathDirectory, str);
                                try {
                                    fileOutputStream = new FileOutputStream(file, false);
                                    if (jAvailable > 0) {
                                        i = 0;
                                    } else {
                                        i = -1;
                                    }
                                    try {
                                        this.progress = i;
                                        bArr = new byte[4096];
                                        while (true) {
                                            i2 = inputStreamOpenInputStream.read(bArr);
                                            if (i2 > 0) {
                                                break;
                                            }
                                            fileOutputStream.write(bArr, 0, i2);
                                            if (jAvailable > 0) {
                                                byte[] bArr2 = bArr;
                                                long j2 = j + ((long) i2);
                                                i3 = (int) ((j2 / jAvailable) * 100.0d);
                                                this.progress = i3;
                                                if (i3 > 100) {
                                                    this.progress = 100;
                                                }
                                                bArr = bArr2;
                                                j = j2;
                                            }
                                        }
                                        if (this.cancelled) {
                                            fileOutputStream.close();
                                            file.delete();
                                            fileOutputStream = null;
                                        } else if (jAvailable > 0) {
                                            this.progress = 100;
                                        }
                                        if (this.selectMultiple) {
                                            if (this.savedFiles == null) {
                                                this.savedFiles = new ArrayList<>();
                                            }
                                            this.savedFiles.add(str);
                                        }
                                        Log.d("Unity", "Copied media from " + uri + " to: " + file.getAbsolutePath());
                                        String absolutePath = file.getAbsolutePath();
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        inputStreamOpenInputStream.close();
                                        return absolutePath;
                                    } catch (Throwable th) {
                                        th = th;
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        inputStreamOpenInputStream.close();
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileOutputStream = null;
                                }
                            }
                        } else {
                            strSubstring = null;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        strSubstring = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } else {
                strSubstring = null;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception e3) {
            e = e3;
            cursorQuery = null;
            strSubstring = null;
        } catch (Throwable th4) {
            th = th4;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        if (strSubstring != null || strSubstring.length() < 3) {
            strSubstring = "temp";
        }
        iLastIndexOf = strSubstring.lastIndexOf(46);
        if (iLastIndexOf > 0 || iLastIndexOf >= strSubstring.length() - 1) {
            type = contentResolver.getType(uri);
            if (type != null || (extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(type)) == null || extensionFromMimeType.length() <= 0) {
                strSubstring2 = null;
            } else {
                strSubstring2 = "." + extensionFromMimeType;
            }
        } else {
            strSubstring2 = strSubstring.substring(iLastIndexOf);
        }
        if (strSubstring2 == null) {
            strSubstring2 = ".tmp";
        }
        if (!NativeGalleryMediaPickerFragment.tryPreserveFilenames) {
            strSubstring = this.savePathFilename;
        } else if (strSubstring.endsWith(strSubstring2)) {
            strSubstring = strSubstring.substring(0, strSubstring.length() - strSubstring2.length());
        }
        try {
            inputStreamOpenInputStream = contentResolver.openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                Log.w("Unity", "Couldn't open input stream: " + uri);
                return null;
            }
            j = 0;
            if (jAvailable < 0) {
                jAvailable = inputStreamOpenInputStream.available();
                if (jAvailable < 0) {
                    jAvailable = 0;
                }
            }
            str = strSubstring + strSubstring2;
            if (this.savedFiles != null) {
                i4 = 1;
                i5 = 0;
                while (i5 < this.savedFiles.size()) {
                    if (this.savedFiles.get(i5).equals(str)) {
                        int i7 = i4 + 1;
                        i4 = i7;
                        str = strSubstring + i7 + strSubstring2;
                        i5 = -1;
                    }
                    i5++;
                }
            }
            file = new File(this.savePathDirectory, str);
            fileOutputStream = new FileOutputStream(file, false);
            if (jAvailable > 0) {
                i = 0;
            } else {
                i = -1;
            }
            this.progress = i;
            bArr = new byte[4096];
            while (true) {
                i2 = inputStreamOpenInputStream.read(bArr);
                if (i2 > 0 || this.cancelled) {
                    break;
                    break;
                }
                fileOutputStream.write(bArr, 0, i2);
                if (jAvailable > 0) {
                    byte[] bArr3 = bArr;
                    long j3 = j + ((long) i2);
                    i3 = (int) ((j3 / jAvailable) * 100.0d);
                    this.progress = i3;
                    if (i3 > 100) {
                        this.progress = 100;
                    }
                    bArr = bArr3;
                    j = j3;
                }
            }
            if (this.cancelled) {
                fileOutputStream.close();
                file.delete();
                fileOutputStream = null;
            } else if (jAvailable > 0) {
                this.progress = 100;
            }
            if (this.selectMultiple) {
                if (this.savedFiles == null) {
                    this.savedFiles = new ArrayList<>();
                }
                this.savedFiles.add(str);
            }
            Log.d("Unity", "Copied media from " + uri + " to: " + file.getAbsolutePath());
            String absolutePath2 = file.getAbsolutePath();
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            inputStreamOpenInputStream.close();
            return absolutePath2;
        } catch (Exception e4) {
            Log.e("Unity", "Exception:", e4);
            return null;
        }
    }
}
