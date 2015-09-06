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
  private LoginPresenter mPresenter;
  private Context mContext;
  private Firebase mFirebaseRef;

  @Override public void setPresenter(LoginPresenter presenter) {
    mPresenter = presenter;
  }

  @Override public void initialize(Context c) {
    mContext = c;
    mFirebaseRef = new Firebase(mContext.getResources().getString(R.string.firebase_url));
  }

  @Override public void login(final String username, final String password) {
    boolean error = false;
    if (TextUtils.isEmpty(username)) {
      mPresenter.onUsernameError();
      error = true;
    }
    if (TextUtils.isEmpty(password)) {
      mPresenter.onPasswordError();
      error = true;
    }
    if (!error) {
      final Firebase firebaseRef = mFirebaseRef;
      firebaseRef.authWithPassword(username, password, new Firebase.AuthResultHandler() {
        @Override public void onAuthenticated(AuthData authData) {
          mPresenter.onSuccess();
        }

        @Override public void onAuthenticationError(FirebaseError error) {
          // there was an error
          Log.e("logged user", "Error al logged user");
          switch (error.getCode()) {
            case FirebaseError.USER_DOES_NOT_EXIST:
              // handle a non existing user
              mPresenter.onUserNotExistError();
              break;
            case FirebaseError.INVALID_PASSWORD:
              // handle an invalid password
              mPresenter.onInvalidPasswordError();
              break;
            default:
              // handle other errors
              mPresenter.onAuthenticationError();
              break;
          }
        }
      });
    }
  }
}
