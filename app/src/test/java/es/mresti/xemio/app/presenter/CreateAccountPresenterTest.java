package es.mresti.xemio.app.presenter;

import com.firebase.client.Firebase;
import es.mresti.xemio.app.contract.CreateAccountContract;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class CreateAccountPresenterTest {

  //@Mock private Firebase mFirebase;
  //
  //@Mock private CreateAccountContract.View mCreateAccountView;
  //
  //private CreateAccountPresenter mCreateAccountPresenter;
  //
  //@Before public void setupCreateAccountPresenter() {
  //  // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
  //  // inject the mocks in the test the initMocks method needs to be called.
  //  MockitoAnnotations.initMocks(this);
  //
  //  // Get a reference to the class under test
  //  mCreateAccountPresenter = new CreateAccountPresenter(mCreateAccountView);
  //}
  //
  //@Test public void setRegister_showsSuccessMessageUi() {
  //  mCreateAccountPresenter.setRegister("name@domain.com", "pass1", "pass1");
  //  verify(mCreateAccountView).openExtra();
  //}
  //
  //@Test public void setRegister_emptyEmailShowsErrorUi() {
  //  mCreateAccountPresenter.setRegister("", "pass1", "pass1");
  //  verify(mCreateAccountView).setEmailError();
  //}
  //
  //@Test public void setRegister_emptyPass1ShowsErrorUi() {
  //  mCreateAccountPresenter.setRegister("name@domain.com", "", "pass1");
  //  verify(mCreateAccountView).openExtra();
  //}
  //
  //@Test public void setRegister_emptyPass2ShowsErrorUi() {
  //  mCreateAccountPresenter.setRegister("name@domain.com", "pass1", "");
  //  verify(mCreateAccountView).openExtra();
  //}
  //
  //@Test public void setRegister_distinctLengthPassShowsErrorUi() {
  //  mCreateAccountPresenter.setRegister("name@domain.com", "pass", "pass1");
  //  verify(mCreateAccountView).openExtra();
  //}
  //
  //@Test public void setRegister_distinctPassShowsErrorUi() {
  //  mCreateAccountPresenter.setRegister("name@domain.com", "pass1", "pass2");
  //  verify(mCreateAccountView).openExtra();
  //}
}
