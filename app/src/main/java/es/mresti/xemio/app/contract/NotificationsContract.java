package es.mresti.xemio.app.contract;

import com.firebase.client.Firebase;

public interface NotificationsContract {
  interface View extends BaseContract.BaseView {
  }

  interface UserActionsListener extends BaseContract.BaseActions {
    Firebase getNotificationListRef();
  }
}
