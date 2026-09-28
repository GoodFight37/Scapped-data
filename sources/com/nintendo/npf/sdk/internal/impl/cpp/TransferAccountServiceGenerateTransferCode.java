package com.nintendo.npf.sdk.internal.impl.cpp;

import androidx.core.app.NotificationCompat;
import com.google.protobuf.InvalidProtocolBufferException;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.NPFSDK;
import com.nintendo.npf.sdk.internal.bridge.cpp.BridgeCore;
import com.nintendo.npf.sdk.internal.bridge.model.TransformKt;
import com.nintendo.npf.sdk.user.TransferAccountService;
import com.nintendo.npf.sdk.user.TransferCode;
import com.nintendo.npf.sdk.user.TransferIdentifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0013\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/nintendo/npf/sdk/internal/impl/cpp/TransferAccountServiceGenerateTransferCode;", "", "", "callbackId", "", "prop0", "Lcom/nintendo/npf/sdk/internal/bridge/cpp/BridgeCore;", "bridgeCore", "Lcom/nintendo/npf/sdk/user/TransferAccountService;", NotificationCompat.CATEGORY_SERVICE, "<init>", "(J[BLcom/nintendo/npf/sdk/internal/bridge/cpp/BridgeCore;Lcom/nintendo/npf/sdk/user/TransferAccountService;)V", "", "execute", "()V", "Lcom/nintendo/npf/sdk/user/TransferCode;", "arg0", "Lcom/nintendo/npf/sdk/NPFError;", "arg1", "onComplete", "(Lcom/nintendo/npf/sdk/user/TransferCode;Lcom/nintendo/npf/sdk/NPFError;)V", "a", "J", "b", "[B", "c", "Lcom/nintendo/npf/sdk/internal/bridge/cpp/BridgeCore;", "d", "Lcom/nintendo/npf/sdk/user/TransferAccountService;", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TransferAccountServiceGenerateTransferCode {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long callbackId;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final byte[] prop0;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final BridgeCore bridgeCore;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final TransferAccountService service;

    /* synthetic */ class a extends FunctionReferenceImpl implements Function2 {
        a(Object obj) {
            super(2, obj, TransferAccountServiceGenerateTransferCode.class, "onComplete", "onComplete(Lcom/nintendo/npf/sdk/user/TransferCode;Lcom/nintendo/npf/sdk/NPFError;)V", 0);
        }

        public final void a(TransferCode transferCode, NPFError nPFError) {
            ((TransferAccountServiceGenerateTransferCode) this.receiver).onComplete(transferCode, nPFError);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((TransferCode) obj, (NPFError) obj2);
            return Unit.INSTANCE;
        }
    }

    public TransferAccountServiceGenerateTransferCode(long j, byte[] bArr) {
        this(j, bArr, null, null, 12, null);
    }

    public final void execute() throws InvalidProtocolBufferException {
        TransferIdentifier npfObject;
        byte[] bArr = this.prop0;
        if (bArr != null) {
            com.nintendo.npf.sdk.internal.bridge.protobuf.TransferIdentifier from = com.nintendo.npf.sdk.internal.bridge.protobuf.TransferIdentifier.parseFrom(bArr);
            Intrinsics.checkNotNullExpressionValue(from, "parseFrom(it)");
            npfObject = TransformKt.toNpfObject(from);
        } else {
            npfObject = null;
        }
        TransferAccountService transferAccountService = this.service;
        if (npfObject == null) {
            throw new IllegalStateException("Required value was null.");
        }
        transferAccountService.generateTransferCode(npfObject, new a(this));
    }

    public final void onComplete(TransferCode arg0, NPFError arg1) {
        this.bridgeCore.a(this.callbackId, arg0 != null ? TransformKt.toProtoObject(arg0) : null, arg1 != null ? TransformKt.toProtoObject(arg1) : null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TransferAccountServiceGenerateTransferCode(long j, byte[] bArr, BridgeCore bridgeCore) {
        this(j, bArr, bridgeCore, null, 8, null);
        Intrinsics.checkNotNullParameter(bridgeCore, "bridgeCore");
    }

    public TransferAccountServiceGenerateTransferCode(long j, byte[] bArr, BridgeCore bridgeCore, TransferAccountService service) {
        Intrinsics.checkNotNullParameter(bridgeCore, "bridgeCore");
        Intrinsics.checkNotNullParameter(service, "service");
        this.callbackId = j;
        this.prop0 = bArr;
        this.bridgeCore = bridgeCore;
        this.service = service;
    }

    public /* synthetic */ TransferAccountServiceGenerateTransferCode(long j, byte[] bArr, BridgeCore bridgeCore, TransferAccountService transferAccountService, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, bArr, (i & 4) != 0 ? BridgeCore.f732a : bridgeCore, (i & 8) != 0 ? NPFSDK.getTransferAccountService() : transferAccountService);
    }
}
