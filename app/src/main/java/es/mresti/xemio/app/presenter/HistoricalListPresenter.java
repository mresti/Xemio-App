package es.mresti.xemio.app.presenter;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import es.mresti.xemio.app.contract.HistoricalListContract;
import es.mresti.xemio.app.utils.Constants;

public class HistoricalListPresenter implements HistoricalListContract.UserActionsListener {

  private Firebase mFirebaseRef;
  private AuthData mAuthData;
  private final HistoricalListContract.View mHistoricalView;

  public HistoricalListPresenter(HistoricalListContract.View historicalView) {
    mHistoricalView = historicalView;
    mFirebaseRef = new Firebase(Constants.FIREBASE_URL);
    mAuthData = mFirebaseRef.getAuth();
  }

  @Override public Firebase getHistoricalListRef() {
    return mFirebaseRef.child(Constants.FIREBASE_NODE_HISTORICAL).child(mAuthData.getUid());
  }
}
