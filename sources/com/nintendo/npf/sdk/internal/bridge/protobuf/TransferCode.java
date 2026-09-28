package com.nintendo.npf.sdk.internal.bridge.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.nintendo.npf.sdk.core.f2;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class TransferCode extends GeneratedMessageLite<TransferCode, Builder> implements f2, TransferCodeOrBuilder {
    public static final int CODE_FIELD_NUMBER = 2;
    private static final TransferCode DEFAULT_INSTANCE;
    public static final int IDENTIFIER_FIELD_NUMBER = 1;
    private static volatile Parser<TransferCode> PARSER;
    private int bitField0_;
    private String identifier_ = "";
    private String code_ = "";

    public static final class Builder extends GeneratedMessageLite.Builder<TransferCode, Builder> implements TransferCodeOrBuilder {
        /* synthetic */ Builder(a aVar) {
            this();
        }

        public Builder clearCode() {
            copyOnWrite();
            ((TransferCode) this.instance).clearCode();
            return this;
        }

        public Builder clearIdentifier() {
            copyOnWrite();
            ((TransferCode) this.instance).clearIdentifier();
            return this;
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.TransferCodeOrBuilder
        public String getCode() {
            return ((TransferCode) this.instance).getCode();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.TransferCodeOrBuilder
        public ByteString getCodeBytes() {
            return ((TransferCode) this.instance).getCodeBytes();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.TransferCodeOrBuilder
        public String getIdentifier() {
            return ((TransferCode) this.instance).getIdentifier();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.TransferCodeOrBuilder
        public ByteString getIdentifierBytes() {
            return ((TransferCode) this.instance).getIdentifierBytes();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.TransferCodeOrBuilder
        public boolean hasCode() {
            return ((TransferCode) this.instance).hasCode();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.TransferCodeOrBuilder
        public boolean hasIdentifier() {
            return ((TransferCode) this.instance).hasIdentifier();
        }

        public Builder setCode(String str) {
            copyOnWrite();
            ((TransferCode) this.instance).setCode(str);
            return this;
        }

        public Builder setCodeBytes(ByteString byteString) {
            copyOnWrite();
            ((TransferCode) this.instance).setCodeBytes(byteString);
            return this;
        }

        public Builder setIdentifier(String str) {
            copyOnWrite();
            ((TransferCode) this.instance).setIdentifier(str);
            return this;
        }

        public Builder setIdentifierBytes(ByteString byteString) {
            copyOnWrite();
            ((TransferCode) this.instance).setIdentifierBytes(byteString);
            return this;
        }

        private Builder() {
            super(TransferCode.DEFAULT_INSTANCE);
        }
    }

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f743a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f743a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f743a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f743a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f743a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f743a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f743a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f743a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    static {
        TransferCode transferCode = new TransferCode();
        DEFAULT_INSTANCE = transferCode;
        GeneratedMessageLite.registerDefaultInstance(TransferCode.class, transferCode);
    }

    private TransferCode() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCode() {
        this.bitField0_ &= -3;
        this.code_ = getDefaultInstance().getCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIdentifier() {
        this.bitField0_ &= -2;
        this.identifier_ = getDefaultInstance().getIdentifier();
    }

    public static TransferCode getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static TransferCode parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (TransferCode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TransferCode parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (TransferCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<TransferCode> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCode(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.code_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCodeBytes(ByteString byteString) {
        this.code_ = byteString.toStringUtf8();
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIdentifier(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.identifier_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIdentifierBytes(ByteString byteString) {
        this.identifier_ = byteString.toStringUtf8();
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        a aVar = null;
        switch (a.f743a[methodToInvoke.ordinal()]) {
            case 1:
                return new TransferCode();
            case 2:
                return new Builder(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"bitField0_", "identifier_", "code_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<TransferCode> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (TransferCode.class) {
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

    @Override // com.nintendo.npf.sdk.core.f2, com.nintendo.npf.sdk.internal.bridge.protobuf.TransferCodeOrBuilder
    public String getCode() {
        return this.code_;
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.TransferCodeOrBuilder
    public ByteString getCodeBytes() {
        return ByteString.copyFromUtf8(this.code_);
    }

    @Override // com.nintendo.npf.sdk.core.f2, com.nintendo.npf.sdk.internal.bridge.protobuf.TransferCodeOrBuilder
    public String getIdentifier() {
        return this.identifier_;
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.TransferCodeOrBuilder
    public ByteString getIdentifierBytes() {
        return ByteString.copyFromUtf8(this.identifier_);
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.TransferCodeOrBuilder
    public boolean hasCode() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.TransferCodeOrBuilder
    public boolean hasIdentifier() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(TransferCode transferCode) {
        return DEFAULT_INSTANCE.createBuilder(transferCode);
    }

    public static TransferCode parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TransferCode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TransferCode parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TransferCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static TransferCode parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (TransferCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static TransferCode parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TransferCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static TransferCode parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (TransferCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TransferCode parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TransferCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static TransferCode parseFrom(InputStream inputStream) throws IOException {
        return (TransferCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TransferCode parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TransferCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TransferCode parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (TransferCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static TransferCode parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TransferCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
