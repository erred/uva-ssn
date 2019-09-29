package androidx.p082g;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.util.Log;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

/* renamed from: androidx.g.a */
/* compiled from: MultiDex */
public final class C1122a {

    /* renamed from: a */
    private static final Set<File> f3510a = new HashSet();

    /* renamed from: b */
    private static final boolean f3511b = m4366a(System.getProperty("java.vm.version"));

    /* renamed from: androidx.g.a$a */
    /* compiled from: MultiDex */
    private static final class C1123a {

        /* renamed from: a */
        private static final int f3512a = ".zip".length();

        /* renamed from: b */
        private final C1124a f3513b;

        /* renamed from: androidx.g.a$a$a */
        /* compiled from: MultiDex */
        private interface C1124a {
            /* renamed from: a */
            Object mo4560a(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException;
        }

        /* renamed from: androidx.g.a$a$b */
        /* compiled from: MultiDex */
        private static class C1125b implements C1124a {

            /* renamed from: a */
            private final Constructor<?> f3514a;

            C1125b(Class<?> cls) throws SecurityException, NoSuchMethodException {
                this.f3514a = cls.getConstructor(new Class[]{File.class, ZipFile.class, DexFile.class});
                this.f3514a.setAccessible(true);
            }

            /* renamed from: a */
            public Object mo4560a(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException {
                return this.f3514a.newInstance(new Object[]{file, new ZipFile(file), dexFile});
            }
        }

        /* renamed from: androidx.g.a$a$c */
        /* compiled from: MultiDex */
        private static class C1126c implements C1124a {

            /* renamed from: a */
            private final Constructor<?> f3515a;

            C1126c(Class<?> cls) throws SecurityException, NoSuchMethodException {
                this.f3515a = cls.getConstructor(new Class[]{File.class, File.class, DexFile.class});
                this.f3515a.setAccessible(true);
            }

            /* renamed from: a */
            public Object mo4560a(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
                return this.f3515a.newInstance(new Object[]{file, file, dexFile});
            }
        }

        /* renamed from: androidx.g.a$a$d */
        /* compiled from: MultiDex */
        private static class C1127d implements C1124a {

            /* renamed from: a */
            private final Constructor<?> f3516a;

            C1127d(Class<?> cls) throws SecurityException, NoSuchMethodException {
                this.f3516a = cls.getConstructor(new Class[]{File.class, Boolean.TYPE, File.class, DexFile.class});
                this.f3516a.setAccessible(true);
            }

            /* renamed from: a */
            public Object mo4560a(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
                return this.f3516a.newInstance(new Object[]{file, Boolean.FALSE, file, dexFile});
            }
        }

        /* renamed from: a */
        static void m4373a(ClassLoader classLoader, List<? extends File> list) throws IOException, SecurityException, IllegalArgumentException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
            Object obj = C1122a.m4368b(classLoader, "pathList").get(classLoader);
            Object[] a = new C1123a().m4374a(list);
            try {
                C1122a.m4370b(obj, "dexElements", a);
            } catch (NoSuchFieldException e) {
                Log.w("MultiDex", "Failed find field 'dexElements' attempting 'pathElements'", e);
                C1122a.m4370b(obj, "pathElements", a);
            }
        }

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private C1123a() throws java.lang.ClassNotFoundException, java.lang.SecurityException, java.lang.NoSuchMethodException {
            /*
                r2 = this;
                r2.<init>()
                java.lang.String r0 = "dalvik.system.DexPathList$Element"
                java.lang.Class r0 = java.lang.Class.forName(r0)
                androidx.g.a$a$b r1 = new androidx.g.a$a$b     // Catch:{ NoSuchMethodException -> 0x000f }
                r1.<init>(r0)     // Catch:{ NoSuchMethodException -> 0x000f }
                goto L_0x001a
            L_0x000f:
                androidx.g.a$a$c r1 = new androidx.g.a$a$c     // Catch:{ NoSuchMethodException -> 0x0015 }
                r1.<init>(r0)     // Catch:{ NoSuchMethodException -> 0x0015 }
                goto L_0x001a
            L_0x0015:
                androidx.g.a$a$d r1 = new androidx.g.a$a$d
                r1.<init>(r0)
            L_0x001a:
                r2.f3513b = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.p082g.C1122a.C1123a.<init>():void");
        }

        /* renamed from: a */
        private Object[] m4374a(List<? extends File> list) throws IOException, SecurityException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
            Object[] objArr = new Object[list.size()];
            for (int i = 0; i < objArr.length; i++) {
                File file = (File) list.get(i);
                objArr[i] = this.f3513b.mo4560a(file, DexFile.loadDex(file.getPath(), m4372a(file), 0));
            }
            return objArr;
        }

        /* renamed from: a */
        private static String m4372a(File file) {
            File parentFile = file.getParentFile();
            String name = file.getName();
            StringBuilder sb = new StringBuilder();
            sb.append(name.substring(0, name.length() - f3512a));
            sb.append(".dex");
            return new File(parentFile, sb.toString()).getPath();
        }
    }

    /* renamed from: androidx.g.a$b */
    /* compiled from: MultiDex */
    private static final class C1128b {
        /* renamed from: a */
        static void m4379a(ClassLoader classLoader, List<? extends File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
            IOException[] iOExceptionArr;
            Object obj = C1122a.m4368b(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            C1122a.m4370b(obj, "dexElements", m4380a(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Log.w("MultiDex", "Exception in makeDexElement", (IOException) it.next());
                }
                Field a = C1122a.m4368b(obj, "dexElementsSuppressedExceptions");
                IOException[] iOExceptionArr2 = (IOException[]) a.get(obj);
                if (iOExceptionArr2 == null) {
                    iOExceptionArr = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                } else {
                    IOException[] iOExceptionArr3 = new IOException[(arrayList.size() + iOExceptionArr2.length)];
                    arrayList.toArray(iOExceptionArr3);
                    System.arraycopy(iOExceptionArr2, 0, iOExceptionArr3, arrayList.size(), iOExceptionArr2.length);
                    iOExceptionArr = iOExceptionArr3;
                }
                a.set(obj, iOExceptionArr);
                IOException iOException = new IOException("I/O exception during makeDexElement");
                iOException.initCause((Throwable) arrayList.get(0));
                throw iOException;
            }
        }

        /* renamed from: a */
        private static Object[] m4380a(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            return (Object[]) C1122a.m4369b(obj, "makeDexElements", (Class<?>[]) new Class[]{ArrayList.class, File.class, ArrayList.class}).invoke(obj, new Object[]{arrayList, file, arrayList2});
        }
    }

    /* renamed from: androidx.g.a$c */
    /* compiled from: MultiDex */
    private static final class C1129c {
        /* renamed from: a */
        static void m4381a(ClassLoader classLoader, List<? extends File> list) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, IOException {
            int size = list.size();
            Field a = C1122a.m4368b(classLoader, "path");
            StringBuilder sb = new StringBuilder((String) a.get(classLoader));
            String[] strArr = new String[size];
            File[] fileArr = new File[size];
            ZipFile[] zipFileArr = new ZipFile[size];
            DexFile[] dexFileArr = new DexFile[size];
            ListIterator listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                File file = (File) listIterator.next();
                String absolutePath = file.getAbsolutePath();
                sb.append(':');
                sb.append(absolutePath);
                int previousIndex = listIterator.previousIndex();
                strArr[previousIndex] = absolutePath;
                fileArr[previousIndex] = file;
                zipFileArr[previousIndex] = new ZipFile(file);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(absolutePath);
                sb2.append(".dex");
                dexFileArr[previousIndex] = DexFile.loadDex(absolutePath, sb2.toString(), 0);
            }
            a.set(classLoader, sb.toString());
            C1122a.m4370b((Object) classLoader, "mPaths", (Object[]) strArr);
            C1122a.m4370b((Object) classLoader, "mFiles", (Object[]) fileArr);
            C1122a.m4370b((Object) classLoader, "mZips", (Object[]) zipFileArr);
            C1122a.m4370b((Object) classLoader, "mDexs", (Object[]) dexFileArr);
        }
    }

    /* renamed from: a */
    public static void m4361a(Context context) {
        Log.i("MultiDex", "Installing application");
        if (f3511b) {
            Log.i("MultiDex", "VM has multidex support, MultiDex support library is disabled.");
        } else if (VERSION.SDK_INT >= 4) {
            try {
                ApplicationInfo b = m4367b(context);
                if (b == null) {
                    Log.i("MultiDex", "No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
                    return;
                }
                m4362a(context, new File(b.sourceDir), new File(b.dataDir), "secondary-dexes", "", true);
                Log.i("MultiDex", "install done");
            } catch (Exception e) {
                Log.e("MultiDex", "MultiDex installation failure", e);
                StringBuilder sb = new StringBuilder();
                sb.append("MultiDex installation failed (");
                sb.append(e.getMessage());
                sb.append(").");
                throw new RuntimeException(sb.toString());
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("MultiDex installation failed. SDK ");
            sb2.append(VERSION.SDK_INT);
            sb2.append(" is unsupported. Min SDK version is ");
            sb2.append(4);
            sb2.append(".");
            throw new RuntimeException(sb2.toString());
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x00a4 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m4362a(android.content.Context r5, java.io.File r6, java.io.File r7, java.lang.String r8, java.lang.String r9, boolean r10) throws java.io.IOException, java.lang.IllegalArgumentException, java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.reflect.InvocationTargetException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.ClassNotFoundException, java.lang.InstantiationException {
        /*
            java.util.Set<java.io.File> r0 = f3510a
            monitor-enter(r0)
            java.util.Set<java.io.File> r1 = f3510a     // Catch:{ all -> 0x00af }
            boolean r1 = r1.contains(r6)     // Catch:{ all -> 0x00af }
            if (r1 == 0) goto L_0x000d
            monitor-exit(r0)     // Catch:{ all -> 0x00af }
            return
        L_0x000d:
            java.util.Set<java.io.File> r1 = f3510a     // Catch:{ all -> 0x00af }
            r1.add(r6)     // Catch:{ all -> 0x00af }
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00af }
            r2 = 20
            if (r1 <= r2) goto L_0x0055
            java.lang.String r1 = "MultiDex"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00af }
            r3.<init>()     // Catch:{ all -> 0x00af }
            java.lang.String r4 = "MultiDex is not guaranteed to work in SDK version "
            r3.append(r4)     // Catch:{ all -> 0x00af }
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00af }
            r3.append(r4)     // Catch:{ all -> 0x00af }
            java.lang.String r4 = ": SDK version higher than "
            r3.append(r4)     // Catch:{ all -> 0x00af }
            r3.append(r2)     // Catch:{ all -> 0x00af }
            java.lang.String r2 = " should be backed by "
            r3.append(r2)     // Catch:{ all -> 0x00af }
            java.lang.String r2 = "runtime with built-in multidex capabilty but it's not the "
            r3.append(r2)     // Catch:{ all -> 0x00af }
            java.lang.String r2 = "case here: java.vm.version=\""
            r3.append(r2)     // Catch:{ all -> 0x00af }
            java.lang.String r2 = "java.vm.version"
            java.lang.String r2 = java.lang.System.getProperty(r2)     // Catch:{ all -> 0x00af }
            r3.append(r2)     // Catch:{ all -> 0x00af }
            java.lang.String r2 = "\""
            r3.append(r2)     // Catch:{ all -> 0x00af }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x00af }
            android.util.Log.w(r1, r2)     // Catch:{ all -> 0x00af }
        L_0x0055:
            java.lang.ClassLoader r1 = r5.getClassLoader()     // Catch:{ RuntimeException -> 0x00a5 }
            if (r1 != 0) goto L_0x0064
            java.lang.String r5 = "MultiDex"
            java.lang.String r6 = "Context class loader is null. Must be running in test mode. Skip patching."
            android.util.Log.e(r5, r6)     // Catch:{ all -> 0x00af }
            monitor-exit(r0)     // Catch:{ all -> 0x00af }
            return
        L_0x0064:
            m4371c(r5)     // Catch:{ Throwable -> 0x0068 }
            goto L_0x0070
        L_0x0068:
            r2 = move-exception
            java.lang.String r3 = "MultiDex"
            java.lang.String r4 = "Something went wrong when trying to clear old MultiDex extraction, continuing without cleaning."
            android.util.Log.w(r3, r4, r2)     // Catch:{ all -> 0x00af }
        L_0x0070:
            java.io.File r7 = m4358a(r5, r7, r8)     // Catch:{ all -> 0x00af }
            androidx.g.b r8 = new androidx.g.b     // Catch:{ all -> 0x00af }
            r8.<init>(r6, r7)     // Catch:{ all -> 0x00af }
            r6 = 0
            r2 = 0
            java.util.List r2 = r8.mo4561a(r5, r9, r2)     // Catch:{ all -> 0x00a0 }
            m4364a(r1, r7, r2)     // Catch:{ IOException -> 0x0083 }
            goto L_0x0095
        L_0x0083:
            r2 = move-exception
            if (r10 == 0) goto L_0x009f
            java.lang.String r10 = "MultiDex"
            java.lang.String r3 = "Failed to install extracted secondary dex files, retrying with forced extraction"
            android.util.Log.w(r10, r3, r2)     // Catch:{ all -> 0x00a0 }
            r10 = 1
            java.util.List r5 = r8.mo4561a(r5, r9, r10)     // Catch:{ all -> 0x00a0 }
            m4364a(r1, r7, r5)     // Catch:{ all -> 0x00a0 }
        L_0x0095:
            r8.close()     // Catch:{ IOException -> 0x0099 }
            goto L_0x009a
        L_0x0099:
            r6 = move-exception
        L_0x009a:
            if (r6 != 0) goto L_0x009e
            monitor-exit(r0)     // Catch:{ all -> 0x00af }
            return
        L_0x009e:
            throw r6     // Catch:{ all -> 0x00af }
        L_0x009f:
            throw r2     // Catch:{ all -> 0x00a0 }
        L_0x00a0:
            r5 = move-exception
            r8.close()     // Catch:{ IOException -> 0x00a4 }
        L_0x00a4:
            throw r5     // Catch:{ all -> 0x00af }
        L_0x00a5:
            r5 = move-exception
            java.lang.String r6 = "MultiDex"
            java.lang.String r7 = "Failure while trying to obtain Context class loader. Must be running in test mode. Skip patching."
            android.util.Log.w(r6, r7, r5)     // Catch:{ all -> 0x00af }
            monitor-exit(r0)     // Catch:{ all -> 0x00af }
            return
        L_0x00af:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00af }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.p082g.C1122a.m4362a(android.content.Context, java.io.File, java.io.File, java.lang.String, java.lang.String, boolean):void");
    }

    /* renamed from: b */
    private static ApplicationInfo m4367b(Context context) {
        try {
            return context.getApplicationInfo();
        } catch (RuntimeException e) {
            Log.w("MultiDex", "Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", e);
            return null;
        }
    }

    /* renamed from: a */
    static boolean m4366a(String str) {
        boolean z = false;
        if (str != null) {
            Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(str);
            if (matcher.matches()) {
                try {
                    int parseInt = Integer.parseInt(matcher.group(1));
                    int parseInt2 = Integer.parseInt(matcher.group(2));
                    if (parseInt > 2 || (parseInt == 2 && parseInt2 >= 1)) {
                        z = true;
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        String str2 = "MultiDex";
        StringBuilder sb = new StringBuilder();
        sb.append("VM with version ");
        sb.append(str);
        sb.append(z ? " has multidex support" : " does not have multidex support");
        Log.i(str2, sb.toString());
        return z;
    }

    /* renamed from: a */
    private static void m4364a(ClassLoader classLoader, File file, List<? extends File> list) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException, SecurityException, ClassNotFoundException, InstantiationException {
        if (list.isEmpty()) {
            return;
        }
        if (VERSION.SDK_INT >= 19) {
            C1128b.m4379a(classLoader, list, file);
        } else if (VERSION.SDK_INT >= 14) {
            C1123a.m4373a(classLoader, list);
        } else {
            C1129c.m4381a(classLoader, list);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static Field m4368b(Object obj, String str) throws NoSuchFieldException {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Field ");
        sb.append(str);
        sb.append(" not found in ");
        sb.append(obj.getClass());
        throw new NoSuchFieldException(sb.toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static Method m4369b(Object obj, String str, Class<?>... clsArr) throws NoSuchMethodException {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
                cls = cls.getSuperclass();
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Method ");
        sb.append(str);
        sb.append(" with parameters ");
        sb.append(Arrays.asList(clsArr));
        sb.append(" not found in ");
        sb.append(obj.getClass());
        throw new NoSuchMethodException(sb.toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m4370b(Object obj, String str, Object[] objArr) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field b = m4368b(obj, str);
        Object[] objArr2 = (Object[]) b.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        b.set(obj, objArr3);
    }

    /* renamed from: c */
    private static void m4371c(Context context) throws Exception {
        File file = new File(context.getFilesDir(), "secondary-dexes");
        if (file.isDirectory()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Clearing old secondary dex dir (");
            sb.append(file.getPath());
            sb.append(").");
            Log.i("MultiDex", sb.toString());
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to list secondary dex dir content (");
                sb2.append(file.getPath());
                sb2.append(").");
                Log.w("MultiDex", sb2.toString());
                return;
            }
            for (File file2 : listFiles) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Trying to delete old file ");
                sb3.append(file2.getPath());
                sb3.append(" of size ");
                sb3.append(file2.length());
                Log.i("MultiDex", sb3.toString());
                if (!file2.delete()) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Failed to delete old file ");
                    sb4.append(file2.getPath());
                    Log.w("MultiDex", sb4.toString());
                } else {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("Deleted old file ");
                    sb5.append(file2.getPath());
                    Log.i("MultiDex", sb5.toString());
                }
            }
            if (!file.delete()) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("Failed to delete secondary dex dir ");
                sb6.append(file.getPath());
                Log.w("MultiDex", sb6.toString());
            } else {
                StringBuilder sb7 = new StringBuilder();
                sb7.append("Deleted old secondary dex dir ");
                sb7.append(file.getPath());
                Log.i("MultiDex", sb7.toString());
            }
        }
    }

    /* renamed from: a */
    private static File m4358a(Context context, File file, String str) throws IOException {
        File file2 = new File(file, "code_cache");
        try {
            m4363a(file2);
        } catch (IOException unused) {
            file2 = new File(context.getFilesDir(), "code_cache");
            m4363a(file2);
        }
        File file3 = new File(file2, str);
        m4363a(file3);
        return file3;
    }

    /* renamed from: a */
    private static void m4363a(File file) throws IOException {
        file.mkdir();
        if (!file.isDirectory()) {
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to create dir ");
                sb.append(file.getPath());
                sb.append(". Parent file is null.");
                Log.e("MultiDex", sb.toString());
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to create dir ");
                sb2.append(file.getPath());
                sb2.append(". parent file is a dir ");
                sb2.append(parentFile.isDirectory());
                sb2.append(", a file ");
                sb2.append(parentFile.isFile());
                sb2.append(", exists ");
                sb2.append(parentFile.exists());
                sb2.append(", readable ");
                sb2.append(parentFile.canRead());
                sb2.append(", writable ");
                sb2.append(parentFile.canWrite());
                Log.e("MultiDex", sb2.toString());
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Failed to create directory ");
            sb3.append(file.getPath());
            throw new IOException(sb3.toString());
        }
    }
}
