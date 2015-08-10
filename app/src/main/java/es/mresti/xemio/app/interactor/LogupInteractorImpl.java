package es.mresti.xemio.app.interactor;

import android.os.Handler;
import android.text.TextUtils;
import es.mresti.xemio.app.presenter.LogupPresenter;

public class LogupInteractorImpl implements LogupInteractor {
  private LogupPresenter presenter;

  @Override public void setPresenter(LogupPresenter presenter) {
    this.presenter = presenter;
  }

  @Override public void register(final String username, final String email, final String age) {
    // Mock login. I'm creating a handler to delay the answer a couple of seconds
    new Handler().postDelayed(new Runnable() {
      @Override public void run() {
        boolean error = false;
        if (TextUtils.isEmpty(username)){
          presenter.onUsernameError();
          error = true;
        }
        if (TextUtils.isEmpty(email)){
          presenter.onEmailError();
          error = true;
        }
        if (TextUtils.isEmpty(age)){
          presenter.onAgeError();
          error = true;
        }
        if (!error){
          presenter.onSuccess();
        }
      }
    }, 2000);
  }
}

