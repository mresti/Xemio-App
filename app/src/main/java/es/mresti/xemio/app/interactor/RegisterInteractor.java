package es.mresti.xemio.app.interactor;

import android.content.Context;
import es.mresti.xemio.app.presenter.RegisterPresenter;

public interface RegisterInteractor {
  void setPresenter(RegisterPresenter presenter);

  void initialize(Context c);
}
