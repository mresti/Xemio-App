package es.mresti.xemio.app.presenter;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import es.mresti.xemio.app.contract.IncidenceListContract;
import es.mresti.xemio.app.utils.Constants;

public class IncidenceListPresenter implements IncidenceListContract.UserActionsListener {

  private Firebase mFirebaseRef;
  private AuthData mAuthData;
  private final IncidenceListContract.View mIncidenceView;

  public IncidenceListPresenter(IncidenceListContract.View incidencesView) {
    mIncidenceView = incidencesView;
    mFirebaseRef = new Firebase(Constants.FIREBASE_URL);
    mAuthData = mFirebaseRef.getAuth();
  }

  @Override public Firebase getIncidenceListRef() {
    return mFirebaseRef.child(Constants.FIREBASE_NODE_INCIDENCE).child(mAuthData.getUid());
  }
}


