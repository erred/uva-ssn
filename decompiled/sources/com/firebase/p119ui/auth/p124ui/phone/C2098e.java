package com.firebase.p119ui.auth.p124ui.phone;

import android.os.AsyncTask;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import net.sqlcipher.database.SQLiteDatabase;
import twitter4j.HttpResponseCode;

/* renamed from: com.firebase.ui.auth.ui.phone.e */
/* compiled from: CountryListLoadTask */
final class C2098e extends AsyncTask<Void, Void, List<C2096c>> {

    /* renamed from: a */
    private final C2099a f6445a;

    /* renamed from: com.firebase.ui.auth.ui.phone.e$a */
    /* compiled from: CountryListLoadTask */
    public interface C2099a {
        /* renamed from: a */
        void mo11912a(List<C2096c> list);
    }

    public C2098e(C2099a aVar) {
        this.f6445a = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public List<C2096c> doInBackground(Void... voidArr) {
        ArrayList arrayList = new ArrayList(291);
        arrayList.add(new C2096c(new Locale("", "AF"), 93));
        arrayList.add(new C2096c(new Locale("", "AX"), 358));
        arrayList.add(new C2096c(new Locale("", "AL"), 355));
        arrayList.add(new C2096c(new Locale("", "DZ"), 213));
        arrayList.add(new C2096c(new Locale("", "AS"), 1));
        arrayList.add(new C2096c(new Locale("", "AD"), 376));
        arrayList.add(new C2096c(new Locale("", "AO"), 244));
        arrayList.add(new C2096c(new Locale("", "AI"), 1));
        arrayList.add(new C2096c(new Locale("", "AG"), 1));
        arrayList.add(new C2096c(new Locale("", "AR"), 54));
        arrayList.add(new C2096c(new Locale("", "AM"), 374));
        arrayList.add(new C2096c(new Locale("", "AW"), 297));
        arrayList.add(new C2096c(new Locale("", "AC"), 247));
        arrayList.add(new C2096c(new Locale("", "AU"), 61));
        arrayList.add(new C2096c(new Locale("", "AT"), 43));
        arrayList.add(new C2096c(new Locale("", "AZ"), 994));
        arrayList.add(new C2096c(new Locale("", "BS"), 1));
        arrayList.add(new C2096c(new Locale("", "BH"), 973));
        arrayList.add(new C2096c(new Locale("", "BD"), 880));
        arrayList.add(new C2096c(new Locale("", "BB"), 1));
        arrayList.add(new C2096c(new Locale("", "BY"), 375));
        arrayList.add(new C2096c(new Locale("", "BE"), 32));
        arrayList.add(new C2096c(new Locale("", "BZ"), 501));
        arrayList.add(new C2096c(new Locale("", "BJ"), 229));
        arrayList.add(new C2096c(new Locale("", "BM"), 1));
        arrayList.add(new C2096c(new Locale("", "BT"), 975));
        arrayList.add(new C2096c(new Locale("", "BO"), 591));
        arrayList.add(new C2096c(new Locale("", "BA"), 387));
        arrayList.add(new C2096c(new Locale("", "BW"), 267));
        arrayList.add(new C2096c(new Locale("", "BR"), 55));
        arrayList.add(new C2096c(new Locale("", "IO"), 246));
        arrayList.add(new C2096c(new Locale("", "VG"), 1));
        arrayList.add(new C2096c(new Locale("", "BN"), 673));
        arrayList.add(new C2096c(new Locale("", "BG"), 359));
        arrayList.add(new C2096c(new Locale("", "BF"), 226));
        arrayList.add(new C2096c(new Locale("", "BI"), 257));
        arrayList.add(new C2096c(new Locale("", "KH"), 855));
        arrayList.add(new C2096c(new Locale("", "CM"), 237));
        arrayList.add(new C2096c(new Locale("", "CA"), 1));
        arrayList.add(new C2096c(new Locale("", "CV"), 238));
        arrayList.add(new C2096c(new Locale("", "BQ"), 599));
        arrayList.add(new C2096c(new Locale("", "KY"), 1));
        arrayList.add(new C2096c(new Locale("", "CF"), 236));
        arrayList.add(new C2096c(new Locale("", "TD"), 235));
        arrayList.add(new C2096c(new Locale("", "CL"), 56));
        arrayList.add(new C2096c(new Locale("", "CN"), 86));
        arrayList.add(new C2096c(new Locale("", "CX"), 61));
        arrayList.add(new C2096c(new Locale("", "CC"), 61));
        arrayList.add(new C2096c(new Locale("", "CO"), 57));
        arrayList.add(new C2096c(new Locale("", "KM"), 269));
        arrayList.add(new C2096c(new Locale("", "CD"), 243));
        arrayList.add(new C2096c(new Locale("", "CG"), 242));
        arrayList.add(new C2096c(new Locale("", "CK"), 682));
        arrayList.add(new C2096c(new Locale("", "CR"), 506));
        arrayList.add(new C2096c(new Locale("", "CI"), 225));
        arrayList.add(new C2096c(new Locale("", "HR"), 385));
        arrayList.add(new C2096c(new Locale("", "CU"), 53));
        arrayList.add(new C2096c(new Locale("", "CW"), 599));
        arrayList.add(new C2096c(new Locale("", "CY"), 357));
        arrayList.add(new C2096c(new Locale("", "CZ"), HttpResponseCode.ENHANCE_YOUR_CLAIM));
        arrayList.add(new C2096c(new Locale("", "DK"), 45));
        arrayList.add(new C2096c(new Locale("", "DJ"), 253));
        arrayList.add(new C2096c(new Locale("", "DM"), 1));
        arrayList.add(new C2096c(new Locale("", "DO"), 1));
        arrayList.add(new C2096c(new Locale("", "TL"), 670));
        arrayList.add(new C2096c(new Locale("", "EC"), 593));
        arrayList.add(new C2096c(new Locale("", "EG"), 20));
        arrayList.add(new C2096c(new Locale("", "SV"), 503));
        arrayList.add(new C2096c(new Locale("", "GQ"), 240));
        arrayList.add(new C2096c(new Locale("", "ER"), 291));
        arrayList.add(new C2096c(new Locale("", "EE"), 372));
        arrayList.add(new C2096c(new Locale("", "ET"), 251));
        arrayList.add(new C2096c(new Locale("", "FK"), 500));
        arrayList.add(new C2096c(new Locale("", "FO"), 298));
        arrayList.add(new C2096c(new Locale("", "FJ"), 679));
        arrayList.add(new C2096c(new Locale("", "FI"), 358));
        arrayList.add(new C2096c(new Locale("", "FR"), 33));
        arrayList.add(new C2096c(new Locale("", "GF"), 594));
        arrayList.add(new C2096c(new Locale("", "PF"), 689));
        arrayList.add(new C2096c(new Locale("", "GA"), 241));
        arrayList.add(new C2096c(new Locale("", "GM"), 220));
        arrayList.add(new C2096c(new Locale("", "GE"), 995));
        arrayList.add(new C2096c(new Locale("", "DE"), 49));
        arrayList.add(new C2096c(new Locale("", "GH"), 233));
        arrayList.add(new C2096c(new Locale("", "GI"), 350));
        arrayList.add(new C2096c(new Locale("", "GR"), 30));
        arrayList.add(new C2096c(new Locale("", "GL"), 299));
        arrayList.add(new C2096c(new Locale("", "GD"), 1));
        arrayList.add(new C2096c(new Locale("", "GP"), 590));
        arrayList.add(new C2096c(new Locale("", "GU"), 1));
        arrayList.add(new C2096c(new Locale("", "GT"), 502));
        arrayList.add(new C2096c(new Locale("", "GG"), 44));
        arrayList.add(new C2096c(new Locale("", "GN"), 224));
        arrayList.add(new C2096c(new Locale("", "GW"), 245));
        arrayList.add(new C2096c(new Locale("", "GY"), 592));
        arrayList.add(new C2096c(new Locale("", "HT"), 509));
        arrayList.add(new C2096c(new Locale("", "HM"), 672));
        arrayList.add(new C2096c(new Locale("", "HN"), HttpResponseCode.GATEWAY_TIMEOUT));
        arrayList.add(new C2096c(new Locale("", "HK"), 852));
        arrayList.add(new C2096c(new Locale("", "HU"), 36));
        arrayList.add(new C2096c(new Locale("", "IS"), 354));
        arrayList.add(new C2096c(new Locale("", "IN"), 91));
        arrayList.add(new C2096c(new Locale("", "ID"), 62));
        arrayList.add(new C2096c(new Locale("", "IR"), 98));
        arrayList.add(new C2096c(new Locale("", "IQ"), 964));
        arrayList.add(new C2096c(new Locale("", "IE"), 353));
        arrayList.add(new C2096c(new Locale("", "IM"), 44));
        arrayList.add(new C2096c(new Locale("", "IL"), 972));
        arrayList.add(new C2096c(new Locale("", "IT"), 39));
        arrayList.add(new C2096c(new Locale("", "JM"), 1));
        arrayList.add(new C2096c(new Locale("", "JP"), 81));
        arrayList.add(new C2096c(new Locale("", "JE"), 44));
        arrayList.add(new C2096c(new Locale("", "JO"), 962));
        arrayList.add(new C2096c(new Locale("", "KZ"), 7));
        arrayList.add(new C2096c(new Locale("", "KE"), 254));
        arrayList.add(new C2096c(new Locale("", "KI"), 686));
        arrayList.add(new C2096c(new Locale("", "XK"), 381));
        arrayList.add(new C2096c(new Locale("", "KW"), 965));
        arrayList.add(new C2096c(new Locale("", "KG"), 996));
        arrayList.add(new C2096c(new Locale("", "LA"), 856));
        arrayList.add(new C2096c(new Locale("", "LV"), 371));
        arrayList.add(new C2096c(new Locale("", "LB"), 961));
        arrayList.add(new C2096c(new Locale("", "LS"), 266));
        arrayList.add(new C2096c(new Locale("", "LR"), 231));
        arrayList.add(new C2096c(new Locale("", "LY"), 218));
        arrayList.add(new C2096c(new Locale("", "LI"), 423));
        arrayList.add(new C2096c(new Locale("", "LT"), 370));
        arrayList.add(new C2096c(new Locale("", "LU"), 352));
        arrayList.add(new C2096c(new Locale("", "MO"), 853));
        arrayList.add(new C2096c(new Locale("", "MK"), 389));
        arrayList.add(new C2096c(new Locale("", "MG"), 261));
        arrayList.add(new C2096c(new Locale("", "MW"), 265));
        arrayList.add(new C2096c(new Locale("", "MY"), 60));
        arrayList.add(new C2096c(new Locale("", "MV"), 960));
        arrayList.add(new C2096c(new Locale("", "ML"), 223));
        arrayList.add(new C2096c(new Locale("", "MT"), 356));
        arrayList.add(new C2096c(new Locale("", "MH"), 692));
        arrayList.add(new C2096c(new Locale("", "MQ"), 596));
        arrayList.add(new C2096c(new Locale("", "MR"), 222));
        arrayList.add(new C2096c(new Locale("", "MU"), 230));
        arrayList.add(new C2096c(new Locale("", "YT"), 262));
        arrayList.add(new C2096c(new Locale("", "MX"), 52));
        arrayList.add(new C2096c(new Locale("", "FM"), 691));
        arrayList.add(new C2096c(new Locale("", "MD"), 373));
        arrayList.add(new C2096c(new Locale("", "MC"), 377));
        arrayList.add(new C2096c(new Locale("", "MN"), 976));
        arrayList.add(new C2096c(new Locale("", "ME"), 382));
        arrayList.add(new C2096c(new Locale("", "MS"), 1));
        arrayList.add(new C2096c(new Locale("", "MA"), 212));
        arrayList.add(new C2096c(new Locale("", "MZ"), 258));
        arrayList.add(new C2096c(new Locale("", "MM"), 95));
        arrayList.add(new C2096c(new Locale("", "NA"), 264));
        arrayList.add(new C2096c(new Locale("", "NR"), 674));
        arrayList.add(new C2096c(new Locale("", "NP"), 977));
        arrayList.add(new C2096c(new Locale("", "NL"), 31));
        arrayList.add(new C2096c(new Locale("", "NC"), 687));
        arrayList.add(new C2096c(new Locale("", "NZ"), 64));
        arrayList.add(new C2096c(new Locale("", "NI"), 505));
        arrayList.add(new C2096c(new Locale("", "NE"), 227));
        arrayList.add(new C2096c(new Locale("", "NG"), 234));
        arrayList.add(new C2096c(new Locale("", "NU"), 683));
        arrayList.add(new C2096c(new Locale("", "NF"), 672));
        arrayList.add(new C2096c(new Locale("", "KP"), 850));
        arrayList.add(new C2096c(new Locale("", "MP"), 1));
        arrayList.add(new C2096c(new Locale("", "NO"), 47));
        arrayList.add(new C2096c(new Locale("", "OM"), 968));
        arrayList.add(new C2096c(new Locale("", "PK"), 92));
        arrayList.add(new C2096c(new Locale("", "PW"), 680));
        arrayList.add(new C2096c(new Locale("", "PS"), 970));
        arrayList.add(new C2096c(new Locale("", "PA"), 507));
        arrayList.add(new C2096c(new Locale("", "PG"), 675));
        arrayList.add(new C2096c(new Locale("", "PY"), 595));
        arrayList.add(new C2096c(new Locale("", "PE"), 51));
        arrayList.add(new C2096c(new Locale("", "PH"), 63));
        arrayList.add(new C2096c(new Locale("", "PL"), 48));
        arrayList.add(new C2096c(new Locale("", "PT"), 351));
        arrayList.add(new C2096c(new Locale("", "PR"), 1));
        arrayList.add(new C2096c(new Locale("", "QA"), 974));
        arrayList.add(new C2096c(new Locale("", "RE"), 262));
        arrayList.add(new C2096c(new Locale("", "RO"), 40));
        arrayList.add(new C2096c(new Locale("", "RU"), 7));
        arrayList.add(new C2096c(new Locale("", "RW"), SQLiteDatabase.MAX_SQL_CACHE_SIZE));
        arrayList.add(new C2096c(new Locale("", "BL"), 590));
        arrayList.add(new C2096c(new Locale("", "SH"), 290));
        arrayList.add(new C2096c(new Locale("", "KN"), 1));
        arrayList.add(new C2096c(new Locale("", "LC"), 1));
        arrayList.add(new C2096c(new Locale("", "MF"), 590));
        arrayList.add(new C2096c(new Locale("", "PM"), 508));
        arrayList.add(new C2096c(new Locale("", "VC"), 1));
        arrayList.add(new C2096c(new Locale("", "WS"), 685));
        arrayList.add(new C2096c(new Locale("", "SM"), 378));
        arrayList.add(new C2096c(new Locale("", "ST"), 239));
        arrayList.add(new C2096c(new Locale("", "SA"), 966));
        arrayList.add(new C2096c(new Locale("", "SN"), 221));
        arrayList.add(new C2096c(new Locale("", "RS"), 381));
        arrayList.add(new C2096c(new Locale("", "SC"), 248));
        arrayList.add(new C2096c(new Locale("", "SL"), 232));
        arrayList.add(new C2096c(new Locale("", "SG"), 65));
        arrayList.add(new C2096c(new Locale("", "SX"), 1));
        arrayList.add(new C2096c(new Locale("", "SK"), 421));
        arrayList.add(new C2096c(new Locale("", "SI"), 386));
        arrayList.add(new C2096c(new Locale("", "SB"), 677));
        arrayList.add(new C2096c(new Locale("", "SO"), 252));
        arrayList.add(new C2096c(new Locale("", "ZA"), 27));
        arrayList.add(new C2096c(new Locale("", "GS"), 500));
        arrayList.add(new C2096c(new Locale("", "KR"), 82));
        arrayList.add(new C2096c(new Locale("", "SS"), 211));
        arrayList.add(new C2096c(new Locale("", "ES"), 34));
        arrayList.add(new C2096c(new Locale("", "LK"), 94));
        arrayList.add(new C2096c(new Locale("", "SD"), 249));
        arrayList.add(new C2096c(new Locale("", "SR"), 597));
        arrayList.add(new C2096c(new Locale("", "SJ"), 47));
        arrayList.add(new C2096c(new Locale("", "SZ"), 268));
        arrayList.add(new C2096c(new Locale("", "SE"), 46));
        arrayList.add(new C2096c(new Locale("", "CH"), 41));
        arrayList.add(new C2096c(new Locale("", "SY"), 963));
        arrayList.add(new C2096c(new Locale("", "TW"), 886));
        arrayList.add(new C2096c(new Locale("", "TJ"), 992));
        arrayList.add(new C2096c(new Locale("", "TZ"), 255));
        arrayList.add(new C2096c(new Locale("", "TH"), 66));
        arrayList.add(new C2096c(new Locale("", "TG"), 228));
        arrayList.add(new C2096c(new Locale("", "TK"), 690));
        arrayList.add(new C2096c(new Locale("", "TO"), 676));
        arrayList.add(new C2096c(new Locale("", "TT"), 1));
        arrayList.add(new C2096c(new Locale("", "TN"), 216));
        arrayList.add(new C2096c(new Locale("", "TR"), 90));
        arrayList.add(new C2096c(new Locale("", "TM"), 993));
        arrayList.add(new C2096c(new Locale("", "TC"), 1));
        arrayList.add(new C2096c(new Locale("", "TV"), 688));
        arrayList.add(new C2096c(new Locale("", "VI"), 1));
        arrayList.add(new C2096c(new Locale("", "UG"), 256));
        arrayList.add(new C2096c(new Locale("", "UA"), 380));
        arrayList.add(new C2096c(new Locale("", "AE"), 971));
        arrayList.add(new C2096c(new Locale("", "GB"), 44));
        arrayList.add(new C2096c(new Locale("", "US"), 1));
        arrayList.add(new C2096c(new Locale("", "UY"), 598));
        arrayList.add(new C2096c(new Locale("", "UZ"), 998));
        arrayList.add(new C2096c(new Locale("", "VU"), 678));
        arrayList.add(new C2096c(new Locale("", "VA"), 379));
        arrayList.add(new C2096c(new Locale("", "VE"), 58));
        arrayList.add(new C2096c(new Locale("", "VN"), 84));
        arrayList.add(new C2096c(new Locale("", "WF"), 681));
        arrayList.add(new C2096c(new Locale("", "EH"), 212));
        arrayList.add(new C2096c(new Locale("", "YE"), 967));
        arrayList.add(new C2096c(new Locale("", "ZM"), 260));
        arrayList.add(new C2096c(new Locale("", "ZW"), 263));
        Collections.sort(arrayList);
        return arrayList;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(List<C2096c> list) {
        if (this.f6445a != null) {
            this.f6445a.mo11912a(list);
        }
    }
}
