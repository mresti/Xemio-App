package es.mresti.xemio.app.interactor;

import es.mresti.xemio.app.presenter.VerifyPresenter;

public interface VerifyInteractor {
  void setPresenter(VerifyPresenter presenter);

  void getVerify();

  void sendEmailUser();
}

