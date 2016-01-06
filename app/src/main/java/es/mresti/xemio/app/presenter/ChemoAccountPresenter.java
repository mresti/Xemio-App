package es.mresti.xemio.app.presenter;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import es.mresti.xemio.app.contract.ChemoAccountContract;
import es.mresti.xemio.app.utils.Constants;
import java.util.HashMap;
import java.util.Map;

public class ChemoAccountPresenter implements ChemoAccountContract.UserActionsListener {

  private Firebase mFirebaseRef;
  private AuthData mAuthData;
  private final ChemoAccountContract.View mChemoView;

  public ChemoAccountPresenter(ChemoAccountContract.View chemoView) {
    mChemoView = chemoView;
    mFirebaseRef = new Firebase(Constants.FIREBASE_URL);
    mAuthData = mFirebaseRef.getAuth();
  }

  @Override public Firebase getChemoRef() {
    return mFirebaseRef.child(Constants.FIREBASE_NODE_CHEMO);
  }

  @Override public void setRegisterChemo(String key) {
    AuthData authData = mFirebaseRef.getAuth();
    Firebase userRef = mFirebaseRef.child(Constants.FIREBASE_NODE_USERS).child(authData.getUid());

    Map<String, Object> person = new HashMap<String, Object>();
    person.put(Constants.FIREBASE_PROPERTY_CHEMO, key);
    userRef.updateChildren(person);

    this.onSuccess();
  }

  private void onSuccess() {
    mChemoView.openDashboard();
  }
}