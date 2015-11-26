package es.mresti.xemio.app.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import es.mresti.xemio.R;
import es.mresti.xemio.app.contract.MainContract;

import static android.support.test.espresso.core.deps.guava.base.Preconditions.checkNotNull;

public class MainPresenter implements MainContract.UserActionsListener {
  private Firebase mFirebaseRef;
  private Context mContext;
  private final MainContract.View mMainView;

  public MainPresenter(@NonNull MainContract.View mainView) {
    mMainView = checkNotNull(mainView, "notesView cannot be null!");
  }

  @Override public void initializeActions(Context c) {
    mContext = c;
    mFirebaseRef = new Firebase(mContext.getResources().getString(R.string.firebase_url));
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
