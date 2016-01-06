package es.mresti.xemio.app.presenter;

import android.text.TextUtils;
import android.util.Log;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import es.mresti.xemio.app.contract.LoginContract;
import es.mresti.xemio.app.utils.Constants;

public class LoginPresenter implements LoginContract.UserActionsListener {

  private Firebase mFirebaseRef;
  private AuthData mAuthData;
  private final LoginContract.View mLoginView;

  public LoginPresenter(LoginContract.View loginView) {
    mLoginView = loginView;
    mFirebaseRef = new Firebase(Constants.FIREBASE_URL);
    mAuthData = mFirebaseRef.getAuth();
  }

  @Override public void validateCredentials(String username, String password) {
    mLoginView.showProgress();
    this.login(username, password);
  }

  public void login(final String username, final String password) {

    boolean error = false;
    if (TextUtils.isEmpty(username)) {
      this.onUsernameError();
      error = true;
    }
    if (TextUtils.isEmpty(password)) {
      this.onPasswordError();
      error = true;
    }
    if (!error) {
      this.onConnected(username, password);
    }
  }

  public void onConnected(final String username, final String password) {
    mFirebaseRef.authWithPassword(username, password, new Firebase.AuthResultHandler() {
      @Override public void onAuthenticated(AuthData authData) {
        onSuccess();
      }

      @Override public void onAuthenticationError(FirebaseError error) {
        // there was an error
        Log.e("logged user", "Error al logged user");
        Log.e("logger uder", error.toString());
        Log.e("logger uder", String.valueOf(error.getCode()));
        switch (error.getCode()) {
          case FirebaseError.USER_DOES_NOT_EXIST:
            // handle a non existing user
            showMessage(Constants.USER_DOES_NOT_EXIST);
            break;
          case FirebaseError.INVALID_PASSWORD:
            // handle an invalid password
            showMessage(Constants.INVALID_PASSWORD);
            break;
          default:
            // handle other errors
            showMessage(Constants.OTHER_ERROR);
            break;
        }
      }
    });
  }

  private void onUsernameError() {
    mLoginView.setUsernameError();
    mLoginView.hideProgress();
  }

  private void onPasswordError() {
    mLoginView.setPasswordError();
    mLoginView.hideProgress();
  }

  private void onSuccess() {
    mLoginView.openDashboard();
  }

  private void showMessage(String message) {
    mLoginView.showNotificationMessage(message);
    mLoginView.hideProgress();
  }
}
