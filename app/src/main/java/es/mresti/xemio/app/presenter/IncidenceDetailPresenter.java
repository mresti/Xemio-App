package es.mresti.xemio.app.presenter;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import es.mresti.xemio.app.contract.IncidenceDetailContract;
import es.mresti.xemio.app.utils.Constants;

public class IncidenceDetailPresenter implements IncidenceDetailContract.UserActionsListener {

  private Firebase mFirebaseRef;
  private AuthData mAuthData;
  private final IncidenceDetailContract.View mIncidenceDetailView;

  public IncidenceDetailPresenter(IncidenceDetailContract.View incidenceDetailView) {
    mIncidenceDetailView = incidenceDetailView;
    mFirebaseRef = new Firebase(Constants.FIREBASE_URL);
    mAuthData = mFirebaseRef.getAuth();
  }

  @Override public Firebase getIncidenceRef(String key) {
    return mFirebaseRef.child(Constants.FIREBASE_NODE_INCIDENCE)
        .child(mAuthData.getUid())
        .child(key);
  }

  @Override public void removeIncidence(String key) {
    mFirebaseRef.child(Constants.FIREBASE_NODE_INCIDENCE)
        .child(mAuthData.getUid())
        .child(key)
        .removeValue();
  }
}
