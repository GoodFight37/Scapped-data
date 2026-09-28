package com.google.android.gms.nearby.exposurenotification;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class PackageConfiguration extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PackageConfiguration> CREATOR = new zzn();
    final Bundle zza;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
    public static final class PackageConfigurationBuilder {
        private Bundle zza;

        public PackageConfiguration build() {
            return new PackageConfiguration(this.zza);
        }

        public PackageConfigurationBuilder setValues(Bundle bundle) {
            this.zza = new Bundle(bundle);
            return this;
        }
    }

    PackageConfiguration(Bundle bundle) {
        this.zza = bundle;
    }

    public boolean equals(Object obj) {
        if (obj instanceof PackageConfiguration) {
            return Objects.equal(this.zza, ((PackageConfiguration) obj).getValues());
        }
        return false;
    }

    public Bundle getValues() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza);
    }

    public String toString() {
        return String.format(Locale.US, "PackageConfiguration<values: %s>", this.zza);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 1, getValues(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
