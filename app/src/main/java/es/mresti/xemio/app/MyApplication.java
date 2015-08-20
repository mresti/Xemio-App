package es.mresti.xemio.app;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {
  private static MyApplication singleton;
  private static Context mContext;

  public static MyApplication getInstance() {
    return singleton;
  }

  @Override public void onCreate() {
    super.onCreate();
    singleton = this;
  }

  public static Context getContext() {
    return mContext;
  }

  public static void setContext(Context c) {
    mContext = c;
  }
}
