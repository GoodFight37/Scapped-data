package com.google.android.gms.internal.nearby;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.google.android.gms.nearby.connection.Payload;
import java.io.File;
import java.io.FileNotFoundException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzmd {
    private static File zza;

    static Payload zza(Context context, zzmb zzmbVar) {
        long jZzb = zzmbVar.zzb();
        int iZza = zzmbVar.zza();
        if (iZza == 1) {
            zzlx zzlxVarZzg = zzmbVar.zzg();
            return Payload.zza((byte[]) zzsg.zzc(zzlxVarZzg != null ? zzlxVarZzg.zzc() : zzmbVar.zzv(), "Payload bytes cannot be null if type is BYTES."), jZzb);
        }
        if (iZza != 2) {
            if (iZza != 3) {
                Log.w("NearbyConnections", String.format("Incoming ParcelablePayload %d has unknown type %d", Long.valueOf(zzmbVar.zzb()), Integer.valueOf(zzmbVar.zza())));
                return null;
            }
            ParcelFileDescriptor parcelFileDescriptorZze = zzmbVar.zze();
            zzsg.zzc(parcelFileDescriptorZze, "Data ParcelFileDescriptor cannot be null for type STREAM");
            return Payload.zzc(Payload.Stream.zzb(parcelFileDescriptorZze), jZzb);
        }
        String strZzh = zzmbVar.zzh();
        Uri uriZzd = zzmbVar.zzd();
        if (strZzh == null || uriZzd == null) {
            ParcelFileDescriptor parcelFileDescriptorZze2 = zzmbVar.zze();
            zzsg.zzc(parcelFileDescriptorZze2, "Data ParcelFileDescriptor cannot be null for type FILE");
            return Payload.zzb(Payload.File.zzb(parcelFileDescriptorZze2), jZzb);
        }
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uriZzd, "r");
            if (parcelFileDescriptorOpenFileDescriptor != null) {
                return Payload.zzb(Payload.File.zza(new File(strZzh), parcelFileDescriptorOpenFileDescriptor, zzmbVar.zzc(), uriZzd), jZzb);
            }
            Log.w("NearbyConnections", String.format("Failed to get ParcelFileDescriptor for %s", uriZzd));
            return null;
        } catch (FileNotFoundException e) {
            Log.w("NearbyConnections", String.format("Failed to create Payload from ParcelablePayload: unable to open uri %s for file %s.", uriZzd, strZzh), e);
            return null;
        } catch (SecurityException e2) {
            Log.w("NearbyConnections", String.format("Failed to create Payload from ParcelablePayload: unable to open uri %s for file %s.", uriZzd, strZzh), e2);
            return null;
        }
    }

    static File zzb() {
        return zza;
    }

    public static void zzc(File file) {
        if (file == null) {
            Log.e("NearbyConnections", "Cannot set null temp directory");
        } else {
            zza = file;
        }
    }
}
