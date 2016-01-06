package es.mresti.xemio.app.contract;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface CreateAccountContract {

  interface View extends BaseContract.BaseView {
    void showProgress();

    void hideProgress();

    void setEmailError();

    void setPass1Error();

    void setPass2Error();

    void setPassDistinctError();

    void openExtra();

    void getBackApp();

    void showNotificationMessage(String message);
  }

  interface UserActionsListener {
    void setRegister(String email, String pass1, String pass2);
  }
}
