package es.mresti.xemio.app.interactor;

import android.content.Context;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import es.mresti.xemio.R;
import es.mresti.xemio.app.presenter.MainPresenter;

public class MainInteractorImpl implements MainInteractor {
  private MainPresenter presenter;

  @Override public void setPresenter(MainPresenter presenter) {
    this.presenter = presenter;
  }

  @Override public void userStatus(Context c) {
    Firebase ref = new Firebase(c.getResources().getString(R.string.firebase_url));

    AuthData authData = ref.getAuth();
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
