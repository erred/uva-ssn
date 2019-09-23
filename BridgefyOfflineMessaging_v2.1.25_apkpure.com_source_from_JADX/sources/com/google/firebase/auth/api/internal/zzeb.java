package com.google.firebase.auth.api.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.firebase_auth.zzag;
import com.google.android.gms.internal.firebase_auth.zzai;
import com.google.android.gms.internal.firebase_auth.zzak;
import com.google.android.gms.internal.firebase_auth.zzam;
import com.google.android.gms.internal.firebase_auth.zzao;
import com.google.android.gms.internal.firebase_auth.zzaq;
import com.google.android.gms.internal.firebase_auth.zzas;
import com.google.android.gms.internal.firebase_auth.zzau;
import com.google.android.gms.internal.firebase_auth.zzaw;
import com.google.android.gms.internal.firebase_auth.zzay;
import com.google.android.gms.internal.firebase_auth.zzb;
import com.google.android.gms.internal.firebase_auth.zzba;
import com.google.android.gms.internal.firebase_auth.zzbc;
import com.google.android.gms.internal.firebase_auth.zzbe;
import com.google.android.gms.internal.firebase_auth.zzbg;
import com.google.android.gms.internal.firebase_auth.zzbi;
import com.google.android.gms.internal.firebase_auth.zzbk;
import com.google.android.gms.internal.firebase_auth.zzbm;
import com.google.android.gms.internal.firebase_auth.zzbo;
import com.google.android.gms.internal.firebase_auth.zzbq;
import com.google.android.gms.internal.firebase_auth.zzbs;
import com.google.android.gms.internal.firebase_auth.zzbu;
import com.google.android.gms.internal.firebase_auth.zzbw;
import com.google.android.gms.internal.firebase_auth.zzby;
import com.google.android.gms.internal.firebase_auth.zzc;
import com.google.android.gms.internal.firebase_auth.zzca;
import com.google.android.gms.internal.firebase_auth.zzcc;
import com.google.android.gms.internal.firebase_auth.zzce;
import com.google.android.gms.internal.firebase_auth.zzdj;
import com.google.android.gms.internal.firebase_auth.zzdr;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.UserProfileChangeRequest;

public abstract class zzeb extends zzb implements zzea {
    public zzeb() {
        super("com.google.firebase.auth.api.internal.IFirebaseAuthService");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzdx zzdx = null;
        switch (i) {
            case 1:
                String readString = parcel.readString();
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface;
                    } else {
                        zzdx = new zzdz(readStrongBinder);
                    }
                }
                zza(readString, zzdx);
                break;
            case 2:
                String readString2 = parcel.readString();
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface2 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface2;
                    } else {
                        zzdx = new zzdz(readStrongBinder2);
                    }
                }
                zzb(readString2, zzdx);
                break;
            case 3:
                zzdr zzdr = (zzdr) zzc.zza(parcel, zzdr.CREATOR);
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface3 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface3;
                    } else {
                        zzdx = new zzdz(readStrongBinder3);
                    }
                }
                zza(zzdr, zzdx);
                break;
            case 4:
                String readString3 = parcel.readString();
                UserProfileChangeRequest userProfileChangeRequest = (UserProfileChangeRequest) zzc.zza(parcel, UserProfileChangeRequest.CREATOR);
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface4 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface4;
                    } else {
                        zzdx = new zzdz(readStrongBinder4);
                    }
                }
                zza(readString3, userProfileChangeRequest, zzdx);
                break;
            case 5:
                String readString4 = parcel.readString();
                String readString5 = parcel.readString();
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface5 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface5;
                    } else {
                        zzdx = new zzdz(readStrongBinder5);
                    }
                }
                zza(readString4, readString5, zzdx);
                break;
            case 6:
                String readString6 = parcel.readString();
                String readString7 = parcel.readString();
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 != null) {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface6 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface6;
                    } else {
                        zzdx = new zzdz(readStrongBinder6);
                    }
                }
                zzb(readString6, readString7, zzdx);
                break;
            case 7:
                String readString8 = parcel.readString();
                String readString9 = parcel.readString();
                IBinder readStrongBinder7 = parcel.readStrongBinder();
                if (readStrongBinder7 != null) {
                    IInterface queryLocalInterface7 = readStrongBinder7.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface7 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface7;
                    } else {
                        zzdx = new zzdz(readStrongBinder7);
                    }
                }
                zzc(readString8, readString9, zzdx);
                break;
            case 8:
                String readString10 = parcel.readString();
                String readString11 = parcel.readString();
                IBinder readStrongBinder8 = parcel.readStrongBinder();
                if (readStrongBinder8 != null) {
                    IInterface queryLocalInterface8 = readStrongBinder8.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface8 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface8;
                    } else {
                        zzdx = new zzdz(readStrongBinder8);
                    }
                }
                zzd(readString10, readString11, zzdx);
                break;
            case 9:
                String readString12 = parcel.readString();
                IBinder readStrongBinder9 = parcel.readStrongBinder();
                if (readStrongBinder9 != null) {
                    IInterface queryLocalInterface9 = readStrongBinder9.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface9 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface9;
                    } else {
                        zzdx = new zzdz(readStrongBinder9);
                    }
                }
                zzc(readString12, zzdx);
                break;
            case 10:
                String readString13 = parcel.readString();
                IBinder readStrongBinder10 = parcel.readStrongBinder();
                if (readStrongBinder10 != null) {
                    IInterface queryLocalInterface10 = readStrongBinder10.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface10 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface10;
                    } else {
                        zzdx = new zzdz(readStrongBinder10);
                    }
                }
                zzd(readString13, zzdx);
                break;
            case 11:
                String readString14 = parcel.readString();
                String readString15 = parcel.readString();
                String readString16 = parcel.readString();
                IBinder readStrongBinder11 = parcel.readStrongBinder();
                if (readStrongBinder11 != null) {
                    IInterface queryLocalInterface11 = readStrongBinder11.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface11 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface11;
                    } else {
                        zzdx = new zzdz(readStrongBinder11);
                    }
                }
                zza(readString14, readString15, readString16, zzdx);
                break;
            case 12:
                String readString17 = parcel.readString();
                zzdr zzdr2 = (zzdr) zzc.zza(parcel, zzdr.CREATOR);
                IBinder readStrongBinder12 = parcel.readStrongBinder();
                if (readStrongBinder12 != null) {
                    IInterface queryLocalInterface12 = readStrongBinder12.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface12 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface12;
                    } else {
                        zzdx = new zzdz(readStrongBinder12);
                    }
                }
                zza(readString17, zzdr2, zzdx);
                break;
            case 13:
                String readString18 = parcel.readString();
                IBinder readStrongBinder13 = parcel.readStrongBinder();
                if (readStrongBinder13 != null) {
                    IInterface queryLocalInterface13 = readStrongBinder13.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface13 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface13;
                    } else {
                        zzdx = new zzdz(readStrongBinder13);
                    }
                }
                zze(readString18, zzdx);
                break;
            case 14:
                String readString19 = parcel.readString();
                String readString20 = parcel.readString();
                IBinder readStrongBinder14 = parcel.readStrongBinder();
                if (readStrongBinder14 != null) {
                    IInterface queryLocalInterface14 = readStrongBinder14.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface14 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface14;
                    } else {
                        zzdx = new zzdz(readStrongBinder14);
                    }
                }
                zze(readString19, readString20, zzdx);
                break;
            case 15:
                String readString21 = parcel.readString();
                IBinder readStrongBinder15 = parcel.readStrongBinder();
                if (readStrongBinder15 != null) {
                    IInterface queryLocalInterface15 = readStrongBinder15.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface15 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface15;
                    } else {
                        zzdx = new zzdz(readStrongBinder15);
                    }
                }
                zzf(readString21, zzdx);
                break;
            case 16:
                IBinder readStrongBinder16 = parcel.readStrongBinder();
                if (readStrongBinder16 != null) {
                    IInterface queryLocalInterface16 = readStrongBinder16.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface16 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface16;
                    } else {
                        zzdx = new zzdz(readStrongBinder16);
                    }
                }
                zza(zzdx);
                break;
            case 17:
                String readString22 = parcel.readString();
                IBinder readStrongBinder17 = parcel.readStrongBinder();
                if (readStrongBinder17 != null) {
                    IInterface queryLocalInterface17 = readStrongBinder17.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface17 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface17;
                    } else {
                        zzdx = new zzdz(readStrongBinder17);
                    }
                }
                zzg(readString22, zzdx);
                break;
            case 18:
                String readString23 = parcel.readString();
                IBinder readStrongBinder18 = parcel.readStrongBinder();
                if (readStrongBinder18 != null) {
                    IInterface queryLocalInterface18 = readStrongBinder18.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface18 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface18;
                    } else {
                        zzdx = new zzdz(readStrongBinder18);
                    }
                }
                zzh(readString23, zzdx);
                break;
            case 19:
                String readString24 = parcel.readString();
                IBinder readStrongBinder19 = parcel.readStrongBinder();
                if (readStrongBinder19 != null) {
                    IInterface queryLocalInterface19 = readStrongBinder19.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface19 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface19;
                    } else {
                        zzdx = new zzdz(readStrongBinder19);
                    }
                }
                zzi(readString24, zzdx);
                break;
            case 20:
                String readString25 = parcel.readString();
                IBinder readStrongBinder20 = parcel.readStrongBinder();
                if (readStrongBinder20 != null) {
                    IInterface queryLocalInterface20 = readStrongBinder20.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface20 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface20;
                    } else {
                        zzdx = new zzdz(readStrongBinder20);
                    }
                }
                zzj(readString25, zzdx);
                break;
            case 21:
                String readString26 = parcel.readString();
                String readString27 = parcel.readString();
                IBinder readStrongBinder21 = parcel.readStrongBinder();
                if (readStrongBinder21 != null) {
                    IInterface queryLocalInterface21 = readStrongBinder21.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface21 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface21;
                    } else {
                        zzdx = new zzdz(readStrongBinder21);
                    }
                }
                zzf(readString26, readString27, zzdx);
                break;
            case 22:
                zzdj zzdj = (zzdj) zzc.zza(parcel, zzdj.CREATOR);
                IBinder readStrongBinder22 = parcel.readStrongBinder();
                if (readStrongBinder22 != null) {
                    IInterface queryLocalInterface22 = readStrongBinder22.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface22 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface22;
                    } else {
                        zzdx = new zzdz(readStrongBinder22);
                    }
                }
                zza(zzdj, zzdx);
                break;
            case 23:
                PhoneAuthCredential phoneAuthCredential = (PhoneAuthCredential) zzc.zza(parcel, PhoneAuthCredential.CREATOR);
                IBinder readStrongBinder23 = parcel.readStrongBinder();
                if (readStrongBinder23 != null) {
                    IInterface queryLocalInterface23 = readStrongBinder23.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface23 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface23;
                    } else {
                        zzdx = new zzdz(readStrongBinder23);
                    }
                }
                zza(phoneAuthCredential, zzdx);
                break;
            case 24:
                String readString28 = parcel.readString();
                PhoneAuthCredential phoneAuthCredential2 = (PhoneAuthCredential) zzc.zza(parcel, PhoneAuthCredential.CREATOR);
                IBinder readStrongBinder24 = parcel.readStrongBinder();
                if (readStrongBinder24 != null) {
                    IInterface queryLocalInterface24 = readStrongBinder24.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface24 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface24;
                    } else {
                        zzdx = new zzdz(readStrongBinder24);
                    }
                }
                zza(readString28, phoneAuthCredential2, zzdx);
                break;
            case 25:
                String readString29 = parcel.readString();
                ActionCodeSettings actionCodeSettings = (ActionCodeSettings) zzc.zza(parcel, ActionCodeSettings.CREATOR);
                IBinder readStrongBinder25 = parcel.readStrongBinder();
                if (readStrongBinder25 != null) {
                    IInterface queryLocalInterface25 = readStrongBinder25.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface25 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface25;
                    } else {
                        zzdx = new zzdz(readStrongBinder25);
                    }
                }
                zza(readString29, actionCodeSettings, zzdx);
                break;
            case 26:
                String readString30 = parcel.readString();
                ActionCodeSettings actionCodeSettings2 = (ActionCodeSettings) zzc.zza(parcel, ActionCodeSettings.CREATOR);
                IBinder readStrongBinder26 = parcel.readStrongBinder();
                if (readStrongBinder26 != null) {
                    IInterface queryLocalInterface26 = readStrongBinder26.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface26 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface26;
                    } else {
                        zzdx = new zzdz(readStrongBinder26);
                    }
                }
                zzb(readString30, actionCodeSettings2, zzdx);
                break;
            case 27:
                String readString31 = parcel.readString();
                IBinder readStrongBinder27 = parcel.readStrongBinder();
                if (readStrongBinder27 != null) {
                    IInterface queryLocalInterface27 = readStrongBinder27.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface27 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface27;
                    } else {
                        zzdx = new zzdz(readStrongBinder27);
                    }
                }
                zzk(readString31, zzdx);
                break;
            case 28:
                String readString32 = parcel.readString();
                ActionCodeSettings actionCodeSettings3 = (ActionCodeSettings) zzc.zza(parcel, ActionCodeSettings.CREATOR);
                IBinder readStrongBinder28 = parcel.readStrongBinder();
                if (readStrongBinder28 != null) {
                    IInterface queryLocalInterface28 = readStrongBinder28.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface28 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface28;
                    } else {
                        zzdx = new zzdz(readStrongBinder28);
                    }
                }
                zzc(readString32, actionCodeSettings3, zzdx);
                break;
            case 29:
                EmailAuthCredential emailAuthCredential = (EmailAuthCredential) zzc.zza(parcel, EmailAuthCredential.CREATOR);
                IBinder readStrongBinder29 = parcel.readStrongBinder();
                if (readStrongBinder29 != null) {
                    IInterface queryLocalInterface29 = readStrongBinder29.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface29 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface29;
                    } else {
                        zzdx = new zzdz(readStrongBinder29);
                    }
                }
                zza(emailAuthCredential, zzdx);
                break;
            default:
                switch (i) {
                    case 101:
                        zzau zzau = (zzau) zzc.zza(parcel, zzau.CREATOR);
                        IBinder readStrongBinder30 = parcel.readStrongBinder();
                        if (readStrongBinder30 != null) {
                            IInterface queryLocalInterface30 = readStrongBinder30.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                            if (queryLocalInterface30 instanceof zzdx) {
                                zzdx = (zzdx) queryLocalInterface30;
                            } else {
                                zzdx = new zzdz(readStrongBinder30);
                            }
                        }
                        zza(zzau, zzdx);
                        break;
                    case 102:
                        zzbs zzbs = (zzbs) zzc.zza(parcel, zzbs.CREATOR);
                        IBinder readStrongBinder31 = parcel.readStrongBinder();
                        if (readStrongBinder31 != null) {
                            IInterface queryLocalInterface31 = readStrongBinder31.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                            if (queryLocalInterface31 instanceof zzdx) {
                                zzdx = (zzdx) queryLocalInterface31;
                            } else {
                                zzdx = new zzdz(readStrongBinder31);
                            }
                        }
                        zza(zzbs, zzdx);
                        break;
                    case 103:
                        zzbq zzbq = (zzbq) zzc.zza(parcel, zzbq.CREATOR);
                        IBinder readStrongBinder32 = parcel.readStrongBinder();
                        if (readStrongBinder32 != null) {
                            IInterface queryLocalInterface32 = readStrongBinder32.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                            if (queryLocalInterface32 instanceof zzdx) {
                                zzdx = (zzdx) queryLocalInterface32;
                            } else {
                                zzdx = new zzdz(readStrongBinder32);
                            }
                        }
                        zza(zzbq, zzdx);
                        break;
                    case 104:
                        zzce zzce = (zzce) zzc.zza(parcel, zzce.CREATOR);
                        IBinder readStrongBinder33 = parcel.readStrongBinder();
                        if (readStrongBinder33 != null) {
                            IInterface queryLocalInterface33 = readStrongBinder33.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                            if (queryLocalInterface33 instanceof zzdx) {
                                zzdx = (zzdx) queryLocalInterface33;
                            } else {
                                zzdx = new zzdz(readStrongBinder33);
                            }
                        }
                        zza(zzce, zzdx);
                        break;
                    case 105:
                        zzai zzai = (zzai) zzc.zza(parcel, zzai.CREATOR);
                        IBinder readStrongBinder34 = parcel.readStrongBinder();
                        if (readStrongBinder34 != null) {
                            IInterface queryLocalInterface34 = readStrongBinder34.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                            if (queryLocalInterface34 instanceof zzdx) {
                                zzdx = (zzdx) queryLocalInterface34;
                            } else {
                                zzdx = new zzdz(readStrongBinder34);
                            }
                        }
                        zza(zzai, zzdx);
                        break;
                    case 106:
                        zzak zzak = (zzak) zzc.zza(parcel, zzak.CREATOR);
                        IBinder readStrongBinder35 = parcel.readStrongBinder();
                        if (readStrongBinder35 != null) {
                            IInterface queryLocalInterface35 = readStrongBinder35.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                            if (queryLocalInterface35 instanceof zzdx) {
                                zzdx = (zzdx) queryLocalInterface35;
                            } else {
                                zzdx = new zzdz(readStrongBinder35);
                            }
                        }
                        zza(zzak, zzdx);
                        break;
                    case 107:
                        zzaq zzaq = (zzaq) zzc.zza(parcel, zzaq.CREATOR);
                        IBinder readStrongBinder36 = parcel.readStrongBinder();
                        if (readStrongBinder36 != null) {
                            IInterface queryLocalInterface36 = readStrongBinder36.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                            if (queryLocalInterface36 instanceof zzdx) {
                                zzdx = (zzdx) queryLocalInterface36;
                            } else {
                                zzdx = new zzdz(readStrongBinder36);
                            }
                        }
                        zza(zzaq, zzdx);
                        break;
                    case 108:
                        zzbu zzbu = (zzbu) zzc.zza(parcel, zzbu.CREATOR);
                        IBinder readStrongBinder37 = parcel.readStrongBinder();
                        if (readStrongBinder37 != null) {
                            IInterface queryLocalInterface37 = readStrongBinder37.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                            if (queryLocalInterface37 instanceof zzdx) {
                                zzdx = (zzdx) queryLocalInterface37;
                            } else {
                                zzdx = new zzdz(readStrongBinder37);
                            }
                        }
                        zza(zzbu, zzdx);
                        break;
                    case 109:
                        zzaw zzaw = (zzaw) zzc.zza(parcel, zzaw.CREATOR);
                        IBinder readStrongBinder38 = parcel.readStrongBinder();
                        if (readStrongBinder38 != null) {
                            IInterface queryLocalInterface38 = readStrongBinder38.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                            if (queryLocalInterface38 instanceof zzdx) {
                                zzdx = (zzdx) queryLocalInterface38;
                            } else {
                                zzdx = new zzdz(readStrongBinder38);
                            }
                        }
                        zza(zzaw, zzdx);
                        break;
                    default:
                        switch (i) {
                            case 111:
                                zzay zzay = (zzay) zzc.zza(parcel, zzay.CREATOR);
                                IBinder readStrongBinder39 = parcel.readStrongBinder();
                                if (readStrongBinder39 != null) {
                                    IInterface queryLocalInterface39 = readStrongBinder39.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                    if (queryLocalInterface39 instanceof zzdx) {
                                        zzdx = (zzdx) queryLocalInterface39;
                                    } else {
                                        zzdx = new zzdz(readStrongBinder39);
                                    }
                                }
                                zza(zzay, zzdx);
                                break;
                            case 112:
                                zzba zzba = (zzba) zzc.zza(parcel, zzba.CREATOR);
                                IBinder readStrongBinder40 = parcel.readStrongBinder();
                                if (readStrongBinder40 != null) {
                                    IInterface queryLocalInterface40 = readStrongBinder40.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                    if (queryLocalInterface40 instanceof zzdx) {
                                        zzdx = (zzdx) queryLocalInterface40;
                                    } else {
                                        zzdx = new zzdz(readStrongBinder40);
                                    }
                                }
                                zza(zzba, zzdx);
                                break;
                            case 113:
                                zzca zzca = (zzca) zzc.zza(parcel, zzca.CREATOR);
                                IBinder readStrongBinder41 = parcel.readStrongBinder();
                                if (readStrongBinder41 != null) {
                                    IInterface queryLocalInterface41 = readStrongBinder41.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                    if (queryLocalInterface41 instanceof zzdx) {
                                        zzdx = (zzdx) queryLocalInterface41;
                                    } else {
                                        zzdx = new zzdz(readStrongBinder41);
                                    }
                                }
                                zza(zzca, zzdx);
                                break;
                            case 114:
                                zzcc zzcc = (zzcc) zzc.zza(parcel, zzcc.CREATOR);
                                IBinder readStrongBinder42 = parcel.readStrongBinder();
                                if (readStrongBinder42 != null) {
                                    IInterface queryLocalInterface42 = readStrongBinder42.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                    if (queryLocalInterface42 instanceof zzdx) {
                                        zzdx = (zzdx) queryLocalInterface42;
                                    } else {
                                        zzdx = new zzdz(readStrongBinder42);
                                    }
                                }
                                zza(zzcc, zzdx);
                                break;
                            case 115:
                                zzbe zzbe = (zzbe) zzc.zza(parcel, zzbe.CREATOR);
                                IBinder readStrongBinder43 = parcel.readStrongBinder();
                                if (readStrongBinder43 != null) {
                                    IInterface queryLocalInterface43 = readStrongBinder43.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                    if (queryLocalInterface43 instanceof zzdx) {
                                        zzdx = (zzdx) queryLocalInterface43;
                                    } else {
                                        zzdx = new zzdz(readStrongBinder43);
                                    }
                                }
                                zza(zzbe, zzdx);
                                break;
                            case 116:
                                zzbo zzbo = (zzbo) zzc.zza(parcel, zzbo.CREATOR);
                                IBinder readStrongBinder44 = parcel.readStrongBinder();
                                if (readStrongBinder44 != null) {
                                    IInterface queryLocalInterface44 = readStrongBinder44.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                    if (queryLocalInterface44 instanceof zzdx) {
                                        zzdx = (zzdx) queryLocalInterface44;
                                    } else {
                                        zzdx = new zzdz(readStrongBinder44);
                                    }
                                }
                                zza(zzbo, zzdx);
                                break;
                            case 117:
                                zzas zzas = (zzas) zzc.zza(parcel, zzas.CREATOR);
                                IBinder readStrongBinder45 = parcel.readStrongBinder();
                                if (readStrongBinder45 != null) {
                                    IInterface queryLocalInterface45 = readStrongBinder45.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                    if (queryLocalInterface45 instanceof zzdx) {
                                        zzdx = (zzdx) queryLocalInterface45;
                                    } else {
                                        zzdx = new zzdz(readStrongBinder45);
                                    }
                                }
                                zza(zzas, zzdx);
                                break;
                            default:
                                switch (i) {
                                    case 119:
                                        zzam zzam = (zzam) zzc.zza(parcel, zzam.CREATOR);
                                        IBinder readStrongBinder46 = parcel.readStrongBinder();
                                        if (readStrongBinder46 != null) {
                                            IInterface queryLocalInterface46 = readStrongBinder46.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                            if (queryLocalInterface46 instanceof zzdx) {
                                                zzdx = (zzdx) queryLocalInterface46;
                                            } else {
                                                zzdx = new zzdz(readStrongBinder46);
                                            }
                                        }
                                        zza(zzam, zzdx);
                                        break;
                                    case 120:
                                        zzag zzag = (zzag) zzc.zza(parcel, zzag.CREATOR);
                                        IBinder readStrongBinder47 = parcel.readStrongBinder();
                                        if (readStrongBinder47 != null) {
                                            IInterface queryLocalInterface47 = readStrongBinder47.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                            if (queryLocalInterface47 instanceof zzdx) {
                                                zzdx = (zzdx) queryLocalInterface47;
                                            } else {
                                                zzdx = new zzdz(readStrongBinder47);
                                            }
                                        }
                                        zza(zzag, zzdx);
                                        break;
                                    case 121:
                                        zzao zzao = (zzao) zzc.zza(parcel, zzao.CREATOR);
                                        IBinder readStrongBinder48 = parcel.readStrongBinder();
                                        if (readStrongBinder48 != null) {
                                            IInterface queryLocalInterface48 = readStrongBinder48.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                            if (queryLocalInterface48 instanceof zzdx) {
                                                zzdx = (zzdx) queryLocalInterface48;
                                            } else {
                                                zzdx = new zzdz(readStrongBinder48);
                                            }
                                        }
                                        zza(zzao, zzdx);
                                        break;
                                    case 122:
                                        zzbk zzbk = (zzbk) zzc.zza(parcel, zzbk.CREATOR);
                                        IBinder readStrongBinder49 = parcel.readStrongBinder();
                                        if (readStrongBinder49 != null) {
                                            IInterface queryLocalInterface49 = readStrongBinder49.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                            if (queryLocalInterface49 instanceof zzdx) {
                                                zzdx = (zzdx) queryLocalInterface49;
                                            } else {
                                                zzdx = new zzdz(readStrongBinder49);
                                            }
                                        }
                                        zza(zzbk, zzdx);
                                        break;
                                    case 123:
                                        zzby zzby = (zzby) zzc.zza(parcel, zzby.CREATOR);
                                        IBinder readStrongBinder50 = parcel.readStrongBinder();
                                        if (readStrongBinder50 != null) {
                                            IInterface queryLocalInterface50 = readStrongBinder50.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                            if (queryLocalInterface50 instanceof zzdx) {
                                                zzdx = (zzdx) queryLocalInterface50;
                                            } else {
                                                zzdx = new zzdz(readStrongBinder50);
                                            }
                                        }
                                        zza(zzby, zzdx);
                                        break;
                                    case 124:
                                        zzbc zzbc = (zzbc) zzc.zza(parcel, zzbc.CREATOR);
                                        IBinder readStrongBinder51 = parcel.readStrongBinder();
                                        if (readStrongBinder51 != null) {
                                            IInterface queryLocalInterface51 = readStrongBinder51.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                            if (queryLocalInterface51 instanceof zzdx) {
                                                zzdx = (zzdx) queryLocalInterface51;
                                            } else {
                                                zzdx = new zzdz(readStrongBinder51);
                                            }
                                        }
                                        zza(zzbc, zzdx);
                                        break;
                                    default:
                                        switch (i) {
                                            case 126:
                                                zzbg zzbg = (zzbg) zzc.zza(parcel, zzbg.CREATOR);
                                                IBinder readStrongBinder52 = parcel.readStrongBinder();
                                                if (readStrongBinder52 != null) {
                                                    IInterface queryLocalInterface52 = readStrongBinder52.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                                    if (queryLocalInterface52 instanceof zzdx) {
                                                        zzdx = (zzdx) queryLocalInterface52;
                                                    } else {
                                                        zzdx = new zzdz(readStrongBinder52);
                                                    }
                                                }
                                                zza(zzbg, zzdx);
                                                break;
                                            case 127:
                                                zzbm zzbm = (zzbm) zzc.zza(parcel, zzbm.CREATOR);
                                                IBinder readStrongBinder53 = parcel.readStrongBinder();
                                                if (readStrongBinder53 != null) {
                                                    IInterface queryLocalInterface53 = readStrongBinder53.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                                    if (queryLocalInterface53 instanceof zzdx) {
                                                        zzdx = (zzdx) queryLocalInterface53;
                                                    } else {
                                                        zzdx = new zzdz(readStrongBinder53);
                                                    }
                                                }
                                                zza(zzbm, zzdx);
                                                break;
                                            case 128:
                                                zzbi zzbi = (zzbi) zzc.zza(parcel, zzbi.CREATOR);
                                                IBinder readStrongBinder54 = parcel.readStrongBinder();
                                                if (readStrongBinder54 != null) {
                                                    IInterface queryLocalInterface54 = readStrongBinder54.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                                    if (queryLocalInterface54 instanceof zzdx) {
                                                        zzdx = (zzdx) queryLocalInterface54;
                                                    } else {
                                                        zzdx = new zzdz(readStrongBinder54);
                                                    }
                                                }
                                                zza(zzbi, zzdx);
                                                break;
                                            case 129:
                                                zzbw zzbw = (zzbw) zzc.zza(parcel, zzbw.CREATOR);
                                                IBinder readStrongBinder55 = parcel.readStrongBinder();
                                                if (readStrongBinder55 != null) {
                                                    IInterface queryLocalInterface55 = readStrongBinder55.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                                    if (queryLocalInterface55 instanceof zzdx) {
                                                        zzdx = (zzdx) queryLocalInterface55;
                                                    } else {
                                                        zzdx = new zzdz(readStrongBinder55);
                                                    }
                                                }
                                                zza(zzbw, zzdx);
                                                break;
                                            default:
                                                return false;
                                        }
                                }
                        }
                }
        }
        parcel2.writeNoException();
        return true;
    }
}
