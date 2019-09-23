package butterknife;

public interface Unbinder {
    public static final Unbinder EMPTY = new Unbinder() {
        public void unbind() {
        }
    };

    void unbind();
}
