package p140me.bridgefy.intro.verification;

import android.os.AsyncTask;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import net.sqlcipher.database.SQLiteDatabase;
import twitter4j.HttpResponseCode;

/* renamed from: me.bridgefy.intro.verification.d */
/* compiled from: CountryListLoadTask */
final class C3577d extends AsyncTask<Void, Void, List<C3574b>> {

    /* renamed from: a */
    private final C3578a f9397a;

    /* renamed from: me.bridgefy.intro.verification.d$a */
    /* compiled from: CountryListLoadTask */
    public interface C3578a {
        /* renamed from: a */
        void mo29467a(List<C3574b> list);
    }

    public C3577d(C3578a aVar) {
        this.f9397a = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public List<C3574b> doInBackground(Void... voidArr) {
        ArrayList arrayList = new ArrayList(291);
        arrayList.add(new C3574b(new Locale("", "AF"), 93));
        arrayList.add(new C3574b(new Locale("", "AX"), 358));
        arrayList.add(new C3574b(new Locale("", "AL"), 355));
        arrayList.add(new C3574b(new Locale("", "DZ"), 213));
        arrayList.add(new C3574b(new Locale("", "AS"), 1));
        arrayList.add(new C3574b(new Locale("", "AD"), 376));
        arrayList.add(new C3574b(new Locale("", "AO"), 244));
        arrayList.add(new C3574b(new Locale("", "AI"), 1));
        arrayList.add(new C3574b(new Locale("", "AG"), 1));
        arrayList.add(new C3574b(new Locale("", "AR"), 54));
        arrayList.add(new C3574b(new Locale("", "AM"), 374));
        arrayList.add(new C3574b(new Locale("", "AW"), 297));
        arrayList.add(new C3574b(new Locale("", "AC"), 247));
        arrayList.add(new C3574b(new Locale("", "AU"), 61));
        arrayList.add(new C3574b(new Locale("", "AT"), 43));
        arrayList.add(new C3574b(new Locale("", "AZ"), 994));
        arrayList.add(new C3574b(new Locale("", "BS"), 1));
        arrayList.add(new C3574b(new Locale("", "BH"), 973));
        arrayList.add(new C3574b(new Locale("", "BD"), 880));
        arrayList.add(new C3574b(new Locale("", "BB"), 1));
        arrayList.add(new C3574b(new Locale("", "BY"), 375));
        arrayList.add(new C3574b(new Locale("", "BE"), 32));
        arrayList.add(new C3574b(new Locale("", "BZ"), 501));
        arrayList.add(new C3574b(new Locale("", "BJ"), 229));
        arrayList.add(new C3574b(new Locale("", "BM"), 1));
        arrayList.add(new C3574b(new Locale("", "BT"), 975));
        arrayList.add(new C3574b(new Locale("", "BO"), 591));
        arrayList.add(new C3574b(new Locale("", "BA"), 387));
        arrayList.add(new C3574b(new Locale("", "BW"), 267));
        arrayList.add(new C3574b(new Locale("", "BR"), 55));
        arrayList.add(new C3574b(new Locale("", "IO"), 246));
        arrayList.add(new C3574b(new Locale("", "VG"), 1));
        arrayList.add(new C3574b(new Locale("", "BN"), 673));
        arrayList.add(new C3574b(new Locale("", "BG"), 359));
        arrayList.add(new C3574b(new Locale("", "BF"), 226));
        arrayList.add(new C3574b(new Locale("", "BI"), 257));
        arrayList.add(new C3574b(new Locale("", "KH"), 855));
        arrayList.add(new C3574b(new Locale("", "CM"), 237));
        arrayList.add(new C3574b(new Locale("", "CA"), 1));
        arrayList.add(new C3574b(new Locale("", "CV"), 238));
        arrayList.add(new C3574b(new Locale("", "BQ"), 599));
        arrayList.add(new C3574b(new Locale("", "KY"), 1));
        arrayList.add(new C3574b(new Locale("", "CF"), 236));
        arrayList.add(new C3574b(new Locale("", "TD"), 235));
        arrayList.add(new C3574b(new Locale("", "CL"), 56));
        arrayList.add(new C3574b(new Locale("", "CN"), 86));
        arrayList.add(new C3574b(new Locale("", "CX"), 61));
        arrayList.add(new C3574b(new Locale("", "CC"), 61));
        arrayList.add(new C3574b(new Locale("", "CO"), 57));
        arrayList.add(new C3574b(new Locale("", "KM"), 269));
        arrayList.add(new C3574b(new Locale("", "CD"), 243));
        arrayList.add(new C3574b(new Locale("", "CG"), 242));
        arrayList.add(new C3574b(new Locale("", "CK"), 682));
        arrayList.add(new C3574b(new Locale("", "CR"), 506));
        arrayList.add(new C3574b(new Locale("", "CI"), 225));
        arrayList.add(new C3574b(new Locale("", "HR"), 385));
        arrayList.add(new C3574b(new Locale("", "CU"), 53));
        arrayList.add(new C3574b(new Locale("", "CW"), 599));
        arrayList.add(new C3574b(new Locale("", "CY"), 357));
        arrayList.add(new C3574b(new Locale("", "CZ"), HttpResponseCode.ENHANCE_YOUR_CLAIM));
        arrayList.add(new C3574b(new Locale("", "DK"), 45));
        arrayList.add(new C3574b(new Locale("", "DJ"), 253));
        arrayList.add(new C3574b(new Locale("", "DM"), 1));
        arrayList.add(new C3574b(new Locale("", "DO"), 1));
        arrayList.add(new C3574b(new Locale("", "TL"), 670));
        arrayList.add(new C3574b(new Locale("", "EC"), 593));
        arrayList.add(new C3574b(new Locale("", "EG"), 20));
        arrayList.add(new C3574b(new Locale("", "SV"), 503));
        arrayList.add(new C3574b(new Locale("", "GQ"), 240));
        arrayList.add(new C3574b(new Locale("", "ER"), 291));
        arrayList.add(new C3574b(new Locale("", "EE"), 372));
        arrayList.add(new C3574b(new Locale("", "ET"), 251));
        arrayList.add(new C3574b(new Locale("", "FK"), 500));
        arrayList.add(new C3574b(new Locale("", "FO"), 298));
        arrayList.add(new C3574b(new Locale("", "FJ"), 679));
        arrayList.add(new C3574b(new Locale("", "FI"), 358));
        arrayList.add(new C3574b(new Locale("", "FR"), 33));
        arrayList.add(new C3574b(new Locale("", "GF"), 594));
        arrayList.add(new C3574b(new Locale("", "PF"), 689));
        arrayList.add(new C3574b(new Locale("", "GA"), 241));
        arrayList.add(new C3574b(new Locale("", "GM"), 220));
        arrayList.add(new C3574b(new Locale("", "GE"), 995));
        arrayList.add(new C3574b(new Locale("", "DE"), 49));
        arrayList.add(new C3574b(new Locale("", "GH"), 233));
        arrayList.add(new C3574b(new Locale("", "GI"), 350));
        arrayList.add(new C3574b(new Locale("", "GR"), 30));
        arrayList.add(new C3574b(new Locale("", "GL"), 299));
        arrayList.add(new C3574b(new Locale("", "GD"), 1));
        arrayList.add(new C3574b(new Locale("", "GP"), 590));
        arrayList.add(new C3574b(new Locale("", "GU"), 1));
        arrayList.add(new C3574b(new Locale("", "GT"), 502));
        arrayList.add(new C3574b(new Locale("", "GG"), 44));
        arrayList.add(new C3574b(new Locale("", "GN"), 224));
        arrayList.add(new C3574b(new Locale("", "GW"), 245));
        arrayList.add(new C3574b(new Locale("", "GY"), 592));
        arrayList.add(new C3574b(new Locale("", "HT"), 509));
        arrayList.add(new C3574b(new Locale("", "HM"), 672));
        arrayList.add(new C3574b(new Locale("", "HN"), HttpResponseCode.GATEWAY_TIMEOUT));
        arrayList.add(new C3574b(new Locale("", "HK"), 852));
        arrayList.add(new C3574b(new Locale("", "HU"), 36));
        arrayList.add(new C3574b(new Locale("", "IS"), 354));
        arrayList.add(new C3574b(new Locale("", "IN"), 91));
        arrayList.add(new C3574b(new Locale("", "ID"), 62));
        arrayList.add(new C3574b(new Locale("", "IR"), 98));
        arrayList.add(new C3574b(new Locale("", "IQ"), 964));
        arrayList.add(new C3574b(new Locale("", "IE"), 353));
        arrayList.add(new C3574b(new Locale("", "IM"), 44));
        arrayList.add(new C3574b(new Locale("", "IL"), 972));
        arrayList.add(new C3574b(new Locale("", "IT"), 39));
        arrayList.add(new C3574b(new Locale("", "JM"), 1));
        arrayList.add(new C3574b(new Locale("", "JP"), 81));
        arrayList.add(new C3574b(new Locale("", "JE"), 44));
        arrayList.add(new C3574b(new Locale("", "JO"), 962));
        arrayList.add(new C3574b(new Locale("", "KZ"), 7));
        arrayList.add(new C3574b(new Locale("", "KE"), 254));
        arrayList.add(new C3574b(new Locale("", "KI"), 686));
        arrayList.add(new C3574b(new Locale("", "XK"), 381));
        arrayList.add(new C3574b(new Locale("", "KW"), 965));
        arrayList.add(new C3574b(new Locale("", "KG"), 996));
        arrayList.add(new C3574b(new Locale("", "LA"), 856));
        arrayList.add(new C3574b(new Locale("", "LV"), 371));
        arrayList.add(new C3574b(new Locale("", "LB"), 961));
        arrayList.add(new C3574b(new Locale("", "LS"), 266));
        arrayList.add(new C3574b(new Locale("", "LR"), 231));
        arrayList.add(new C3574b(new Locale("", "LY"), 218));
        arrayList.add(new C3574b(new Locale("", "LI"), 423));
        arrayList.add(new C3574b(new Locale("", "LT"), 370));
        arrayList.add(new C3574b(new Locale("", "LU"), 352));
        arrayList.add(new C3574b(new Locale("", "MO"), 853));
        arrayList.add(new C3574b(new Locale("", "MK"), 389));
        arrayList.add(new C3574b(new Locale("", "MG"), 261));
        arrayList.add(new C3574b(new Locale("", "MW"), 265));
        arrayList.add(new C3574b(new Locale("", "MY"), 60));
        arrayList.add(new C3574b(new Locale("", "MV"), 960));
        arrayList.add(new C3574b(new Locale("", "ML"), 223));
        arrayList.add(new C3574b(new Locale("", "MT"), 356));
        arrayList.add(new C3574b(new Locale("", "MH"), 692));
        arrayList.add(new C3574b(new Locale("", "MQ"), 596));
        arrayList.add(new C3574b(new Locale("", "MR"), 222));
        arrayList.add(new C3574b(new Locale("", "MU"), 230));
        arrayList.add(new C3574b(new Locale("", "YT"), 262));
        arrayList.add(new C3574b(new Locale("", "MX"), 52));
        arrayList.add(new C3574b(new Locale("", "FM"), 691));
        arrayList.add(new C3574b(new Locale("", "MD"), 373));
        arrayList.add(new C3574b(new Locale("", "MC"), 377));
        arrayList.add(new C3574b(new Locale("", "MN"), 976));
        arrayList.add(new C3574b(new Locale("", "ME"), 382));
        arrayList.add(new C3574b(new Locale("", "MS"), 1));
        arrayList.add(new C3574b(new Locale("", "MA"), 212));
        arrayList.add(new C3574b(new Locale("", "MZ"), 258));
        arrayList.add(new C3574b(new Locale("", "MM"), 95));
        arrayList.add(new C3574b(new Locale("", "NA"), 264));
        arrayList.add(new C3574b(new Locale("", "NR"), 674));
        arrayList.add(new C3574b(new Locale("", "NP"), 977));
        arrayList.add(new C3574b(new Locale("", "NL"), 31));
        arrayList.add(new C3574b(new Locale("", "NC"), 687));
        arrayList.add(new C3574b(new Locale("", "NZ"), 64));
        arrayList.add(new C3574b(new Locale("", "NI"), 505));
        arrayList.add(new C3574b(new Locale("", "NE"), 227));
        arrayList.add(new C3574b(new Locale("", "NG"), 234));
        arrayList.add(new C3574b(new Locale("", "NU"), 683));
        arrayList.add(new C3574b(new Locale("", "NF"), 672));
        arrayList.add(new C3574b(new Locale("", "KP"), 850));
        arrayList.add(new C3574b(new Locale("", "MP"), 1));
        arrayList.add(new C3574b(new Locale("", "NO"), 47));
        arrayList.add(new C3574b(new Locale("", "OM"), 968));
        arrayList.add(new C3574b(new Locale("", "PK"), 92));
        arrayList.add(new C3574b(new Locale("", "PW"), 680));
        arrayList.add(new C3574b(new Locale("", "PS"), 970));
        arrayList.add(new C3574b(new Locale("", "PA"), 507));
        arrayList.add(new C3574b(new Locale("", "PG"), 675));
        arrayList.add(new C3574b(new Locale("", "PY"), 595));
        arrayList.add(new C3574b(new Locale("", "PE"), 51));
        arrayList.add(new C3574b(new Locale("", "PH"), 63));
        arrayList.add(new C3574b(new Locale("", "PL"), 48));
        arrayList.add(new C3574b(new Locale("", "PT"), 351));
        arrayList.add(new C3574b(new Locale("", "PR"), 1));
        arrayList.add(new C3574b(new Locale("", "QA"), 974));
        arrayList.add(new C3574b(new Locale("", "RE"), 262));
        arrayList.add(new C3574b(new Locale("", "RO"), 40));
        arrayList.add(new C3574b(new Locale("", "RU"), 7));
        arrayList.add(new C3574b(new Locale("", "RW"), SQLiteDatabase.MAX_SQL_CACHE_SIZE));
        arrayList.add(new C3574b(new Locale("", "BL"), 590));
        arrayList.add(new C3574b(new Locale("", "SH"), 290));
        arrayList.add(new C3574b(new Locale("", "KN"), 1));
        arrayList.add(new C3574b(new Locale("", "LC"), 1));
        arrayList.add(new C3574b(new Locale("", "MF"), 590));
        arrayList.add(new C3574b(new Locale("", "PM"), 508));
        arrayList.add(new C3574b(new Locale("", "VC"), 1));
        arrayList.add(new C3574b(new Locale("", "WS"), 685));
        arrayList.add(new C3574b(new Locale("", "SM"), 378));
        arrayList.add(new C3574b(new Locale("", "ST"), 239));
        arrayList.add(new C3574b(new Locale("", "SA"), 966));
        arrayList.add(new C3574b(new Locale("", "SN"), 221));
        arrayList.add(new C3574b(new Locale("", "RS"), 381));
        arrayList.add(new C3574b(new Locale("", "SC"), 248));
        arrayList.add(new C3574b(new Locale("", "SL"), 232));
        arrayList.add(new C3574b(new Locale("", "SG"), 65));
        arrayList.add(new C3574b(new Locale("", "SX"), 1));
        arrayList.add(new C3574b(new Locale("", "SK"), 421));
        arrayList.add(new C3574b(new Locale("", "SI"), 386));
        arrayList.add(new C3574b(new Locale("", "SB"), 677));
        arrayList.add(new C3574b(new Locale("", "SO"), 252));
        arrayList.add(new C3574b(new Locale("", "ZA"), 27));
        arrayList.add(new C3574b(new Locale("", "GS"), 500));
        arrayList.add(new C3574b(new Locale("", "KR"), 82));
        arrayList.add(new C3574b(new Locale("", "SS"), 211));
        arrayList.add(new C3574b(new Locale("", "ES"), 34));
        arrayList.add(new C3574b(new Locale("", "LK"), 94));
        arrayList.add(new C3574b(new Locale("", "SD"), 249));
        arrayList.add(new C3574b(new Locale("", "SR"), 597));
        arrayList.add(new C3574b(new Locale("", "SJ"), 47));
        arrayList.add(new C3574b(new Locale("", "SZ"), 268));
        arrayList.add(new C3574b(new Locale("", "SE"), 46));
        arrayList.add(new C3574b(new Locale("", "CH"), 41));
        arrayList.add(new C3574b(new Locale("", "SY"), 963));
        arrayList.add(new C3574b(new Locale("", "TW"), 886));
        arrayList.add(new C3574b(new Locale("", "TJ"), 992));
        arrayList.add(new C3574b(new Locale("", "TZ"), 255));
        arrayList.add(new C3574b(new Locale("", "TH"), 66));
        arrayList.add(new C3574b(new Locale("", "TG"), 228));
        arrayList.add(new C3574b(new Locale("", "TK"), 690));
        arrayList.add(new C3574b(new Locale("", "TO"), 676));
        arrayList.add(new C3574b(new Locale("", "TT"), 1));
        arrayList.add(new C3574b(new Locale("", "TN"), 216));
        arrayList.add(new C3574b(new Locale("", "TR"), 90));
        arrayList.add(new C3574b(new Locale("", "TM"), 993));
        arrayList.add(new C3574b(new Locale("", "TC"), 1));
        arrayList.add(new C3574b(new Locale("", "TV"), 688));
        arrayList.add(new C3574b(new Locale("", "VI"), 1));
        arrayList.add(new C3574b(new Locale("", "UG"), 256));
        arrayList.add(new C3574b(new Locale("", "UA"), 380));
        arrayList.add(new C3574b(new Locale("", "AE"), 971));
        arrayList.add(new C3574b(new Locale("", "GB"), 44));
        arrayList.add(new C3574b(new Locale("", "US"), 1));
        arrayList.add(new C3574b(new Locale("", "UY"), 598));
        arrayList.add(new C3574b(new Locale("", "UZ"), 998));
        arrayList.add(new C3574b(new Locale("", "VU"), 678));
        arrayList.add(new C3574b(new Locale("", "VA"), 379));
        arrayList.add(new C3574b(new Locale("", "VE"), 58));
        arrayList.add(new C3574b(new Locale("", "VN"), 84));
        arrayList.add(new C3574b(new Locale("", "WF"), 681));
        arrayList.add(new C3574b(new Locale("", "EH"), 212));
        arrayList.add(new C3574b(new Locale("", "YE"), 967));
        arrayList.add(new C3574b(new Locale("", "ZM"), 260));
        arrayList.add(new C3574b(new Locale("", "ZW"), 263));
        Collections.sort(arrayList);
        return arrayList;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(List<C3574b> list) {
        if (this.f9397a != null) {
            this.f9397a.mo29467a(list);
        }
    }
}
