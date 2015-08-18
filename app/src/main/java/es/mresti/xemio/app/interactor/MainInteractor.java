package es.mresti.xemio.app.interactor;

import es.mresti.xemio.app.presenter.MainPresenter;

public interface MainInteractor {
  void setPresenter(MainPresenter presenter);

  void userStatus();
}
