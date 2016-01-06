package es.mresti.xemio.app.presenter;

import com.firebase.client.Firebase;
import es.mresti.xemio.app.contract.ChatMessageContract;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class ChatPresenterTest {

  //@Mock private Firebase mFirebase;
  //
  //@Mock private ChatMessageContract.View mChatView;
  //
  //private ChatMessagePresenter mChatPresenter;
  //
  //@Before public void setupChatPresenter() {
  //  // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
  //  // inject the mocks in the test the initMocks method needs to be called.
  //  MockitoAnnotations.initMocks(this);
  //
  //  // Get a reference to the class under test
  //  mChatPresenter = new ChatMessagePresenter(mChatView);
  //}
  //
  //@Test public void getChatMessageListRef_Firebase() {
  //  Firebase firebase = mChatPresenter.getChatMessageListRef("myKey");
  //
  //  when(firebase.getRef()).thenReturn(mFirebase);
  //}
  //
  //@Test public void sendMessageChat_Firebase() {
  //  doNothing().when(mChatPresenter).sendMessageChat("message", "user", "myKey");
  //}
}
