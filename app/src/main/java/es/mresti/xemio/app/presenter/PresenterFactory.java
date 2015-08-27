package es.mresti.xemio.app.presenter;

import es.mresti.xemio.app.interactor.ChemoInteractor;
import es.mresti.xemio.app.interactor.ChemoInteractorImpl;
import es.mresti.xemio.app.interactor.DashboardInteractor;
import es.mresti.xemio.app.interactor.DashboardInteractorImpl;
import es.mresti.xemio.app.interactor.ExtraInteractor;
import es.mresti.xemio.app.interactor.ExtraInteractorImpl;
import es.mresti.xemio.app.interactor.LoginInteractor;
import es.mresti.xemio.app.interactor.LoginInteractorImpl;
import es.mresti.xemio.app.interactor.LogupInteractor;
import es.mresti.xemio.app.interactor.LogupInteractorImpl;
import es.mresti.xemio.app.interactor.MainInteractor;
import es.mresti.xemio.app.interactor.MainInteractorImpl;
import es.mresti.xemio.app.interactor.RegisterInteractor;
import es.mresti.xemio.app.interactor.RegisterInteractorImpl;
import es.mresti.xemio.app.view.ChemoView;
import es.mresti.xemio.app.view.DashboardView;
import es.mresti.xemio.app.view.ExtraView;
import es.mresti.xemio.app.view.LoginView;
import es.mresti.xemio.app.view.LogupView;
import es.mresti.xemio.app.view.MainView;
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
}
