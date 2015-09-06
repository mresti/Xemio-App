package es.mresti.xemio.app.interactor;

import android.content.Context;
import es.mresti.xemio.app.presenter.LoginPresenter;

public interface LoginInteractor {
  void setPresenter(LoginPresenter presenter);

  void initialize(Context c);

  void login(String username, String password);
}
