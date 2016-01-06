package es.mresti.xemio.app.contract;

import com.firebase.client.Firebase;

public interface NotificationListContract {
  interface View extends BaseContract.BaseView {
  }

  interface UserActionsListener {
    Firebase getNotificationListRef();
  }
}
