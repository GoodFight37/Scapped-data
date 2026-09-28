package com.google.android.gms.internal.p002firebaseauthapi;

import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzanp {
    private static final ThreadLocal<SimpleDateFormat> zza;

    private static boolean zza(long j) {
        return j >= -62135596800L && j <= 253402300799L;
    }

    private static long zzb(String str) throws ParseException {
        int iIndexOf = str.indexOf(58);
        if (iIndexOf == -1) {
            throw new ParseException("Invalid offset value: " + str, 0);
        }
        try {
            return ((Long.parseLong(str.substring(0, iIndexOf)) * 60) + Long.parseLong(str.substring(iIndexOf + 1))) * 60;
        } catch (NumberFormatException e) {
            ParseException parseException = new ParseException("Invalid offset value: " + str, 0);
            parseException.initCause(e);
            throw parseException;
        }
    }

    public static long zza(zzamt zzamtVar) {
        return zzb(zzamtVar).zzb();
    }

    private static zzamt zzb(zzamt zzamtVar) {
        long jZzb = zzamtVar.zzb();
        int iZza = zzamtVar.zza();
        if (!zza(jZzb) || iZza < 0 || iZza >= 1000000000) {
            throw new IllegalArgumentException(zzae.zza("Timestamp is not valid. See proto definition for valid values. Seconds (%s) must be in range [-62,135,596,800, +253,402,300,799]. Nanos (%s) must be in range [0, +999,999,999].", Long.valueOf(jZzb), Integer.valueOf(iZza)));
        }
        return zzamtVar;
    }

    public static zzamt zza(String str) throws ParseException {
        String strSubstring;
        int iCharAt;
        int iIndexOf = str.indexOf(84);
        if (iIndexOf == -1) {
            throw new ParseException("Failed to parse timestamp: invalid timestamp \"" + str + "\"", 0);
        }
        int iIndexOf2 = str.indexOf(90, iIndexOf);
        if (iIndexOf2 == -1) {
            iIndexOf2 = str.indexOf(43, iIndexOf);
        }
        if (iIndexOf2 == -1) {
            iIndexOf2 = str.indexOf(45, iIndexOf);
        }
        if (iIndexOf2 == -1) {
            throw new ParseException("Failed to parse timestamp: missing valid timezone offset.", 0);
        }
        String strSubstring2 = str.substring(0, iIndexOf2);
        int iIndexOf3 = strSubstring2.indexOf(46);
        if (iIndexOf3 == -1) {
            strSubstring = "";
        } else {
            String strSubstring3 = strSubstring2.substring(0, iIndexOf3);
            strSubstring = strSubstring2.substring(iIndexOf3 + 1);
            strSubstring2 = strSubstring3;
        }
        long time = zza.get().parse(strSubstring2).getTime() / 1000;
        if (strSubstring.isEmpty()) {
            iCharAt = 0;
        } else {
            iCharAt = 0;
            for (int i = 0; i < 9; i++) {
                iCharAt *= 10;
                if (i < strSubstring.length()) {
                    if (strSubstring.charAt(i) < '0' || strSubstring.charAt(i) > '9') {
                        throw new ParseException("Invalid nanoseconds.", 0);
                    }
                    iCharAt += strSubstring.charAt(i) - '0';
                }
            }
        }
        if (str.charAt(iIndexOf2) == 'Z') {
            if (str.length() != iIndexOf2 + 1) {
                throw new ParseException("Failed to parse timestamp: invalid trailing data \"" + str.substring(iIndexOf2) + "\"", 0);
            }
        } else {
            long jZzb = zzb(str.substring(iIndexOf2 + 1));
            time = str.charAt(iIndexOf2) == '+' ? time - jZzb : time + jZzb;
        }
        try {
            if (!zza(time)) {
                throw new IllegalArgumentException(zzae.zza("Timestamp is not valid. Input seconds is too large. Seconds (%s) must be in range [-62,135,596,800, +253,402,300,799]. ", Long.valueOf(time)));
            }
            if (iCharAt <= -1000000000 || iCharAt >= 1000000000) {
                time = zzbc.zza(time, iCharAt / 1000000000);
                iCharAt %= 1000000000;
            }
            if (iCharAt < 0) {
                iCharAt += 1000000000;
                time = zzbc.zzb(time, 1L);
            }
            return zzb((zzamt) ((zzakg) zzamt.zzc().zza(time).zza(iCharAt).zze()));
        } catch (IllegalArgumentException e) {
            ParseException parseException = new ParseException("Failed to parse timestamp " + str + " Timestamp is out of range.", 0);
            parseException.initCause(e);
            throw parseException;
        }
    }

    @Nullable
    private static Method zzc(String str) {
        try {
            return Class.forName("java.time.Instant").getMethod(str, new Class[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static /* synthetic */ SimpleDateFormat zza() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
        gregorianCalendar.setGregorianChange(new Date(Long.MIN_VALUE));
        simpleDateFormat.setCalendar(gregorianCalendar);
        return simpleDateFormat;
    }

    static {
        zza = new zzano();
        zzc("now");
        zzc("getEpochSecond");
        zzc("getNano");
    }
}
