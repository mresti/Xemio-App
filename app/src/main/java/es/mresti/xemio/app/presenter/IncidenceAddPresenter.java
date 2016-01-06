package es.mresti.xemio.app.presenter;

import android.text.TextUtils;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import es.mresti.xemio.app.contract.IncidenceAddContract;
import es.mresti.xemio.app.model.Incidence;
import es.mresti.xemio.app.utils.Constants;

public class IncidenceAddPresenter implements IncidenceAddContract.UserActionsListener {

  private Firebase mFirebaseRef;
  private AuthData mAuthData;
  private final IncidenceAddContract.View mAddIncidenceView;

  public IncidenceAddPresenter(IncidenceAddContract.View addIncidenceView) {
    mAddIncidenceView = addIncidenceView;
    mFirebaseRef = new Firebase(Constants.FIREBASE_URL);
    mAuthData = mFirebaseRef.getAuth();
  }

  @Override public void addIncidence(String subject, String description) {
    boolean error = false;

    if (TextUtils.isEmpty(subject)) {
      this.onSubjectError();
      error = true;
    }

    if (TextUtils.isEmpty(description)) {
      this.onDescriptionError();
      error = true;
    }

    if (!error) {
      this.createIncidence(subject, description);
    }
  }

  private void createIncidence(String subject, String desc) {
    Firebase userRef =
        mFirebaseRef.child(Constants.FIREBASE_NODE_INCIDENCE).child(mAuthData.getUid());

    // item 1
    Firebase item = userRef.push();

    Incidence ala = new Incidence(subject, desc);
    item.setValue(ala);
    this.onSuccess();
  }

  private void onSubjectError() {
    mAddIncidenceView.setSubjectError();
  }

  private void onDescriptionError() {
    mAddIncidenceView.setDescriptionError();
  }

  private void onSuccess() {
    mAddIncidenceView.showNotificationCreated();
  }
}
