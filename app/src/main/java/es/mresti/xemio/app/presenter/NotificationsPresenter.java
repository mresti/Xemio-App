package es.mresti.xemio.app.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import com.firebase.client.Firebase;
import es.mresti.xemio.R;
import es.mresti.xemio.app.contract.NotificationsContract;

public class NotificationsPresenter implements NotificationsContract.UserActionsListener {

  private Firebase mFirebaseRef;
  private Context mContext;
  private final NotificationsContract.View mNotificationsView;

  public NotificationsPresenter(@NonNull NotificationsContract.View notificationsView) {
    mNotificationsView = notificationsView;
  }

  @Override public void initializeActions(Context c) {
    mContext = c;
    mFirebaseRef = new Firebase(mContext.getResources().getString(R.string.firebase_url));
  }

  @Override public Firebase getNotificationListRef() {
    return mFirebaseRef.child("notifications").child("-Jy4JKD7Lz7PoKKIEyvI");
  }

}
