package es.mresti.xemio.app.presenter;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import es.mresti.xemio.app.contract.ChatMessageContract;
import es.mresti.xemio.app.model.Chat;
import es.mresti.xemio.app.utils.Constants;

public class ChatMessagePresenter implements ChatMessageContract.UserActionsListener {

  private Firebase mFirebaseRef;
  private AuthData mAuthData;
  private final ChatMessageContract.View mRoomView;

  public ChatMessagePresenter(ChatMessageContract.View roomView) {
    mRoomView = roomView;
    mFirebaseRef = new Firebase(Constants.FIREBASE_URL);
    mAuthData = mFirebaseRef.getAuth();
  }

  @Override public Firebase getChatMessageListRef(String key) {
    return mFirebaseRef.child(Constants.FIREBASE_NODE_CHAT).child(key);
  }

  @Override public void sendMessageChat(String input, String username, String key) {
    Chat message = new Chat(input, username);
    mFirebaseRef.child(Constants.FIREBASE_NODE_CHAT).child(key).push().setValue(message);
  }
}
