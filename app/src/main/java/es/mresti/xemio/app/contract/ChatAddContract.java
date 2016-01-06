package es.mresti.xemio.app.contract;

import com.firebase.client.Firebase;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface ChatAddContract {

  interface View extends BaseContract.BaseView {
    void openChannel(String chatId);
  }

  interface UserActionsListener {
    Firebase getFoundationListRef();

    void addChat(String owner, String foundation, String key);
  }
}
