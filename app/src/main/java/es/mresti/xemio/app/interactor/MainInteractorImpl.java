package es.mresti.xemio.app.interactor;

import android.content.Context;
import com.firebase.client.Firebase;
import es.mresti.xemio.app.presenter.MainPresenter;

public class MainInteractorImpl implements MainInteractor {
  private MainPresenter presenter;

  @Override public void setPresenter(MainPresenter presenter) {
    this.presenter = presenter;
  }

  @Override public void userStatus(Context c) {
    Firebase.setAndroidContext(c);
    Firebase myFirebaseRef = new Firebase("https://<YOUR-FIREBASE-APP>.firebaseio.com/");
    myFirebaseRef.child("message").setValue("Do you have data? You'll love Firebasasase.");
    // show dashboardActivity

    // show verifyActivity

    // show mainActivity
  }
}
