package es.mresti.xemio.app.navigation;

import android.content.Context;
import android.content.Intent;

import es.mresti.xemio.app.view.activity.CancerActivity;
import es.mresti.xemio.app.view.activity.ChemotherapyActivity;
import es.mresti.xemio.app.view.activity.DashboardActivity;
import es.mresti.xemio.app.view.activity.ExtraActivity;
import es.mresti.xemio.app.view.activity.IncidenceActivity;
import es.mresti.xemio.app.view.activity.LogInActivity;
import es.mresti.xemio.app.view.activity.LogUpActivity;
import es.mresti.xemio.app.view.activity.VerifiedActivity;
import es.mresti.xemio.app.view.activity.VerifyActivity;

/**
 * Class used to navigate through the application.
 */
public class Navigator {

  public void Navigator() {
    //empty
  }

  /**
   * Goes to the login screen.
   *
   * @param context A Context needed to open the destiny activity.
   */
  public void navigateToUserLogIn(Context context) {
    if (context != null){
      Intent intentToLaunch = LogInActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }


  /**
   * Goes to the logup screen.
   *
   * @param context A Context needed to open the destiny activity.
   */
  public void navigateToUserLogUp(Context context) {
    if (context != null){
      Intent intentToLaunch = LogUpActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  /**
   * Goes to the dashboard screen.
   *
   * @param context A Context needed to open the destiny activity.
   */
  public void navigateToDashboard(Context context) {
    if (context != null){
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
    if (context != null){
      Intent intentToLaunch = VerifyActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  /**
   * Goes to the user verified screen.
   *
   * @param context A Context needed to open the destiny activity.
   */
  public void navigateToVerified(Context context) {
    if (context != null){
      Intent intentToLaunch = VerifiedActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  /**
   * Goes to the cancer screen.
   *
   * @param context A Context needed to open the destiny activity.
   */
  public void navigateToCancer(Context context) {
    if (context != null){
      Intent intentToLaunch = CancerActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  /**
   * Goes to the chemotherapy screen.
   *
   * @param context A Context needed to open the destiny activity.
   */
  public void navigateToChemotherapy(Context context) {
    if (context != null){
      Intent intentToLaunch = ChemotherapyActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  /**
   * Goes to the extra screen.
   *
   * @param context A Context needed to open the destiny activity.
   */
  public void navigateToExtra(Context context) {
    if (context != null){
      Intent intentToLaunch = ExtraActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  /**
   * Goes to the new incidence screen.
   *
   * @param context A Context needed to open the destiny activity.
   */
  public void navigateToNewIncidence(Context context) {
    if (context != null){
      Intent intentToLaunch = IncidenceActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }
}
