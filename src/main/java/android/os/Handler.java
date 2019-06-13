package android.os;

public class Handler {
    public Handler(Looper looper) {
    }

    public boolean postDelayed(Runnable runnable, long delay) {
        return true;
    }

    public boolean post(Runnable runnable) {
        return true;
    }
}
