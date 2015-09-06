package es.mresti.xemio.app.interactor;

import android.content.Context;
import es.mresti.xemio.app.presenter.MainPresenter;

public interface MainInteractor {
  void setPresenter(MainPresenter presenter);

  void initialize(Context c);

  void userStatus();
}
