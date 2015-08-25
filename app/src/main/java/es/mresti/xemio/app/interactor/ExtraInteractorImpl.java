package es.mresti.xemio.app.interactor;

import android.os.Handler;
import android.text.TextUtils;
import es.mresti.xemio.app.presenter.ExtraPresenter;

public class ExtraInteractorImpl implements ExtraInteractor {
  private ExtraPresenter presenter;

  @Override public void setPresenter(ExtraPresenter presenter) {
    this.presenter = presenter;
  }

  @Override public void saveExtraData(final String username, final String age) {
    // Mock login. I'm creating a handler to delay the answer a couple of seconds
    new Handler().postDelayed(new Runnable() {
      @Override public void run() {
        boolean error = false;
        if (TextUtils.isEmpty(username)) {
          presenter.onUsernameError();
          error = true;
        }
        if (TextUtils.isEmpty(age)) {
          presenter.onAgeError();
          error = true;
        }
        if (!error) {
          presenter.onSuccess();
        }
      }
    }, 2000);
  }
}
