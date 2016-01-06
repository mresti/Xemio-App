package es.mresti.xemio.app.presenter;

import com.firebase.client.Firebase;
import es.mresti.xemio.app.contract.ExtraAccountContract;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class ExtraAccountPresenterTest {

  //@Mock private Firebase mFirebase;
  //
  //@Mock private ExtraAccountContract.View mExtraAccountView;
  //
  //private ExtraAccountPresenter mExtraAccountPresenter;
  //
  //@Before public void setupExtraAccountPresenter() {
  //  // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
  //  // inject the mocks in the test the initMocks method needs to be called.
  //  MockitoAnnotations.initMocks(this);
  //
  //  // Get a reference to the class under test
  //  mExtraAccountPresenter = new ExtraAccountPresenter(mExtraAccountView);
  //}
  //
  //@Test public void setRegisterExtraToFirebase_showsSuccessMessageUi() {
  //  mExtraAccountPresenter.setRegisterExtra("name", "12");
  //  verify(mExtraAccountView).openChemo();
  //}
  //
  //@Test public void setRegisterExtraToFirebase_emptyNameShowsErrorUi() {
  //  mExtraAccountPresenter.setRegisterExtra("", "12");
  //  verify(mExtraAccountView).setUsernameError();
  //}
  //
  //@Test public void setRegisterExtraToFirebase_emptyAgeShowsErrorUi() {
  //  mExtraAccountPresenter.setRegisterExtra("name", "");
  //  verify(mExtraAccountView).setAgeError();
  //}
}
