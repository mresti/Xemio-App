package es.mresti.xemio.app.interactor;

import android.os.Handler;
import android.text.TextUtils;
import es.mresti.xemio.app.presenter.PassPresenter;

public class PassInteractorImpl implements PassInteractor {
  private PassPresenter presenter;

  @Override public void setPresenter(PassPresenter presenter) {
    this.presenter = presenter;
  }

  @Override public void setPass(final String pass1, final String pass2) {
    // Mock login. I'm creating a handler to delay the answer a couple of seconds
    new Handler().postDelayed(new Runnable() {
      @Override public void run() {
        boolean error = false;
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

        if (pass1.equals(pass2)) {
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
