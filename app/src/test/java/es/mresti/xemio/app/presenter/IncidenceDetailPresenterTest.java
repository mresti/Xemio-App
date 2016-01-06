package es.mresti.xemio.app.presenter;

import com.firebase.client.Firebase;
import es.mresti.xemio.app.contract.IncidenceDetailContract;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class IncidenceDetailPresenterTest {

  //@Mock private Firebase mFirebase;
  //
  //@Mock private IncidenceDetailContract.View mIncidenceDetailView;
  //
  //private IncidenceDetailPresenter mIncidenceDetailPresenter;
  //
  //@Before public void setupIncidenceDetailPresenter() {
  //  // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
  //  // inject the mocks in the test the initMocks method needs to be called.
  //  MockitoAnnotations.initMocks(this);
  //
  //  // Get a reference to the class under test
  //  mIncidenceDetailPresenter = new IncidenceDetailPresenter(mIncidenceDetailView);
  //}
  //
  //@Test public void getIncidenceRef_Firebase() {
  //  Firebase firebase = mIncidenceDetailPresenter.getIncidenceRef("myKey");
  //
  //  when(firebase.getRef()).thenReturn(mFirebase);
  //}
  //
  //@Test public void removeIncidence_Firebase() {
  //  doNothing().when(mIncidenceDetailPresenter).removeIncidence("myKey");
  //}
}
