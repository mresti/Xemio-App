package es.mresti.xemio.app.interactor;

import android.content.Context;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import es.mresti.xemio.R;
import es.mresti.xemio.app.presenter.MainPresenter;

public class MainInteractorImpl implements MainInteractor {
  private MainPresenter presenter;
  private Firebase mFirebaseRef;
  private Context mContext;

  @Override public void setPresenter(MainPresenter presenter) {
    this.presenter = presenter;
  }

  @Override public void userStatus(Context c) {
    this.mContext = c;
    mFirebaseRef = new Firebase(this.mContext.getResources().getString(R.string.firebase_url));

    AuthData authData = mFirebaseRef.getAuth();
    if (authData != null) {
      // user authenticated
      // show dashboardActivity
      presenter.onSuccessAuth();
    } else {
      // no user authenticated
      // show mainActivity
      presenter.onFailAuth();
    }
  }
}
