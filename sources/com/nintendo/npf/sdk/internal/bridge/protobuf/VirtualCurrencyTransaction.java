package com.nintendo.npf.sdk.internal.bridge.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.nintendo.npf.sdk.core.i2;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class VirtualCurrencyTransaction extends GeneratedMessageLite<VirtualCurrencyTransaction, Builder> implements i2, VirtualCurrencyTransactionOrBuilder {
    private static final VirtualCurrencyTransaction DEFAULT_INSTANCE;
    public static final int ORDER_ID_FIELD_NUMBER = 1;
    private static volatile Parser<VirtualCurrencyTransaction> PARSER = null;
    public static final int SKU_FIELD_NUMBER = 2;
    public static final int STATE_FIELD_NUMBER = 3;
    private int bitField0_;
    private String orderId_ = "";
    private String sku_ = "";
    private int state_;

    public static final class Builder extends GeneratedMessageLite.Builder<VirtualCurrencyTransaction, Builder> implements VirtualCurrencyTransactionOrBuilder {
        /* synthetic */ Builder(a aVar) {
            this();
        }

        public Builder clearOrderId() {
            copyOnWrite();
            ((VirtualCurrencyTransaction) this.instance).clearOrderId();
            return this;
        }

        public Builder clearSku() {
            copyOnWrite();
            ((VirtualCurrencyTransaction) this.instance).clearSku();
            return this;
        }

        public Builder clearState() {
            copyOnWrite();
            ((VirtualCurrencyTransaction) this.instance).clearState();
            return this;
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.VirtualCurrencyTransactionOrBuilder
        public String getOrderId() {
            return ((VirtualCurrencyTransaction) this.instance).getOrderId();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.VirtualCurrencyTransactionOrBuilder
        public ByteString getOrderIdBytes() {
            return ((VirtualCurrencyTransaction) this.instance).getOrderIdBytes();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.VirtualCurrencyTransactionOrBuilder
        public String getSku() {
            return ((VirtualCurrencyTransaction) this.instance).getSku();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.VirtualCurrencyTransactionOrBuilder
        public ByteString getSkuBytes() {
            return ((VirtualCurrencyTransaction) this.instance).getSkuBytes();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.VirtualCurrencyTransactionOrBuilder
        public VirtualCurrencyTransactionState getState() {
            return ((VirtualCurrencyTransaction) this.instance).getState();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.VirtualCurrencyTransactionOrBuilder
        public boolean hasOrderId() {
            return ((VirtualCurrencyTransaction) this.instance).hasOrderId();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.VirtualCurrencyTransactionOrBuilder
        public boolean hasSku() {
            return ((VirtualCurrencyTransaction) this.instance).hasSku();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.VirtualCurrencyTransactionOrBuilder
        public boolean hasState() {
            return ((VirtualCurrencyTransaction) this.instance).hasState();
        }

        public Builder setOrderId(String str) {
            copyOnWrite();
            ((VirtualCurrencyTransaction) this.instance).setOrderId(str);
            return this;
        }

        public Builder setOrderIdBytes(ByteString byteString) {
            copyOnWrite();
            ((VirtualCurrencyTransaction) this.instance).setOrderIdBytes(byteString);
            return this;
        }

        public Builder setSku(String str) {
            copyOnWrite();
            ((VirtualCurrencyTransaction) this.instance).setSku(str);
            return this;
        }

        public Builder setSkuBytes(ByteString byteString) {
            copyOnWrite();
            ((VirtualCurrencyTransaction) this.instance).setSkuBytes(byteString);
            return this;
        }

        public Builder setState(VirtualCurrencyTransactionState virtualCurrencyTransactionState) {
            copyOnWrite();
            ((VirtualCurrencyTransaction) this.instance).setState(virtualCurrencyTransactionState);
            return this;
        }

        private Builder() {
            super(VirtualCurrencyTransaction.DEFAULT_INSTANCE);
        }
    }

    public enum VirtualCurrencyTransactionState implements Internal.EnumLite {
        PENDING(0),
        PURCHASED(1),
        DEFERRED(2),
        REGISTERED(3);

        public static final int DEFERRED_VALUE = 2;
        public static final int PENDING_VALUE = 0;
        public static final int PURCHASED_VALUE = 1;
        public static final int REGISTERED_VALUE = 3;
        private static final Internal.EnumLiteMap<VirtualCurrencyTransactionState> internalValueMap = new a();
        private final int value;

        class a implements Internal.EnumLiteMap {
            a() {
            }

            @Override // com.google.protobuf.Internal.EnumLiteMap
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public VirtualCurrencyTransactionState findValueByNumber(int i) {
                return VirtualCurrencyTransactionState.forNumber(i);
            }
        }

        private static final class b implements Internal.EnumVerifier {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            static final Internal.EnumVerifier f746a = new b();

            private b() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return VirtualCurrencyTransactionState.forNumber(i) != null;
            }
        }

        VirtualCurrencyTransactionState(int i) {
            this.value = i;
        }

        public static VirtualCurrencyTransactionState forNumber(int i) {
            if (i == 0) {
                return PENDING;
            }
            if (i == 1) {
                return PURCHASED;
            }
            if (i == 2) {
                return DEFERRED;
            }
            if (i != 3) {
                return null;
            }
            return REGISTERED;
        }

        public static Internal.EnumLiteMap<VirtualCurrencyTransactionState> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return b.f746a;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static VirtualCurrencyTransactionState valueOf(int i) {
            return forNumber(i);
        }
    }

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f747a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f747a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f747a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f747a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f747a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f747a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f747a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f747a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    static {
        VirtualCurrencyTransaction virtualCurrencyTransaction = new VirtualCurrencyTransaction();
        DEFAULT_INSTANCE = virtualCurrencyTransaction;
        GeneratedMessageLite.registerDefaultInstance(VirtualCurrencyTransaction.class, virtualCurrencyTransaction);
    }

    private VirtualCurrencyTransaction() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOrderId() {
        this.bitField0_ &= -2;
        this.orderId_ = getDefaultInstance().getOrderId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSku() {
        this.bitField0_ &= -3;
        this.sku_ = getDefaultInstance().getSku();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearState() {
        this.bitField0_ &= -5;
        this.state_ = 0;
    }

    public static VirtualCurrencyTransaction getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static VirtualCurrencyTransaction parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (VirtualCurrencyTransaction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VirtualCurrencyTransaction parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (VirtualCurrencyTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<VirtualCurrencyTransaction> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOrderId(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.orderId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOrderIdBytes(ByteString byteString) {
        this.orderId_ = byteString.toStringUtf8();
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSku(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.sku_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSkuBytes(ByteString byteString) {
        this.sku_ = byteString.toStringUtf8();
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setState(VirtualCurrencyTransactionState virtualCurrencyTransactionState) {
        this.state_ = virtualCurrencyTransactionState.getNumber();
        this.bitField0_ |= 4;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        a aVar = null;
        switch (a.f747a[methodToInvoke.ordinal()]) {
            case 1:
                return new VirtualCurrencyTransaction();
            case 2:
                return new Builder(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဌ\u0002", new Object[]{"bitField0_", "orderId_", "sku_", "state_", VirtualCurrencyTransactionState.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<VirtualCurrencyTransaction> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (VirtualCurrencyTransaction.class) {
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

    @Override // com.nintendo.npf.sdk.core.i2, com.nintendo.npf.sdk.internal.bridge.protobuf.VirtualCurrencyTransactionOrBuilder
    public String getOrderId() {
        return this.orderId_;
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.VirtualCurrencyTransactionOrBuilder
    public ByteString getOrderIdBytes() {
        return ByteString.copyFromUtf8(this.orderId_);
    }

    @Override // com.nintendo.npf.sdk.core.i2, com.nintendo.npf.sdk.internal.bridge.protobuf.VirtualCurrencyTransactionOrBuilder
    public String getSku() {
        return this.sku_;
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.VirtualCurrencyTransactionOrBuilder
    public ByteString getSkuBytes() {
        return ByteString.copyFromUtf8(this.sku_);
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.VirtualCurrencyTransactionOrBuilder
    public VirtualCurrencyTransactionState getState() {
        VirtualCurrencyTransactionState virtualCurrencyTransactionStateForNumber = VirtualCurrencyTransactionState.forNumber(this.state_);
        return virtualCurrencyTransactionStateForNumber == null ? VirtualCurrencyTransactionState.PENDING : virtualCurrencyTransactionStateForNumber;
    }

    @Override // com.nintendo.npf.sdk.core.i2
    public String getStateString() {
        return getState().name();
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.VirtualCurrencyTransactionOrBuilder
    public boolean hasOrderId() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.VirtualCurrencyTransactionOrBuilder
    public boolean hasSku() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.VirtualCurrencyTransactionOrBuilder
    public boolean hasState() {
        return (this.bitField0_ & 4) != 0;
    }

    public static Builder newBuilder(VirtualCurrencyTransaction virtualCurrencyTransaction) {
        return DEFAULT_INSTANCE.createBuilder(virtualCurrencyTransaction);
    }

    public static VirtualCurrencyTransaction parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (VirtualCurrencyTransaction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static VirtualCurrencyTransaction parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (VirtualCurrencyTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static VirtualCurrencyTransaction parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (VirtualCurrencyTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static VirtualCurrencyTransaction parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (VirtualCurrencyTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static VirtualCurrencyTransaction parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (VirtualCurrencyTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static VirtualCurrencyTransaction parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (VirtualCurrencyTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static VirtualCurrencyTransaction parseFrom(InputStream inputStream) throws IOException {
        return (VirtualCurrencyTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VirtualCurrencyTransaction parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (VirtualCurrencyTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static VirtualCurrencyTransaction parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (VirtualCurrencyTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static VirtualCurrencyTransaction parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (VirtualCurrencyTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
