package es.mresti.xemio.app.presenter;

import android.text.TextUtils;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import es.mresti.xemio.app.contract.ExtraAccountContract;
import es.mresti.xemio.app.utils.Constants;
import java.util.HashMap;
import java.util.Map;

public class ExtraAccountPresenter implements ExtraAccountContract.UserActionsListener {

  private Firebase mFirebaseRef;
  private AuthData mAuthData;
  private final ExtraAccountContract.View mExtraView;

  public ExtraAccountPresenter(ExtraAccountContract.View extraView) {
    mExtraView = extraView;
    mFirebaseRef = new Firebase(Constants.FIREBASE_URL);
    mAuthData = mFirebaseRef.getAuth();
  }

  @Override public void setRegisterExtra(String username, String age) {
    mExtraView.showProgress();
    this.saveExtraData(username, age);
  }

  private void saveExtraData(final String username, final String age) {
    boolean error = false;
    if (TextUtils.isEmpty(username)) {
      this.onUsernameError();
      error = true;
    }
    if (TextUtils.isEmpty(age)) {
      this.onAgeError();
      error = true;
    }
    if (!error) {
      AuthData authData = mFirebaseRef.getAuth();
      Firebase userRef = mFirebaseRef.child(Constants.FIREBASE_NODE_USERS).child(authData.getUid());

      Map<String, Object> person = new HashMap<String, Object>();
      person.put(Constants.FIREBASE_PROPERTY_FULLNAME, username);
      person.put(Constants.FIREBASE_PROPERTY_AGE, age);
      userRef.updateChildren(person);

      this.onSuccess();
    }
  }

  public void onUsernameError() {
    mExtraView.hideProgress();
    mExtraView.setUsernameError();
  }

  public void onAgeError() {
    mExtraView.hideProgress();
    mExtraView.setAgeError();
  }

  public void onSuccess() {
    mExtraView.openChemo();
  }
}
