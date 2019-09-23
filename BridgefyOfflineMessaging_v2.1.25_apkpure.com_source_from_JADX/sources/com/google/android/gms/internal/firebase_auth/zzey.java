package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import java.io.IOException;
import java.util.List;

final class zzey implements zzhr {
    private int tag;
    private final zzet zztl;
    private int zztm;
    private int zztn = 0;

    public static zzey zza(zzet zzet) {
        if (zzet.zzta != null) {
            return zzet.zzta;
        }
        return new zzey(zzet);
    }

    private zzey(zzet zzet) {
        this.zztl = (zzet) zzfv.zza(zzet, "input");
        this.zztl.zzta = this;
    }

    public final int zzgg() throws IOException {
        if (this.zztn != 0) {
            this.tag = this.zztn;
            this.zztn = 0;
        } else {
            this.tag = this.zztl.zzfi();
        }
        return (this.tag == 0 || this.tag == this.zztm) ? BaseClientBuilder.API_PRIORITY_OTHER : this.tag >>> 3;
    }

    public final int getTag() {
        return this.tag;
    }

    public final boolean zzgh() throws IOException {
        if (this.zztl.zzfy() || this.tag == this.zztm) {
            return false;
        }
        return this.zztl.zzo(this.tag);
    }

    private final void zzy(int i) throws IOException {
        if ((this.tag & 7) != i) {
            throw zzgc.zzhv();
        }
    }

    public final double readDouble() throws IOException {
        zzy(1);
        return this.zztl.readDouble();
    }

    public final float readFloat() throws IOException {
        zzy(5);
        return this.zztl.readFloat();
    }

    public final long zzfj() throws IOException {
        zzy(0);
        return this.zztl.zzfj();
    }

    public final long zzfk() throws IOException {
        zzy(0);
        return this.zztl.zzfk();
    }

    public final int zzfl() throws IOException {
        zzy(0);
        return this.zztl.zzfl();
    }

    public final long zzfm() throws IOException {
        zzy(1);
        return this.zztl.zzfm();
    }

    public final int zzfn() throws IOException {
        zzy(5);
        return this.zztl.zzfn();
    }

    public final boolean zzfo() throws IOException {
        zzy(0);
        return this.zztl.zzfo();
    }

    public final String readString() throws IOException {
        zzy(2);
        return this.zztl.readString();
    }

    public final String zzfp() throws IOException {
        zzy(2);
        return this.zztl.zzfp();
    }

    public final <T> T zza(zzhw<T> zzhw, zzfg zzfg) throws IOException {
        zzy(2);
        return zzc(zzhw, zzfg);
    }

    public final <T> T zzb(zzhw<T> zzhw, zzfg zzfg) throws IOException {
        zzy(3);
        return zzd(zzhw, zzfg);
    }

    private final <T> T zzc(zzhw<T> zzhw, zzfg zzfg) throws IOException {
        int zzfr = this.zztl.zzfr();
        if (this.zztl.zzsx < this.zztl.zzsy) {
            int zzp = this.zztl.zzp(zzfr);
            T newInstance = zzhw.newInstance();
            this.zztl.zzsx++;
            zzhw.zza(newInstance, this, zzfg);
            zzhw.zzf(newInstance);
            this.zztl.zzn(0);
            this.zztl.zzsx--;
            this.zztl.zzq(zzp);
            return newInstance;
        }
        throw new zzgc("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    private final <T> T zzd(zzhw<T> zzhw, zzfg zzfg) throws IOException {
        int i = this.zztm;
        this.zztm = ((this.tag >>> 3) << 3) | 4;
        try {
            T newInstance = zzhw.newInstance();
            zzhw.zza(newInstance, this, zzfg);
            zzhw.zzf(newInstance);
            if (this.tag == this.zztm) {
                return newInstance;
            }
            throw zzgc.zzhx();
        } finally {
            this.zztm = i;
        }
    }

    public final zzeh zzfq() throws IOException {
        zzy(2);
        return this.zztl.zzfq();
    }

    public final int zzfr() throws IOException {
        zzy(0);
        return this.zztl.zzfr();
    }

    public final int zzfs() throws IOException {
        zzy(0);
        return this.zztl.zzfs();
    }

    public final int zzft() throws IOException {
        zzy(5);
        return this.zztl.zzft();
    }

    public final long zzfu() throws IOException {
        zzy(1);
        return this.zztl.zzfu();
    }

    public final int zzfv() throws IOException {
        zzy(0);
        return this.zztl.zzfv();
    }

    public final long zzfw() throws IOException {
        zzy(0);
        return this.zztl.zzfw();
    }

    public final void zzd(List<Double> list) throws IOException {
        int zzfi;
        int zzfi2;
        if (list instanceof zzfd) {
            zzfd zzfd = (zzfd) list;
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    int zzfr = this.zztl.zzfr();
                    zzz(zzfr);
                    int zzfz = this.zztl.zzfz() + zzfr;
                    do {
                        zzfd.zzc(this.zztl.readDouble());
                    } while (this.zztl.zzfz() < zzfz);
                    return;
                default:
                    throw zzgc.zzhv();
            }
            do {
                zzfd.zzc(this.zztl.readDouble());
                if (!this.zztl.zzfy()) {
                    zzfi2 = this.zztl.zzfi();
                } else {
                    return;
                }
            } while (zzfi2 == this.tag);
            this.zztn = zzfi2;
            return;
        }
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                int zzfr2 = this.zztl.zzfr();
                zzz(zzfr2);
                int zzfz2 = this.zztl.zzfz() + zzfr2;
                do {
                    list.add(Double.valueOf(this.zztl.readDouble()));
                } while (this.zztl.zzfz() < zzfz2);
                return;
            default:
                throw zzgc.zzhv();
        }
        do {
            list.add(Double.valueOf(this.zztl.readDouble()));
            if (!this.zztl.zzfy()) {
                zzfi = this.zztl.zzfi();
            } else {
                return;
            }
        } while (zzfi == this.tag);
        this.zztn = zzfi;
    }

    public final void zze(List<Float> list) throws IOException {
        int zzfi;
        int zzfi2;
        if (list instanceof zzfq) {
            zzfq zzfq = (zzfq) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzfr = this.zztl.zzfr();
                zzaa(zzfr);
                int zzfz = this.zztl.zzfz() + zzfr;
                do {
                    zzfq.zzc(this.zztl.readFloat());
                } while (this.zztl.zzfz() < zzfz);
            } else if (i == 5) {
                do {
                    zzfq.zzc(this.zztl.readFloat());
                    if (!this.zztl.zzfy()) {
                        zzfi2 = this.zztl.zzfi();
                    } else {
                        return;
                    }
                } while (zzfi2 == this.tag);
                this.zztn = zzfi2;
            } else {
                throw zzgc.zzhv();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzfr2 = this.zztl.zzfr();
                zzaa(zzfr2);
                int zzfz2 = this.zztl.zzfz() + zzfr2;
                do {
                    list.add(Float.valueOf(this.zztl.readFloat()));
                } while (this.zztl.zzfz() < zzfz2);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(this.zztl.readFloat()));
                    if (!this.zztl.zzfy()) {
                        zzfi = this.zztl.zzfi();
                    } else {
                        return;
                    }
                } while (zzfi == this.tag);
                this.zztn = zzfi;
            } else {
                throw zzgc.zzhv();
            }
        }
    }

    public final void zzf(List<Long> list) throws IOException {
        int zzfi;
        int zzfi2;
        if (list instanceof zzgq) {
            zzgq zzgq = (zzgq) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzgq.zzl(this.zztl.zzfj());
                    if (!this.zztl.zzfy()) {
                        zzfi2 = this.zztl.zzfi();
                    } else {
                        return;
                    }
                } while (zzfi2 == this.tag);
                this.zztn = zzfi2;
            } else if (i == 2) {
                int zzfz = this.zztl.zzfz() + this.zztl.zzfr();
                do {
                    zzgq.zzl(this.zztl.zzfj());
                } while (this.zztl.zzfz() < zzfz);
                zzab(zzfz);
            } else {
                throw zzgc.zzhv();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zztl.zzfj()));
                    if (!this.zztl.zzfy()) {
                        zzfi = this.zztl.zzfi();
                    } else {
                        return;
                    }
                } while (zzfi == this.tag);
                this.zztn = zzfi;
            } else if (i2 == 2) {
                int zzfz2 = this.zztl.zzfz() + this.zztl.zzfr();
                do {
                    list.add(Long.valueOf(this.zztl.zzfj()));
                } while (this.zztl.zzfz() < zzfz2);
                zzab(zzfz2);
            } else {
                throw zzgc.zzhv();
            }
        }
    }

    public final void zzg(List<Long> list) throws IOException {
        int zzfi;
        int zzfi2;
        if (list instanceof zzgq) {
            zzgq zzgq = (zzgq) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzgq.zzl(this.zztl.zzfk());
                    if (!this.zztl.zzfy()) {
                        zzfi2 = this.zztl.zzfi();
                    } else {
                        return;
                    }
                } while (zzfi2 == this.tag);
                this.zztn = zzfi2;
            } else if (i == 2) {
                int zzfz = this.zztl.zzfz() + this.zztl.zzfr();
                do {
                    zzgq.zzl(this.zztl.zzfk());
                } while (this.zztl.zzfz() < zzfz);
                zzab(zzfz);
            } else {
                throw zzgc.zzhv();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zztl.zzfk()));
                    if (!this.zztl.zzfy()) {
                        zzfi = this.zztl.zzfi();
                    } else {
                        return;
                    }
                } while (zzfi == this.tag);
                this.zztn = zzfi;
            } else if (i2 == 2) {
                int zzfz2 = this.zztl.zzfz() + this.zztl.zzfr();
                do {
                    list.add(Long.valueOf(this.zztl.zzfk()));
                } while (this.zztl.zzfz() < zzfz2);
                zzab(zzfz2);
            } else {
                throw zzgc.zzhv();
            }
        }
    }

    public final void zzh(List<Integer> list) throws IOException {
        int zzfi;
        int zzfi2;
        if (list instanceof zzfu) {
            zzfu zzfu = (zzfu) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzfu.zzas(this.zztl.zzfl());
                    if (!this.zztl.zzfy()) {
                        zzfi2 = this.zztl.zzfi();
                    } else {
                        return;
                    }
                } while (zzfi2 == this.tag);
                this.zztn = zzfi2;
            } else if (i == 2) {
                int zzfz = this.zztl.zzfz() + this.zztl.zzfr();
                do {
                    zzfu.zzas(this.zztl.zzfl());
                } while (this.zztl.zzfz() < zzfz);
                zzab(zzfz);
            } else {
                throw zzgc.zzhv();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zztl.zzfl()));
                    if (!this.zztl.zzfy()) {
                        zzfi = this.zztl.zzfi();
                    } else {
                        return;
                    }
                } while (zzfi == this.tag);
                this.zztn = zzfi;
            } else if (i2 == 2) {
                int zzfz2 = this.zztl.zzfz() + this.zztl.zzfr();
                do {
                    list.add(Integer.valueOf(this.zztl.zzfl()));
                } while (this.zztl.zzfz() < zzfz2);
                zzab(zzfz2);
            } else {
                throw zzgc.zzhv();
            }
        }
    }

    public final void zzi(List<Long> list) throws IOException {
        int zzfi;
        int zzfi2;
        if (list instanceof zzgq) {
            zzgq zzgq = (zzgq) list;
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    int zzfr = this.zztl.zzfr();
                    zzz(zzfr);
                    int zzfz = this.zztl.zzfz() + zzfr;
                    do {
                        zzgq.zzl(this.zztl.zzfm());
                    } while (this.zztl.zzfz() < zzfz);
                    return;
                default:
                    throw zzgc.zzhv();
            }
            do {
                zzgq.zzl(this.zztl.zzfm());
                if (!this.zztl.zzfy()) {
                    zzfi2 = this.zztl.zzfi();
                } else {
                    return;
                }
            } while (zzfi2 == this.tag);
            this.zztn = zzfi2;
            return;
        }
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                int zzfr2 = this.zztl.zzfr();
                zzz(zzfr2);
                int zzfz2 = this.zztl.zzfz() + zzfr2;
                do {
                    list.add(Long.valueOf(this.zztl.zzfm()));
                } while (this.zztl.zzfz() < zzfz2);
                return;
            default:
                throw zzgc.zzhv();
        }
        do {
            list.add(Long.valueOf(this.zztl.zzfm()));
            if (!this.zztl.zzfy()) {
                zzfi = this.zztl.zzfi();
            } else {
                return;
            }
        } while (zzfi == this.tag);
        this.zztn = zzfi;
    }

    public final void zzj(List<Integer> list) throws IOException {
        int zzfi;
        int zzfi2;
        if (list instanceof zzfu) {
            zzfu zzfu = (zzfu) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzfr = this.zztl.zzfr();
                zzaa(zzfr);
                int zzfz = this.zztl.zzfz() + zzfr;
                do {
                    zzfu.zzas(this.zztl.zzfn());
                } while (this.zztl.zzfz() < zzfz);
            } else if (i == 5) {
                do {
                    zzfu.zzas(this.zztl.zzfn());
                    if (!this.zztl.zzfy()) {
                        zzfi2 = this.zztl.zzfi();
                    } else {
                        return;
                    }
                } while (zzfi2 == this.tag);
                this.zztn = zzfi2;
            } else {
                throw zzgc.zzhv();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzfr2 = this.zztl.zzfr();
                zzaa(zzfr2);
                int zzfz2 = this.zztl.zzfz() + zzfr2;
                do {
                    list.add(Integer.valueOf(this.zztl.zzfn()));
                } while (this.zztl.zzfz() < zzfz2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zztl.zzfn()));
                    if (!this.zztl.zzfy()) {
                        zzfi = this.zztl.zzfi();
                    } else {
                        return;
                    }
                } while (zzfi == this.tag);
                this.zztn = zzfi;
            } else {
                throw zzgc.zzhv();
            }
        }
    }

    public final void zzk(List<Boolean> list) throws IOException {
        int zzfi;
        int zzfi2;
        if (list instanceof zzef) {
            zzef zzef = (zzef) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzef.addBoolean(this.zztl.zzfo());
                    if (!this.zztl.zzfy()) {
                        zzfi2 = this.zztl.zzfi();
                    } else {
                        return;
                    }
                } while (zzfi2 == this.tag);
                this.zztn = zzfi2;
            } else if (i == 2) {
                int zzfz = this.zztl.zzfz() + this.zztl.zzfr();
                do {
                    zzef.addBoolean(this.zztl.zzfo());
                } while (this.zztl.zzfz() < zzfz);
                zzab(zzfz);
            } else {
                throw zzgc.zzhv();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zztl.zzfo()));
                    if (!this.zztl.zzfy()) {
                        zzfi = this.zztl.zzfi();
                    } else {
                        return;
                    }
                } while (zzfi == this.tag);
                this.zztn = zzfi;
            } else if (i2 == 2) {
                int zzfz2 = this.zztl.zzfz() + this.zztl.zzfr();
                do {
                    list.add(Boolean.valueOf(this.zztl.zzfo()));
                } while (this.zztl.zzfz() < zzfz2);
                zzab(zzfz2);
            } else {
                throw zzgc.zzhv();
            }
        }
    }

    public final void readStringList(List<String> list) throws IOException {
        zza(list, false);
    }

    public final void zzl(List<String> list) throws IOException {
        zza(list, true);
    }

    private final void zza(List<String> list, boolean z) throws IOException {
        int zzfi;
        int zzfi2;
        if ((this.tag & 7) != 2) {
            throw zzgc.zzhv();
        } else if (!(list instanceof zzgl) || z) {
            do {
                list.add(z ? zzfp() : readString());
                if (!this.zztl.zzfy()) {
                    zzfi = this.zztl.zzfi();
                } else {
                    return;
                }
            } while (zzfi == this.tag);
            this.zztn = zzfi;
        } else {
            zzgl zzgl = (zzgl) list;
            do {
                zzgl.zzc(zzfq());
                if (!this.zztl.zzfy()) {
                    zzfi2 = this.zztl.zzfi();
                } else {
                    return;
                }
            } while (zzfi2 == this.tag);
            this.zztn = zzfi2;
        }
    }

    public final <T> void zza(List<T> list, zzhw<T> zzhw, zzfg zzfg) throws IOException {
        int zzfi;
        if ((this.tag & 7) == 2) {
            int i = this.tag;
            do {
                list.add(zzc(zzhw, zzfg));
                if (!this.zztl.zzfy() && this.zztn == 0) {
                    zzfi = this.zztl.zzfi();
                } else {
                    return;
                }
            } while (zzfi == i);
            this.zztn = zzfi;
            return;
        }
        throw zzgc.zzhv();
    }

    public final <T> void zzb(List<T> list, zzhw<T> zzhw, zzfg zzfg) throws IOException {
        int zzfi;
        if ((this.tag & 7) == 3) {
            int i = this.tag;
            do {
                list.add(zzd(zzhw, zzfg));
                if (!this.zztl.zzfy() && this.zztn == 0) {
                    zzfi = this.zztl.zzfi();
                } else {
                    return;
                }
            } while (zzfi == i);
            this.zztn = zzfi;
            return;
        }
        throw zzgc.zzhv();
    }

    public final void zzm(List<zzeh> list) throws IOException {
        int zzfi;
        if ((this.tag & 7) == 2) {
            do {
                list.add(zzfq());
                if (!this.zztl.zzfy()) {
                    zzfi = this.zztl.zzfi();
                } else {
                    return;
                }
            } while (zzfi == this.tag);
            this.zztn = zzfi;
            return;
        }
        throw zzgc.zzhv();
    }

    public final void zzn(List<Integer> list) throws IOException {
        int zzfi;
        int zzfi2;
        if (list instanceof zzfu) {
            zzfu zzfu = (zzfu) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzfu.zzas(this.zztl.zzfr());
                    if (!this.zztl.zzfy()) {
                        zzfi2 = this.zztl.zzfi();
                    } else {
                        return;
                    }
                } while (zzfi2 == this.tag);
                this.zztn = zzfi2;
            } else if (i == 2) {
                int zzfz = this.zztl.zzfz() + this.zztl.zzfr();
                do {
                    zzfu.zzas(this.zztl.zzfr());
                } while (this.zztl.zzfz() < zzfz);
                zzab(zzfz);
            } else {
                throw zzgc.zzhv();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zztl.zzfr()));
                    if (!this.zztl.zzfy()) {
                        zzfi = this.zztl.zzfi();
                    } else {
                        return;
                    }
                } while (zzfi == this.tag);
                this.zztn = zzfi;
            } else if (i2 == 2) {
                int zzfz2 = this.zztl.zzfz() + this.zztl.zzfr();
                do {
                    list.add(Integer.valueOf(this.zztl.zzfr()));
                } while (this.zztl.zzfz() < zzfz2);
                zzab(zzfz2);
            } else {
                throw zzgc.zzhv();
            }
        }
    }

    public final void zzo(List<Integer> list) throws IOException {
        int zzfi;
        int zzfi2;
        if (list instanceof zzfu) {
            zzfu zzfu = (zzfu) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzfu.zzas(this.zztl.zzfs());
                    if (!this.zztl.zzfy()) {
                        zzfi2 = this.zztl.zzfi();
                    } else {
                        return;
                    }
                } while (zzfi2 == this.tag);
                this.zztn = zzfi2;
            } else if (i == 2) {
                int zzfz = this.zztl.zzfz() + this.zztl.zzfr();
                do {
                    zzfu.zzas(this.zztl.zzfs());
                } while (this.zztl.zzfz() < zzfz);
                zzab(zzfz);
            } else {
                throw zzgc.zzhv();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zztl.zzfs()));
                    if (!this.zztl.zzfy()) {
                        zzfi = this.zztl.zzfi();
                    } else {
                        return;
                    }
                } while (zzfi == this.tag);
                this.zztn = zzfi;
            } else if (i2 == 2) {
                int zzfz2 = this.zztl.zzfz() + this.zztl.zzfr();
                do {
                    list.add(Integer.valueOf(this.zztl.zzfs()));
                } while (this.zztl.zzfz() < zzfz2);
                zzab(zzfz2);
            } else {
                throw zzgc.zzhv();
            }
        }
    }

    public final void zzp(List<Integer> list) throws IOException {
        int zzfi;
        int zzfi2;
        if (list instanceof zzfu) {
            zzfu zzfu = (zzfu) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzfr = this.zztl.zzfr();
                zzaa(zzfr);
                int zzfz = this.zztl.zzfz() + zzfr;
                do {
                    zzfu.zzas(this.zztl.zzft());
                } while (this.zztl.zzfz() < zzfz);
            } else if (i == 5) {
                do {
                    zzfu.zzas(this.zztl.zzft());
                    if (!this.zztl.zzfy()) {
                        zzfi2 = this.zztl.zzfi();
                    } else {
                        return;
                    }
                } while (zzfi2 == this.tag);
                this.zztn = zzfi2;
            } else {
                throw zzgc.zzhv();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzfr2 = this.zztl.zzfr();
                zzaa(zzfr2);
                int zzfz2 = this.zztl.zzfz() + zzfr2;
                do {
                    list.add(Integer.valueOf(this.zztl.zzft()));
                } while (this.zztl.zzfz() < zzfz2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zztl.zzft()));
                    if (!this.zztl.zzfy()) {
                        zzfi = this.zztl.zzfi();
                    } else {
                        return;
                    }
                } while (zzfi == this.tag);
                this.zztn = zzfi;
            } else {
                throw zzgc.zzhv();
            }
        }
    }

    public final void zzq(List<Long> list) throws IOException {
        int zzfi;
        int zzfi2;
        if (list instanceof zzgq) {
            zzgq zzgq = (zzgq) list;
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    int zzfr = this.zztl.zzfr();
                    zzz(zzfr);
                    int zzfz = this.zztl.zzfz() + zzfr;
                    do {
                        zzgq.zzl(this.zztl.zzfu());
                    } while (this.zztl.zzfz() < zzfz);
                    return;
                default:
                    throw zzgc.zzhv();
            }
            do {
                zzgq.zzl(this.zztl.zzfu());
                if (!this.zztl.zzfy()) {
                    zzfi2 = this.zztl.zzfi();
                } else {
                    return;
                }
            } while (zzfi2 == this.tag);
            this.zztn = zzfi2;
            return;
        }
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                int zzfr2 = this.zztl.zzfr();
                zzz(zzfr2);
                int zzfz2 = this.zztl.zzfz() + zzfr2;
                do {
                    list.add(Long.valueOf(this.zztl.zzfu()));
                } while (this.zztl.zzfz() < zzfz2);
                return;
            default:
                throw zzgc.zzhv();
        }
        do {
            list.add(Long.valueOf(this.zztl.zzfu()));
            if (!this.zztl.zzfy()) {
                zzfi = this.zztl.zzfi();
            } else {
                return;
            }
        } while (zzfi == this.tag);
        this.zztn = zzfi;
    }

    public final void zzr(List<Integer> list) throws IOException {
        int zzfi;
        int zzfi2;
        if (list instanceof zzfu) {
            zzfu zzfu = (zzfu) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzfu.zzas(this.zztl.zzfv());
                    if (!this.zztl.zzfy()) {
                        zzfi2 = this.zztl.zzfi();
                    } else {
                        return;
                    }
                } while (zzfi2 == this.tag);
                this.zztn = zzfi2;
            } else if (i == 2) {
                int zzfz = this.zztl.zzfz() + this.zztl.zzfr();
                do {
                    zzfu.zzas(this.zztl.zzfv());
                } while (this.zztl.zzfz() < zzfz);
                zzab(zzfz);
            } else {
                throw zzgc.zzhv();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zztl.zzfv()));
                    if (!this.zztl.zzfy()) {
                        zzfi = this.zztl.zzfi();
                    } else {
                        return;
                    }
                } while (zzfi == this.tag);
                this.zztn = zzfi;
            } else if (i2 == 2) {
                int zzfz2 = this.zztl.zzfz() + this.zztl.zzfr();
                do {
                    list.add(Integer.valueOf(this.zztl.zzfv()));
                } while (this.zztl.zzfz() < zzfz2);
                zzab(zzfz2);
            } else {
                throw zzgc.zzhv();
            }
        }
    }

    public final void zzs(List<Long> list) throws IOException {
        int zzfi;
        int zzfi2;
        if (list instanceof zzgq) {
            zzgq zzgq = (zzgq) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzgq.zzl(this.zztl.zzfw());
                    if (!this.zztl.zzfy()) {
                        zzfi2 = this.zztl.zzfi();
                    } else {
                        return;
                    }
                } while (zzfi2 == this.tag);
                this.zztn = zzfi2;
            } else if (i == 2) {
                int zzfz = this.zztl.zzfz() + this.zztl.zzfr();
                do {
                    zzgq.zzl(this.zztl.zzfw());
                } while (this.zztl.zzfz() < zzfz);
                zzab(zzfz);
            } else {
                throw zzgc.zzhv();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zztl.zzfw()));
                    if (!this.zztl.zzfy()) {
                        zzfi = this.zztl.zzfi();
                    } else {
                        return;
                    }
                } while (zzfi == this.tag);
                this.zztn = zzfi;
            } else if (i2 == 2) {
                int zzfz2 = this.zztl.zzfz() + this.zztl.zzfr();
                do {
                    list.add(Long.valueOf(this.zztl.zzfw()));
                } while (this.zztl.zzfz() < zzfz2);
                zzab(zzfz2);
            } else {
                throw zzgc.zzhv();
            }
        }
    }

    private static void zzz(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzgc.zzhx();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0053, code lost:
        if (zzgh() != false) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005d, code lost:
        throw new com.google.android.gms.internal.firebase_auth.zzgc("Unable to parse map entry.");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x004f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <K, V> void zza(java.util.Map<K, V> r6, com.google.android.gms.internal.firebase_auth.zzgv<K, V> r7, com.google.android.gms.internal.firebase_auth.zzfg r8) throws java.io.IOException {
        /*
            r5 = this;
            r0 = 2
            r5.zzy(r0)
            com.google.android.gms.internal.firebase_auth.zzet r0 = r5.zztl
            int r0 = r0.zzfr()
            com.google.android.gms.internal.firebase_auth.zzet r1 = r5.zztl
            int r0 = r1.zzp(r0)
            K r1 = r7.zzzd
            V r2 = r7.zzzf
        L_0x0014:
            int r3 = r5.zzgg()     // Catch:{ all -> 0x0067 }
            r4 = 2147483647(0x7fffffff, float:NaN)
            if (r3 == r4) goto L_0x005e
            com.google.android.gms.internal.firebase_auth.zzet r4 = r5.zztl     // Catch:{ all -> 0x0067 }
            boolean r4 = r4.zzfy()     // Catch:{ all -> 0x0067 }
            if (r4 != 0) goto L_0x005e
            switch(r3) {
                case 1: goto L_0x003b;
                case 2: goto L_0x002d;
                default: goto L_0x0028;
            }
        L_0x0028:
            boolean r3 = r5.zzgh()     // Catch:{ zzgd -> 0x004f }
            goto L_0x0044
        L_0x002d:
            com.google.android.gms.internal.firebase_auth.zzjf r3 = r7.zzze     // Catch:{ zzgd -> 0x004f }
            V r4 = r7.zzzf     // Catch:{ zzgd -> 0x004f }
            java.lang.Class r4 = r4.getClass()     // Catch:{ zzgd -> 0x004f }
            java.lang.Object r3 = r5.zza(r3, r4, r8)     // Catch:{ zzgd -> 0x004f }
            r2 = r3
            goto L_0x0014
        L_0x003b:
            com.google.android.gms.internal.firebase_auth.zzjf r3 = r7.zzzc     // Catch:{ zzgd -> 0x004f }
            r4 = 0
            java.lang.Object r3 = r5.zza(r3, r4, r4)     // Catch:{ zzgd -> 0x004f }
            r1 = r3
            goto L_0x0014
        L_0x0044:
            if (r3 == 0) goto L_0x0047
            goto L_0x0014
        L_0x0047:
            com.google.android.gms.internal.firebase_auth.zzgc r3 = new com.google.android.gms.internal.firebase_auth.zzgc     // Catch:{ zzgd -> 0x004f }
            java.lang.String r4 = "Unable to parse map entry."
            r3.<init>(r4)     // Catch:{ zzgd -> 0x004f }
            throw r3     // Catch:{ zzgd -> 0x004f }
        L_0x004f:
            boolean r3 = r5.zzgh()     // Catch:{ all -> 0x0067 }
            if (r3 == 0) goto L_0x0056
            goto L_0x0014
        L_0x0056:
            com.google.android.gms.internal.firebase_auth.zzgc r6 = new com.google.android.gms.internal.firebase_auth.zzgc     // Catch:{ all -> 0x0067 }
            java.lang.String r7 = "Unable to parse map entry."
            r6.<init>(r7)     // Catch:{ all -> 0x0067 }
            throw r6     // Catch:{ all -> 0x0067 }
        L_0x005e:
            r6.put(r1, r2)     // Catch:{ all -> 0x0067 }
            com.google.android.gms.internal.firebase_auth.zzet r6 = r5.zztl
            r6.zzq(r0)
            return
        L_0x0067:
            r6 = move-exception
            com.google.android.gms.internal.firebase_auth.zzet r7 = r5.zztl
            r7.zzq(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzey.zza(java.util.Map, com.google.android.gms.internal.firebase_auth.zzgv, com.google.android.gms.internal.firebase_auth.zzfg):void");
    }

    private final Object zza(zzjf zzjf, Class<?> cls, zzfg zzfg) throws IOException {
        switch (zzjf) {
            case BOOL:
                return Boolean.valueOf(zzfo());
            case BYTES:
                return zzfq();
            case DOUBLE:
                return Double.valueOf(readDouble());
            case ENUM:
                return Integer.valueOf(zzfs());
            case FIXED32:
                return Integer.valueOf(zzfn());
            case FIXED64:
                return Long.valueOf(zzfm());
            case FLOAT:
                return Float.valueOf(readFloat());
            case INT32:
                return Integer.valueOf(zzfl());
            case INT64:
                return Long.valueOf(zzfk());
            case MESSAGE:
                zzy(2);
                return zzc(zzho.zziu().zzf(cls), zzfg);
            case SFIXED32:
                return Integer.valueOf(zzft());
            case SFIXED64:
                return Long.valueOf(zzfu());
            case SINT32:
                return Integer.valueOf(zzfv());
            case SINT64:
                return Long.valueOf(zzfw());
            case STRING:
                return zzfp();
            case UINT32:
                return Integer.valueOf(zzfr());
            case UINT64:
                return Long.valueOf(zzfj());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static void zzaa(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzgc.zzhx();
        }
    }

    private final void zzab(int i) throws IOException {
        if (this.zztl.zzfz() != i) {
            throw zzgc.zzhq();
        }
    }
}
