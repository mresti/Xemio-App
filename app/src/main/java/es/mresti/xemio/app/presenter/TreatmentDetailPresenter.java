package es.mresti.xemio.app.presenter;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import es.mresti.xemio.app.contract.TreatmentDetailContract;
import es.mresti.xemio.app.utils.Constants;

public class TreatmentDetailPresenter implements TreatmentDetailContract.UserActionsListener {

  private Firebase mFirebaseRef;
  private AuthData mAuthData;
  private final TreatmentDetailContract.View mTreatmentDetailView;

  public TreatmentDetailPresenter(TreatmentDetailContract.View treatmentDetailView) {
    mTreatmentDetailView = treatmentDetailView;
    mFirebaseRef = new Firebase(Constants.FIREBASE_URL);
    mAuthData = mFirebaseRef.getAuth();
  }

  @Override public Firebase getTreatmentRef(String key) {
    return mFirebaseRef.child(Constants.FIREBASE_NODE_TREATMENT).child(key);
  }
}
