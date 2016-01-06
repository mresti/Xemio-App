package es.mresti.xemio.app.presenter;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import es.mresti.xemio.app.contract.AdviceDetailContract;
import es.mresti.xemio.app.model.Historical;
import es.mresti.xemio.app.utils.Constants;

public class AdviceDetailPresenter implements AdviceDetailContract.UserActionsListener {

  private Firebase mFirebaseRef;
  private AuthData mAuthData;
  private final AdviceDetailContract.View mAdviceDetailView;

  public AdviceDetailPresenter(AdviceDetailContract.View effectDetailView) {
    mAdviceDetailView = effectDetailView;
    mFirebaseRef = new Firebase(Constants.FIREBASE_URL);
    mAuthData = mFirebaseRef.getAuth();
  }

  @Override public Firebase getAdviceRef(String key, String advice) {
    savedKeyInHistorical(key, advice);
    return mFirebaseRef.child(Constants.FIREBASE_NODE_EFFECTS)
        .child("-Jy4JKD7Lz7PoKKIEyvI")
        .child(key);
  }

  @Override public void savedKeyInHistorical(String key, String advice) {
    Firebase newListRef =
        mFirebaseRef.child(Constants.FIREBASE_NODE_HISTORICAL).child(mAuthData.getUid()).push();
    Historical historical = new Historical(key, advice);
    newListRef.setValue(historical);
  }
}



