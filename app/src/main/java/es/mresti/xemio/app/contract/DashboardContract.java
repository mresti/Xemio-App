package es.mresti.xemio.app.contract;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface DashboardContract {

  interface View extends BaseContract.BaseView {
    void openMain();
  }

  interface UserActionsListener {
    void getUserStatus();

    void getUserLogout();
  }
}
