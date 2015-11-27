package es.mresti.xemio.app.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import es.mresti.xemio.R;
import es.mresti.xemio.app.contract.LogupContract;
import java.util.HashMap;
import java.util.Map;

import static android.support.test.espresso.core.deps.guava.base.Preconditions.checkNotNull;

public class LogupPresenter implements LogupContract.UserActionsListener {

  private Firebase mFirebaseRef;
  private Context mContext;
  private final LogupContract.View mLogupView;

  public LogupPresenter(@NonNull LogupContract.View logupView) {
    mLogupView = checkNotNull(logupView, "logupView cannot be null!");
  }

  @Override public void initializeActions(Context c) {
    mContext = c;
    mFirebaseRef = new Firebase(mContext.getResources().getString(R.string.firebase_url));
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
              ///onInvalidPasswordError();
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

  private void onEmailError() {
    mLogupView.setEmailError();
    mLogupView.hideProgress();
  }

  private void onPassError1() {
    mLogupView.setPass1Error();
    mLogupView.hideProgress();
  }

  private void onPassError2() {
    mLogupView.setPass2Error();
    mLogupView.hideProgress();
  }

  private void onPassErrorDistinct() {
    mLogupView.setPassDistinctError();
    mLogupView.hideProgress();
  }

  private void onSuccess() {
    mLogupView.openExtra();
  }

  private void onUserNotExistError() {
  }

  private void onInvalidPasswordError() {
  }

  private void onAuthenticationError() {
  }
}
