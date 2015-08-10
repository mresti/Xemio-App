package es.mresti.xemio.app.interactor;

import es.mresti.xemio.app.presenter.CancerPresenter;

public interface CancerInteractor {
  void setPresenter(CancerPresenter presenter);

  void setCancer();
}

