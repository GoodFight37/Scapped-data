package com.nintendo.npf.sdk.internal.bridge.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.nintendo.npf.sdk.internal.model.INPFError;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class NPFError extends GeneratedMessageLite<NPFError, Builder> implements INPFError, NPFErrorOrBuilder {
    private static final NPFError DEFAULT_INSTANCE;
    public static final int ERROR_CODE_FIELD_NUMBER = 2;
    public static final int ERROR_MESSAGE_FIELD_NUMBER = 3;
    public static final int ERROR_TYPE_FIELD_NUMBER = 1;
    public static final int ORIGINAL_ERROR_MESSAGE_FIELD_NUMBER = 5;
    public static final int ORIGINAL_ERROR_TYPE_FIELD_NUMBER = 4;
    private static volatile Parser<NPFError> PARSER;
    private int bitField0_;
    private int errorCode_;
    private int errorType_;
    private int originalErrorType_;
    private String errorMessage_ = "";
    private String originalErrorMessage_ = "";

    public static final class Builder extends GeneratedMessageLite.Builder<NPFError, Builder> implements NPFErrorOrBuilder {
        /* synthetic */ Builder(a aVar) {
            this();
        }

        public Builder clearErrorCode() {
            copyOnWrite();
            ((NPFError) this.instance).clearErrorCode();
            return this;
        }

        public Builder clearErrorMessage() {
            copyOnWrite();
            ((NPFError) this.instance).clearErrorMessage();
            return this;
        }

        public Builder clearErrorType() {
            copyOnWrite();
            ((NPFError) this.instance).clearErrorType();
            return this;
        }

        public Builder clearOriginalErrorMessage() {
            copyOnWrite();
            ((NPFError) this.instance).clearOriginalErrorMessage();
            return this;
        }

        public Builder clearOriginalErrorType() {
            copyOnWrite();
            ((NPFError) this.instance).clearOriginalErrorType();
            return this;
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.NPFErrorOrBuilder
        public int getErrorCode() {
            return ((NPFError) this.instance).getErrorCode();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.NPFErrorOrBuilder
        public String getErrorMessage() {
            return ((NPFError) this.instance).getErrorMessage();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.NPFErrorOrBuilder
        public ByteString getErrorMessageBytes() {
            return ((NPFError) this.instance).getErrorMessageBytes();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.NPFErrorOrBuilder
        public ErrorType getErrorType() {
            return ((NPFError) this.instance).getErrorType();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.NPFErrorOrBuilder
        public String getOriginalErrorMessage() {
            return ((NPFError) this.instance).getOriginalErrorMessage();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.NPFErrorOrBuilder
        public ByteString getOriginalErrorMessageBytes() {
            return ((NPFError) this.instance).getOriginalErrorMessageBytes();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.NPFErrorOrBuilder
        public OriginalErrorType getOriginalErrorType() {
            return ((NPFError) this.instance).getOriginalErrorType();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.NPFErrorOrBuilder
        public boolean hasErrorCode() {
            return ((NPFError) this.instance).hasErrorCode();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.NPFErrorOrBuilder
        public boolean hasErrorMessage() {
            return ((NPFError) this.instance).hasErrorMessage();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.NPFErrorOrBuilder
        public boolean hasErrorType() {
            return ((NPFError) this.instance).hasErrorType();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.NPFErrorOrBuilder
        public boolean hasOriginalErrorMessage() {
            return ((NPFError) this.instance).hasOriginalErrorMessage();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.NPFErrorOrBuilder
        public boolean hasOriginalErrorType() {
            return ((NPFError) this.instance).hasOriginalErrorType();
        }

        public Builder setErrorCode(int i) {
            copyOnWrite();
            ((NPFError) this.instance).setErrorCode(i);
            return this;
        }

        public Builder setErrorMessage(String str) {
            copyOnWrite();
            ((NPFError) this.instance).setErrorMessage(str);
            return this;
        }

        public Builder setErrorMessageBytes(ByteString byteString) {
            copyOnWrite();
            ((NPFError) this.instance).setErrorMessageBytes(byteString);
            return this;
        }

        public Builder setErrorType(ErrorType errorType) {
            copyOnWrite();
            ((NPFError) this.instance).setErrorType(errorType);
            return this;
        }

        public Builder setOriginalErrorMessage(String str) {
            copyOnWrite();
            ((NPFError) this.instance).setOriginalErrorMessage(str);
            return this;
        }

        public Builder setOriginalErrorMessageBytes(ByteString byteString) {
            copyOnWrite();
            ((NPFError) this.instance).setOriginalErrorMessageBytes(byteString);
            return this;
        }

        public Builder setOriginalErrorType(OriginalErrorType originalErrorType) {
            copyOnWrite();
            ((NPFError) this.instance).setOriginalErrorType(originalErrorType);
            return this;
        }

        private Builder() {
            super(NPFError.DEFAULT_INSTANCE);
        }
    }

    public enum ErrorType implements Internal.EnumLite {
        NETWORK_ERROR(0),
        NPF_ERROR(1),
        INVALID_NA_TOKEN(2),
        NA_EULA_UPDATE(3),
        INVALID_NA_USER(4),
        MISMATCHED_NA_USER(5),
        PROCESS_CANCEL(12),
        USER_CANCEL(11);

        public static final int INVALID_NA_TOKEN_VALUE = 2;
        public static final int INVALID_NA_USER_VALUE = 4;
        public static final int MISMATCHED_NA_USER_VALUE = 5;
        public static final int NA_EULA_UPDATE_VALUE = 3;
        public static final int NETWORK_ERROR_VALUE = 0;
        public static final int NPF_ERROR_VALUE = 1;
        public static final int PROCESS_CANCEL_VALUE = 12;
        public static final int USER_CANCEL_VALUE = 11;
        private static final Internal.EnumLiteMap<ErrorType> internalValueMap = new a();
        private final int value;

        class a implements Internal.EnumLiteMap {
            a() {
            }

            @Override // com.google.protobuf.Internal.EnumLiteMap
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ErrorType findValueByNumber(int i) {
                return ErrorType.forNumber(i);
            }
        }

        private static final class b implements Internal.EnumVerifier {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            static final Internal.EnumVerifier f733a = new b();

            private b() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return ErrorType.forNumber(i) != null;
            }
        }

        ErrorType(int i) {
            this.value = i;
        }

        public static ErrorType forNumber(int i) {
            if (i == 11) {
                return USER_CANCEL;
            }
            if (i == 12) {
                return PROCESS_CANCEL;
            }
            if (i == 0) {
                return NETWORK_ERROR;
            }
            if (i == 1) {
                return NPF_ERROR;
            }
            if (i == 2) {
                return INVALID_NA_TOKEN;
            }
            if (i == 3) {
                return NA_EULA_UPDATE;
            }
            if (i == 4) {
                return INVALID_NA_USER;
            }
            if (i != 5) {
                return null;
            }
            return MISMATCHED_NA_USER;
        }

        public static Internal.EnumLiteMap<ErrorType> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return b.f733a;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static ErrorType valueOf(int i) {
            return forNumber(i);
        }
    }

    public enum OriginalErrorType implements Internal.EnumLite {
        NPF_SDK_ERROR(0),
        GOOGLE_PLAY_BILLING_LIBRARY_ERROR(1),
        STORE_KIT_ERROR(2);

        public static final int GOOGLE_PLAY_BILLING_LIBRARY_ERROR_VALUE = 1;
        public static final int NPF_SDK_ERROR_VALUE = 0;
        public static final int STORE_KIT_ERROR_VALUE = 2;
        private static final Internal.EnumLiteMap<OriginalErrorType> internalValueMap = new a();
        private final int value;

        class a implements Internal.EnumLiteMap {
            a() {
            }

            @Override // com.google.protobuf.Internal.EnumLiteMap
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public OriginalErrorType findValueByNumber(int i) {
                return OriginalErrorType.forNumber(i);
            }
        }

        private static final class b implements Internal.EnumVerifier {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            static final Internal.EnumVerifier f734a = new b();

            private b() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return OriginalErrorType.forNumber(i) != null;
            }
        }

        OriginalErrorType(int i) {
            this.value = i;
        }

        public static OriginalErrorType forNumber(int i) {
            if (i == 0) {
                return NPF_SDK_ERROR;
            }
            if (i == 1) {
                return GOOGLE_PLAY_BILLING_LIBRARY_ERROR;
            }
            if (i != 2) {
                return null;
            }
            return STORE_KIT_ERROR;
        }

        public static Internal.EnumLiteMap<OriginalErrorType> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return b.f734a;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static OriginalErrorType valueOf(int i) {
            return forNumber(i);
        }
    }

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f735a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f735a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f735a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f735a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f735a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f735a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f735a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f735a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    static {
        NPFError nPFError = new NPFError();
        DEFAULT_INSTANCE = nPFError;
        GeneratedMessageLite.registerDefaultInstance(NPFError.class, nPFError);
    }

    private NPFError() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearErrorCode() {
        this.bitField0_ &= -3;
        this.errorCode_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearErrorMessage() {
        this.bitField0_ &= -5;
        this.errorMessage_ = getDefaultInstance().getErrorMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearErrorType() {
        this.bitField0_ &= -2;
        this.errorType_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOriginalErrorMessage() {
        this.bitField0_ &= -17;
        this.originalErrorMessage_ = getDefaultInstance().getOriginalErrorMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOriginalErrorType() {
        this.bitField0_ &= -9;
        this.originalErrorType_ = 0;
    }

    public static NPFError getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static NPFError parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (NPFError) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NPFError parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (NPFError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<NPFError> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setErrorCode(int i) {
        this.bitField0_ |= 2;
        this.errorCode_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setErrorMessage(String str) {
        str.getClass();
        this.bitField0_ |= 4;
        this.errorMessage_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setErrorMessageBytes(ByteString byteString) {
        this.errorMessage_ = byteString.toStringUtf8();
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setErrorType(ErrorType errorType) {
        this.errorType_ = errorType.getNumber();
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOriginalErrorMessage(String str) {
        str.getClass();
        this.bitField0_ |= 16;
        this.originalErrorMessage_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOriginalErrorMessageBytes(ByteString byteString) {
        this.originalErrorMessage_ = byteString.toStringUtf8();
        this.bitField0_ |= 16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOriginalErrorType(OriginalErrorType originalErrorType) {
        this.originalErrorType_ = originalErrorType.getNumber();
        this.bitField0_ |= 8;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        a aVar = null;
        switch (a.f735a[methodToInvoke.ordinal()]) {
            case 1:
                return new NPFError();
            case 2:
                return new Builder(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002င\u0001\u0003ဈ\u0002\u0004ဌ\u0003\u0005ဈ\u0004", new Object[]{"bitField0_", "errorType_", ErrorType.internalGetVerifier(), "errorCode_", "errorMessage_", "originalErrorType_", OriginalErrorType.internalGetVerifier(), "originalErrorMessage_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<NPFError> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (NPFError.class) {
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

    @Override // com.nintendo.npf.sdk.internal.model.INPFError
    public int getErrorCode() {
        return this.errorCode_;
    }

    @Override // com.nintendo.npf.sdk.internal.model.INPFError
    public String getErrorMessage() {
        return this.errorMessage_;
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.NPFErrorOrBuilder
    public ByteString getErrorMessageBytes() {
        return ByteString.copyFromUtf8(this.errorMessage_);
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.NPFErrorOrBuilder
    public ErrorType getErrorType() {
        ErrorType errorTypeForNumber = ErrorType.forNumber(this.errorType_);
        return errorTypeForNumber == null ? ErrorType.NETWORK_ERROR : errorTypeForNumber;
    }

    @Override // com.nintendo.npf.sdk.internal.model.INPFError
    public String getErrorTypeString() {
        return getErrorType().name();
    }

    @Override // com.nintendo.npf.sdk.internal.model.INPFError
    public String getOriginalErrorMessage() {
        return this.originalErrorMessage_;
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.NPFErrorOrBuilder
    public ByteString getOriginalErrorMessageBytes() {
        return ByteString.copyFromUtf8(this.originalErrorMessage_);
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.NPFErrorOrBuilder
    public OriginalErrorType getOriginalErrorType() {
        OriginalErrorType originalErrorTypeForNumber = OriginalErrorType.forNumber(this.originalErrorType_);
        return originalErrorTypeForNumber == null ? OriginalErrorType.NPF_SDK_ERROR : originalErrorTypeForNumber;
    }

    @Override // com.nintendo.npf.sdk.internal.model.INPFError
    public String getOriginalErrorTypeString() {
        return getOriginalErrorType().name();
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.NPFErrorOrBuilder
    public boolean hasErrorCode() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.NPFErrorOrBuilder
    public boolean hasErrorMessage() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.NPFErrorOrBuilder
    public boolean hasErrorType() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.NPFErrorOrBuilder
    public boolean hasOriginalErrorMessage() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.NPFErrorOrBuilder
    public boolean hasOriginalErrorType() {
        return (this.bitField0_ & 8) != 0;
    }

    public static Builder newBuilder(NPFError nPFError) {
        return DEFAULT_INSTANCE.createBuilder(nPFError);
    }

    public static NPFError parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (NPFError) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NPFError parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (NPFError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static NPFError parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (NPFError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static NPFError parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (NPFError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static NPFError parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (NPFError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static NPFError parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (NPFError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static NPFError parseFrom(InputStream inputStream) throws IOException {
        return (NPFError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NPFError parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (NPFError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NPFError parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (NPFError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static NPFError parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (NPFError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
