package es.mresti.xemio.app.interactor;

import android.content.Context;
import es.mresti.xemio.app.datasource.ApiData;
import es.mresti.xemio.app.datasource.ApiDataImpl;
import es.mresti.xemio.app.presenter.MainPresenter;

public class MainInteractorImpl implements MainInteractor {
  private MainPresenter presenter;

  @Override public void setPresenter(MainPresenter presenter) {
    this.presenter = presenter;
  }

  @Override public void userStatus(Context c) {
    ApiData api = new ApiDataImpl(c);
    api.addIncidence("hola", "hola");
    // show dashboardActivity

    // show verifyActivity

    // show mainActivity
  }
}
