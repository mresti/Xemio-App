package es.mresti.xemio.app.view.navigation;

import android.content.Context;
import android.content.Intent;
import es.mresti.xemio.app.view.activity.AdviceDetailActivity;
import es.mresti.xemio.app.view.activity.ChatAddActivity;
import es.mresti.xemio.app.view.activity.ChatMessageActivity;
import es.mresti.xemio.app.view.activity.ChemoAccountActivity;
import es.mresti.xemio.app.view.activity.CreateAccountActivity;
import es.mresti.xemio.app.view.activity.DashboardActivity;
import es.mresti.xemio.app.view.activity.ExtraAccountActivity;
import es.mresti.xemio.app.view.activity.HistoricalListActivity;
import es.mresti.xemio.app.view.activity.IncidenceAddActivity;
import es.mresti.xemio.app.view.activity.IncidenceDetailActivity;
import es.mresti.xemio.app.view.activity.LoginActivity;
import es.mresti.xemio.app.view.activity.MainActivity;
import es.mresti.xemio.app.view.activity.NotificationListActivity;
import es.mresti.xemio.app.view.activity.RegisterActivity;
import es.mresti.xemio.app.view.activity.TreatmentDetailActivity;

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

  public void navigateToRegister(Context context) {
    if (context != null) {
      Intent intentToLaunch = RegisterActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  public void navigateToCreateAccount(Context context) {
    if (context != null) {
      Intent intentToLaunch = CreateAccountActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  public void navigateToExtraAccount(Context context) {
    if (context != null) {
      Intent intentToLaunch = ExtraAccountActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  public void navigateToChemoAccount(Context context) {
    if (context != null) {
      Intent intentToLaunch = ChemoAccountActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  public void navigateToDashboard(Context context) {
    if (context != null) {
      Intent intentToLaunch = DashboardActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  public void navigateToLogin(Context context) {
    if (context != null) {
      Intent intentToLaunch = LoginActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  public void navigateToNewIncidence(Context context) {
    if (context != null) {
      Intent intentToLaunch = IncidenceAddActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  public void navigateToNotifications(Context context) {
    if (context != null) {
      Intent intentToLaunch = NotificationListActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  public void navigateToHistorical(Context context) {
    if (context != null) {
      Intent intentToLaunch = HistoricalListActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  public void navigateToNewChat(Context context) {
    if (context != null) {
      Intent intentToLaunch = ChatAddActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  public void navigateToTreatmentDetail(Context context, String key) {
    if (context != null) {
      Intent intentToLaunch = TreatmentDetailActivity.getCallingIntent(context, key);
      context.startActivity(intentToLaunch);
    }
  }

  public void navigateToIncidenceDetail(Context context, String key) {
    if (context != null) {
      Intent intentToLaunch = IncidenceDetailActivity.getCallingIntent(context, key);
      context.startActivity(intentToLaunch);
    }
  }

  public void navigateToAdviceDetail(Context context, String key, String name) {
    if (context != null) {
      Intent intentToLaunch = AdviceDetailActivity.getCallingIntent(context, key, name);
      context.startActivity(intentToLaunch);
    }
  }

  public void navigateToChatMessage(Context context, String key) {
    if (context != null) {
      Intent intentToLaunch = ChatMessageActivity.getCallingIntent(context, key);
      context.startActivity(intentToLaunch);
    }
  }
}
