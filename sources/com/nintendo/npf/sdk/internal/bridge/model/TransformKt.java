package com.nintendo.npf.sdk.internal.bridge.model;

import com.google.protobuf.GeneratedMessageLite;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.audit.ProfanityWord;
import com.nintendo.npf.sdk.core.f2;
import com.nintendo.npf.sdk.core.g2;
import com.nintendo.npf.sdk.core.h2;
import com.nintendo.npf.sdk.core.i2;
import com.nintendo.npf.sdk.internal.bridge.protobuf.ProfanityWordList;
import com.nintendo.npf.sdk.internal.bridge.protobuf.SubscriptionTransactionList;
import com.nintendo.npf.sdk.internal.bridge.protobuf.VirtualCurrencyTransactionList;
import com.nintendo.npf.sdk.internal.model.INPFError;
import com.nintendo.npf.sdk.internal.model.IProfanityWord;
import com.nintendo.npf.sdk.internal.model.ISubscriptionTransaction;
import com.nintendo.npf.sdk.subscription.SubscriptionTransaction;
import com.nintendo.npf.sdk.subscription.SubscriptionTransactionState;
import com.nintendo.npf.sdk.user.TransferCode;
import com.nintendo.npf.sdk.user.TransferIdentifier;
import com.nintendo.npf.sdk.user.TransferSwitchResult;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyTransaction;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyTransactionState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a\u001b\u0010\u0003\u001a\u00020\u000b2\f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u0003\u0010\f\u001a\u0015\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\n¢\u0006\u0004\b\u0003\u0010\u000e\u001a\u001b\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000f0\t2\u0006\u0010\u0005\u001a\u00020\u000b¢\u0006\u0004\b\u0007\u0010\u0010\u001a\u0015\u0010\u0007\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\r¢\u0006\u0004\b\u0007\u0010\u0011\u001a\u001b\u0010\u0003\u001a\u00020\u00132\f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00120\t¢\u0006\u0004\b\u0003\u0010\u0014\u001a\u0015\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0001\u001a\u00020\u0012¢\u0006\u0004\b\u0003\u0010\u0016\u001a\u001b\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00170\t2\u0006\u0010\u0005\u001a\u00020\u0013¢\u0006\u0004\b\u0007\u0010\u0018\u001a\u0015\u0010\u0007\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u0015¢\u0006\u0004\b\u0007\u0010\u0019\u001a\u001b\u0010\u0003\u001a\u00020\u001b2\f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u001a0\t¢\u0006\u0004\b\u0003\u0010\u001c\u001a\u0015\u0010\u0003\u001a\u00020\u001d2\u0006\u0010\u0001\u001a\u00020\u001a¢\u0006\u0004\b\u0003\u0010\u001e\u001a\u001b\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u001f0\t2\u0006\u0010\u0005\u001a\u00020\u001b¢\u0006\u0004\b\u0007\u0010 \u001a\u0015\u0010\u0007\u001a\u00020\u001f2\u0006\u0010\u0005\u001a\u00020\u001d¢\u0006\u0004\b\u0007\u0010!\u001a\u0015\u0010\u0003\u001a\u00020#2\u0006\u0010\u0001\u001a\u00020\"¢\u0006\u0004\b\u0003\u0010$\u001a\u0015\u0010\u0007\u001a\u00020%2\u0006\u0010\u0005\u001a\u00020#¢\u0006\u0004\b\u0007\u0010&\u001a\u0015\u0010\u0003\u001a\u00020(2\u0006\u0010\u0001\u001a\u00020'¢\u0006\u0004\b\u0003\u0010)\u001a\u0015\u0010\u0007\u001a\u00020*2\u0006\u0010\u0005\u001a\u00020(¢\u0006\u0004\b\u0007\u0010+\u001a\u0015\u0010\u0003\u001a\u00020-2\u0006\u0010\u0001\u001a\u00020,¢\u0006\u0004\b\u0003\u0010.\u001a\u0015\u0010\u0007\u001a\u00020/2\u0006\u0010\u0005\u001a\u00020-¢\u0006\u0004\b\u0007\u00100¨\u00061"}, d2 = {"Lcom/nintendo/npf/sdk/internal/model/INPFError;", "npfObject", "Lcom/nintendo/npf/sdk/internal/bridge/protobuf/NPFError;", "toProtoObject", "(Lcom/nintendo/npf/sdk/internal/model/INPFError;)Lcom/nintendo/npf/sdk/internal/bridge/protobuf/NPFError;", "protoObject", "Lcom/nintendo/npf/sdk/NPFError;", "toNpfObject", "(Lcom/nintendo/npf/sdk/internal/bridge/protobuf/NPFError;)Lcom/nintendo/npf/sdk/NPFError;", "", "Lcom/nintendo/npf/sdk/internal/model/ISubscriptionTransaction;", "Lcom/nintendo/npf/sdk/internal/bridge/protobuf/SubscriptionTransactionList;", "(Ljava/util/List;)Lcom/nintendo/npf/sdk/internal/bridge/protobuf/SubscriptionTransactionList;", "Lcom/nintendo/npf/sdk/internal/bridge/protobuf/SubscriptionTransaction;", "(Lcom/nintendo/npf/sdk/internal/model/ISubscriptionTransaction;)Lcom/nintendo/npf/sdk/internal/bridge/protobuf/SubscriptionTransaction;", "Lcom/nintendo/npf/sdk/subscription/SubscriptionTransaction;", "(Lcom/nintendo/npf/sdk/internal/bridge/protobuf/SubscriptionTransactionList;)Ljava/util/List;", "(Lcom/nintendo/npf/sdk/internal/bridge/protobuf/SubscriptionTransaction;)Lcom/nintendo/npf/sdk/subscription/SubscriptionTransaction;", "Lcom/nintendo/npf/sdk/core/i2;", "Lcom/nintendo/npf/sdk/internal/bridge/protobuf/VirtualCurrencyTransactionList;", "(Ljava/util/List;)Lcom/nintendo/npf/sdk/internal/bridge/protobuf/VirtualCurrencyTransactionList;", "Lcom/nintendo/npf/sdk/internal/bridge/protobuf/VirtualCurrencyTransaction;", "(Lcom/nintendo/npf/sdk/core/i2;)Lcom/nintendo/npf/sdk/internal/bridge/protobuf/VirtualCurrencyTransaction;", "Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyTransaction;", "(Lcom/nintendo/npf/sdk/internal/bridge/protobuf/VirtualCurrencyTransactionList;)Ljava/util/List;", "(Lcom/nintendo/npf/sdk/internal/bridge/protobuf/VirtualCurrencyTransaction;)Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyTransaction;", "Lcom/nintendo/npf/sdk/internal/model/IProfanityWord;", "Lcom/nintendo/npf/sdk/internal/bridge/protobuf/ProfanityWordList;", "(Ljava/util/List;)Lcom/nintendo/npf/sdk/internal/bridge/protobuf/ProfanityWordList;", "Lcom/nintendo/npf/sdk/internal/bridge/protobuf/ProfanityWord;", "(Lcom/nintendo/npf/sdk/internal/model/IProfanityWord;)Lcom/nintendo/npf/sdk/internal/bridge/protobuf/ProfanityWord;", "Lcom/nintendo/npf/sdk/audit/ProfanityWord;", "(Lcom/nintendo/npf/sdk/internal/bridge/protobuf/ProfanityWordList;)Ljava/util/List;", "(Lcom/nintendo/npf/sdk/internal/bridge/protobuf/ProfanityWord;)Lcom/nintendo/npf/sdk/audit/ProfanityWord;", "Lcom/nintendo/npf/sdk/core/g2;", "Lcom/nintendo/npf/sdk/internal/bridge/protobuf/TransferIdentifier;", "(Lcom/nintendo/npf/sdk/core/g2;)Lcom/nintendo/npf/sdk/internal/bridge/protobuf/TransferIdentifier;", "Lcom/nintendo/npf/sdk/user/TransferIdentifier;", "(Lcom/nintendo/npf/sdk/internal/bridge/protobuf/TransferIdentifier;)Lcom/nintendo/npf/sdk/user/TransferIdentifier;", "Lcom/nintendo/npf/sdk/core/f2;", "Lcom/nintendo/npf/sdk/internal/bridge/protobuf/TransferCode;", "(Lcom/nintendo/npf/sdk/core/f2;)Lcom/nintendo/npf/sdk/internal/bridge/protobuf/TransferCode;", "Lcom/nintendo/npf/sdk/user/TransferCode;", "(Lcom/nintendo/npf/sdk/internal/bridge/protobuf/TransferCode;)Lcom/nintendo/npf/sdk/user/TransferCode;", "Lcom/nintendo/npf/sdk/core/h2;", "Lcom/nintendo/npf/sdk/internal/bridge/protobuf/TransferSwitchResult;", "(Lcom/nintendo/npf/sdk/core/h2;)Lcom/nintendo/npf/sdk/internal/bridge/protobuf/TransferSwitchResult;", "Lcom/nintendo/npf/sdk/user/TransferSwitchResult;", "(Lcom/nintendo/npf/sdk/internal/bridge/protobuf/TransferSwitchResult;)Lcom/nintendo/npf/sdk/user/TransferSwitchResult;", "NPFSDK_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TransformKt {
    public static final NPFError toNpfObject(com.nintendo.npf.sdk.internal.bridge.protobuf.NPFError protoObject) {
        Intrinsics.checkNotNullParameter(protoObject, "protoObject");
        String errorTypeString = protoObject.getErrorTypeString();
        Intrinsics.checkNotNullExpressionValue(errorTypeString, "errorTypeString");
        NPFError.ErrorType errorTypeValueOf = NPFError.ErrorType.valueOf(errorTypeString);
        int errorCode = protoObject.getErrorCode();
        String errorMessage = protoObject.hasErrorMessage() ? protoObject.getErrorMessage() : null;
        String originalErrorTypeString = protoObject.getOriginalErrorTypeString();
        Intrinsics.checkNotNullExpressionValue(originalErrorTypeString, "originalErrorTypeString");
        NPFError.OriginalErrorType originalErrorTypeValueOf = NPFError.OriginalErrorType.valueOf(originalErrorTypeString);
        String originalErrorMessage = protoObject.getOriginalErrorMessage();
        Intrinsics.checkNotNullExpressionValue(originalErrorMessage, "originalErrorMessage");
        return new NPFError(errorTypeValueOf, errorCode, errorMessage, originalErrorTypeValueOf, originalErrorMessage);
    }

    public static final com.nintendo.npf.sdk.internal.bridge.protobuf.NPFError toProtoObject(INPFError npfObject) {
        Intrinsics.checkNotNullParameter(npfObject, "npfObject");
        com.nintendo.npf.sdk.internal.bridge.protobuf.NPFError.Builder builderNewBuilder = com.nintendo.npf.sdk.internal.bridge.protobuf.NPFError.newBuilder();
        builderNewBuilder.setErrorType(com.nintendo.npf.sdk.internal.bridge.protobuf.NPFError.ErrorType.valueOf(npfObject.getErrorTypeString()));
        builderNewBuilder.setErrorCode(npfObject.getErrorCode());
        String errorMessage = npfObject.getErrorMessage();
        if (errorMessage != null) {
            builderNewBuilder.setErrorMessage(errorMessage);
        }
        builderNewBuilder.setOriginalErrorType(com.nintendo.npf.sdk.internal.bridge.protobuf.NPFError.OriginalErrorType.valueOf(npfObject.getOriginalErrorTypeString()));
        builderNewBuilder.setOriginalErrorMessage(npfObject.getOriginalErrorMessage());
        com.nintendo.npf.sdk.internal.bridge.protobuf.NPFError nPFErrorBuild = builderNewBuilder.build();
        Intrinsics.checkNotNullExpressionValue(nPFErrorBuild, "builder.build()");
        return nPFErrorBuild;
    }

    public static final List<SubscriptionTransaction> toNpfObject(SubscriptionTransactionList protoObject) {
        Intrinsics.checkNotNullParameter(protoObject, "protoObject");
        List<com.nintendo.npf.sdk.internal.bridge.protobuf.SubscriptionTransaction> subscriptionTransactionList = protoObject.getSubscriptionTransactionList();
        Intrinsics.checkNotNullExpressionValue(subscriptionTransactionList, "protoObject.subscriptionTransactionList");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(subscriptionTransactionList, 10));
        for (com.nintendo.npf.sdk.internal.bridge.protobuf.SubscriptionTransaction it : subscriptionTransactionList) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(toNpfObject(it));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: toProtoObject, reason: collision with other method in class */
    public static final SubscriptionTransactionList m166toProtoObject(List<? extends ISubscriptionTransaction> npfObject) {
        Intrinsics.checkNotNullParameter(npfObject, "npfObject");
        SubscriptionTransactionList.Builder builderNewBuilder = SubscriptionTransactionList.newBuilder();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(npfObject, 10));
        Iterator<T> it = npfObject.iterator();
        while (it.hasNext()) {
            arrayList.add(toProtoObject((ISubscriptionTransaction) it.next()));
        }
        builderNewBuilder.addAllSubscriptionTransaction(arrayList);
        GeneratedMessageLite generatedMessageLiteBuild = builderNewBuilder.build();
        Intrinsics.checkNotNullExpressionValue(generatedMessageLiteBuild, "builder.build()");
        return (SubscriptionTransactionList) generatedMessageLiteBuild;
    }

    public static final SubscriptionTransaction toNpfObject(com.nintendo.npf.sdk.internal.bridge.protobuf.SubscriptionTransaction protoObject) {
        Intrinsics.checkNotNullParameter(protoObject, "protoObject");
        String orderId = protoObject.hasOrderId() ? protoObject.getOrderId() : null;
        String productId = protoObject.getProductId();
        Intrinsics.checkNotNullExpressionValue(productId, "productId");
        String stateString = protoObject.getStateString();
        Intrinsics.checkNotNullExpressionValue(stateString, "stateString");
        return new SubscriptionTransaction(orderId, productId, SubscriptionTransactionState.valueOf(stateString));
    }

    public static final List<VirtualCurrencyTransaction> toNpfObject(VirtualCurrencyTransactionList protoObject) {
        Intrinsics.checkNotNullParameter(protoObject, "protoObject");
        List<com.nintendo.npf.sdk.internal.bridge.protobuf.VirtualCurrencyTransaction> virtualCurrencyTransactionList = protoObject.getVirtualCurrencyTransactionList();
        Intrinsics.checkNotNullExpressionValue(virtualCurrencyTransactionList, "protoObject.virtualCurrencyTransactionList");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(virtualCurrencyTransactionList, 10));
        for (com.nintendo.npf.sdk.internal.bridge.protobuf.VirtualCurrencyTransaction it : virtualCurrencyTransactionList) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(toNpfObject(it));
        }
        return arrayList;
    }

    public static final com.nintendo.npf.sdk.internal.bridge.protobuf.SubscriptionTransaction toProtoObject(ISubscriptionTransaction npfObject) {
        Intrinsics.checkNotNullParameter(npfObject, "npfObject");
        com.nintendo.npf.sdk.internal.bridge.protobuf.SubscriptionTransaction.Builder builderNewBuilder = com.nintendo.npf.sdk.internal.bridge.protobuf.SubscriptionTransaction.newBuilder();
        String orderId = npfObject.getOrderId();
        if (orderId != null) {
            builderNewBuilder.setOrderId(orderId);
        }
        builderNewBuilder.setProductId(npfObject.getProductId());
        builderNewBuilder.setState(com.nintendo.npf.sdk.internal.bridge.protobuf.SubscriptionTransaction.SubscriptionTransactionState.valueOf(npfObject.getStateString()));
        com.nintendo.npf.sdk.internal.bridge.protobuf.SubscriptionTransaction subscriptionTransactionBuild = builderNewBuilder.build();
        Intrinsics.checkNotNullExpressionValue(subscriptionTransactionBuild, "builder.build()");
        return subscriptionTransactionBuild;
    }

    /* JADX INFO: renamed from: toProtoObject, reason: collision with other method in class */
    public static final VirtualCurrencyTransactionList m167toProtoObject(List<? extends i2> npfObject) {
        Intrinsics.checkNotNullParameter(npfObject, "npfObject");
        VirtualCurrencyTransactionList.Builder builderNewBuilder = VirtualCurrencyTransactionList.newBuilder();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(npfObject, 10));
        Iterator<T> it = npfObject.iterator();
        while (it.hasNext()) {
            arrayList.add(toProtoObject((i2) it.next()));
        }
        builderNewBuilder.addAllVirtualCurrencyTransaction(arrayList);
        GeneratedMessageLite generatedMessageLiteBuild = builderNewBuilder.build();
        Intrinsics.checkNotNullExpressionValue(generatedMessageLiteBuild, "builder.build()");
        return (VirtualCurrencyTransactionList) generatedMessageLiteBuild;
    }

    public static final VirtualCurrencyTransaction toNpfObject(com.nintendo.npf.sdk.internal.bridge.protobuf.VirtualCurrencyTransaction protoObject) {
        Intrinsics.checkNotNullParameter(protoObject, "protoObject");
        String orderId = protoObject.hasOrderId() ? protoObject.getOrderId() : null;
        String sku = protoObject.getSku();
        Intrinsics.checkNotNullExpressionValue(sku, "sku");
        String stateString = protoObject.getStateString();
        Intrinsics.checkNotNullExpressionValue(stateString, "stateString");
        return new VirtualCurrencyTransaction(orderId, sku, VirtualCurrencyTransactionState.valueOf(stateString));
    }

    public static final List<ProfanityWord> toNpfObject(ProfanityWordList protoObject) {
        Intrinsics.checkNotNullParameter(protoObject, "protoObject");
        List<com.nintendo.npf.sdk.internal.bridge.protobuf.ProfanityWord> profanityWordList = protoObject.getProfanityWordList();
        Intrinsics.checkNotNullExpressionValue(profanityWordList, "protoObject.profanityWordList");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(profanityWordList, 10));
        for (com.nintendo.npf.sdk.internal.bridge.protobuf.ProfanityWord it : profanityWordList) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(toNpfObject(it));
        }
        return arrayList;
    }

    public static final com.nintendo.npf.sdk.internal.bridge.protobuf.VirtualCurrencyTransaction toProtoObject(i2 npfObject) {
        Intrinsics.checkNotNullParameter(npfObject, "npfObject");
        com.nintendo.npf.sdk.internal.bridge.protobuf.VirtualCurrencyTransaction.Builder builderNewBuilder = com.nintendo.npf.sdk.internal.bridge.protobuf.VirtualCurrencyTransaction.newBuilder();
        String orderId = npfObject.getOrderId();
        if (orderId != null) {
            builderNewBuilder.setOrderId(orderId);
        }
        builderNewBuilder.setSku(npfObject.getSku());
        builderNewBuilder.setState(com.nintendo.npf.sdk.internal.bridge.protobuf.VirtualCurrencyTransaction.VirtualCurrencyTransactionState.valueOf(npfObject.getStateString()));
        com.nintendo.npf.sdk.internal.bridge.protobuf.VirtualCurrencyTransaction virtualCurrencyTransactionBuild = builderNewBuilder.build();
        Intrinsics.checkNotNullExpressionValue(virtualCurrencyTransactionBuild, "builder.build()");
        return virtualCurrencyTransactionBuild;
    }

    public static final ProfanityWordList toProtoObject(List<? extends IProfanityWord> npfObject) {
        Intrinsics.checkNotNullParameter(npfObject, "npfObject");
        ProfanityWordList.Builder builderNewBuilder = ProfanityWordList.newBuilder();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(npfObject, 10));
        Iterator<T> it = npfObject.iterator();
        while (it.hasNext()) {
            arrayList.add(toProtoObject((IProfanityWord) it.next()));
        }
        builderNewBuilder.addAllProfanityWord(arrayList);
        GeneratedMessageLite generatedMessageLiteBuild = builderNewBuilder.build();
        Intrinsics.checkNotNullExpressionValue(generatedMessageLiteBuild, "builder.build()");
        return (ProfanityWordList) generatedMessageLiteBuild;
    }

    public static final ProfanityWord toNpfObject(com.nintendo.npf.sdk.internal.bridge.protobuf.ProfanityWord protoObject) {
        Intrinsics.checkNotNullParameter(protoObject, "protoObject");
        String language = protoObject.hasLanguage() ? protoObject.getLanguage() : null;
        String text = protoObject.hasText() ? protoObject.getText() : null;
        String dictionaryTypeString = protoObject.getDictionaryTypeString();
        Intrinsics.checkNotNullExpressionValue(dictionaryTypeString, "dictionaryTypeString");
        ProfanityWord.ProfanityDictionaryType profanityDictionaryTypeValueOf = ProfanityWord.ProfanityDictionaryType.valueOf(dictionaryTypeString);
        String checkStatusString = protoObject.getCheckStatusString();
        Intrinsics.checkNotNullExpressionValue(checkStatusString, "checkStatusString");
        return new ProfanityWord(language, text, profanityDictionaryTypeValueOf, ProfanityWord.ProfanityCheckStatus.valueOf(checkStatusString));
    }

    public static final TransferIdentifier toNpfObject(com.nintendo.npf.sdk.internal.bridge.protobuf.TransferIdentifier protoObject) {
        Intrinsics.checkNotNullParameter(protoObject, "protoObject");
        String value = protoObject.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "value");
        return new TransferIdentifier(value);
    }

    public static final TransferCode toNpfObject(com.nintendo.npf.sdk.internal.bridge.protobuf.TransferCode protoObject) {
        Intrinsics.checkNotNullParameter(protoObject, "protoObject");
        String identifier = protoObject.getIdentifier();
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier");
        String code = protoObject.getCode();
        Intrinsics.checkNotNullExpressionValue(code, "code");
        return new TransferCode(identifier, code);
    }

    public static final TransferSwitchResult toNpfObject(com.nintendo.npf.sdk.internal.bridge.protobuf.TransferSwitchResult protoObject) {
        Intrinsics.checkNotNullParameter(protoObject, "protoObject");
        String oldUserId = protoObject.getOldUserId();
        Intrinsics.checkNotNullExpressionValue(oldUserId, "oldUserId");
        String newUserId = protoObject.getNewUserId();
        Intrinsics.checkNotNullExpressionValue(newUserId, "newUserId");
        String usedTransferId = protoObject.getUsedTransferId();
        Intrinsics.checkNotNullExpressionValue(usedTransferId, "usedTransferId");
        String usedTransferCode = protoObject.getUsedTransferCode();
        Intrinsics.checkNotNullExpressionValue(usedTransferCode, "usedTransferCode");
        return new TransferSwitchResult(oldUserId, newUserId, usedTransferId, usedTransferCode);
    }

    public static final com.nintendo.npf.sdk.internal.bridge.protobuf.ProfanityWord toProtoObject(IProfanityWord npfObject) {
        Intrinsics.checkNotNullParameter(npfObject, "npfObject");
        com.nintendo.npf.sdk.internal.bridge.protobuf.ProfanityWord.Builder builderNewBuilder = com.nintendo.npf.sdk.internal.bridge.protobuf.ProfanityWord.newBuilder();
        String language = npfObject.getLanguage();
        if (language != null) {
            builderNewBuilder.setLanguage(language);
        }
        String text = npfObject.getText();
        if (text != null) {
            builderNewBuilder.setText(text);
        }
        builderNewBuilder.setDictionaryType(com.nintendo.npf.sdk.internal.bridge.protobuf.ProfanityWord.ProfanityDictionaryType.valueOf(npfObject.getDictionaryTypeString()));
        builderNewBuilder.setCheckStatus(com.nintendo.npf.sdk.internal.bridge.protobuf.ProfanityWord.ProfanityCheckStatus.valueOf(npfObject.getCheckStatusString()));
        com.nintendo.npf.sdk.internal.bridge.protobuf.ProfanityWord profanityWordBuild = builderNewBuilder.build();
        Intrinsics.checkNotNullExpressionValue(profanityWordBuild, "builder.build()");
        return profanityWordBuild;
    }

    public static final com.nintendo.npf.sdk.internal.bridge.protobuf.TransferIdentifier toProtoObject(g2 npfObject) {
        Intrinsics.checkNotNullParameter(npfObject, "npfObject");
        com.nintendo.npf.sdk.internal.bridge.protobuf.TransferIdentifier.Builder builderNewBuilder = com.nintendo.npf.sdk.internal.bridge.protobuf.TransferIdentifier.newBuilder();
        builderNewBuilder.setValue(npfObject.getValue());
        com.nintendo.npf.sdk.internal.bridge.protobuf.TransferIdentifier transferIdentifierBuild = builderNewBuilder.build();
        Intrinsics.checkNotNullExpressionValue(transferIdentifierBuild, "builder.build()");
        return transferIdentifierBuild;
    }

    public static final com.nintendo.npf.sdk.internal.bridge.protobuf.TransferCode toProtoObject(f2 npfObject) {
        Intrinsics.checkNotNullParameter(npfObject, "npfObject");
        com.nintendo.npf.sdk.internal.bridge.protobuf.TransferCode.Builder builderNewBuilder = com.nintendo.npf.sdk.internal.bridge.protobuf.TransferCode.newBuilder();
        builderNewBuilder.setIdentifier(npfObject.getIdentifier());
        builderNewBuilder.setCode(npfObject.getCode());
        com.nintendo.npf.sdk.internal.bridge.protobuf.TransferCode transferCodeBuild = builderNewBuilder.build();
        Intrinsics.checkNotNullExpressionValue(transferCodeBuild, "builder.build()");
        return transferCodeBuild;
    }

    public static final com.nintendo.npf.sdk.internal.bridge.protobuf.TransferSwitchResult toProtoObject(h2 npfObject) {
        Intrinsics.checkNotNullParameter(npfObject, "npfObject");
        com.nintendo.npf.sdk.internal.bridge.protobuf.TransferSwitchResult.Builder builderNewBuilder = com.nintendo.npf.sdk.internal.bridge.protobuf.TransferSwitchResult.newBuilder();
        builderNewBuilder.setOldUserId(npfObject.getOldUserId());
        builderNewBuilder.setNewUserId(npfObject.getNewUserId());
        builderNewBuilder.setUsedTransferId(npfObject.getUsedTransferId());
        builderNewBuilder.setUsedTransferCode(npfObject.getUsedTransferCode());
        com.nintendo.npf.sdk.internal.bridge.protobuf.TransferSwitchResult transferSwitchResultBuild = builderNewBuilder.build();
        Intrinsics.checkNotNullExpressionValue(transferSwitchResultBuild, "builder.build()");
        return transferSwitchResultBuild;
    }
}
