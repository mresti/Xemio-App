package es.mresti.xemio.app.contract;

import android.content.Context;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface RegisterContract {

  interface View extends BaseContract.BaseView {

    void openLogin();

    void openLogup();

    void closeApp();
  }

  interface UserActionsListener {
    void initializeActions(Context c);
  }
}
