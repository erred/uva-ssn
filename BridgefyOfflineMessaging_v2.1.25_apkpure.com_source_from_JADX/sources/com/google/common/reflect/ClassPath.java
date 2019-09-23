package com.google.common.reflect;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.ImmutableSortedSet.Builder;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.collect.Sets;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.jar.Attributes.Name;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.logging.Logger;

@Beta
public final class ClassPath {
    private static final String CLASS_FILE_NAME_EXTENSION = ".class";
    /* access modifiers changed from: private */
    public static final Splitter CLASS_PATH_ATTRIBUTE_SEPARATOR = Splitter.m8657on(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).omitEmptyStrings();
    private static final Predicate<ClassInfo> IS_TOP_LEVEL = new Predicate<ClassInfo>() {
        public boolean apply(ClassInfo classInfo) {
            return classInfo.className.indexOf(36) == -1;
        }
    };
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger(ClassPath.class.getName());
    private final ImmutableSet<ResourceInfo> resources;

    @Beta
    public static final class ClassInfo extends ResourceInfo {
        /* access modifiers changed from: private */
        public final String className;

        ClassInfo(String str, ClassLoader classLoader) {
            super(str, classLoader);
            this.className = ClassPath.getClassName(str);
        }

        public String getPackageName() {
            return Reflection.getPackageName(this.className);
        }

        public String getSimpleName() {
            int lastIndexOf = this.className.lastIndexOf(36);
            if (lastIndexOf != -1) {
                return CharMatcher.DIGIT.trimLeadingFrom(this.className.substring(lastIndexOf + 1));
            }
            String packageName = getPackageName();
            if (packageName.length() == 0) {
                return this.className;
            }
            return this.className.substring(packageName.length() + 1);
        }

        public String getName() {
            return this.className;
        }

        public Class<?> load() {
            try {
                return this.loader.loadClass(this.className);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException(e);
            }
        }

        public String toString() {
            return this.className;
        }
    }

    @Beta
    public static class ResourceInfo {
        final ClassLoader loader;
        private final String resourceName;

        /* renamed from: of */
        static ResourceInfo m8759of(String str, ClassLoader classLoader) {
            if (str.endsWith(ClassPath.CLASS_FILE_NAME_EXTENSION)) {
                return new ClassInfo(str, classLoader);
            }
            return new ResourceInfo(str, classLoader);
        }

        ResourceInfo(String str, ClassLoader classLoader) {
            this.resourceName = (String) Preconditions.checkNotNull(str);
            this.loader = (ClassLoader) Preconditions.checkNotNull(classLoader);
        }

        public final URL url() {
            return (URL) Preconditions.checkNotNull(this.loader.getResource(this.resourceName), "Failed to load resource: %s", this.resourceName);
        }

        public final String getResourceName() {
            return this.resourceName;
        }

        public int hashCode() {
            return this.resourceName.hashCode();
        }

        public boolean equals(Object obj) {
            boolean z = false;
            if (!(obj instanceof ResourceInfo)) {
                return false;
            }
            ResourceInfo resourceInfo = (ResourceInfo) obj;
            if (this.resourceName.equals(resourceInfo.resourceName) && this.loader == resourceInfo.loader) {
                z = true;
            }
            return z;
        }

        public String toString() {
            return this.resourceName;
        }
    }

    @VisibleForTesting
    static final class Scanner {
        private final Builder<ResourceInfo> resources = new Builder<>(Ordering.usingToString());
        private final Set<URI> scannedUris = Sets.newHashSet();

        Scanner() {
        }

        /* access modifiers changed from: 0000 */
        public ImmutableSortedSet<ResourceInfo> getResources() {
            return this.resources.build();
        }

        /* access modifiers changed from: 0000 */
        public void scan(URI uri, ClassLoader classLoader) throws IOException {
            if (uri.getScheme().equals("file") && this.scannedUris.add(uri)) {
                scanFrom(new File(uri), classLoader);
            }
        }

        /* access modifiers changed from: 0000 */
        @VisibleForTesting
        public void scanFrom(File file, ClassLoader classLoader) throws IOException {
            if (file.exists()) {
                if (file.isDirectory()) {
                    scanDirectory(file, classLoader);
                } else {
                    scanJar(file, classLoader);
                }
            }
        }

        private void scanDirectory(File file, ClassLoader classLoader) throws IOException {
            scanDirectory(file, classLoader, "", ImmutableSet.m8706of());
        }

        private void scanDirectory(File file, ClassLoader classLoader, String str, ImmutableSet<File> immutableSet) throws IOException {
            File canonicalFile = file.getCanonicalFile();
            if (!immutableSet.contains(canonicalFile)) {
                File[] listFiles = file.listFiles();
                if (listFiles == null) {
                    Logger access$100 = ClassPath.logger;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Cannot read directory ");
                    sb.append(file);
                    access$100.warning(sb.toString());
                    return;
                }
                ImmutableSet build = ImmutableSet.builder().addAll((Iterable) immutableSet).add((Object) canonicalFile).build();
                for (File file2 : listFiles) {
                    String name = file2.getName();
                    if (file2.isDirectory()) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str);
                        sb2.append(name);
                        sb2.append("/");
                        scanDirectory(file2, classLoader, sb2.toString(), build);
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str);
                        sb3.append(name);
                        String sb4 = sb3.toString();
                        if (!sb4.equals("META-INF/MANIFEST.MF")) {
                            this.resources.add((Object) ResourceInfo.m8759of(sb4, classLoader));
                        }
                    }
                }
            }
        }

        private void scanJar(File file, ClassLoader classLoader) throws IOException {
            try {
                JarFile jarFile = new JarFile(file);
                try {
                    Iterator it = getClassPathFromManifest(file, jarFile.getManifest()).iterator();
                    while (it.hasNext()) {
                        scan((URI) it.next(), classLoader);
                    }
                    Enumeration entries = jarFile.entries();
                    while (entries.hasMoreElements()) {
                        JarEntry jarEntry = (JarEntry) entries.nextElement();
                        if (!jarEntry.isDirectory()) {
                            if (!jarEntry.getName().equals("META-INF/MANIFEST.MF")) {
                                this.resources.add((Object) ResourceInfo.m8759of(jarEntry.getName(), classLoader));
                            }
                        }
                    }
                } finally {
                    try {
                        jarFile.close();
                    } catch (IOException unused) {
                    }
                }
            } catch (IOException unused2) {
            }
        }

        @VisibleForTesting
        static ImmutableSet<URI> getClassPathFromManifest(File file, Manifest manifest) {
            if (manifest == null) {
                return ImmutableSet.m8706of();
            }
            ImmutableSet.Builder builder = ImmutableSet.builder();
            String value = manifest.getMainAttributes().getValue(Name.CLASS_PATH.toString());
            if (value != null) {
                for (String str : ClassPath.CLASS_PATH_ATTRIBUTE_SEPARATOR.split(value)) {
                    try {
                        builder.add((Object) getClassPathEntry(file, str));
                    } catch (URISyntaxException unused) {
                        Logger access$100 = ClassPath.logger;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Invalid Class-Path entry: ");
                        sb.append(str);
                        access$100.warning(sb.toString());
                    }
                }
            }
            return builder.build();
        }

        @VisibleForTesting
        static URI getClassPathEntry(File file, String str) throws URISyntaxException {
            URI uri = new URI(str);
            if (uri.isAbsolute()) {
                return uri;
            }
            return new File(file.getParentFile(), str.replace('/', File.separatorChar)).toURI();
        }
    }

    private ClassPath(ImmutableSet<ResourceInfo> immutableSet) {
        this.resources = immutableSet;
    }

    public static ClassPath from(ClassLoader classLoader) throws IOException {
        Scanner scanner = new Scanner();
        Iterator it = getClassPathEntries(classLoader).entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            scanner.scan((URI) entry.getKey(), (ClassLoader) entry.getValue());
        }
        return new ClassPath(scanner.getResources());
    }

    public ImmutableSet<ResourceInfo> getResources() {
        return this.resources;
    }

    public ImmutableSet<ClassInfo> getAllClasses() {
        return FluentIterable.from((Iterable<E>) this.resources).filter(ClassInfo.class).toSet();
    }

    public ImmutableSet<ClassInfo> getTopLevelClasses() {
        return FluentIterable.from((Iterable<E>) this.resources).filter(ClassInfo.class).filter(IS_TOP_LEVEL).toSet();
    }

    public ImmutableSet<ClassInfo> getTopLevelClasses(String str) {
        Preconditions.checkNotNull(str);
        ImmutableSet.Builder builder = ImmutableSet.builder();
        Iterator it = getTopLevelClasses().iterator();
        while (it.hasNext()) {
            ClassInfo classInfo = (ClassInfo) it.next();
            if (classInfo.getPackageName().equals(str)) {
                builder.add((Object) classInfo);
            }
        }
        return builder.build();
    }

    public ImmutableSet<ClassInfo> getTopLevelClassesRecursive(String str) {
        Preconditions.checkNotNull(str);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append('.');
        String sb2 = sb.toString();
        ImmutableSet.Builder builder = ImmutableSet.builder();
        Iterator it = getTopLevelClasses().iterator();
        while (it.hasNext()) {
            ClassInfo classInfo = (ClassInfo) it.next();
            if (classInfo.getName().startsWith(sb2)) {
                builder.add((Object) classInfo);
            }
        }
        return builder.build();
    }

    @VisibleForTesting
    static ImmutableMap<URI, ClassLoader> getClassPathEntries(ClassLoader classLoader) {
        LinkedHashMap newLinkedHashMap = Maps.newLinkedHashMap();
        ClassLoader parent = classLoader.getParent();
        if (parent != null) {
            newLinkedHashMap.putAll(getClassPathEntries(parent));
        }
        if (classLoader instanceof URLClassLoader) {
            URL[] uRLs = ((URLClassLoader) classLoader).getURLs();
            int length = uRLs.length;
            int i = 0;
            while (i < length) {
                try {
                    URI uri = uRLs[i].toURI();
                    if (!newLinkedHashMap.containsKey(uri)) {
                        newLinkedHashMap.put(uri, classLoader);
                    }
                    i++;
                } catch (URISyntaxException e) {
                    throw new IllegalArgumentException(e);
                }
            }
        }
        return ImmutableMap.copyOf(newLinkedHashMap);
    }

    @VisibleForTesting
    static String getClassName(String str) {
        return str.substring(0, str.length() - CLASS_FILE_NAME_EXTENSION.length()).replace('/', '.');
    }
}
