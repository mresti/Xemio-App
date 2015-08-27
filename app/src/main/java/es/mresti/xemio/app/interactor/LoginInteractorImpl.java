package es.mresti.xemio.app.interactor;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.firebase.client.Firebase;
import es.mresti.xemio.app.presenter.LoginPresenter;

public class LoginInteractorImpl implements LoginInteractor {
  private LoginPresenter presenter;
  private Firebase mFirebaseRef;

  @Override public void setPresenter(LoginPresenter presenter) {
    this.presenter = presenter;
  }

  @Override public void login(Context c, final String username, final String password) {
    Context mContext = c;
    // Mock login. I'm creating a handler to delay the answer a couple of seconds
    new Handler().postDelayed(new Runnable() {
      @Override public void run() {
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
          presenter.onSuccess();
        }
      }
    }, 2000);
  }
}
