package android.app;

import android.content.ContextWrapper;
import android.os.Bundle;

public class Application extends ContextWrapper {
    public Application() {
        super(null);
    }


    public void registerActivityLifecycleCallbacks(ActivityLifecycleCallbacks callbacks) {
    }

    public interface ActivityLifecycleCallbacks {
        void onActivityCreated(Activity activity, Bundle savedInstanceState);
        void onActivityStarted(Activity activity);
        void onActivityResumed(Activity activity);
        void onActivityPaused(Activity activity);
        void onActivityStopped(Activity activity);
        void onActivitySaveInstanceState(Activity activity, Bundle outState);
        void onActivityDestroyed(Activity activity);
    }
}
