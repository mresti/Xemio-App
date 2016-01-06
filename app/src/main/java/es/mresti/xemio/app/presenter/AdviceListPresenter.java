package es.mresti.xemio.app.presenter;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import es.mresti.xemio.app.contract.AdviceListContract;
import es.mresti.xemio.app.utils.Constants;

public class AdviceListPresenter implements AdviceListContract.UserActionsListener {

  private Firebase mFirebaseRef;
  private AuthData mAuthData;
  private String mEffectID;
  private final AdviceListContract.View mEffectView;

  public AdviceListPresenter(AdviceListContract.View effectsView) {
    mEffectView = effectsView;
    mFirebaseRef = new Firebase(Constants.FIREBASE_URL);
    mAuthData = mFirebaseRef.getAuth();
  }

  @Override public Firebase getAdviceListRef() {
    // TODO: retrieve idchemo by user
    //return mFirebaseRef.child("effects").child(mEffectID);
    return mFirebaseRef.child(Constants.FIREBASE_NODE_EFFECTS).child("-Jy4JKD7Lz7PoKKIEyvI");
  }
}
