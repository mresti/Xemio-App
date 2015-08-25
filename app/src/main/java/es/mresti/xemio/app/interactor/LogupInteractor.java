package es.mresti.xemio.app.interactor;

import es.mresti.xemio.app.presenter.LogupPresenter;

public interface LogupInteractor {
  void setPresenter(LogupPresenter presenter);

  void register(String email, String pass1, String pass2);
}
