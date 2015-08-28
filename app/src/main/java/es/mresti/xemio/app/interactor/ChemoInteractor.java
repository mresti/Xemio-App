package es.mresti.xemio.app.interactor;

import android.content.Context;
import es.mresti.xemio.app.presenter.ChemoPresenter;

public interface ChemoInteractor {
  void setPresenter(ChemoPresenter presenter);

  void setChemo(Context c);
}

