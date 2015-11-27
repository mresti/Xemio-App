package es.mresti.xemio.app.contract;

import com.firebase.client.Firebase;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface ChemoContract {

  interface View extends BaseContract.BaseView {
    void openDashboard();
  }

  interface UserActionsListener extends BaseContract.BaseActions {

    Firebase getChemoRef();

    void setChemo(String key);
  }
}
