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

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzhi implements Runnable {
    final /* synthetic */ zzhk zza;
    private final URL zzb;
    private final byte[] zzc;
    private final zzhg zzd;
    private final String zze;
    private final Map zzf;

    public zzhi(zzhk zzhkVar, String str, URL url, byte[] bArr, Map map, zzhg zzhgVar) {
        this.zza = zzhkVar;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzhgVar);
        this.zzb = url;
        this.zzc = bArr;
        this.zzd = zzhgVar;
        this.zze = str;
        this.zzf = map;
    }

    /* JADX WARN: Code duplicated, block: B:68:0x0137  */
    /* JADX WARN: Code duplicated, block: B:79:0x0176  */
    /* JADX WARN: Code duplicated, block: B:85:0x011b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x015a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x00f6: MOVE (r8 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:45:0x00f5 */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x00fa: MOVE (r10 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:47:0x00f9 */
    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        int i;
        HttpURLConnection httpURLConnection;
        Map map;
        IOException iOException;
        int responseCode;
        Map map2;
        zzhh zzhhVar;
        zzil zzilVarZzaX;
        Map map3;
        Map map4;
        InputStream inputStream;
        zzhk zzhkVar = this.zza;
        zzhkVar.zzaY();
        OutputStream outputStream = null;
        try {
            URL url = this.zzb;
            int i2 = com.google.android.gms.internal.measurement.zzcm.zzb;
            URLConnection uRLConnectionOpenConnection = url.openConnection();
            if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
                throw new IOException("Failed to obtain HTTP connection");
            }
            httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
            httpURLConnection.setDefaultUseCaches(false);
            zzio zzioVar = zzhkVar.zzu;
            zzioVar.zzf();
            httpURLConnection.setConnectTimeout(60000);
            zzioVar.zzf();
            httpURLConnection.setReadTimeout(61000);
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setDoInput(true);
            try {
                Map map5 = this.zzf;
                if (map5 != null) {
                    for (Map.Entry entry : map5.entrySet()) {
                        httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                byte[] bArr = this.zzc;
                if (bArr != null) {
                    byte[] bArrZzB = zzhkVar.zzg.zzA().zzB(bArr);
                    zzhc zzhcVarZzj = zzioVar.zzaW().zzj();
                    int length = bArrZzB.length;
                    zzhcVarZzj.zzb("Uploading data. size", Integer.valueOf(length));
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.addRequestProperty(HttpHeaders.CONTENT_ENCODING, "gzip");
                    httpURLConnection.setFixedLengthStreamingMode(length);
                    httpURLConnection.connect();
                    OutputStream outputStream2 = httpURLConnection.getOutputStream();
                    try {
                        outputStream2.write(bArrZzB);
                        outputStream2.close();
                    } catch (IOException e) {
                        iOException = e;
                        responseCode = 0;
                        map2 = null;
                        outputStream = outputStream2;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e2) {
                                this.zza.zzu.zzaW().zze().zzc("Error closing HTTP compressed POST connection output stream. appId", zzhe.zzn(this.zze), e2);
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        zzhk zzhkVar2 = this.zza;
                        String str = this.zze;
                        zzhg zzhgVar = this.zzd;
                        zzilVarZzaX = zzhkVar2.zzu.zzaX();
                        zzhhVar = new zzhh(str, zzhgVar, responseCode, iOException, null, map2, null);
                        zzilVarZzaX.zzq(zzhhVar);
                    } catch (Throwable th) {
                        th = th;
                        map = null;
                        outputStream = outputStream2;
                        i = 0;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e3) {
                                this.zza.zzu.zzaW().zze().zzc("Error closing HTTP compressed POST connection output stream. appId", zzhe.zzn(this.zze), e3);
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        this.zza.zzu.zzaX().zzq(new zzhh(this.zze, this.zzd, i, null, null, map, null));
                        throw th;
                    }
                }
                responseCode = httpURLConnection.getResponseCode();
                try {
                    try {
                        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                        try {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            inputStream = httpURLConnection.getInputStream();
                            try {
                                byte[] bArr2 = new byte[1024];
                                while (true) {
                                    int i3 = inputStream.read(bArr2);
                                    if (i3 <= 0) {
                                        break;
                                    } else {
                                        byteArrayOutputStream.write(bArr2, 0, i3);
                                    }
                                }
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                zzhk zzhkVar3 = this.zza;
                                String str2 = this.zze;
                                zzhg zzhgVar2 = this.zzd;
                                zzilVarZzaX = zzhkVar3.zzu.zzaX();
                                zzhhVar = new zzhh(str2, zzhgVar2, responseCode, null, byteArray, headerFields, null);
                                zzilVarZzaX.zzq(zzhhVar);
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
                    } catch (IOException e4) {
                        e = e4;
                        map2 = null;
                        iOException = e;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        zzhk zzhkVar4 = this.zza;
                        String str3 = this.zze;
                        zzhg zzhgVar3 = this.zzd;
                        zzilVarZzaX = zzhkVar4.zzu.zzaX();
                        zzhhVar = new zzhh(str3, zzhgVar3, responseCode, iOException, null, map2, null);
                    } catch (Throwable th4) {
                        th = th4;
                        i = responseCode;
                        map = null;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        this.zza.zzu.zzaX().zzq(new zzhh(this.zze, this.zzd, i, null, null, map, null));
                        throw th;
                    }
                } catch (IOException e5) {
                    e = e5;
                    map2 = map4;
                    iOException = e;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    zzhk zzhkVar5 = this.zza;
                    String str4 = this.zze;
                    zzhg zzhgVar4 = this.zzd;
                    zzilVarZzaX = zzhkVar5.zzu.zzaX();
                    zzhhVar = new zzhh(str4, zzhgVar4, responseCode, iOException, null, map2, null);
                } catch (Throwable th5) {
                    th = th5;
                    i = responseCode;
                    map = map3;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    this.zza.zzu.zzaX().zzq(new zzhh(this.zze, this.zzd, i, null, null, map, null));
                    throw th;
                }
            } catch (IOException e6) {
                iOException = e6;
                responseCode = 0;
                map2 = null;
            } catch (Throwable th6) {
                th = th6;
                i = 0;
            }
        } catch (IOException e7) {
            iOException = e7;
            responseCode = 0;
            httpURLConnection = null;
            map2 = null;
        } catch (Throwable th7) {
            th = th7;
            i = 0;
            httpURLConnection = null;
            map = null;
        }
    }
}
