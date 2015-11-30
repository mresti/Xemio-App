package es.mresti.xemio.app.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import es.mresti.xemio.R;
import es.mresti.xemio.app.contract.LoginContract;

public class LoginPresenter implements LoginContract.UserActionsListener {

  private Firebase mFirebaseRef;
  private Context mContext;
  private final LoginContract.View mLoginView;

  public LoginPresenter(@NonNull LoginContract.View loginView) {
    mLoginView = loginView;
  }

  @Override public void validateCredentials(String username, String password) {
    mLoginView.showProgress();
    this.login(username, password);
  }

  @Override public void initializeActions(Context c) {
    mContext = c;
    mFirebaseRef = new Firebase(mContext.getResources().getString(R.string.firebase_url));
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
      final Firebase firebaseRef = mFirebaseRef;
      firebaseRef.authWithPassword(username, password, new Firebase.AuthResultHandler() {
        @Override public void onAuthenticated(AuthData authData) {
          onSuccess();
        }

        @Override public void onAuthenticationError(FirebaseError error) {
          // there was an error
          Log.e("logged user", "Error al logged user");
          switch (error.getCode()) {
            case FirebaseError.USER_DOES_NOT_EXIST:
              // handle a non existing user
              //onUserNotExistError();
              break;
            case FirebaseError.INVALID_PASSWORD:
              // handle an invalid password
              //onInvalidPasswordError();
              break;
            default:
              // handle other errors
              //onAuthenticationError();
              break;
          }
        }
      });
    }
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

  private void onUserNotExistError() {
  }

  private void onInvalidPasswordError() {
  }

  private void onAuthenticationError() {
  }
}
