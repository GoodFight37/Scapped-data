package com.nintendo.npf.sdk.internal.bridge.unity;

import com.google.protobuf.InvalidProtocolBufferException;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.audit.ProfanityWord;
import com.nintendo.npf.sdk.core.g4;
import com.nintendo.npf.sdk.internal.bridge.model.TransformKt;
import com.nintendo.npf.sdk.internal.bridge.protobuf.ProfanityWordList;
import com.nintendo.npf.sdk.internal.model.IProfanityWord;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0012\u001a\u00020\n2\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/nintendo/npf/sdk/internal/bridge/unity/ProtobufTestServiceMultiEcho;", "", "", "callbackId", "", "prop0", "Lcom/nintendo/npf/sdk/internal/bridge/unity/BridgeCore;", "bridgeCore", "<init>", "(Ljava/lang/String;[BLcom/nintendo/npf/sdk/internal/bridge/unity/BridgeCore;)V", "", "execute", "()V", "", "Lcom/nintendo/npf/sdk/audit/ProfanityWord;", "arg0", "Lcom/nintendo/npf/sdk/NPFError;", "arg1", "onComplete", "(Ljava/util/List;Lcom/nintendo/npf/sdk/NPFError;)V", "a", "Ljava/lang/String;", "b", "[B", "c", "Lcom/nintendo/npf/sdk/internal/bridge/unity/BridgeCore;", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ProtobufTestServiceMultiEcho {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String callbackId;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final byte[] prop0;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final BridgeCore bridgeCore;

    /* synthetic */ class a extends FunctionReferenceImpl implements Function2 {
        a(Object obj) {
            super(2, obj, ProtobufTestServiceMultiEcho.class, "onComplete", "onComplete(Ljava/util/List;Lcom/nintendo/npf/sdk/NPFError;)V", 0);
        }

        public final void a(List list, NPFError nPFError) throws IllegalAccessException, InvocationTargetException {
            ((ProtobufTestServiceMultiEcho) this.receiver).onComplete(list, nPFError);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
            a((List) obj, (NPFError) obj2);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProtobufTestServiceMultiEcho(String callbackId, byte[] bArr) {
        this(callbackId, bArr, null, 4, null);
        Intrinsics.checkNotNullParameter(callbackId, "callbackId");
    }

    public final void execute() throws InvalidProtocolBufferException {
        List<ProfanityWord> npfObject;
        byte[] bArr = this.prop0;
        if (bArr != null) {
            ProfanityWordList from = ProfanityWordList.parseFrom(bArr);
            Intrinsics.checkNotNullExpressionValue(from, "parseFrom(it)");
            npfObject = TransformKt.toNpfObject(from);
        } else {
            npfObject = null;
        }
        g4.f466a.a(npfObject, new a(this));
    }

    public final void onComplete(List<ProfanityWord> arg0, NPFError arg1) throws IllegalAccessException, InvocationTargetException {
        List listFilterNotNull;
        this.bridgeCore.executeCommand(this.callbackId, (arg0 == null || (listFilterNotNull = CollectionsKt.filterNotNull(arg0)) == null) ? null : TransformKt.toProtoObject((List<? extends IProfanityWord>) listFilterNotNull), arg1 != null ? TransformKt.toProtoObject(arg1) : null);
    }

    public ProtobufTestServiceMultiEcho(String callbackId, byte[] bArr, BridgeCore bridgeCore) {
        Intrinsics.checkNotNullParameter(callbackId, "callbackId");
        Intrinsics.checkNotNullParameter(bridgeCore, "bridgeCore");
        this.callbackId = callbackId;
        this.prop0 = bArr;
        this.bridgeCore = bridgeCore;
    }

    public /* synthetic */ ProtobufTestServiceMultiEcho(String str, byte[] bArr, BridgeCore bridgeCore, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, bArr, (i & 4) != 0 ? BridgeCore.INSTANCE : bridgeCore);
    }
}
