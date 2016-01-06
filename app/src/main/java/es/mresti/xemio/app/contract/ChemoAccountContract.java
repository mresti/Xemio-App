package es.mresti.xemio.app.contract;

import com.firebase.client.Firebase;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface ChemoAccountContract {

  interface View extends BaseContract.BaseView {
    void openDashboard();
  }

  interface UserActionsListener {
    Firebase getChemoRef();

    void setRegisterChemo(String key);
  }
}
