package es.mresti.xemio.app.interactor;

import es.mresti.xemio.app.presenter.LoginPresenter;

public interface LoginInteractor {
  void setPresenter(LoginPresenter presenter);

  void login(String username, String password);
}
