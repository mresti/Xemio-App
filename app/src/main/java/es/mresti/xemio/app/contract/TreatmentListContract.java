package es.mresti.xemio.app.contract;

import com.firebase.client.Firebase;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface TreatmentListContract {

  interface View extends BaseContract.BaseView {
  }

  interface UserActionsListener {
    Firebase getTreatmentListRef();
  }
}
