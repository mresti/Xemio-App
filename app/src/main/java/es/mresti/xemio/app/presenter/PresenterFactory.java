package es.mresti.xemio.app.presenter;

import es.mresti.xemio.app.interactor.DashboardInteractor;
import es.mresti.xemio.app.interactor.DashboardInteractorImpl;
import es.mresti.xemio.app.interactor.NewIncidenceInteractor;
import es.mresti.xemio.app.interactor.NewIncidenceInteractorImpl;
import es.mresti.xemio.app.view.DashboardView;
import es.mresti.xemio.app.view.NewIncidenceView;

public class PresenterFactory {

  public static DashboardPresenter getDashboardPresenter(DashboardView view) {
    DashboardInteractor interactor = new DashboardInteractorImpl();
    return DashboardPresenter.newInstance(view, interactor);
  }

  public static NewIncidencePresenter getNewIncidencePresenter(NewIncidenceView view) {
    NewIncidenceInteractor interactor = new NewIncidenceInteractorImpl();
    return NewIncidencePresenter.newInstance(view, interactor);
  }
}
