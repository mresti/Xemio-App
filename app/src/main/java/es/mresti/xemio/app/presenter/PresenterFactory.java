package es.mresti.xemio.app.presenter;

import es.mresti.xemio.app.interactor.ChemoInteractor;
import es.mresti.xemio.app.interactor.ChemoInteractorImpl;
import es.mresti.xemio.app.interactor.DashboardInteractor;
import es.mresti.xemio.app.interactor.DashboardInteractorImpl;
import es.mresti.xemio.app.interactor.DetailEffectInteractor;
import es.mresti.xemio.app.interactor.DetailEffectInteractorImpl;
import es.mresti.xemio.app.interactor.DetailIncidenceInteractor;
import es.mresti.xemio.app.interactor.DetailIncidenceInteractorImpl;
import es.mresti.xemio.app.interactor.DetailTreatmentInteractor;
import es.mresti.xemio.app.interactor.DetailTreatmentInteractorImpl;
import es.mresti.xemio.app.interactor.ExtraInteractor;
import es.mresti.xemio.app.interactor.ExtraInteractorImpl;
import es.mresti.xemio.app.interactor.ListEffectsInteractor;
import es.mresti.xemio.app.interactor.ListEffectsInteractorImpl;
import es.mresti.xemio.app.interactor.ListIncidencesInteractor;
import es.mresti.xemio.app.interactor.ListIncidencesInteractorImpl;
import es.mresti.xemio.app.interactor.ListTreatmentsInteractor;
import es.mresti.xemio.app.interactor.ListTreatmentsInteractorImpl;
import es.mresti.xemio.app.interactor.LoginInteractor;
import es.mresti.xemio.app.interactor.LoginInteractorImpl;
import es.mresti.xemio.app.interactor.LogupInteractor;
import es.mresti.xemio.app.interactor.LogupInteractorImpl;
import es.mresti.xemio.app.interactor.MainInteractor;
import es.mresti.xemio.app.interactor.MainInteractorImpl;
import es.mresti.xemio.app.interactor.NewIncidenceInteractor;
import es.mresti.xemio.app.interactor.NewIncidenceInteractorImpl;
import es.mresti.xemio.app.interactor.RegisterInteractor;
import es.mresti.xemio.app.interactor.RegisterInteractorImpl;
import es.mresti.xemio.app.view.ChemoView;
import es.mresti.xemio.app.view.DashboardView;
import es.mresti.xemio.app.view.DetailEffectView;
import es.mresti.xemio.app.view.DetailIncidenceView;
import es.mresti.xemio.app.view.DetailTreatmentView;
import es.mresti.xemio.app.view.ExtraView;
import es.mresti.xemio.app.view.ListEffectView;
import es.mresti.xemio.app.view.ListIncidencesView;
import es.mresti.xemio.app.view.ListTreatmentView;
import es.mresti.xemio.app.view.LoginView;
import es.mresti.xemio.app.view.LogupView;
import es.mresti.xemio.app.view.MainView;
import es.mresti.xemio.app.view.NewIncidenceView;
import es.mresti.xemio.app.view.RegisterView;

public class PresenterFactory {
  public static MainPresenter getMainPresenter(MainView view) {
    MainInteractor interactor = new MainInteractorImpl();
    return MainPresenter.newInstance(view, interactor);
  }

  public static RegisterPresenter getRegisterPresenter(RegisterView view) {
    RegisterInteractor interactor = new RegisterInteractorImpl();
    return RegisterPresenter.newInstance(view, interactor);
  }

  public static LoginPresenter getLoginPresenter(LoginView view) {
    LoginInteractor interactor = new LoginInteractorImpl();
    return LoginPresenter.newInstance(view, interactor);
  }

  public static LogupPresenter getLogupPresenter(LogupView view) {
    LogupInteractor interactor = new LogupInteractorImpl();
    return LogupPresenter.newInstance(view, interactor);
  }

  public static ExtraPresenter getExtraPresenter(ExtraView view) {
    ExtraInteractor interactor = new ExtraInteractorImpl();
    return ExtraPresenter.newInstance(view, interactor);
  }

  public static ChemoPresenter getChemoPresenter(ChemoView view) {
    ChemoInteractor interactor = new ChemoInteractorImpl();
    return ChemoPresenter.newInstance(view, interactor);
  }

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

  public static ListIncidencesPresenter getListIncidencesPresenter(ListIncidencesView view) {
    ListIncidencesInteractor interactor = new ListIncidencesInteractorImpl();
    return ListIncidencesPresenter.newInstance(view, interactor);
  }

  public static ListTreatmentsPresenter getListTreatmentPresenter(ListTreatmentView view) {
    ListTreatmentsInteractor interactor = new ListTreatmentsInteractorImpl();
    return ListTreatmentsPresenter.newInstance(view, interactor);
  }

  public static ListEffectsPresenter getListEffectsPresenter(ListEffectView view) {
    ListEffectsInteractor interactor = new ListEffectsInteractorImpl();
    return ListEffectsPresenter.newInstance(view, interactor);
  }

  public static DetailEffectPresenter getDetailEffectPresenter(DetailEffectView view) {
    DetailEffectInteractor interactor = new DetailEffectInteractorImpl();
    return DetailEffectPresenter.newInstance(view, interactor);
  }
}
