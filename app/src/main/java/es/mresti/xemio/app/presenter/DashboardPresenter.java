package es.mresti.xemio.app.presenter;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import es.mresti.xemio.app.contract.DashboardContract;
import es.mresti.xemio.app.utils.Constants;

public class DashboardPresenter implements DashboardContract.UserActionsListener {

  private Firebase mFirebaseRef;
  private AuthData mAuthData;
  private final DashboardContract.View mDashboardView;

  public DashboardPresenter(DashboardContract.View dashboardView) {
    mDashboardView = dashboardView;
    mFirebaseRef = new Firebase(Constants.FIREBASE_URL);
    mAuthData = mFirebaseRef.getAuth();
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

  @Override public void getUserLogout() {
    mFirebaseRef.unauth();
  }

  public void onFailAuth() {
    mDashboardView.openMain();
  }
}