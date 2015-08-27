package es.mresti.xemio.app.interactor;

import android.content.Context;
import es.mresti.xemio.app.presenter.LogupPresenter;

public interface LogupInteractor {
  void setPresenter(LogupPresenter presenter);

  void register(Context c, String email, String pass1, String pass2);
}
