package es.mresti.xemio.app.presenter;

import android.content.Context;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import es.mresti.xemio.app.contract.ChatListContract;
import es.mresti.xemio.app.utils.Constants;

public class ChatListPresenter implements ChatListContract.UserActionsListener {

  private Firebase mFirebaseRef;
  private AuthData mAuthData;
  private Context mContext;
  private final ChatListContract.View mChannelsView;

  public ChatListPresenter(ChatListContract.View channelsView) {
    mChannelsView = channelsView;
    mFirebaseRef = new Firebase(Constants.FIREBASE_URL);
    mAuthData = mFirebaseRef.getAuth();
  }

  @Override public Firebase getChatListRef() {
    return mFirebaseRef.child(Constants.FIREBASE_NODE_CHANNEL).child(mAuthData.getUid());
  }
}
