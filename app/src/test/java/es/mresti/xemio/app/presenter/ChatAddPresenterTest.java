package es.mresti.xemio.app.presenter;

import com.firebase.client.Firebase;
import es.mresti.xemio.app.contract.ChatAddContract;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ChatAddPresenterTest {

  //@Mock private Firebase mFirebase;
  //
  //@Mock private ChatAddContract.View mChatAddView;
  //
  //private ChatAddPresenter mChatAddPresenter;
  //
  //@Before public void setupChatAddPresenter() {
  //  // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
  //  // inject the mocks in the test the initMocks method needs to be called.
  //  MockitoAnnotations.initMocks(this);
  //
  //  // Get a reference to the class under test
  //  mChatAddPresenter = new ChatAddPresenter(mChatAddView);
  //}
  //
  //@Test public void getFoundationListRef_Firebase() {
  //  Firebase firebase = mChatAddPresenter.getFoundationListRef();
  //
  //  when(firebase.getRef()).thenReturn(mFirebase);
  //}
  //
  //@Test public void addChat_showsSuccessMessageUi() {
  //  mChatAddPresenter.addChat("pacient", "foundation", "myKey");
  //
  //  verify(mChatAddView).openChannel("myKey");
  //}
}
