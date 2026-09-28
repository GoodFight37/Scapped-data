package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.nearby.zznh;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public class Message extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final int MAX_CONTENT_SIZE_BYTES = 102400;
    public static final int MAX_TYPE_LENGTH = 32;
    public static final String MESSAGE_NAMESPACE_RESERVED = "__reserved_namespace";

    @Deprecated
    public static final String MESSAGE_TYPE_AUDIO_BYTES = "__audio_bytes";
    public static final String MESSAGE_TYPE_EDDYSTONE_UID = "__eddystone_uid";
    public static final String MESSAGE_TYPE_I_BEACON_ID = "__i_beacon_id";
    final int zza;

    @Deprecated
    final zznh[] zzb;
    private final byte[] zzd;
    private final String zze;
    private final String zzf;
    private final long zzg;
    public static final Parcelable.Creator<Message> CREATOR = new zza();
    private static final zznh[] zzc = {zznh.zza};

    Message(int i, byte[] bArr, String str, String str2, zznh[] zznhVarArr, long j) {
        this.zza = i;
        this.zze = (String) Preconditions.checkNotNull(str2);
        this.zzf = str == null ? "" : str;
        this.zzg = j;
        Preconditions.checkNotNull(bArr);
        int length = bArr.length;
        Preconditions.checkArgument(length <= 102400, "Content length(%d) must not exceed MAX_CONTENT_SIZE_BYTES(%d)", Integer.valueOf(length), Integer.valueOf(MAX_CONTENT_SIZE_BYTES));
        this.zzd = bArr;
        this.zzb = (zznhVarArr == null || zznhVarArr.length == 0) ? zzc : zznhVarArr;
        Preconditions.checkArgument(str2.length() <= 32, "Type length(%d) must not exceed MAX_TYPE_LENGTH(%d)", Integer.valueOf(str2.length()), 32);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Message)) {
            return false;
        }
        Message message = (Message) obj;
        return TextUtils.equals(this.zzf, message.zzf) && TextUtils.equals(this.zze, message.zze) && Arrays.equals(this.zzd, message.zzd) && this.zzg == message.zzg;
    }

    public byte[] getContent() {
        return this.zzd;
    }

    public String getNamespace() {
        return this.zzf;
    }

    public String getType() {
        return this.zze;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzf, this.zze, Integer.valueOf(Arrays.hashCode(this.zzd)), Long.valueOf(this.zzg));
    }

    public String toString() {
        String str = this.zzf;
        String str2 = this.zze;
        byte[] bArr = this.zzd;
        return "Message{namespace='" + str + "', type='" + str2 + "', content=[" + (bArr == null ? 0 : bArr.length) + " bytes]}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 1, getContent(), false);
        SafeParcelWriter.writeString(parcel, 2, getType(), false);
        SafeParcelWriter.writeString(parcel, 3, getNamespace(), false);
        SafeParcelWriter.writeTypedArray(parcel, 4, this.zzb, i, false);
        SafeParcelWriter.writeLong(parcel, 5, this.zzg);
        SafeParcelWriter.writeInt(parcel, 1000, this.zza);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final boolean zza(String str) {
        return MESSAGE_NAMESPACE_RESERVED.equals(getNamespace()) && str.equals(getType());
    }

    public Message(byte[] bArr) {
        this(bArr, "", "", zzc, 0L);
    }

    public Message(byte[] bArr, String str) {
        this(bArr, "", str, zzc, 0L);
    }

    public Message(byte[] bArr, String str, String str2) {
        this(bArr, MESSAGE_NAMESPACE_RESERVED, MESSAGE_TYPE_AUDIO_BYTES, zzc, 0L);
    }

    public Message(byte[] bArr, String str, String str2, zznh[] zznhVarArr, long j) {
        this(2, bArr, str, str2, zznhVarArr, 0L);
    }
}
