package es.mresti.xemio.app.presenter;

import es.mresti.xemio.app.interactor.DashboardInteractor;
import es.mresti.xemio.app.interactor.DashboardInteractorImpl;
import es.mresti.xemio.app.interactor.DetailEffectInteractor;
import es.mresti.xemio.app.interactor.DetailEffectInteractorImpl;
import es.mresti.xemio.app.interactor.DetailIncidenceInteractor;
import es.mresti.xemio.app.interactor.DetailIncidenceInteractorImpl;
import es.mresti.xemio.app.interactor.DetailTreatmentInteractor;
import es.mresti.xemio.app.interactor.DetailTreatmentInteractorImpl;
import es.mresti.xemio.app.interactor.NewIncidenceInteractor;
import es.mresti.xemio.app.interactor.NewIncidenceInteractorImpl;
import es.mresti.xemio.app.view.DashboardView;
import es.mresti.xemio.app.view.DetailEffectView;
import es.mresti.xemio.app.view.DetailIncidenceView;
import es.mresti.xemio.app.view.DetailTreatmentView;
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

  public static DetailIncidencePresenter getDetailIncidencePresenter(DetailIncidenceView view) {
    DetailIncidenceInteractor interactor = new DetailIncidenceInteractorImpl();
    return DetailIncidencePresenter.newInstance(view, interactor);
  }

  public static DetailTreatmentPresenter getDetailTreatmentPresenter(DetailTreatmentView view) {
    DetailTreatmentInteractor interactor = new DetailTreatmentInteractorImpl();
    return DetailTreatmentPresenter.newInstance(view, interactor);
  }

  public static DetailEffectPresenter getDetailEffectPresenter(DetailEffectView view) {
    DetailEffectInteractor interactor = new DetailEffectInteractorImpl();
    return DetailEffectPresenter.newInstance(view, interactor);
  }
}
