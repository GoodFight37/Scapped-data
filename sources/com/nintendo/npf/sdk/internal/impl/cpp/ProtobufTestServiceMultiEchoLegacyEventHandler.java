package com.nintendo.npf.sdk.internal.impl.cpp;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.audit.ProfanityWord;
import com.nintendo.npf.sdk.core.g4;
import com.nintendo.npf.sdk.internal.impl.NativeBridgeUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J4\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0083 ¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/nintendo/npf/sdk/internal/impl/cpp/ProtobufTestServiceMultiEchoLegacyEventHandler;", "", "<init>", "()V", "", "cppCallbackIdx", "jniCallbackIdx", "", "profanityWordListByteArray", "", "execute", "(JJ[B)V", "", "wordListJson", "", "Lcom/nintendo/npf/sdk/audit/ProfanityWord;", "a", "(Ljava/lang/String;)Ljava/util/List;", "dataJSONString", "errorJSONString", "onRetrieveCallback", "(JJLjava/lang/String;Ljava/lang/String;)V", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ProtobufTestServiceMultiEchoLegacyEventHandler {
    public static final ProtobufTestServiceMultiEchoLegacyEventHandler INSTANCE = new ProtobufTestServiceMultiEchoLegacyEventHandler();

    static final class a extends Lambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f863a;
        final /* synthetic */ long b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j, long j2) {
            super(2);
            this.f863a = j;
            this.b = j2;
        }

        public final void a(List list, NPFError nPFError) {
            Object nullableJsonFromProfanityWords;
            ProtobufTestServiceMultiEchoLegacyEventHandler.onRetrieveCallback(this.f863a, this.b, (list == null || (nullableJsonFromProfanityWords = NativeBridgeUtil.toNullableJsonFromProfanityWords(list)) == null) ? null : nullableJsonFromProfanityWords.toString(), nPFError != null ? NativeBridgeUtil.toNullableJsonFromNPFError(nPFError).toString() : null);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((List) obj, (NPFError) obj2);
            return Unit.INSTANCE;
        }
    }

    private ProtobufTestServiceMultiEchoLegacyEventHandler() {
    }

    private final List a(String wordListJson) throws JSONException {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray(wordListJson);
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            String string = jSONObject.getString("language");
            String string2 = jSONObject.getString("text");
            String string3 = jSONObject.getString("dictionaryType");
            String string4 = jSONObject.getString("checkStatus");
            arrayList.add(new ProfanityWord(string, string2, Intrinsics.areEqual(string3, "nickname") ? ProfanityWord.ProfanityDictionaryType.NICKNAME : ProfanityWord.ProfanityDictionaryType.COMMON, Intrinsics.areEqual(string4, "valid") ? ProfanityWord.ProfanityCheckStatus.VALID : Intrinsics.areEqual(string4, "invalid") ? ProfanityWord.ProfanityCheckStatus.INVALID : ProfanityWord.ProfanityCheckStatus.UNCHECKED));
        }
        return arrayList;
    }

    @JvmStatic
    public static final void execute(long cppCallbackIdx, long jniCallbackIdx, byte[] profanityWordListByteArray) {
        g4.f466a.a(INSTANCE.a(profanityWordListByteArray != null ? new String(profanityWordListByteArray, Charsets.UTF_8) : null), new a(cppCallbackIdx, jniCallbackIdx));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void onRetrieveCallback(long cppCallbackIdx, long jniCallbackIdx, String dataJSONString, String errorJSONString);
}
