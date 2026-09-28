package com.nintendo.npf.sdk.internal.bridge.unity;

import com.google.protobuf.InvalidProtocolBufferException;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.audit.ProfanityWord;
import com.nintendo.npf.sdk.core.g4;
import com.nintendo.npf.sdk.internal.bridge.model.TransformKt;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0011\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/nintendo/npf/sdk/internal/bridge/unity/ProtobufTestServiceEcho;", "", "", "callbackId", "", "prop0", "Lcom/nintendo/npf/sdk/internal/bridge/unity/BridgeCore;", "bridgeCore", "<init>", "(Ljava/lang/String;[BLcom/nintendo/npf/sdk/internal/bridge/unity/BridgeCore;)V", "", "execute", "()V", "Lcom/nintendo/npf/sdk/audit/ProfanityWord;", "arg0", "Lcom/nintendo/npf/sdk/NPFError;", "arg1", "onComplete", "(Lcom/nintendo/npf/sdk/audit/ProfanityWord;Lcom/nintendo/npf/sdk/NPFError;)V", "a", "Ljava/lang/String;", "b", "[B", "c", "Lcom/nintendo/npf/sdk/internal/bridge/unity/BridgeCore;", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ProtobufTestServiceEcho {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String callbackId;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final byte[] prop0;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final BridgeCore bridgeCore;

    /* synthetic */ class a extends FunctionReferenceImpl implements Function2 {
        a(Object obj) {
            super(2, obj, ProtobufTestServiceEcho.class, "onComplete", "onComplete(Lcom/nintendo/npf/sdk/audit/ProfanityWord;Lcom/nintendo/npf/sdk/NPFError;)V", 0);
        }

        public final void a(ProfanityWord profanityWord, NPFError nPFError) throws IllegalAccessException, InvocationTargetException {
            ((ProtobufTestServiceEcho) this.receiver).onComplete(profanityWord, nPFError);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
            a((ProfanityWord) obj, (NPFError) obj2);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProtobufTestServiceEcho(String callbackId, byte[] bArr) {
        this(callbackId, bArr, null, 4, null);
        Intrinsics.checkNotNullParameter(callbackId, "callbackId");
    }

    public final void execute() throws InvalidProtocolBufferException {
        ProfanityWord npfObject;
        byte[] bArr = this.prop0;
        if (bArr != null) {
            com.nintendo.npf.sdk.internal.bridge.protobuf.ProfanityWord from = com.nintendo.npf.sdk.internal.bridge.protobuf.ProfanityWord.parseFrom(bArr);
            Intrinsics.checkNotNullExpressionValue(from, "parseFrom(it)");
            npfObject = TransformKt.toNpfObject(from);
        } else {
            npfObject = null;
        }
        g4.f466a.a(npfObject, new a(this));
    }

    public final void onComplete(ProfanityWord arg0, NPFError arg1) throws IllegalAccessException, InvocationTargetException {
        this.bridgeCore.executeCommand(this.callbackId, arg0 != null ? TransformKt.toProtoObject(arg0) : null, arg1 != null ? TransformKt.toProtoObject(arg1) : null);
    }

    public ProtobufTestServiceEcho(String callbackId, byte[] bArr, BridgeCore bridgeCore) {
        Intrinsics.checkNotNullParameter(callbackId, "callbackId");
        Intrinsics.checkNotNullParameter(bridgeCore, "bridgeCore");
        this.callbackId = callbackId;
        this.prop0 = bArr;
        this.bridgeCore = bridgeCore;
    }

    public /* synthetic */ ProtobufTestServiceEcho(String str, byte[] bArr, BridgeCore bridgeCore, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, bArr, (i & 4) != 0 ? BridgeCore.INSTANCE : bridgeCore);
    }
}
