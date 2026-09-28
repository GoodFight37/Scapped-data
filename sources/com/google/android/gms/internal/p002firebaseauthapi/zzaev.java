package com.google.android.gms.internal.p002firebaseauthapi;

import com.adjust.sdk.Constants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.common.net.HttpHeaders;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import org.json.JSONException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaev {
    private static void zza(HttpURLConnection httpURLConnection, zzaew<?> zzaewVar, Type type) {
        try {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                InputStream inputStream = zza(responseCode) ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream();
                StringBuilder sb = new StringBuilder();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Constants.ENCODING));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        } else {
                            sb.append(line);
                        }
                    } catch (Throwable th) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                bufferedReader.close();
                String string = sb.toString();
                if (zza(responseCode)) {
                    zzaewVar.zza((zzaea) zzady.zza(string, type));
                } else {
                    zzaewVar.zza((String) zzady.zza(string, String.class));
                }
                httpURLConnection.disconnect();
            } catch (zzabr e) {
                e = e;
                zzaewVar.zza(e.getMessage());
                httpURLConnection.disconnect();
            } catch (SocketTimeoutException unused) {
                zzaewVar.zza("TIMEOUT");
                httpURLConnection.disconnect();
            } catch (IOException e2) {
                e = e2;
                zzaewVar.zza(e.getMessage());
                httpURLConnection.disconnect();
            }
        } catch (Throwable th3) {
            httpURLConnection.disconnect();
            throw th3;
        }
    }

    private static final boolean zza(int i) {
        return i >= 200 && i < 300;
    }

    public static void zza(String str, zzaew<?> zzaewVar, Type type, zzaef zzaefVar) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(60000);
            zzaefVar.zza(httpURLConnection);
            zza(httpURLConnection, zzaewVar, type);
        } catch (SocketTimeoutException unused) {
            zzaewVar.zza("TIMEOUT");
        } catch (UnknownHostException unused2) {
            zzaewVar.zza("<<Network Error>>");
        } catch (IOException e) {
            zzaewVar.zza(e.getMessage());
        }
    }

    public static void zza(String str, zzaeb zzaebVar, zzaew<?> zzaewVar, Type type, zzaef zzaefVar) {
        try {
            Preconditions.checkNotNull(zzaebVar);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoOutput(true);
            byte[] bytes = zzaebVar.zza().getBytes(Charset.defaultCharset());
            httpURLConnection.setFixedLengthStreamingMode(bytes.length);
            httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
            httpURLConnection.setConnectTimeout(60000);
            zzaefVar.zza(httpURLConnection);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream(), bytes.length);
            try {
                bufferedOutputStream.write(bytes, 0, bytes.length);
                bufferedOutputStream.close();
                zza(httpURLConnection, zzaewVar, type);
            } catch (Throwable th) {
                try {
                    bufferedOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e) {
            e = e;
            zzaewVar.zza(e.getMessage());
        } catch (NullPointerException e2) {
            e = e2;
            zzaewVar.zza(e.getMessage());
        } catch (SocketTimeoutException unused) {
            zzaewVar.zza("TIMEOUT");
        } catch (UnknownHostException unused2) {
            zzaewVar.zza("<<Network Error>>");
        } catch (JSONException e3) {
            e = e3;
            zzaewVar.zza(e.getMessage());
        }
    }
}
