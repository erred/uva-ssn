package com.fasterxml.jackson.core;

import java.io.Serializable;

public class Version implements Serializable, Comparable<Version> {
    private static final Version UNKNOWN_VERSION;
    private static final long serialVersionUID = 1;
    protected final String _artifactId;
    protected final String _groupId;
    protected final int _majorVersion;
    protected final int _minorVersion;
    protected final int _patchLevel;
    protected final String _snapshotInfo;

    static {
        Version version = new Version(0, 0, 0, null, null, null);
        UNKNOWN_VERSION = version;
    }

    @Deprecated
    public Version(int i, int i2, int i3, String str) {
        this(i, i2, i3, str, null, null);
    }

    public Version(int i, int i2, int i3, String str, String str2, String str3) {
        this._majorVersion = i;
        this._minorVersion = i2;
        this._patchLevel = i3;
        this._snapshotInfo = str;
        if (str2 == null) {
            str2 = "";
        }
        this._groupId = str2;
        if (str3 == null) {
            str3 = "";
        }
        this._artifactId = str3;
    }

    public static Version unknownVersion() {
        return UNKNOWN_VERSION;
    }

    public boolean isUnknownVersion() {
        return this == UNKNOWN_VERSION;
    }

    public boolean isSnapshot() {
        return this._snapshotInfo != null && this._snapshotInfo.length() > 0;
    }

    @Deprecated
    public boolean isUknownVersion() {
        return isUnknownVersion();
    }

    public int getMajorVersion() {
        return this._majorVersion;
    }

    public int getMinorVersion() {
        return this._minorVersion;
    }

    public int getPatchLevel() {
        return this._patchLevel;
    }

    public String getGroupId() {
        return this._groupId;
    }

    public String getArtifactId() {
        return this._artifactId;
    }

    public String toFullString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this._groupId);
        sb.append('/');
        sb.append(this._artifactId);
        sb.append('/');
        sb.append(toString());
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this._majorVersion);
        sb.append('.');
        sb.append(this._minorVersion);
        sb.append('.');
        sb.append(this._patchLevel);
        if (isSnapshot()) {
            sb.append('-');
            sb.append(this._snapshotInfo);
        }
        return sb.toString();
    }

    public int hashCode() {
        return this._artifactId.hashCode() ^ (((this._groupId.hashCode() + this._majorVersion) - this._minorVersion) + this._patchLevel);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        Version version = (Version) obj;
        if (!(version._majorVersion == this._majorVersion && version._minorVersion == this._minorVersion && version._patchLevel == this._patchLevel && version._artifactId.equals(this._artifactId) && version._groupId.equals(this._groupId))) {
            z = false;
        }
        return z;
    }

    public int compareTo(Version version) {
        if (version == this) {
            return 0;
        }
        int compareTo = this._groupId.compareTo(version._groupId);
        if (compareTo == 0) {
            compareTo = this._artifactId.compareTo(version._artifactId);
            if (compareTo == 0) {
                compareTo = this._majorVersion - version._majorVersion;
                if (compareTo == 0) {
                    compareTo = this._minorVersion - version._minorVersion;
                    if (compareTo == 0) {
                        compareTo = this._patchLevel - version._patchLevel;
                    }
                }
            }
        }
        return compareTo;
    }
}
