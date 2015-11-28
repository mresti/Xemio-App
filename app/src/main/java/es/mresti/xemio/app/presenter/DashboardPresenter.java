package es.mresti.xemio.app.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import es.mresti.xemio.R;
import es.mresti.xemio.app.contract.DashboardContract;

import static android.support.test.espresso.core.deps.guava.base.Preconditions.checkNotNull;

public class DashboardPresenter implements DashboardContract.UserActionsListener {

  private Firebase mFirebaseRef;
  private Context mContext;
  private final DashboardContract.View mDashboardView;

  public DashboardPresenter(@NonNull DashboardContract.View dashboardView) {
    mDashboardView = checkNotNull(dashboardView, "dashboardView cannot be null!");
  }

  @Override public void initializeActions(Context c) {
    mContext = c;
    mFirebaseRef = new Firebase(mContext.getResources().getString(R.string.firebase_url));
  }

  @Override public void getUserStatus() {
    AuthData authData = mFirebaseRef.getAuth();
    if (authData != null) {
      // user authenticated
      // show dashboardActivity
    } else {
      // no user authenticated
      // show mainActivity
      this.onFailAuth();
    }
  }

  public void onFailAuth() {
    mDashboardView.openMain();
  }
}