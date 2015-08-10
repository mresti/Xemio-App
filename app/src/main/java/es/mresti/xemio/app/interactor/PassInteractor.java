package es.mresti.xemio.app.interactor;

import es.mresti.xemio.app.presenter.PassPresenter;

public interface PassInteractor {
  void setPresenter(PassPresenter presenter);

  void setPass(String pass1, String pass2);
}

