package es.mresti.xemio.app.interactor;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import es.mresti.xemio.R;
import es.mresti.xemio.app.presenter.LoginPresenter;

public class LoginInteractorImpl implements LoginInteractor {
  private LoginPresenter presenter;
  private Firebase mFirebaseRef;

  @Override public void setPresenter(LoginPresenter presenter) {
    this.presenter = presenter;
  }

  @Override public void login(Context c, final String username, final String password) {
    Context mContext = c;
    Firebase mFirebaseRef = new Firebase(mContext.getResources().getString(R.string.firebase_url));

    boolean error = false;
    if (TextUtils.isEmpty(username)) {
      presenter.onUsernameError();
      error = true;
    }
    if (TextUtils.isEmpty(password)) {
      presenter.onPasswordError();
      error = true;
    }
    if (!error) {
      final Firebase firebaseRef =
          new Firebase(mContext.getResources().getString(R.string.firebase_url));
      firebaseRef.authWithPassword(username, password, new Firebase.AuthResultHandler() {
        @Override public void onAuthenticated(AuthData authData) {
          presenter.onSuccess();
        }

        @Override public void onAuthenticationError(FirebaseError error) {
          // there was an error
          Log.e("logged user", "Error al logged user");
          switch (error.getCode()) {
            case FirebaseError.USER_DOES_NOT_EXIST:
              // handle a non existing user
              break;
            case FirebaseError.INVALID_PASSWORD:
              // handle an invalid password
              break;
            default:
              // handle other errors
              break;
          }
        }
      });
    }
  }
}
