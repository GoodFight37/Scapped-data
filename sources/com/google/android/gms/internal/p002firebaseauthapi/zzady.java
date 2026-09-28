package com.google.android.gms.internal.p002firebaseauthapi;

import java.lang.reflect.Type;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public class zzady {
    public static Object zza(String str, Type type) throws zzabr {
        if (type == String.class) {
            try {
                zzafu zzafuVar = (zzafu) new zzafu().zza(str);
                if (zzafuVar.zzb()) {
                    return zzafuVar.zza();
                }
                throw new zzabr("No error message: " + str);
            } catch (Exception e) {
                throw new zzabr("Json conversion failed! " + e.getMessage(), e);
            }
        }
        if (type == Void.class) {
            return null;
        }
        try {
            try {
                return ((zzaea) ((Class) type).getConstructor(new Class[0]).newInstance(new Object[0])).zza(str);
            } catch (Exception e2) {
                throw new zzabr("Json conversion failed! " + e2.getMessage(), e2);
            }
        } catch (Exception e3) {
            throw new zzabr("Instantiation of JsonResponse failed! " + String.valueOf(type), e3);
        }
    }

    private zzady() {
    }
}
