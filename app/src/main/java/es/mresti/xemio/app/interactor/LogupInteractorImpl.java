package es.mresti.xemio.app.interactor;

import android.os.Handler;
import android.text.TextUtils;
import es.mresti.xemio.app.presenter.LogupPresenter;

public class LogupInteractorImpl implements LogupInteractor {
  private LogupPresenter presenter;

  @Override public void setPresenter(LogupPresenter presenter) {
    this.presenter = presenter;
  }

  @Override public void register(final String email, final String pass1, final String pass2) {
    // Mock login. I'm creating a handler to delay the answer a couple of seconds
    new Handler().postDelayed(new Runnable() {
      @Override public void run() {
        boolean error = false;
        if (TextUtils.isEmpty(email)) {
          presenter.onEmailError();
          error = true;
        }
        if (TextUtils.isEmpty(pass1)) {
          presenter.onPassError1();
          error = true;
        }
        if (TextUtils.isEmpty(pass2)) {
          presenter.onPassError2();
          error = true;
        }
        if (pass1.length() != pass2.length()) {
          presenter.onPassErrorDistinct();
          error = true;
        }

        if (!pass1.equals(pass2)) {
          presenter.onPassErrorDistinct();
          error = true;
        }
        if (!error) {
          presenter.onSuccess();
        }
      }
    }, 2000);
  }
}

