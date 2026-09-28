package com.nintendo.npf.sdk.internal.bridge.protobuf;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface ProfanityWordListOrBuilder extends MessageLiteOrBuilder {
    ProfanityWord getProfanityWord(int i);

    int getProfanityWordCount();

    List<ProfanityWord> getProfanityWordList();
}
