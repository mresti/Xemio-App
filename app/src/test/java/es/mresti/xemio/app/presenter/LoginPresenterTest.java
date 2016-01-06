package es.mresti.xemio.app.presenter;

import com.firebase.client.Firebase;
import es.mresti.xemio.app.contract.LoginContract;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class LoginPresenterTest {

  //@Mock private Firebase mFirebase;
  //
  //@Mock private LoginContract.View mLoginView;
  //
  //private LoginPresenter mLoginPresenter;
  //
  //@Before public void setupLoginPresenter() {
  //  // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
  //  // inject the mocks in the test the initMocks method needs to be called.
  //  MockitoAnnotations.initMocks(this);
  //
  //  // Get a reference to the class under test
  //  mLoginPresenter = new LoginPresenter(mLoginView);
  //}
  //
  //@Test public void validateCredentials_showsSuccessMessageUi() {
  //  mLoginPresenter.validateCredentials("name@domain.com", "pass1");
  //
  //  verify(mLoginView).openDashboard();
  //}
  //
  //@Test public void validateCredentials_emptyEmailShowsErrorUi() {
  //  mLoginPresenter.validateCredentials("", "pass1");
  //
  //  verify(mLoginView).setUsernameError();
  //}
  //
  //@Test public void validateCredentials_emptyPassShowsErrorUi() {
  //  mLoginPresenter.validateCredentials("name@domain.com", "");
  //
  //  verify(mLoginView).setPasswordError();
  //}
}
