package com.google.android.gms.internal.firebase_auth;

final class zzik {
    static String zzf(zzeh zzeh) {
        zzil zzil = new zzil(zzeh);
        StringBuilder sb = new StringBuilder(zzil.size());
        for (int i = 0; i < zzil.size(); i++) {
            byte zzk = zzil.zzk(i);
            if (zzk == 34) {
                sb.append("\\\"");
            } else if (zzk == 39) {
                sb.append("\\'");
            } else if (zzk != 92) {
                switch (zzk) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (zzk >= 32 && zzk <= 126) {
                            sb.append((char) zzk);
                            break;
                        } else {
                            sb.append('\\');
                            sb.append((char) (((zzk >>> 6) & 3) + 48));
                            sb.append((char) (((zzk >>> 3) & 7) + 48));
                            sb.append((char) ((zzk & 7) + 48));
                            break;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }
}
