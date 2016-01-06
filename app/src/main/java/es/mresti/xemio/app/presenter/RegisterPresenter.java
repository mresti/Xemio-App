package es.mresti.xemio.app.presenter;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import es.mresti.xemio.app.contract.RegisterContract;
import es.mresti.xemio.app.utils.Constants;

public class RegisterPresenter implements RegisterContract.UserActionsListener {

  private Firebase mFirebaseRef;
  private AuthData mAuthData;
  private final RegisterContract.View mRegisterView;

  public RegisterPresenter(RegisterContract.View registerView) {
    mRegisterView = registerView;
    mFirebaseRef = new Firebase(Constants.FIREBASE_URL);
    mAuthData = mFirebaseRef.getAuth();
  }
}
