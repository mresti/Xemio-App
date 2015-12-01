package es.mresti.xemio.app.navigation;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import es.mresti.xemio.app.view.activity.AddIncidenceActivity;
import es.mresti.xemio.app.view.activity.ChemoActivity;
import es.mresti.xemio.app.view.activity.DashboardActivity;
import es.mresti.xemio.app.view.activity.EffectsActivity;
import es.mresti.xemio.app.view.activity.ExtraActivity;
import es.mresti.xemio.app.view.activity.IncidencesActivity;
import es.mresti.xemio.app.view.activity.InfoActivity;
import es.mresti.xemio.app.view.activity.LoginActivity;
import es.mresti.xemio.app.view.activity.LogupActivity;
import es.mresti.xemio.app.view.activity.MainActivity;
import es.mresti.xemio.app.view.activity.NotificationsActivity;
import es.mresti.xemio.app.view.activity.RegisterActivity;
import es.mresti.xemio.app.view.activity.SettingsActivity;
import es.mresti.xemio.app.view.activity.TreatmentDetailActivity;
import es.mresti.xemio.app.view.activity.TreatmentsActivity;

/**
 * Class used to navigate through the application.
 */
public class Navigator {

  public void Navigator() {
    //empty
  }

  public void navigateToMain(Context context) {
    if (context != null) {
      Intent intentToLaunch = MainActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  public void navigateToUserRegister(Context context) {
    if (context != null) {
      Intent intentToLaunch = RegisterActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  public void navigateToUserLogIn(Context context) {
    if (context != null) {
      Intent intentToLaunch = LoginActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  public void navigateToUserLogUp(Context context) {
    if (context != null) {
      Intent intentToLaunch = LogupActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  public void navigateToExtra(Context context) {
    if (context != null) {
      Intent intentToLaunch = ExtraActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  public void navigateToChemo(Context context) {
    if (context != null) {
      Intent intentToLaunch = ChemoActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  public void navigateToDashboard(Context context) {
    if (context != null) {
      Intent intentToLaunch = DashboardActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  public void navigateToInfo(Context context) {
    if (context != null) {
      Intent intentToLaunch = InfoActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  public void navigateToTreatment(Context context) {
    if (context != null) {
      Intent intentToLaunch = TreatmentsActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  public void navigateToTreatmentDetails(Context context, String key) {
    if (context != null) {
      Intent intentToLaunch = TreatmentDetailActivity.getCallingIntent(context, key);
      context.startActivity(intentToLaunch);
    }
  }

  public void navigateToNewIncidence(Context context) {
    if (context != null) {
      Intent intentToLaunch = AddIncidenceActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  public void navigateToHistory(Context context) {
    if (context != null) {
      Intent intentToLaunch = IncidencesActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  public void navigateToSettings(Context context) {
    if (context != null) {
      Intent intentToLaunch = SettingsActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  public void navigateToXemioWeb(Context context) {
    if (context != null) {
      Intent intentToLaunch = new Intent(Intent.ACTION_VIEW);
      intentToLaunch.setData(Uri.parse("http://xemio.org"));
      context.startActivity(intentToLaunch);
    }
  }

  public void navigateToEffect(Context context) {
    if (context != null) {
      Intent intentToLaunch = EffectsActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  public void navigateToNotifications(Context context) {
    if (context != null) {
      Intent intentToLaunch = NotificationsActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }
}
