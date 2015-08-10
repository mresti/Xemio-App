package es.mresti.xemio.app.interactor;

import android.os.Handler;
import es.mresti.xemio.app.presenter.VerifyPresenter;

public class VerifyInteractorImpl implements VerifyInteractor {
  private VerifyPresenter presenter;

  @Override public void setPresenter(VerifyPresenter presenter) {
    this.presenter = presenter;
  }

  @Override public void getVerify() {
    // Mock login. I'm creating a handler to delay the answer a couple of seconds
    new Handler().postDelayed(new Runnable() {
      @Override public void run() {
        presenter.onSuccess();
      }
    }, 2000);
  }

  @Override public void sendEmailUser() {
    // Mock login. I'm creating a handler to delay the answer a couple of seconds
    new Handler().postDelayed(new Runnable() {
      @Override public void run() {
        presenter.onSuccess2();
      }
    }, 2000);
  }
}

