package es.mresti.xemio.app.view.utils;

import android.content.Context;

public class Preferences {
  /**
   * Logout prefecence name
   */
  public static final String LOGOUTPREF = "logOutPref";

  /**
   * Application context
   */
  private static Context mContext;

  public Preferences(Context ctx) {
    mContext = ctx;
  }
}
