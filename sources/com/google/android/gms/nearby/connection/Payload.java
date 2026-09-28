package com.google.android.gms.nearby.connection;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.internal.nearby.zzsi;
import com.google.android.gms.internal.nearby.zzsq;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.UUID;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public class Payload {
    public static final zzsq zza = zzsq.zzo(DomExceptionUtils.SEPARATOR, "\\", "../");
    public static final zzsq zzb = zzsq.zzr("../", DomExceptionUtils.SEPARATOR, "\\", "?", "*", "\"", "<", ">", "|", ":", "\u0000", "\n", "\r", "\t", "\f");
    public static final zzsq zzc = zzsq.zzp("..", ".", "\\", DomExceptionUtils.SEPARATOR);
    public static final zzsq zzd = zzsq.zzm("\\");
    public static final zzsq zze = zzsq.zzn("../", "..\\");
    public static final zzsq zzf = zzsq.zzq("?", "*", "\"", "|", ":", "\u0000", "\n", "\r", "\t", "\f");
    public static final zzsq zzg = zzsq.zzm("\\");
    public static final zzsq zzh = zzsq.zzn("\\", DomExceptionUtils.SEPARATOR);
    private final long zzi;
    private final int zzj;
    private final byte[] zzk;
    private final File zzl;
    private final Stream zzm;
    private long zzn;
    private boolean zzo;
    private String zzp;
    private String zzq;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
    public static class File {
        private final java.io.File zza;
        private final ParcelFileDescriptor zzb;
        private final long zzc;
        private final Uri zzd;

        private File(java.io.File file, ParcelFileDescriptor parcelFileDescriptor, long j, Uri uri) {
            this.zza = file;
            this.zzb = parcelFileDescriptor;
            this.zzc = j;
            this.zzd = uri;
        }

        public static File zza(java.io.File file, ParcelFileDescriptor parcelFileDescriptor, long j, Uri uri) {
            return new File((java.io.File) Preconditions.checkNotNull(file, "Cannot create Payload.File from null java.io.File."), (ParcelFileDescriptor) Preconditions.checkNotNull(parcelFileDescriptor, "Cannot create Payload.File from null ParcelFileDescriptor."), j, (Uri) Preconditions.checkNotNull(uri, "Cannot create Payload.File from null Uri"));
        }

        public static File zzb(ParcelFileDescriptor parcelFileDescriptor) {
            return new File(null, (ParcelFileDescriptor) Preconditions.checkNotNull(parcelFileDescriptor, "Cannot create Payload.File from null ParcelFileDescriptor."), parcelFileDescriptor.getStatSize(), null);
        }

        @Deprecated
        public java.io.File asJavaFile() {
            return this.zza;
        }

        public ParcelFileDescriptor asParcelFileDescriptor() {
            return this.zzb;
        }

        public Uri asUri() {
            return this.zzd;
        }

        @Deprecated
        public void close() {
            IOUtils.closeQuietly(this.zzb);
        }

        public long getSize() {
            return this.zzc;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
    public static class Stream {
        private final ParcelFileDescriptor zza;
        private InputStream zzb;

        private Stream(ParcelFileDescriptor parcelFileDescriptor, InputStream inputStream) {
            this.zza = parcelFileDescriptor;
            this.zzb = inputStream;
        }

        public static Stream zza(InputStream inputStream) {
            Preconditions.checkNotNull(inputStream, "Cannot create Payload.Stream from null InputStream.");
            return new Stream(null, inputStream);
        }

        public static Stream zzb(ParcelFileDescriptor parcelFileDescriptor) {
            Preconditions.checkNotNull(parcelFileDescriptor, "Cannot create Payload.Stream from null ParcelFileDescriptor.");
            return new Stream(parcelFileDescriptor, null);
        }

        public InputStream asInputStream() {
            if (this.zzb == null) {
                this.zzb = new ParcelFileDescriptor.AutoCloseInputStream((ParcelFileDescriptor) Preconditions.checkNotNull(this.zza));
            }
            return this.zzb;
        }

        public ParcelFileDescriptor asParcelFileDescriptor() {
            return this.zza;
        }

        @Deprecated
        public void close() {
            IOUtils.closeQuietly(this.zza);
            IOUtils.closeQuietly(this.zzb);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
    public @interface Type {
        public static final int BYTES = 1;
        public static final int FILE = 2;
        public static final int STREAM = 3;
    }

    private Payload(long j, int i, byte[] bArr, File file, Stream stream) {
        this.zzi = j;
        this.zzj = i;
        this.zzk = bArr;
        this.zzl = file;
        this.zzm = stream;
    }

    public static Payload fromBytes(byte[] bArr) {
        Preconditions.checkNotNull(bArr, "Cannot create a Payload from null bytes.");
        return zza(bArr, UUID.randomUUID().getLeastSignificantBits());
    }

    public static Payload fromFile(ParcelFileDescriptor parcelFileDescriptor) {
        return zzb(File.zzb(parcelFileDescriptor), UUID.randomUUID().getLeastSignificantBits());
    }

    public static Payload fromStream(ParcelFileDescriptor parcelFileDescriptor) {
        return zzc(Stream.zzb(parcelFileDescriptor), UUID.randomUUID().getLeastSignificantBits());
    }

    public static Payload zza(byte[] bArr, long j) {
        return new Payload(j, 1, bArr, null, null);
    }

    public static Payload zzb(File file, long j) {
        return new Payload(j, 2, null, file, null);
    }

    public static Payload zzc(Stream stream, long j) {
        return new Payload(j, 3, null, null, stream);
    }

    public byte[] asBytes() {
        return this.zzk;
    }

    public File asFile() {
        return this.zzl;
    }

    public Stream asStream() {
        return this.zzm;
    }

    public void close() {
        File file = this.zzl;
        if (file != null) {
            file.close();
        }
        Stream stream = this.zzm;
        if (stream != null) {
            stream.close();
        }
    }

    public long getId() {
        return this.zzi;
    }

    public long getOffset() {
        return this.zzn;
    }

    public int getType() {
        return this.zzj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setFileName(String str) {
        if (zzsi.zzb(str)) {
            throw new IllegalArgumentException("Payload file name should not be null or empty.");
        }
        if (getType() != 2) {
            throw new IllegalArgumentException("Payload type must be FILE.");
        }
        zzsq zzsqVar = zza;
        int size = zzsqVar.size();
        int i = 0;
        while (i < size) {
            String str2 = (String) zzsqVar.get(i);
            i++;
            if (str.contains(str2)) {
                throw new IllegalArgumentException("File name " + str + " contains illegal string " + str2 + ".");
            }
        }
        this.zzp = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setParentFolder(String str) {
        if (zzsi.zzb(str)) {
            throw new IllegalArgumentException("Payload parent folder should not be null or empty.");
        }
        if (getType() != 2) {
            throw new IllegalArgumentException("Payload type must be FILE.");
        }
        zzsq zzsqVar = zze;
        int size = zzsqVar.size();
        int i = 0;
        while (i < size) {
            boolean zContains = str.contains((String) zzsqVar.get(i));
            i++;
            if (zContains) {
                throw new IllegalArgumentException("Folder name contains illegal string.");
            }
        }
        this.zzq = str;
    }

    public void setSensitive(boolean z) {
        this.zzo = z;
    }

    public final String zzd() {
        return this.zzp;
    }

    public final String zze() {
        return this.zzq;
    }

    public final boolean zzf() {
        return this.zzo;
    }

    public void setOffset(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Payload offset must be positive or zero.");
        }
        if (getType() != 2 && getType() != 3) {
            throw new IllegalArgumentException("Payload offset only support FILE or STREAM type.");
        }
        File file = this.zzl;
        if (file != null && j >= file.getSize()) {
            throw new IllegalArgumentException("Payload offset should be smaller than the file size.");
        }
        getType();
        this.zzn = j;
    }

    public static Payload fromFile(java.io.File file) throws FileNotFoundException {
        return zzb(File.zza(file, ParcelFileDescriptor.open(file, 268435456), file.length(), Uri.fromFile(file)), UUID.randomUUID().getLeastSignificantBits());
    }

    public static Payload fromStream(InputStream inputStream) {
        return zzc(Stream.zza(inputStream), UUID.randomUUID().getLeastSignificantBits());
    }
}
