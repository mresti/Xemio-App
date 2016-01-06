package es.mresti.xemio.app.contract;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface InfoContract {

  interface View extends BaseContract.BaseView {

    void showFABNext();

    void showFABEnd();

    void showFABInit();
  }

  interface UserActionsListener {
  }
}
