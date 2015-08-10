package es.mresti.xemio.app.interactor;

import android.os.Handler;
import es.mresti.xemio.app.presenter.ChemoPresenter;

public class ChemoInteractorImpl implements ChemoInteractor {
  private ChemoPresenter presenter;

  @Override public void setPresenter(ChemoPresenter presenter) {
    this.presenter = presenter;
  }

  @Override public void setChemo() {
    // Mock login. I'm creating a handler to delay the answer a couple of seconds
    new Handler().postDelayed(new Runnable() {
      @Override public void run() {
        presenter.onSuccess();
      }
    }, 2000);
  }
}
