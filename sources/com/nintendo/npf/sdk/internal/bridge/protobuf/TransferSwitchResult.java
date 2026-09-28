package com.nintendo.npf.sdk.internal.bridge.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.nintendo.npf.sdk.core.h2;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class TransferSwitchResult extends GeneratedMessageLite<TransferSwitchResult, Builder> implements h2, TransferSwitchResultOrBuilder {
    private static final TransferSwitchResult DEFAULT_INSTANCE;
    public static final int NEW_USER_ID_FIELD_NUMBER = 2;
    public static final int OLD_USER_ID_FIELD_NUMBER = 1;
    private static volatile Parser<TransferSwitchResult> PARSER = null;
    public static final int USED_TRANSFER_CODE_FIELD_NUMBER = 4;
    public static final int USED_TRANSFER_ID_FIELD_NUMBER = 3;
    private int bitField0_;
    private String oldUserId_ = "";
    private String newUserId_ = "";
    private String usedTransferId_ = "";
    private String usedTransferCode_ = "";

    public static final class Builder extends GeneratedMessageLite.Builder<TransferSwitchResult, Builder> implements TransferSwitchResultOrBuilder {
        /* synthetic */ Builder(a aVar) {
            this();
        }

        public Builder clearNewUserId() {
            copyOnWrite();
            ((TransferSwitchResult) this.instance).clearNewUserId();
            return this;
        }

        public Builder clearOldUserId() {
            copyOnWrite();
            ((TransferSwitchResult) this.instance).clearOldUserId();
            return this;
        }

        public Builder clearUsedTransferCode() {
            copyOnWrite();
            ((TransferSwitchResult) this.instance).clearUsedTransferCode();
            return this;
        }

        public Builder clearUsedTransferId() {
            copyOnWrite();
            ((TransferSwitchResult) this.instance).clearUsedTransferId();
            return this;
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.TransferSwitchResultOrBuilder
        public String getNewUserId() {
            return ((TransferSwitchResult) this.instance).getNewUserId();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.TransferSwitchResultOrBuilder
        public ByteString getNewUserIdBytes() {
            return ((TransferSwitchResult) this.instance).getNewUserIdBytes();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.TransferSwitchResultOrBuilder
        public String getOldUserId() {
            return ((TransferSwitchResult) this.instance).getOldUserId();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.TransferSwitchResultOrBuilder
        public ByteString getOldUserIdBytes() {
            return ((TransferSwitchResult) this.instance).getOldUserIdBytes();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.TransferSwitchResultOrBuilder
        public String getUsedTransferCode() {
            return ((TransferSwitchResult) this.instance).getUsedTransferCode();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.TransferSwitchResultOrBuilder
        public ByteString getUsedTransferCodeBytes() {
            return ((TransferSwitchResult) this.instance).getUsedTransferCodeBytes();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.TransferSwitchResultOrBuilder
        public String getUsedTransferId() {
            return ((TransferSwitchResult) this.instance).getUsedTransferId();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.TransferSwitchResultOrBuilder
        public ByteString getUsedTransferIdBytes() {
            return ((TransferSwitchResult) this.instance).getUsedTransferIdBytes();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.TransferSwitchResultOrBuilder
        public boolean hasNewUserId() {
            return ((TransferSwitchResult) this.instance).hasNewUserId();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.TransferSwitchResultOrBuilder
        public boolean hasOldUserId() {
            return ((TransferSwitchResult) this.instance).hasOldUserId();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.TransferSwitchResultOrBuilder
        public boolean hasUsedTransferCode() {
            return ((TransferSwitchResult) this.instance).hasUsedTransferCode();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.TransferSwitchResultOrBuilder
        public boolean hasUsedTransferId() {
            return ((TransferSwitchResult) this.instance).hasUsedTransferId();
        }

        public Builder setNewUserId(String str) {
            copyOnWrite();
            ((TransferSwitchResult) this.instance).setNewUserId(str);
            return this;
        }

        public Builder setNewUserIdBytes(ByteString byteString) {
            copyOnWrite();
            ((TransferSwitchResult) this.instance).setNewUserIdBytes(byteString);
            return this;
        }

        public Builder setOldUserId(String str) {
            copyOnWrite();
            ((TransferSwitchResult) this.instance).setOldUserId(str);
            return this;
        }

        public Builder setOldUserIdBytes(ByteString byteString) {
            copyOnWrite();
            ((TransferSwitchResult) this.instance).setOldUserIdBytes(byteString);
            return this;
        }

        public Builder setUsedTransferCode(String str) {
            copyOnWrite();
            ((TransferSwitchResult) this.instance).setUsedTransferCode(str);
            return this;
        }

        public Builder setUsedTransferCodeBytes(ByteString byteString) {
            copyOnWrite();
            ((TransferSwitchResult) this.instance).setUsedTransferCodeBytes(byteString);
            return this;
        }

        public Builder setUsedTransferId(String str) {
            copyOnWrite();
            ((TransferSwitchResult) this.instance).setUsedTransferId(str);
            return this;
        }

        public Builder setUsedTransferIdBytes(ByteString byteString) {
            copyOnWrite();
            ((TransferSwitchResult) this.instance).setUsedTransferIdBytes(byteString);
            return this;
        }

        private Builder() {
            super(TransferSwitchResult.DEFAULT_INSTANCE);
        }
    }

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f745a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f745a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f745a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f745a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f745a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f745a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f745a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f745a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    static {
        TransferSwitchResult transferSwitchResult = new TransferSwitchResult();
        DEFAULT_INSTANCE = transferSwitchResult;
        GeneratedMessageLite.registerDefaultInstance(TransferSwitchResult.class, transferSwitchResult);
    }

    private TransferSwitchResult() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNewUserId() {
        this.bitField0_ &= -3;
        this.newUserId_ = getDefaultInstance().getNewUserId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOldUserId() {
        this.bitField0_ &= -2;
        this.oldUserId_ = getDefaultInstance().getOldUserId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUsedTransferCode() {
        this.bitField0_ &= -9;
        this.usedTransferCode_ = getDefaultInstance().getUsedTransferCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUsedTransferId() {
        this.bitField0_ &= -5;
        this.usedTransferId_ = getDefaultInstance().getUsedTransferId();
    }

    public static TransferSwitchResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static TransferSwitchResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (TransferSwitchResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TransferSwitchResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (TransferSwitchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<TransferSwitchResult> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNewUserId(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.newUserId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNewUserIdBytes(ByteString byteString) {
        this.newUserId_ = byteString.toStringUtf8();
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOldUserId(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.oldUserId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOldUserIdBytes(ByteString byteString) {
        this.oldUserId_ = byteString.toStringUtf8();
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUsedTransferCode(String str) {
        str.getClass();
        this.bitField0_ |= 8;
        this.usedTransferCode_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUsedTransferCodeBytes(ByteString byteString) {
        this.usedTransferCode_ = byteString.toStringUtf8();
        this.bitField0_ |= 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUsedTransferId(String str) {
        str.getClass();
        this.bitField0_ |= 4;
        this.usedTransferId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUsedTransferIdBytes(ByteString byteString) {
        this.usedTransferId_ = byteString.toStringUtf8();
        this.bitField0_ |= 4;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        a aVar = null;
        switch (a.f745a[methodToInvoke.ordinal()]) {
            case 1:
                return new TransferSwitchResult();
            case 2:
                return new Builder(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003", new Object[]{"bitField0_", "oldUserId_", "newUserId_", "usedTransferId_", "usedTransferCode_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<TransferSwitchResult> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (TransferSwitchResult.class) {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                    break;
                }
                return defaultInstanceBasedParser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // com.nintendo.npf.sdk.core.h2, com.nintendo.npf.sdk.internal.bridge.protobuf.TransferSwitchResultOrBuilder
    public String getNewUserId() {
        return this.newUserId_;
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.TransferSwitchResultOrBuilder
    public ByteString getNewUserIdBytes() {
        return ByteString.copyFromUtf8(this.newUserId_);
    }

    @Override // com.nintendo.npf.sdk.core.h2, com.nintendo.npf.sdk.internal.bridge.protobuf.TransferSwitchResultOrBuilder
    public String getOldUserId() {
        return this.oldUserId_;
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.TransferSwitchResultOrBuilder
    public ByteString getOldUserIdBytes() {
        return ByteString.copyFromUtf8(this.oldUserId_);
    }

    @Override // com.nintendo.npf.sdk.core.h2, com.nintendo.npf.sdk.internal.bridge.protobuf.TransferSwitchResultOrBuilder
    public String getUsedTransferCode() {
        return this.usedTransferCode_;
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.TransferSwitchResultOrBuilder
    public ByteString getUsedTransferCodeBytes() {
        return ByteString.copyFromUtf8(this.usedTransferCode_);
    }

    @Override // com.nintendo.npf.sdk.core.h2, com.nintendo.npf.sdk.internal.bridge.protobuf.TransferSwitchResultOrBuilder
    public String getUsedTransferId() {
        return this.usedTransferId_;
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.TransferSwitchResultOrBuilder
    public ByteString getUsedTransferIdBytes() {
        return ByteString.copyFromUtf8(this.usedTransferId_);
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.TransferSwitchResultOrBuilder
    public boolean hasNewUserId() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.TransferSwitchResultOrBuilder
    public boolean hasOldUserId() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.TransferSwitchResultOrBuilder
    public boolean hasUsedTransferCode() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.TransferSwitchResultOrBuilder
    public boolean hasUsedTransferId() {
        return (this.bitField0_ & 4) != 0;
    }

    public static Builder newBuilder(TransferSwitchResult transferSwitchResult) {
        return DEFAULT_INSTANCE.createBuilder(transferSwitchResult);
    }

    public static TransferSwitchResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TransferSwitchResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TransferSwitchResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TransferSwitchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static TransferSwitchResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (TransferSwitchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static TransferSwitchResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TransferSwitchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static TransferSwitchResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (TransferSwitchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TransferSwitchResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TransferSwitchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static TransferSwitchResult parseFrom(InputStream inputStream) throws IOException {
        return (TransferSwitchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TransferSwitchResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TransferSwitchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TransferSwitchResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (TransferSwitchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static TransferSwitchResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TransferSwitchResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
