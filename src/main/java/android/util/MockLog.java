package android.util;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MockLog {
    private static PrintStream out = System.out;

    public static PrintStream getOut() {
        if(out == null) {
            return new PrintStream(new ByteArrayOutputStream());
        }
        return out;
    }

    public static void setOut(PrintStream out) {
        MockLog.out = out;
    }
}
