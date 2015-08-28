package es.mresti.xemio.app.interactor;

import android.content.Context;
import es.mresti.xemio.app.presenter.ExtraPresenter;

public interface ExtraInteractor {
  void setPresenter(ExtraPresenter presenter);

  void saveExtraData(Context c, String username, String age);
}
