package es.mresti.xemio.app.interactor;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import es.mresti.xemio.R;
import es.mresti.xemio.app.presenter.LogupPresenter;
import java.util.HashMap;
import java.util.Map;

public class LogupInteractorImpl implements LogupInteractor {
  private LogupPresenter mPresenter;
  private Context mContext;
  private Firebase mFirebaseRef;

  @Override public void setPresenter(LogupPresenter presenter) {
    mPresenter = presenter;
  }

  @Override public void initialize(Context c) {
    mContext = c;
    mFirebaseRef = new Firebase(mContext.getResources().getString(R.string.firebase_url));
  }

  @Override public void register(final String email, final String pass1, final String pass2) {
    boolean error = false;
    if (TextUtils.isEmpty(email)) {
      mPresenter.onEmailError();
      error = true;
    }
    if (TextUtils.isEmpty(pass1)) {
      mPresenter.onPassError1();
      error = true;
    }
    if (TextUtils.isEmpty(pass2)) {
      mPresenter.onPassError2();
      error = true;
    }
    if (pass1.length() != pass2.length()) {
      mPresenter.onPassErrorDistinct();
      error = true;
    }

    if (!pass1.equals(pass2)) {
      mPresenter.onPassErrorDistinct();
      error = true;
    }
    if (!error) {
      mFirebaseRef.createUser(email, pass1, new Firebase.ValueResultHandler<Map<String, Object>>() {
        @Override public void onSuccess(Map<String, Object> result) {
          Log.w("creater user", "Successfully created user account with uid: " + result.get("uid"));
        }

        @Override public void onError(FirebaseError firebaseError) {
          // there was an error
          Log.e("creater user", "Error al crear user");
        }
      });

      final Firebase firebaseRef = mFirebaseRef;
      firebaseRef.authWithPassword(email, pass1, new Firebase.AuthResultHandler() {
        @Override public void onAuthenticated(AuthData authData) {

          Map<String, String> map = new HashMap<String, String>();
          map.put("provider", authData.getProvider());
          if (authData.getProviderData().containsKey("displayName")) {
            map.put("displayName", authData.getProviderData().get("displayName").toString());
          }
          firebaseRef.child("users").child(authData.getUid()).setValue(map);
          Log.w("logged user",
              "User ID: " + authData.getUid() + ", Provider: " + authData.getProvider());

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

