package es.mresti.xemio.app.contract;

import com.firebase.client.Firebase;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface IncidencesContract {

  interface View extends BaseContract.BaseView {
  }

  interface UserActionsListener extends BaseContract.BaseActions {
    Firebase getIncidenceListRef();
  }
}
