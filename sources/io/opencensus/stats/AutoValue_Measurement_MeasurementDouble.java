package io.opencensus.stats;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_Measurement_MeasurementDouble extends Measurement.MeasurementDouble {
    private final Measure.MeasureDouble measure;
    private final double value;

    AutoValue_Measurement_MeasurementDouble(Measure.MeasureDouble measureDouble, double d) {
        if (measureDouble == null) {
            throw new NullPointerException("Null measure");
        }
        this.measure = measureDouble;
        this.value = d;
    }

    @Override // io.opencensus.stats.Measurement.MeasurementDouble, io.opencensus.stats.Measurement
    public Measure.MeasureDouble getMeasure() {
        return this.measure;
    }

    @Override // io.opencensus.stats.Measurement.MeasurementDouble
    public double getValue() {
        return this.value;
    }

    public String toString() {
        return "MeasurementDouble{measure=" + this.measure + ", value=" + this.value + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Measurement.MeasurementDouble)) {
            return false;
        }
        Measurement.MeasurementDouble measurementDouble = (Measurement.MeasurementDouble) obj;
        return this.measure.equals(measurementDouble.getMeasure()) && Double.doubleToLongBits(this.value) == Double.doubleToLongBits(measurementDouble.getValue());
    }

    public int hashCode() {
        return (int) (((long) ((this.measure.hashCode() ^ 1000003) * 1000003)) ^ ((Double.doubleToLongBits(this.value) >>> 32) ^ Double.doubleToLongBits(this.value)));
    }
}
