package es.mresti.xemio.app.contract;

import com.firebase.client.Firebase;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface HistoricalDetailContract {

  interface View extends BaseContract.BaseView {

  }

  interface UserActionsListener {
    Firebase getHistoricalRef(String key);
  }
}
