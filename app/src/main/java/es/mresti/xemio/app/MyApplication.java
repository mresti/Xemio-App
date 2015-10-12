package es.mresti.xemio.app;

import android.app.Application;
import com.firebase.client.Firebase;
import com.squareup.leakcanary.LeakCanary;

public class MyApplication extends Application {
  @Override public void onCreate() {
    super.onCreate();
    Firebase.setAndroidContext(this);
    Firebase.getDefaultConfig().setPersistenceEnabled(true);
    LeakCanary.install(this);
  }
}
