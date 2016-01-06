package es.mresti.xemio.app.presenter;

import com.firebase.client.Firebase;
import es.mresti.xemio.app.contract.ChemoAccountContract;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ChemoAccountPresenterTest {

  //@Mock private Firebase mFirebase;
  //
  //@Mock private ChemoAccountContract.View mChemoAccountView;
  //
  //private ChemoAccountPresenter mChemoAccountPresenter;
  //
  //@Before public void setupChemoAccountPresenter() {
  //  // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
  //  // inject the mocks in the test the initMocks method needs to be called.
  //  MockitoAnnotations.initMocks(this);
  //
  //  // Get a reference to the class under test
  //  mChemoAccountPresenter = new ChemoAccountPresenter(mChemoAccountView);
  //}
  //
  //@Test public void getChemoRef_Firebase() {
  //  Firebase firebase = mChemoAccountPresenter.getChemoRef();
  //
  //  when(firebase.getRef()).thenReturn(mFirebase);
  //}
  //
  //@Test public void setRegisterChemo_showsSuccessMessageUi() {
  //  mChemoAccountPresenter.setRegisterChemo("myKey");
  //
  //  verify(mChemoAccountView).openDashboard();
  //}
}
