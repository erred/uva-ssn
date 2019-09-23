package org.msgpack.core.buffer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import org.msgpack.core.Preconditions;

public class InputStreamBufferInput implements MessageBufferInput {
    private final byte[] buffer;

    /* renamed from: in */
    private InputStream f9914in;

    public static MessageBufferInput newBufferInput(InputStream inputStream) {
        Preconditions.checkNotNull(inputStream, "InputStream is null");
        if (inputStream instanceof FileInputStream) {
            FileChannel channel = ((FileInputStream) inputStream).getChannel();
            if (channel != null) {
                return new ChannelBufferInput(channel);
            }
        }
        return new InputStreamBufferInput(inputStream);
    }

    public InputStreamBufferInput(InputStream inputStream) {
        this(inputStream, 8192);
    }

    public InputStreamBufferInput(InputStream inputStream, int i) {
        this.f9914in = (InputStream) Preconditions.checkNotNull(inputStream, "input is null");
        this.buffer = new byte[i];
    }

    public InputStream reset(InputStream inputStream) throws IOException {
        InputStream inputStream2 = this.f9914in;
        this.f9914in = inputStream;
        return inputStream2;
    }

    public MessageBuffer next() throws IOException {
        int read = this.f9914in.read(this.buffer);
        if (read == -1) {
            return null;
        }
        return MessageBuffer.wrap(this.buffer, 0, read);
    }

    public void close() throws IOException {
        this.f9914in.close();
    }
}
