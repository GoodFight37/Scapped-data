package io.opencensus.metrics;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import io.opencensus.internal.Utils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DoubleCumulative {

    public static abstract class DoublePoint {
        public abstract void add(double d);
    }

    public abstract void clear();

    public abstract DoublePoint getDefaultTimeSeries();

    public abstract DoublePoint getOrCreateTimeSeries(List<LabelValue> list);

    public abstract void removeTimeSeries(List<LabelValue> list);

    static DoubleCumulative newNoopDoubleCumulative(String str, String str2, String str3, List<LabelKey> list) {
        return NoopDoubleCumulative.create(str, str2, str3, list);
    }

    private static final class NoopDoubleCumulative extends DoubleCumulative {
        private final int labelKeysSize;

        @Override // io.opencensus.metrics.DoubleCumulative
        public void clear() {
        }

        @Override // io.opencensus.metrics.DoubleCumulative
        public /* bridge */ /* synthetic */ DoublePoint getOrCreateTimeSeries(List list) {
            return getOrCreateTimeSeries((List<LabelValue>) list);
        }

        static NoopDoubleCumulative create(String str, String str2, String str3, List<LabelKey> list) {
            return new NoopDoubleCumulative(str, str2, str3, list);
        }

        NoopDoubleCumulative(String str, String str2, String str3, List<LabelKey> list) {
            Utils.checkNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
            Utils.checkNotNull(str2, MapperConstants.SUBSCRIPTION_FIELD_DESCRIPTION);
            Utils.checkNotNull(str3, "unit");
            Utils.checkListElementNotNull((List) Utils.checkNotNull(list, "labelKeys"), "labelKey");
            this.labelKeysSize = list.size();
        }

        @Override // io.opencensus.metrics.DoubleCumulative
        public NoopDoublePoint getOrCreateTimeSeries(List<LabelValue> list) {
            Utils.checkListElementNotNull((List) Utils.checkNotNull(list, "labelValues"), "labelValue");
            Utils.checkArgument(this.labelKeysSize == list.size(), "Label Keys and Label Values don't have same size.");
            return NoopDoublePoint.INSTANCE;
        }

        @Override // io.opencensus.metrics.DoubleCumulative
        public NoopDoublePoint getDefaultTimeSeries() {
            return NoopDoublePoint.INSTANCE;
        }

        @Override // io.opencensus.metrics.DoubleCumulative
        public void removeTimeSeries(List<LabelValue> list) {
            Utils.checkNotNull(list, "labelValues");
        }

        private static final class NoopDoublePoint extends DoublePoint {
            private static final NoopDoublePoint INSTANCE = new NoopDoublePoint();

            @Override // io.opencensus.metrics.DoubleCumulative.DoublePoint
            public void add(double d) {
            }

            private NoopDoublePoint() {
            }
        }
    }
}
