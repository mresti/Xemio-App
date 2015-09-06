package es.mresti.xemio.app.interactor;

import android.content.Context;
import es.mresti.xemio.app.presenter.DashboardPresenter;

public interface DashboardInteractor {
  void setPresenter(DashboardPresenter presenter);

  void initialize(Context c);

  void userStatus();
}

