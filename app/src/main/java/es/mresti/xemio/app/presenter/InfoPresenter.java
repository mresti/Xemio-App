package es.mresti.xemio.app.presenter;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import es.mresti.xemio.app.contract.InfoContract;
import es.mresti.xemio.app.utils.Constants;

public class InfoPresenter implements InfoContract.UserActionsListener {

  private Firebase mFirebaseRef;
  private AuthData mAuthData;
  private final InfoContract.View mInfoView;

  public InfoPresenter(InfoContract.View infoView) {
    mInfoView = infoView;
    mFirebaseRef = new Firebase(Constants.FIREBASE_URL);
    mAuthData = mFirebaseRef.getAuth();
  }
}
