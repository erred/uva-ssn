package androidx.customview.p073b;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* renamed from: androidx.customview.b.b */
/* compiled from: FocusStrategy */
class C1028b {

    /* renamed from: androidx.customview.b.b$a */
    /* compiled from: FocusStrategy */
    public interface C1029a<T> {
        /* renamed from: a */
        void mo3988a(T t, Rect rect);
    }

    /* renamed from: androidx.customview.b.b$b */
    /* compiled from: FocusStrategy */
    public interface C1030b<T, V> {
        /* renamed from: a */
        int mo3990a(T t);

        /* renamed from: a */
        V mo3992a(T t, int i);
    }

    /* renamed from: androidx.customview.b.b$c */
    /* compiled from: FocusStrategy */
    private static class C1031c<T> implements Comparator<T> {

        /* renamed from: a */
        private final Rect f3165a = new Rect();

        /* renamed from: b */
        private final Rect f3166b = new Rect();

        /* renamed from: c */
        private final boolean f3167c;

        /* renamed from: d */
        private final C1029a<T> f3168d;

        C1031c(boolean z, C1029a<T> aVar) {
            this.f3167c = z;
            this.f3168d = aVar;
        }

        public int compare(T t, T t2) {
            Rect rect = this.f3165a;
            Rect rect2 = this.f3166b;
            this.f3168d.mo3988a(t, rect);
            this.f3168d.mo3988a(t2, rect2);
            int i = -1;
            if (rect.top < rect2.top) {
                return -1;
            }
            if (rect.top > rect2.top) {
                return 1;
            }
            if (rect.left < rect2.left) {
                if (this.f3167c) {
                    i = 1;
                }
                return i;
            } else if (rect.left > rect2.left) {
                if (!this.f3167c) {
                    i = 1;
                }
                return i;
            } else if (rect.bottom < rect2.bottom) {
                return -1;
            } else {
                if (rect.bottom > rect2.bottom) {
                    return 1;
                }
                if (rect.right < rect2.right) {
                    if (this.f3167c) {
                        i = 1;
                    }
                    return i;
                } else if (rect.right <= rect2.right) {
                    return 0;
                } else {
                    if (!this.f3167c) {
                        i = 1;
                    }
                    return i;
                }
            }
        }
    }

    /* renamed from: a */
    private static int m3895a(int i, int i2) {
        return (i * 13 * i) + (i2 * i2);
    }

    /* renamed from: a */
    public static <L, T> T m3896a(L l, C1030b<L, T> bVar, C1029a<T> aVar, T t, int i, boolean z, boolean z2) {
        int a = bVar.mo3990a(l);
        ArrayList arrayList = new ArrayList(a);
        for (int i2 = 0; i2 < a; i2++) {
            arrayList.add(bVar.mo3992a(l, i2));
        }
        Collections.sort(arrayList, new C1031c(z, aVar));
        switch (i) {
            case 1:
                return m3902b(t, arrayList, z2);
            case 2:
                return m3898a(t, arrayList, z2);
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
        }
    }

    /* renamed from: a */
    private static <T> T m3898a(T t, ArrayList<T> arrayList, boolean z) {
        int i;
        int size = arrayList.size();
        if (t == null) {
            i = -1;
        } else {
            i = arrayList.lastIndexOf(t);
        }
        int i2 = i + 1;
        if (i2 < size) {
            return arrayList.get(i2);
        }
        if (!z || size <= 0) {
            return null;
        }
        return arrayList.get(0);
    }

    /* renamed from: b */
    private static <T> T m3902b(T t, ArrayList<T> arrayList, boolean z) {
        int i;
        int size = arrayList.size();
        if (t == null) {
            i = size;
        } else {
            i = arrayList.indexOf(t);
        }
        int i2 = i - 1;
        if (i2 >= 0) {
            return arrayList.get(i2);
        }
        if (!z || size <= 0) {
            return null;
        }
        return arrayList.get(size - 1);
    }

    /* renamed from: a */
    public static <L, T> T m3897a(L l, C1030b<L, T> bVar, C1029a<T> aVar, T t, Rect rect, int i) {
        Rect rect2 = new Rect(rect);
        if (i == 17) {
            rect2.offset(rect.width() + 1, 0);
        } else if (i == 33) {
            rect2.offset(0, rect.height() + 1);
        } else if (i == 66) {
            rect2.offset(-(rect.width() + 1), 0);
        } else if (i == 130) {
            rect2.offset(0, -(rect.height() + 1));
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        T t2 = null;
        int a = bVar.mo3990a(l);
        Rect rect3 = new Rect();
        for (int i2 = 0; i2 < a; i2++) {
            T a2 = bVar.mo3992a(l, i2);
            if (a2 != t) {
                aVar.mo3988a(a2, rect3);
                if (m3900a(i, rect, rect3, rect2)) {
                    rect2.set(rect3);
                    t2 = a2;
                }
            }
        }
        return t2;
    }

    /* renamed from: a */
    private static boolean m3900a(int i, Rect rect, Rect rect2, Rect rect3) {
        boolean z = false;
        if (!m3901a(rect, rect2, i)) {
            return false;
        }
        if (!m3901a(rect, rect3, i) || m3904b(i, rect, rect2, rect3)) {
            return true;
        }
        if (m3904b(i, rect, rect3, rect2)) {
            return false;
        }
        if (m3895a(m3905c(i, rect, rect2), m3909g(i, rect, rect2)) < m3895a(m3905c(i, rect, rect3), m3909g(i, rect, rect3))) {
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    private static boolean m3904b(int i, Rect rect, Rect rect2, Rect rect3) {
        boolean a = m3899a(i, rect, rect2);
        if (m3899a(i, rect, rect3) || !a) {
            return false;
        }
        boolean z = true;
        if (!m3903b(i, rect, rect3) || i == 17 || i == 66) {
            return true;
        }
        if (m3905c(i, rect, rect2) >= m3907e(i, rect, rect3)) {
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    private static boolean m3901a(Rect rect, Rect rect2, int i) {
        boolean z = true;
        if (i == 17) {
            if ((rect.right <= rect2.right && rect.left < rect2.right) || rect.left <= rect2.left) {
                z = false;
            }
            return z;
        } else if (i == 33) {
            if ((rect.bottom <= rect2.bottom && rect.top < rect2.bottom) || rect.top <= rect2.top) {
                z = false;
            }
            return z;
        } else if (i == 66) {
            if ((rect.left >= rect2.left && rect.right > rect2.left) || rect.right >= rect2.right) {
                z = false;
            }
            return z;
        } else if (i == 130) {
            if ((rect.top >= rect2.top && rect.bottom > rect2.top) || rect.bottom >= rect2.bottom) {
                z = false;
            }
            return z;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    /* renamed from: a */
    private static boolean m3899a(int i, Rect rect, Rect rect2) {
        boolean z = true;
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            if (rect2.right < rect.left || rect2.left > rect.right) {
                z = false;
            }
            return z;
        }
        if (rect2.bottom < rect.top || rect2.top > rect.bottom) {
            z = false;
        }
        return z;
    }

    /* renamed from: b */
    private static boolean m3903b(int i, Rect rect, Rect rect2) {
        boolean z = false;
        if (i == 17) {
            if (rect.left >= rect2.right) {
                z = true;
            }
            return z;
        } else if (i == 33) {
            if (rect.top >= rect2.bottom) {
                z = true;
            }
            return z;
        } else if (i == 66) {
            if (rect.right <= rect2.left) {
                z = true;
            }
            return z;
        } else if (i == 130) {
            if (rect.bottom <= rect2.top) {
                z = true;
            }
            return z;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    /* renamed from: c */
    private static int m3905c(int i, Rect rect, Rect rect2) {
        return Math.max(0, m3906d(i, rect, rect2));
    }

    /* renamed from: d */
    private static int m3906d(int i, Rect rect, Rect rect2) {
        if (i == 17) {
            return rect.left - rect2.right;
        }
        if (i == 33) {
            return rect.top - rect2.bottom;
        }
        if (i == 66) {
            return rect2.left - rect.right;
        }
        if (i == 130) {
            return rect2.top - rect.bottom;
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    /* renamed from: e */
    private static int m3907e(int i, Rect rect, Rect rect2) {
        return Math.max(1, m3908f(i, rect, rect2));
    }

    /* renamed from: f */
    private static int m3908f(int i, Rect rect, Rect rect2) {
        if (i == 17) {
            return rect.left - rect2.left;
        }
        if (i == 33) {
            return rect.top - rect2.top;
        }
        if (i == 66) {
            return rect2.right - rect.right;
        }
        if (i == 130) {
            return rect2.bottom - rect.bottom;
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    /* renamed from: g */
    private static int m3909g(int i, Rect rect, Rect rect2) {
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs((rect.left + (rect.width() / 2)) - (rect2.left + (rect2.width() / 2)));
        }
        return Math.abs((rect.top + (rect.height() / 2)) - (rect2.top + (rect2.height() / 2)));
    }
}
