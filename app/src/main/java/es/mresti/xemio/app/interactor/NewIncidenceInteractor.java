package es.mresti.xemio.app.interactor;

import android.content.Context;
import es.mresti.xemio.app.presenter.NewIncidencePresenter;

public interface NewIncidenceInteractor {
  void setPresenter(NewIncidencePresenter presenter);

  void register(Context c, String subject, String description);
}
