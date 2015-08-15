package es.mresti.xemio.app.navigation;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import es.mresti.xemio.app.view.activity.CancerActivity;
import es.mresti.xemio.app.view.activity.ChemoActivity;
import es.mresti.xemio.app.view.activity.DashboardActivity;
import es.mresti.xemio.app.view.activity.IncidenceActivity;
import es.mresti.xemio.app.view.activity.LoginActivity;
import es.mresti.xemio.app.view.activity.LogupActivity;
import es.mresti.xemio.app.view.activity.PassActivity;
import es.mresti.xemio.app.view.activity.RegisterActivity;
import es.mresti.xemio.app.view.activity.SettingsActivity;
import es.mresti.xemio.app.view.activity.VerifyActivity;

/**
 * Class used to navigate through the application.
 */
public class Navigator {

  public void Navigator() {
    //empty
  }

  /**
   * Goes to the User register screen.
   *
   * @param context A Context needed to open the destiny activity.
   */
  public void navigateToUserRegister(Context context) {
    if (context != null) {
      Intent intentToLaunch = RegisterActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  /**
   * Goes to the login screen.
   *
   * @param context A Context needed to open the destiny activity.
   */
  public void navigateToUserLogIn(Context context) {
    if (context != null) {
      Intent intentToLaunch = LoginActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  /**
   * Goes to the logup screen.
   *
   * @param context A Context needed to open the destiny activity.
   */
  public void navigateToUserLogUp(Context context) {
    if (context != null) {
      Intent intentToLaunch = LogupActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  /**
   * Goes to the dashboard screen.
   *
   * @param context A Context needed to open the destiny activity.
   */
  public void navigateToDashboard(Context context) {
    if (context != null) {
      Intent intentToLaunch = DashboardActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  /**
   * Goes to the user verify screen.
   *
   * @param context A Context needed to open the destiny activity.
   */
  public void navigateToVerify(Context context) {
    if (context != null) {
      Intent intentToLaunch = VerifyActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  /**
   * Goes to the cancer screen.
   *
   * @param context A Context needed to open the destiny activity.
   */
  public void navigateToCancer(Context context) {
    if (context != null) {
      Intent intentToLaunch = CancerActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  /**
   * Goes to the chemotherapy screen.
   *
   * @param context A Context needed to open the destiny activity.
   */
  public void navigateToChemo(Context context) {
    if (context != null) {
      Intent intentToLaunch = ChemoActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  /**
   * Goes to the pass screen.
   *
   * @param context A Context needed to open the destiny activity.
   */
  public void navigateToPass(Context context) {
    if (context != null) {
      Intent intentToLaunch = PassActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  /**
   * Goes to the new incidence screen.
   *
   * @param context A Context needed to open the destiny activity.
   */
  public void navigateToNewIncidence(Context context) {
    if (context != null) {
      Intent intentToLaunch = IncidenceActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  /**
   * Goes to the xemio website.
   *
   * @param context A Context needed to open the destiny activity.
   */
  public void navigateToXemioWeb(Context context) {
    if (context != null) {
      Intent intentToLaunch = new Intent(Intent.ACTION_VIEW);
      intentToLaunch.setData(Uri.parse("http://xemio.org"));
      context.startActivity(intentToLaunch);
    }
  }

  public void navigateToSettings(Context context) {
    if (context != null) {
      Intent intentToLaunch = SettingsActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }
}
