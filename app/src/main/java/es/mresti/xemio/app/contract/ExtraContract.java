package es.mresti.xemio.app.contract;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface ExtraContract {

  interface View extends BaseContract.BaseView {

    void showProgress();

    void hideProgress();

    void openChemo();

    void setUsernameError();

    void setAgeError();
  }

  interface UserActionsListener extends BaseContract.BaseActions {
    void setRegister(String username, String age);
  }
}
