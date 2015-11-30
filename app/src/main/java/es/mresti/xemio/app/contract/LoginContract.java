package es.mresti.xemio.app.contract;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface LoginContract {

  interface View extends BaseContract.BaseView {

    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void openDashboard();

    void getBackApp();
  }

  interface UserActionsListener extends BaseContract.BaseActions {
    void validateCredentials(String username, String password);
  }
}
