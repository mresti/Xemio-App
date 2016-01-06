package es.mresti.xemio.app.presenter;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import es.mresti.xemio.app.contract.NotificationListContract;
import es.mresti.xemio.app.utils.Constants;

public class NotificationListPresenter implements NotificationListContract.UserActionsListener {

  private Firebase mFirebaseRef;
  private AuthData mAuthData;
  private final NotificationListContract.View mNotificationsView;

  public NotificationListPresenter(NotificationListContract.View notificationsView) {
    mNotificationsView = notificationsView;
    mFirebaseRef = new Firebase(Constants.FIREBASE_URL);
    mAuthData = mFirebaseRef.getAuth();
  }

  @Override public Firebase getNotificationListRef() {
    return mFirebaseRef.child(Constants.FIREBASE_NODE_NOTIFICATION).child("-Jy4JKD7Lz7PoKKIEyvI");
  }
}
