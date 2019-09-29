package com.google.api.client.util.store;

import com.google.api.client.util.IOUtils;
import com.google.api.client.util.Maps;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.logging.Logger;

public class FileDataStoreFactory extends AbstractDataStoreFactory {
    private static final Logger LOGGER = Logger.getLogger(FileDataStoreFactory.class.getName());
    private final File dataDirectory;

    static class FileDataStore<V extends Serializable> extends AbstractMemoryDataStore<V> {
        private final File dataFile;

        FileDataStore(FileDataStoreFactory fileDataStoreFactory, File file, String str) throws IOException {
            super(fileDataStoreFactory, str);
            this.dataFile = new File(file, str);
            if (IOUtils.isSymbolicLink(this.dataFile)) {
                String valueOf = String.valueOf(String.valueOf(this.dataFile));
                StringBuilder sb = new StringBuilder(valueOf.length() + 31);
                sb.append("unable to use a symbolic link: ");
                sb.append(valueOf);
                throw new IOException(sb.toString());
            } else if (this.dataFile.createNewFile()) {
                this.keyValueMap = Maps.newHashMap();
                save();
            } else {
                this.keyValueMap = (HashMap) IOUtils.deserialize((InputStream) new FileInputStream(this.dataFile));
            }
        }

        /* access modifiers changed from: 0000 */
        public void save() throws IOException {
            IOUtils.serialize(this.keyValueMap, new FileOutputStream(this.dataFile));
        }

        public FileDataStoreFactory getDataStoreFactory() {
            return (FileDataStoreFactory) super.getDataStoreFactory();
        }
    }

    public FileDataStoreFactory(File file) throws IOException {
        File canonicalFile = file.getCanonicalFile();
        this.dataDirectory = canonicalFile;
        if (IOUtils.isSymbolicLink(canonicalFile)) {
            String valueOf = String.valueOf(String.valueOf(canonicalFile));
            StringBuilder sb = new StringBuilder(valueOf.length() + 31);
            sb.append("unable to use a symbolic link: ");
            sb.append(valueOf);
            throw new IOException(sb.toString());
        } else if (canonicalFile.exists() || canonicalFile.mkdirs()) {
            setPermissionsToOwnerOnly(canonicalFile);
        } else {
            String valueOf2 = String.valueOf(String.valueOf(canonicalFile));
            StringBuilder sb2 = new StringBuilder(valueOf2.length() + 28);
            sb2.append("unable to create directory: ");
            sb2.append(valueOf2);
            throw new IOException(sb2.toString());
        }
    }

    public final File getDataDirectory() {
        return this.dataDirectory;
    }

    /* access modifiers changed from: protected */
    public <V extends Serializable> DataStore<V> createDataStore(String str) throws IOException {
        return new FileDataStore(this, this.dataDirectory, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0085, code lost:
        if (((java.lang.Boolean) r3.invoke(r10, new java.lang.Object[]{java.lang.Boolean.valueOf(false), java.lang.Boolean.valueOf(false)})).booleanValue() == false) goto L_0x0087;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void setPermissionsToOwnerOnly(java.io.File r10) throws java.io.IOException {
        /*
            java.lang.Class<java.io.File> r0 = java.io.File.class
            java.lang.String r1 = "setReadable"
            r2 = 2
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.Class r4 = java.lang.Boolean.TYPE     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            r5 = 0
            r3[r5] = r4     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.Class r4 = java.lang.Boolean.TYPE     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            r6 = 1
            r3[r6] = r4     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.reflect.Method r0 = r0.getMethod(r1, r3)     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.Class<java.io.File> r1 = java.io.File.class
            java.lang.String r3 = "setWritable"
            java.lang.Class[] r4 = new java.lang.Class[r2]     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.Class r7 = java.lang.Boolean.TYPE     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            r4[r5] = r7     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.Class r7 = java.lang.Boolean.TYPE     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            r4[r6] = r7     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.reflect.Method r1 = r1.getMethod(r3, r4)     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.Class<java.io.File> r3 = java.io.File.class
            java.lang.String r4 = "setExecutable"
            java.lang.Class[] r7 = new java.lang.Class[r2]     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.Class r8 = java.lang.Boolean.TYPE     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            r7[r5] = r8     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.Class r8 = java.lang.Boolean.TYPE     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            r7[r6] = r8     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.reflect.Method r3 = r3.getMethod(r4, r7)     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r5)     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            r4[r5] = r7     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r5)     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            r4[r6] = r7     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.Object r4 = r0.invoke(r10, r4)     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            boolean r4 = r4.booleanValue()     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            if (r4 == 0) goto L_0x0087
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r5)     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            r4[r5] = r7     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r5)     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            r4[r6] = r7     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.Object r4 = r1.invoke(r10, r4)     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            boolean r4 = r4.booleanValue()     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            if (r4 == 0) goto L_0x0087
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r5)     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            r4[r5] = r7     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r5)     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            r4[r6] = r7     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.Object r4 = r3.invoke(r10, r4)     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            boolean r4 = r4.booleanValue()     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            if (r4 != 0) goto L_0x00ab
        L_0x0087:
            java.util.logging.Logger r4 = LOGGER     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.String r7 = java.lang.String.valueOf(r10)     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            int r9 = r7.length()     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            int r9 = r9 + 44
            r8.<init>(r9)     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.String r9 = "unable to change permissions for everybody: "
            r8.append(r9)     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            r8.append(r7)     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.String r7 = r8.toString()     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            r4.warning(r7)     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
        L_0x00ab:
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r6)     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            r4[r5] = r7     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r6)     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            r4[r6] = r7     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.Object r0 = r0.invoke(r10, r4)     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            boolean r0 = r0.booleanValue()     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            if (r0 == 0) goto L_0x00f9
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r6)     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            r0[r5] = r4     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r6)     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            r0[r6] = r4     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.Object r0 = r1.invoke(r10, r0)     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            boolean r0 = r0.booleanValue()     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            if (r0 == 0) goto L_0x00f9
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r6)     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            r0[r5] = r1     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r6)     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            r0[r6] = r1     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.Object r0 = r3.invoke(r10, r0)     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            boolean r0 = r0.booleanValue()     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            if (r0 != 0) goto L_0x0147
        L_0x00f9:
            java.util.logging.Logger r0 = LOGGER     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.String r1 = java.lang.String.valueOf(r10)     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            int r3 = r1.length()     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            int r3 = r3 + 40
            r2.<init>(r3)     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.String r3 = "unable to change permissions for owner: "
            r2.append(r3)     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            r2.append(r1)     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            java.lang.String r1 = r2.toString()     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            r0.warning(r1)     // Catch:{ InvocationTargetException -> 0x0148, NoSuchMethodException -> 0x011e, IllegalAccessException | IllegalArgumentException | SecurityException -> 0x0147 }
            goto L_0x0147
        L_0x011e:
            java.util.logging.Logger r0 = LOGGER
            java.lang.String r10 = java.lang.String.valueOf(r10)
            java.lang.String r10 = java.lang.String.valueOf(r10)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r2 = r10.length()
            int r2 = r2 + 93
            r1.<init>(r2)
            java.lang.String r2 = "Unable to set permissions for "
            r1.append(r2)
            r1.append(r10)
            java.lang.String r10 = ", likely because you are running a version of Java prior to 1.6"
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            r0.warning(r10)
        L_0x0147:
            return
        L_0x0148:
            r10 = move-exception
            java.lang.Throwable r10 = r10.getCause()
            java.lang.Class<java.io.IOException> r0 = java.io.IOException.class
            com.google.api.client.util.Throwables.propagateIfPossible(r10, r0)
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.api.client.util.store.FileDataStoreFactory.setPermissionsToOwnerOnly(java.io.File):void");
    }
}
