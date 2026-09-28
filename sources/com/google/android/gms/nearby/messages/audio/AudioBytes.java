package com.google.android.gms.nearby.messages.audio;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.nearby.messages.Message;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class AudioBytes {
    public static final int MAX_SIZE = 10;
    private final byte[] zza;

    public AudioBytes(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        int length = bArr.length;
        Preconditions.checkArgument(length <= 10, "Given byte array longer than 10 bytes, given by AudioBytes.MAX_SIZE.");
        Preconditions.checkArgument(length > 0, "Given byte array is of zero length.");
        this.zza = bArr;
    }

    public static AudioBytes from(Message message) {
        Preconditions.checkNotNull(message);
        Preconditions.checkArgument(message.zza(Message.MESSAGE_TYPE_AUDIO_BYTES), "Message type '" + message.getType() + "' is not Message.MESSAGE_TYPE_AUDIO_BYTES.");
        return new AudioBytes(message.getContent());
    }

    public byte[] getBytes() {
        return this.zza;
    }

    public Message toMessage() {
        return new Message(this.zza, Message.MESSAGE_NAMESPACE_RESERVED, Message.MESSAGE_TYPE_AUDIO_BYTES);
    }

    public String toString() {
        return "AudioBytes [" + Arrays.toString(this.zza) + " ]";
    }
}
