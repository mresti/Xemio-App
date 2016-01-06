package es.mresti.xemio.app.presenter;

import com.firebase.client.Firebase;
import es.mresti.xemio.app.contract.IncidenceAddContract;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class IncidenceAddPresenterTest {

  //@Mock private Firebase mFirebase;
  //
  //@Mock private IncidenceAddContract.View mAddIncidenceView;
  //
  //private IncidenceAddPresenter mIncidenceAddPresenter;
  //
  //@Before public void setupIncidenceAddPresenter() {
  //  // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
  //  // inject the mocks in the test the initMocks method needs to be called.
  //  MockitoAnnotations.initMocks(this);
  //
  //  // Get a reference to the class under test
  //  mIncidenceAddPresenter = new IncidenceAddPresenter(mAddIncidenceView);
  //}
  //
  //@Test public void saveIncidenceToFirebase_showsSuccessMessageUi() {
  //  mIncidenceAddPresenter.addIncidence("Incidence Subject", "Incidence Description");
  //
  //  verify(mAddIncidenceView).showNotificationCreated(); // shown in the UI
  //}
  //
  //@Test public void saveIncidenceToFirebase_emptyIncidenceShowsErrorUi() {
  //  mIncidenceAddPresenter.addIncidence("", "Incidence Description");
  //
  //  verify(mAddIncidenceView).setSubjectError();
  //}
}