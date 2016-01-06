package es.mresti.xemio.app.presenter;

import android.text.TextUtils;
import android.util.Log;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import es.mresti.xemio.app.contract.CreateAccountContract;
import es.mresti.xemio.app.utils.Constants;
import java.util.HashMap;
import java.util.Map;

public class CreateAccountPresenter implements CreateAccountContract.UserActionsListener {

  private Firebase mFirebaseRef;
  private AuthData mAuthData;
  private final CreateAccountContract.View mLogupView;

  public CreateAccountPresenter(CreateAccountContract.View logupView) {
    mLogupView = logupView;
    mFirebaseRef = new Firebase(Constants.FIREBASE_URL);
    mAuthData = mFirebaseRef.getAuth();
  }

  @Override public void setRegister(String email, String password1, String password2) {
    mLogupView.showProgress();
    this.register(email, password1, password2);
  }

  private void register(final String email, final String pass1, final String pass2) {
    boolean error = false;
    if (TextUtils.isEmpty(email)) {
      this.onEmailError();
      error = true;
    }
    if (TextUtils.isEmpty(pass1)) {
      this.onPassError1();
      error = true;
    }
    if (TextUtils.isEmpty(pass2)) {
      this.onPassError2();
      error = true;
    }
    if (pass1.length() != pass2.length()) {
      this.onPassErrorDistinct();
      error = true;
    }

    if (!pass1.equals(pass2)) {
      this.onPassErrorDistinct();
      error = true;
    }
    if (!error) {
      createUser(email, pass1);
    }
  }

  private void createUser(final String email, final String pass1) {
    mFirebaseRef.createUser(email, pass1, new Firebase.ValueResultHandler<Map<String, Object>>() {
      @Override public void onSuccess(Map<String, Object> result) {
        Log.w("creater user", "Successfully created user account with uid: " + result.get("uid"));
        authUserPass(email, pass1);
      }

      @Override public void onError(FirebaseError firebaseError) {
        // there was an error
        Log.e("creater user", "Error al crear user");
        manageErrorFirebase(firebaseError);
      }
    });
  }

  private void authUserPass(String email, String pass1) {
    mFirebaseRef.authWithPassword(email, pass1, new Firebase.AuthResultHandler() {
      @Override public void onAuthenticated(AuthData authData) {

        Map<String, String> map = new HashMap<String, String>();
        map.put(Constants.FIREBASE_PROPERTY_PROVIDER, authData.getProvider());
        if (authData.getProviderData().containsKey(Constants.FIREBASE_PROPERTY_NAME)) {
          map.put(Constants.FIREBASE_PROPERTY_NAME,
              authData.getProviderData().get(Constants.FIREBASE_PROPERTY_NAME).toString());
        }
        mFirebaseRef.child(Constants.FIREBASE_NODE_USERS).child(authData.getUid()).setValue(map);
        Log.w("logged user",
            "User ID: " + authData.getUid() + ", Provider: " + authData.getProvider());

        onSuccess();
      }

      @Override public void onAuthenticationError(FirebaseError error) {
        // there was an error
        Log.e("logged user", "Error al logged user");
        manageErrorFirebase(error);
      }
    });
  }

  private void manageErrorFirebase(FirebaseError error) {
    switch (error.getCode()) {
      case FirebaseError.USER_DOES_NOT_EXIST:
        showMessage(Constants.USER_DOES_NOT_EXIST);
        break;
      case FirebaseError.INVALID_EMAIL:
        showMessage(Constants.INVALID_EMAIL);
        break;
      case FirebaseError.EMAIL_TAKEN:
        showMessage(Constants.USER_EXIST);
        break;
      case FirebaseError.INVALID_CREDENTIALS:
        showMessage(Constants.INVALID_CREDENTIAL);
        break;
      case FirebaseError.INVALID_PASSWORD:
        showMessage(Constants.INVALID_PASSWORD);
        break;
      default:
        // handle other errors
        showMessage(Constants.OTHER_ERROR);
        break;
    }
  }

  private void onEmailError() {
    mLogupView.hideProgress();
    mLogupView.setEmailError();
  }

  private void onPassError1() {
    mLogupView.hideProgress();
    mLogupView.setPass1Error();
  }

  private void onPassError2() {
    mLogupView.hideProgress();
    mLogupView.setPass2Error();
  }

  private void onPassErrorDistinct() {
    mLogupView.hideProgress();
    mLogupView.setPassDistinctError();
  }

  private void onSuccess() {
    mLogupView.openExtra();
  }

  private void showMessage(String message) {
    mLogupView.hideProgress();
    mLogupView.showNotificationMessage(message);
  }
}
