package com.p103a.p104a.p107c;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;

/* renamed from: com.a.a.c.am */
/* compiled from: Utils */
final class C1773am {

    /* renamed from: a */
    private static final FilenameFilter f5541a = new FilenameFilter() {
        public boolean accept(File file, String str) {
            return true;
        }
    };

    /* renamed from: a */
    static int m7347a(File file, int i, Comparator<File> comparator) {
        return m7348a(file, f5541a, i, comparator);
    }

    /* renamed from: a */
    static int m7348a(File file, FilenameFilter filenameFilter, int i, Comparator<File> comparator) {
        File[] listFiles = file.listFiles(filenameFilter);
        if (listFiles == null) {
            return 0;
        }
        int length = listFiles.length;
        Arrays.sort(listFiles, comparator);
        for (File file2 : listFiles) {
            if (length <= i) {
                return length;
            }
            file2.delete();
            length--;
        }
        return length;
    }
}
