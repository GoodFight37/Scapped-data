package com.google.android.gms.internal.measurement;

import androidx.core.text.HtmlCompat;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbk extends zzaw {
    protected zzbk() {
        this.zza.add(zzbl.ASSIGN);
        this.zza.add(zzbl.CONST);
        this.zza.add(zzbl.CREATE_ARRAY);
        this.zza.add(zzbl.CREATE_OBJECT);
        this.zza.add(zzbl.EXPRESSION_LIST);
        this.zza.add(zzbl.GET);
        this.zza.add(zzbl.GET_INDEX);
        this.zza.add(zzbl.GET_PROPERTY);
        this.zza.add(zzbl.NULL);
        this.zza.add(zzbl.SET_PROPERTY);
        this.zza.add(zzbl.TYPEOF);
        this.zza.add(zzbl.UNDEFINED);
        this.zza.add(zzbl.VAR);
    }

    @Override // com.google.android.gms.internal.measurement.zzaw
    public final zzap zza(String str, zzg zzgVar, List list) {
        zzap zzapVarZzb;
        String str2;
        zzbl zzblVar = zzbl.ADD;
        int iOrdinal = zzh.zze(str).ordinal();
        int i = 0;
        if (iOrdinal == 3) {
            zzh.zzh(zzbl.ASSIGN.name(), 2, list);
            zzap zzapVarZzb2 = zzgVar.zzb((zzap) list.get(0));
            if (!(zzapVarZzb2 instanceof zzat)) {
                throw new IllegalArgumentException(String.format("Expected string for assign var. got %s", zzapVarZzb2.getClass().getCanonicalName()));
            }
            if (!zzgVar.zzh(zzapVarZzb2.zzi())) {
                throw new IllegalArgumentException(String.format("Attempting to assign undefined value %s", zzapVarZzb2.zzi()));
            }
            zzap zzapVarZzb3 = zzgVar.zzb((zzap) list.get(1));
            zzgVar.zzg(zzapVarZzb2.zzi(), zzapVarZzb3);
            return zzapVarZzb3;
        }
        if (iOrdinal == 14) {
            zzh.zzi(zzbl.CONST.name(), 2, list);
            if (list.size() % 2 != 0) {
                throw new IllegalArgumentException(String.format("CONST requires an even number of arguments, found %s", Integer.valueOf(list.size())));
            }
            while (i < list.size() - 1) {
                zzap zzapVarZzb4 = zzgVar.zzb((zzap) list.get(i));
                if (!(zzapVarZzb4 instanceof zzat)) {
                    throw new IllegalArgumentException(String.format("Expected string for const name. got %s", zzapVarZzb4.getClass().getCanonicalName()));
                }
                zzgVar.zzf(zzapVarZzb4.zzi(), zzgVar.zzb((zzap) list.get(i + 1)));
                i += 2;
            }
            return zzap.zzf;
        }
        if (iOrdinal == 24) {
            zzh.zzi(zzbl.EXPRESSION_LIST.name(), 1, list);
            zzap zzapVarZzb5 = zzap.zzf;
            while (i < list.size()) {
                zzapVarZzb5 = zzgVar.zzb((zzap) list.get(i));
                if (zzapVarZzb5 instanceof zzag) {
                    throw new IllegalStateException("ControlValue cannot be in an expression list");
                }
                i++;
            }
            return zzapVarZzb5;
        }
        if (iOrdinal == 33) {
            zzh.zzh(zzbl.GET.name(), 1, list);
            zzap zzapVarZzb6 = zzgVar.zzb((zzap) list.get(0));
            if (zzapVarZzb6 instanceof zzat) {
                return zzgVar.zzd(zzapVarZzb6.zzi());
            }
            throw new IllegalArgumentException(String.format("Expected string for get var. got %s", zzapVarZzb6.getClass().getCanonicalName()));
        }
        if (iOrdinal == 49) {
            zzh.zzh(zzbl.NULL.name(), 0, list);
            return zzap.zzg;
        }
        if (iOrdinal != 58) {
            if (iOrdinal == 17) {
                if (list.isEmpty()) {
                    return new zzae();
                }
                zzae zzaeVar = new zzae();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    zzap zzapVarZzb7 = zzgVar.zzb((zzap) it.next());
                    if (zzapVarZzb7 instanceof zzag) {
                        throw new IllegalStateException("Failed to evaluate array element");
                    }
                    zzaeVar.zzq(i, zzapVarZzb7);
                    i++;
                }
                return zzaeVar;
            }
            if (iOrdinal == 18) {
                if (list.isEmpty()) {
                    return new zzam();
                }
                if (list.size() % 2 != 0) {
                    throw new IllegalArgumentException(String.format("CREATE_OBJECT requires an even number of arguments, found %s", Integer.valueOf(list.size())));
                }
                zzam zzamVar = new zzam();
                while (i < list.size() - 1) {
                    zzap zzapVarZzb8 = zzgVar.zzb((zzap) list.get(i));
                    zzap zzapVarZzb9 = zzgVar.zzb((zzap) list.get(i + 1));
                    if ((zzapVarZzb8 instanceof zzag) || (zzapVarZzb9 instanceof zzag)) {
                        throw new IllegalStateException("Failed to evaluate map entry");
                    }
                    zzamVar.zzr(zzapVarZzb8.zzi(), zzapVarZzb9);
                    i += 2;
                }
                return zzamVar;
            }
            if (iOrdinal == 35 || iOrdinal == 36) {
                zzh.zzh(zzbl.GET_PROPERTY.name(), 2, list);
                zzap zzapVarZzb10 = zzgVar.zzb((zzap) list.get(0));
                zzap zzapVarZzb11 = zzgVar.zzb((zzap) list.get(1));
                if ((zzapVarZzb10 instanceof zzae) && zzh.zzk(zzapVarZzb11)) {
                    return ((zzae) zzapVarZzb10).zze(zzapVarZzb11.zzh().intValue());
                }
                if (zzapVarZzb10 instanceof zzal) {
                    return ((zzal) zzapVarZzb10).zzf(zzapVarZzb11.zzi());
                }
                if (zzapVarZzb10 instanceof zzat) {
                    if ("length".equals(zzapVarZzb11.zzi())) {
                        zzapVarZzb = new zzah(Double.valueOf(zzapVarZzb10.zzi().length()));
                    } else if (zzh.zzk(zzapVarZzb11) && zzapVarZzb11.zzh().doubleValue() < zzapVarZzb10.zzi().length()) {
                        return new zzat(String.valueOf(zzapVarZzb10.zzi().charAt(zzapVarZzb11.zzh().intValue())));
                    }
                }
                return zzap.zzf;
            }
            switch (iOrdinal) {
                case 62:
                    zzh.zzh(zzbl.TYPEOF.name(), 1, list);
                    zzap zzapVarZzb12 = zzgVar.zzb((zzap) list.get(0));
                    if (zzapVarZzb12 instanceof zzau) {
                        str2 = "undefined";
                    } else if (zzapVarZzb12 instanceof zzaf) {
                        str2 = "boolean";
                    } else if (zzapVarZzb12 instanceof zzah) {
                        str2 = "number";
                    } else if (zzapVarZzb12 instanceof zzat) {
                        str2 = "string";
                    } else if (zzapVarZzb12 instanceof zzao) {
                        str2 = "function";
                    } else {
                        if ((zzapVarZzb12 instanceof zzaq) || (zzapVarZzb12 instanceof zzag)) {
                            throw new IllegalArgumentException(String.format("Unsupported value type %s in typeof", zzapVarZzb12));
                        }
                        str2 = "object";
                    }
                    return new zzat(str2);
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    zzh.zzh(zzbl.UNDEFINED.name(), 0, list);
                    return zzap.zzf;
                case 64:
                    zzh.zzi(zzbl.VAR.name(), 1, list);
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        zzap zzapVarZzb13 = zzgVar.zzb((zzap) it2.next());
                        if (!(zzapVarZzb13 instanceof zzat)) {
                            throw new IllegalArgumentException(String.format("Expected string for var name. got %s", zzapVarZzb13.getClass().getCanonicalName()));
                        }
                        zzgVar.zze(zzapVarZzb13.zzi(), zzap.zzf);
                    }
                    return zzap.zzf;
                default:
                    return super.zzb(str);
            }
        }
        zzh.zzh(zzbl.SET_PROPERTY.name(), 3, list);
        zzap zzapVarZzb14 = zzgVar.zzb((zzap) list.get(0));
        zzap zzapVarZzb15 = zzgVar.zzb((zzap) list.get(1));
        zzapVarZzb = zzgVar.zzb((zzap) list.get(2));
        if (zzapVarZzb14 == zzap.zzf || zzapVarZzb14 == zzap.zzg) {
            throw new IllegalStateException(String.format("Can't set property %s of %s", zzapVarZzb15.zzi(), zzapVarZzb14.zzi()));
        }
        if ((zzapVarZzb14 instanceof zzae) && (zzapVarZzb15 instanceof zzah)) {
            ((zzae) zzapVarZzb14).zzq(zzapVarZzb15.zzh().intValue(), zzapVarZzb);
        } else if (zzapVarZzb14 instanceof zzal) {
            ((zzal) zzapVarZzb14).zzr(zzapVarZzb15.zzi(), zzapVarZzb);
            return zzapVarZzb;
        }
        return zzapVarZzb;
    }
}
