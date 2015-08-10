package es.mresti.xemio.app.interactor;

import android.os.Handler;
import es.mresti.xemio.app.presenter.CancerPresenter;

public class CancerInteractorImpl implements CancerInteractor {
  private CancerPresenter presenter;

  @Override public void setPresenter(CancerPresenter presenter) {
    this.presenter = presenter;
  }

  @Override public void setCancer() {
    // Mock login. I'm creating a handler to delay the answer a couple of seconds
    new Handler().postDelayed(new Runnable() {
      @Override public void run() {
        presenter.onSuccess();
      }
    }, 2000);
  }
}

