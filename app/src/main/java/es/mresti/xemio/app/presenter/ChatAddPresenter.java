package es.mresti.xemio.app.presenter;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import es.mresti.xemio.app.contract.ChatAddContract;
import es.mresti.xemio.app.model.Channel;
import es.mresti.xemio.app.utils.Constants;

public class ChatAddPresenter implements ChatAddContract.UserActionsListener {

  private Firebase mFirebaseRef;
  private AuthData mAuthData;
  private final ChatAddContract.View mAddChannelView;

  public ChatAddPresenter(ChatAddContract.View addChannelView) {
    mAddChannelView = addChannelView;
    mFirebaseRef = new Firebase(Constants.FIREBASE_URL);
    mAuthData = mFirebaseRef.getAuth();
  }

  @Override public Firebase getFoundationListRef() {
    return mFirebaseRef.child(Constants.FIREBASE_NODE_FOUNDATION);
  }

  @Override public void addChat(String owner, String foundation, String key) {
    Firebase newListRef = mFirebaseRef.child(Constants.FIREBASE_NODE_CHAT).push();
    final String chatId = newListRef.getKey();

    Firebase inciUserRef =
        mFirebaseRef.child(Constants.FIREBASE_NODE_CHANNEL).child(mAuthData.getUid());
    Firebase item = inciUserRef.push();
    Channel ala = new Channel(owner, foundation, chatId);
    item.setValue(ala);

    Firebase inciUserRef2 = mFirebaseRef.child(Constants.FIREBASE_NODE_CHANNEL).child(key);
    Firebase item2 = inciUserRef2.push();
    item2.setValue(ala);

    this.onSuccess(chatId);
  }

  private void onSuccess(String chatId) {
    mAddChannelView.openChannel(chatId);
  }
}
