package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.nearby.zznj;
import com.google.android.gms.nearby.messages.internal.zzac;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public class MessageFilter extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MessageFilter> CREATOR = new zzb();
    public static final MessageFilter INCLUDE_ALL_MY_TYPES;
    final int zza;
    private final List zzb;
    private final List zzc;
    private final boolean zzd;
    private final List zze;
    private final int zzf;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
    public static final class Builder {
        private boolean zzd;
        private final Set zza = new HashSet();
        private final List zzb = new ArrayList();
        private final Set zzc = new HashSet();
        private int zze = 0;

        private final Builder zza(String str, String str2) {
            this.zza.add(new zzac(str, str2));
            return this;
        }

        public MessageFilter build() {
            boolean z = true;
            if (!this.zzd && this.zza.isEmpty()) {
                z = false;
            }
            Preconditions.checkState(z, "At least one of the include methods must be called.");
            return new MessageFilter(2, new ArrayList(this.zza), this.zzb, this.zzd, new ArrayList(this.zzc), this.zze);
        }

        public Builder includeAllMyTypes() {
            this.zzd = true;
            return this;
        }

        @Deprecated
        public Builder includeAudioBytes(int i) {
            Preconditions.checkArgument(this.zze == 0, "includeAudioBytes() can only be called once per MessageFilter instance.");
            Preconditions.checkArgument(i > 0, "Invalid value for numAudioBytes: " + i);
            Preconditions.checkArgument(i <= 10, "numAudioBytes is capped by AudioBytes.MAX_SIZE = 10");
            zza(Message.MESSAGE_NAMESPACE_RESERVED, Message.MESSAGE_TYPE_AUDIO_BYTES);
            this.zze = i;
            return this;
        }

        public Builder includeEddystoneUids(String str, String str2) {
            zza(Message.MESSAGE_NAMESPACE_RESERVED, Message.MESSAGE_TYPE_EDDYSTONE_UID);
            this.zzb.add(zznj.zza(str, str2));
            return this;
        }

        public Builder includeFilter(MessageFilter messageFilter) {
            this.zza.addAll(messageFilter.zzc());
            this.zzb.addAll(messageFilter.zzb());
            this.zzc.addAll(messageFilter.zza());
            this.zzd = messageFilter.zzd() | this.zzd;
            return this;
        }

        public Builder includeIBeaconIds(UUID uuid, Short sh, Short sh2) {
            zza(Message.MESSAGE_NAMESPACE_RESERVED, Message.MESSAGE_TYPE_I_BEACON_ID);
            this.zzb.add(zznj.zzb(uuid, sh, sh2));
            return this;
        }

        public Builder includeNamespacedType(String str, String str2) {
            Preconditions.checkArgument((str == null || str.isEmpty() || str.contains("*")) ? false : true, "namespace(%s) cannot be null, empty or contain (*).", str);
            Preconditions.checkArgument((str2 == null || str2.contains("*")) ? false : true, "type(%s) cannot be null or contain (*).", str2);
            zza(str, str2);
            return this;
        }
    }

    static {
        Builder builder = new Builder();
        builder.includeAllMyTypes();
        INCLUDE_ALL_MY_TYPES = builder.build();
    }

    MessageFilter(int i, List list, List list2, boolean z, List list3, int i2) {
        this.zza = i;
        this.zzb = Collections.unmodifiableList((List) Preconditions.checkNotNull(list));
        this.zzd = z;
        this.zzc = Collections.unmodifiableList(list2 == null ? Collections.emptyList() : list2);
        this.zze = Collections.unmodifiableList(list3 == null ? Collections.emptyList() : list3);
        this.zzf = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageFilter)) {
            return false;
        }
        MessageFilter messageFilter = (MessageFilter) obj;
        return this.zzd == messageFilter.zzd && Objects.equal(this.zzb, messageFilter.zzb) && Objects.equal(this.zzc, messageFilter.zzc) && Objects.equal(this.zze, messageFilter.zze);
    }

    public int hashCode() {
        return Objects.hashCode(this.zzb, this.zzc, Boolean.valueOf(this.zzd), this.zze);
    }

    public String toString() {
        return "MessageFilter{includeAllMyTypes=" + this.zzd + ", messageTypes=" + String.valueOf(this.zzb) + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.zzb, false);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zzc, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzd);
        SafeParcelWriter.writeTypedList(parcel, 4, this.zze, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zzf);
        SafeParcelWriter.writeInt(parcel, 1000, this.zza);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final List zza() {
        return this.zze;
    }

    final List zzb() {
        return this.zzc;
    }

    public final List zzc() {
        return this.zzb;
    }

    public final boolean zzd() {
        return this.zzd;
    }
}
