package es.mresti.xemio.app.presenter;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import es.mresti.xemio.app.contract.HistoricalDetailContract;
import es.mresti.xemio.app.utils.Constants;

public class HistoricalDetailPresenter implements HistoricalDetailContract.UserActionsListener {

  private Firebase mFirebaseRef;
  private AuthData mAuthData;
  private final HistoricalDetailContract.View mHistoricalDetailView;

  public HistoricalDetailPresenter(HistoricalDetailContract.View historicalDetailView) {
    mHistoricalDetailView = historicalDetailView;
    mFirebaseRef = new Firebase(Constants.FIREBASE_URL);
    mAuthData = mFirebaseRef.getAuth();
  }

  @Override public Firebase getHistoricalRef(String key) {
    return mFirebaseRef.child(Constants.FIREBASE_NODE_EFFECTS)
        .child("-Jy4JKD7Lz7PoKKIEyvI")
        .child(key);
  }
}


