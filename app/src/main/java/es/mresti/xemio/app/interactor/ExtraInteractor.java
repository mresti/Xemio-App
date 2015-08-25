package es.mresti.xemio.app.interactor;

import es.mresti.xemio.app.presenter.ExtraPresenter;

public interface ExtraInteractor {
  void setPresenter(ExtraPresenter presenter);

  void saveExtraData(String username, String age);
}
