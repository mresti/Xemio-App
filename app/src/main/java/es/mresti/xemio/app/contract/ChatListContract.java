package es.mresti.xemio.app.contract;

import com.firebase.client.Firebase;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface ChatListContract {

  interface View extends BaseContract.BaseView {

  }

  interface UserActionsListener {
    Firebase getChatListRef();
  }
}
