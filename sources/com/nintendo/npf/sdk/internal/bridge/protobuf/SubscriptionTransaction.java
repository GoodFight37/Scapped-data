package com.nintendo.npf.sdk.internal.bridge.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.nintendo.npf.sdk.internal.model.ISubscriptionTransaction;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class SubscriptionTransaction extends GeneratedMessageLite<SubscriptionTransaction, Builder> implements ISubscriptionTransaction, SubscriptionTransactionOrBuilder {
    private static final SubscriptionTransaction DEFAULT_INSTANCE;
    public static final int ORDER_ID_FIELD_NUMBER = 1;
    private static volatile Parser<SubscriptionTransaction> PARSER = null;
    public static final int PRODUCT_ID_FIELD_NUMBER = 2;
    public static final int STATE_FIELD_NUMBER = 3;
    private int bitField0_;
    private String orderId_ = "";
    private String productId_ = "";
    private int state_;

    public static final class Builder extends GeneratedMessageLite.Builder<SubscriptionTransaction, Builder> implements SubscriptionTransactionOrBuilder {
        /* synthetic */ Builder(a aVar) {
            this();
        }

        public Builder clearOrderId() {
            copyOnWrite();
            ((SubscriptionTransaction) this.instance).clearOrderId();
            return this;
        }

        public Builder clearProductId() {
            copyOnWrite();
            ((SubscriptionTransaction) this.instance).clearProductId();
            return this;
        }

        public Builder clearState() {
            copyOnWrite();
            ((SubscriptionTransaction) this.instance).clearState();
            return this;
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.SubscriptionTransactionOrBuilder
        public String getOrderId() {
            return ((SubscriptionTransaction) this.instance).getOrderId();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.SubscriptionTransactionOrBuilder
        public ByteString getOrderIdBytes() {
            return ((SubscriptionTransaction) this.instance).getOrderIdBytes();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.SubscriptionTransactionOrBuilder
        public String getProductId() {
            return ((SubscriptionTransaction) this.instance).getProductId();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.SubscriptionTransactionOrBuilder
        public ByteString getProductIdBytes() {
            return ((SubscriptionTransaction) this.instance).getProductIdBytes();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.SubscriptionTransactionOrBuilder
        public SubscriptionTransactionState getState() {
            return ((SubscriptionTransaction) this.instance).getState();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.SubscriptionTransactionOrBuilder
        public boolean hasOrderId() {
            return ((SubscriptionTransaction) this.instance).hasOrderId();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.SubscriptionTransactionOrBuilder
        public boolean hasProductId() {
            return ((SubscriptionTransaction) this.instance).hasProductId();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.SubscriptionTransactionOrBuilder
        public boolean hasState() {
            return ((SubscriptionTransaction) this.instance).hasState();
        }

        public Builder setOrderId(String str) {
            copyOnWrite();
            ((SubscriptionTransaction) this.instance).setOrderId(str);
            return this;
        }

        public Builder setOrderIdBytes(ByteString byteString) {
            copyOnWrite();
            ((SubscriptionTransaction) this.instance).setOrderIdBytes(byteString);
            return this;
        }

        public Builder setProductId(String str) {
            copyOnWrite();
            ((SubscriptionTransaction) this.instance).setProductId(str);
            return this;
        }

        public Builder setProductIdBytes(ByteString byteString) {
            copyOnWrite();
            ((SubscriptionTransaction) this.instance).setProductIdBytes(byteString);
            return this;
        }

        public Builder setState(SubscriptionTransactionState subscriptionTransactionState) {
            copyOnWrite();
            ((SubscriptionTransaction) this.instance).setState(subscriptionTransactionState);
            return this;
        }

        private Builder() {
            super(SubscriptionTransaction.DEFAULT_INSTANCE);
        }
    }

    public enum SubscriptionTransactionState implements Internal.EnumLite {
        PENDING(0),
        PURCHASED(1),
        DEFERRED(2);

        public static final int DEFERRED_VALUE = 2;
        public static final int PENDING_VALUE = 0;
        public static final int PURCHASED_VALUE = 1;
        private static final Internal.EnumLiteMap<SubscriptionTransactionState> internalValueMap = new a();
        private final int value;

        class a implements Internal.EnumLiteMap {
            a() {
            }

            @Override // com.google.protobuf.Internal.EnumLiteMap
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SubscriptionTransactionState findValueByNumber(int i) {
                return SubscriptionTransactionState.forNumber(i);
            }
        }

        private static final class b implements Internal.EnumVerifier {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            static final Internal.EnumVerifier f740a = new b();

            private b() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return SubscriptionTransactionState.forNumber(i) != null;
            }
        }

        SubscriptionTransactionState(int i) {
            this.value = i;
        }

        public static SubscriptionTransactionState forNumber(int i) {
            if (i == 0) {
                return PENDING;
            }
            if (i == 1) {
                return PURCHASED;
            }
            if (i != 2) {
                return null;
            }
            return DEFERRED;
        }

        public static Internal.EnumLiteMap<SubscriptionTransactionState> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return b.f740a;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static SubscriptionTransactionState valueOf(int i) {
            return forNumber(i);
        }
    }

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f741a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f741a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f741a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f741a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f741a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f741a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f741a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f741a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    static {
        SubscriptionTransaction subscriptionTransaction = new SubscriptionTransaction();
        DEFAULT_INSTANCE = subscriptionTransaction;
        GeneratedMessageLite.registerDefaultInstance(SubscriptionTransaction.class, subscriptionTransaction);
    }

    private SubscriptionTransaction() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOrderId() {
        this.bitField0_ &= -2;
        this.orderId_ = getDefaultInstance().getOrderId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearProductId() {
        this.bitField0_ &= -3;
        this.productId_ = getDefaultInstance().getProductId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearState() {
        this.bitField0_ &= -5;
        this.state_ = 0;
    }

    public static SubscriptionTransaction getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static SubscriptionTransaction parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (SubscriptionTransaction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SubscriptionTransaction parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (SubscriptionTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<SubscriptionTransaction> parser() {
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
    public void setProductId(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.productId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProductIdBytes(ByteString byteString) {
        this.productId_ = byteString.toStringUtf8();
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setState(SubscriptionTransactionState subscriptionTransactionState) {
        this.state_ = subscriptionTransactionState.getNumber();
        this.bitField0_ |= 4;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        a aVar = null;
        switch (a.f741a[methodToInvoke.ordinal()]) {
            case 1:
                return new SubscriptionTransaction();
            case 2:
                return new Builder(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဌ\u0002", new Object[]{"bitField0_", "orderId_", "productId_", "state_", SubscriptionTransactionState.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<SubscriptionTransaction> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (SubscriptionTransaction.class) {
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

    @Override // com.nintendo.npf.sdk.internal.model.ISubscriptionTransaction, com.nintendo.npf.sdk.internal.bridge.protobuf.SubscriptionTransactionOrBuilder
    public String getOrderId() {
        return this.orderId_;
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.SubscriptionTransactionOrBuilder
    public ByteString getOrderIdBytes() {
        return ByteString.copyFromUtf8(this.orderId_);
    }

    @Override // com.nintendo.npf.sdk.internal.model.ISubscriptionTransaction, com.nintendo.npf.sdk.internal.bridge.protobuf.SubscriptionTransactionOrBuilder
    public String getProductId() {
        return this.productId_;
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.SubscriptionTransactionOrBuilder
    public ByteString getProductIdBytes() {
        return ByteString.copyFromUtf8(this.productId_);
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.SubscriptionTransactionOrBuilder
    public SubscriptionTransactionState getState() {
        SubscriptionTransactionState subscriptionTransactionStateForNumber = SubscriptionTransactionState.forNumber(this.state_);
        return subscriptionTransactionStateForNumber == null ? SubscriptionTransactionState.PENDING : subscriptionTransactionStateForNumber;
    }

    @Override // com.nintendo.npf.sdk.internal.model.ISubscriptionTransaction
    public String getStateString() {
        return getState().name();
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.SubscriptionTransactionOrBuilder
    public boolean hasOrderId() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.SubscriptionTransactionOrBuilder
    public boolean hasProductId() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.SubscriptionTransactionOrBuilder
    public boolean hasState() {
        return (this.bitField0_ & 4) != 0;
    }

    public static Builder newBuilder(SubscriptionTransaction subscriptionTransaction) {
        return DEFAULT_INSTANCE.createBuilder(subscriptionTransaction);
    }

    public static SubscriptionTransaction parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SubscriptionTransaction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SubscriptionTransaction parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (SubscriptionTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static SubscriptionTransaction parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (SubscriptionTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static SubscriptionTransaction parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (SubscriptionTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static SubscriptionTransaction parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (SubscriptionTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SubscriptionTransaction parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (SubscriptionTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static SubscriptionTransaction parseFrom(InputStream inputStream) throws IOException {
        return (SubscriptionTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SubscriptionTransaction parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SubscriptionTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SubscriptionTransaction parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (SubscriptionTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static SubscriptionTransaction parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SubscriptionTransaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
