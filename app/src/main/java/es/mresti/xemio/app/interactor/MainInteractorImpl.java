package es.mresti.xemio.app.interactor;

import android.content.Context;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import es.mresti.xemio.R;
import es.mresti.xemio.app.presenter.MainPresenter;

public class MainInteractorImpl implements MainInteractor {
  private MainPresenter mPresenter;
  private Firebase mFirebaseRef;
  private Context mContext;

  @Override public void setPresenter(MainPresenter presenter) {
    mPresenter = presenter;
  }

  @Override public void initialize(Context c) {
    mContext = c;
    mFirebaseRef = new Firebase(mContext.getResources().getString(R.string.firebase_url));
  }

  @Override public void userStatus() {
    AuthData authData = mFirebaseRef.getAuth();
    if (authData != null) {
      // user authenticated
      // show dashboardActivity
      mPresenter.onSuccessAuth();
    } else {
      // no user authenticated
      // show mainActivity
      mPresenter.onFailAuth();
    }
  }
}
