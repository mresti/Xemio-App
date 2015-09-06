package es.mresti.xemio.app.interactor;

import android.content.Context;
import es.mresti.xemio.app.presenter.LogupPresenter;

public interface LogupInteractor {
  void setPresenter(LogupPresenter presenter);

  void initialize(Context c);

  void register(String email, String pass1, String pass2);
}
