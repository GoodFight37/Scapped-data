package com.nintendo.npf.sdk.internal.bridge.unity;

import androidx.core.app.NotificationCompat;
import com.google.protobuf.InvalidProtocolBufferException;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.NPFSDK;
import com.nintendo.npf.sdk.audit.AuditService;
import com.nintendo.npf.sdk.audit.ProfanityWord;
import com.nintendo.npf.sdk.internal.bridge.model.TransformKt;
import com.nintendo.npf.sdk.internal.bridge.protobuf.ProfanityWordList;
import com.nintendo.npf.sdk.internal.model.IProfanityWord;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0014\u001a\u00020\f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/nintendo/npf/sdk/internal/bridge/unity/AuditServiceCheckProfanityWord;", "", "", "callbackId", "", "prop0", "Lcom/nintendo/npf/sdk/internal/bridge/unity/BridgeCore;", "bridgeCore", "Lcom/nintendo/npf/sdk/audit/AuditService;", NotificationCompat.CATEGORY_SERVICE, "<init>", "(Ljava/lang/String;[BLcom/nintendo/npf/sdk/internal/bridge/unity/BridgeCore;Lcom/nintendo/npf/sdk/audit/AuditService;)V", "", "execute", "()V", "", "Lcom/nintendo/npf/sdk/audit/ProfanityWord;", "arg0", "Lcom/nintendo/npf/sdk/NPFError;", "arg1", "onComplete", "(Ljava/util/List;Lcom/nintendo/npf/sdk/NPFError;)V", "a", "Ljava/lang/String;", "b", "[B", "c", "Lcom/nintendo/npf/sdk/internal/bridge/unity/BridgeCore;", "d", "Lcom/nintendo/npf/sdk/audit/AuditService;", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AuditServiceCheckProfanityWord {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String callbackId;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final byte[] prop0;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final BridgeCore bridgeCore;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final AuditService service;

    /* synthetic */ class a extends FunctionReferenceImpl implements Function2 {
        a(Object obj) {
            super(2, obj, AuditServiceCheckProfanityWord.class, "onComplete", "onComplete(Ljava/util/List;Lcom/nintendo/npf/sdk/NPFError;)V", 0);
        }

        public final void a(List list, NPFError nPFError) throws IllegalAccessException, InvocationTargetException {
            ((AuditServiceCheckProfanityWord) this.receiver).onComplete(list, nPFError);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
            a((List) obj, (NPFError) obj2);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AuditServiceCheckProfanityWord(String callbackId, byte[] bArr) {
        this(callbackId, bArr, null, null, 12, null);
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
        this.service.checkProfanityWord(npfObject, new a(this));
    }

    public final void onComplete(List<ProfanityWord> arg0, NPFError arg1) throws IllegalAccessException, InvocationTargetException {
        this.bridgeCore.executeCommand(this.callbackId, arg0 != null ? TransformKt.toProtoObject((List<? extends IProfanityWord>) arg0) : null, arg1 != null ? TransformKt.toProtoObject(arg1) : null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AuditServiceCheckProfanityWord(String callbackId, byte[] bArr, BridgeCore bridgeCore) {
        this(callbackId, bArr, bridgeCore, null, 8, null);
        Intrinsics.checkNotNullParameter(callbackId, "callbackId");
        Intrinsics.checkNotNullParameter(bridgeCore, "bridgeCore");
    }

    public AuditServiceCheckProfanityWord(String callbackId, byte[] bArr, BridgeCore bridgeCore, AuditService service) {
        Intrinsics.checkNotNullParameter(callbackId, "callbackId");
        Intrinsics.checkNotNullParameter(bridgeCore, "bridgeCore");
        Intrinsics.checkNotNullParameter(service, "service");
        this.callbackId = callbackId;
        this.prop0 = bArr;
        this.bridgeCore = bridgeCore;
        this.service = service;
    }

    public /* synthetic */ AuditServiceCheckProfanityWord(String str, byte[] bArr, BridgeCore bridgeCore, AuditService auditService, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, bArr, (i & 4) != 0 ? BridgeCore.INSTANCE : bridgeCore, (i & 8) != 0 ? NPFSDK.getAuditService() : auditService);
    }
}
