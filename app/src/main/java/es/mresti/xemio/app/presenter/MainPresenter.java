package es.mresti.xemio.app.presenter;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import es.mresti.xemio.app.contract.MainContract;
import es.mresti.xemio.app.utils.Constants;

public class MainPresenter implements MainContract.UserActionsListener {
  private Firebase mFirebaseRef;
  private AuthData mAuthData;
  private final MainContract.View mMainView;

  public MainPresenter(MainContract.View mainView) {
    mMainView = mainView;
    mFirebaseRef = new Firebase(Constants.FIREBASE_URL);
    mAuthData = mFirebaseRef.getAuth();
  }

  @Override public void getUserStatus() {
    mMainView.hideProgress();
    this.userStatus();
  }

  private void onSuccessAuth() {
    mMainView.hideProgress();
    mMainView.openDashboard();
  }

  private void onFailAuth() {
    mMainView.showProgress();
  }

  private void userStatus() {
    AuthData authData = mFirebaseRef.getAuth();
    if (authData != null) {
      // user authenticated
      // show dashboardActivity
      this.onSuccessAuth();
    } else {
      // no user authenticated
      // show mainActivity
      this.onFailAuth();
    }
  }
}
