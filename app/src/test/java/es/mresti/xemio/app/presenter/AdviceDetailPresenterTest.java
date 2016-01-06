package es.mresti.xemio.app.presenter;

import com.firebase.client.Firebase;
import es.mresti.xemio.app.contract.AdviceDetailContract;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class AdviceDetailPresenterTest {

  //@Mock private Firebase mFirebase;
  //
  //@Mock private AdviceDetailContract.View mAdviceDetailView;
  //
  //private AdviceDetailPresenter mAdviceDetailPresenter;
  //
  //@Before public void setupAdviceDetailPresenter() {
  //  // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
  //  // inject the mocks in the test the initMocks method needs to be called.
  //  MockitoAnnotations.initMocks(this);
  //
  //  // Get a reference to the class under test
  //  mAdviceDetailPresenter = new AdviceDetailPresenter(mAdviceDetailView);
  //}
  //
  //@Test public void getAdviceRef_Firebase() {
  //  Firebase firebase = mAdviceDetailPresenter.getAdviceRef("myKey", "Some description");
  //
  //  when(firebase.getRef()).thenReturn(mFirebase);
  //}
  //
  //@Test public void saveKeyInHistorical_Firebase() {
  //  doNothing().when(mAdviceDetailPresenter).savedKeyInHistorical("myKey", "Some description");
  //}
}
