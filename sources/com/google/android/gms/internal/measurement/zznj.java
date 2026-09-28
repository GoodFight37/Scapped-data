package com.google.android.gms.internal.measurement;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.4.0 */
/* JADX INFO: loaded from: classes.dex */
final class zznj {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    static String zza(zznh zznhVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzd(zznhVar, sb, 0);
        return sb.toString();
    }

    static void zzb(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zzb(sb, i, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                zzb(sb, i, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        zzc(i, sb);
        if (!str.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Character.toLowerCase(str.charAt(0)));
            for (int i2 = 1; i2 < str.length(); i2++) {
                char cCharAt = str.charAt(i2);
                if (Character.isUpperCase(cCharAt)) {
                    sb2.append("_");
                }
                sb2.append(Character.toLowerCase(cCharAt));
            }
            str = sb2.toString();
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            zzld zzldVar = zzld.zzb;
            sb.append(zzoc.zza(new zzlb(((String) obj).getBytes(zzmk.zza))));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzld) {
            sb.append(": \"");
            sb.append(zzoc.zza((zzld) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzmd) {
            sb.append(" {");
            zzd((zzmd) obj, sb, i + 2);
            sb.append("\n");
            zzc(i, sb);
            sb.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb.append(": ");
            sb.append(obj);
            return;
        }
        int i3 = i + 2;
        sb.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        zzb(sb, i3, "key", entry.getKey());
        zzb(sb, i3, "value", entry.getValue());
        sb.append("\n");
        zzc(i, sb);
        sb.append("}");
    }

    private static void zzc(int i, StringBuilder sb) {
        while (i > 0) {
            int i2 = 80;
            if (i <= 80) {
                i2 = i;
            }
            sb.append(zza, 0, i2);
            i -= i2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0203  */
    private static void zzd(zznh zznhVar, StringBuilder sb, int i) {
        int i2;
        boolean zEquals;
        Method method;
        Method method2;
        HashSet hashSet = new HashSet();
        HashMap map = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zznhVar.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i3 = 0;
        while (true) {
            i2 = 3;
            if (i3 >= length) {
                break;
            }
            Method method3 = declaredMethods[i3];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        map.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith("get")) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i3++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String strSubstring = ((String) entry.getKey()).substring(i2);
            if (strSubstring.endsWith("List") && !strSubstring.endsWith("OrBuilderList") && !strSubstring.equals("List") && (method2 = (Method) entry.getValue()) != null && method2.getReturnType().equals(List.class)) {
                zzb(sb, i, strSubstring.substring(0, strSubstring.length() - 4), zzmd.zzcp(method2, zznhVar, new Object[0]));
            } else if (strSubstring.endsWith("Map") && !strSubstring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                zzb(sb, i, strSubstring.substring(0, strSubstring.length() - 3), zzmd.zzcp(method, zznhVar, new Object[0]));
            } else if (hashSet.contains("set".concat(String.valueOf(strSubstring))) && (!strSubstring.endsWith("Bytes") || !treeMap.containsKey("get".concat(String.valueOf(strSubstring.substring(0, strSubstring.length() - 5)))))) {
                Method method4 = (Method) entry.getValue();
                Method method5 = (Method) map.get("has".concat(String.valueOf(strSubstring)));
                if (method4 != null) {
                    Object objZzcp = zzmd.zzcp(method4, zznhVar, new Object[0]);
                    if (method5 == null) {
                        if (objZzcp instanceof Boolean) {
                            if (((Boolean) objZzcp).booleanValue()) {
                                zzb(sb, i, strSubstring, objZzcp);
                            }
                        } else if (objZzcp instanceof Integer) {
                            if (((Integer) objZzcp).intValue() != 0) {
                                zzb(sb, i, strSubstring, objZzcp);
                            }
                        } else if (objZzcp instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) objZzcp).floatValue()) != 0) {
                                zzb(sb, i, strSubstring, objZzcp);
                            }
                        } else if (!(objZzcp instanceof Double)) {
                            if (objZzcp instanceof String) {
                                zEquals = objZzcp.equals("");
                            } else if (objZzcp instanceof zzld) {
                                zEquals = objZzcp.equals(zzld.zzb);
                            } else if (objZzcp instanceof zznh) {
                                if (objZzcp != ((zznh) objZzcp).zzcC()) {
                                    zzb(sb, i, strSubstring, objZzcp);
                                }
                            } else if (!(objZzcp instanceof Enum) || ((Enum) objZzcp).ordinal() != 0) {
                                zzb(sb, i, strSubstring, objZzcp);
                            }
                            if (!zEquals) {
                                zzb(sb, i, strSubstring, objZzcp);
                            }
                        } else if (Double.doubleToRawLongBits(((Double) objZzcp).doubleValue()) != 0) {
                            zzb(sb, i, strSubstring, objZzcp);
                        }
                    } else if (((Boolean) zzmd.zzcp(method5, zznhVar, new Object[0])).booleanValue()) {
                        zzb(sb, i, strSubstring, objZzcp);
                    }
                }
            }
            i2 = 3;
        }
        if (zznhVar instanceof zzma) {
            Iterator itZze = ((zzma) zznhVar).zzb.zze();
            if (itZze.hasNext()) {
                throw null;
            }
        }
        zzof zzofVar = ((zzmd) zznhVar).zzc;
        if (zzofVar != null) {
            zzofVar.zzi(sb, i);
        }
    }
}
