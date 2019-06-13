package android.util;

/**
 * Mock of android.util.Log
 */
public class Log {
    public static int d(String tag, String msg) {
        MockLog.getOut().println("DEBUG: " + tag + ": " + msg);
        return 0;
    }

    public static int i(String tag, String msg) {
        MockLog.getOut().println("INFO: " + tag + ": " + msg);
        return 0;
    }

    public static int w(String tag, String msg) {
        MockLog.getOut().println("WARN: " + tag + ": " + msg);
        return 0;
    }

    public static int e(String tag, String msg) {
        MockLog.getOut().println("ERROR: " + tag + ": " + msg);
        return 0;
    }
}