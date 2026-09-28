package com.nintendo.npf.sdk.internal.bridge.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.nintendo.npf.sdk.core.g2;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class TransferIdentifier extends GeneratedMessageLite<TransferIdentifier, Builder> implements g2, TransferIdentifierOrBuilder {
    private static final TransferIdentifier DEFAULT_INSTANCE;
    private static volatile Parser<TransferIdentifier> PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private int bitField0_;
    private String value_ = "";

    public static final class Builder extends GeneratedMessageLite.Builder<TransferIdentifier, Builder> implements TransferIdentifierOrBuilder {
        /* synthetic */ Builder(a aVar) {
            this();
        }

        public Builder clearValue() {
            copyOnWrite();
            ((TransferIdentifier) this.instance).clearValue();
            return this;
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.TransferIdentifierOrBuilder
        public String getValue() {
            return ((TransferIdentifier) this.instance).getValue();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.TransferIdentifierOrBuilder
        public ByteString getValueBytes() {
            return ((TransferIdentifier) this.instance).getValueBytes();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.TransferIdentifierOrBuilder
        public boolean hasValue() {
            return ((TransferIdentifier) this.instance).hasValue();
        }

        public Builder setValue(String str) {
            copyOnWrite();
            ((TransferIdentifier) this.instance).setValue(str);
            return this;
        }

        public Builder setValueBytes(ByteString byteString) {
            copyOnWrite();
            ((TransferIdentifier) this.instance).setValueBytes(byteString);
            return this;
        }

        private Builder() {
            super(TransferIdentifier.DEFAULT_INSTANCE);
        }
    }

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f744a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f744a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f744a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f744a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f744a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f744a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f744a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f744a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    static {
        TransferIdentifier transferIdentifier = new TransferIdentifier();
        DEFAULT_INSTANCE = transferIdentifier;
        GeneratedMessageLite.registerDefaultInstance(TransferIdentifier.class, transferIdentifier);
    }

    private TransferIdentifier() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearValue() {
        this.bitField0_ &= -2;
        this.value_ = getDefaultInstance().getValue();
    }

    public static TransferIdentifier getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static TransferIdentifier parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (TransferIdentifier) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TransferIdentifier parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (TransferIdentifier) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<TransferIdentifier> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValue(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.value_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValueBytes(ByteString byteString) {
        this.value_ = byteString.toStringUtf8();
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        a aVar = null;
        switch (a.f744a[methodToInvoke.ordinal()]) {
            case 1:
                return new TransferIdentifier();
            case 2:
                return new Builder(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"bitField0_", "value_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<TransferIdentifier> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (TransferIdentifier.class) {
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

    @Override // com.nintendo.npf.sdk.core.g2, com.nintendo.npf.sdk.internal.bridge.protobuf.TransferIdentifierOrBuilder
    public String getValue() {
        return this.value_;
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.TransferIdentifierOrBuilder
    public ByteString getValueBytes() {
        return ByteString.copyFromUtf8(this.value_);
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.TransferIdentifierOrBuilder
    public boolean hasValue() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(TransferIdentifier transferIdentifier) {
        return DEFAULT_INSTANCE.createBuilder(transferIdentifier);
    }

    public static TransferIdentifier parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TransferIdentifier) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TransferIdentifier parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TransferIdentifier) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static TransferIdentifier parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (TransferIdentifier) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static TransferIdentifier parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TransferIdentifier) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static TransferIdentifier parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (TransferIdentifier) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TransferIdentifier parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TransferIdentifier) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static TransferIdentifier parseFrom(InputStream inputStream) throws IOException {
        return (TransferIdentifier) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TransferIdentifier parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TransferIdentifier) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TransferIdentifier parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (TransferIdentifier) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static TransferIdentifier parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TransferIdentifier) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
