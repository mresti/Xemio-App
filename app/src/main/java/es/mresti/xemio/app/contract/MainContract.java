package es.mresti.xemio.app.contract;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface MainContract {

  interface View extends BaseContract.BaseView {
    void showProgress();

    void hideProgress();

    void openRegister();

    void openDashboard();

    void closeApp();
  }

  interface UserActionsListener {
    void getUserStatus();
  }
}
