package es.mresti.xemio.app.presenter;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import es.mresti.xemio.app.contract.TreatmentListContract;
import es.mresti.xemio.app.utils.Constants;

public class TreatmentListPresenter implements TreatmentListContract.UserActionsListener {

  private Firebase mFirebaseRef;
  private AuthData mAuthData;
  private final TreatmentListContract.View mTreatmentView;

  public TreatmentListPresenter(TreatmentListContract.View treatmentsView) {
    mTreatmentView = treatmentsView;
    mFirebaseRef = new Firebase(Constants.FIREBASE_URL);
    mAuthData = mFirebaseRef.getAuth();
  }

  @Override public Firebase getTreatmentListRef() {
    return mFirebaseRef.child(Constants.FIREBASE_NODE_TREATMENT);
  }
}
