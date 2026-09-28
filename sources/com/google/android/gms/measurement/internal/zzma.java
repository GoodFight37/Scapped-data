package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.common.net.HttpHeaders;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzma implements Runnable {
    final /* synthetic */ zzmb zza;
    private final URL zzb;
    private final byte[] zzc;
    private final zzly zzd;
    private final String zze;
    private final Map zzf;

    public zzma(zzmb zzmbVar, String str, URL url, byte[] bArr, Map map, zzly zzlyVar) {
        this.zza = zzmbVar;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzlyVar);
        this.zzb = url;
        this.zzc = bArr;
        this.zzd = zzlyVar;
        this.zze = str;
        this.zzf = map;
    }

    private final void zzb(final int i, final Exception exc, final byte[] bArr, final Map map) {
        this.zza.zzu.zzaX().zzq(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzlz
            @Override // java.lang.Runnable
            public final void run() {
                zzma zzmaVar = this.zza;
                zzmaVar.zzd.zza(zzmaVar.zze, i, exc, bArr, map);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:72:0x0148  */
    /* JADX WARN: Code duplicated, block: B:84:0x0171  */
    /* JADX WARN: Code duplicated, block: B:87:0x0155 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x012c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.google.android.gms.measurement.internal.zzma] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.util.Map] */
    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        HttpURLConnection httpURLConnection;
        OutputStream outputStream;
        OutputStream outputStream2;
        ?? r6;
        ?? r7;
        OutputStream outputStream3;
        OutputStream outputStream4;
        OutputStream outputStream5;
        ?? r8;
        OutputStream outputStream6;
        ?? r9;
        InputStream inputStream;
        zzmb zzmbVar = this.zza;
        zzmbVar.zzaY();
        int i = 0;
        try {
            URL url = this.zzb;
            int i2 = com.google.android.gms.internal.measurement.zzcm.zzb;
            URLConnection uRLConnectionOpenConnection = url.openConnection();
            if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
                throw new IOException("Failed to obtain HTTP connection");
            }
            httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
            httpURLConnection.setDefaultUseCaches(false);
            zzio zzioVar = zzmbVar.zzu;
            zzioVar.zzf();
            httpURLConnection.setConnectTimeout(60000);
            zzioVar.zzf();
            httpURLConnection.setReadTimeout(61000);
            httpURLConnection.setInstanceFollowRedirects(false);
            ?? r5 = 1;
            httpURLConnection.setDoInput(true);
            try {
                try {
                    Map map = this.zzf;
                    if (map != null) {
                        for (Map.Entry entry : map.entrySet()) {
                            httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                        }
                    }
                    byte[] bArr = this.zzc;
                    if (bArr != null) {
                        try {
                            zzioVar.zzaV();
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                            gZIPOutputStream.write(bArr);
                            gZIPOutputStream.close();
                            byteArrayOutputStream.close();
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            zzhc zzhcVarZzj = this.zza.zzu.zzaW().zzj();
                            int length = byteArray.length;
                            zzhcVarZzj.zzb("Uploading data. size", Integer.valueOf(length));
                            httpURLConnection.setDoOutput(true);
                            httpURLConnection.addRequestProperty(HttpHeaders.CONTENT_ENCODING, "gzip");
                            httpURLConnection.setFixedLengthStreamingMode(length);
                            httpURLConnection.connect();
                            OutputStream outputStream7 = httpURLConnection.getOutputStream();
                            try {
                                outputStream7.write(byteArray);
                                outputStream7.close();
                                r5 = outputStream7;
                            } catch (IOException e) {
                                e = e;
                                r6 = 0;
                                outputStream4 = outputStream7;
                                if (outputStream4 != null) {
                                    try {
                                        outputStream4.close();
                                    } catch (IOException e2) {
                                        this.zza.zzu.zzaW().zze().zzc("Error closing HTTP compressed POST connection output stream. appId", zzhe.zzn(this.zze), e2);
                                    }
                                }
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                zzb(i, e, null, r6);
                            } catch (Throwable th) {
                                th = th;
                                r7 = 0;
                                outputStream3 = outputStream7;
                                if (outputStream3 != null) {
                                    try {
                                        outputStream3.close();
                                    } catch (IOException e3) {
                                        this.zza.zzu.zzaW().zze().zzc("Error closing HTTP compressed POST connection output stream. appId", zzhe.zzn(this.zze), e3);
                                    }
                                }
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                zzb(i, null, null, r7);
                                throw th;
                            }
                        } catch (IOException e4) {
                            this.zza.zzu.zzaW().zze().zzb("Failed to gzip post request content", e4);
                            throw e4;
                        }
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    try {
                        try {
                            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                            try {
                                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                                inputStream = httpURLConnection.getInputStream();
                                try {
                                    byte[] bArr2 = new byte[1024];
                                    while (true) {
                                        int i3 = inputStream.read(bArr2);
                                        if (i3 <= 0) {
                                            break;
                                        } else {
                                            byteArrayOutputStream2.write(bArr2, 0, i3);
                                        }
                                    }
                                    byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    zzb(responseCode, null, byteArray2, headerFields);
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                inputStream = null;
                            }
                        } catch (IOException e5) {
                            e = e5;
                            outputStream6 = null;
                            r9 = 0;
                            IOException iOException = e;
                            i = responseCode;
                            e = iOException;
                            outputStream4 = outputStream6;
                            r6 = r9;
                            if (outputStream4 != null) {
                                outputStream4.close();
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            zzb(i, e, null, r6);
                        } catch (Throwable th4) {
                            th = th4;
                            outputStream5 = null;
                            r8 = 0;
                            Throwable th5 = th;
                            i = responseCode;
                            th = th5;
                            outputStream3 = outputStream5;
                            r7 = r8;
                            if (outputStream3 != null) {
                                outputStream3.close();
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            zzb(i, null, null, r7);
                            throw th;
                        }
                    } catch (IOException e6) {
                        e = e6;
                        r9 = r5;
                        outputStream6 = null;
                        IOException iOException2 = e;
                        i = responseCode;
                        e = iOException2;
                        outputStream4 = outputStream6;
                        r6 = r9;
                        if (outputStream4 != null) {
                            outputStream4.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        zzb(i, e, null, r6);
                    } catch (Throwable th6) {
                        th = th6;
                        r8 = r5;
                        outputStream5 = null;
                        Throwable th7 = th;
                        i = responseCode;
                        th = th7;
                        outputStream3 = outputStream5;
                        r7 = r8;
                        if (outputStream3 != null) {
                            outputStream3.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        zzb(i, null, null, r7);
                        throw th;
                    }
                } catch (IOException e7) {
                    e = e7;
                    outputStream2 = null;
                    r6 = outputStream2;
                    outputStream4 = outputStream2;
                    if (outputStream4 != null) {
                        outputStream4.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    zzb(i, e, null, r6);
                }
            } catch (Throwable th8) {
                th = th8;
                outputStream = null;
                r7 = outputStream;
                outputStream3 = outputStream;
                if (outputStream3 != null) {
                    outputStream3.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                zzb(i, null, null, r7);
                throw th;
            }
        } catch (IOException e8) {
            e = e8;
            httpURLConnection = null;
            outputStream2 = null;
        } catch (Throwable th9) {
            th = th9;
            httpURLConnection = null;
            outputStream = null;
        }
    }
}
