package es.mresti.xemio.app;

import android.app.Application;
import com.firebase.client.Firebase;
import com.squareup.leakcanary.LeakCanary;

public class XemioApplication extends Application {
  @Override public void onCreate() {
    super.onCreate();
    /* Initialize Firebase */
    Firebase.setAndroidContext(this);
    Firebase.getDefaultConfig().setPersistenceEnabled(true);
    /* Install LeakCanary */
    LeakCanary.install(this);
  }
}
