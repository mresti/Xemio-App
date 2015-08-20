package es.mresti.xemio.app.presenter;

import es.mresti.xemio.app.interactor.CancerInteractor;
import es.mresti.xemio.app.interactor.CancerInteractorImpl;
import es.mresti.xemio.app.interactor.ChemoInteractor;
import es.mresti.xemio.app.interactor.ChemoInteractorImpl;
import es.mresti.xemio.app.interactor.LoginInteractor;
import es.mresti.xemio.app.interactor.LoginInteractorImpl;
import es.mresti.xemio.app.interactor.LogupInteractor;
import es.mresti.xemio.app.interactor.LogupInteractorImpl;
import es.mresti.xemio.app.interactor.MainInteractor;
import es.mresti.xemio.app.interactor.MainInteractorImpl;
import es.mresti.xemio.app.interactor.PassInteractor;
import es.mresti.xemio.app.interactor.PassInteractorImpl;
import es.mresti.xemio.app.interactor.VerifyInteractor;
import es.mresti.xemio.app.interactor.VerifyInteractorImpl;
import es.mresti.xemio.app.view.CancerView;
import es.mresti.xemio.app.view.ChemoView;
import es.mresti.xemio.app.view.LoginView;
import es.mresti.xemio.app.view.LogupView;
import es.mresti.xemio.app.view.MainView;
import es.mresti.xemio.app.view.PassView;
import es.mresti.xemio.app.view.VerifyView;

public class PresenterFactory {
  public static MainPresenter getMainPresenter(MainView view) {
    MainInteractor interactor = new MainInteractorImpl();
    return MainPresenter.newInstance(view, interactor);
  }

  public static LoginPresenter getLoginPresenter(LoginView view) {
    LoginInteractor interactor = new LoginInteractorImpl();
    return LoginPresenter.newInstance(view, interactor);
  }

  public static LogupPresenter getLogupPresenter(LogupView view) {
    LogupInteractor interactor = new LogupInteractorImpl();
    return LogupPresenter.newInstance(view, interactor);
  }

  public static VerifyPresenter getVerifyPresenter(VerifyView view) {
    VerifyInteractor interactor = new VerifyInteractorImpl();
    return VerifyPresenter.newInstance(view, interactor);
  }

  public static CancerPresenter getCancerPresenter(CancerView view) {
    CancerInteractor interactor = new CancerInteractorImpl();
    return CancerPresenter.newInstance(view, interactor);
  }

  public static ChemoPresenter getChemoPresenter(ChemoView view) {
    ChemoInteractor interactor = new ChemoInteractorImpl();
    return ChemoPresenter.newInstance(view, interactor);
  }

  public static PassPresenter getPassPresenter(PassView view) {
    PassInteractor interactor = new PassInteractorImpl();
    return PassPresenter.newInstance(view, interactor);
  }
}
