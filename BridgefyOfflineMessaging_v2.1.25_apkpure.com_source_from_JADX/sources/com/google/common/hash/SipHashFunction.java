package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.nio.ByteBuffer;

final class SipHashFunction extends AbstractStreamingHashFunction implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: c */
    private final int f6775c;

    /* renamed from: d */
    private final int f6776d;

    /* renamed from: k0 */
    private final long f6777k0;

    /* renamed from: k1 */
    private final long f6778k1;

    private static final class SipHasher extends AbstractStreamingHasher {
        private static final int CHUNK_SIZE = 8;

        /* renamed from: b */
        private long f6779b = 0;

        /* renamed from: c */
        private final int f6780c;

        /* renamed from: d */
        private final int f6781d;
        private long finalM = 0;

        /* renamed from: v0 */
        private long f6782v0 = 8317987319222330741L;

        /* renamed from: v1 */
        private long f6783v1 = 7237128888997146477L;

        /* renamed from: v2 */
        private long f6784v2 = 7816392313619706465L;

        /* renamed from: v3 */
        private long f6785v3 = 8387220255154660723L;

        SipHasher(int i, int i2, long j, long j2) {
            super(8);
            this.f6780c = i;
            this.f6781d = i2;
            this.f6782v0 ^= j;
            this.f6783v1 ^= j2;
            this.f6784v2 ^= j;
            this.f6785v3 ^= j2;
        }

        /* access modifiers changed from: protected */
        public void process(ByteBuffer byteBuffer) {
            this.f6779b += 8;
            processM(byteBuffer.getLong());
        }

        /* access modifiers changed from: protected */
        public void processRemaining(ByteBuffer byteBuffer) {
            this.f6779b += (long) byteBuffer.remaining();
            int i = 0;
            while (byteBuffer.hasRemaining()) {
                this.finalM ^= (((long) byteBuffer.get()) & 255) << i;
                i += 8;
            }
        }

        public HashCode makeHash() {
            this.finalM ^= this.f6779b << 56;
            processM(this.finalM);
            this.f6784v2 ^= 255;
            sipRound(this.f6781d);
            return HashCode.fromLong(((this.f6782v0 ^ this.f6783v1) ^ this.f6784v2) ^ this.f6785v3);
        }

        private void processM(long j) {
            this.f6785v3 ^= j;
            sipRound(this.f6780c);
            this.f6782v0 = j ^ this.f6782v0;
        }

        private void sipRound(int i) {
            for (int i2 = 0; i2 < i; i2++) {
                this.f6782v0 += this.f6783v1;
                this.f6784v2 += this.f6785v3;
                this.f6783v1 = Long.rotateLeft(this.f6783v1, 13);
                this.f6785v3 = Long.rotateLeft(this.f6785v3, 16);
                this.f6783v1 ^= this.f6782v0;
                this.f6785v3 ^= this.f6784v2;
                this.f6782v0 = Long.rotateLeft(this.f6782v0, 32);
                this.f6784v2 += this.f6783v1;
                this.f6782v0 += this.f6785v3;
                this.f6783v1 = Long.rotateLeft(this.f6783v1, 17);
                this.f6785v3 = Long.rotateLeft(this.f6785v3, 21);
                this.f6783v1 ^= this.f6784v2;
                this.f6785v3 ^= this.f6782v0;
                this.f6784v2 = Long.rotateLeft(this.f6784v2, 32);
            }
        }
    }

    public int bits() {
        return 64;
    }

    SipHashFunction(int i, int i2, long j, long j2) {
        Preconditions.checkArgument(i > 0, "The number of SipRound iterations (c=%s) during Compression must be positive.", Integer.valueOf(i));
        Preconditions.checkArgument(i2 > 0, "The number of SipRound iterations (d=%s) during Finalization must be positive.", Integer.valueOf(i2));
        this.f6775c = i;
        this.f6776d = i2;
        this.f6777k0 = j;
        this.f6778k1 = j2;
    }

    public Hasher newHasher() {
        SipHasher sipHasher = new SipHasher(this.f6775c, this.f6776d, this.f6777k0, this.f6778k1);
        return sipHasher;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hashing.sipHash");
        sb.append(this.f6775c);
        sb.append("");
        sb.append(this.f6776d);
        sb.append("(");
        sb.append(this.f6777k0);
        sb.append(", ");
        sb.append(this.f6778k1);
        sb.append(")");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof SipHashFunction)) {
            return false;
        }
        SipHashFunction sipHashFunction = (SipHashFunction) obj;
        if (this.f6775c == sipHashFunction.f6775c && this.f6776d == sipHashFunction.f6776d && this.f6777k0 == sipHashFunction.f6777k0 && this.f6778k1 == sipHashFunction.f6778k1) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return (int) ((((long) ((getClass().hashCode() ^ this.f6775c) ^ this.f6776d)) ^ this.f6777k0) ^ this.f6778k1);
    }
}
